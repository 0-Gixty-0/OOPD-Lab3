package Application.View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.*;

import Application.Model.Model;
import Application.Model.Vehicle.Vehicle;
import Application.Model.Vehicle.Types.VehicleType;

import java.awt.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private BufferedImage volvoImage;
    private BufferedImage saabImage;
    private BufferedImage scaniaImage;
    private Model model;
    private HashMap<VehicleType, BufferedImage> imageHashMap;


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, Model model) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.imageHashMap = new HashMap<VehicleType, BufferedImage>();
        this.model = model;
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            imageHashMap.put(VehicleType.VOLVO, volvoImage);
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            imageHashMap.put(VehicleType.SAAB, volvoImage);
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            imageHashMap.put(VehicleType.SCANIA, volvoImage);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle v: this.model.getVehiclesSet()) {
            VehicleType type = v.getType();
            switch (type) {
                case SAAB:
                    g.drawImage(saabImage, (int) v.getXCord(), (int) v.getYCord(), null); // see javadoc for more info on the parameters
                    break;
                case SCANIA:
                    g.drawImage(scaniaImage, (int) v.getXCord(), (int) v.getYCord(), null); // see javadoc for more info on the parameters
                    break;
                case VOLVO:
                    g.drawImage(volvoImage, (int) v.getXCord(), (int) v.getYCord(), null); // see javadoc for
                    break;
                default:
                    break;
    
            }
        }

    }
}
