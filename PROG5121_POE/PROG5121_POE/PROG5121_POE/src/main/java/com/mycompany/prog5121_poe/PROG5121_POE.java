/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121_poe;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 *
 * @author Kgomotso
 */
public class PROG5121_POE {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Message messageObj;
        Login loginObj;

        String firstName;
        String lastName;
        String userName;
        String phoneNumber;
        String password;
        String registerUserName;
        String registerPassword;
        //Creating an object of Message class
        //(used to call the Message check methods before a new message is created)
         messageObj = new Message("10001",0,"Kgomotso","Nosipho","Hey can you come over?");
         
          // Lists to keep the sent and stored messages
         ArrayList<Message> sentMessages = new ArrayList<>();
         ArrayList<Message> storedMessages = new ArrayList<>();
         ArrayList<Message> disregardedMessages = new ArrayList<>();
         ArrayList<String> messageHashArray = new ArrayList<>();
         ArrayList<String> messageIDArray = new ArrayList<>();
         loadMessages(storedMessages);
         

         //Creating an object of Login
         loginObj = new Login();

        //==========================Registration================================
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
             System.out.println("Cell phone number incorrectly formatted or does not contain international code");
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

       //================Login============================
       
       do{
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
         
          if (!Login.loginUser(userName, password, registerUserName, registerPassword))
         {
             System.out.println("You must log in successfully to use QuickChat. Goodbye.");
         }
       }
       while(!Login.loginUser(userName, password, registerUserName, registerPassword));
       

         //================QuickChat (Part 2)============================

         // Users can only send messages if they logged in successfully
        
         System.out.println();
         System.out.println();
         System.out.println("Welcome to QuickChat.");
         int messageCount = 0;   // how many messages have been entered (also the message number in the hash)
         int option = 0;

         // The application runs until the user chooses Quit
         while (option != 4)
         {
             option = menu(input);

             switch(option)
             {
                 case 1:
                 {
                     // The user decides how many messages they want to send
                    System.out.print("How many messages would you like to send? ");
                    int numberOfMessages = getNumber(input);

                    while (numberOfMessages < 1)
                    {
                        System.out.print("Please enter a number of 1 or more: ");
                        numberOfMessages = getNumber(input);
                    }
                     
                     // Stop if the user has already entered the number of messages they chose
                     if(messageCount == numberOfMessages)
                     {
                       System.out.println("You have already entered all " + numberOfMessages + " message(s).");
                     }
                     else
                     {
                          while(messageCount != numberOfMessages)
                            {
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
                               messageCount++;

                               Message newMessage = new Message(messageID, messageCount, recipient, firstName, text);


                               // Ask what to do with the message
                               System.out.println();
                               System.out.println("Please Choose what you want to do with the message:");
                               System.out.println("1. Send Message\n2. Disregard Message\n3. Store Message");
                               int userChoice = getNumber(input);

                               while (userChoice < 1 || userChoice > 4)
                               {
                                   System.out.println(newMessage.SentMessage(userChoice));
                                   userChoice = getNumber(input);
                               }
                               System.out.println(newMessage.SentMessage(userChoice));

                               if (userChoice == 1)
                               {
                                   // Send: add it to the sent list and show its full details
                                   newMessage.setStatus("Sent");
                                   sentMessages.add(newMessage);
                                   System.out.println();
                                   newMessage.DisplayMesage();
                               }
                               else if (userChoice == 2)
                               {
                                   // Disregard: the user must press 0 to delete the message
                                   newMessage.setStatus("Disregard");
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
                                   newMessage.setStatus("Stored");
                                   storedMessages.add(newMessage);
                                   newMessage.StoreMessages(storedMessages);
                               }



                               // Once all the messages have been entered, show the total sent
                               if (messageCount == numberOfMessages)
                               {
                                   System.out.println();
                                   System.out.println("All messages have been entered.");
                                   System.out.println("Total number of messages sent: " + messageObj.returnTotalMessages(sentMessages));
                                   messageCount = 0;
                                   numberOfMessages = 0;
                                   break;
                               }

                            }
                         
                     }

                     break;
                 }

                 case 2:
                     System.out.println("Coming Soon.");
                     break;
                     
                 case 3:
                     MessageManagement obj = new MessageManagement();
                     loadMessages(storedMessages);
                     storedMessagesMenu(input,obj,storedMessages);
                     break;

                 case 4:
                     System.out.println("Total number of messages sent: " + messageObj.returnTotalMessages(sentMessages));
                     System.out.println("Goodbye.");
                     break;

                 default:
                     System.out.println("Invalid option, please choose 1, 2,3, or 4");
                     break;
             }
             
         }
         input.close();    
    }

    //Shows the QuickChat menu and returns the option the user chose
    public static int menu(Scanner input)
    {
        System.out.println();
        System.out.println("Please choose an option:");
        System.out.println("1) Send Messages");
        System.out.println("2) Show recently sent messages");
        System.out.println("3) Stored messages");
        System.out.println("4) Quit");
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
    
   //Part 3 methods
           
    
// Stored Messages submenu
public static void storedMessagesMenu(Scanner input, MessageManagement management, ArrayList<Message> storedMessages)
{
    int choice = 0;

    while (choice != 7)
    {
        System.out.println("\n===== STORED MESSAGES =====");
        System.out.println("1. Display sender and recipient");
        System.out.println("2. Display longest stored message");
        System.out.println("3. Search message using ID");
        System.out.println("4. Search messages by recipient");
        System.out.println("5. Delete message using hash");
        System.out.println("6. Display stored message report");
        System.out.println("7. Return to main menu");

        System.out.print("Choose an option: ");
        choice = getNumber(input);

        switch (choice)
        {
            case 1:
                management.displaySenderAndRecipient(storedMessages);
                break;

            case 2:
                management.displayLongestStoredMessage(storedMessages);
                break;

            case 3:
                loadMessages(storedMessages);
                management.searchMessageByID(storedMessages);
                break;

            case 4:
                loadMessages(storedMessages);
                management.searchMessageByRecipient(storedMessages);
                break;

            case 5:
                loadMessages(storedMessages);
                management.deleteMessageByHash(storedMessages);
                break;

            case 6:
               loadMessages(storedMessages);
               management.reportOfStoredMessages(storedMessages);
                break;

            case 7:
                System.out.println("Returning to main menu...");
                break;

            default:
                System.out.println("Invalid option. Please choose 1-7.");
                break;
        }
    }
}

    public static void loadMessages(ArrayList<Message> storedMessages)
    {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("message.json"))
        {
            Type listType = new TypeToken<ArrayList<Message>>(){}.getType();

            ArrayList<Message> loadedMessages = gson.fromJson(reader, listType);

            if (loadedMessages != null)
            {
                storedMessages.clear();
                storedMessages.addAll(loadedMessages);

                System.out.println("Messages loaded successfully!");
                System.out.println("Total messages loaded: " + storedMessages.size());
            }
        }
        catch (Exception e)
        {
            System.out.println("Error loading messages: " + e.getMessage());
        }
    }
    
        
}

     

