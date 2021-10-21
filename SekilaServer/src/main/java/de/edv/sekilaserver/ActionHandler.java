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

import de.edv.sekilaserver.Modell.Land;
import de.edv.sekilaserver.Modell.Person;
import de.edv.sekilaserver.Modell.Stadt;
import de.edv.sekilaserver.SQL.Delete;
import de.edv.sekilaserver.SQL.Insert;

/**
 *
 * @author Markus
 */
public class ActionHandler {

    public void execute(Object data) {
        switch (data.getClass().getName()) {
            case "Land":
                Land land = (Land) data;
                switch (land.getAction()) {
                    case INSERT:
                        new Insert().country(land);
                        break;
                    case DELETE:
                        new Delete().country(land);
                        break;
                }
                break;
            case "Person":
                Person person = (Person) data;
                switch (person.getAction()) {
                    case INSERT:
                        new Insert().person(person);
                        break;
                    case DELETE:
                        new Delete().person(person);
                        break;
                }
                break;
            case "Stadt":
                Stadt stadt = (Stadt) data;
                switch (stadt.getAction()) {
                    case INSERT:
                        new Insert().city(stadt);
                        break;
                    case DELETE:
                        new Delete().city(stadt);
                        break;
                }
                break;
        }
    }
}
