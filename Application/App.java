package Application;

import Application.Controller.Controller;
import Application.View.View;
import Application.Model.Model;

// App

public class App {{

}
public static void main(String[] args) {
    Controller controller = new Controller();
    Model model = new Model(controller);
    View view = new View(controller, model);
    controller.addObserver(model);
    model.addObserver(view);
    model.run();
    }
}  