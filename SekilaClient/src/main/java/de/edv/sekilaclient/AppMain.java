/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
