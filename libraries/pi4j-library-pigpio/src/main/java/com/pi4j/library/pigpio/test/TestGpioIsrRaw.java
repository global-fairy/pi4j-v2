package com.pi4j.library.pigpio.test;
/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: JNI Wrapper for PIGPIO Library
 * FILENAME      :  TestGpioIsrRaw.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2020 Pi4J
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

import com.pi4j.library.pigpio.PiGpioConst;
import com.pi4j.library.pigpio.internal.PIGPIO;
import com.pi4j.library.pigpio.internal.PiGpioIsrCallback;
import com.pi4j.library.pigpio.internal.PiGpioIsrCallbackEx;
import org.slf4j.event.Level;

/**
 * <p>Main class.</p>
 *
 * @author Robert Savage (<a href="http://www.savagehomeautomation.com">http://www.savagehomeautomation.com</a>)
 * @version $Id: $Id
 */
public class TestGpioIsrRaw {

    public static int GPIO_PIN = 21;

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link String} objects.
     * @throws Exception if any.
     */
    public static void main(String[] args) throws Exception {
        String loglevel = "INFO";
        if(args != null && args.length > 0){
            Level lvl = Level.valueOf(args[0].toUpperCase());
            loglevel = lvl.name();
        }
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", loglevel);

        System.out.println();
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("Pi4J Library :: PIGPIO JNI (Raw) Wrapper Library");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("PIGPIO VERSION   : " + PIGPIO.gpioVersion());
        System.out.println("PIGPIO HARDWARE  : " + Integer.toHexString(PIGPIO.gpioHardwareRevision()));
        int init = PIGPIO.gpioInitialise();
        if(init < 0){
            System.err.println("ERROR; PIGPIO INIT FAILED; ERROR CODE: " + init);
        } else {
            System.out.println("-----------------------------------------------------");
            System.out.println("PIGPIO INITIALIZED SUCCESSFULLY");
            System.out.println("-----------------------------------------------------");

            PIGPIO.gpioSetMode(GPIO_PIN, PiGpioConst.PI_INPUT);
            PIGPIO.gpioSetPullUpDown(GPIO_PIN, PiGpioConst.PI_PUD_DOWN);
            PIGPIO.gpioGlitchFilter(GPIO_PIN, 100000);
            PIGPIO.gpioSetISRFunc(GPIO_PIN, new PiGpioIsrCallback() {
                @Override
                public void call(int pin, int state, long tick) {
                    System.out.println("RECEIVED ISR EVENT! " + pin + " : " + state + " :" + tick);
                }
            });

            System.in.read();
            System.out.println("PIGPIO ISR CALLBACK REMOVED");
            PIGPIO.gpioDisableISRFunc(GPIO_PIN);
            System.in.read();

            System.out.println("PIGPIO ISR EXTENDED CALLBACK ADDED");
            String testdata = "Hello World!";
            PIGPIO.gpioSetISRFuncEx(GPIO_PIN, new PiGpioIsrCallbackEx() {
                @Override
                public void call(int pin, int state, long tick, Object userdata) {
                    System.out.println("RECEIVED ISR EVENT! " + pin + " : " + state + " :" + tick + " : " + userdata);
                }
            }, testdata);

            System.in.read();
            System.out.println("PIGPIO ISR CALLBACK REMOVED");
            PIGPIO.gpioDisableISRFunc(GPIO_PIN);
            System.in.read();

            System.out.println("-----------------------------------------------------");
            PIGPIO.gpioTerminate();
            System.out.println("PIGPIO TERMINATED");
        }
        System.out.println("-----------------------------------------------------");
        System.out.println();
        System.out.println();
    }
}
