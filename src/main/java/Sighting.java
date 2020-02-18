import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sighting {
    public String rangername;
    public String location;
    public String animalname;
    public String animaltype;
    public String animalhealth;
    public String animalage;
    public int id;


    public Sighting(String rangername, String animalname, String location, String animaltype, String animalhealth, String animalage){
       this.animalname = animalname;
       this.animaltype = animaltype;
       this.location = location;
       this.rangername = rangername;
       this.animalhealth = animalhealth;
       this.animalage = animalage;
       this.id = id;
    }

    public String getRangername() {
        return rangername;
    }

    public void setRangername(String rangername) {
        this.rangername = rangername;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAnimalname() {
        return animalname;
    }

    public void setAnimalname(String animalname) {
        this.animalname = animalname;
    }

    public String getAnimalType() {
        return animaltype;
    }

    public void setAnimalType(String animalType) {
        this.animaltype = animalType;
    }

    public String getAnimalhealth() {
        return animalhealth;
    }

    public void setAnimalhealth(String animalhealth) {
        this.animalhealth = animalhealth;
    }

    public String getAnimalage() {
        return animalage;
    }

    public void setAnimalage(String animalage) {
        this.animalage = animalage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sighting)) return false;
        Sighting sighting = (Sighting) o;
        return getId() == sighting.getId() &&
                Objects.equals(getRangername(), sighting.getRangername()) &&
                Objects.equals(getLocation(), sighting.getLocation()) &&
                Objects.equals(getAnimalname(), sighting.getAnimalname()) &&
                Objects.equals(animaltype, sighting.animaltype) &&
                Objects.equals(getAnimalhealth(), sighting.getAnimalhealth()) &&
                Objects.equals(getAnimalage(), sighting.getAnimalage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRangername(), getLocation(), getAnimalname(), animaltype, getAnimalhealth(), getAnimalage(), getId());
    }
    public void save() {
        try (Connection con = DB.sql2o.open()) {
            con.setRollbackOnException(false);
            String sql = "INSERT INTO sightings (rangername,location,animalname,animaltype,animalhealth,animalage) VALUES (:rangername, :location, :animalname, :animaltype, :animalhealth, :animalage)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("rangername", this.rangername)
                    .addParameter("location", this.location)
                    .addParameter("animalname",this.animalname)
                    .addParameter("animaltype",this.animaltype)
                    .addParameter("animalhealth",this.animalhealth)
                    .addParameter("animalage",this.animalage)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Sighting> all() {
        String sql = "SELECT * FROM sightings";
        try (Connection con = DB.sql2o.open()) {
            con.setRollbackOnException(false);
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }

    public static Sighting find(int id) {
        try (Connection con = DB.sql2o.open()) {
            con.setRollbackOnException(false);
            String sql = "SELECT * FROM sightings where id=:id";
            Sighting sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        }
    }
    public List<Object> getSightings() {
        List<Object> allSightings = new ArrayList<Object>();

        try(Connection con = DB.sql2o.open()) {
            String sqlSightings = "SELECT * FROM sightings WHERE id=:id;";
            List<Sighting> sightings = con.createQuery(sqlSightings)
                    .addParameter("id", this.id)
                    .executeAndFetch(Sighting.class);
            allSightings.addAll(sightings);
        }
        return allSightings;
    }
}
