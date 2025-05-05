FILESEXTRAPATHS:prepend := "${THISDIR}/python3-labgrid:"

SRC_URI += " \
    file://userconfig.yaml \
"

do_install:append() {
    install -d ${D}${sysconfdir}/labgrid
    install -m 0644 ${WORKDIR}/userconfig.yaml ${D}${sysconfdir}/labgrid
}
