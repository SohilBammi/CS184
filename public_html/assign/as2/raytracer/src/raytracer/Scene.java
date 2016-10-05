package raytracer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Scene {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedImage img = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
        int rgb = new Color(255, 255, 255).getRGB();
        img.setRGB(120, 120, rgb);
        File f = new File("bin/MyFile.png");
        ImageIO.write(img, "PNG", f);
        System.out.println("Complete.");
    }

}
