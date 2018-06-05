package model;

import java.util.*;

/**
 * Class that represents the World of our application. It loads and initializes
 * all the spots, views and items of the application. It stores the current Spot
 * where the user is located and the suitcase, which is the list of items
 * carried by the user.
 * 
 * @author Andres Monteoliva
 * @version 1.0
 *
 */
public class World {

	private Spot currentSpot;
	private ArrayList<Item> suitcase = new ArrayList<Item>();

	/**
	 * Constructor that calls the createWorld() function to load all the components
	 * of the world.
	 */
	public World() {

		createWorld();
	}

	/**
	 * Loads all the components of the world and sets an initial state of it.
	 */
	public void createWorld() {

		// Create all the spots in the World
		Spot corner = new Spot(" The corner");
		Spot road = new Spot("The road");
		Spot court = new Spot("The court");
		Spot park = new Spot("The park");
		Spot lane = new Spot("The bikes lane");
		Spot libOut = new Spot("library Out");
		Spot libIn = new Spot("library In");

		// Create all the items in the World
		Item gloves = new Item("gloves", "img/gloves.png");
		Item keys = new Item("keys", "img/keys.png");
		Item ipod = new Item("ipod", "img/ipod.png");
		Item beer = new Item("beer", "img/beer.png");
		Item compass = new Item("compass", "img/compass.png");
		Item baseball = new Item("baseball", "img/baseball.png");
		Item trophy = new Item("trophy", "img/trophy.png");
		Item rabbit = new Item("rabbit", "img/rabbit.png");
		Item egg = new Item("egg", "img/egg.png");
		Item cake = new Item("cake", "img/cake.png");
		Item hammer = new Item("hammer", "img/hammer.png");
		Item calculator = new Item("calculator", "img/calculator.png");

		// Add items to my backpack
		suitcase.add(compass);
		suitcase.add(baseball);
		suitcase.add(trophy);

		// Views of the MeadowsCorner
		View cornerNorth = new View("img/cornerNorth.jpg");
		View cornerSouth = new View("img/cornerSouth.jpg");
		View cornerEast = new View("img/cornerEast.jpg");
		View cornerWest = new View("img/cornerWest.jpg");

		// Add views to the MeadowsCorner
		corner.addView("north", cornerNorth);
		corner.addView("east", cornerEast);
		corner.addView("south", cornerSouth);
		corner.addView("west", cornerWest);

		// Add links to the MeadowsCorner
		corner.addLinks(cornerNorth, court);
		corner.addLinks(cornerWest, road);

		// Add items to the MeadowsCorner
		corner.addItem(beer);
		corner.addItem(gloves);
		corner.addItem(keys);

		// Views of the MeadowsRoad
		View roadNorth = new View("img/roadNorth.jpg");
		View roadSouth = new View("img/roadSouth.jpg");
		View roadEast = new View("img/roadEast.jpg");
		View roadWest = new View("img/roadWest.jpg");

		// Add views to the MeadowsRoad
		road.addView("north", roadNorth);
		road.addView("east", roadEast);
		road.addView("south", roadSouth);
		road.addView("west", roadWest);

		// Add links to the MeadowsRoad
		road.addLinks(roadEast, corner);
		road.addLinks(roadNorth, park);

		// Add items to the MeadowsRoad
		road.addItem(rabbit);

		// Views of the tennis Court
		View courtNorth = new View("img/courtNorth.jpg");
		View courtSouth = new View("img/courtSouth.jpg");
		View courtEast = new View("img/courtEast.jpg");
		View courtWest = new View("img/courtWest.jpg");

		// Add views to the tennis court
		court.addView("north", courtNorth);
		court.addView("east", courtEast);
		court.addView("south", courtSouth);
		court.addView("west", courtWest);

		// Add links to the tennis Court
		court.addLinks(courtSouth, corner);
		court.addLinks(courtWest, park);

		// Add items to the tennis Court
		court.addItem(egg);

		// Views of the Park
		View parkNorth = new View("img/parkNorth.jpg");
		View parkSouth = new View("img/parkSouth.jpg");
		View parkEast = new View("img/parkEast.jpg");
		View parkWest = new View("img/parkWest.jpg");

		// Add views to the Park
		park.addView("north", parkNorth);
		park.addView("east", parkEast);
		park.addView("south", parkSouth);
		park.addView("west", parkWest);

		// Add items to the Park
		park.addItem(cake);
		park.addItem(ipod);

		// Add links to the park

		park.addLinks(parkWest, lane);
		park.addLinks(parkEast, court);
		park.addLinks(parkSouth, road);

		// Views of the bikesLane
		View laneNorth = new View("img/laneNorth.jpg");
		View laneSouth = new View("img/laneSouth.jpg");
		View laneEast = new View("img/laneEast.jpg");
		View laneWest = new View("img/laneWest.jpg");

		// Add views to the BikesLane
		lane.addView("north", laneNorth);
		lane.addView("east", laneEast);
		lane.addView("south", laneSouth);
		lane.addView("west", laneWest);

		// Add links to the BikesLane
		lane.addLinks(laneNorth, libOut);
		lane.addLinks(laneEast, park);

		// Add items to the BikesLane
		lane.addItem(hammer);

		// View of the outside of the Library
		View libOutNorth = new View("img/libOutNorth.jpg");
		View libOutSouth = new View("img/libOutSouth.jpg");
		View libOutEast = new View("img/libOutEast.jpg");
		View libOutWest = new View("img/libOutWest.jpg");

		// Add views to the outside part of the Library
		libOut.addView("north", libOutNorth);
		libOut.addView("east", libOutEast);
		libOut.addView("south", libOutSouth);
		libOut.addView("west", libOutWest);

		// Add links to the outside part of the Library
		libOut.addLinks(libOutSouth, lane);
		libOut.addLinks(libOutEast, libIn);

		// View of the inside of the Library
		View libInNorth = new View("img/libInNorth.jpg");
		View libInSouth = new View("img/libInSouth.jpg");
		View libInEast = new View("img/libInEast.jpg");
		View libInWest = new View("img/libInWest.jpg");

		// Add views to the inside of the Library
		libIn.addView("north", libInNorth);
		libIn.addView("east", libInEast);
		libIn.addView("south", libInSouth);
		libIn.addView("west", libInWest);

		// Add links to the inside of the Library
		libIn.addLinks(libInWest, libOut);

		// Add items to the inside of the Library
		libIn.addItem(calculator);

		// Add items to the inside of the Library

		// Set the origin of our world
		currentSpot = corner;
		currentSpot.setDirection("north");

	}

