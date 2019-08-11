/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.client.RestTemplate;
import entity.Gender;
/**
 *
 * @author SCEA
 */
public class GenderizeClient {
    
    public static Boolean validate(String gender) {
        Class<?> objClass = Gender.class.getClass();

        Field[] fields = objClass.getFields();
        for(Field field : fields) {
            String name = field.getName();
            Object value = null;
            try {
                value = field.get(null);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(GenderizeClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(GenderizeClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(name + ": " + value.toString());
        }
          return null;
    }
    
    
    public static String extractGender(String response) {
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(response);
        JsonObject rootObject = jsonElement.getAsJsonObject();
        String gender = rootObject.get("gender").getAsString();
        System.out.println(gender + " <-Gender" );
        return gender;
    } 
    
    public static String call(String firstName, String lastName) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://api.namsor.com/onomastics/api/json/gender/" + firstName + "/" + lastName,String.class);
        String gender = extractGender(result);
        System.out.println(validate(gender));
        return null;
    }
}
