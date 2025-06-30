package environment.collectables;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;
import environment.marker.*;

public class ArtefactTest {
    @Test
    public void testSampleConstructor(){
        Sample s1 = new Sample("RX-721", Color.BLUE);
        assertFalse(s1.getRigidStructure());
        assertEquals("RX-721", s1.getLocationData());
        assertEquals(Color.BLUE, s1.getColor());
    }

    @Test
    public void testRetrieve(){
        Sample s1 = new Sample("RX-721", Color.BLUE);
        Sample s2 = new Sample("RX-7", Color.RED);
        assertNull(s1.retrieve());
        s1.tag();
        s2.tag();
        s1.retrieve();
        s2.retrieve();
        String newloc1 = s1.getLocationData();
        String newloc2 = s2.getLocationData();
        assertEquals("RX-721#OK", newloc1);
        assertEquals("RX-7#NO", newloc2);
    }

    @Test
    public void testTag(){
        Sample s1 = new Sample("RX-721", Color.BLUE);
        assertFalse(s1.getRigidStructure());
        s1.tag();
        assertTrue(s1.getRigidStructure());
        s1.tag();
        assertFalse(s1.getRigidStructure());
    }

    @Test
    public void testText(){
        Sample s1 = new Sample("RX-721", Color.BLUE);
        String result = "LocationData: RX-721, Color: BLUE, isRigid: false";
        assertEquals(result, s1.toString());
    }

    @Test
    public void testSampleEquals(){
        Sample s1 = new Sample("RX-721", Color.BLUE);
        Sample s2 = new Sample("RX-727", Color.BLUE);
        Sample s3 = new Sample("ZX-700", Color.GREEN);
        assertEquals(s1,s2);
        assertNotEquals(s1,s3);
        assertNotEquals(s2,s3);
        assertEquals(s1.hashCode(),s2.hashCode());
    }
}
