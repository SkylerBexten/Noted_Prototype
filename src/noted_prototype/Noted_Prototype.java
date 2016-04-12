
package noted_prototype;

import java.io.*;
import java.util.ArrayList;

public class Noted_Prototype {
    
    public static ArrayList<Category> TopCategories = new ArrayList<>();
    public static ArrayList<Note> TopNotes = new ArrayList<>();
    public static ArrayList<Tag> TagList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        
        FileSaver fileSaver = new FileSaver();
      
        XMLHelper helper = new XMLHelper();
        helper.getFileHierarchy(new File("FileStructure.txt"));
        
        for(int j = 0; j < TopCategories.size(); j++){
            TopCategories.get(j).printHierarchy(0);
        }
        for(int j = 0; j < TopNotes.size(); j++){
           System.out.println(TopNotes.get(j).getName());
        }
        for(int j = 0; j < TagList.size(); j++){
           System.out.print(TagList.get(j).getName() + " ");
            System.out.println(TagList.get(j).getCount());
        }
        
        Tag newTag = new Tag("Cute",2);
        TagList.add(newTag);
        
        fileSaver.saveFileHierarchy();

    }
    
}