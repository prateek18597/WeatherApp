/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;
import entity.Gender;
import util.GenderizeClient;
/**
 *
 * @author SCEA
 */
public class Runner {
 
    public static void main(String[] args) {
        GenderizeClient genderizeClient = new GenderizeClient();
        genderizeClient.call("pratik");
    }
}
