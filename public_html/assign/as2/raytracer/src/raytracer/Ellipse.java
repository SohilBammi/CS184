package raytracer;

import java.util.ArrayList;

public class Ellipse implements Polygon{
    Point center;
    double radius;
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
    Double[][] transformMatrix;
    boolean isTransformed;
    
    
    public Ellipse(){
        this.center = new Point(0, 0, 0);
        this.radius = 1;
        this.ka = KA_DEFAULT;
        this.kd = KD_DEFAULT;
        this.ks = KS_DEFAULT;
        this.kr = KR_DEFAULT;
        this.p = P_DEFAULT;
        this.isTransformed = false;
        this.transformMatrix = getIdentityMatrix();
    }
    
    public Ellipse(Point center, double radius){
        this.center = center;
        this.radius = radius;
        this.ka = KA_DEFAULT;
        this.kd = KD_DEFAULT;
        this.ks = KS_DEFAULT;
        this.kr = KR_DEFAULT;
        this.p = P_DEFAULT;
        this.isTransformed = false;
        this.transformMatrix = getIdentityMatrix();
        if(radius!=1)
            scale(radius, radius, radius);
        if(center.x!=0 || center.y!=0 ||center.z!=0)
            translate(center.x, center.y, center.z);
    }
    
    public Ellipse(Point center, double radius, Vector ka, Vector kd, Vector ks, double kr, double p){
        this.center = center;
        this.radius = radius;
        this.ka = ka;
        this.kd = kd;
        this.ks = ks;
        this.kr = kr;
        this.p = p;
        this.isTransformed = false;
        this.transformMatrix = getIdentityMatrix();
        if(radius!=1)
            scale(radius, radius, radius);
        if(center.x!=0 || center.y!=0 ||center.z!=0)
            translate(center.x, center.y, center.z);
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

    public Vector getNormalVector(Point p) {
        Double[][] transformMatrixInv = transformationMatrixInverse(transformMatrix);
        double unitSphereX = p.x * transformMatrixInv[0][0] + p.y *transformMatrixInv[0][1] +p.z * transformMatrixInv[0][2] + transformMatrixInv[0][3];
        double unitSphereY = p.x * transformMatrixInv[1][0] + p.y *transformMatrixInv[1][1] +p.z * transformMatrixInv[1][2] + transformMatrixInv[1][3];
        double unitSphereZ = p.x * transformMatrixInv[2][0] + p.y *transformMatrixInv[2][1] +p.z * transformMatrixInv[2][2] + transformMatrixInv[2][3];
        Point unitSphereP = new Point(unitSphereX, unitSphereY, unitSphereZ);
        Sphere sphere = new Sphere();
        Vector normVec = sphere.getNormalVector(unitSphereP);
        normVec.normalize();
        return normVec;
    }
    
    public void translate(double x, double y, double z){
        Double[][] tMatrix = {  {1.0, 0.0, 0.0, x  },
                                {0.0, 1.0, 0.0, y  },
                                {0.0, 0.0, 1.0, z  },
                                {0.0, 0.0, 0.0, 1.0}    };
        transform(tMatrix);
    }
    
    public void scale(double x, double y, double z){
        Double[][] sMatrix = {  {x, 0.0, 0.0, 0.0  },
                                {0.0, y, 0.0, 0.0  },
                                {0.0, 0.0, z, 0.0  },
                                {0.0, 0.0, 0.0, 1.0}    };
        transform(sMatrix);
    }
    
    public void rotate(double x, double y, double z){
        double cosx = Math.cos(x);
        double sinx = Math.sin(x);
        double cosy = Math.cos(y);
        double siny = Math.sin(y);
        double cosz = Math.cos(z);
        double sinz = Math.sin(z);
        
        Double[][] rxMatrix = { {1.0,  0.0,   0.0, 0.0},
                                {0.0, cosx, -sinx, 0.0},
                                {0.0, sinx,  cosx, 0.0},
                                {0.0,  0.0,   0.0, 1.0}    };
        
        Double[][] ryMatrix = { { cosy, 0.0, siny, 0.0},
                                {  0.0, 1.0,  0.0, 0.0},
                                {-siny, 0.0, cosy, 0.0},
                                {  0.0, 0.0,  0.0, 1.0}    };
        
        Double[][] rzMatrix = { {cosz, -sinz, 0.0, 0.0},
                                {sinz,  cosz, 0.0, 0.0},
                                { 0.0,   0.0, 1.0, 0.0},
                                { 0.0,   0.0, 0.0, 1.0}    };
        Double[][] rxyMatrix = matrixMultiply(rxMatrix, ryMatrix);
        Double[][] rxyzMatrix = matrixMultiply(rxyMatrix, rzMatrix);
        transform(rxyzMatrix);
    }
    
    
    private Double[][] matrixMultiply(Double[][] m1, Double[][] m2){
        int m = m1.length;
        int n = m1[0].length;
        int p = m2.length;
        int q = m2[0].length;
        
        Double[][] ret = new Double[m1.length][m1.length];
        double sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < q; j++) {
                for (int k = 0; k < p; k++) {
                    sum = sum + m1[i][k]*m2[k][j];
                }
                    ret[i][j] = sum;
                    sum = 0;
            }
        }
        return ret;
    }
    
    private Double[][] getIdentityMatrix(){
        Double[][] ret = {  {1.0, 0.0, 0.0, 0.0},
                            {0.0, 1.0, 0.0, 0.0},
                            {0.0, 0.0, 1.0, 0.0},
                            {0.0, 0.0, 0.0, 1.0}    };
        return ret;
    }
    
    private Double[][] transformationMatrixInverse(Double[][] m){
        Vector u = new Vector(m[0][0], m[1][0], m[2][0]);
        Vector v = new Vector(m[0][1], m[1][1], m[2][1]);
        Vector w = new Vector(m[0][2], m[1][2], m[2][2]);
        Vector t = new Vector(m[0][3], m[1][3], m[2][3]);
        
        Double[][] ret = {  {u.x, u.y, u.z, -u.dotProduct(t)},
                            {v.x, v.y, v.z, -v.dotProduct(t)},
                            {w.x, w.y, w.z, -w.dotProduct(t)},
                            {0.0, 0.0, 0.0, 1.0             }   };
        return ret;
    }
    
    private void transform(Double[][] m){
        if(isTransformed){
            this.transformMatrix = matrixMultiply(this.transformMatrix, m);
        }
        else{
            this.transformMatrix = m;
            isTransformed = true;
        }
    }
    
    private Ray transformRay(Ray r){
        Double[][] transformMatrixInv = transformationMatrixInverse(transformMatrix);
        double originX = r.origin.x * transformMatrixInv[0][0] + r.origin.y *transformMatrixInv[0][1] +r.origin.z * transformMatrixInv[0][2] + transformMatrixInv[0][3];
        double originY = r.origin.x * transformMatrixInv[1][0] + r.origin.y *transformMatrixInv[1][1] +r.origin.z * transformMatrixInv[1][2] + transformMatrixInv[1][3];
        double originZ = r.origin.x * transformMatrixInv[2][0] + r.origin.y *transformMatrixInv[2][1] +r.origin.z * transformMatrixInv[2][2] + transformMatrixInv[2][3];
        double dirX = r.dir.x * transformMatrixInv[0][0] + r.dir.y *transformMatrixInv[0][1] +r.dir.z * transformMatrixInv[0][2];
        double dirY = r.dir.x * transformMatrixInv[1][0] + r.dir.y *transformMatrixInv[1][1] +r.dir.z * transformMatrixInv[1][2];
        double dirZ = r.dir.x * transformMatrixInv[2][0] + r.dir.y *transformMatrixInv[2][1] +r.dir.z * transformMatrixInv[2][2];
        Point origin = new Point(originX, originY, originZ);
        Vector dir = new Vector(dirX, dirY, dirZ);
        return new Ray(origin, dir);
        
    }
    
    public boolean isIntersection(Ray r){
        r = transformRay(r);
        Sphere s = new Sphere();
        return s.isIntersection(r);
    }
    
    
    public double getIntersection(Ray r){
        r = transformRay(r);
        Sphere s = new Sphere();
        return s.getIntersection(r);
    }    
}
