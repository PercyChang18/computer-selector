package model.classes;

import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DatabaseWriter extends DatabaseConnectionAbs {
	
	
	//This method writes the new user data into a JSON file.
	//First read the existing user data, copy the data, append the new user data, 
	//and finally overwrite the JSON file.
    @SuppressWarnings("unchecked")
	public static void writeUserData(String username, String password, String fileLocation)
    {
        JSONArray jsArray = DatabaseReader.readArray(fileLocation);
        JSONObject newUser = wrapUserInfo(username, password);
        jsArray.add(newUser);

        //Re-write to JSON file
        writeArrayToFile(jsArray, fileLocation);
    }

    
    // This method writes a JSONArray to a data file.
    private static void writeArrayToFile(JSONArray jsArray, String fileLocation)
    {
        try(FileWriter fw = new FileWriter(fileLocation))
        {
            fw.write(jsArray.toJSONString());
            fw.flush();
            fw.close();
        }
        catch(Exception e)
        {
            e.getMessage();
            e.printStackTrace();
        }
    }

    
    // Wraps user info in a JSONObject.
    @SuppressWarnings("unchecked")
	public static JSONObject wrapUserInfo(String username, String password)
    {
        JSONObject newUser = new JSONObject();
        newUser.put("username", username);
        newUser.put("password", password);
        return newUser;
    }
}
