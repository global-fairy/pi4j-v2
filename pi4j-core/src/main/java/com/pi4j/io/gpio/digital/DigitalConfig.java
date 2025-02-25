package com.pi4j.io.gpio.digital;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (CORE)
 * FILENAME      :  DigitalConfig.java
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

import com.pi4j.config.Config;
import com.pi4j.io.gpio.GpioConfig;

/**
 * <p>DigitalConfig interface.</p>
 *
 * @author Robert Savage (<a href="http://www.savagehomeautomation.com">http://www.savagehomeautomation.com</a>)
 * @version $Id: $Id
 * @param <CONFIG_TYPE>
 */
public interface DigitalConfig<CONFIG_TYPE extends Config> extends GpioConfig<CONFIG_TYPE> {

    /** Constant <code>ON_STATE_KEY="onstate"</code> */
    String ON_STATE_KEY = "onstate";
    /**
     * <p>onState.</p>
     *
     * @return a {@link com.pi4j.io.gpio.digital.DigitalState} object.
     */
    DigitalState onState();

    /**
     * <p>getOnState.</p>
     *
     * @return a {@link com.pi4j.io.gpio.digital.DigitalState} object.
     */
    default DigitalState getOnState(){
        return this.onState();
    }
}
