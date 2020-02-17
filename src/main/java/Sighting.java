import java.security.PublicKey;

public class Sighting {
    public String rangerName;
    public String location;
    public String animalName;
    public String animalType;
    public String animalHealth;
    public String animalAge;
    public int  animalId;


    public Sighting(String rangerName,String animalName,String location,String animalType,String animalHealth,String animalAge){
       this.animalName = animalName;
       this.animalType = animalType;
       this.location = location;
       this.rangerName = rangerName;
       this.animalHealth = animalHealth;
       this.animalAge  = animalAge;
       this.animalId = animalId;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalHealth() {
        return animalHealth;
    }

    public void setAnimalHealth(String animalHealth) {
        this.animalHealth = animalHealth;
    }

    public String getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(String animalAge) {
        this.animalAge = animalAge;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
}
