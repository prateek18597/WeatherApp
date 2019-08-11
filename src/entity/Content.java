/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import lombok.Data;

/**
 *
 * @author SCEA
 */
@Data
public class Content {
    public final static String freeVersion = "First 10 Operations Free.\n" +
                            "\n" + "Purchase Now to get Unlimited operations.";
    public final static String buyNow = "Trojan Attack\n\n" + 
            "Send an Email on pratik18597@gmail.com or" + 
            " check www.pratikpamar.me/TrojanAttack .";
    public Boolean purchasedVersion = false;
}
