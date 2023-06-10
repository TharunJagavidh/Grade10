import java.util.Scanner; //scanner class
import java.util.HashMap; //Hashmap is used to store data
import java.util.Map; //Used to store data like a dictionary
import java.net.URI; //Used to redirect to a website
import java.awt.Desktop; //Also used to get access to web
import java.time.LocalDate; //used to access date
import java.time.format.DateTimeFormatter; //used to format date
public class Covid_19_helper
{
    public static void main(String args[])throws Exception{
        Scanner inpt = new Scanner(System.in); //scanner inpt variable
        Desktop desk=Desktop.getDesktop(); //desktop access variable
        LocalDate  NOW= LocalDate.now(); //date access object
        String today=(NOW.format(DateTimeFormatter.ISO_DATE)); //date access variable
        int id_sev = 0; //variables for ids and indexes or keys
        int a = 0;

        int h = 0;
        int id_mild = 0;
        
        Map<Integer, String > time_appo = new HashMap<>(); //time appointment dictionary
        Map<Integer, Integer > ICU = new HashMap<>(); //ICU appointment dictionary
        while(true){ //for repeated use of app
        System.out.println("Enter 1 for patient and 2 for doctor: ");
        int user = inpt.nextInt(); //user inpt for doctor or patient
        if(user == 1){//for patient
            System.out.println("Welcome to the Covid awareness app");
            System.out.println("We will be asking a few questions to get u started about the patient");
            System.out.println("");
            System.out.println("Pls enter 1 if the patient is above 60 years old and has trouble breathing or is not responding and is unconcious");
            System.out.println("pls enter 1 also for babies or infants in need of help");
            System.out.println("Pls enter 2 if Symptoms such as cold, fever, cough are mild");
            System.out.println("pls enter 3 for mental health issues");
            System.out.println("");
            int menu1 = inpt.nextInt();
            
            if(menu1 == 1){
                System.out.println("Pls admit to hospital immediately, Your ID to enter ICU is: "+id_sev);
                a++; //patient number
                ICU.put(a,id_sev); //storing patient and ID number
                
                id_sev++; //ID next
            }
            else if(menu1 == 2){
                System.out.println("You can get an appointment now");
                System.out.println("Choose 1 for 10-11am");
                System.out.println("Choose 2 for 11am-12pm");
                System.out.println("Choose 3 for 12-1pm");
                int appo = inpt.nextInt();
                if(appo == 1){
                    time_appo.put(h, "10-11am");
                    System.out.println("Your appointment is fixed for 10-11");
                    h++;//key increment
                }
                else if(appo == 2){
                    time_appo.put(h, "11am-12pm");
                    System.out.println("Your appointment is fixed for 11-12");
                    h++;//key increment
                }
                else if(appo == 3){
                    time_appo.put(h, "12-1pm");
                    System.out.println("Your appointment is fixed for 12-1");
                    h++;//key increment
                }
                else{
                    System.out.println("Invalid Input");
                    continue;
                }
            }
            else if(menu1 == 3){
                desk.browse(new URI("https://www.abhayahospital.org/"));//redirect to webpage
            }
            else{
                System.out.println("Invalid input");
                continue; //to start loop once again
            }
        }
        else if(user == 2){//for doctor
            System.out.println("Enter 1 to know Number of patients in ICU and their IDs");
            System.out.println("Enter 2 to know ur appointments");
            System.out.println("");
            int menu2 = inpt.nextInt();
            System.out.println("");
            if(menu2 == 1){
                System.out.println(today);
                for (Map.Entry pairEntry : ICU.entrySet()){
                    System.out.println("Patient number: "+pairEntry.getKey() + " with Id: " + pairEntry.getValue()); //printing all stored values
                }
            }
            if(menu2 == 2){
                System.out.println(today);
                for (Map.Entry pairEntry : time_appo.entrySet()){
                    System.out.println("Patient number: "+pairEntry.getKey() + " with time of appointment: " + pairEntry.getValue()); //printing all stored values
                }
            }
        }
        else{
            System.out.println("Invalid input");
            continue;
            
        }
        System.out.println("Do you want to exit the program? Enter 1 for Yes and 2 for No: ");
        int Break2 = inpt.nextInt();
        if(Break2 == 1){
            System.out.println("Very well then, Bye!!");
            break;
        }
        else{
            continue;
        }
    }
    }
}
