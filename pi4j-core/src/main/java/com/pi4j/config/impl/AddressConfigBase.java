package com.pi4j.config.impl;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (CORE)
 * FILENAME      :  AddressConfigBase.java
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

import com.pi4j.config.AddressConfig;
import com.pi4j.config.Config;
import com.pi4j.config.ConfigBase;
import com.pi4j.config.exception.ConfigMissingRequiredKeyException;

import java.util.Map;

/**
 * <p>Abstract AddressConfigBase class.</p>
 *
 * @author Robert Savage (<a href="http://www.savagehomeautomation.com">http://www.savagehomeautomation.com</a>)
 * @version $Id: $Id
 * @param <CONFIG_TYPE>
 */
public abstract class AddressConfigBase<CONFIG_TYPE extends Config>
        extends ConfigBase<CONFIG_TYPE>
        implements AddressConfig<CONFIG_TYPE> {

    // private configuration properties
    protected Integer address = null;

    /**
     * PRIVATE CONSTRUCTOR
     */
    protected AddressConfigBase(){
        super();
    }

    /**
     * <p>Constructor for AddressConfigBase.</p>
     *
     * @param address a {@link java.lang.Number} object.
     */
    protected AddressConfigBase(Number address){
        super();
        this.address = address.intValue();
    }

    /**
     * PRIVATE CONSTRUCTOR
     *
     * @param properties a {@link java.util.Map} object.
     */
    protected AddressConfigBase(Map<String,String> properties){
        super(properties);

        // load address property
        if(properties.containsKey(ADDRESS_KEY)){
            this.address = Integer.parseInt(properties.get(ADDRESS_KEY));
        } else {
            throw new ConfigMissingRequiredKeyException(ADDRESS_KEY);
        }
    }

    /**
     * <p>address.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer address() {
        return this.address;
    };
}
