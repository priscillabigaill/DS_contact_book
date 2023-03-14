import java.nio.file.LinkPermission;
import java.util.Scanner;

public class ContactBookExercise {
    private static class Contact {
        private String name;
        private String phoneNum;
        private String email;
        private Contact next;

        private Contact(String name, String email, String phoneNum) {
            this.name = name;
            this.email = email;
            this.phoneNum = phoneNum;
            this.next = null;
        }
    }

    public static Contact head = null;

    // initial menu
    private static void menu(){
        System.out.println();
        System.out.println("*****************************");
        System.out.println("(A)dd");
        System.out.println("(D)elete");
        System.out.println("(E)mail Search");
        System.out.println("(P)rint List");
        System.out.println("(S)earch");
        System.out.println("(Q)uit");
        System.out.println("*****************************");
        System.out.print("Please enter a command: ");
    }

    // add method
    public static void add(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter email address: ");
        String email = input.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNum = input.nextLine();

        Contact contact = new Contact(name, email, phoneNum);

        // if linkedList is empty
        if (head == null){
            head = contact;
        } else { // if not, find the last node -> add new contact to the end
            Contact current = head;
            while (current.next != null){
                current = current.next;
            } 
            current.next = contact; 
        }
        System.out.println("\ncontact added.");
    }

    // delete method
    public static void delete() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name of the contact to delete: ");
        String delete = input.nextLine();
        
        if (head == null) {
            System.out.println("\nno contacts are currently in the contactBook.");
            return;
        } else if (head.name.equals(delete)) {
            // if the first contact's name matches, deletes it
            head = head.next;
            System.out.println("\ncontact deleted.");
            return;
        }

        // search for a matching name
        Contact current = head;
        while (current.next != null && !current.next.name.equals(delete)){
            current = current.next;
        }

        if (current.next != null){
            // after the contact is found, deletes that contact
            current.next = current.next.next;
            System.out.println("\ncontact deleted.");
            return;
        } else if (current.next == null) {
            // if the contact is not found
            System.out.println("\ncontact not found.");
            return;
        }
    }

    // search contact by email address
    public static void searchEmail(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter email address: ");
        String emailSrc = input.nextLine();

        Contact current = head;
        boolean x = false;

        while (current != null){
            if (current.email.equals(emailSrc)){
                System.out.println("\nName: " + current.name);
                System.out.println("Email Address: " + current.email);
                System.out.println("Phone Number: " + current.phoneNum);
                x = true;
            }
            current = current.next;
        }

        if (x == false){
            System.out.println("\nno contact found under that email address.");
        }
    }

    // print all contacts
    public static void print(){
        Contact current = head;
        while (current != null){
            System.out.println("\nName: " + current.name);
            System.out.println("Email Address: " + current.email);
            System.out.println("Phone Number: " + current.phoneNum);
            current = current.next;
        }
    }

    // search contact by name
    public static void searchContact(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        String nameSrc = input.nextLine();

        Contact current = head;
        boolean x = false;

        while (current != null){
            if (current.name.equals(nameSrc)){
                System.out.println("\nName: " + current.name);
                System.out.println("Email Address: " + current.email);
                System.out.println("Phone Number: " + current.phoneNum);
                x = true;
            }
            current = current.next;
        }

        if (x == false){
            System.out.println("\nno contact found under that name address.");
        }
    }



    // execute the program using main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String opt;

        do {
            menu();
            opt = input.nextLine();

            if (opt.equals("A")) {
                add();
            } else if (opt.equals("D")) {
                delete();
            } else if (opt.equals("E")) {
                searchEmail();
            } else if (opt.equals("P")) {
                print();
            } else if (opt.equals("S")) {
                searchContact();
            }
        } while (!opt.equals("Q"));
    }
}
