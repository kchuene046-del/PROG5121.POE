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
    
    
}
   
