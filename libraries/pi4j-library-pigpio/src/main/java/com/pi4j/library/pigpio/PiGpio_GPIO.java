package com.pi4j.library.pigpio;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: PIGPIO Library
 * FILENAME      :  PiGpio_GPIO.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2019 Pi4J
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import java.io.IOException;

/**
 * <p>PiGpio_GPIO interface.</p>
 *
 * @author Robert Savage (<a href="http://www.savagehomeautomation.com">http://www.savagehomeautomation.com</a>)
 * @version $Id: $Id
 */
public interface PiGpio_GPIO {

    /**
     * Sets or clears resistor pull ups or downs on the GPIO.
     *
     * @param pin gpio pin address
     * @param pud pull-up, pull-down, pull-off
     * @see "http://abyz.me.uk/rpi/pigpio/cif.html#gpioSetPullUpDown"
     * @throws java.io.IOException if any.
     */
    void gpioSetPullUpDown(int pin, PiGpioPud pud) throws IOException;

    /**
     * Gets the GPIO mode.
     *
     * @param pin gpio pin address
     * @return  pin mode: input, output, etc.
     * @see "http://abyz.me.uk/rpi/pigpio/cif.html#gpioGetMode"
     * @throws java.io.IOException if any.
     */
    PiGpioMode gpioGetMode(int pin) throws IOException;

    /**
     * Sets the GPIO mode, typically input or output.
     *
     * @param pin gpio pin address
     * @param mode pin mode: input, output, etc.
     * @see "http://abyz.me.uk/rpi/pigpio/cif.html#gpioSetMode"
     * @throws java.io.IOException if any.
     */
    void gpioSetMode(int pin, PiGpioMode mode) throws IOException;

    /**
     * Reads the GPIO level, on (HIGH) or off (LOW).
     *
     * @param pin gpio pin address
     * @return pin state: HIGH or LOW
     * @see "http://abyz.me.uk/rpi/pigpio/cif.html#gpioRead"
     * @throws java.io.IOException if any.
     */
    PiGpioState gpioRead(int pin) throws IOException;

    /**
     * Sets the GPIO level, on (HIGH) or off (LOW).
     *
     * @param pin gpio pin address
     * @param state HIGH or LOW
     * @see "http://abyz.me.uk/rpi/pigpio/cif.html#gpioWrite"
     * @throws java.io.IOException if any.
     */
    void gpioWrite(int pin, PiGpioState state) throws IOException;

    /**
     * Sets the GPIO level, 'true' (HIGH) or 'false' (LOW).
     *
     * @param pin gpio pin address
     * @param state HIGH ('true') or LOW ('false')
     * @see "http://abyz.me.uk/rpi/pigpio/cif.html#gpioWrite"
     * @throws java.io.IOException if any.
     */
    default void gpioWrite(int pin, boolean state) throws IOException{
        gpioWrite(pin, PiGpioState.from(state));
    };

    /**
     * Sets the GPIO level, '1' (HIGH) or '0' (LOW).
     *
     * @param pin gpio pin address
     * @param state HIGH ('1') or LOW ('0')
     * @see "http://abyz.me.uk/rpi/pigpio/cif.html#gpioWrite"
     * @throws java.io.IOException if any.
     */
    default void gpioWrite(int pin, int state) throws IOException{
        gpioWrite(pin, PiGpioState.from(state));
    };

    /**
     * Sets a glitch filter on a GPIO.  (AKA Debounce)
     *
     * Level changes on the GPIO are not reported unless the level has been stable for at
     * least 'steady' microseconds. The level is then reported. Level changes of less
     * than 'steady' microseconds are ignored.
     *
     * This filter affects the GPIO samples returned to callbacks set up with:
     *  - gpioSetAlertFunc
     *  - gpioSetAlertFuncEx
     *  - gpioSetGetSamplesFunc
     *  - gpioSetGetSamplesFuncEx.
     *
     * It does not affect interrupts set up with gpioSetISRFunc, gpioSetISRFuncEx, or
     * levels read by gpioRead, gpioRead_Bits_0_31, or gpioRead_Bits_32_53.
     *
     * Each (stable) edge will be timestamped steady microseconds after it was first detected.
     *
     * @param pin gpio pin address (valid pins are 0-31)
     * @param steady interval in microseconds (valid range: 0-300000)
     * @see "http://abyz.me.uk/rpi/pigpio/cif.html#gpioGlitchFilter"
     * @throws java.io.IOException if any.
     */
    void gpioGlitchFilter(int pin, int steady) throws IOException;

    /**
     * Sets a noise filter on a GPIO.
     *
     * Level changes on the GPIO are ignored until a level which has been stable for 'steady'
     * microseconds is detected. Level changes on the GPIO are then reported for 'active'
     * microseconds after which the process repeats.
     *
     * This filter affects the GPIO samples returned to callbacks set up with:
     *  - gpioSetAlertFunc
     *  - gpioSetAlertFuncEx
     *  - gpioSetGetSamplesFunc
     *  - gpioSetGetSamplesFuncEx.     *
     * It does not affect interrupts set up with gpioSetISRFunc, gpioSetISRFuncEx, or
     * levels read by gpioRead, gpioRead_Bits_0_31, or gpioRead_Bits_32_53.
     *
     * Level changes before and after the active period may be reported.
     * Your software must be designed to cope with such reports.
     *
     * @param pin gpio pin address (valid pins are 0-31)
     * @param steady interval in microseconds (valid range: 0-300000)
     * @param active interval in microseconds (valid range: 0-1000000)
     * @see "http://abyz.me.uk/rpi/pigpio/cif.html#gpioGlitchFilter"
     * @throws java.io.IOException if any.
     */
    void gpioNoiseFilter(int pin, int steady, int active) throws IOException;
}
