DESCRIPTION = ".NET Core 7.0 Runtime (v7.0.0) - Linux x64 Binaries"
HOMEPAGE = "https://dotnet.microsoft.com/en-us/download/dotnet/6.0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DOTNET_FETCH_ID = "edc62d2f-5c2e-4085-a6d8-11ba9abb18f4/6ca82f155ed65e4c1335214d2d948c78"
ASPNET_FETCH_ID = "2d6d851a-4eea-4a7a-9d5e-f1d6cdccda29/366a3dd90251ce11d8c5191ae9633efc"

SRC_URI[sha256sum] = "f23e32f764f54a08cc721aff4ec4885ee805cd2a8757570cd9a418ecc87ff79b"
SRC_URI = "https://download.visualstudio.microsoft.com/download/pr/${DOTNET_FETCH_ID}/dotnet-runtime-${PV}-linux-arm64.tar.gz;unpack=0"

# https://download.visualstudio.microsoft.com/download/pr/${DOTNET_FETCH_ID}/aspnetcore-runtime-${PV}-linux-arm64.tar.gz


DEPENDS = "patchelf-native"

RDEPENDS:${PN} = "\
    icu \
    libgssapi-krb5 \
    openssl \
    zlib \
"

FILES:${PN} += "\
    ${datadir}/dotnet \
"
INSANE_SKIP:${PN} += "already-stripped libdir"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    
    install -d ${D}${datadir}/dotnet
    tar -xpvzf ${WORKDIR}/dotnet-runtime-${PV}-linux-arm64.tar.gz -C ${D}${datadir}/dotnet
    chmod +x ${D}${datadir}/dotnet/dotnet

    install -d ${D}${bindir}
    ln -rs ${D}${datadir}/dotnet/dotnet ${D}${bindir}/dotnet
    
    # Hack to fix liblttng-ust dependency issues
    patchelf --remove-needed liblttng-ust.so.0 ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App/${PV}/libcoreclrtraceptprovider.so
}