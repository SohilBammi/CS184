package raytracer;

import java.util.ArrayList;

public interface Polygon {
	public boolean isValidPoint(Point p);
	public boolean hasPointAt(double x, double y);
	public ArrayList<Double> getZCoordinates(double x, double y);
	public ArrayList<Point> getPoints(double x, double y);
	public Point getFrontPoint(double x, double y);
	public Vector getNormalVector(Point p);
}
