SUMMARY = "A simple Hello Yocto program using Makefile"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello_makefile.c \
           file://Makefile"

S = "${WORKDIR}"

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 hello_makefile ${D}${bindir}
}