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

# As this package is tied to systemd, only build it when we're also building systemd.
inherit features_check
REQUIRED_DISTRO_FEATURES = "systemd"

do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/

    install -m 0644 ${WORKDIR}/rpi-env-init.service ${D}${systemd_system_unitdir}/rpi-env-init.service
	ln -sf ${systemd_system_unitdir}/rpi-env-init.service \
		${D}${sysconfdir}/systemd/system/multi-user.target.wants/rpi-env-init.service

    install -d ${D}${base_sbindir}
    install -m 0755 ${WORKDIR}/rpi_env_init.sh ${D}${base_sbindir}
}

FILES:${PN} = " \
    ${sysconfdir} \
    ${systemd_system_unitdir}/rpi-env-init.service \
    ${base_sbindir}/rpi_env_init.sh \
    "