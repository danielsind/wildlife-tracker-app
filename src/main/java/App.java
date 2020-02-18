import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");

        Map<String,Object> model = new HashMap<String,Object>();

        get("/", (req,res) -> {
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings/form",(req,res)->{
            return new ModelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sightings/new",(req,res)->{
            String rangername = req.queryParams("rangername");
            String location = req.queryParams("location");
            String animalname = req.queryParams("animalname");
            String animalhealth = req.queryParams("animalhealth");
            String animalage = req.queryParams("animalage");
            String animaltype = req.queryParams("animaltype");
            Sighting sighting = new Sighting(location,rangername,animalname,animalhealth,animalage,animaltype);
            sighting.save();
            return new ModelAndView(model, "successsighting.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings",(req,res)->{
            model.put("sightings",Sighting.all());
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangered",(req,res) ->{
            model.put("endangeredAnimals",EndangeredAnimal.all());
            return new ModelAndView(model, "endangeredanimal.hbs");
        }, new HandlebarsTemplateEngine());


        get("/endangered/form",(req,res)->{
            return new ModelAndView(model, "endangered-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/endangered/new",(req,res) ->{
            String name = req.queryParams("name");
            String health = req.queryParams("health");
            String age = req.queryParams("age");
            EndangeredAnimal animal= new EndangeredAnimal(name,health,age);
            animal.save();
            return new ModelAndView(model, "endangeredSuccess.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animal/form",(req,res) -> {
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/animal/new",(req,res) -> {
            String name = req.queryParams("name");
            String health = req.queryParams("health");
            String age = req.queryParams("age");
            NonEndangeredAnimal nonEndangeredAnimal= new NonEndangeredAnimal(name,health,age);
            nonEndangeredAnimal.save();
            return new ModelAndView(model, "animalsuccess.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals",(req,res) ->{
            model.put("nonEndangeredAnimals",NonEndangeredAnimal.all());
            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
