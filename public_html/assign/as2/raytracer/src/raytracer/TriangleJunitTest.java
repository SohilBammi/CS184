package raytracer;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Before;

public class TriangleJunitTest {
    private Triangle triangleNoParams;
    
    @Before
    public void setUp() {
        triangleNoParams = new Triangle();
    }
    
    /*****Test Naming Convention: [UnitOfWork_StateUnderTest_ExpectedBehavior]*****/
    
    @Test
    public void IsIntersection_SimpleParameters_Calculated() {
        Triangle t = new Triangle();
        Ray r = new Ray(new Point(0, 0, -1), new Vector(0, 0, 1));
        boolean ret = t.isIntersection(r);
        assertEquals(ret, true);
    }
}
