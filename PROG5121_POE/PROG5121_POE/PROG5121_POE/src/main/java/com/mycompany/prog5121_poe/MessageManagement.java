/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121_poe;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
/**
 *
 * @author Kgomotso
 */
public class MessageManagement {
    public void displaySenderAndRecipient (ArrayList<Message> storedMessages){
       
        for (int i = 0; i < storedMessages.size(); i++) {
            Message currentMessage = storedMessages.get(i);
            System.out.println("=================Message "+(i+1)+"====================================");
            System.out.println("Sender: "+currentMessage.getSender()+"\nRecipient: "+currentMessage.getRecipient());
        }
    }
    
    
}
