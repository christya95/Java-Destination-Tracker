/*
 * Author: Josua Christyanton
 * Date: October 16th 2020
 * 
 * Description: The following writes implementations for the methods that are additional
 * to the lists. searchDestination is a method where a second temporary list is made
 * to display the desired filtered results from user. It is cleared upon method call to
 * avoid concatenating on top.
 * */
package ca.sheridancollege.christya.repositories;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import ca.sheridancollege.christya.beans.Destination;
import lombok.*;

@Component
@Data
public class DestinationListImpl implements DestinationList{

	//CopyOnWriteArrayList has something to do with security issue and multi-threading
	private List<Destination> destinationList = new CopyOnWriteArrayList<Destination>();
	
	
	//get entire List
	@Override
	public List<Destination> displayDestinationList() {
		return destinationList;
	}

	//add a destination to the end of List
	@Override
	public void addDestiantion(Destination destination) {
		destinationList.add(destination);
	}
	
	//Search through list for year entered, and update the temporary search list to display
	@Override
	public List<Destination> searchDestination(String year) {
		List<Destination> searchDestinationList = new CopyOnWriteArrayList<Destination>();
		
		//Error check to see if field is left empty, then return entire destinationList
		if (year.isBlank()) {
			return destinationList;
		}
		
		//Iterate through destinationList to see if Destination object has matching year
		for(Destination index : destinationList) {

			if (index.getYear().equals(year)) {
				searchDestinationList.add(index);
			}
		}
		return searchDestinationList;
	}
}
