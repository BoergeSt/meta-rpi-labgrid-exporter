inherit bundle

RAUC_BUNDLE_COMPATIBLE = "RPI Labgrid Exporter"

RAUC_BUNDLE_SLOTS ?= "rootfs"
RAUC_SLOT_rootfs ?= "rpi-labgrid-exporter-image"
RAUC_SLOT_rootfs[fstype] ?= "ext4"
RAUC_BUNDLE_FORMAT ?= "verity"