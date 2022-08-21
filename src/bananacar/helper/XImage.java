/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.helper;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author hp
 */
public class XImage {
 
 public static Image getAppIcon(){
     URL url = XImage.class.getResource("/bananacar.icons/bananaCar.jpg");
     return new ImageIcon(url).getImage();
 }
 
 public static void save(File src){
     File dst = new File("logos", src.getName());
     if(dst.getParentFile().exists()){
         dst.getParentFile().mkdirs();// Tạo thư mục logos nếu chưa tồn tại
     }
     try {
         Path from = Paths.get(src.getAbsolutePath());
         Path to = Paths.get(dst.getAbsolutePath());
         Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING); // Copy file vào thư mục logos
     } catch (IOException e) {
         throw new RuntimeException(e);
     }
 }
 
 public static ImageIcon read(String fileName){
     File path = new File("logos", fileName);
     return new ImageIcon( new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(300, 270, Image.SCALE_DEFAULT));
 }
 
}
