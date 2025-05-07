SUMMARY = "Root-CA Certificates for SSH"
DESCRIPTION = "Installs specific SSH certificates and configuration fragments."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


SSH_CUSTOM_CA_FILE ??= "ssh-ca.pub"
SSH_CUSTOM_CA_URI ??= "file://${SSH_CUSTOM_CA_FILE}"

SRC_URI = " \
    file://ssh-root-ca.conf \
    ${SSH_CUSTOM_CA_URI} \
    file://ssh-principals \
"

inherit systemd

do_install() {
    # Make sure the /etc/ssh/sshd_config.d directory exists
    mkdir -p ${D}${sysconfdir}/ssh/sshd_config.d

    # Install the CA key
    install -m 0644 ${WORKDIR}/${SSH_CUSTOM_CA_FILE} ${D}${sysconfdir}/ssh/ssh-ca.pub
    install -m 0644 ${WORKDIR}/ssh-principals ${D}${sysconfdir}/ssh/

    # Install the config fragment to the sshd_config.d folder
    install -m 0644 ${WORKDIR}/ssh-root-ca.conf ${D}${sysconfdir}/ssh/sshd_config.d/
}
