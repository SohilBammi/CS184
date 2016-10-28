package raytracer;

import java.util.ArrayList;

public class Triangle implements Polygon {
    Point vertex1;
    Point vertex2;
    Point vertex3;
    Vector normalVec;
    Vector ka;
    Vector kd;
    Vector ks;
    double kr;
    double p;
    final Vector KA_DEFAULT = new Vector(0.5, 0.5, 0.5);
    final Vector KD_DEFAULT = new Vector(0.5, 0.5, 0.5);
    final Vector KS_DEFAULT = new Vector(0.5, 0.5, 0.5);
    final double KR_DEFAULT = 1;
    final double P_DEFAULT = 10;
    
    public Triangle(){
        this.ka = KA_DEFAULT;
        this.kd = KD_DEFAULT;
        this.ks = KS_DEFAULT;
        this.kr = KR_DEFAULT;
        this.p = P_DEFAULT;
        setNormalVector();
    }
    
    public Triangle(Point vertex1, Point vertex2, Point vertex3){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        this.ka = KA_DEFAULT;
        this.kd = KD_DEFAULT;
        this.ks = KS_DEFAULT;
        this.kr = KR_DEFAULT;
        this.p = P_DEFAULT;
        setNormalVector();
    }
    
    public Triangle(Point vertex1, Point vertex2, Point vertex3, Vector ka, Vector kd, Vector ks, double kr, double p){
        this.ka = ka;
        this.kd = kd;
        this.ks = ks;
        this.kr = kr;
        this.p = p;
        setNormalVector();
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
    
    public double getKr(){
        return this.kr;
    }

    public double getP() {
        return this.p;
    }
    
    public void setNormalVector() {
        Vector v1 = new Vector(this.vertex1, this.vertex2);
        Vector v2 = new Vector(this.vertex1, this.vertex3);
        this.normalVec =  v1.crossProduct(v2);
    }

    public double getNormalVectorAlpha(Point p) {
        double term1 = p.y - p.x;
        double term2 = p.z - p.x;
        return term1*term2;
    }

    public double calcM(Ray r) {
        Vector dir = r.getDir();
        double a = vertex1.x - vertex2.x;
        double b = vertex1.y - vertex2.y;
        double c = vertex1.z - vertex2.z;
        double d = vertex1.x - vertex3.x;
        double e = vertex1.y - vertex3.y;
        double f = vertex1.z - vertex3.z;
        double g = dir.x;
        double h = dir.y;
        double i = dir.z;
        double term1 = a*(e*i - h*f);
        double term2 = b*(g*f - d*i);
        double term3 = c*(d*h - e*g);

        return term1+term2+term3;
    }

    public double calcBeta(Ray r) {
        Vector dir = r.getDir();
        double a = vertex1.x - vertex2.x;
        double b = vertex1.y - vertex2.y;
        double c = vertex1.z - vertex2.z;
        double d = vertex1.x - vertex3.x;
        double e = vertex1.y - vertex3.y;
        double f = vertex1.z - vertex3.z;
        double g = dir.x;
        double h = dir.y;
        double i = dir.z;
        double j = vertex1.x - dir.x;
        double k = vertex1.y - dir.y;
        double l = vertex1.z - dir.z;
        double m = calcM(r);
        double term1 = j*(e*i - h*f);
        double term2 = k*(g*f - d*i);
        double term3 = l*(d*h - e*g);   

        return (term1+term2+term3)/m;
    }

    public double calcGamma(Ray r) {
        Vector dir = r.getDir();
        double a = vertex1.x - vertex2.x;
        double b = vertex1.y - vertex2.y;
        double c = vertex1.z - vertex2.z;
        double d = vertex1.x - vertex3.x;
        double e = vertex1.y - vertex3.y;
        double f = vertex1.z - vertex3.z;
        double g = dir.x;
        double h = dir.y;
        double i = dir.z;
        double j = vertex1.x - dir.x;
        double k = vertex1.y - dir.y;
        double l = vertex1.z - dir.z;
        double m = calcM(r);
        double term1 = i*(a*k - j*b);
        double term2 = h*(j*c - a*l);
        double term3 = g*(b*l - k*c);      

        return (term1+term2+term3)/m;
    }
    
    public void translate(double x, double y, double z){
        this.vertex1.x = this.vertex1.x + x;
        this.vertex1.y = this.vertex1.y + y;
        this.vertex1.z = this.vertex1.z + z;
        
        this.vertex2.x = this.vertex2.x + x;
        this.vertex2.y = this.vertex2.y + y;
        this.vertex2.z = this.vertex2.z + z;
        
        this.vertex3.x = this.vertex3.x + x;
        this.vertex3.y = this.vertex3.y + y;
        this.vertex3.z = this.vertex3.z + z;
    }
    
    public boolean isIntersection(Ray r){
        double beta = calcBeta(r);
        double gamma = calcGamma(r);
        if (beta > 0 && gamma > 0 && gamma+beta > 1) {
            return true;
        }
        return false;
    }

    public double getIntersection(Ray r) {
        Point p1 = vertex1;
        Vector term1 = p1.vector(r.origin);
        double term2 = r.dir.dotProduct(normalVec);
        return (term1.dotProduct(normalVec))/term2;
    }

    public Vector getNormalVector(Point p) {
        return this.normalVec;
    }
}