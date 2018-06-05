package model;

import javafx.scene.image.*;

/**
 * Item class that holds the image and the name of an item.
 * 
 * @author Andres Monteoliva
 * @version 1.0
 *
 */
public class Item {

	private String text;
	private Image image;

	/**
	 * Constructor of the item class, with a given name and path for the image.
	 * 
	 * @param text
	 *            The name of the Item.
	 * @param path
	 *            The path of the image of the Item in the filesystem. It could
	 *            potentially be an URL as well.
	 */
	public Item(String text, String path) {

		image = new Image(path);
		this.text = text;
	}

	/**
	 * Retrieves the image of the item.
	 * 
	 * @return The image of the Item.
	 */
	public Image getImage() {

		return image;
	}

	/**
	 * Retrieves the name of the item.
	 * 
	 * @return the name of the item.
	 */
	public String getText() {

		return text;
	}

}