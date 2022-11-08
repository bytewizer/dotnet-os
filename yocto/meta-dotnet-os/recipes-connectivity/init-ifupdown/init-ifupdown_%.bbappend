FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://interfaces-router"

do_configure:append() {
    install -d ${D}/etc/network
    install -m 0644 ${WORKDIR}/interfaces-router ${WORKDIR}/interfaces
}
