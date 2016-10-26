package raytracer;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Before;

public class SphereJunitTest {
	private Sphere sphereNoParams;
	private Sphere sphereSimpleParams;
	
	@Before
    public void setUp() {
        sphereNoParams = new Sphere();
        sphereSimpleParams = new Sphere(new Point(0, 0, 0), 1);
	}
	
	/*****Test Naming Convention: [UnitOfWork_StateUnderTest_ExpectedBehavior]*****/
	@Test
	public void NewSphere_NoParameters_Instantiated() {
		assertEquals(sphereNoParams.center.x, 0, 0.01);
		assertEquals(sphereNoParams.center.y, 0, 0.01);
		assertEquals(sphereNoParams.center.z, 0, 0.01);
		assertEquals(sphereNoParams.radius, 1, 0.01);
	}
	
	@Test
	public void IsIntersection_SimpleParameters_Calculated() {
	    Sphere s = new Sphere(new Point(0,0,4), 5);
	    Ray r = new Ray(new Point(10,0,0), new Vector(-1,0,0));
	    boolean ret = s.isIntersection(r);
	    assertEquals(ret, true);
	}
	
	@Test
	public void getIntersection_SimpleParameters_Calculated() {
	    Sphere s = new Sphere(new Point(0,0,4), 5);
	    Ray r = new Ray(new Point(10,0,0), new Vector(-1,0,0));
	    double ret = s.getIntersection(r);
	    assertEquals(ret, 7, 0.01);
	}
}
