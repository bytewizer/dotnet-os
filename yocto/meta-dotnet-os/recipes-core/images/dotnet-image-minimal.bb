SUMMARY = "A minimal console-only runtime image for the Raspberry Pi devices"
HOMEPAGE = "https://www.raspberrypi.com/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

require recipes-core/images/core-image-minimal.bb

#inherit deviceos-users

# Additional installed packages
IMAGE_INSTALL += "packagegroup-core"
IMAGE_INSTALL:append = "\
	dotnet \
	vsdbg-dbg \
"