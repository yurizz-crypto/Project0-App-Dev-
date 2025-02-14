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
                    "Go back to Main Menu" },
            {
                    // Menu for View Contacts by Country Code
                    "Malaysia", "Indonesia", "Philippines", "Singapore", "Thailand", "Vietnam", "Brunei", "Cambodia", "Lao",
                    "Myanmar", "Timor Leste", "All"}};
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        Phonebook pb = new Phonebook();

        Person p1 = new Person("123", "Juan", "Dela Cruz", "Male", "Faculty", "12345", 63, 81);
        Person p2 = new Person("321", "Maria", "Clara", "Female", "Maiden", "18721", 63, 122);
        Person p3 = new Person("67667", "Jose", "Rizal", "Male", "Makata", "19911", 60, 12);
        Person p4 =
                new Person("11919", "Charlizz", "Betista", "Male", "Programmer", "10091", 670, 195);
        Person p5 = new Person("86711", "David", "Teeger", "Male", "Teacher", "997751", 84, 100);
        pb.insert(p5);
        pb.insert(p2);
        pb.insert(p4);
        pb.insert(p1);
        pb.insert(p3);

        boolean exit = false;
        while (true) {
            showMenu(1, 1);
            int opt;
            try {
                opt = Integer.parseInt(prompt("Select an option: "));
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Please enter a number.");
                continue;
            }
            System.out.print("\n");

            switch (opt) {
                case 1:
                    while (true) {
                        pb.insert(createNewPerson());
                        System.out.println("Do you want to enter another entry [Y/N]? ");
                        String choice = input.nextLine();
                        if (!choice.equalsIgnoreCase("y")) {
                            System.out.print("\n");
                            break;
                        }
                        System.out.print("\n");
                    }
                    break;

                case 2:
                    while (true) {
                        String ID = prompt("Enter Contact ID ('q' to quit): ");
                        if (ID.equals("q")) break; // Exit outer loop

                        Person P = pb.getContact(ID);
                        if (P != null) {
                            while (true) {
                                System.out.println("\nInformation about " + ID + " : \n" + P + "\n");
                                showMenu(2, 3);

                                String toEdit = prompt("\nEnter choice: ").trim();

                                if (toEdit.equals("8")) break; // Exit inner loop

                                switch (toEdit) {
                                    case "1":
                                        System.out.println("Enter new student number: ");
                                        String studentNumber = input.nextLine();
                                        P.setId(studentNumber);
                                        break;

                                    case "2":
                                        System.out.println("Enter new first name: ");
                                        P.setFName(input.nextLine());
                                        break;

                                    case "3":
                                        System.out.println("Enter new last name: ");
                                        P.setLName(input.nextLine());
                                        pb.insert(pb.deleteContact(P.getId()));
                                        break;

                                    case "4":
                                        System.out.println("Enter new occupation: ");
                                        P.setOccupation(input.nextLine());
                                        break;

                                    case "5":
                                        System.out.println("Enter new country code: ");
                                        try {
                                            P.setCountryCode(Integer.parseInt(input.nextLine()));
                                        } catch (NumberFormatException e) {
                                            System.out.println("Invalid input! Try again.");
                                        }
                                        break;

                                    case "6":
                                        System.out.println("Enter new area code: ");
                                        try {
                                            P.setAreaCode(Integer.parseInt(input.nextLine()));
                                        } catch (NumberFormatException e) {
                                            System.out.println("Invalid input! Try again.");
                                        }
                                        break;

                                    case "7":
                                        System.out.println("Enter new phone number: ");
                                        P.setContactNum(input.nextLine());
                                        break;

                                    default:
                                        System.out.println("Invalid Input! Try Again.");
                                }
                            }
                        } else {
                            System.out.println("Contact not found.");
                            continue;
                        }
                        break;
                    }
                    break;
                case 3:
                    String id = prompt("Enter contact ID to delete: ");
                    Person p = pb.getContact(id);
                    if (p != null) {
                        if (pb.deleteContact(id) != null) {
                            System.out.println("Contact has been successfully deleted!");
                        }
                    } else {
                        System.out.println("This contact does not exist!");
                    }
                    break;

                case 4:
                    while (true) {
                        showMenu(3, 1);
                        int showOpt;
                        try {
                            showOpt = Integer.parseInt(prompt("Enter option: "));
                        } catch (NumberFormatException e) {
                            System.out.println("\nInvalid input! Please enter a number.");
                            continue;
                        }

                        if (showOpt == 1)
                        {
                            System.out.println("\nContacts Added to Phonebook:\n" + pb);
                            if (pb.isEmpty()) {
                                System.out.println("The phonebook is empty...\n");
                            }
                        }
                        else if (showOpt == 2)
                        {
                            String targetId = prompt("Enter id to search: ");
                            Person target = pb.getContact(targetId);
                            System.out.println(target != null ? "Information about " + targetId + " : \n" + target + "\n" : "No contact exists with that ID number!\n");
                        }
                        else if (showOpt == 3)
                        {
                            int ccCount = 0;
                            int[] countryCodes = new int[11];
                            while (true)
                            {
                                System.out.println("From which country:");
                                showMenu(4, 3);
                                System.out.print("[0] No more");
                                System.out.print("\n");
                                int countryCode;
                                try {
                                    countryCode = Integer.parseInt(prompt("\nEnter Country Code: "));
                                } catch (NumberFormatException e) {
                                    System.out.println("\nInvalid input! Try again.");
                                    continue;
                                }

                                if (ccCount == 11 || countryCode == 12) {
                                    System.out.println("\nHere are the contact(s) from all countries:\n" + pb);
                                    break;
                                }

                                // Print if input is 0
                                if (countryCode == 0) {
                                    System.out.print("\nHere are the contact(s) from ");
                                    if (pb.isEmpty()) {
                                        System.out.println("\nThe phonebook is empty...\n");
                                        break;
                                    }
                                    for (int i = 0; i < ccCount; i++) {
                                        if (i > 0) System.out.print((i == ccCount - 1) ? " and " : ", ");
                                        System.out.print(MENUS[3][i]);
                                    }
                                    System.out.println(":");
                                    System.out.println(pb.printContactsFromCountryCodes(countryCodes));
                                    break;
                                }

                                // Check if area code is already inputted
                                boolean exists = false;
                                for (int a : countryCodes) {
                                    if (a == convertChoices(countryCode)) {
                                        System.out.println("This area code has already been inputted!\n");
                                        exists = true;
                                        break;
                                    }
                                }
                                // Only add if area codes isn't part of the array...
                                if (!exists) {
                                    countryCodes[ccCount++] = convertChoices(countryCode);
                                }
                            }
                        } else if (showOpt == 4) {
                            break;
                        } else {
                            System.out.println("Invalid input! Try again.");
                        }
                    }
                    break;

                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option!");
            }

            if (exit) break;
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
    private static int convertChoices(int choice)
    {
        // Complete this method.
        return switch (choice) {
            case 1 -> 60;
            case 2 -> 62;
            case 3 -> 63;
            case 4 -> 65;
            case 5 -> 66;
            case 6 -> 84;
            case 7 -> 673;
            case 8 -> 855;
            case 9 -> 856;
            case 10 -> 95;
            default -> 670;
        };
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
        sex = prompt("Enter sex/gender (M for male, F for female): ");
        String properSex = sex.toUpperCase().equals("M")? "Male" : "Female";
        countryCode = Integer.parseInt(prompt("Enter Country Code: "));
        areaCode = Integer.parseInt(prompt("Enter Area Code: "));
        contactNum = prompt("Enter Contact Number: ");
        return new Person(id, fname, lname, properSex, occupation, contactNum, countryCode, areaCode);
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
