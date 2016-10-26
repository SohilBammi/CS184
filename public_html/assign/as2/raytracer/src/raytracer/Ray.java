package raytracer;

public class Ray {
    Point origin;
    Vector dir;
    
    public Ray(Point eye, Vector dir){
        this.origin = eye;
        this.dir = dir;
    }
    
}
