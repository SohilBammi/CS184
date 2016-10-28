package raytracer;

public class Camera {
	Point UL;
	Point UR;
	Point LR;
	Point LL;
	double depth;
	int scale;
	private final int DEFAULT_SCALE = 2000;
	int width;
	int height;
	
	public Camera(Point UL, Point UR, Point LR, Point LL, int scale){
		this.UL = UL;
		this.UR = UR;
		this.LR = LR;
		this.LL = LL;
		this.depth = UL.z;
		this.scale = scale;
		this.width = (int) (this.UR.x - this.UL.x)*scale;
    	this.height = (int) (this.UR.y - this.LR.y)*scale;
	}
	
	public Camera(Point UL, Point UR, Point LR, Point LL){
		this.UL = UL;
		this.UR = UR;
		this.LR = LR;
		this.LL = LL;
		this.depth = UL.z;
		this.scale = DEFAULT_SCALE;
		this.width = (int) (this.UR.x - this.UL.x)*scale;
    	this.height = (int) (this.UR.y - this.LR.y)*scale;
	}
	
	public Point getPointByPixel(double x, double y){
		return new Point(UL.x + (x+1)/scale, UL.y - (y+1)/scale, depth);
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public int getHeight(){
		return this.width;
	}
}
