package controller;

import model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.*;
import java.util.*;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 * Controller class, based on the JavaFX package, which provides a connection
 * between the model and the GUI to interact with the Walk around the Meadows
 * application. The GUI permits the user to move between different locations,
 * turn around and interact with different objects in the park.
 * 
 * @author Andres Monteoliva
 * @version 1.0
 *
 */

public class WorldController {

	// Elements to interact with the GUI.
	@FXML
	private ImageView currentView, leftView, rightView, forwardView, itemsLeft, itemsRight, item0, item1, item2, hand,
			itemCase, rightCase, leftCase;

	@FXML
	private Menu menuItems, menuSuitcase;

	@FXML
	private TextField spotMessage;

	private World myWorld;

	/**
	 * Initialize the controller, creating a new instance of the class World.
	 */
	public WorldController() {

		myWorld = new World();

	}

	/**
	 * Prints the name of the Spot in which the user is.
	 */
	public void printMessage() {

		spotMessage.clear();
		spotMessage.setText(myWorld.getSpot().getSpotName());
	}

	/**
	 * Turns left the vision of the user (left here is understood as
	 * anti-clockwise).
	 * 
	 * @param event
	 *            click on buttonL.
	 */
	public void lookLeft(ActionEvent event) {

		removeButtonForward();
		myWorld.getSpot().turnLeft();
		Image image = myWorld.getSpot().getCurrentView().getImage();
		currentView.setImage(image);
		setButtonForward();

	}

	/**
	 * Turns right the vision of the user (left here is understood as clockwise).
	 * 
	 * @param event
	 *            click on buttonR.
	 */
	public void lookRight(ActionEvent event) {

		removeButtonForward();
		myWorld.getSpot().turnRight();
		Image image = myWorld.getSpot().getCurrentView().getImage();
		currentView.setImage(image);
		setButtonForward();

	}

	/**
	 * The user advances to the next spot according to its vision direction.
	 * 
	 * @param event
	 *            click on forward.
	 */
	public void goForward(ActionEvent event) {

		if (setButtonForward()) {
			// Refresh the state before doing updates.
			removeButtonForward();
			resetItems();
			myWorld.changeSpot();
			Image image = myWorld.getSpot().getCurrentView().getImage();
			currentView.setImage(image);
			setButtonForward();
			setItems();
			printMessage();
		}
	}

	/**
	 * Initialize the starting position and start screen of the GUI.
	 */
	public void Initialise() {

		Image image = myWorld.getSpot().getCurrentView().getImage();
		currentView.setImage(image);

		Image arrowL = new Image("img/arrowleft1.png");
		leftView.setImage(arrowL);

		Image arrowR = new Image("img/arrowright1.png");
		rightView.setImage(arrowR);

		setButtonForward();
		setItems();
		setCaseItems();
		printMessage();

	}

	/**
	 * Sets the Forward arrow button in case that there is a spot in the current
	 * direction of vision
	 * 
	 * @return boolean. True if the button has been set and vice versa.
	 */
	public boolean setButtonForward() {

		View currentView = myWorld.getSpot().getCurrentView();

		if (myWorld.getSpot().hasLink(currentView)) {

			Image arrowF = new Image("img/arrowforward1.png");
			forwardView.setImage(arrowF);

			return true;

		}
		return false;

	}

	/**
	 * Removes the Forward button.
	 */
	public void removeButtonForward() {

		forwardView.setImage(null);
	}

	/**
	 * Sets and displays in the GUI the items stored in the current location. It
	 * sets also the arrow controllers in case there is more than one item.
	 */
	public void setItems() {

		ArrayList<Item> items = myWorld.getSpot().getSpotItems();
		// Refresh the state of the menu.
		menuItems.getItems().clear();
		// Loop which fills the items display (3 items at a time).
		for (Item item : items) {
			// Update menu items.
			menuItems.getItems().add(new MenuItem(item.getText()));

			if (item0.getImage() == null) {

				item0.setImage(item.getImage());
				// Display of the hand which permits picking items.
				Image myHand = new Image("img/hand.png");
				hand.setImage(myHand);

			} else if (item1.getImage() == null) {

				item1.setImage(item.getImage());
				// Display of the arrows which permit shift the items displayed.
				Image itemsL = new Image("img/arrowleft1.png");
				itemsLeft.setImage(itemsL);

				Image itemsR = new Image("img/arrowright1.png");
				itemsRight.setImage(itemsR);

			} else if (item2.getImage() == null) {

				item2.setImage(item.getImage());

			}
		}
	}

