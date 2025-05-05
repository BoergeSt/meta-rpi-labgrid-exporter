
LICENSE = "MIT"

inherit core-image

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
  overlayfs-home \
"

install_skel_files_for_root() {
    cp -a ${IMAGE_ROOTFS}${sysconfdir}/skel/. ${IMAGE_ROOTFS}/home/root/
}
ROOTFS_POSTPROCESS_COMMAND += "install_skel_files_for_root; "
