package app.routes;

import app.controllers.PoemController;
import io.javalin.apibuilder.EndpointGroup;
import static io.javalin.apibuilder.ApiBuilder.*;

public class PoemRoute {

    PoemController poemController = new PoemController();

    public EndpointGroup getRoutes() {
        return () -> {
            get("/", poemController::getAllPoems);
//            get("/{id}", poemController::getDogById);
//            post("/", poemController::createDog);
//            put("/{id}", poemController::updateDog);
//            delete("/{id}", poemController::deleteDog);
        };
    }
}
