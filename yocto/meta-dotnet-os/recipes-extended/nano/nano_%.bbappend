DESCRIPTION = "Syntax highlighting for C# in nano editor."

FILESEXTRAPATHS:prepend := "${THISDIR}/files/:"

SRC_URI += "file://csharp.nanorc"

RDEPENDS:${PN} = "\
    nano \
"
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install:append() {
    mkdir -p ${D}${datadir}/nano/
    install -m 0644 ${WORKDIR}/csharp.nanorc ${D}${datadir}/nano/
}