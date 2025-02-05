DESCRIPTION = "The goal is to init rpi env "
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


SRC_URI = " file://rpi-env-init.service \
   		 	file://rpi_env_init.sh \
    "

inherit systemd

SYSTEMD_PACKAGES += "${PN}"
SYSTEMD_SERVICE_${PN} = "rpi-env-init.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

do_install() {
    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/rpi-env-init.service ${D}${systemd_unitdir}/system
        install -d ${D}${base_sbindir}
        install -m 0755 ${WORKDIR}/rpi_env_init.sh ${D}${base_sbindir}
    fi
}

FILES:${PN} = " \
    ${systemd_unitdir}/system/rpi-env-init.service \
    ${base_sbindir}/rpi_env_init.sh \
    "