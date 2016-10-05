package raytracer;

public class Vector {
	double x;
	double y;
	double z;
	
	public Vector(double x, double y, double z){
	    this.x = x;
	    this.y = y;
	    this.z = z;
	}
	
	public Vector(){
	    this.x = 0;
	    this.y = 0;
	    this.z = 0;
	}
	
	public double dotProduct(Vector vec){
	    return this.x*vec.x + this.y*vec.y + this.z*vec.z;
	}
	
	public Vector crossProduct(Vector vec){
	    Vector ret = new Vector();
	    ret.x = this.y*vec.z - this.z*vec.y;
	    ret.y = this.z*vec.x - this.x*vec.z;
	    ret.z = this.x*vec.y - this.y*vec.x;
	    return ret;
	}
	
	public Vector addVector(Vector vec){
	    Vector ret = new Vector();
	    ret.x = this.x + vec.x;
	    ret.y = this.y + vec.y;
	    ret.z = this.z + vec.z;
	    return ret;
	}
	
	public Vector subVector(Vector vec){
	    Vector ret = new Vector();
	    ret.x = this.x - vec.x;
	    ret.y = this.y - vec.y;
	    ret.z = this.z - vec.z;
	    return ret;
	}
	
	public Vector mulScalar(double scal){
	    Vector ret = new Vector();
	    ret.x = this.x * scal;
	    ret.y = this.y * scal;
	    ret.z = this.z * scal;
	    return ret;
	}
	
	public Vector divScalar(double scal){
	    Vector ret = new Vector();
	    ret.x = this.x / scal;
	    ret.y = this.y / scal;
	    ret.z = this.z / scal;
	    return ret;
	}
	
	public void printVector(){
		System.out.println("("+this.x+", "+this.y+", "+this.z+")");
	}
}
