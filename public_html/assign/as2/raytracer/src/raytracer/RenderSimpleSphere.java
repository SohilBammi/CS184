package raytracer;

import java.io.IOException;
import java.util.ArrayList;

public class RenderSimpleSphere {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
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

}
