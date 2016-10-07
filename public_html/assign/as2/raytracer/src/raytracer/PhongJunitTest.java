package raytracer;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;

public class PhongJunitTest {
	private PhongShader phongNoParams;
	private PhongShader phongSimpleParams1;
	private Light dirLSimple1;
	private Light pointLSimple1;
	private Vector kaSimple1;
	private Vector kdSimple1;
	private Vector ksSimple1;
	private double specCoefSimple1;
	
	@Before
    public void setUp() {
        phongNoParams = new PhongShader();
        dirLSimple1 = new Light(new Vector(1, 1, 1), new Vector(-1, -1, -1), "DIR");
        pointLSimple1 = new Light(new Vector(1, 0, 0), new Vector(1, 0, 1), "POINT");
        ArrayList<Light> lights = new ArrayList<Light>();
        lights.add(dirLSimple1);
        lights.add(pointLSimple1);
        kaSimple1 = new Vector(0, 0, 0);
        kdSimple1 = new Vector(0.5, 0.5, 0.5);
        ksSimple1 = new Vector(0.5, 0.5, 0.5);
        specCoefSimple1 = 2;
        phongSimpleParams1 = new PhongShader(lights, kaSimple1, kdSimple1, ksSimple1, specCoefSimple1);
	}
	
	/*****Test Naming Convention: [UnitOfWork_StateUnderTest_ExpectedBehavior]*****/
	@Test
	public void NewPhong_NoParameters_Instantiated() {
		assertEquals(phongNoParams.ka.x, 0, 0.01);
		assertEquals(phongNoParams.kd.x, 0, 0.01);
		assertEquals(phongNoParams.ks.x, 0, 0.01);
		assertEquals(phongNoParams.ka.y, 0, 0.01);
		assertEquals(phongNoParams.kd.y, 0, 0.01);
		assertEquals(phongNoParams.ks.y, 0, 0.01);
		assertEquals(phongNoParams.ka.z, 0, 0.01);
		assertEquals(phongNoParams.kd.z, 0, 0.01);
		assertEquals(phongNoParams.ks.z, 0, 0.01);
		assertEquals(phongNoParams.specCoef, 0, 0.01);
	}
	
	@Test
	public void NewPhong_SimpleParameters_Instantiated() {
		assertEquals(phongSimpleParams1.ka.x, 0, 0.01);
		assertEquals(phongSimpleParams1.kd.x, 0.5, 0.01);
		assertEquals(phongSimpleParams1.ks.x, 0.5, 0.01);
		assertEquals(phongSimpleParams1.ka.y, 0, 0.01);
		assertEquals(phongSimpleParams1.kd.y, 0.5, 0.01);
		assertEquals(phongSimpleParams1.ks.y, 0.5, 0.01);
		assertEquals(phongSimpleParams1.ka.z, 0, 0.01);
		assertEquals(phongSimpleParams1.kd.z, 0.5, 0.01);
		assertEquals(phongSimpleParams1.ks.z, 0.5, 0.01);
		assertEquals(phongSimpleParams1.specCoef, 2, 0.01);
	}
}
