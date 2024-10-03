SUMMARY = "A small image just capable of allowing a device to boot."

require recipes-core/images/core-image-minimal.bb

COMPATIBLE_MACHINE = "x5h"

# Enable package manager
EXTRA_IMAGE_FEATURES += "package-management"

# Basic packages
IMAGE_INSTALL:append = " \
    bash \
    v4l-utils \
    i2c-tools \
    coreutils \
"

