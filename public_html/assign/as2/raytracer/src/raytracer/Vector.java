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
	
	public Vector(Point start, Point end){
		this.x = end.x - start.x;
		this.y = end.y - start.y;
		this.z = end.z - start.z;
	}
	
	public Vector(){
	    this.x = 0;
	    this.y = 0;
	    this.z = 0;
	}
	
	public double magnitude(){
		return Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
	}
	
	public void normalize(){
		double scal = this.x*this.x + this.y*this.y +this.z*this.z;
		if(scal!=0) scal = 1 / Math.sqrt(scal);
		this.x = this.x * scal;
		this.y = this.y * scal;
		this.z = this.z * scal;
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
	
	public Vector mulComponents(Vector vec){
		Vector ret = new Vector();
	    ret.x = this.x * vec.x;
	    ret.y = this.y * vec.y;
	    ret.z = this.z * vec.z;
	    return ret;
	}
	
	public Vector divComponents(Vector vec){
		Vector ret = new Vector();
	    ret.x = this.x / vec.x;
	    ret.y = this.y / vec.y;
	    ret.z = this.z / vec.z;
	    return ret;
	}
	
	public void printVector(){
		System.out.println("("+this.x+", "+this.y+", "+this.z+")");
	}
}
