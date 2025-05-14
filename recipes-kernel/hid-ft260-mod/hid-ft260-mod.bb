SUMMARY = "Example of how to build an external Linux kernel module"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit module

SRC_URI = "git://github.com/MichaelZaidman/hid-ft260.git;branch=main;protocol=https"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "KBUILD=${STAGING_KERNEL_DIR}"

RPROVIDES:${PN} += "kernel-module-hid-ft260"

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra
    install -m 0644 ${B}/hid-ft260.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra/
}
