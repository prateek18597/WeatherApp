/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import gui.GenderAPI;
import gui.Home;
import gui.WeatherAPI;

/**
 *
 * @author SCEA
 */
public class MenuUtil {
    public static void Home() {
        new Home().setVisible(true);
    }
    
    public static void WeatherAPI() {
        new WeatherAPI().setVisible(true);
    }
    
    public static void GenderAPI() {
        new GenderAPI().setVisible(true);
    }
}
