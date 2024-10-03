DESCRIPTION = "QOS Interface library for R-Car"

require qosif.inc

DEPENDS = "kernel-module-qos"
PN = "qosif-user-module"
PR = "r0"

S = "${WORKDIR}/git"
QOSIF_LIB_DIR = "qos_if-module/files/qos_if"

EXTRA_OEMAKE = "ARCH=${TARGET_ARCH}"

do_compile() {
    # Build shared library
    cd ${S}/${QOSIF_LIB_DIR}/if
    rm -rf ${S}/${QOSIF_LIB_DIR}/if/libqos.so*
    oe_runmake
}

do_install() {
    # Create destination directories
    install -d ${D}/${libdir}
    install -d ${D}/${includedir}

    # Copy shared library
    install -m 755 ${S}/${QOSIF_LIB_DIR}/if/libqos.so* ${D}/${libdir}/
    cd ${D}/${libdir}/
    ln -sf libqos.so.1.0.0 libqos.so.1
    ln -sf libqos.so.1 libqos.so

    # Install shared header file
    install -m 644 ${S}/${QOSIF_LIB_DIR}/include/qos_public.h ${D}/${includedir}/
}

PACKAGES = " \
    ${PN} \
    ${PN}-dev \
    ${PN}-dbg \
"

FILES:${PN} = " \
    ${libdir}/libqos.so* \
"

FILES:${PN}-dev = " \
    ${includedir}/qos_public.h \
"

INSANE_SKIP:${PN} = "dev-so"
