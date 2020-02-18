import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void instantiatesCorrectltyClassSighting(){
        Sighting testSighting = new Sighting("Daniel","Lion","Nairobi","Endangered","Healthy","Young");
        assertEquals(true,testSighting instanceof Sighting);
    }
    @Test
    public void get_methodsForAttributesNameLocationTypeAndHealth(){
        Sighting testSighting = new Sighting("Daniel","Lion","Nairobi","Endangered","Healthy","Young");
        assertEquals("Daniel",testSighting.getRangername());
        assertEquals("Lion",testSighting.getAnimalname());
        assertEquals("Nairobi",testSighting.getLocation());
        assertEquals("Healthy",testSighting.getAnimalhealth());
        assertEquals("Young",testSighting.getAnimalage());
        assertEquals("Endangered",testSighting.getAnimalType());
    }

}
