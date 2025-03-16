DESCRIPTION = "custom image for raspberrypi 4B board"
LICENSE = "MIT"

#require recipes-core/images/core-image-base.bb
inherit core-image

IMAGE_FSTYPES = "tar.gz ext4.xz rpi-sdimg"
SDIMG_ROOTFS_TYPE="ext4.xz"

IMAGE_FEATURES += "ssh-server-openssh"

DISTRO_FEATURES:remove = "x11"
DISTRO_FEATURES:append = "opengl"

IMAGE_INSTALL +=" openssh-sftp-server \
		sudo \
		rpi-gpio \
		raspi-gpio \
		packagegroup-appdemo \
		packagegroup-customtools \
		packagegroup-gstreamer \
		packagegroup-qt5 \
		rpi-env-init \
		tzdata \
"