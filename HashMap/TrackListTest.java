import java.util.HashMap;
import java.util.Set;

public class TrackListTest {
    public static void main(String[] args){
        HashMap<String, String> trackLists = new HashMap<String, String>();
        trackLists.put("Loneliness", "Is that you?");
        trackLists.put("Grey Matter","All your matter is grey");
        trackLists.put("Heart of A Graveyard","Tell me that your hopes and dreams don't end");
        trackLists.put("Undying","One final heartbreak");
        System.out.println(trackLists.get("Loneliness"));
        Set<String> keys = trackLists.keySet();
        for(String key:keys){
            System.out.println(key + ":" + " " + trackLists.get(key));
        }
    }
}