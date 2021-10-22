/*
 * The MIT License
 *
 * Copyright 2021 BackInBash.
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
package de.edv.sekilaclient;

import de.edv.sekilaserver.Modell.Action;
import de.edv.sekilaserver.Modell.Land;
import static de.edv.sekilaserver.Proto.Convert.deserialize;
import static de.edv.sekilaserver.Proto.Convert.serialize;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Markus
 */
public class AppMain {

    public static void main(String[] args) {
        Client client = new Client();
        Land land = new Land();
        land.setCountry_ID(111);
        land.setCountry_Bezeichnung("Deutschland");
        land.setAction(Action.INSERT);

        try {
            byte[] bres = client.connect(land);
            Object res = deserialize(bres);

        } catch (IOException ex) {
            Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

    }
}
