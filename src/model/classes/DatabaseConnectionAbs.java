package model.classes;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;

public abstract class DatabaseConnectionAbs{
	
	
	//This method will parse the given file and return a JSONParser as an Object 
	//containing the reference to the file. The parser Object can then be used to 
	//read an existing JSON file.
    public static Object getParser(String location) {
        JSONParser parser = new JSONParser();
        Object parseObject = null;

        try {
            parseObject = (Object) parser.parse(new FileReader(location));

        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return parseObject;
    }
}


