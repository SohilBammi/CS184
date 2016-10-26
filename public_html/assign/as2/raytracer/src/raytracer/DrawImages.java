package raytracer;

import java.io.IOException;
import java.util.ArrayList;

public class DrawImages {
	
	public static void renderSimpleSphereNoShading() throws IOException{
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
        scene.basicRayTraceNoShading();
	}
	
	public static void renderSimpleSphere() throws IOException{
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
        scene.basicRayTrace();
	}
	
	public static void main(String[] args) throws IOException {
        //renderSimpleSphereNoShading();
		renderSimpleSphere();
    }
}
