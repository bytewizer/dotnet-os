DESCRIPTION = "Base application packagegroup"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = "\
    roslynos-base-packagegroup \
    roslynos-base-connectivity \
    roslynos-base-utilities"

RDEPENDS:${PN} = "\
    roslynos-base-connectivity \
    roslynos-base-utilities"

SUMMARY:roslynos-base-connectivity = "Connectivity utilities"
RDEPENDS:roslynos-base-connectivity = "\
	hostapd \
	dnsmasq \
	openssh \ 
	openssh-sftp-server \
	openssl \
	iptables \
    curl"

SUMMARY:roslynos-base-utilities = "General utilities"
RDEPENDS:roslynos-base-utilities = "\
    iw \
    nano \
	sudo \
	vsdbg \
	usbutils \
    libgpiod \
	libgpiod-tools \
	i2c-tools"