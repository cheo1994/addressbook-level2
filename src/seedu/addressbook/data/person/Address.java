package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in the format a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;
    
    public Block block;
    public Street street;
    public Unit unit;
    public PostalCode postalCode;
    
    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = address;
        
        splitAddressToComponents(address);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }
    
    /**
     * Assigns the Block, Street, Unit and PostalCode to the variables in Address
     */
    public void splitAddressToComponents(String address) {

    	String[] addressComponents = splitAddressByCommas(address);

        this.block = new Block(addressComponents[0]);
        this.street = new Street(addressComponents[1]);
        this.unit = new Unit(addressComponents[2]);
        this.postalCode = new PostalCode(addressComponents[3]);
    	
    }
    
    /**
     * Returns an array of string comprising of the components in the address separated by commas. 
     */
    public String[] splitAddressByCommas(String address) {
    	
    	String[] addressComponents = address.split(",");
    	
    	return addressComponents;
    	
    }
    
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    public class Block {
        
    	private final String block;
        
        public Block(String block) {
    		this.block = block;
    	}
        
        public String getBlock() {
        	return this.block;
        }
    }
    
    public class Street {
    	
    	private final String street;
    	
    	public Street(String street) {
    		this.street = street;
    	}
    	
    	public String getStreet() {
    		return this.street;
    	}
    	
    }
    
    public class Unit {
    	
    	private final String unit;
    	
    	public Unit(String unit) {
    		this.unit = unit;
    	}
    	
    	public String getUnit() {
    		return this.unit;
    	}
    }
    
    public class PostalCode {
    	
    	private final String postalCode;
    	
    	public PostalCode(String postalCode) {
    		this.postalCode = postalCode;
    	}
    	
    	public String getPostalCode() {
    		return this.postalCode;
    	}
    }
}