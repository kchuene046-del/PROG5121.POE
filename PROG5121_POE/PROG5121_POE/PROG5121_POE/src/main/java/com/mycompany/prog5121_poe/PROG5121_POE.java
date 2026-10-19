/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121_poe;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kgomotso
 */
public class PROG5121_POE {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Message messageObj;
        
        
        String firstName;
        String lastName;
        String userName;
        String phoneNumber;
        String password;
        String registerUserName;
        String registerPassword;
       
        //Creating an object of Message class
        //(used to call the Message check methods before a new message is created)
            messageObj = new Message("10001",0,"Kgomotso","Hey can you come over?");

        //Creating an object of Login
            loginObj = new Login();
            
     //=======================Registration=================================== 
        System.out.println();
        System.out.println("REGISTRATION");
     // Ask for first name
        System.out.print("Enter your first name: ");
         firstName = input.nextLine();
        
    // Ask for last name
        System.out.print("Enter your last name: ");
        lastName = input.nextLine();
        
    // Ask for phone number
        System.out.print("Enter your phone number: ");
        phoneNumber = input.nextLine();
          
          while(!loginObj.checkCellPhoneNumber(phoneNumber))
            {
              System.out.println();
              System.out.println("Cell phone number incorrectly formatted or "
                      + "does not contain international code");
              System.out.println();
              System.out.print("Enter your phone number: ");
              phoneNumber = input.nextLine();
            }
          
    // Ask for user name
        System.out.print("Enter your user name: ");
        registerUserName = input.nextLine();

        while(!loginObj.checkUserName(registerUserName))
          {
           System.out.println();
           System.out.println("Username is not correctly formatted, please ensure that your username contains "
                 + "and underscore and is no more than 5 characters in length");
           System.out.println();
           System.out.print("Enter your user name: ");
           registerUserName = input.nextLine();
           }
    // Ask for password
        System.out.print("Enter your password: ");
        registerPassword = input.nextLine();
        System.out.println();
        System.out.println();

        while(!loginObj.checkPasswordComplexity(registerPassword))
         {
           System.out.println();
           System.out.println("\nPasword is not correctly formatted, please ensure that your password contains "
                        + "at least 8 characters, a capital letter, a number, and a special character");
           System.out.println();
           System.out.print("Enter your password: ");
           registerPassword = input.nextLine();
         }
       System.out.println(Login.registerUser(firstName,lastName,phoneNumber,registerUserName,registerPassword));

       System.out.println();
       System.out.println();
       
       //======================Login============================================
       
       System.out.println("LOGIN");
        // Ask for user name
         System.out.print("Enter your user name: ");
         userName = input.nextLine();

          while(!loginObj.checkUserName(userName))
         {
             System.out.println();
             System.out.println("Username is not correctly formatted, please ensure that your username contains "
                           + "and underscore and is no more than 5 characters in length");
             System.out.println();
             System.out.print("Enter your user name: ");
            userName = input.nextLine();
         }

       // Ask for password
         System.out.print("Enter your password: ");
         password = input.nextLine();

         while(!loginObj.checkPasswordComplexity(password))
         {
             System.out.println();
             System.out.println("\nPasword is not correctly formatted, please ensure that your password contains "
                           + "at least 8 characters, a capital letter, a number, and a special character");
             System.out.println();
             System.out.print("Enter your password: ");
             password = input.nextLine();
         }

       System.out.println();
       System.out.println();
       System.out.println(Login.LoginStatus(firstName,lastName, userName, password,registerUserName, registerPassword));
        
    //=====================QuickChat (Part 2)===================================
        
