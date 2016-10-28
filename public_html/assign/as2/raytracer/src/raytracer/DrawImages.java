package raytracer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
        Light dirL = new Light(new Vector(1, 1, 1), new Vector(-1, -1, -1), "DIR");
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
        ellipse.rotate(45, 45, 45);
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
	    Point eye = new Point(0, 0, 3);
        Point UL = new Point(-1, 1, 2);
        Point UR = new Point(1, 1, 2);
        Point LR = new Point(1, -1, 2);
        Point LL = new Point(-1, -1, 2);
        Triangle triangle = new Triangle();
        triangle.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 1, 2);
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        polygons.add(triangle);
        ArrayList<Light> lights = new ArrayList<Light>();
        Light dirL = new Light(new Vector(1, 1, 1), new Vector(-1, -1, -1), "DIR");
        lights.add(dirL);
        Light pointL = new Light(new Vector(1, 0, 0), new Vector(1, 0, 1), "POINT");
        lights.add(pointL);
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
	        BufferedReader br = new BufferedReader(new FileReader(filename));
            while (br.readLine() != null) {
                System.out.println(br.readLine());
            }
	        br.close();
	    }
	    else{
	        System.out.println("Invalid Input");
	    }
	    sc.close();
    }
}
