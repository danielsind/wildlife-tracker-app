import org.junit.Test;
import static org.junit.Assert.*;

public class RangerTest {
    @Test
    public void ranger_instantiatesCorrectly_true() {
        Ranger testRanger = new Ranger("Henry", "[email protected] (Links to an external site.)");
        assertEquals(true, testRanger instanceof Ranger);
    }
    @Test
    public void getName_rangerInstantiatesWithName_Henry() {
        Ranger tetsRanger = new Ranger("Henry", "[email protected] (Links to an external site.)");
        assertEquals("Henry", tetsRanger.getName());
    }

    @Test
    public void getEmail_rangerInstantiatesWithEmail_String() {
        Ranger testRanger = new Ranger("Henry", "[email protected] (Links to an external site.)");
        assertEquals("[email protected] (Links to an external site.)", testRanger.getEmail());
    }
}
