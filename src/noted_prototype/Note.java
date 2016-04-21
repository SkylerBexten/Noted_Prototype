
package noted_prototype;

import java.util.ArrayList;
import javax.swing.JComponent;

public class Note {
    
    private String name = "";
    private Category parent = null;
    private ArrayList<Tag> noteTags = new ArrayList<>();
    private ArrayList<JComponent> noteContents = new ArrayList<>();
    
    public Note(String Name){
        name = Name;
    }
    
    public void setName(String Name){
        name = Name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setParent(Category cat){
        parent = cat;
    }
    
    public Category getParent(){
        return parent;
    }
    
    //Get the note's contents
    public ArrayList<JComponent> getContents(){
        return noteContents;
    }
    
    /*Add components and content to the note*/
    
    public void addTextBox(){
        NoteTextBox ntb = new NoteTextBox();
        noteContents.add(ntb);
    }
    
    public void addTag(Tag tag){
        noteTags.add(tag);
    }
    
}
