/*
 * The MIT License
 *
 * Copyright 2021 Markus.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.edv.sekilaserver;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Markus
 */
public class Config {

    private static String APIKEY;
    private static String DEFAULT_CONFIG = "SekilaServer.conf";
    private static String DB_IP;
    private static String DB_NAME;
    private static String DB_USER;
    private static String DB_PASSWORD;

    public static String getApiKey() {
        return APIKEY;
    }

    public static String getDBIP() {
        return DB_IP;
    }

    public static String getDBName() {
        return DB_NAME;
    }

    public static String getDBUser() {
        return DB_USER;
    }

    public static String getDBPassword() {
        return DB_PASSWORD;
    }

    /**
     * Read Configuration File
     */
    public static void UpdateConfig() {
        Gson gson = new Gson();
        String data = null;
        try {
            data = new String(Files.readAllBytes(Paths.get(DEFAULT_CONFIG)));
        } catch (IOException e) {
            System.out.println("Cannot open config file: " + e.getMessage());
            System.exit(1);
        }
        if (data == null) {
            System.out.println("ERROR: Config file is empty!");
            System.exit(1);
        }
        try {
            Config ConfigObject = gson.fromJson(data, Config.class);
            APIKEY = ConfigObject.APIKEY;
            DB_IP = ConfigObject.DB_IP;
            DB_NAME = ConfigObject.DB_NAME;
            DB_USER = ConfigObject.DB_USER;
            DB_PASSWORD = ConfigObject.DB_PASSWORD;
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            System.exit(1);
        }
    }
}