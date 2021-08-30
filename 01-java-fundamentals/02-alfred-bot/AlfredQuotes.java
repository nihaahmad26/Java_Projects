import java.util.Date;
public class AlfredQuotes {

    public String basicGreeting() {

        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name, String dayPeriod) {

        return String.format("Good %s, %s. Lovely to see you.",dayPeriod, name);
    }

    public String dateAnnouncement() {
          
           Date date = new Date();
        
        return "The date is currently " + date;

    }
    

    public String respondBeforeAlexis(String conversation) {
        if (conversation.indexOf("Alexis") > -1) {
            return "I am not Alexis. I am JARVIS";
        }
        if (conversation.indexOf("Alfred") > -1){
            return "yes, Mr Bruce.";
        }
        else {
            return "I bid you a good one, Master Wayne.";
        } 
    }
   
}

