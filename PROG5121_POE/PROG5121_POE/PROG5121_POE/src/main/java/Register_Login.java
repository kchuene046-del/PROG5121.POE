
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kgomotso
 */
public class Register_Login {
    
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstName;
        String lastName;
        String userName;
        String phoneNumber;
        String password;
        String registerUserName;
        String registerPassword;
        
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
          
         while(!checkCellPhoneNumber(phoneNumber))
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
         
           while(!checkUserName(registerUserName))
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
        
        while(!checkPasswordComplexity(registerPassword))
         {
             System.out.println();
             System.out.println("\nPasword is not correctly formatted, please ensure that your password contains "
                           + "at least 8 characters, a capital letter, a number, and a special character");
             System.out.println();
             System.out.print("Enter your password: ");
             registerPassword = input.nextLine();
         }
       System.out.println(registerUser(firstName,lastName,phoneNumber,registerUserName,registerPassword));
       
       System.out.println();
       System.out.println();
       
       System.out.println("LOGIN");
        // Ask for user name
         System.out.print("Enter your user name: ");
         userName = input.nextLine();
         
          while(!checkUserName(userName))
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
         
         while(!checkPasswordComplexity(password))
         {
             System.out.println();
             System.out.println("\nPasword is not correctly formatted, please ensure that your password contains "
                           + "at least 8 characters, a capital letter, a number, and a special character");
             System.out.println();
             System.out.print("Enter your password: ");
             password = input.nextLine();
         }
         
         System.out.println();
         System.out.println(LoginSatus(firstName,lastName, userName, password,registerUserName, registerPassword));
       
    }
    
    
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
     
     public static boolean checkCellPhoneNumber(String phoneNumber) {
         //checks if cell phone number contains national code
         if (phoneNumber != null && phoneNumber.matches("\\+27[0-9]{9}"))
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

   
