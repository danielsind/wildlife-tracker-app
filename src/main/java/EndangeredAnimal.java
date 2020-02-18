import java.util.List;
import org.sql2o.*;

public class EndangeredAnimal extends Animal {
       public int id;
       public static final String DATABASE_TYPE = "Endangered";
    public EndangeredAnimal(String name,String health,String age){
        this.age=age;
        this.name = name;
        this.health = health;
        this.id = id;
        type = DATABASE_TYPE;
    }
    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM animals WHERE type = 'Endangered';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
        }
    }
    public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals WHERE id=:id";
            EndangeredAnimal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animal;
        }
    }
    public void save() {
        try (Connection con = DB.sql2o.open()) {
            con.setRollbackOnException(true);
            String sql = "INSERT INTO animals (name, health,age,type) VALUES (:name, :health, :age, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("health",this.health)
                    .addParameter("age",this.age)
                    .addParameter("type",this.type)
                    .executeUpdate()
                    .getKey();
        }
    }
}
