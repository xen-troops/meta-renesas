DESCRIPTION = "OSS packages for development & testing"

LICENSE = "BSD-3-Clause & GPLv2+ & LGPLv2+"

inherit packagegroup

PACKAGES = " \
    packagegroup-oss \
    packagegroup-bsp-devpkg \
    packagegroup-bsp-testpkg \
    packagegroup-bsp-python3 \
    packagegroup-bsp-utest \
"

RDEPENDS:packagegroup-oss = " \
    packagegroup-bsp-devpkg \
    packagegroup-bsp-testpkg \
    packagegroup-bsp-python3 \
    packagegroup-bsp-utest \
"

# OSS packages for development
RDEPENDS:packagegroup-bsp-devpkg = " \
    cmake \
    g++ \
    gcc \
    git \
    git-perltools \
    make \
    atop \
    curl \
    devmem2 \
    gdb \
    gdbserver \
    iperf3 \
    iproute2 \
    iproute2-tc \
    linuxptp \
    nano \
    openssh \
    openssh-sftp \
    openssh-sftp-server \
    opkg \
    perf \
    procps \
    strace \
    vim \
    wget \
    e2fsprogs-resize2fs \
    avahi-daemon \
    libdrm-tests \
    libgpiod libgpiod-tools \
    alsa-utils \
"
# Remove strace in due to compile error with Kernel v5.10
RDEPENDS:packagegroup-bsp-devpkg:remove = "strace"

# Various packages needed for testing
RDEPENDS:packagegroup-bsp-testpkg = " \
    bonnie++ \
    can-utils \
    e2fsprogs \
    e2fsprogs-tune2fs \
    eglibc-utils \
    ethtool \
    ldd \
    libpcap \
    libsocketcan \
    lmbench \
    mtd-utils \
    pciutils \
    rsync \
    subversion \
    usbutils \
    util-linux \
    dbench \
    dhrystone \
    ${@bb.utils.contains("LICENSE_FLAGS_WHITELIST", "non-commercial", "netperf", "", d)} \
    whetstone \
    fio \
"

# Python3 packages requested by Renesas
RDEPENDS:packagegroup-bsp-python3 = " \
    python3-dbus \
    python3-nose \
    python3-numpy \
    python3-pygobject \
    python3-pyyaml \
    python3-setuptools \
    python3-pip \
"

# Utest (IMR, IMP, etc demos) related packages
RDEPENDS:packagegroup-bsp-utest = " \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-base-app \
    libdrm \
    libinput \
    libgstallocators-1.0 \
    libgstapp-1.0 \
    libyaml \
    libfftw \
"
