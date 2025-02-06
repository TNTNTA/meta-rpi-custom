SUMMARY = "A simple Hello Yocto program using AutoTools"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello_autotools.c \
           file://configure.ac \
           file://Makefile.am"

S = "${WORKDIR}"

inherit autotools

do_configure::prepend() {
    autoreconf -vi
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 hello_autotools ${D}${bindir}
}