      // Users can only send messages if they logged in successfully
         if (!Login.loginUser(userName, password, registerUserName, registerPassword))
         {
             System.out.println("You must log in successfully to use QuickChat. Goodbye.");
         }
         else{
             System.out.println();
         System.out.println();
         System.out.println("Welcome to QuickChat.");

         // The user decides how many messages they want to send
         System.out.print("How many messages would you like to send? ");
         int numberOfMessages = getNumber(input);
          
          while (numberOfMessages < 1)
         {
             System.out.print("Please enter a number of 1 or more: ");
             numberOfMessages = getNumber(input);
         }

        // Lists to keep the sent and stored messages
         ArrayList<Message> sentMessages = new ArrayList<>();
         ArrayList<Message> storedMessages = new ArrayList<>();

         int messageCount = 0;   // how many messages have been entered (also the message number in the hash)
         int option = 0;

         // The application runs until the user chooses Quit
        
        while (option != 3)
         {
             option = Menu(input);

             switch(option)
             {
                 case 1:
                 {
                     // Stop if the user has already entered the number of messages they chose
                     if (messageCount >= numberOfMessages)
                     {
                         System.out.println("You have already entered all " + numberOfMessages + " message(s).");
                         break;
                     }

                     System.out.println();
                     System.out.println("----- Message " + (messageCount + 1) + " -----");

                     // Creating a random ten-digit message ID
                     String messageID = Message.generateMessageID();

                     // Ask for the recipient's cell number
                     System.out.print("Enter the recipient's cell number: ");
                     String recipient = input.nextLine();
                     
                      while (!Login.checkCellPhoneNumber(recipient))
                     {
                         System.out.println(messageObj.checkRecipientCell(recipient));
                         System.out.print("Enter the recipient's cell number: ");
                         recipient = input.nextLine();
                     }
                     System.out.println(messageObj.checkRecipientCell(recipient));

                     // Ask for the message (no more than 250 characters)
                     System.out.print("Enter your message: ");
                     String text = input.nextLine();
                     
                      while (text.trim().isEmpty() || text.length() > 250)
                     {
                         if (text.trim().isEmpty())
                         {
                             System.out.println("The message cannot be empty.");
                         }
                         else
                         {
                             System.out.println(messageObj.checkMessageLength(text));
                         }
                         System.out.print("Enter your message: ");
                         text = input.nextLine();
                     }
                     System.out.println(messageObj.checkMessageLength(text));
                     
                     // Creating the new message (the hash is created in the constructor)
                     Message newMessage = new Message(messageID, messageCount, recipient, text);
                     System.out.println(newMessage.messageIDCreated());
                     
                      // Ask what to do with the message
                     System.out.println();
                     System.out.println("Please Choose what you want to do with the message:");
                     System.out.println("1. Send Message\n2. Disregard Message\n3. Store Message");
                     int userChoice = getNumber(input);
                     
                      while (userChoice < 1 || userChoice > 3)
                     {
                         System.out.println(newMessage.SentMessage(userChoice));
                         userChoice = getNumber(input);
                     }
                     System.out.println(newMessage.SentMessage(userChoice));

                     if (userChoice == 1)
                     {
                         // Send: add it to the sent list and show its full details
                         sentMessages.add(newMessage);
                         System.out.println();
                         newMessage.DisplayMesage();
                     }
                     else if (userChoice == 2)
                     {
                         // Disregard: the user must press 0 to delete the message
                         String key = input.nextLine();
                         while (!key.equals("0"))
                         {
                             System.out.println("Press 0 to delete the message.");
                             key = input.nextLine();
                         }
                         System.out.println("Message deleted.");
                     }
                     else
                     {
                         // Store: add it to the stored list and save the list to the JSON file
                         storedMessages.add(newMessage);
                         newMessage.StoreMessages(storedMessages);
                     }

                     messageCount++;

                     // Once all the messages have been entered, show the total sent
                     if (messageCount == numberOfMessages)
                     {
                         System.out.println();
                         System.out.println("All messages have been entered.");
                         System.out.println("Total number of messages sent: " + messageObj.returnTotalMessages(sentMessages));
                     }
                     break;
                 }
                 
                  case 2:
                     System.out.println("Coming Soon.");
                     break;

                 case 3:
                     System.out.println("Total number of messages sent: " + messageObj.returnTotalMessages(sentMessages));
                     System.out.println("Goodbye.");
                     break;

                 default:
                     System.out.println("Invalid option, please choose 1, 2 or 3.");
                     break;
             }
         }
         input.close();
         
        }  
    }
       public static boolean checkCellPhoneNumber(String phoneNumber) {
         //checks if cell phone number contains national code
         if (phoneNumber != null && phoneNumber.matches("\\+27[0-9]{9}"))
         {
             return true;
        }
               return false;
     }
     
     //Shows the QuickChat menu and returns the option the user chose
    public static int Menu(Scanner input)
    {
        System.out.println();
        System.out.println("Please choose an option:");
        System.out.println("1) Send Messages");
        System.out.println("2) Show recently sent messages");
        System.out.println("3) Quit");
        System.out.print("Option: ");

        return getNumber(input);
    }

    //Reads a whole number from the user and keeps asking until they type a number
    public static int getNumber(Scanner input)
    {
        while (!input.hasNextInt())
        {
            input.nextLine();   // throws away what they typed
            System.out.print("Please enter a number: ");
        }
        int number = input.nextInt();
        input.nextLine();   // clears the leftover Enter so the next nextLine() works
        return number;
    }
}
     

