import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class NonEndangeredAnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangeredAnimal_instantiatesCorrectly_true() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Bubbles","Healthy","Young");
        assertEquals(true, testNonEndangeredAnimal instanceof NonEndangeredAnimal);
    }

    @Test
    public void FireMonster_instantiatesWithName_String() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Bubbles","Healthy","Young");
        assertEquals("Bubbles", testNonEndangeredAnimal.getName());
    }

    @Test
    public void FireMonster_instantiatesWithPersonId_int() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Bubbles","Healthy","Young");
        assertEquals(1, testNonEndangeredAnimal.getId());
    }

    @Test
    public void equals_returnsTrueIfNameAndPersonIdAreSame_true() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Bubbles","Healthy","Young");
        NonEndangeredAnimal testNonEndangeredAnimal2 = new NonEndangeredAnimal("Bubbles","Healthy","Young");
        assertTrue(testNonEndangeredAnimal.equals(testNonEndangeredAnimal2));
    }

    @Test
    public void save_successfullyAddsFireMonsterToDatabase_List() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Bubbles","Healthy","Young");
        testNonEndangeredAnimal.save();
        assertTrue(NonEndangeredAnimal.all().get(0).equals(testNonEndangeredAnimal));
    }

    @Test
    public void save_assignsIdToFireMonster() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Bubbles","Healthy","Young");
        testNonEndangeredAnimal.save();
        NonEndangeredAnimal savedNonEndangeredAnimal = NonEndangeredAnimal.all().get(0);
        assertEquals(savedNonEndangeredAnimal.getId(), testNonEndangeredAnimal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfFireMonster_true() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Bubbles","Healthy","Young");
        testNonEndangeredAnimal.save();
        NonEndangeredAnimal testNonEndangeredAnimal2 = new NonEndangeredAnimal("Bee","Healthy","Young");
        testNonEndangeredAnimal2.save();
        assertEquals(true, NonEndangeredAnimal.all().get(0).equals(testNonEndangeredAnimal));
        assertEquals(true, NonEndangeredAnimal.all().get(1).equals(testNonEndangeredAnimal2));
    }

    @Test
    public void find_returnsFireMonsterWithSameId_secondFireMonster() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Bubbles","Healthy","Young");
        testNonEndangeredAnimal.save();
        NonEndangeredAnimal testNonEndangeredAnimal2 = new NonEndangeredAnimal("Bubbles","Healthy","Young");
        testNonEndangeredAnimal2.save();
        assertEquals(EndangeredAnimal.find(testNonEndangeredAnimal2.getId()), testNonEndangeredAnimal2);
    }
//
//    @Test
//    public void save_savesPersonIdIntoDB_true() {
//        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Bubbles","Healthy","Young");
//        testNonEndangeredAnimal.save();
//        NonEndangeredAnimal testNonEndangeredAnimal2 = new NonEndangeredAnimal("Bubbles","Healthy","Young");
//        testNonEndangeredAnimal2.save();
//        NonEndangeredAnimal savedNonEndangereAnimal = NonEndangeredAnimal.find(testNonEndangeredAnimal.getId());
//        assertEquals(savedNonEndangereAnimal.getPersonId(), testNonEndangeredAnimal.getId());
//    }


    @Test
    public void save_assignsIdToObject() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Bubbles","Healthy","Young");
        testNonEndangeredAnimal.save();
        NonEndangeredAnimal savedNonEndangeredAnimal = NonEndangeredAnimal.all().get(0);
        assertEquals(testNonEndangeredAnimal.getId(), savedNonEndangeredAnimal.getId());
    }

}