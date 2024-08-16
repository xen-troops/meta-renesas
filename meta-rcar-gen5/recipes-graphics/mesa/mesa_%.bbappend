# These below libraries are provided by gles-user-module
PACKAGECONFIG:remove:rcar-gen5 = "egl gles"

do_install:append:rcar-gen5() {
    # Have to remove khrplatform.h file due to conflict with gles-user-module
    # even though libegl from mesa is removed
    rm -rf ${D}${includedir}/KHR
}

