package connectfour;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/* you will need to add test methods and likely change the
setup method as well.  The samples that are here are just so that
you can see how junit works.

Tests are run on build unless specifically excluded with -x test.
The test results are reported in the reports subfolder of the build directory */


public class BoardTest{
    private Board tester;

    @Before
    public void setup(){
        //set up for the test
        tester = new Board();

    }

    @Test
    public void someTestHere(){
        /* to see what happens when a test fails, change
        the 1 to any other number in the statement below */
        Assert.assertEquals(tester.returnSomething(), 1);
        
    }

}