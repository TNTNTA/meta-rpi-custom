SUMMARY = "Custom package group for Yocto"
DESCRIPTION = "A package group that includes all kind of hello demo bin."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} = "\
    makefile-demo \
    autotools-demo \
    cmake-demo \
"