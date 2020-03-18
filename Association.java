import java.util.Map;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.ArrayList;


public class Association<K extends Comparable<K>,V>{    
    private Map<String, String> map = new LinkedHashMap<String, String>();
    private ArrayList<String> list;
	public Map<String, String> Reader(){
        String[] parts = null;
        String fileName = "dictionary.txt";

        String line = null;
        String nLine = null;

        try {

            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                nLine = line.substring(1,line.length()-1);
                parts = nLine.split(", ");

                map.put(parts[0],parts[1]);
                parts = null;
            }
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }
        return map;
    }       
}