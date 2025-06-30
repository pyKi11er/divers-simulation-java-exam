package environment;

import java.util.HashSet;
import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail; 
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;
import environment.marker.*;
import environment.collectables.*;
import person.divers.*;
import person.util.*;

public class DivingOperationTest {

    @Test
    public void testConstructor(){
        DivingOperation d = new DivingOperation(3);
        assertEquals("T1", d.teams.get(0).getTeamId());
        assertEquals(Color.RED, d.teams.get(0).getColor());
        assertEquals("T2", d.teams.get(1).getTeamId());
        assertEquals(Color.GREEN, d.teams.get(1).getColor());
        assertEquals("T3", d.teams.get(2).getTeamId());
        assertEquals(Color.BLUE, d.teams.get(2).getColor());
    }

    @Test
    public void testPrepareOperation(){
        DivingOperation d = new DivingOperation(3);
        d.prepareOperation(5);
        assertEquals(2, d.allArtefacts.size());
        for(Artefact a : d.allArtefacts){
            assertEquals(Color.GREEN, a.getColor());
        }
    }

    @Test
    public void testPrepareOperationThrowsInvalidOperation(){
        DivingOperation d = new DivingOperation(3);
        assertThrows(IllegalStateException.class, () ->  d.prepareOperation(1));
    }

    @Test
    public void testConductOperation() {
        DivingOperation d = new DivingOperation(3);
        
        Sample greenSample1 = new Sample("GRN-001", Color.GREEN);
        Sample greenSample2 = new Sample("GRN-002", Color.GREEN);
        d.allArtefacts.add(greenSample1);
        d.allArtefacts.add(greenSample2);
        
        try {
            HashSet<Artefact> r = d.conductOperation();
            assertNotNull(r);
            assertFalse(r.isEmpty());

            for(Artefact a : r) {
                assertTrue(d.allArtefacts.contains(a));
            }

            for(Diver team : d.teams) {
                for(Artefact artefact : team.getArtefacts()) {
                    assertEquals(team.getColor(), artefact.getColor());
                }
            }
        } catch (WrongArtefact e) {
            fail(e.getMessage());
        }
    }

    // @Test
    // public void testRedTeamForceRetrieval(){

    // }
}
