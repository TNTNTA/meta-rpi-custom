FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://10-eth0-static-vlan.network \
	file://20-eth0-vlan.104.netdev \
	file://30-eth0-vlan.104.network \
	file://40-wlan0.network \
	"

do_install:append() {
    install -d ${D}${systemd_unitdir}/network
    install -D -m 0644 ${WORKDIR}/10-eth0-static-vlan.network 	${D}${systemd_unitdir}/network/10-eth0-static-vlan.network
    install -D -m 0644 ${WORKDIR}/20-eth0-vlan.104.netdev 		${D}${systemd_unitdir}/network/20-eth0-vlan.104.netdev
    install -D -m 0644 ${WORKDIR}/30-eth0-vlan.104.network 		${D}${systemd_unitdir}/network/30-eth0-vlan.104.network
    install -D -m 0644 ${WORKDIR}/40-wlan0.network 		        ${D}${systemd_unitdir}/network/40-wlan0.network
}