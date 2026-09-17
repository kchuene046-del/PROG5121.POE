/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kgomotso
 */
public class Register_Login {
    
    
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
    
     //Login methods
     
    public static boolean loginUser(String userName, String password, String registeredUsername, String registeredPassword)  {
       //login in the user
       if(userName.equals(registeredUsername) && password.equals(registeredPassword))
       {
           return true;
       }
       return false;
    }
    
   public static String LoginSatus(String firstName, String lastName, String userName, 
            String password,String registeredUsername, String registeredPassword) {
        // checks if the useer is successfuly logged in
       if (loginUser(userName, password,registeredUsername, registeredPassword))  {
          return "Welcome " + firstName + "," + lastName + " it is great to see you again." ;
       }
       return "Username or password incorrect please try again";
    }
} 

   
