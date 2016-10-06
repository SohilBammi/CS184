package raytracer;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RaytracerJunitTestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(RaytracerJunitTestSuite.class);
      System.out.println(result.getRunCount()+" test(s) ran.");
      System.out.println(result.getFailureCount()+" test(s) failed.\n");
      if(result.getFailureCount() > 0){
    	  System.out.println("Errors:");
    	  for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
      }
   }
} 
