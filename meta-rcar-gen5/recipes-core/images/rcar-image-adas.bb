SUMMARY = "An image with support for ADAS applications."

require recipes-core/images/rcar-image-minimal.bb

# Handle extra features
RENESAS_EXTRA_IMAGE_FEATURES = " \
    debug-tweaks \
    dev-pkgs \
    tools-sdk \
    tools-profile \
    tools-debug \
    eclipse-debug \
    ssh-server-openssh \
"

EXTRA_IMAGE_FEATURES += " \
    ${RENESAS_EXTRA_IMAGE_FEATURES} \
"

# Do not install debug packages, it reduces SDK size
RENESAS_REMOVED_SDKIMAGE_FEATURES = "dbg-pkgs"

SDKIMAGE_FEATURES:remove = " \
    ${RENESAS_REMOVED_SDKIMAGE_FEATURES} \
"

IMAGE_INSTALL:append = " \
    packagegroup-renesas \
    packagegroup-oss \
    packagegroup-opencv-sdk \
    kernel-image \
    kernel-devicetree \
    kernel-modules \
"

