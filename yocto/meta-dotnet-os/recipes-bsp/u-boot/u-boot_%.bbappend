FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

UBOOT_NO_DELAY ?= "1"

SRC_URI += "${@bb.utils.contains('UBOOT_NO_DELAY', '1', 'file://no-boot-delay.cfg', '', d)}"