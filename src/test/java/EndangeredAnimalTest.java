import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class EndangeredAnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangeredAnimal_instantiatesCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Bubbles","Healthy","Young");
        assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void EndangeredAnimal_instantiatesWithName_String() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Bubbles","Healthy","Young");
        assertEquals("Bubbles", testEndangeredAnimal.getName());
    }

    @Test
    public void EndangeredAnimal_instantiatesWithAnimalId_int() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Bubbles","Healthy","Young");
        assertEquals(0, testEndangeredAnimal.getId());
    }

    @Test
    public void equals_returnsTrueIfNameAndAnimalIdAreSame_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Bubbles","Healthy","Young");
        EndangeredAnimal testEndangeredAnimal2 = new EndangeredAnimal("Bubbles","Healthy","Young");
        assertTrue(testEndangeredAnimal.getName().equals(testEndangeredAnimal2.getName()));
    }

    @Test
    public void save_successfullyAddsEndangeredAnimalToDatabase_List() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Bubbles","Healthy","Young");
        testEndangeredAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
    }

    @Test
    public void save_assignsIdToEndangeredAnimal() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Bubbles","Healthy","Young");
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(savedEndangeredAnimal.getId(), testEndangeredAnimal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Bubbles","Healthy","Young");
        testEndangeredAnimal.save();
        EndangeredAnimal testEndangeredAnimal2 = new EndangeredAnimal("Buffallo","Healthy","Young");
        testEndangeredAnimal2.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(testEndangeredAnimal2));
    }

    @Test
    public void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Bubbles","Healthy","Young");
        testEndangeredAnimal.save();
        EndangeredAnimal testEndangeredAnimal2 = new EndangeredAnimal("Buffallo","Healthy","Young");
        testEndangeredAnimal2.save();
        assertEquals(EndangeredAnimal.find(testEndangeredAnimal2.getId()), testEndangeredAnimal2);
    }

//    @Test
//    public void save_savesPersonIdIntoDB_true() {
//        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Bubbles","Healthy","Young");
//        testEndangeredAnimal.save();
//        EndangeredAnimal testEndangeredAnimal2 = new EndangeredAnimal("Lionness","Healthy","Young");
//        testEndangeredAnimal2.save();
//        EndangeredAnimal savedEndangereAnimal = EndangeredAnimal.find(testEndangeredAnimal.getId());
//        assertEquals(savedEndangereAnimal.getPersonId(), testEndangeredAnimal.getId());
//    }


    @Test
    public void save_assignsIdToObject() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Bubbles","Healthy","Young");
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(testEndangeredAnimal.getId(), savedEndangeredAnimal.getId());
    }

}