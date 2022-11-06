SUMMARY = "A minimal console-only development image for the Raspberry Pi"
HOMEPAGE = "https://www.raspberrypi.com/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

require recipes-core/images/core-image-minimal.bb
inherit deviceos-users

# Extra image configuration defaults
EXTRA_IMAGE_FEATURES ?= "ssh-server-openssh"

# Software features shipped 
DISTRO_FEATURES:append = " wifi bluetooth"

# Additional installed packages
IMAGE_INSTALL += "packagegroup-core"

IMAGE_INSTALL:append = "\
	nano \
	curl \
	dotnet \
	vsdbg-dbg \
"

# Enable wic format for flashing to sdcard
IMAGE_FSTYPES = "wic"

#
# Set the size of root file system to 32GB
#
# IMAGE_ROOTFS_SIZE = "319488" 
# IMAGE_OVERHEAD_FACTOR = "1.1"
# IMAGE_ROOTFS_EXTRA_SPACE = "512"
# IMAGE_ROOTFS_MAXSIZE = "372736"

#IMAGE_ROOTFS_SIZE = "5120" 

# Remove debugging tweaks. This allows the root user to be passwordless.
# IMAGE_FEATURES:remove = " \
#     debug-tweaks \
# "
