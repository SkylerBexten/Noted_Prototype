
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
        /*
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
        */
        Tag newTag = new Tag("Cute",2);
        TagList.add(newTag);
        
        //Note newNote = new Note("Panda");
        //TopNotes.add(newNote);
        
        fileSaver.saveFileHierarchy();
        
        Category cg = new Category("Mammalia");
        TopCategories.get(0).addChild(cg);
        
        //Open new main JFrame for the application
        Noted_Screen main_screen = new Noted_Screen();
        main_screen.setVisible(true);
        for(Category cat: TopCategories){
            main_screen.addCategoryPanel(cat,0,0);
        }
        for(Note note: TopNotes){
            note.setDefault();
            main_screen.addNotePanel(0, note);
            main_screen.changeCurrentNote(note);
        }
    }
    
}
