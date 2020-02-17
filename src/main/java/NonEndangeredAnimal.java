import org.sql2o.*;
import java.util.List;

public class NonEndangeredAnimal extends Animal {
    public NonEndangeredAnimal(String name,String health,String age){
        this.age=age;
        this.name = name;
        this.health = health;
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, health,age) VALUES (:name, :health, :age);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("health",this.health)
                    .addParameter("age",this.age)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<NonEndangeredAnimal> all() {
        String sql = "SELECT * FROM animals;";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(NonEndangeredAnimal.class);
        }
    }
    public static NonEndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            NonEndangeredAnimal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(NonEndangeredAnimal.class);
            return animal;
        }
    }
}