	/**
	 * Retrieves the current spot of the world where the user is at.
	 * 
	 * @return Spot, the currentSpot of the world.
	 */
	public Spot getSpot() {

		return currentSpot;
	}

	/**
	 * Changes the currentSpot to the next one in the current vision direction, if
	 * any-
	 */
	public void changeSpot() {

		if (currentSpot.hasLink(currentSpot.getCurrentView()) == true) {

			String direction = currentSpot.getDirection();
			currentSpot = currentSpot.getLink(currentSpot.getCurrentView());
			// Maintains the current direction in the new Spot.
			currentSpot.setDirection(direction);

		}
	}

	/**
	 * Retrieves the list of items stored by the users in his/her suitcase.
	 * 
	 * @return A list of the Item elements.
	 */
	public ArrayList<Item> getSuitcaseItems() {

		return suitcase;
	}

	/**
	 * Updates the contents of the list of items stored by the user.
	 * 
	 * @param list
	 *            The updated list of items.
	 */
	public void updateItems(ArrayList<Item> list) {
		this.suitcase = list;
	}

	/**
	 * Picks an item from the current Spot and adds it to the list of items carried
	 * by the user
	 * 
	 * @param item
	 *            The item to be picked.
	 */
	public void pickItem(Item item) {

		currentSpot.removeItem(item);
		suitcase.add(0, item);
	}

	/**
	 * Drops an item from the list of items carried by the player and stores it in
	 * the list of items of the current Spot.
	 * 
	 * @param item
	 *            The item to be dropped.
	 */
	public void dropItem(Item item) {

		suitcase.remove(item);
		currentSpot.addItem(0, item);
	}

}
