
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES  += " overlayfs-etc "

IMAGE_INSTALL:append = " \
  networkmanager \
  networkmanager-nmcli \
  networkmanager-wifi \
  iptables \
  \
  python3 \
  python3-pip \
  python3-labgrid \
  \
  curl \
  openssh \
  openssl \
  ca-certificates \
  \
  minicom \
  screen \
  \
  less \
  tree \
  \
  util-linux \
  parted \
  e2fsprogs \
  e2fsprogs-resize2fs \
  \
  libgpiod \
  libgpiod-tools \
  \
  rsync \
  \
  imx-uuu \
  \
  overlayfs-home \
"

install_skel_files_for_root() {
    cp -a ${IMAGE_ROOTFS}${sysconfdir}/skel/. ${IMAGE_ROOTFS}/home/root/
}
ROOTFS_POSTPROCESS_COMMAND += "install_skel_files_for_root; "

add_coordinator_dns_entry() {
    echo "192.168.178.157 coordinator.fritz.box" >> ${IMAGE_ROOTFS}/etc/hosts
}
ROOTFS_POSTPROCESS_COMMAND += "add_coordinator_dns_entry;"
