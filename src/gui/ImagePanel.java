package gui;

/**
 * ImagePanel extends JPanel in order to allow an image to be applied to 
 * the background.
 *
 * @author Mike
 */
import java.awt.*;
import javax.swing.*;
import java.io.*;


public class ImagePanel extends JPanel implements Serializable {
    Image image = null;

    /**
     * Constructor for ImagePanel
     * @param image
     */
    public ImagePanel(Image image) {
        this.image = image;
    }

    /**
     * Constructor
     */
    public ImagePanel() {

    }

    /**
     * Setter for Image
     * @param image
     */
    public void setImage(Image image){
        this.image = image;
    }

    /**
     * Getter for Image
     * @param image
     * @return
     */
    public Image getImage(Image image){
        return image;
    }

    /**
     * Paint image onto JPanel
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        // Paint Background
        super.paintComponent(g);
        // If there is a picture, draw it!
        if (image != null) { 
            int height = this.getSize().height;
            int width = this.getSize().width;
            // g.drawImage(image, 0, 0, this);                   //use image size
            g.drawImage(image,0,0, width, height, this);
        }
    }
}