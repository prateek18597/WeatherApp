/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.WeatherInfo;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author SCEA
 */
public class ApixuClient {
    
// Need to display Location, Temp in C, Condition, 
 public static WeatherInfo extractWeather(String response) {
    JsonParser parser = new JsonParser();
    JsonElement jsonElement = parser.parse(response);
    JsonObject rootObject = jsonElement.getAsJsonObject();
    JsonObject location = rootObject.getAsJsonObject("location");
    String city = location.get("name").getAsString();
    String country = location.get("country").getAsString();
    JsonObject current = rootObject.getAsJsonObject("current");
    Double temp = current.get("temp_c").getAsDouble();
    JsonObject condition = current.getAsJsonObject("condition");
    String conditionText = condition.get("text").getAsString();
    return new WeatherInfo(city, country, conditionText, temp);
}
 public static WeatherInfo call(String city, String country) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://api.apixu.com/v1/current.json?key=c6e3a88d315d4367a4e44612191108&q=" + city + "," + country ,String.class);
        WeatherInfo w = extractWeather(result);
        System.out.println(result);
        return w;
    }   
}