	/**
	 * Removes all the items of the current location from the GUI.
	 */
	public void resetItems() {

		ImageView[] itemViews = new ImageView[] { item0, item1, item2, itemsLeft, itemsRight, hand };

		for (ImageView item : itemViews) {

			item.setImage(null);
		}
	}

	/**
	 * Removes all the items of the player from the GUI.
	 */
	public void resetCaseItems() {

		itemCase.setImage(null);
		rightCase.setImage(null);
		leftCase.setImage(null);
	}

	/**
	 * Sets and displays in the GUI the items stored by the player. It sets also the
	 * arrow controllers in case there is more than one item.
	 */
	public void setCaseItems() {

		ArrayList<Item> items = myWorld.getSuitcaseItems();
		// Refresh the state of the menu.
		menuSuitcase.getItems().clear();
		for (Item item : items) {
			// Update menu items.
			menuSuitcase.getItems().add(new MenuItem(item.getText()));

			if ((itemCase.getImage() == null) && items.size() > 0) {

				itemCase.setImage(item.getImage());

			} else if (leftCase.getImage() == null) {
				// displays the arrows to shift the items if there are more than one.
				Image caseL = new Image("img/arrowleft1.png");
				leftCase.setImage(caseL);

				Image caseR = new Image("img/arrowright1.png");
				rightCase.setImage(caseR);

			}
		}

	}

	/**
	 * Displays the next item of the player suitcase to the left.
	 * 
	 * @param event
	 *            click on caseL.
	 */
	public void lookCaseRight(ActionEvent event) {

		resetCaseItems();
		ArrayList<Item> caseItems = myWorld.getSuitcaseItems();
		// Shifts every element of the list one position to the right (mod length).
		Collections.rotate(caseItems, 1);
		myWorld.updateItems(caseItems);
		setCaseItems();
	}

	/**
	 * Displays the next item of the player suitcase to the right.
	 * 
	 * @param event
	 *            click on caseR.
	 */
	public void lookCaseLeft(ActionEvent event) {

		resetCaseItems();
		ArrayList<Item> caseItems = myWorld.getSuitcaseItems();
		// Shifts every element of the list one position to the left (mod length).
		Collections.rotate(caseItems, -1);
		myWorld.updateItems(caseItems);
		setCaseItems();
	}

	/**
	 * Shifts the list of items of the spot one position to the right.
	 * 
	 * @param event
	 *            click on itemsR.
	 */
	public void lookItemsRight(ActionEvent event) {

		resetItems();
		ArrayList<Item> spotItems = myWorld.getSpot().getSpotItems();
		// Shifts every element of the list one position to the right (mod length).
		Collections.rotate(spotItems, 1);
		myWorld.getSpot().updateItems(spotItems);
		setItems();
	}

	/**
	 * Shifts the list of items of the spot one position to the left.
	 * 
	 * @param event
	 *            click on itemsL.
	 */
	public void lookItemsLeft(ActionEvent event) {

		resetItems();
		ArrayList<Item> spotItems = myWorld.getSpot().getSpotItems();
		// Shifts every element of the list one position to the left (mod length).
		Collections.rotate(spotItems, -1);
		myWorld.getSpot().updateItems(spotItems);
		setItems();
	}

	/**
	 * Drops the item displayed in the user suitcase, and it is displayed in the
	 * spot items list.
	 * 
	 * @param event
	 *            click on drop button.
	 */
	public void dropItem(ActionEvent event) {

		ArrayList<Item> caseItems = myWorld.getSuitcaseItems();

		if (caseItems.isEmpty()) {
			return;
		}
		// Selects the first item of the case (the one which is displayed).
		Item updateItem = caseItems.get(0);
		// Item moved from the suitcase to the currentSpot.
		myWorld.dropItem(updateItem);
		// Refresh the state of the GUI.
		resetItems();
		setItems();
		resetCaseItems();
		setCaseItems();
	}

	/**
	 * Picks the big first item of the three displayed by the GUI, and it is
	 * displayed in the users suitcase.
	 * 
	 * @param event
	 *            click on pick button.
	 */
	public void pickItem(ActionEvent event) {
		// All the items in the current Spot.
		ArrayList<Item> spotItems = myWorld.getSpot().getSpotItems();

		if (spotItems.isEmpty()) {

			return;
		}
		// Selects the first item of the case (the first one in left).
		Item updateItem = spotItems.get(0);
		// Item moved from the currentSpot to the suitcase.
		myWorld.pickItem(updateItem);
		// Update state in the GUI.
		resetItems();
		setItems();
		resetCaseItems();
		setCaseItems();
	}

	/**
	 * Closes the application.
	 * 
	 * @param event
	 *            Click in the exit menu item.
	 */
	public void exitWorld(ActionEvent event) {

		System.exit(0);
	}

}
