package JavaForMobileTutorials;

import java.util.ArrayList;

public class Phone {
    private ArrayList<String> contacts;
    private ArrayList<String> messages;
    private ArrayList<ArrayList<String>> messagesContent;

    /**
     * For Contact List and Manipulate
     */
    public void addContact(String number) {
        this.contacts.add(number);
    }

    public void showAllContacts() {
        if (this.contacts.isEmpty())
            System.out.println("Contacts is empty !");
        else {
            for (int i = 0; i < this.contacts.size() + 1; i++) {
                System.out.println("Contact " + i + this.contacts.get(i));
            }
        }
    }

    public void searchContact(String number) {
        if (this.contacts.contains(number)) {
            System.out.println("This number is exist. Check it out below !");
            System.out.println(number + " .Index of number in Contact List: " + this.contacts.indexOf(number));
        } else
            System.out.println("This number doesn't exist !");
    }

    public void deleteContact(String number) {
        if (this.contacts.contains(number)) {
            System.out.println("Deleting ... ... ...");
            this.contacts.remove(number);
            System.out.println("Successful Deleted");
        } else {
            System.out.println("This number doesn't exist !");
        }
    }

    /**
     * For Message List
     */
    public void showListMessage() {
        if (this.messages.isEmpty())
            System.out.println("No messages exist !");
        else {
            for (int i = 0; i < this.messages.size() + 1; i++) {
                System.out.println("Message to " + this.messages.get(i));
            }
        }
    }

    public void showMessageContent(String number){

    }

}
