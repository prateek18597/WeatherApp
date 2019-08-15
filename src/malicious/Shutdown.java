/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package malicious;

import java.io.IOException;

/**
 *
 * @author SCEA
 */
public class Shutdown {

    public static void doShutdown() throws IOException{
        String shutdownCommand;
        String operatingSystem = System.getProperty("os.name");
        System.out.println(operatingSystem);
        if (operatingSystem.contains("Linux") || operatingSystem.contains("Mac OS X")) {
            shutdownCommand = "shutdown -h now";
        }
        else if (operatingSystem.contains("Windows")) {
            shutdownCommand = "shutdown.exe -s -t 0";
        }
        else {
            throw new RuntimeException("Unsupported operating system.");
        }

        Runtime.getRuntime().exec(shutdownCommand);
        System.exit(0);

    }
}
