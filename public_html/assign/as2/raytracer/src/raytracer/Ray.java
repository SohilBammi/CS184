package raytracer;

public class Ray {
    Point origin;
    Vector dir;
    
    public Ray(Point eye, Vector dir){
        this.origin = eye;
        this.dir = dir;
    }
    
    public Point getPoint(double t){
    	Vector distance = this.dir.mulScalar(t);
    	Point dist = new Point(distance.x, distance.y, distance.z);
    	dist.addPoint(this.origin);
    	return dist;
    }
    
    public Vector getDir(){
    	return this.dir;
    }
    
}
