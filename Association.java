/*Hansel Andre Lopez Montenegro 19026
Algoritmos y Estructura de datos
Hoja de trabajo 7
*/

import java.util.Map;
import java.io.*;
import java.util.LinkedHashMap;

public class Association<K extends Comparable<K>,V>{    
    private Map<String, String> map = new LinkedHashMap<String, String>();

    //Metodo para leer el archivo dictionary.txt y retorna un Map<String, String> tipo LinkedHashMap
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
    
    //Metodo para leer el archivo text.txt y retorna un String[] con las palabras separadas por (" ")
    public String[] readText(){
        String[] parts = null;
        String fileName = "text.txt";

        String line = null;

        try {

            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                parts = line.split(" ");
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
        return parts;
    }       
    
    //Metodo para traducir el archivo text.txt segun las palabras almacenadas en dictionary.txt
    public void translate(String[] words, BinarySearchTree<String> tree){
        for(int n=0;n<words.length;n++){
            
            if(tree.find(words[n].toLowerCase())){
                System.out.print(map.get(words[n])+" ");
            }else{
                if(n == words.length-1 && tree.find(words[n].substring(0,words[n].length()-1))){
                    System.out.print(map.get(words[n].substring(0,words[n].length()-1))+" ");
                }else{
                    System.out.print("*"+words[n]+"* ");
                }               
            }
        } 
    }   
}