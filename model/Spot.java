package model;

import java.util.*;

/**
 * Spot class which stores all the views of spot, the list of items it holds and
 * the current direction of vision of the user. It can turn right or left the
 * vision of the user and check of connections with other spots.
 * 
 * @author Andres Monteoliva
 * @version 1.0
 *
 */
public class Spot {

	private HashMap<String, View> views = new HashMap<String, View>();
	private ArrayList<Item> items = new ArrayList<Item>();
	private HashMap<View, Spot> links = new HashMap<View, Spot>();

	private View currentView;
	private String currentDirection;
	private String spotName;

	/**
	 * Constructor of the class Spot.
	 * 
	 * @param name
	 *            name of the Spot to be constructed.
	 */
	public Spot(String name) {
		spotName = name;
	}

	/**
	 * Accessor to the name of the Spot
	 * 
	 * @return The name of the Spot.
	 */
	public String getSpotName() {

		return spotName;
	}

	/**
	 * Mutator method that sets the direction of vision of the user.
	 * 
	 * @param direction
	 *            The direction to be set to currentDirection.
	 */
	public void setDirection(String direction) {

		currentDirection = direction;
	}

	/**
	 * Accessor method that retrieves the current direction of vision of the user.
	 * 
	 * @return The currentDirection of the user vision.
	 */
	public String getDirection() {

		return currentDirection;
	}

	/**
	 * Retrieve the View for the current direction of vision of the user.
	 * 
	 * @return the currentView.
	 */
	public View getCurrentView() {

		currentView = views.get(currentDirection);
		return currentView;
	}

	/**
	 * Adds a View to a Spot in a determined direction.
	 * 
	 * @param direction
	 *            The direction of the view.
	 * @param view
	 *            The View to be added.
	 */
	public void addView(String direction, View view) {

		views.put(direction, view);
	}

	/**
	 * Adds a link or connection between a View of one Spot to another Spot.
	 * 
	 * @param view
	 *            The View to add the link.
	 * @param spot
	 *            The Spot to be linked to the View.
	 */
	public void addLinks(View view, Spot spot) {

		links.put(view, spot);
	}

	/**
	 * Checks if a View has a link to any Spot.
	 * 
	 * @param view
	 *            The View to be checked.
	 * @return A boolean, regarding of the availability of a link.
	 */
	public boolean hasLink(View view) {

		return links.containsKey(view);

	}

	/**
	 * Retrieves the Spot to which the View is connected, if any.
	 * 
	 * @param view
	 *            The View the link is is required of.
	 * @return The Spot to which the View is connected, if any.
	 */
	public Spot getLink(View view) {
		if (hasLink(view)) {

			return links.get(view);
		}

		return null;

	}

	/**
	 * Changes both the current direction of vision and its related current View to
	 * the next one on the right (clock-wise).
	 */
	public void turnRight() {

		String[] possibleDirection = new String[] { "north", "east", "south", "west" };

		int noViews = possibleDirection.length;

		// Retrieves the next element from currenDirection from possibleDirection list.
		currentDirection = possibleDirection[(Arrays.asList(possibleDirection).indexOf(currentDirection) + 1)
				% noViews];
		currentView = views.get(currentDirection);

	}

	/**
	 * Changes both the current direction of vision and its related current View to
	 * the next one on the left (anti clock-wise).
	 */
	public void turnLeft() {

		String[] possibleDirection = new String[] { "north", "east", "south", "west" };

		int noViews = possibleDirection.length;
		// Retrieves the previous element from currenDirection from possibleDirection
		// list.
		currentDirection = possibleDirection[(Arrays.asList(possibleDirection).indexOf(currentDirection) - 1 + noViews)
				% noViews];
		currentView = views.get(currentDirection);

	}

	/**
	 * Add an Item to the Spot.
	 * 
	 * @param item
	 *            the item to be added.
	 */
	public void addItem(Item item) {

		items.add(item);
	}

	/**
	 * Add an Item to the Spot in a defined index.
	 * 
	 * @param index
	 *            The index for the new item in the list of Items of the Spot.
	 * @param item
	 *            the item to be added.
	 */
	public void addItem(int index, Item item) {
		items.add(index, item);
	}

	/**
	 * Remove the item of the Spot's list of items.
	 * 
	 * @param item
	 *            The item to be removed.
	 */
	public void removeItem(Item item) {

		items.remove(item);
	}

	/**
	 * It retrieves the list of items stored in the Spot.
	 * 
	 * @return The list of items.
	 */
	public ArrayList<Item> getSpotItems() {

		return items;
	}

	/**
	 * Updates and refresh the list of items stored in the Spot.
	 * 
	 * @param list
	 */
	public void updateItems(ArrayList<Item> list) {
		this.items = list;
	}
}
