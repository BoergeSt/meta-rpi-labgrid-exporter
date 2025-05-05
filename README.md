# meta-rpi-labgrid-exporter

**Yocto layer for deploying a `labgrid-exporter` on Raspberry Pi**

This layer provides a `labgrid-exporter` setup tailored for the Raspberry Pi platform. It is optimized for the Raspberry Pi 4 but should work on other models with minimal modification.

While the layer aims to remain generic, some components are specific to my personal setup. These should be easy to find and to remove or adjusted to fit your use case.

---

## Features

- ✅ A/B root filesystem layout  
- 🔄 Optional RAUC integration for OTA updates  
- 🛠️ Persistent `/etc` using OverlayFS  
- 🗄️ Persistent `/home` using OverlayFS  

---

## Usage

This layer is intended to be used in a Yocto build environment, ideally managed with [kas](https://github.com/siemens/kas).  
You can find an example `kas` configuration I use with this layer in my repository:  
👉 [BoergeSt/Various-KAS-Configs](https://github.com/BoergeSt/Various-KAS-Configs)

---

## Disclaimer

This project is provided **as is**, without warranty of any kind. Use it at your own risk.  
I am not responsible for any damage, data loss, or other consequences resulting from the use of this software.
