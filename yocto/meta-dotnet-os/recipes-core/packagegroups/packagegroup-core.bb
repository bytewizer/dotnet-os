DESCRIPTION = "dotnet-os core package group"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# Additional installed packages
CORE_OS = "\
	kernel-modules \
	linux-firmware-bcm43430 \
	linux-firmware-bcm43455 \
	bluez5 \
	openssh \ 
	openssh-sftp-server \
	openssl \
	sudo \
	iptables \
"

HARDWARE_TOOLS = "\
	usbutils \
	can-utils \
	ethtool \
	libgpiod \
	libgpiod-dev \
	libgpiod-tools \
	i2c-tools \
"

WIFI_TOOLS = " \
	iw \
	wpa-supplicant \
"

RDEPENDS_${PN} = " \
  ${CORE_OS} \
  ${HARDWARE_TOOLS} \
  ${WIFI_TOOLS} \
"