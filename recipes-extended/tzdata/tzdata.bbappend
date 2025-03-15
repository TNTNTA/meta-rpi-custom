do_install:append () {
    echo "Asia/Shanghai" > ${D}/etc/timezone
    rm -rf ${D}/etc/localtime
    ln -sf /usr/share/zoneinfo/Asia/Shanghai ${D}/etc/localtime
}