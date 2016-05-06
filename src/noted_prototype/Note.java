
package noted_prototype;

import java.awt.Font;
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
        addTextBox();
    }
    
    public void addTextBox(){
        NoteTextBox ntb = new NoteTextBox();
        noteContents.add(ntb);
        resizeFirstBox();
    }
    
    public void addTag(Tag tag){
        TagPanel tagPanel = new TagPanel(tag);
        noteTags.add(tagPanel);
    }
    
    public void addSpoiler(Spoiler box){
        noteContents.add(box);
        addTextBox();
    }
    
    //Resize first text box
    public void resizeFirstBox(){
        noteContents.get(0).setSize(600, 100);
    }
    
    //Sets up the note as a
    //"default" note.
    public void setDefault(){
        NoteTextBox ntb = new NoteTextBox();
        ntb.setText("Welcome to Noted.  This is a prototype that we've built "
                + "for you to test.  We hope you enjoy the\nexperience.\n\n"
                + "This is an example of a note.");
        ntb.setFont(new Font("SansSerif", 0, 18));
        ntb.setWrapStyleWord(true);
        noteContents.add(ntb);
    }
}
