package raytracer;

import java.util.ArrayList;

public class Sphere implements Polygon{
	Point center;
	double radius;
	
	public Sphere(){
		this.center = new Point(0, 0, 0);
		this.radius = 1;
	}
	
	public Sphere(Point center, double radius){
		this.center = center;
		this.radius = radius;
	}
	
	public ArrayList<Double> getZCoordinates(double x, double y) {
		ArrayList<Double> ret = new ArrayList<Double>();
		double xVal = x-this.center.x;
		double yVal = y-this.center.y;
		double zValSquare = (radius*radius)-((xVal*xVal)+(yVal*yVal));
		if(zValSquare < 0) zValSquare = -zValSquare;
		double zVal = Math.sqrt(zValSquare);
		double z = zVal - this.center.z;
		ret.add(z);
		if(z!=0) ret.add(-z);
		return ret;
	}

	public Point getFrontPoint(double x, double y) {
		ArrayList<Double> ZCoordList = getZCoordinates(x, y);
		double z = ZCoordList.get(0);
		return new Point(x, y, z);
	}

	public Vector getNormalVector(Point p) {
		Vector normVec = new Vector(p.x-this.center.x, p.y-this.center.y, p.z-this.center.z);
		normVec.normalize();
		return normVec;
	}

	public boolean isValidPoint(Point p) {
		double xVal = p.x - this.center.x;
		double yVal = p.y - this.center.y;
		double zVal = p.z - this.center.z;
		double calcRadius = Math.sqrt(xVal * xVal + yVal * yVal + zVal * zVal);
		if(calcRadius == radius) return true;
		return false;
	}

	public boolean hasPointAt(double x, double y) {
		double xBoundLeft = this.center.x - radius;
		double xBoundRight = this.center.x + radius;
		double yBoundDown = this.center.y - radius;
		double yBoundUp = this.center.y + radius;
		if((x >= xBoundLeft && x <= xBoundRight) && (y >= yBoundDown && y <= yBoundUp)) return true;
		return false;
	}

	public ArrayList<Point> getPoints(double x, double y) {
		ArrayList<Point> ret = new ArrayList<Point>();
		if(hasPointAt(x, y)){
			ArrayList<Double> ZCoordList = getZCoordinates(x, y);
			for(double z : ZCoordList){
				ret.add(new Point(x, y, z));
			}		
		}
		return ret;
	}
	
	public boolean isIntersection(Ray r){
	    return false;
	}
	
}
