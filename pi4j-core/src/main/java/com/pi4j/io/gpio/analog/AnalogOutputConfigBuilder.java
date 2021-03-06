package com.pi4j.io.gpio.analog;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (CORE)
 * FILENAME      :  AnalogOutputConfigBuilder.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2020 Pi4J
 * %%
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

import com.pi4j.context.Context;
import com.pi4j.io.gpio.analog.impl.DefaultAnalogOutputConfigBuilder;

/**
 * <p>AnalogOutputConfigBuilder interface.</p>
 *
 * @author Robert Savage (<a href="http://www.savagehomeautomation.com">http://www.savagehomeautomation.com</a>)
 * @version $Id: $Id
 */
public interface AnalogOutputConfigBuilder extends AnalogConfigBuilder<AnalogOutputConfigBuilder, AnalogOutputConfig> {
    /**
     * <p>shutdown.</p>
     *
     * @param value a {@link java.lang.Integer} object.
     * @return a {@link com.pi4j.io.gpio.analog.AnalogOutputConfigBuilder} object.
     */
    AnalogOutputConfigBuilder shutdown(Integer value);
    /**
     * <p>initial.</p>
     *
     * @param value a {@link java.lang.Integer} object.
     * @return a {@link com.pi4j.io.gpio.analog.AnalogOutputConfigBuilder} object.
     */
    AnalogOutputConfigBuilder initial(Integer value);
    /**
     * <p>step.</p>
     *
     * @param value a {@link java.lang.Integer} object.
     * @return a {@link com.pi4j.io.gpio.analog.AnalogOutputConfigBuilder} object.
     */
    AnalogOutputConfigBuilder step(Integer value);

    /**
     * <p>newInstance.</p>
     *
     * @param context {@link Context}
     * @return a {@link com.pi4j.io.gpio.analog.AnalogOutputConfigBuilder} object.
     */
    static AnalogOutputConfigBuilder newInstance(Context context)  {
        return DefaultAnalogOutputConfigBuilder.newInstance(context);
    }
}
