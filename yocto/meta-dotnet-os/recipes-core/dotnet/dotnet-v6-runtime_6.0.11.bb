DESCRIPTION = ".NET Core 6.0 Runtime (v6.0.11) - Linux x64 Binaries"
HOMEPAGE = "https://dotnet.microsoft.com/en-us/download/dotnet/6.0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_FETCH_ID = "b02be36b-8470-4b81-8254-1f957ce8f397/fd6aa0da17fc51c1b57b2d96aa792c1a"

SRC_URI[sha256sum] = "526dfd1ba17ff880c7fc575af6792f01d19b6fb9f98253e673752430d15bc71a"
SRC_URI = "https://download.visualstudio.microsoft.com/download/pr/${SRC_FETCH_ID}/dotnet-runtime-${PV}-linux-arm64.tar.gz;unpack=0"

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

INSANE_SKIP:${PN} = "already-stripped libdir"