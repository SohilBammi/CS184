package raytracer;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class VectorJunitTest {
	private Vector vecNoParams;
	private Vector vecSimple1;
	private Vector vecSimple2;
	private double scal1;
	
	@Before
    public void setUp() {
        vecNoParams = new Vector();
        vecSimple1 = new Vector(1, 2, 3);
        vecSimple2 = new Vector(2, 2, 2);
        scal1 = 5;
    }
	
	/*****Test Naming Convention: [UnitOfWork_StateUnderTest_ExpectedBehavior]*****/
	@Test
	public void NewVector_NoParameters_Instantiated() {
		assertEquals(vecNoParams.x, 0, 0.01);
		assertEquals(vecNoParams.y, 0, 0.01);
		assertEquals(vecNoParams.z, 0, 0.01);
	}
	
	@Test
	public void NewVector_ThreeParameters_Instantiated() {
		assertEquals(vecSimple1.x, 1, 0.01);
		assertEquals(vecSimple1.y, 2, 0.01);
		assertEquals(vecSimple1.z, 3, 0.01);
	}
	
	@Test
	public void MulScalar_SimplePositiveScalar_Calculated() {
		Vector ret = vecSimple1.mulScalar(scal1);
		assertEquals(ret.x, 5, 0.01);
		assertEquals(ret.y, 10, 0.01);
		assertEquals(ret.z, 15, 0.01);
	}
	
	@Test
	public void DivScalar_SimplePositiveScalar_Calculated() {
		Vector ret = vecSimple1.divScalar(scal1);
		assertEquals(ret.x, 0.2, 0.01);
		assertEquals(ret.y, 0.4, 0.01);
		assertEquals(ret.z, 0.6, 0.01);
	}
	
	@Test
	public void AddVector_SimplePositiveVectors_Calculated() {
		Vector retActual1 = new Vector(3, 4, 5);
		Vector ret1 = vecSimple1.addVector(vecSimple2);
		Vector ret2 = vecSimple2.addVector(vecSimple1);
		assertEquals(ret1.x, retActual1.x, 0.01);
		assertEquals(ret1.y, retActual1.y, 0.01);
		assertEquals(ret1.z, retActual1.z, 0.01);
		assertEquals(ret2.x, retActual1.x, 0.01);
		assertEquals(ret2.y, retActual1.y, 0.01);
		assertEquals(ret2.z, retActual1.z, 0.01);
	}
	
	@Test
	public void SubVector_SimplePositiveVectors_Calculated() {
		Vector retActual1 = new Vector(-1, 0, 1);
		Vector retActual2 = new Vector(1, 0, -1);
		Vector ret1 = vecSimple1.subVector(vecSimple2);
		Vector ret2 = vecSimple2.subVector(vecSimple1);
		assertEquals(ret1.x, retActual1.x, 0.01);
		assertEquals(ret1.y, retActual1.y, 0.01);
		assertEquals(ret1.z, retActual1.z, 0.01);
		assertEquals(ret2.x, retActual2.x, 0.01);
		assertEquals(ret2.y, retActual2.y, 0.01);
		assertEquals(ret2.z, retActual2.z, 0.01);
	}
		
	@Test
	public void DotProduct_SimplePositiveVectors_Calculated() {
		double ret1 = vecSimple1.dotProduct(vecSimple2);
		double ret2 = vecSimple2.dotProduct(vecSimple1);
		assertEquals(ret1, 12, 0.01);
		assertEquals(ret1, ret2, 0.01);
	}
	
	@Test
	public void CrossProduct_SimplePositiveVectors_Calculated() {
		Vector retActual1 = new Vector(-2, 4, -2);
		Vector retActual2 = new Vector(2, -4, 2);
		Vector ret1 = vecSimple1.crossProduct(vecSimple2);
		Vector ret2 = vecSimple2.crossProduct(vecSimple1);
		assertEquals(ret1.x, retActual1.x, 0.01);
		assertEquals(ret1.y, retActual1.y, 0.01);
		assertEquals(ret1.z, retActual1.z, 0.01);
		assertEquals(ret2.x, retActual2.x, 0.01);
		assertEquals(ret2.y, retActual2.y, 0.01);
		assertEquals(ret2.z, retActual2.z, 0.01);
	}
}
