package raytracer;

import java.awt.Color;

public class Light {
	
	private Color col;
	private Vector dir;
	private String type;
	
	public Light(Color col, Vector dir, String type){
		this.col = col;
		this.dir = dir;
		if(isValidType(type)){
			this.type = type;
		}
	}
	
	private boolean isValidType(String type){
		if(type.toUpperCase().equals("POINT") || type.toUpperCase().equals("DIR")){
			return true;
		}
		return false;
	}
}
