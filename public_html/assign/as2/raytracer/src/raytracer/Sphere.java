package raytracer;

import java.util.ArrayList;

public class Sphere implements Polygon{
	Point center;
	double radius;
	Vector ka;
	Vector kd;
	Vector ks;
	double p;
	final Vector KA_DEFAULT = new Vector(0.5, 0.5, 0.5);
	final Vector KD_DEFAULT = new Vector(0.5, 0.5, 0.5);;
	final Vector KS_DEFAULT = new Vector(0.5, 0.5, 0.5);;
	final double P_DEFAULT = 10;
	
	public Sphere(){
		this.center = new Point(0, 0, 0);
		this.radius = 1;
		this.ka = KA_DEFAULT;
		this.kd = KD_DEFAULT;
		this.ks = KS_DEFAULT;
		this.p = P_DEFAULT;
	}
	
	public Sphere(Point center, double radius){
		this.center = center;
		this.radius = radius;
		this.ka = KA_DEFAULT;
		this.kd = KD_DEFAULT;
		this.ks = KS_DEFAULT;
		this.p = P_DEFAULT;
	}
	
	public Sphere(Point center, double radius, Vector ka, Vector kd, Vector ks, double p){
		this.center = center;
		this.radius = radius;
		this.ka = ka;
		this.kd = kd;
		this.ks = ks;
		this.p = p;
	}
	
	public void setMaterial(Vector ka, Vector kd, Vector ks, double p){
		this.ka = ka;
		this.kd = kd;
		this.ks = ks;
		this.p = p;
	}
	
	public Vector getKa() {
		return this.ka;
	}

	public Vector getKd() {
		return this.kd;
	}

	public Vector getKs() {
		return this.ks;
	}

	public double getP() {
		return this.p;
	}

	public Vector getNormalVector(Point p) {
		Vector normVec = new Vector(p.x-this.center.x, p.y-this.center.y, p.z-this.center.z);
		normVec.normalize();
		return normVec;
	}
	
	public void translate(double x, double y, double z){
		this.center.x = this.center.x + x;
		this.center.y = this.center.y + y;
		this.center.z = this.center.z + z;
	}
	
	public boolean isIntersection(Ray r){
		Vector e = new Vector(r.origin.x, r.origin.y, r.origin.z);
		Vector c = new Vector(this.center.x, this.center.y, this.center.z);
		Vector d = r.dir;
		double termA = d.dotProduct(d);
		double termB = d.mulScalar(2).dotProduct(e.subVector(c));
		double termC = (e.subVector(c)).dotProduct(e.subVector(c)) - radius*radius;
		double discriminant = termB*termB - 4*termA*termC;
		if(discriminant < 0){
			return false;
		}
		return true;
	}
	
	
	public double getIntersection(Ray r){
		Vector e = new Vector(r.origin.x, r.origin.y, r.origin.z);
		Vector c = new Vector(this.center.x, this.center.y, this.center.z);
		Vector d = r.dir;
		Vector eMinc = e.subVector(c);
		double dDotd = d.dotProduct(d);
		double numeratorTerm1 = -d.dotProduct(eMinc);
		double numeratorSqrtTerm1 = Math.pow(d.dotProduct(eMinc), 2);
		double numeratorSqrtTerm2 = -dDotd * (eMinc.dotProduct(eMinc) - radius*radius);
		double numeratorTerm2 = Math.sqrt(numeratorSqrtTerm1+numeratorSqrtTerm2);
		double t0 = (numeratorTerm1 + numeratorTerm2)/dDotd;
		double t1 = (numeratorTerm1 - numeratorTerm2)/dDotd;
		return Math.min(t0, t1);
	}
	
}
