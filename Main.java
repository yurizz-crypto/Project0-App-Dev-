import java.util.Scanner;

public class Main
{

    private static final String[][] MENUS = { {
            // Main Menu
            "Add New Contact", "Edit Contact", "Delete Contact", "View Phonebook", "Exit" },
            {
                    // Edit Contact Menu
                    "Student Number", "First Name", "Last Name", "Occupation", "Country Code",
                    "Area Code", "Phone Number", "None - Go back to Main Menu" },
            {
                    // Menu for View Phonebook
                    "View All", "View Contact through ID", "View Contacts through Country Code",
                    "Go back to Main Menu" }, };
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        Phonebook pb = new Phonebook();
        // For Testing
        Person p1 = new Person("123", "Juan", "Dela Cruz", "Male", "Faculty", "12345", 63, 81);
        Person p2 = new Person("321", "Maria", "Clara", "Female", "Maiden", "18721", 63, 122);
        Person p3 = new Person("67667", "Jose", "Rizal", "Male", "Makata", "19911", 60, 12);
        Person p4 = new Person("11919", "Charlizz", "Betista", "Male", "Programmer", "10091", 670, 195);
        Person p5 = new Person("86711", "David", "Teeger", "Male", "Teacher", "997751", 84, 100);
        pb.insert(p5);
        pb.insert(p2);
        pb.insert(p4);
        pb.insert(p1);
        pb.insert(p3);

