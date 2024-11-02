import java.util.ArrayList;

public class PhoneBook {
    public ArrayList<Contact> contacts = new ArrayList<>();

    public Boolean addContacts(Contact contact) {
        if (contacts.contains(contact)) {
            System.out.println("Already exists");
            return false;
        } else {
            contacts.add(contact);
            System.out.println("Added");
            return true;
        }
    }

    public Contact findContact(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(firstName) && contact.getLastname().equals(lastName)) {
                return contact;
            }
        }
        return null;
    }

    public Boolean deleteContact(String firstName, String lastName) {
        boolean removed = contacts.removeIf(contact ->
                contact.getName().equals(firstName) && contact.getLastname().equals(lastName));
        if (removed) {
            System.out.println("Removed" + firstName + " " + lastName);
        } else {
            System.out.println("Not Found");
        }
        return removed;
    }

    Contact[] findContacts(String group) {
        ArrayList<Contact> groupedcontact = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getGroup().equals(group)) {
                groupedcontact.add(contact);
            }

        }
        return groupedcontact.toArray(new Contact[0]);
    }

    public void printContacts() {
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.getName());
            System.out.println("Last Name: " + contact.getLastname());
            System.out.println("Email: " + contact.getEmail());
            System.out.println("Phone Number: " + contact.phonenumber);
            System.out.println("Address: " + contact.address);
            System.out.println("------------------");
        }
    }
}