/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package any;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LibraryTest {
    @Test public void testSomeLibraryMethod() {
    	HashMap<String,Object> map = new HashMap<String,Object>();
    	map.put("JSON","{\"KEY\":\"VAL\",\"KEY2\":\"VAL2\"}");
    	//map.put("JSON","{KEY:VAL,KEY2:VAL2}");
    	String str = (String)map.get("JSON");
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
}