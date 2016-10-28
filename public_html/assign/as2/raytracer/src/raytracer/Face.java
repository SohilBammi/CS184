package raytracer;

import java.util.ArrayList;

public class Face implements Polygon{
    ArrayList<Point> vertices;
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
    
    public Face(){
        this.ka = KA_DEFAULT;
        this.kd = KD_DEFAULT;
        this.ks = KS_DEFAULT;
        this.kr = KR_DEFAULT;
        this.p = P_DEFAULT;
        setNormalVector(vertices.get(0), vertices.get(1), vertices.get(2));
    }
    
    public Face(ArrayList<Point> vertices){
        this.vertices = vertices;
        this.ka = KA_DEFAULT;
        this.kd = KD_DEFAULT;
        this.ks = KS_DEFAULT;
        this.kr = KR_DEFAULT;
        this.p = P_DEFAULT;
        setNormalVector(vertices.get(0), vertices.get(1), vertices.get(2));
    }
    
    public Face(ArrayList<Point> vertices, Vector ka, Vector kd, Vector ks, double kr, double p){
        this.vertices = vertices;
        this.ka = ka;
        this.kd = kd;
        this.ks = ks;
        this.kr = kr;
        this.p = p;
        setNormalVector(vertices.get(0), vertices.get(1), vertices.get(2));
    }
    
    public void setMaterial(Vector ka, Vector kd, Vector ks, double kr, double p){
        this.ka = ka;
        this.kd = kd;
        this.ks = ks;
        this.kr = kr;
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
    
    public double getKr() {
        return this.kr;
    }

    public double getP() {
        return this.p;
    }

    public void setNormalVector(Point p1, Point p2, Point p3) {
        Vector v1 = new Vector(p1, p2);
        Vector v2 = new Vector(p1, p3);
        this.normalVec =  v1.crossProduct(v2);
    }
    
    public void translate(double x, double y, double z){
        ArrayList<Point> ret = new ArrayList<Point>();
        for(Point vertex : vertices){
            vertex.x = vertex.x + x;
            vertex.y = vertex.y + y;
            vertex.z = vertex.z + z;
            ret.add(vertex);
        }
        this.vertices = ret;
    }
    
    public boolean isIntersection(Ray r){
        return false;
    }
    
    public double getIntersection(Ray r){
        Point p1 = vertices.get(0);
        Vector term1 = p1.vector(r.origin);
        double term2 = r.dir.dotProduct(normalVec);
        return (term1.dotProduct(normalVec))/term2;
    }

    public Vector getNormalVector(Point p) {
        return this.normalVec;
    }
}
