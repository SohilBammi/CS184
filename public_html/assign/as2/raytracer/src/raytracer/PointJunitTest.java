package raytracer;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class PointJunitTest {
	private Point pointNoParams;
	private Point pointSimple1;
	private Point pointSimple2;
	
	@Before
    public void setUp() {
        pointNoParams = new Point();
        pointSimple1 = new Point(1, 2, 3);
        pointSimple2 = new Point(2, 2, 2);
    }
	
	/*****Test Naming Convention: [UnitOfWork_StateUnderTest_ExpectedBehavior]*****/
	@Test
	public void NewPoint_NoParameters_Instantiated() {
		assertEquals(pointNoParams.x, 0, 0.01);
		assertEquals(pointNoParams.y, 0, 0.01);
		assertEquals(pointNoParams.z, 0, 0.01);
	}
	
	@Test
	public void NewVector_ThreeParameters_Instantiated() {
		assertEquals(pointSimple1.x, 1, 0.01);
		assertEquals(pointSimple1.y, 2, 0.01);
		assertEquals(pointSimple1.z, 3, 0.01);
	}
	
	@Test
	public void Distance_SimplePositivePoints_Calculated() {
		double ret = pointSimple1.distance(pointSimple2);
		assertEquals(ret, 1.414, 0.01);
	}
	
	@Test
	public void Vector_SimplePositivePoints_Calculated() {
		Vector ret = pointSimple1.vector(pointSimple2);
		assertEquals(ret.x, 1, 0.01);
		assertEquals(ret.y, 0, 0.01);
		assertEquals(ret.z, -1, 0.01);
	}
}
