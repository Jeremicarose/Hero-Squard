import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        Integer port;
        if (processBuilder.environment().get("PORT") != null){
            port = Integer.parseInt(processBuilder.environment().get("PORT"));
        }else {
            port= 4567;
        }
        port(port);
        staticFileLocation("/public");


            staticFileLocation("/public");
            get("/", ((request, response) -> {
                Map<String, Object> model = new HashMap<>();
                return new ModelAndView(model, "index.hbs");
            }), new HandlebarsTemplateEngine());

            get("/hero", (request, response) -> {
                Map<String, Object> model = new HashMap<>();
                return new ModelAndView(model, "hero-form.hbs");
            }, new HandlebarsTemplateEngine());

            get("/squad", (request, response) -> {
                Map<String, Object> model = new HashMap<>();
                return new ModelAndView(model, "squd-form.hbs");
            }, new HandlebarsTemplateEngine());
            post("/hero/new", ((request, response) -> {
                Map<String, Object> model = new HashMap<>();
                String name = request.queryParams("name");
                int age = Integer.parseInt(request.queryParams("age"));
                String specialPowers = request.queryParams("power");
                String weakness = request.queryParams("weakness");
                Hero newHero = new Hero(name, age, specialPowers, weakness);
                return new ModelAndView(model, "succ-hero.hbs");
            }), new HandlebarsTemplateEngine());

            post("/squad/new", ((request, response) -> {
                Map<String, Object> model = new HashMap<>();
                String name = request.queryParams("name");
                int squadSize = Integer.parseInt(request.queryParams("squadSize"));
                String cause = request.queryParams("name");
                Squad newSquad = new Squad(name, squadSize, cause);
                return new ModelAndView(model, "succ-squd.hbs");
            }), new HandlebarsTemplateEngine());

            get("/squad/list", ((request, response) -> {
                Map<String, Object> model = new HashMap<>();
                ArrayList<Squad> squads = Squad.getAll();
                model.put("squads", squads);
                return new ModelAndView(model, "squd-details.hbs");
            }), new HandlebarsTemplateEngine());
            get("/heros/list", (request, response) -> {
                Map<String, Object> model = new HashMap<>();
                ArrayList<Hero> heros = Hero.getInstances();
                model.put("heros", heros);
                return new ModelAndView(model, "hero-details.hbs");
            }, new HandlebarsTemplateEngine());
            get("/heros/delete", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                Hero.clearAllHeroes();
                return new ModelAndView(model, "succ-hero.hbs");
            }, new HandlebarsTemplateEngine());
        }
    }
