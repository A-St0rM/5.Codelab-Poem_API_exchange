package app.routes;

import app.controllers.DogController;
import io.javalin.apibuilder.EndpointGroup;
import static io.javalin.apibuilder.ApiBuilder.*;

public class PoemRoute {

    DogController dogController = new DogController();

    public EndpointGroup getRoutes() {
        return () -> {
            get("/", dogController::getAllDogs);
            get("/{id}", dogController::getDogById);
            post("/", dogController::createDog);
            put("/{id}", dogController::updateDog);
            delete("/{id}", dogController::deleteDog);
        };
    }
}
