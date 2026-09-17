/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kgomotso
 */
public class Register_Login {
    
    
    
    
    public static boolean checkFirstName(String firstName){
        
        //check if both first and last name are provided
        if (!firstName.isEmpty())
        {
            return true;
        }
       
            return false;
    }
    
     public static boolean checkLastName(String lastName){
        
        //check if both first and last name are provided
        if (!lastName.isEmpty())
        {
            return true;
        }
       
            return false;
    }
      public static boolean checkUserName(String userName) {
         //checks if the user name has an underscore or is less than 5 characters 
         if(userName != null && userName.contains("_") && userName.length()<= 5)  {
            return true;
         }
         return false;
    }
      public static boolean checkPasswordComplexity(String password){
         //Declarations
          boolean hasCapitalLetter = false;
          boolean hasSpecialCharacter = false;
          boolean hasNumber = false;
          boolean hasEightCharacters = false;
          
          //check password length
         if (password != null && password.length()>=8){
             hasEightCharacters = true;
         }
         
       //Checks if password has uppercases, digits and special characters
        for (int i = 0; i < password.length(); i++) {
            char current = password.charAt(i);
            
            if (Character.isUpperCase(current)) {
                hasCapitalLetter = true;
            } else if (Character.isDigit(current)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(current)) {
                hasSpecialCharacter = true;
            }
        }
             
         if (hasEightCharacters && hasNumber && hasCapitalLetter && hasSpecialCharacter)
         {
             return true;
         }
            return false;
     }
    
    
}
   
