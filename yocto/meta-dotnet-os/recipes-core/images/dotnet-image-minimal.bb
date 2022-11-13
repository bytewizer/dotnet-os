SUMMARY = "A minimal console-only runtime image for the Raspberry Pi devices"
HOMEPAGE = "https://www.raspberrypi.com/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

include recipes-core/images/core-image-minimal.bb

# Setup default user and passwords
inherit deviceos-users

CORE_IMAGE_EXTRA_INSTALL += "\
    roslynos-core-packagegroup \
    roslynos-base-packagegroup \
    aspnet-runtime \
"
# Disable root account
DISABLE_ROOT = "1"