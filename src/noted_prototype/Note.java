
package noted_prototype;

import java.util.ArrayList;
import javax.swing.JComponent;

public class Note {
    
    private String name = "";
    private Category parent = null;
    private ArrayList<TagPanel> noteTags = new ArrayList<>();
    private ArrayList<JComponent> noteContents = new ArrayList<>();
    private static boolean isOpen = false;
    
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
    //Get the note's contents
    public ArrayList<TagPanel> getTags(){
        return noteTags;
    }
    
    public void setOpen(){
        isOpen = true;
    }
    
    public void setClosed(){
        isOpen = false;
    }
    
    /*Add components and content to the note*/
    public void addCodeBox(CodeBox box){
        noteContents.add(box);
    }
    
    public void addTextBox(){
        NoteTextBox ntb = new NoteTextBox();
        noteContents.add(ntb);
    }
    
    public void addTag(Tag tag){
        TagPanel tagPanel = new TagPanel(tag);
        noteTags.add(tagPanel);
    }
    
}
