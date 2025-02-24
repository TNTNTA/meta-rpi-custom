DESCRIPTION = "custom image for raspberrypi4B board"
LICENSE = "MIT"

#require recipes-core/images/core-image-base.bb
inherit core-image

IMAGE_FSTYPES = "ext4.xz rpi-sdimg"
SDIMG_ROOTFS_TYPE="ext4.xz"

IMAGE_FEATURES += "ssh-server-openssh"

DISTRO_FEATURES:append = " systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED:append = " sysvinit"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"

IMAGE_INSTALL +=" openssh-sftp-server \
		sudo \
		rpi-gpio \
		raspi-gpio \
		packagegroup-appdemo \
		rpi-env-init \
"