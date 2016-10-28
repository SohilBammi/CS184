package raytracer;

import java.io.IOException;
import java.util.ArrayList;

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
        sphere1.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 2);
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        polygons.add(sphere1);
        Sphere sphere2 = new Sphere(new Point(1,1,1), 0.5);
        sphere2.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 2);
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
        sphere.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 2);
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
        sphere1.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 2);
        Sphere sphere2 = new Sphere(new Point(0.5, 0, 0), 0.5);
        sphere2.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 2);
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
        sphere1.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 2);
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        polygons.add(sphere1);
        Sphere sphere2 = new Sphere(new Point(1,1,1), 0.5);
        sphere2.setMaterial(new Vector(0, 0, 0), new Vector(0.5, 0.5, 0.5), new Vector(0.5,0.5,0.5), 2);
        polygons.add(sphere2);
        ArrayList<Light> lights = new ArrayList<Light>();
        Light dirL = new Light(new Vector(1, 1, 1), new Vector(-1, -1, -1), "DIR");
        lights.add(dirL);
        Light pointL = new Light(new Vector(1, 0, 0), new Vector(1, 0, 1), "POINT");
        lights.add(pointL);
        Scene scene = new Scene(eye, UL, UR, LR, LL, polygons, lights);
        scene.basicRayTrace(filename);
	}
	
	public static void main(String[] args) throws IOException {
        //renderSimpleSphereNoShading("basic-raytrace-no_shading");
		renderTwoSimpleSpheresNoShading("basic-raytrace-two_spheres_no_shading");
		//renderSimpleSphere("basic-raytrace-one_sphere");
		//renderTwoSimpleSpheres("basic-raytrace-two_spheres");
		renderTwoSpheresShadows("basic-raytrace-two_spheres_shadows");
    }
}
