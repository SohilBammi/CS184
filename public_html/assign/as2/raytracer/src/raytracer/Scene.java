package raytracer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Scene {
	Point eye;
	Camera cam;
	ArrayList<Polygon> polygons;

    public Scene(Point eye, Point UL, Point UR, Point LR, Point LL, ArrayList<Polygon> polygons){
        this.eye = eye;
        this.cam = new Camera(UL, UR, LR, LL);
        this.polygons = polygons;
    }
    
    public void basicRayTraceNoShading() throws IOException{
    	BufferedImage img = new BufferedImage(cam.getWidth(), cam.getHeight(), BufferedImage.TYPE_INT_RGB);
    	for(int x = 0; x < cam.getWidth(); x++){
    		for(int y = 0; y < cam.getHeight(); y++){
    			Vector dir = new Vector(eye, cam.getPointByPixel(x, y));
    			Ray r = new Ray(eye, dir);
    			for(Polygon p : polygons){
    	    		if(p.isIntersection(r)){
    	    			int rgb = new Color(255, 0, 0).getRGB();
    	    			img.setRGB(x, y, rgb);
    	    		}
    	    	}
    		}
    	}
    	File f = new File("bin/basicRayTrace.png");
        ImageIO.write(img, "PNG", f);
        System.out.println("Complete.");
    }
}
