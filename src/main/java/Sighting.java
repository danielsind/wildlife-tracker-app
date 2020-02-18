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
}
