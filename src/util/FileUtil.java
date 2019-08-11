/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Record;
import gui.Home;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author SCEA
 */
public class FileUtil {
    
    public static String readFile(File file) throws IOException {
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }
    
    public static void getContent() throws IOException {
        String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
        String fileLoc = path + "/t.txt";
        File file = new File(fileLoc);
        String data = "";
        Path path1 = Paths.get(fileLoc);
        if (file.isFile()) {
            try {
                data = readFile(file);
                if (data.trim().equals("")) {
                    Files.setAttribute(path1, "dos:hidden", false);
                    FileUtils.write(file, "F0");
                    Record.purchased = false;
                    Record.usageCount = 0;
                } else {
                    Record.purchased = data.charAt(0) != 'F';
                    Record.usageCount = Integer.parseInt(data.substring(1));
                }
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            file.createNewFile();
            FileUtils.write(file, "F0");
            Record.purchased = false;
            Record.usageCount = 0;
        }
        try {
            Files.setAttribute(path1, "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void incrementUsage() throws IOException {
        String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
        String fileLoc = path + "/t.txt";
        File file = new File(fileLoc);
        String data = "";
        Path path1 = Paths.get(fileLoc);
        if (file.isFile()) {
            try {
                data = readFile(file);
                Files.setAttribute(path1, "dos:hidden", false);
                String status = Record.purchased ? "P":"F";
                Record.usageCount++;
                FileUtils.write(file, status + String.valueOf(Record.usageCount));
                
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            file.createNewFile();
            String status = Record.purchased ? "P":"F";
            Record.usageCount++;
            FileUtils.write(file, status + String.valueOf(Record.usageCount));
        }
        try {
            Files.setAttribute(path1, "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
