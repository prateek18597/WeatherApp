/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author SCEA
 */
@Data
@AllArgsConstructor
public class WeatherInfo {
    
    private String cityName;
    private String countryName;
    private String condition;
    private Double tempC;
    
    @Override
    public String toString() {
        return "City: " + cityName +
               "\nCountry: " + countryName +
               "\nCondition: " + condition +
               "\nTemperature: " + tempC;
    }
}
