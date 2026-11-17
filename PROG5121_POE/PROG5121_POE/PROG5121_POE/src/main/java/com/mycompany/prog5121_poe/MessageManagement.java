/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121_poe;
import java.util.ArrayList;
/**
 *
 * @author Kgomotso
 */
public class MessageManagement {
    public void displayStoredMessage (ArrayList<Message> storedMessages, String sender){
        
        for (int i = 0; i < storedMessages.size(); i++) {
            Message currentMessage = storedMessages.get(i);
            System.out.println("Sender: "+sender+"\nRecipient: "+currentMessage.getRecipient());
        }
    }
}
