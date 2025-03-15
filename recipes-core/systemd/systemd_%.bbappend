FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://timesyncd.conf \
	"

do_install:append() {
    install -D -m 0644 ${WORKDIR}/timesyncd.conf ${D}${sysconfdir}/systemd/timesyncd.conf

    rm -rf  ${D}${systemd_system_unitdir}/getty.target.wants/getty@tty1.service
}
