import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter a command: \n"
                    + "1. contacts -a <firstName> <lastName>\n"
                    + "2. contacts -r <firstName> <lastName> \n"
                    + "3. show -g <groupName>\n"
                    + "4. show -c <firstName> <lastName> \n"
                    + "5. show\n"
                    + "6. exit");
            String command = scanner.nextLine().trim();
            String[] parts = command.split(" ");

            if (parts.length == 0) {
                System.out.println("Invalid command. Please try again.");
                continue;
            }

            if (parts[0].equals("contacts") && parts.length > 1) {
                if (parts[1].equals("-a") && parts.length == 4) {

                    Contact contact = new Contact();
                    contact.setName(parts[2]);
                    contact.setLastname(parts[3]);

                    System.out.print("enter group: ");
                    contact.setGroup(scanner.nextLine().trim());

                    System.out.print("enter email: ");
                    contact.setEmail(scanner.nextLine().trim());

                    System.out.print("enter country code: ");
                    contact.phonenumber.setCountrycode(scanner.nextLine().trim());

                    System.out.print("enter phone number: ");
                    contact.phonenumber.setNumber(scanner.nextLine().trim());

                    System.out.print("enter zip code: ");
                    contact.address.setZipCode(scanner.nextLine().trim());

                    System.out.print("enter country: ");
                    contact.address.setCountry(scanner.nextLine().trim());

                    System.out.print("enter city: ");
                    contact.address.setCity(scanner.nextLine().trim());

                    if (phoneBook.addContacts(contact)) {
                        System.out.println("Contact saved");
                    } else {
                        System.out.println("Already exists.");
                    }
                } else if (parts[1].equals("-r") && parts.length == 4) {

                    boolean removed = phoneBook.deleteContact(parts[2], parts[3]);
                    if (removed) {
                        System.out.println("Contact removed");
                    } else {
                        System.out.println("Not found.");
                    }
                } else {
                    System.out.println("Invalid command");
                }
            } else if (parts[0].equals("show")) {
                if (parts.length == 1) {

                    phoneBook.printContacts();
                } else if (parts.length == 3 && parts[1].equals("-g")) {

                    Contact[] contacts = phoneBook.findContacts(parts[2]);
                    if (contacts.length > 0) {
                        System.out.println("Contacts in group " + parts[2] + ":");
                        for (Contact contact : contacts) {
                            System.out.println("Name: " + contact.getName() + " " + contact.getLastname());
                        }
                    } else {
                        System.out.println("Notfound in group " + parts[2]);
                    }
                } else if (parts.length == 4 && parts[1].equals("-c")) {

                    Contact contact = phoneBook.findContact(parts[2], parts[3]);
                    if (contact != null) {
                        System.out.println("Contact details:");
                        System.out.println("Name: " + contact.getName() + " " + contact.getLastname());
                        System.out.println("Group: " + contact.getGroup());
                        System.out.println("Email: " + contact.getEmail());
                        System.out.println("Phone Number: " + contact.phonenumber);
                        System.out.println("Address: " + contact.address);
                    } else {
                        System.out.println("Contact not found.");
                    }
                } else {
                    System.out.println("Invalid command");
                }
            } else if (parts[0].equals("exit")) {
                System.out.println("Done");
                break;
            } else {
                System.out.println("Unknown command.try again");
            }
        }
    }
}