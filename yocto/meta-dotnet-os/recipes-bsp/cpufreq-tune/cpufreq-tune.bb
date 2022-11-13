SUMMARY = "qml-forward-gallery autostart service"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit allarch features_check systemd

SRC_URI = "file://${BPN}.service"

SYSTEMD_SERVICE:${PN} = "${BPN}.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"
RDEPENDS:${PN} += "cpupower"

REQUIRED_DISTRO_FEATURES = "systemd"

FILES:${PN} += "${systemd_unitdir}/system"

# Depending on cpufreq driver and kernel settings some configuration might be available:
# conservative, ondemand, userspace, powersave, performance, schedutil

CPUPOWER_GOVERNOR ??= "performance"

do_compile() {
	 
	 sed -e 's#@@CPUPOWER_GOVERNOR@@#${CPUPOWER_GOVERNOR}#g' \
         "${WORKDIR}/${BPN}.service" > "${WORKDIR}/${BPN}.service"

}

do_install() {
	
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/${BPN}.service ${D}${systemd_unitdir}/system/

}