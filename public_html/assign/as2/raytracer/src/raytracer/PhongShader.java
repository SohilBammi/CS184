package raytracer;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;

public class PhongShader {
	ArrayList<Light> lights;
	Vector ka;
	Vector kd;
	Vector ks;
	double specCoef;
	
	public PhongShader(){
		this.lights = new ArrayList<Light>();
		this.ka = new Vector(0, 0, 0);
		this.kd = new Vector(0, 0, 0);
		this.ks = new Vector(0, 0, 0);
		this.specCoef = 0;
	}
	
	public PhongShader(ArrayList<Light> lights, Vector ka, Vector kd, Vector ks, double specCoef){
		this.lights = lights;
		this.ka = ka;
		this.kd = kd;
		this.ks = ks;
		this.specCoef = specCoef;
	}

	public Vector calcDiffuseTerm(Vector currLight, Vector normVec){
		return kd.mulScalar(Math.max(currLight.dotProduct(normVec), 0));
	}
	
	public Vector calcSpecularTerm(Vector currLight, Vector normVec, Vector viewVec){
		Vector rVec = calcRTerm(currLight, normVec);
		return ks.mulScalar(Math.pow(Math.max(rVec.dotProduct(viewVec), 0),specCoef));

	}
	
	public Vector calcRTerm(Vector currLight, Vector normVec){
		return currLight.mulScalar(-1).addVector(normVec.mulScalar(2 * currLight.dotProduct(normVec)));
	}

	public Color calcPixelRGB(Point p, Vector normVec, Vector viewVec, ArrayList<Polygon> polygons){
		Vector pixelRGB = ka;
		for(Light light : lights){
		    Ray r;
		    boolean isShadow = false;
		    if(light.getType().equals("DIR")){
		        r = new Ray(p, light.getVec());
		    }
		    else{
		        Vector dir = new Vector(p, light.getVec().toPoint());
		        dir.normalize();
		        r = new Ray(p, dir);
		    }
		    for(Polygon poly : polygons){
		        if(poly.isIntersection(r)){
		            isShadow = true;
		        }
		    }
		    if(!isShadow){
		        Vector currLightRGB = light.getColor();
	            Vector currLight;
	            if(light.getType().equals("POINT")){
	                Vector lightVec = light.getVec();
	                currLight = new Vector(lightVec.x - p.x, lightVec.y - p.y, lightVec.z - p.z);
	            }
	            else{
	                currLight = light.getVec().mulScalar(-1);
	            }
	            currLight.normalize();
	            Vector diffuseTerm = calcDiffuseTerm(currLight, normVec);
	            Vector specularTerm = calcSpecularTerm(currLight, normVec, viewVec);
	            Vector lightIntensityTerm = diffuseTerm.addVector(specularTerm);
	            pixelRGB = pixelRGB.addVector(currLightRGB.mulComponents(lightIntensityTerm));
		    }
		}
		float pixelRGBflx = round((float)pixelRGB.x, 0, 1);
		float pixelRGBfly = round((float)pixelRGB.y, 0, 1);
		float pixelRGBflz = round((float)pixelRGB.z, 0, 1);
		return new Color(pixelRGBflx, pixelRGBfly, pixelRGBflz);
	}
	
	public float round(float d, float min, float max) {
		if(d < min){
			return min;
		}
		if(d > max){
			return max;
		}
		return d;
    }
}
