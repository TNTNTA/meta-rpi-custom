FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://wpa_supplicant.conf"

# wlan0需要根据自己实际的网卡名作修改，同时wpa_supplicant.conf里面的wifi信息也需要根据自己实际环境修改

SYSTEMD_SERVICE:${PN} = "wpa_supplicant@wlan0.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install:append() {
    install -d ${D}${sysconfdir}/wpa_supplicant
    install -m 0644 ${WORKDIR}/wpa_supplicant.conf ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf

    ln -sf ${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf ${D}${sysconfdir}/wpa_supplicant-wlan0.conf
}
