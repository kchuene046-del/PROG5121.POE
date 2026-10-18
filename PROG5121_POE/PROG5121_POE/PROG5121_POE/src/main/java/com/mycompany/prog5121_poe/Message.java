/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121_poe;

/**
 *
 * @author Kgomotso
 */
public class Message {
    //Class field
    private String messageID;
    private int numMesageSent;
    private String recipientCell;
    private String message;
    private String messageHash;
    private String messageStatus;
    //Constructor
    public Message(String messageID,
            int numMesageSent,
            String recipient,
            String message)
    {
        this.messageID = messageID;
        this.numMesageSent = numMesageSent;
        this.recipientCell = recipient;
        this.message = message;
        this.messageHash = "";
        this.messageStatus = "";
    }
    //Accessor methods accesses this claseses propaties from other classes
    public String getMessageID()
    {
        return this.messageID;
    }
    public int getNumMesageSent()
    {
        return this.numMesageSent;
    }
    public String getRecipient()
    {
        return this.recipientCell;
    }
    public String getMessage()
    {
        return this.message;
    }
     public String getMessageHash()
    {
        return this.messageHash;
    }
      public String getMessageStatus()
    {
        return this.messageStatus;
    }
      
    //Mutator methods changes this cchangeslass's proparties ouside from other classes
      public void setNumMesageSent(int num)
      {
          this.numMesageSent = num;
      }
      
      public void setRecipient(String recipient)
      {
          this.recipientCell = recipient;
      }
       public void setMessage(String message)
      {
          this.message = message;
      }
         public void setMessageHash(String messageHash)
      {
          this.messageHash = messageHash;
      }
        public void setMessageStatus(String messageStatus)
      {
          this.messageStatus = messageStatus;
      }
    
    
    //Message methods
    public boolean checkMessageID(String messageID)
    {
        if (messageID.length()<= 10 )
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    public boolean checkRecipientCell(String recipientCell)
    {
        if (recipientCell.length() <= 10 && recipientCell.matches("\\+27[0-9]{9}"))
         {
             return true;
        }
               return false;
    }
    
    public void DisplayMesage()
    {
        System.out.println("Message ID: "+this.messageID+"\nMessages Sent: "+this.numMesageSent+
                "\nRecipient: "+this.recipientCell+"\nMessage: "+this.message);
    }
    public String createMessageHash(String messageID, int numMessageSent, String mesasage)
    {
       String messageHash =""; 
       int count = 0;
       
       //Add first 2 digits for messageID
        for (int i = 0; i < messageID.length(); i++) {
           char current =  messageID.charAt(i); 
           if(Character.isDigit(current) && count < 2)
           {
               messageHash+=current;
               count++;
           } 
        }
        //Adding the colon and number of messages sent
        messageHash += ":";
        messageHash += numMessageSent;
        messageHash += ":";
        String[] messageArray = message.trim().split("\\s+");
        
       
        
       // Adding the first and last words of the message
       messageHash += messageArray[0];
       messageHash += messageArray[messageArray.length-1];
       
       return messageHash;
    }
    
}
