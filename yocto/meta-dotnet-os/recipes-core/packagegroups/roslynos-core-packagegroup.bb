DESCRIPTION = "Core hardware application packagegroup"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} = "\
    kernel-modules \
    linux-firmware-rpidistro-bcm43430 \
    linux-firmware-rpidistro-bcm43455"