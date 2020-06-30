#!/bin/bash -e
###
# #%L
# **********************************************************************
# ORGANIZATION  :  Pi4J
# PROJECT       :  Pi4J :: Build project inside a Pi4J Builder Docker Container
# FILENAME      :  build-docker.sh
#
# This file is part of the Pi4J project. More information about
# this project can be found here:  https://pi4j.com/
# **********************************************************************
# %%
# Copyright (C) 2012 - 2019 Pi4J
# %%
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# #L%
###

echo
echo "**********************************************************************"
echo "**********************************************************************"
echo "*                                                                    *"
echo "*  COMPILE ENTIRE Pi4J PROJECT USING A PRECONFIGURED DOCKER IMAGE    *"
echo "*                                                                    *"
echo "**********************************************************************"
echo "**********************************************************************"
echo

# -------------------------------------------------------------
# THIS BUILD WILL COMPILE NATIVE LIBRARIES USING THE PI4J
# DOCKER CROSS-COMPILER BUILDER IMAGE FOR THE FOLLOWING:
#   -- ARMv6,ARMv7, ARMv8  32-BIT (ARMHF)
#   -- ARMv8               64-BIT (ARM64)
# -------------------------------------------------------------
docker pull pi4j/pi4j-builder:2.0
docker run --user "$(id -u):$(id -g)" --rm --volume $(pwd):/build pi4j/pi4j-builder:2.0