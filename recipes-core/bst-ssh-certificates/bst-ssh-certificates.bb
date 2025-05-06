SUMMARY = "BST Certificates for SSH"
DESCRIPTION = "Installs BST-specific SSH certificates and configuration fragments."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://bst_sshd_config.conf \
    file://bst-ssh-ca.pub \
    file://bst-ssh-principals \
"

inherit systemd

do_install() {
    # Make sure the /etc/ssh/sshd_config.d directory exists
    mkdir -p ${D}${sysconfdir}/ssh/sshd_config.d

    # Install the CA key
    install -m 0644 ${WORKDIR}/bst-ssh-ca.pub ${D}${sysconfdir}/ssh/
    install -m 0644 ${WORKDIR}/bst-ssh-principals ${D}${sysconfdir}/ssh/

    # Install the config fragment to the sshd_config.d folder
    install -m 0644 ${WORKDIR}/bst_sshd_config.conf ${D}${sysconfdir}/ssh/sshd_config.d/
}