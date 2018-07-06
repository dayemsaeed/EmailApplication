package com.lumen;

import java.util.Scanner;

public class Email {

    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity;
    private String alternateEmail;
    private String company = "lumen";

    private static int default_length = 10;

    // Constructor to get first and last name

    public Email() {

        System.out.print("Enter Name (First, Last): ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String firstname = name.substring(0, name.indexOf(','));
        String lastname = name.substring(name.indexOf(',') + 2);

        this.firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);
        this.lastname = lastname.substring(0, 1).toUpperCase() + lastname.substring(1);

        System.out.println("The name has been set. The name is: " + this.firstname + " " + this.lastname);

        // Call department method and set the department value
        this.department = setDepartment();

        System.out.println("The department has been set. The department is: " + this.department);

        // Call password method and set the password
        this.password = generatePassword(default_length);

        System.out.println("The password has been generated. The password is: " + this.password);

        // Combine all the elements to make the email
        email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department.toLowerCase() + "." + company.toLowerCase() + ".com";

        System.out.println("The email address has been created. The email is: " + this.email);

        // Call Mailbox capacity method and set the mailbox capacity
        this.mailboxCapacity = setMailboxCapacity();

        System.out.println("The mailbox capacity has been set at: " + this.mailboxCapacity);

        // Call alternate email method and set the alternate email
        this.alternateEmail = setAlternateEmail();

        System.out.println("The alternate email has been set. The alternate email is: " + this.alternateEmail);

        // Call change password method and set the new password
        this.password = changePassword();

        System.out.println("The password has been changed. The new password is: " + this.password);

        // Show name, email, and mailbox capacity
        showInfo();

    }

    // Ask for the department

    private String setDepartment() {

        String department = " ";

        System.out.println("Enter the department");
        System.out.println("1 for sales");
        System.out.println("2 for development");
        System.out.println("3 for accounting");
        System.out.println("All other entries will be considered 'none'");
        System.out.print("Enter department code: ");
        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextInt()) {

            case 1:
                department = "Sales";
                break;

            case 2:
                department = "Development";
                break;

            case 3:
                department = "Accounting";
                break;

                default:
                    break;

        }

        return department;

    }

    // Generate a random password

    private String generatePassword(int length) {

        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%";
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {

            int rand = (int) (Math.random() * length);
            password[i] = passwordSet.charAt(rand);

        }

        return new String(password);

    }

    // Set mailbox capacity

    private int setMailboxCapacity() {

        System.out.print("Please enter mailbox capacity: ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();

    }

    // Set alternate email

    private String setAlternateEmail() {

        System.out.print("Please enter alternate email address: ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();

    }

    // Change the password

    private String changePassword() {

        String newPassword;

        System.out.print("Please enter the new password: ");
        Scanner scanner = new Scanner(System.in);
        newPassword = scanner.nextLine();

        return newPassword;

    }

    // Method to display name, email, and mailbox capacity

    private void showInfo() {

        String info = "Name: " + this.firstname + " " + this.lastname + "\n" + "Email: " + this.email + "\n" + "Mailbox Capacity: " + this.mailboxCapacity;

        System.out.println(info);

    }

}
