package com.pi4j.io.gpio.analog;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (CORE)
 * FILENAME      :  AnalogConfigBuilder.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.pi4j.io.gpio.GpioConfigBuilder;

/**
 * <p>AnalogConfigBuilder interface.</p>
 *
 * @author Robert Savage (<a href="http://www.savagehomeautomation.com">http://www.savagehomeautomation.com</a>)
 * @version $Id: $Id
 * @param <BUILDER_TYPE>
 * @param <CONFIG_TYPE>
 */
public interface AnalogConfigBuilder<BUILDER_TYPE extends AnalogConfigBuilder, CONFIG_TYPE extends AnalogConfig>
        extends GpioConfigBuilder<BUILDER_TYPE, CONFIG_TYPE> {
    /**
     * <p>min.</p>
     *
     * @param value a {@link java.lang.Integer} object.
     * @return a BUILDER_TYPE object.
     */
    BUILDER_TYPE min(Integer value);
    /**
     * <p>max.</p>
     *
     * @param value a {@link java.lang.Integer} object.
     * @return a BUILDER_TYPE object.
     */
    BUILDER_TYPE max(Integer value);
}
