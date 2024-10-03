DESCRIPTION = "QOS Interface test app for R-Car"

require qosif.inc

DEPENDS = "qosif-user-module"
PN = "qosif-tp-user-module"
PR = "r0"

S = "${WORKDIR}/git"
QOSIF_TP_DIR = "qos_if-tp-user/files/qos_if"

do_compile() {
    cd ${S}/${QOSIF_TP_DIR}
    oe_runmake
}

do_install() {
    # Create destination directory
    install -d ${D}${bindir}

    # Copy user test program
    install -m 755 ${S}/${QOSIF_TP_DIR}/qos_tp ${D}${bindir}/
}

PACKAGES = " \
    ${PN} \
    ${PN}-dbg \
"

FILES:${PN} = "${bindir}/qos_tp"

FILES:${PN}-dbg = " \
    ${bindir}/.debug/* \
"
