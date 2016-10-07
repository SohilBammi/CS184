package raytracer;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class PhongJunitTest {
	private PhongShader phong;
	
	@Before
    public void setUp() {
        phong = new PhongShader();
    }
	
	/*****Test Naming Convention: [UnitOfWork_StateUnderTest_ExpectedBehavior]*****/
	@Test
	public void NewPhong_NoParameters_Instantiated() {
		assertEquals(phong.ka.x, 0, 0.01);
		assertEquals(phong.kd.x, 0, 0.01);
		assertEquals(phong.ks.x, 0, 0.01);
		assertEquals(phong.ka.y, 0, 0.01);
		assertEquals(phong.kd.y, 0, 0.01);
		assertEquals(phong.ks.y, 0, 0.01);
		assertEquals(phong.ka.z, 0, 0.01);
		assertEquals(phong.kd.z, 0, 0.01);
		assertEquals(phong.ks.z, 0, 0.01);
	}
}
