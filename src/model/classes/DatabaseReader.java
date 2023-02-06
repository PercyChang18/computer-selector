package model.classes;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DatabaseReader extends DatabaseConnectionAbs{
	
	
	//This method reads a JSONArray object and returns its contents in 
	//the form of a JSONArray object. 
    @SuppressWarnings("unchecked")
	public static JSONArray readArray(String fileLocation) {
        JSONArray jsonArray = (JSONArray) getParser(fileLocation);
        JSONArray newArray = new JSONArray();

        Iterator<JSONObject> iter = jsonArray.iterator();
        while(iter.hasNext()) {
            JSONObject temp = iter.next();
            newArray.add(temp);
        }
        return newArray;
    }
    
    
    //This method reads a JSONArray object and returns its contents in
	//the form of a JSONArray object. 
    public static JSONObject findEntry(JSONObject target, JSONArray array)
    {
        @SuppressWarnings("unchecked")
		Iterator<JSONObject> iter = array.iterator();
        while(iter.hasNext())
        {
            JSONObject temp = iter.next();
            if(isEqualAccount(target, temp))
                return temp;
        }
        return null;
    }

    // This method will see if 2 user accounts JSONObjects are equal.
    public static boolean isEqualAccount(JSONObject first, JSONObject second)
    {
        String firstUser = (String) first.get("username");
        String secondUser = (String) second.get("username");
        String firstPass = (String) first.get("password");
        String secondPass = (String) second.get("password");
        return ( (firstUser.equals(secondUser)) && (firstPass.equals(secondPass)));
    }
}
