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
package de.edv.sekilaserver.SQL;

import de.edv.sekilaserver.Modell.Land;
import de.edv.sekilaserver.Modell.Person;
import de.edv.sekilaserver.Modell.Stadt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Markus
 */
public class Select extends SQLConn {

    public List<Land> countries() {
        open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Land> laenderListe = new ArrayList();

        try {
            stm = SQL.prepareStatement("SELECT * from country");
            while (rs.next()) {
                Land land = new Land();
                land.setCountry_ID(Integer.parseInt(rs.getString("country_id")));
                land.setCountry_Bezeichnung(rs.getString("country"));
                laenderListe.add(land);
            }

        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return laenderListe;
    }

    public List<Person> personen() {
        open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Person> personenListe = new ArrayList();

        try {
            stm = SQL.prepareStatement("SELECT * from customer");
            while (rs.next()) {
                Person p = new Person();
                p.setCustomer_ID(Integer.parseInt(rs.getString("customer_id")));
                p.setCustomer_Firstname(rs.getString("first_name"));
                p.setCustomer_Lastname(rs.getString("last_name"));
                personenListe.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return personenListe;
    }

    public List<Stadt> cities() {
        open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Stadt> stadtListe = new ArrayList();

        try {
            stm = SQL.prepareStatement("SELECT * from customer");
            while (rs.next()) {
                Stadt s = new Stadt();
                s.setCity_ID(Integer.parseInt(rs.getString("city_id")));
                s.setCity_Bezeichnung(rs.getString("city"));
                stadtListe.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return stadtListe;
    }

}
