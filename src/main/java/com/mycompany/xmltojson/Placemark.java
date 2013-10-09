/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.xmltojson;

import java.io.Serializable;

/**
 *
 * @author lalotech
 */
public class Placemark implements Serializable {

    private String name;
    private String description;
    private Point Point;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Point getPoint() {
        return Point;
    }

    public void setPoint(Point Point) {
        this.Point = Point;
    }  
}
