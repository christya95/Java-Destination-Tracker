package ca.sheridancollege.christya.repositories;

import java.util.List;

import ca.sheridancollege.christya.beans.Destination;

//Interface to implement additional methods to our List
public interface DestinationList {

	public List<Destination> displayDestinationList();
	public void addDestiantion(Destination destination);
	public List<Destination> searchDestination(String year);
	
}
