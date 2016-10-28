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
    
    public void basicRayTraceNoShading(String fileName) throws IOException{
        double currPixel = 1;
        double currPercent = 0;
        int size = cam.getWidth()*cam.getHeight();
        BufferedImage img = new BufferedImage(cam.getWidth(), cam.getHeight(), BufferedImage.TYPE_INT_RGB);
    	for(int x = 0; x < cam.getWidth(); x++){
    		for(int y = 0; y < cam.getHeight(); y++){
    		    if(((currPixel/size)*100)>(currPercent+5)){
                    currPercent= currPercent+5;
                    System.out.println(currPercent+"%");
                }
    			Vector dir = new Vector(eye, cam.getPointByPixel(x, y));
    			Ray r = new Ray(eye, dir);
    			for(Polygon p : polygons){
    	    		if(p.isIntersection(r)){
    	    			int rgb = new Color(255, 0, 0).getRGB();
    	    			img.setRGB(x, y, rgb);
    	    		}
    	    	}
    			currPixel++;
    		}
    	}
    	File f = new File("bin/" + fileName + ".png");
        ImageIO.write(img, "PNG", f);
        System.out.println("Complete.");
    }
    
    public void basicRayTrace(String fileName) throws IOException{
        double currPixel = 1;
        double currPercent = 0;
        int size = cam.getWidth()*cam.getHeight();
    	BufferedImage img = new BufferedImage(cam.getWidth(), cam.getHeight(), BufferedImage.TYPE_INT_RGB);
    	for(int x = 0; x < cam.getWidth(); x++){
    		for(int y = 0; y < cam.getHeight(); y++){ 
    		    if(((currPixel/size)*100)>(currPercent+5)){
    		        currPercent= currPercent+5;
    		        System.out.println(currPercent+"%");
    		    }
    			Color col = new Color(0,0,0);
    			Vector dir = new Vector(eye, cam.getPointByPixel(x, y));
    			dir.normalize();
    			
    			Ray r = new Ray(cam.getPointByPixel(x, y), dir);
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
        			Point camPos = cam.getPointByPixel(x, y);
        			Vector viewVec = pos.vector(camPos);
        			Vector normVec = poly.getNormalVector(pos);
        			viewVec.normalize();
        			viewVec.mulScalar(-1);
        			ArrayList<Polygon> polygonsMinusCurr = new ArrayList<Polygon>();
        			for(int i = 0; i < polygonsMinusCurr.size(); i++){
        			    if(i!=currPoly){
        			        polygonsMinusCurr.add(polygons.get(i));
        			    }
        			}
        			col = shader.calcPixelRGB(pos, normVec, viewVec, polygonsMinusCurr);
        		}
    			int rgb = col.getRGB();
    			img.setRGB(x, y, rgb);
    			currPixel++;
    		}
    	}
    	File f = new File("bin/" + fileName + ".png");
        ImageIO.write(img, "PNG", f);
        System.out.println("Complete.");
    }
}
