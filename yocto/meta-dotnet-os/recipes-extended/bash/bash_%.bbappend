# Busybox installs sh with priority 50.
# Set bash priority less than that to get ignored in alternatives.
# ALTERNATIVE_PRIORITY = "10"

pkg_prerm:${PN} () {
  # Remove /bin/bash from shell alternatives
  # update-alternatives --remove sh /bin/bash
  # update-alternatives --install /bin/sh sh /bin/bash 100
}