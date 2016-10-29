package raytracer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DrawImages {
	
	public static void renderSimpleSphereNoShading(String filename) throws IOException{
		Point eye = new Point(0, 0, 0);
        Point UL = new Point(-1, 1, -1);
        Point UR = new Point(1, 1, -1);
        Point LR = new Point(1, -1, -1);
        Point LL = new Point(-1, -1, -1);
        Sphere sphere = new Sphere(new Point(0, 0, -2), 1);
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        polygons.add(sphere);
        ArrayList<Light> lights = new ArrayList<Light>();
        Scene scene = new Scene(eye, UL, UR, LR, LL, polygons, lights);
        scene.basicRayTraceNoShading(filename);
	}
	
	public static void renderTwoSimpleSpheresNoShading(String filename) throws IOException{
		Point eye = new Point(0, 0, 4);
        Point UL = new Point(-1, 1, 3);
        Point UR = new Point(1, 1, 3);
        Point LR = new Point(1, -1, 3);
        Point LL = new Point(-1, -1, 3);
        Sphere sphere1 = new Sphere();
        sphere1.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 1, 2);
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        polygons.add(sphere1);
        Sphere sphere2 = new Sphere(new Point(1,1,1), 0.5);
        sphere2.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 1, 2);
        polygons.add(sphere2);
        ArrayList<Light> lights = new ArrayList<Light>();
        Light dirL = new Light(new Vector(1, 1, 1), new Vector(-1, -1, -1), "DIR");
        lights.add(dirL);
        Light pointL = new Light(new Vector(1, 0, 0), new Vector(1, 0, 1), "POINT");
        lights.add(pointL);
        Scene scene = new Scene(eye, UL, UR, LR, LL, polygons, lights);
        scene.basicRayTraceNoShading(filename);
	}
	
	public static void renderSimpleSphere(String filename) throws IOException{
		Point eye = new Point(0, 0, 3);
        Point UL = new Point(-1, 1, 2);
        Point UR = new Point(1, 1, 2);
        Point LR = new Point(1, -1, 2);
        Point LL = new Point(-1, -1, 2);
        Sphere sphere = new Sphere();
        sphere.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 1, 2);
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        polygons.add(sphere);
        ArrayList<Light> lights = new ArrayList<Light>();
        Light dirL = new Light(new Vector(1, 1, 1), new Vector(-1, -1, -1), "DIR");
        lights.add(dirL);
        Light pointL = new Light(new Vector(1, 0, 0), new Vector(1, 0, 1), "POINT");
        lights.add(pointL);
        Scene scene = new Scene(eye, UL, UR, LR, LL, polygons, lights);
        scene.basicRayTrace(filename);
	}
	
	public static void renderTwoSimpleSpheres(String filename) throws IOException{
	    Point eye = new Point(0, 0, 3);
        Point UL = new Point(-1, 1, 2);
        Point UR = new Point(1, 1, 2);
        Point LR = new Point(1, -1, 2);
        Point LL = new Point(-1, -1, 2);
        Sphere sphere1 = new Sphere(new Point(-0.5, 0, 0), 0.5);
        sphere1.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 1, 2);
        Sphere sphere2 = new Sphere(new Point(0.5, 0, 0), 0.5);
        sphere2.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 1, 2);
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        polygons.add(sphere1);
        polygons.add(sphere2);
        ArrayList<Light> lights = new ArrayList<Light>();
        Light dirL = new Light(new Vector(1, 1, 1), new Vector(-1, -1, -1), "DIR");
        lights.add(dirL);
        Light pointL = new Light(new Vector(1, 0, 0), new Vector(1, 0, 1), "POINT");
        lights.add(pointL);
        Scene scene = new Scene(eye, UL, UR, LR, LL, polygons, lights);
        scene.basicRayTrace(filename);
	}
	
	public static void renderTwoSpheresShadows(String filename) throws IOException{
		Point eye = new Point(0, 0, 4);
        Point UL = new Point(-1, 1, 3);
        Point UR = new Point(1, 1, 3);
        Point LR = new Point(1, -1, 3);
        Point LL = new Point(-1, -1, 3);
        Sphere sphere1 = new Sphere();
        sphere1.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 1, 2);
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        polygons.add(sphere1);
        Sphere sphere2 = new Sphere(new Point(1,1,1), 0.5);
        sphere2.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 1, 2);
        polygons.add(sphere2);
        ArrayList<Light> lights = new ArrayList<Light>();
        Light dirL = new Light(new Vector(1, 1, 1), new Vector(1, 1, 1), "DIR");
        lights.add(dirL);
        Light pointL = new Light(new Vector(1, 0, 0), new Vector(1, 0, 1), "POINT");
        lights.add(pointL);
        Scene scene = new Scene(eye, UL, UR, LR, LL, polygons, lights);
        scene.basicRayTrace(filename);
	}
	
	public static void renderSimpleEllipseNoShading(String filename) throws IOException{
        Point eye = new Point(0, 0, 0);
        Point UL = new Point(-1, 1, -1);
        Point UR = new Point(1, 1, -1);
        Point LR = new Point(1, -1, -1);
        Point LL = new Point(-1, -1, -1);
        Ellipse ellipse = new Ellipse(new Point(0, 0, -2), 1);
        ellipse.scale(1, 2, 1);
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        polygons.add(ellipse);
        ArrayList<Light> lights = new ArrayList<Light>();
        Scene scene = new Scene(eye, UL, UR, LR, LL, polygons, lights);
        scene.basicRayTraceNoShading(filename);
    }
	
	public static void renderSimpleEllipse(String filename) throws IOException{
	    Point eye = new Point(0, 0, 3);
        Point UL = new Point(-1, 1, 2);
        Point UR = new Point(1, 1, 2);
        Point LR = new Point(1, -1, 2);
        Point LL = new Point(-1, -1, 2);
        Ellipse ellipse = new Ellipse();
        ellipse.scale(1, 2, 1);
        ellipse.translate(0, 1, 0);
        ellipse.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 1, 2);
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        polygons.add(ellipse);
        ArrayList<Light> lights = new ArrayList<Light>();
        Light dirL = new Light(new Vector(1, 1, 1), new Vector(-1, -1, -1), "DIR");
        lights.add(dirL);
        Light pointL = new Light(new Vector(1, 0, 0), new Vector(1, 0, 1), "POINT");
        lights.add(pointL);
        Scene scene = new Scene(eye, UL, UR, LR, LL, polygons, lights);
        scene.basicRayTrace(filename);
    }
	
	public static void renderSimpleTriangleNoShading(String filename) throws IOException{
        Point eye = new Point(0, 0, 1);
        Point UL = new Point(-3, 3, -1);
        Point UR = new Point(3, 3, -1);
        Point LR = new Point(3, -3, -1);
        Point LL = new Point(-3, -3, -1);
        Triangle triangle = new Triangle();
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        polygons.add(triangle);
        ArrayList<Light> lights = new ArrayList<Light>();
        Scene scene = new Scene(eye, UL, UR, LR, LL, polygons, lights);
        scene.basicRayTraceNoShading(filename);
    }
	
	public static void renderComplexTriangleNoShading(String filename) throws IOException{
        Point eye = new Point(0, 0, 1);
        Point UL = new Point(-3, 3, -1);
        Point UR = new Point(3, 3, -1);
        Point LR = new Point(3, -3, -1);
        Point LL = new Point(-3, -3, -1);
        Triangle triangle = new Triangle();
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        polygons.add(triangle);
        ArrayList<Light> lights = new ArrayList<Light>();
        Scene scene = new Scene(eye, UL, UR, LR, LL, polygons, lights);
        scene.basicRayTraceNoShading(filename);
    }
	
	public static void renderSimpleTriangle(String filename) throws IOException{
		Point eye = new Point( 0,  0,  0);
		Point LL  = new Point(-1,  -1,  -3);
		Point LR  = new Point( 1,  -1, -3);
		Point UR  = new Point( 1, 1, -3);
		Point UL  = new Point(-1, 1, -3);
        Triangle triangle = new Triangle(new Point(5,5,-17), new Point(1,4,-20), new Point(6,-1,-20));
        triangle.setMaterial(new Vector(0.1, 0.1, 0.1), new Vector(0.1, 0.1, 0.1), new Vector(1, 1, 1), 1, 2);
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        polygons.add(triangle);
        ArrayList<Light> lights = new ArrayList<Light>();
        Light dirL1 = new Light(new Vector(1, 1, 1), new Vector(0.57735027, -0.57735027, -0.57735027), "DIR");
        lights.add(dirL1);
        Light dirL2 = new Light(new Vector(0, 0, 1), new Vector(0.57735027, 0.57735027, -0.57735027), "DIR");
        lights.add(dirL2);
        Scene scene = new Scene(eye, UL, UR, LR, LL, polygons, lights);
        scene.basicRayTrace(filename);
    }
	
	public static void renderSimpleScene(String filename) throws IOException{
		Point eye = new Point( 0,  0,  0);
		Point LL  = new Point(-1,  -1,  -3);
		Point LR  = new Point( 1,  -1, -3);
		Point UR  = new Point( 1, 1, -3);
		Point UL  = new Point(-1, 1, -3);
        Triangle triangle = new Triangle(new Point(5,5,-17), new Point(1,4,-20), new Point(6,-1,-20));
        triangle.setMaterial(new Vector(0.1, 0.1, 0.1), new Vector(0.1, 0.1, 0.1), new Vector(1, 1, 1), 1, 2);
        Ellipse ellipse1 = new Ellipse(new Point(0, 0, -20), 1);
        ellipse1.translate(0, 0, -10);
        ellipse1.setMaterial(new Vector(0.1, 0.1, 0.1), new Vector(1, 0, 1), new Vector(1, 1, 1), 0, 50);
        Ellipse ellipse2 = new Ellipse(new Point(-2, 2, -15), 1);
        ellipse2.setMaterial(new Vector(0.1, 0.1, 0.1), new Vector(1, 1, 0), new Vector(1, 1, 1), 0, 50);
        Ellipse ellipse3 = new Ellipse(new Point(-2, -2, -15), 1);
        ellipse3.setMaterial(new Vector(0.1, 0.1, 0.1), new Vector(0, 1, 1), new Vector(1, 1, 1), 0, 50);
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        polygons.add(triangle);
        polygons.add(ellipse1);
        polygons.add(ellipse2);
        polygons.add(ellipse3);
        ArrayList<Light> lights = new ArrayList<Light>();
        Light dirL1 = new Light(new Vector(1, 1, 1), new Vector(0.57735027, -0.57735027, -0.57735027), "DIR");
        lights.add(dirL1);
        Light dirL2 = new Light(new Vector(0, 0, 1), new Vector(0.57735027, 0.57735027, -0.57735027), "DIR");
        lights.add(dirL2);
        Scene scene = new Scene(eye, UL, UR, LR, LL, polygons, lights);
        scene.basicRayTrace(filename);
    }
	
	public static void main(String[] args) throws IOException {
	    System.out.println("Would you like to render sample images? (y/n)");
	    Scanner sc = new Scanner(System.in);
	    String renderSampleImgs = sc.nextLine();
	    if(renderSampleImgs.toUpperCase().equals("Y") || renderSampleImgs.toUpperCase().equals("N")){
	        if(renderSampleImgs.toUpperCase().equals("Y")){
    	        renderSimpleSphereNoShading("basic-raytrace-no_shading");
    	        renderTwoSimpleSpheresNoShading("basic-raytrace-two_spheres_no_shading");
    	        renderSimpleSphere("basic-raytrace-one_sphere");
    	        renderTwoSimpleSpheres("basic-raytrace-two_spheres");
    	        renderTwoSpheresShadows("basic-raytrace-two_spheres_shadows");
    	        renderSimpleTriangleNoShading("basic-raytrace-triangle-no_shading");
    	        renderSimpleTriangle("basic-raytrace-triangle");
    	        renderSimpleEllipseNoShading("basic-raytrace-ellipse-no_shading");
    	        renderSimpleEllipse("basic-raytrace-ellipse");
	        }
	        System.out.println("Input File Path: ");
	        String filename = sc.nextLine();
	        ArrayList<Polygon> polys = new ArrayList<Polygon>();
	        Point eye = new Point( 0,  0,  0);
			Point LL  = new Point(-1,  -1,  -3);
			Point LR  = new Point( 1,  -1, -3);
			Point UR  = new Point( 1, 1, -3);
			Point UL  = new Point(-1, 1, -3);
	        ArrayList<Light> lights = new ArrayList<Light>();
	        for(String line: Files.readAllLines(Paths.get("bin/input/"+filename))){
	        	String[] words = line.split(" ");
	        	if(words[0].equals("cam")){
	        		eye = new Point(Double.parseDouble(words[1]),  Double.parseDouble(words[2]),  Double.parseDouble(words[3]));
	        		LL  = new Point(Double.parseDouble(words[4]),  Double.parseDouble(words[5]),  Double.parseDouble(words[6]));
	        		LR  = new Point(Double.parseDouble(words[7]),  Double.parseDouble(words[8]),  Double.parseDouble(words[9]));
	        		UL  = new Point(Double.parseDouble(words[10]),  Double.parseDouble(words[11]),  Double.parseDouble(words[12]));
	        		UR  = new Point(Double.parseDouble(words[13]),  Double.parseDouble(words[14]),  Double.parseDouble(words[15]));
	        	}
	        	else if(words[0].equals("sph")){
	        		Ellipse sph = new Ellipse(new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), Double.parseDouble(words[4]));
	        		polys.add(sph);
	        	}
	        	else if(words[0].equals("tri")){
	        		Point triX = new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3]));
	        		Point triY = new Point(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6]));
	        		Point triZ = new Point(Double.parseDouble(words[7]), Double.parseDouble(words[8]), Double.parseDouble(words[9]));
	        		Triangle tri = new Triangle(triX, triY, triZ);
	        		polys.add(tri);
	        	}
	        	else if(words[0].equals("obj")){
	        		BufferedReader br = new BufferedReader(new FileReader("bin/input/"+filename));
	        		ObjParser objp = new ObjParser("bin/input/"+filename);
	        		ArrayList<Triangle> tr = objp.triangles;
	        		for(Triangle tri: tr){
	        			polys.add(tri);
	        		}
	        	}
	        	else if(words[0].equals("ltp")){
	        		double r = Double.parseDouble(words[4]);
	        		double g = Double.parseDouble(words[5]);
	        		double b = Double.parseDouble(words[6]);
	        		double x = Double.parseDouble(words[1]);
	        		double y = Double.parseDouble(words[2]);
	        		double z = Double.parseDouble(words[3]);
	        		Light l = new Light(new Vector(r, g, b), new Vector(x, y, z), "POINT");
	        		lights.add(l);
	        	}
	        	else if(words[0].equals("ltd")){
	        		double r = Double.parseDouble(words[4]);
	        		double g = Double.parseDouble(words[5]);
	        		double b = Double.parseDouble(words[6]);
	        		double x = Double.parseDouble(words[1]);
	        		double y = Double.parseDouble(words[2]);
	        		double z = Double.parseDouble(words[3]);
	        		Light l = new Light(new Vector(r, g, b), new Vector(x, y, z), "DIR");
	        		lights.add(l);
	        	}
	        	else if(words[0].equals("mat")){
	        		Polygon currPoly = polys.get(polys.size()-1);
	        		polys.remove(polys.size()-1);
	        		Vector ka = new Vector(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3]));
	        		Vector kd = new Vector(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6]));
	        		Vector ks = new Vector(Double.parseDouble(words[7]), Double.parseDouble(words[8]), Double.parseDouble(words[9]));
	        		Vector kr = new Vector(Double.parseDouble(words[10]), Double.parseDouble(words[11]), Double.parseDouble(words[12]));
	        		currPoly.setMaterial(ka, kd, ks, kr.x, 10.0);
	        		polys.add(currPoly);
	        	}
	        	else if(words[0].equals("xft")){
	        		Polygon currPoly = polys.get(polys.size()-1);
	        		polys.remove(polys.size()-1);
	        		double x = Double.parseDouble(words[1]);
	        		double y = Double.parseDouble(words[2]);
	        		double z = Double.parseDouble(words[3]);
	        		currPoly.translate(x, y, z);
	        		polys.add(currPoly);
	        	}
	        	else if(words[0].equals("xfr")){
	        		Polygon currPoly = polys.get(polys.size()-1);
	        		polys.remove(polys.size()-1);
	        		double x = Double.parseDouble(words[1]);
	        		double y = Double.parseDouble(words[2]);
	        		double z = Double.parseDouble(words[3]);
	        		currPoly.rotate(x, y, z);
	        		polys.add(currPoly);
	        	}
	        	else if(words[0].equals("xfs")){
	        		Polygon currPoly = polys.get(polys.size()-1);
	        		polys.remove(polys.size()-1);
	        		double x = Double.parseDouble(words[1]);
	        		double y = Double.parseDouble(words[2]);
	        		double z = Double.parseDouble(words[3]);
	        		currPoly.scale(x, y, z);
	        		polys.add(currPoly);
	        	}
	        }
	        Scene scene = new Scene(eye, UL, UR, LR, LL, polys, lights);
	        scene.basicRayTrace(filename);
	    }
	    else{
	        System.out.println("Invalid Input");
	    }
	    sc.close();
    }
}
