package raytracer;

import java.util.ArrayList;

public class Triangle implements Polygon{
    Point vertex1;
    Point vertex2;
    Point vertex3;
    Vector normalVec;
    Vector ka;
    Vector kd;
    Vector ks;
    double p;
    final Vector KA_DEFAULT = new Vector(0.5, 0.5, 0.5);
    final Vector KD_DEFAULT = new Vector(0.5, 0.5, 0.5);;
    final Vector KS_DEFAULT = new Vector(0.5, 0.5, 0.5);;
    final double P_DEFAULT = 10;
    
    public Triangle(){
        this.ka = KA_DEFAULT;
        this.kd = KD_DEFAULT;
        this.ks = KS_DEFAULT;
        this.p = P_DEFAULT;
    }
    
    public Triangle(Point vertex1, Point vertex2, Point vertex3){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        this.ka = KA_DEFAULT;
        this.kd = KD_DEFAULT;
        this.ks = KS_DEFAULT;
        this.p = P_DEFAULT;
    }
    
    public Triangle(Point vertex1, Point vertex2, Point vertex3, Vector ka, Vector kd, Vector ks, double p){
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
        return null;
    }
    
    public void translate(double x, double y, double z){
        //method stub
    }
    
    public boolean isIntersection(Ray r){
        return false;
    }
    
    
    public double getIntersection(Ray r){
        return -1;
    }
    
}
