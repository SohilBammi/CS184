package raytracer;

import java.awt.Color;
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

	public Color calcPixelRGB(Point p, Vector normVec, Vector viewVec){
		Vector pixelRGB = ka;
		for(Light light : lights){
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
			pixelRGB.addVector(currLightRGB.mulComponents(lightIntensityTerm));
		}
		return new Color((float)pixelRGB.x, (float)pixelRGB.y, (float)pixelRGB.z);
	}
}