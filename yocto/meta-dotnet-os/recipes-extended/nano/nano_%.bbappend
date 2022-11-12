DESCRIPTION = "Syntax highlighting for C# in nano editor."

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://csharp.nanorc \
    file://nanorc \
"

do_install:append() {

    mkdir -p ${D}${datadir}/nano
    install -m 644 ${WORKDIR}/csharp.nanorc ${D}${datadir}/nano

    install -d ${D}${sysconfdir}
	install -m 644 ${WORKDIR}/nanorc ${D}${sysconfdir}
}