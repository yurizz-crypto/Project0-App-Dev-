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
        // Return the number of contacts stored in this phonebook (excluding null indices).
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
        // Return the contact at the given index where a Person object is assigned else returns null.
        if (this.getSize() > index && index >= 0)
        {
            return this.contacts[index];
        }
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
        // Return the contact with the given id. If it does not exist, return null.
        // Use the size of the phonebook to iterate through the array except the null indices.
        for (int i = 0; i < this.getSize(); i++)
        {
            if (this.contacts[i].getId().equals(id))
            {
                return this.contacts[i];
            }
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
        // Increase the size of the phonebook by 2 times.
        Person[] newContacts = new Person[this.contacts.length * 2];
        // Copy the existing contacts to the new array.
        for (int i = 0; i < this.getSize(); i++)
        {
            newContacts[i] = this.contacts[i];
        }
        // Assign the new array to the existing contacts.
        this.contacts = newContacts;

    }

    /**
     * Inserts a new person object at its appropriate lexicographic location in the phonebook.
     * 
     * @param p Person to be addded to the Phonebook.
     */
    public void insert(Person p)
    {
        // Complete this method
        for (int i = 0; i < this.size; i++)
        {
            if (this.contacts[i] != null && this.contacts[i].getFullName().equals(p.getFullName()))
            {
                return;
            }
        }
        
        if (this.size == this.contacts.length)
        {
            this.increasePhonebookMaxSize();
        }

        int index = this.findIndexInsertion(p);

        if (index == this.size) {
            this.contacts[index] = p;
        } else {
            this.adjustPhonebook(index, this.getSize(), "f");
            this.contacts[index] = p;
        }

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
        // If the phonebook is empty, return 0.
        if (this.getSize() == 0)
        {
            return 0;
        }
        // Iterate through the phonebook to find the appropriate index to insert the person object.
        for (int i = 0; i < this.size; i++) 
        {
            if (this.contacts[i] != null && this.contacts[i].compareTo(p) > 0)
            {
                return i;
            }
        }
        // If the person object is the last one to be inserted, return the next index.
        return this.getSize() - 1;
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
        // Adjust the phonebook from the starting index to the ending index following a direction.
        if (direction.equals("f"))
        {
            // Move the contacts from the starting index to the ending index following a direction.
            for (int i = start; i < end; i++)
            {
                if (i + 1 < this.getSize())
                {
                    this.contacts[i + 1] = this.contacts[i];
                }
            }
        }
        // Move the contacts from the ending index to the starting index following a direction.
        else if (direction.equals("b"))
        {
            for (int i = end; i > start; i--)
            {
                if (i - 1 >= 0 && i < this.getSize()){
                    this.contacts[i - 1] = this.contacts[i];
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
