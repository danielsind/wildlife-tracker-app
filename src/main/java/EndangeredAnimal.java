import java.util.List;
import org.sql2o.*;

public class EndangeredAnimal extends Animal {
       public int id;
    public EndangeredAnimal(String name,String health,String age){
        this.age=age;
        this.name = name;
        this.health = health;
        this.id = id;
    }
    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM animals;";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
        }
    }
    public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            EndangeredAnimal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animal;
        }
    }
    public void save() {
        try (Connection con = DB.sql2o.open()) {
            con.setRollbackOnException(false);
            String sql = "INSERT INTO animals (name, health,age) VALUES (:name, :name, :name);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("name",this.health)
                    .addParameter("name",this.age)
                    .executeUpdate()
                    .getKey();
        }
    }
}
