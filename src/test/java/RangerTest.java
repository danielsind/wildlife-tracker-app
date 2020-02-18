import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RangerTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
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
    @Test
    public void equals_returnsTrueIfNameAndEmailAreSame_true() {
        Ranger firstRanger = new Ranger("Henry", "[email protected] (Links to an external site.)");
        Ranger anotherRanger = new Ranger("Henry", "[email protected] (Links to an external site.)");
        assertTrue(firstRanger.equals(anotherRanger));
    }
    @Test
    public void save_insertsObjectIntoDatabase_Ranger() {
        Ranger testRanger = new Ranger("Henry", "[email protected] (Links to an external site.)");
        testRanger.save();
        assertTrue(Ranger.all().get(0).equals(testRanger));
    }
    @Test
    public void all_returnsAllInstancesOfRanger_true() {
        Ranger firstRanger = new Ranger("Henry", "henry@henry.com");
        firstRanger.save();
        Ranger secondPerson = new Ranger("Harriet", "harriet@harriet.com");
        secondPerson.save();
        assertEquals(true, Ranger.all().get(0).equals(firstRanger));
        assertEquals(true, Ranger.all().get(1).equals(secondPerson));
    }
    @Test
    public void save_assignsIdToObject() {
        Ranger testRanger = new Ranger("Henry", "henry@henry.com");
        testRanger.save();
        Ranger savedRanger = Ranger.all().get(0);
        assertEquals(testRanger.getId(), savedRanger.getId());
    }

    @Test
    public void find_returnsRangerWithSameId_secondPerson() {
        Ranger firstRanger = new Ranger("Henry", "henry@henry.com");
        firstRanger.save();
        Ranger secondRanger = new Ranger("Harriet", "harriet@harriet.com");
        secondRanger.save();
        assertEquals(Ranger.find(secondRanger.getId()), secondRanger);
    }
    @Test
    public void getAnimals_retrievesAllAnimalsFromDatabase_monstersList() {
        Ranger testRanger = new Ranger("Henry", "henry@henry.com");
        testRanger.save();
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Bubbles","Healthy","Young");
        testEndangeredAnimal.save();
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Cat","Healthy","Young");
        testNonEndangeredAnimal.save();
        Object[] animals = new Object[] { testEndangeredAnimal, testNonEndangeredAnimal };
        assertTrue(testRanger.getAnimals().containsAll(Arrays.asList(animals)));
    }

}
