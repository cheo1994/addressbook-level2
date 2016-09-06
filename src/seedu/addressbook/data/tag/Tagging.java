package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Contains the name of the tag removed/added and the name of the person.
 */

public class Tagging {

	private String addOrDel;
	private Person person;
	private Tag tag;
	
	/**
	 * Constructs a Tagging with the given data.
	 * 
	 * @param command
	 * @param person
	 * @param tag
	 */
	public Tagging(String command, Person person, Tag tag) {
		if (command.equals("add")) {
			this.addOrDel = "+";
		} else if (command.equals("delete")) {
			this.addOrDel = "-";
		}
		this.person = person;
		this.tag = tag;
	}
	
	@Override
	public String toString() {
		return addOrDel + person.getName().toString() + tag.toString();
	}

}
