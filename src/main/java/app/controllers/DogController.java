package app.controllers;

import app.DTO.PoemDTO;
import io.javalin.http.Context;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DogController {
    private static Map<Integer, PoemDTO> dogs = new HashMap<>();
    private static int currentId = 1;

    static{
        dogs.put(currentId, new PoemDTO(currentId++, "Tom", "Labrador", "female", 3));
        dogs.put(currentId, new PoemDTO(currentId++, "Jerry", "Beagle", "Male", 5));
    }

    public void getAllDogs(Context ctx) {
        Collection<PoemDTO> allDogs = dogs.values();
        ctx.json(allDogs);
    }

    public void getDogById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        PoemDTO dog = dogs.get(id);
        if (dog == null) {
            ctx.status(404).result("Dog not found");
        } else {
            ctx.json(dog);
        }
    }

    public void createDog(Context ctx) {
        PoemDTO dog = ctx.bodyAsClass(PoemDTO.class);
        dog.setId(currentId++);
        dogs.put(dog.getId(), dog);
        ctx.status(201).json(dog);
    }

    public void updateDog(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        PoemDTO existing = dogs.get(id);
        if (existing == null) {
            ctx.status(404).result("Dog not found");
            return;
        }
        PoemDTO updatedDog = ctx.bodyAsClass(PoemDTO.class);
        updatedDog.setId(id); // bevar id
        dogs.put(id, updatedDog);
        ctx.json(updatedDog);
    }

    public void deleteDog(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        PoemDTO removed = dogs.remove(id);
        if (removed == null) {
            ctx.status(404).result("Dog not found");
        } else {
            ctx.status(204); // no content
        }
    }
}
