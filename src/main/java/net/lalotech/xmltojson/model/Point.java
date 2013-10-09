/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.lalotech.xmltojson.model;

import java.io.Serializable;

/**
 *
 * @author lalotech
 */
public class Point implements Serializable{
    private String coordinates;

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
    
}
