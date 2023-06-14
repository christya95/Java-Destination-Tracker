/*
 * Author: Josua Christyanton
 * Date: October 16th 2020
 * 
 * Description: Simple Model for the Destination object.
 * */
package ca.sheridancollege.christya.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destination implements Serializable {

	private String name;
	private Long duration;
	private String wentWith;
	private String year;
	private String comment;

}
