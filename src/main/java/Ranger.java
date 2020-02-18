import java.util.Objects;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Ranger {
    private String name;
    private String email;
    private int id;

    public Ranger(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ranger)) return false;
        Ranger ranger = (Ranger) o;
        return getName().equals(ranger.getName()) &&
                getEmail().equals(ranger.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmail());
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            con.setRollbackOnException(false);
            String sql = "INSERT INTO rangers (name, email) VALUES (:name, :email)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("email", this.email)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Ranger> all() {
        String sql = "SELECT * FROM rangers";
        try (Connection con = DB.sql2o.open()) {
            con.setRollbackOnException(false);
            return con.createQuery(sql).executeAndFetch(Ranger.class);
        }
    }

    public static Ranger find(int id) {
        try (Connection con = DB.sql2o.open()) {
            con.setRollbackOnException(false);
            String sql = "SELECT * FROM rangers where id=:id";
            Ranger ranger = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Ranger.class);
            return ranger;
        }
    }
    public List<Object> getAnimals() {
        List<Object> allAnimals = new ArrayList<Object>();

        try(Connection con = DB.sql2o.open()) {
            String sqlEndangered = "SELECT * FROM animals WHERE id=:id AND type='Endangered';";
            List<EndangeredAnimal> endangeredAnimals = con.createQuery(sqlEndangered)
                    .addParameter("id", this.id)
                    .executeAndFetch(EndangeredAnimal.class);
            allAnimals.addAll(endangeredAnimals);

            String sqlNonEndangered = "SELECT * FROM animals WHERE id=:id AND type='Non_Endangered';";
            List<NonEndangeredAnimal> nonEndangeredAnimals = con.createQuery(sqlNonEndangered)
                    .addParameter("id", this.id)
                    .executeAndFetch(NonEndangeredAnimal.class);
            allAnimals.addAll(nonEndangeredAnimals);
        }

        return allAnimals;
    }
}
