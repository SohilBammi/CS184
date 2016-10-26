package raytracer;

public class Point {
	double x;
	double y;
	double z;
	
	public Point(double x, double y, double z){
	    this.x = x;
	    this.y = y;
	    this.z = z;
	}
	
	public Point(){
	    this.x = 0;
	    this.y = 0;
	    this.z = 0;
	}
	
	public void addPoint(Point p){
		this.x = this.x + p.x;
		this.y = this.y + p.y;
		this.z = this.z + p.z;
	}
	
	public void subPoint(Point p){
		this.x = this.x - p.x;
		this.y = this.y - p.y;
		this.z = this.z - p.z;
	}
	
	public double distance(Point a){
		return Math.sqrt(Math.pow(this.x-a.x, 2) + Math.pow(this.y-a.y, 2) + Math.pow(this.z-a.z, 2));
	}
	
	//Uses current point as start
	public Vector vector(Point a){
		return new Vector(a.x-this.x, a.y-this.y, a.z-this.z);
	}
}
