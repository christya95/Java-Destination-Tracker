/*
 * Author: Josua Christyanton
 * Date: October 16th 2020
 * 
 * Description: The following is the controller for the application, it receives all the
 * information from the view (HTML) and reroutes to corresponding mapping. A getMapping 
 * is used for any URL that sends information from server to the user. PostMapping is used
 * any time a form is used where the URL sends information from the user to the server.
 * */
package ca.sheridancollege.christya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.christya.beans.Destination;
import ca.sheridancollege.christya.repositories.DestinationList;

@Controller
public class DestinationController {

	// reference to interface
	private DestinationList destinationList;

	// Dependency injection using Constructor
	@Autowired
	public DestinationController(DestinationList destinationList) {
		// destinationList = new DestinationListImpl()
		super();
		this.destinationList = destinationList;
	}

	// Loads the index.html page
	@GetMapping("/")
	public String goIndex(Model model) {

		model.addAttribute("destination", new Destination());
		model.addAttribute("destinationList", destinationList.displayDestinationList());
		return "index";
	}

	// Post request for form
	@PostMapping("/postAddDestination")
	public String forPost(Model model, @ModelAttribute Destination destination) {

		// Add in the object created from form
		destinationList.addDestiantion(destination);

		// clear the place-holders
		model.addAttribute("destination", new Destination());
		model.addAttribute("destinationList", destinationList.displayDestinationList());

		return "addDestination";
	}

	// Get request to go to addDestination URL, you need this or you get error (need
	// to load page for user)
	@GetMapping("addDestination")
	public String addDestination(Model model) {
		model.addAttribute("destination", new Destination());
		model.addAttribute("destinationList", destinationList.displayDestinationList());
		return "addDestination";
	}

	// Post request for form
	@PostMapping("/postSearchDestination")
	public String postSearchDestination(Model model, @ModelAttribute Destination destination) {

		model.addAttribute("destination", new Destination());
		// Display the temporary list with the given year from user
		model.addAttribute("searchList", destinationList.searchDestination(destination.getYear()));

		return "searchDestination";
	}

	// Get request to go to searchDestination URL, you need this or you get error
	// (need to load page for user)
	@GetMapping("/searchDestination")
	public String searchDestination(Model model) {
		model.addAttribute("destination", new Destination());

		return "searchDestination";
	}

	// Get request to go to displayDestination URL, you need this or you get error
	// (need to load page for user)
	@GetMapping("/displayDestination")
	public String displayDestination(Model model) {

		model.addAttribute("destination", new Destination());
		// Display the destinationList with all destinations
		model.addAttribute("destinationList", destinationList.displayDestinationList());

		return "displayDestination";
	}

}
