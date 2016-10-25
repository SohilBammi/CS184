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
	public void GetZCoordinates_SimpleParameters_Calculated() {
		ArrayList<Double> ret1 = sphereSimpleParams.getZCoordinates(1, 1);
		assertEquals(ret1.size(), 2, 0.01);
		assertEquals(ret1.get(0), 1, 0.01);
		assertEquals(ret1.get(1), -1, 0.01);
		
		ArrayList<Double> ret2 = sphereSimpleParams.getZCoordinates(0.5, 0.5);
		assertEquals(ret2.size(), 2, 0.01);
		assertEquals(ret2.get(0), 0.707, 0.01);
		assertEquals(ret2.get(1), -0.707, 0.01);
	}
	
	@Test
	public void GetFrontPoint_SimpleParameters_Calculated() {
		Point ret1 = sphereSimpleParams.getFrontPoint(1, 1);
		assertEquals(ret1.x, 1, 0.01);
		assertEquals(ret1.y, 1, 0.01);
		assertEquals(ret1.z, 1, 0.01);
		
		Point ret2 = sphereSimpleParams.getFrontPoint(0.5, 0.5);
		assertEquals(ret2.x, 0.5, 0.01);
		assertEquals(ret2.y, 0.5, 0.01);
		assertEquals(ret2.z, 0.707, 0.01);
		
	}
	
	@Test
    public void GetNormalVector_SimpleParameters_Calculated() {
        Vector ret = sphereSimpleParams.getNormalVector(new Point(0, 0, 1));
        assertEquals(ret.x, 0, 0.01);
        assertEquals(ret.y, 0, 0.01);
        assertEquals(ret.z, 1, 0.01);
    }

	@Test
    public void IsValidPoint_SimpleParameters_Calculated() {
        Boolean ret1 = sphereSimpleParams.isValidPoint(new Point(0, 0, 1));
        assertEquals(ret1, true);
        
        Boolean ret2 = sphereSimpleParams.isValidPoint(new Point(0, 0.5, 1));
        assertEquals(ret2, false);
    }
	
	@Test
    public void HasPointAt_SimpleParameters_Calculated() {
        Boolean ret1 = sphereSimpleParams.hasPointAt(0,0);
        assertEquals(ret1, true);
        
        Boolean ret2 = sphereSimpleParams.hasPointAt(0,1);
        assertEquals(ret2, true);
        
        Boolean ret3 = sphereSimpleParams.hasPointAt(0,1.01);
        assertEquals(ret3, false);
    }
	
	@Test
    public void GetPoints_SimpleParameters_Calculated() {
        ArrayList<Point> ret1 = sphereSimpleParams.getPoints(1, 1);
        assertEquals(ret1.size(), 2, 0.01);
        assertEquals(ret1.get(0).x, 1, 0.01);
        assertEquals(ret1.get(0).y, 1, 0.01);
        assertEquals(ret1.get(0).z, 1, 0.01);
        assertEquals(ret1.get(1).x, 1, 0.01);
        assertEquals(ret1.get(1).y, 1, 0.01);
        assertEquals(ret1.get(1).z, -1, 0.01);
        
        
        ArrayList<Point> ret2 = sphereSimpleParams.getPoints(0.5, 0.5);
        assertEquals(ret2.size(), 2, 0.01);
        assertEquals(ret2.get(0).x, 0.5, 0.01);
        assertEquals(ret2.get(0).y, 0.5, 0.01);
        assertEquals(ret2.get(0).z, 0.707, 0.01);
        assertEquals(ret2.get(1).x, 0.5, 0.01);
        assertEquals(ret2.get(1).y, 0.5, 0.01);
        assertEquals(ret2.get(1).z, -0.707, 0.01);
    }
}