        boolean exit = false;
        while (true)
        {
            showMenu(1, 1);
            // System.out.print("Select an option: ");
            // int opt = input.nextInt();
            int opt = Integer.parseInt(prompt("Select an option: "));
            switch (opt)
            {
                case 1:
                    while (true){
                        pb.insert(createNewPerson());
                        System.out.println("Do you want to enter another entry [Y/N]? ");
                        if (input.nextLine().toLowerCase().equals("y")) {
                            System.out.println("\n");
                            continue;
                        }
                        else {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true)
                    {
                        String ID = prompt("Enter Contact ID ('q' to quit): ");
                        Person P = pb.getContact(ID);
                        if (ID.equals("q")) {exit = true; break;}

                        if (P != null)
                        {
                            while (true) {
                                System.out.println("\nInformation about " + ID + " : \n" + P.toString() + "\n");
                                showMenu(2, 3);
                                int toEdit = Integer.parseInt(prompt("\nEnter choice: "));

                                if (toEdit == 8) {break;}
                                else if (toEdit == 1) {
                                    System.out.println("\nEnter new student number: ");
                                    String newStudentNumber = input.nextLine();
                                    P.setId(newStudentNumber);
                                } else if (toEdit == 2) {
                                    System.out.println("\nEnter new first name: ");
                                    String newFirstName = input.nextLine();
                                    P.setFName(newFirstName);
                                } else if (toEdit == 3) {
                                    System.out.println("\nEnter new last name: ");
                                    String newLastName = input.nextLine();
                                    P.setLName(newLastName);
                                } else if (toEdit == 4) {
                                    System.out.println("\nEnter new occupation: ");
                                    String newOccupation = input.nextLine();
                                    P.setOccupation(newOccupation);
                                } else if (toEdit == 5) {
                                    System.out.println("\nEnter new country code: ");
                                    int newCountryCode = input.nextInt();
                                    P.setCountryCode(newCountryCode);
                                    input.nextLine();
                                } else if (toEdit == 6) {
                                    System.out.println("\nEnter new area code: ");
                                    int newAreaCode = input.nextInt();
                                    P.setAreaCode(newAreaCode);
                                    input.nextLine();
                                } else if (toEdit == 7) {
                                    System.out.println("\nEnter new phone number: ");
                                    String newPhoneNumber = input.nextLine();
                                    P.setContactNum(newPhoneNumber);
                                } else {
                                    System.out.println("\nInvalid Input! Try Again.");
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Contact not found.");
                        }
                        break;
                    }
                    continue;
                case 3:
                    String id = prompt("Enter contact ID to delete: ");
                    Person p = pb.getContact(id);
                    if (p != null)
                    {
                        Person deletedContact = pb.deleteContact(id);
                        if (deletedContact != null)
                        {
                            System.out.println("Contact has been successfully deleted!");
                        }
                    }
                    else
                    {
                        System.out.println("This contact does not exist!");
                    }
                    break;
                case 4:
                    while (true)
                    {
                        showMenu(3, 1);
                        int showOpt = Integer.parseInt(prompt("Enter option:"));
                        if (showOpt == 1) {System.out.println(pb);}
                        else if (showOpt == 2)
                        {
                            String targetId = prompt("Enter id to search: ");
                            Person target = pb.getContact(targetId);
                            if (target != null)
                            {
                                System.out.println(target);
                            }
                            else
                            {
                                System.out.println("No contact exists with that surname!");
                            }
                        }
                        else if (showOpt == 3)
                        {
                            int ccCount = 0;
                            int[] countryCodes = new int[9];
                            while (true)
                            {
                                int countryCode = Integer.parseInt(prompt("Enter Country Code: "));
                                // Print if input is 0
                                if (countryCode == 0)
                                {
                                    System.out.println(pb.printContactsFromCountryCodes(countryCodes));
                                    break;
                                }
                                // Check if area code is already inputted
                                boolean exists = false;
                                for (int a : countryCodes)
                                {
                                    if (a == countryCode)
                                    {
                                        System.out.println(
                                                "This area code has already been inputted!");
                                        exists = true;
                                        break;
                                    }
                                }
                                // Only add if area codes isn't part of the array...
                                if (!exists)
                                {
                                    countryCodes[ccCount] = countryCode;
                                    ccCount++;
                                }

                            }
                        }
                        else if (showOpt == 4)
                        {
                            break;
                        }
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
            if (exit)
                break;
        }
    }

    /**
     * Show menu based on given index. <br>
     * <br>
     * 1 for Main Menu. <br>
     * <br>
     * 2 for Edit Contact Menu. <br>
     * <br>
     * 3 for View Phonebook Menu. <br>
     * <br>
     * 4 for Country Code Menu.
     *
     * @param menuIdx Index of the menu to be shown.
     * @param inlineTexts Number of menu options to be printed in a single line. Set to 1 if you
     *        want every line to only have one menu option.
     */
    private static void showMenu(int menuIdx, int inlineTexts)
    {
        String[] menu = MENUS[menuIdx - 1];
        int count = 0;
        String space = inlineTexts == 0 ? "" : "%-12s";
        String fmt = "[%d] " + space;
        for (int i = 0; i < menu.length; i++)
        {
            System.out.printf(fmt, i + 1, menu[i]);
            if (inlineTexts != 0)
            {
                count += 1;
            }
            if (count % inlineTexts == 0)
            {
                System.out.print("\n");
            }
        }
    }

    /**
     * Convert choices from the menu into their appropriate country code values.
     *
     * @return Country code value of the menu choice.
     */
    private int convertChoices(int choice)
    {
        // Complete this method.
        return 0;
    }

    /**
     * Create a new person object using a slightly complicated setup.
     *
     * @return Newly created person object.
     */
    private static Person createNewPerson()
    {
        String id, fname, lname, sex, occupation, contactNum;
        int countryCode, areaCode;
        id = prompt("Enter Contact ID: ");
        fname = prompt("Enter First Name: ");
        lname = prompt("Enter Last Name: ");
        occupation = prompt("Enter Occupation: ");
        sex = prompt("Enter sex/gender: ");
        countryCode = Integer.parseInt(prompt("Enter Country Code: "));
        areaCode = Integer.parseInt(prompt("Enter Area Code: "));
        contactNum = prompt("Enter Contact Number: ");
        return new Person(id, fname, lname, sex, occupation, contactNum, countryCode, areaCode);
    }

    /**
     * Receive prompt and return the inputted value back to the variable or process that requires
     * it. Data type is String. Do not forget to type cast if possible.
     *
     * @param phrase Phrase to be given to user when requiring input.
     * @return Returns the data needed.
     */
    private static String prompt(String phrase)
    {
        System.out.print(phrase);
        return input.nextLine();
    }
}
