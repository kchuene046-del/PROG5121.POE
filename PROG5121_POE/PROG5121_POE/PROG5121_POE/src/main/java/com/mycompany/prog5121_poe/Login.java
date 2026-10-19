/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121_poe;

/**
 *
 * @author Kgomotso
 */
public class Login {
    
    //Registration methods
      public static String registerUser(String firstName, String lastName,
        String phoneNumber, String userName,String password)  {
         //Registering the user

         String incorrectText ="";

          if(checkUserName(userName) && checkFirstName(firstName) && checkLastName(lastName)&&
            checkPasswordComplexity(password) &&  checkCellPhoneNumber(phoneNumber) )
            {
                 return "Firstname Successfully captured"+"\nLastname Successfully captured"+"\nUsername Successfully captured"
                         +"\nCell phone number Successfully added"+"\nPassword Successfully captured";

            }
            else
            {

                if (!checkFirstName(firstName))
                {
                    incorrectText +="\nFirstname is incorrect";
                }
                if (!checkLastName(lastName))
                {
                    incorrectText += "\nLastname is incorrect";
                }
                if(!checkUserName(userName))
                {
                    incorrectText += "\nUsername is not correctly formatted, please ensure that your username contains "
                           + "and underscore and is no more than 5 characters in length";
                }
                if(!checkCellPhoneNumber(phoneNumber))
                {
                    incorrectText += "\nCell phone number incorrectly formatted or does not contain international code";
                }
                if (!
                        checkPasswordComplexity(password) )
                {
                    incorrectText += "\nPasword is not correctly formatted, please ensure that your password contains "
                           + "at least 8 characters, a capital letter, a number, and a special character";
                }


            }

          return incorrectText;

    }
      
     
}
