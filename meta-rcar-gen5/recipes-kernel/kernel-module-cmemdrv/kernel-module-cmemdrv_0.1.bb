SUMMARY = "Cache Memory Primitive Module"
LICENSE = "GPLv2 & MIT"
LIC_FILES_CHKSUM = " \
    file://${S}/GPL-COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://${S}/MIT-COPYING;md5=fea016ce2bdf2ec10080f69e9381d378 \
"

inherit module

PR = "r0"
PV = "0.1"

RENESAS_CMEM_URL ?= "git://github.com/renesas-rcar/cmem.git;protocol=https"
SRC_URI = "${RENESAS_CMEM_URL};nobranch=1"

SRCREV:rcar-gen5 = "6c187a3b58adad920a4fe2a194b5ad5406be9524"

S = "${WORKDIR}/git"

do_install:append () {
    install -d ${D}${includedir}/linux
    install -m 644 ${S}/cmemdrv.h ${D}${includedir}/linux/
}

KERNEL_MODULE_AUTOLOAD += "cmemdrv"
KERNEL_MODULE_PROBECONF += "cmemdrv"
module_conf_cmemdrv = "options cmemdrv bsize=0x20000000"
