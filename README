
本项目是**Yocto快速入门和实战指南**书籍的配套软件工程，硬件基于raspberrypi 4B卡片电脑， 完整展示如何基于yocto定制前人千面的嵌入式发行版

# 一、 环境准备
```
git clone -b kirkstone https://gitlab.com/yoctoproject/poky.git poky-kirkstone
cd poky-kirkstone
git clone -b kirkstone https://github.com/agherzan/meta-raspberrypi.git meta-raspberrypi
git clone https://github.com/TNTNTA/meta-rpi-custom.git
```

# 二、 编译

```
source poky-kirkstone/oe-init-build-env rpi-build
bitbake rpi-custom-image
```

# 三、 刷写image到SD卡
```
sudo dd if=/mnt/ext_disk/code/raspberry/rpi-build/tmp/deploy/images/raspberrypi4-64/core-image-base-raspberrypi4-64-20240921103626.rootfs.rpi-sdimg of=/dev/sda
sync
```
# 四、 启动