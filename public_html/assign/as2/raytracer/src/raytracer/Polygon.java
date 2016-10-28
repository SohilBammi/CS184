package raytracer;

import java.util.ArrayList;

public interface Polygon {
	public Vector getKa();
	public Vector getKd();
	public Vector getKs();
	public double getKr();
	public double getP();
	public Vector getNormalVector(Point p);
	public boolean isIntersection(Ray r);
	public double getIntersection(Ray r);
}