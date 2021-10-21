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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Markus
 */
public class Delete extends SQLConn {

    public void country(Land country) {
        open();
        PreparedStatement stm = null;

        try {
            stm = SQL.prepareStatement("DELETE FROM country WHERE ID = ?");

            stm.setLong(1, country.getCountry_ID());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public void city(Stadt city) {
        open();
        PreparedStatement stm = null;

        try {
            stm = SQL.prepareStatement("DELETE FROM city WHERE ID = ?");

            stm.setLong(1, city.getCity_ID());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public void person(Person person) {
        open();
        PreparedStatement stm = null;

        try {
            stm = SQL.prepareStatement("DELETE FROM customer WHERE ID = ?");

            stm.setLong(1, person.getCustomer_ID());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

}
