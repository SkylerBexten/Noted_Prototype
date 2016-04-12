
package noted_prototype;

import java.util.ArrayList;

public class Note {
    
    private String name = "";
    private Category parent = null;
    private ArrayList<Tag> noteTags = new ArrayList<>();
    
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
    
    public void addTag(Tag tag){
        noteTags.add(tag);
    }
    
}
