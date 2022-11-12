SUMMARY = "A minimal console-only development image for the Raspberry Pi devices"
HOMEPAGE = "https://www.raspberrypi.com/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

require recipes-core/images/core-image-minimal.bb

# inherit os-users

# Default packages to exclude
PACKAGE_EXCLUDE = "ifupdown"

# Additional installed packages
IMAGE_INSTALL += " \
	kernel-modules \
	linux-firmware-bcm43430 \
	linux-firmware-bcm43455 \
	bluez5 \
	iptables \
	iw \
	hostapd \
	dnsmasq \
	openssh \ 
	openssh-sftp-server \
	openssl \
	nano \
	sudo \
	usbutils \
	i2c-tools \
	libgpiod \
	libgpiod-dev \
	libgpiod-tools \
	curl \
"