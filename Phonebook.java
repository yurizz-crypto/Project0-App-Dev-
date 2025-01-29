public class Phonebook
{
    // Storage of contacts.
    private Person[] contacts;
    // Number of contacts present in the phonebook.
    private int size;

    /**
     * Create a phonebook of size 50.
     */
    public Phonebook()
    {
        contacts = new Person[50];
    }

    /**
     * @return Number of contacts stored in this phonebook.
     */
    public int getSize()
    {
        // Complete this method
        return this.size;
    }

    /**
     * Get the contact at index.
     * 
     * @param index Index to get contact.
     * @return Person object from index. Null if index is not valid or out of range.
     */
    public Person getContactAtIndex(int index)
    {
        // Complete this method
        // Check if index is within size where there's a contact assigned.
        if (index >= 0 && index < this.getSize()) {return contacts[index];}
        return null;
    }

    /**
     * Get the person object based on a given id.
     * 
     * @param id Target id.
     * @return Person object that has this id. Null if it does not exist.
     */
    public Person getContact(String id)
    {
        // Complete this method
        // Iterate then check if there's an equal ID and returns it.
        for (int i = 0; i < this.getSize(); i++)
        {
            if (contacts[i].getId().equals(id)) {return contacts[i];}
        }
        return null;
    }

    /**
     * Checks if this phonebook has contacts or not.
     * 
     * @return True or False.
     */
    public boolean isEmpty()
    {
        return this.getSize() == 0;
    }

    /**
     * Increase number of contacts present in this phonebook.
     */
    public void incrSize()
    {
        this.size++;
    }

    /**
     * Decrease number of contacts present in this phonebook.
     */
    public void decrSize()
    {
        this.size--;
    }

    /**
     * Increases the size of the phonebook whenever it is full.
     */
    private void increasePhonebookMaxSize()
    {
        // Complete this method
        // Declare new array with double the size of the current array.
        Person[] updatedContacts = new Person[contacts.length * 2];
        for (int i = 0; i < contacts.length; i++)
        {
            // Copy the existing contacts.
            updatedContacts[i] = contacts[i];
        }
        // Assign the new array to the current array.
        this.contacts = updatedContacts;
    }

    /**
     * Inserts a new person object at its appropriate lexicographic location in the phonebook.
     * 
     * @param p Person to be addded to the Phonebook.
     */
    public void insert(Person p)
    {
        // Complete this method
        if (this.getSize() == contacts.length) {this.increasePhonebookMaxSize();}

        int i = this.findIndexInsertion(p);
        this.adjustPhonebook(i, this.getSize(), "b");
        contacts[i] = p;
        this.incrSize();
    }

    /**
     * Searches in what index should this person object with the given be inserted.
     * 
     * @param p Person object to be inserted into the phonebook.
     * @return Appropriate index (position).
     */
    private int findIndexInsertion(Person p)
    {
        // Complete this method
        if (isEmpty()) {return 0;}

        // Iterate through the contacts and compare the person object.
        for (int i = 0; i < this.getSize(); i++)
        {
            // If the person object is less than the current contact, it means it is where it should be inserted.
            if (p.compareTo(contacts[i]) < 0)
            {
                return i;
            }
        }
        // If the person object is greater than all the contacts, it should be inserted at the end.
        return this.getSize();
    }

    /**
     * Delete a person based on their contact id.
     * 
     * @param id Contact ID of that contact.
     * @return Deleted contact.
     */
    public Person deleteContact(String id)
    {
        // Complete this method...
        if (isEmpty()){return null;}

        for (int i = 0; i < this.getSize(); i++)
        {
            if (contacts[i].getId().equals(id))
            {
                Person deletedContact = contacts[i];
                this.adjustPhonebook(i, this.getSize(), "f");
                this.decrSize();
                return deletedContact;
            }
        }
        return null;
    }

    /**
     * Adjusts the existing contacts in a phonebook from a given starting index to where it ends,
     * following a particular direction.
     * 
     * @param start Index to start adjustment from.
     * @param end Index to end adjustment into.
     * @param direction Direction in which the adjustment must be made. direction = "f" if element
     *        at index 0 takes the value of the element next to it (e.g. index 1). direction = "b"
     *        if element at index 1 takes the value of the element behind it (e.g. index 0).
     */
    private void adjustPhonebook(int start, int end, String direction)
    {
        // Complete this method...
        // Check if direction is forward or backward.
        if (direction.equals("f"))
        {   
            // Move the contacts to the left.
            for (int i = start; i < end; i++)
            {
                if (i + 1 < contacts.length) {
                    contacts[i] = contacts[i + 1];
                }
            }
        }
        else if (direction.equals("b"))
        {
            // Move the contacts to the right.
            for (int i = end; i > start; i--)
            {
                if (i - 1 >= 0) {
                    contacts[i] = contacts[i - 1];
                }
            }
        }
    }

    /**
     * Uses ellipsis to ambiguously accept as many country codes as possible. <br>
     * <br>
     * For example: <br>
     * <br>
     * If we have: printContactsFromCountryCodes(1, 2, 3) <br>
     * <br>
     * Then we get: countryCodes = { 1, 2, 3 };
     * 
     * @param countryCodes Area codes to be used as a filter.
     * @return Contacts on this phonebook under a particular area code set by the user.
     */
    public String printContactsFromCountryCodes(int... countryCodes)
    {
        // Complete this method.
        return "";
    }

    /**
     * Print the entire phonebook without any filter or so...
     * 
     * @return The entire list of contacts present in this phonebook.
     */
    public String toString()
    {
        // Complete this method.
        return "";
    }
}
