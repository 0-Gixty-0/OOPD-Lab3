package Application;

import Application.Controller.Controller;
import Application.View.View;
import Application.Model.Model;

public class App {{

}

public static void main(String[] args) {
    
    Controller controller = new Controller();
    View view = new View(controller);
    Model model = new Model(controller);
    controller.addObserver(model);
    model.addObserver(view);
    model.run();
    }
}  