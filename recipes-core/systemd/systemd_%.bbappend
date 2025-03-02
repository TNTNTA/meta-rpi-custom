FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

do_install:append() {
    rm -f  ${D}${systemd_system_unitdir}/getty.target.wants/getty@tty1.service
}