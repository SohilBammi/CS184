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
	ArrayList<Light> lights;

    public Scene(Point eye, Point UL, Point UR, Point LR, Point LL, ArrayList<Polygon> polygons, ArrayList<Light> lights){
        this.eye = eye;
        this.cam = new Camera(UL, UR, LR, LL);
        this.polygons = polygons;
        this.lights = lights;
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
    	File f = new File("bin/basicRayTraceNoShading.png");
        ImageIO.write(img, "PNG", f);
        System.out.println("Complete.");
    }
    
    public void basicRayTrace() throws IOException{
    	BufferedImage img = new BufferedImage(cam.getWidth(), cam.getHeight(), BufferedImage.TYPE_INT_RGB);
    	for(int x = 0; x < cam.getWidth(); x++){
    		for(int y = 0; y < cam.getHeight(); y++){
    			Color col = new Color(0,0,0);
    			Vector dir = new Vector(eye, cam.getPointByPixel(x, y));
    			Ray r = new Ray(eye, dir);
    			double t = -1;
    			int currPoly = -1;
    			for(int i = 0; i < polygons.size(); i++){
    				Polygon p = polygons.get(i);
    	    		if(p.isIntersection(r)){
    	    			if(p.getIntersection(r) > t){
    	    				currPoly = i;
    	    				t = p.getIntersection(r);
    	    			}
    	    		}
    	    	}
    			if(t > -1 && currPoly > -1){
        			Polygon poly = polygons.get(currPoly);
        			PhongShader shader = new PhongShader(lights, poly.getKa(), poly.getKd(), poly.getKs(), poly.getP());
        			Point pos = r.getPoint(t);
        			Point camPos = new Point(x, y, cam.depth);
        			Vector viewVec = pos.vector(camPos);
        			Vector normVec = poly.getNormalVector(pos);
        			viewVec.normalize();
        			viewVec.mulScalar(-1);
        			col = shader.calcPixelRGB(pos, normVec, viewVec);
        		}
    			int rgb = col.getRGB();
    			img.setRGB(x, y, rgb);
    		}
    	}
    	File f = new File("bin/basicRayTrace.png");
        ImageIO.write(img, "PNG", f);
        System.out.println("Complete.");
    }
}
