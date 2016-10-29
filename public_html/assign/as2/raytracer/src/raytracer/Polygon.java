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
	public Ray getNewRay(Ray r);
	public void setMaterial(Vector ka, Vector kd, Vector ks, double kr, double p);
	public void translate(double x, double y, double z);
	public void scale(double x, double y, double z);
	public void rotate(double x, double y, double z);
}