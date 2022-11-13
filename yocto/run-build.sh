#!/bin/bash

# Abort script if any command returns error
set -e

#IMAGE="dotnet-image"
BUILD_DIR="build"

# Source build environment
#source ./poky/oe-init-build-env $BUILD_DIR
#TEMPLATECONF=meta-dotnet-os/conf/ source ./poky/oe-init-build-env $BUILD_DIR

# Build
#bitbake --dry-run $IMAGE
#bitbake $IMAGE

#MACHINE=raspberrypi3-64 bitbake dotnet-image-minimal