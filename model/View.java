package model;

import javafx.scene.image.*;

/**
 * View class that relates an image to each direction a user can look to in each
 * Spot.
 * 
 * @author Andres Monteoliva
 * @version 1.0
 *
 */
public class View {

	private Image image;
	private String path;

	/**
	 * Constructor for the View class.
	 * 
	 * @param path
	 *            The path in the file system where the image related to the View is
	 *            stored. It could potentially be an URL as well.
	 */
	public View(String path) {

		this.path = path;
		image = new Image(path);

	}

	/**
	 * Retrieves the image to be displayed for the View class.
	 * 
	 * @return the image related to this View class.
	 */
	public Image getImage() {

		return image;
	}

	/**
	 * Retrieves the path of the Image of this View
	 * 
	 * @return The path of the image in String format.
	 */
	public String getPath() {

		return path;
	}

}
