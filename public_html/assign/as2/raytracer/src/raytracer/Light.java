package raytracer;

import java.awt.Color;

public class Light {
	
	private Vector col;
	private Vector vec;
	private String type;
	
	public Light(Vector col, Vector vec, String type){
		this.col = col;
		this.vec = vec;
		if(isValidType(type)){
			this.type = type.toUpperCase();
		}
	}
	
	private boolean isValidType(String type){
		if(type.toUpperCase().equals("POINT") || type.toUpperCase().equals("DIR")){
			return true;
		}
		return false;
	}
	
	public String getType(){
		return this.type;
	}
	
	public Vector getVec(){
		return this.vec;
	}
	
	public Vector getColor(){
		return this.col;
	}
	
}
