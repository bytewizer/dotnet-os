DESCRIPTION = "This is the ssh server configuration file."

FILESEXTRAPATHS:prepend := "${THISDIR}/files/:"

SRC_URI += "file://sshd_config"

RDEPENDS:${PN} = "\
    openssh \
"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_compile:append() {
    mkdir -p ${D}${sysconfdir}/ssh/
    install -m 0644 ${WORKDIR}/sshd_config ${D}${sysconfdir}/ssh/
}
