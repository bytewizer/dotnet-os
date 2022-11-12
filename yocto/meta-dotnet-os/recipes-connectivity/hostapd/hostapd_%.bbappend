FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit systemd

SRC_URI += " \
   file://hostapd-ap0.conf \
   file://hostapd-ap0.service \
"

FILES:${PN} += " \
    ${sysconfdir} \
    ${systemd_system_unitdir} \
"

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "hostapd-ap0.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

REQUIRED_DISTRO_FEATURES = "systemd"

INITSCRIPT_PARAMS = "remove"

do_install:append () {
    
    install -d ${D}${sysconfdir}
    install -m 644 ${WORKDIR}/hostapd-ap0.conf ${D}${sysconfdir}/hostapd-ap0.conf

    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/hostapd-ap0.service ${D}${systemd_system_unitdir}

    # Remove hostapd.service
    rm -f ${D}${libdir}/systemd/system/hostapd.service
    rm -f ${D}${sysconfdir}/init.d/hostapd
}