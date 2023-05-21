import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return String.format("Hello %s. Good to see ya!",name);
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        return String.format("It is currently %s", new Date());
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if(conversation.indexOf("Alexis") > -1){
            return "She's useless! However I'm here master!";
        }
        if(conversation.indexOf("Alfred") > -1){
            return "At your service sir!";
        }
        else{
            return "Well I guess I'm off sir! Do be careful!";
        }
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
        // SENSEI BONUS
        // Write your own AlfredQuote method using any of the String methods you have learned!
}

