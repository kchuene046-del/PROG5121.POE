/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121_poe;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kgomotso
 */
public class MessageManagement {
    Scanner input = new Scanner(System.in);
    public void displaySenderAndRecipient (ArrayList<Message> storedMessages){
        System.out.println("\n");
        for (int i = 0; i < storedMessages.size(); i++) {
            Message currentMessage = storedMessages.get(i);
            System.out.println("==================== Message "+(i+1)+" ====================");
            System.out.println("Sender: "+currentMessage.getSender()+"\nRecipient: "+currentMessage.getRecipient());
            System.out.println("\n");
        }
    }
    
    public void displayLongestStoredMessage(ArrayList<Message> storedMessages){
        int longestMessage = -1;
         Message message = new Message("10001",0,"Kgomotso","Nosipho","Hey can you come over?");
         
        
        for (int i = 0; i < storedMessages.size(); i++) {
            Message currentMessage = storedMessages.get(i);
            
            if (currentMessage.getMessage().length() > longestMessage){
                message = currentMessage;
            }  
        }
        System.out.println("\n");
        System.out.println("====================Longest Message====================");
        
        System.out.println("Message ID: "+message.getMessageID() +"\nMessage Hash: "+message.getMessageHash()+
               "\nMessages Sent: "+message.getNumMesageSent()+"\nSender: "+message.getSender()+"\nRecipient: "+
               message.getRecipient() +"\nMessage: "+message.getMessage() +"\nStatus: " +message.getMessageStatus());
    }
    
    public void searchMessageByID(ArrayList<Message> storedMessages){
        
        System.out.println("\n");
        System.out.println("====================Search Message By ID====================");
        System.out.print("Enter the id you want to search for: ");
        String messageID = input.next();
        boolean found = false;
        Message currentMessage = null;
        
        
        for (int i = 0; i < storedMessages.size(); i++) {
             currentMessage = storedMessages.get(i);
             if(currentMessage.getMessageID().equals(messageID)){
                 found = true;
                 break;
             }
        }
        
        if(found == true){
        
        System.out.println("Message ID: "+currentMessage.getMessageID() +"\nMessage Hash: "+currentMessage.getMessageHash()+
               "\nMessages Sent: "+currentMessage.getNumMesageSent()+"\nSender: "+currentMessage.getSender()+"\nRecipient: "+
               currentMessage.getRecipient() +"\nMessage: "+currentMessage.getMessage() +"\nStatus: " +currentMessage.getMessageStatus()); 
        }
        else
        {
            System.out.println("Message ID not found");
        }
    }
    
     public void searchMessageByRecipient(ArrayList<Message> storedMessages){
        
        System.out.println("\n");
        System.out.println("====================Search Message By Recipient====================");
        System.out.print("Enter the recipient's phone number: ");
        String phoneNumber = input.next();
        boolean found = false;
        Message currentMessage = null;
        
        
        for (int i = 0; i < storedMessages.size(); i++) {
             currentMessage = storedMessages.get(i);
             if(currentMessage.getRecipient().equals(phoneNumber)){
                 found = true;
                 break;
             }
        }
        
        if(found == true){
        
        System.out.println("Message ID: "+currentMessage.getMessageID() +"\nMessage Hash: "+currentMessage.getMessageHash()+
               "\nMessages Sent: "+currentMessage.getNumMesageSent()+"\nSender: "+currentMessage.getSender()+"\nRecipient: "+
               currentMessage.getRecipient() +"\nMessage: "+currentMessage.getMessage() +"\nStatus: " +currentMessage.getMessageStatus()); 
        }
        else
        {
            System.out.println("Message recipient not found");
        }
    }
     
     public void deleteMessageByHash(ArrayList<Message> storedMessages){
        
        System.out.println("\n");
        System.out.println("====================Delete Message By Hash====================");
        System.out.print("Enter the Hash code: ");
        String hashCode = input.next();
        boolean found = false;
        int pos = -1;
        Message currentMessage = null;
        
        
        for (int i = 0; i < storedMessages.size(); i++) {
             currentMessage = storedMessages.get(i);
             if(currentMessage.getMessageHash().equals(hashCode)){
                 found = true;
                 pos = i;
                 break;
             }
        }
        
        if(found == true){
          
           System.out.println("Message ID: "+currentMessage.getMessageID() +"\nMessage Hash: "+currentMessage.getMessageHash()+
               "\nMessages Sent: "+currentMessage.getNumMesageSent()+"\nSender: "+currentMessage.getSender()+"\nRecipient: "+
               currentMessage.getRecipient() +"\nMessage: "+currentMessage.getMessage() +"\nStatus: " +currentMessage.getMessageStatus()); 
            System.out.println("\n");
            
            storedMessages.remove(pos);
            currentMessage.StoreMessages(storedMessages);
           System.out.println("This messages has been Successfully deleted");
        }
        else
        {
            System.out.println("Hash code not found");
        }
    }
     
     
     public void reportOfStoredMessages(ArrayList<Message> storedMessages){
         System.out.println("\n");
        for (int i = 0; i < storedMessages.size(); i++) {
            Message currentMessage = storedMessages.get(i);
            System.out.println("==================== Message "+(i+1)+" ====================");
           System.out.println("Message ID: "+currentMessage.getMessageID() +"\nMessage Hash: "+currentMessage.getMessageHash()+
               "\nMessages Sent: "+currentMessage.getNumMesageSent()+"\nSender: "+currentMessage.getSender()+"\nRecipient: "+
               currentMessage.getRecipient() +"\nMessage: "+currentMessage.getMessage() +"\nStatus: " +currentMessage.getMessageStatus());
            System.out.println("\n");
        }
    }    
    
}
