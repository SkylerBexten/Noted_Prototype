
package noted_prototype;

import java.util.ArrayList;

public class Category {
    private String Name = "";
    private Category parent = null;
    private ArrayList<Category> categories = new ArrayList<>();
    private ArrayList<Note> notes = new ArrayList<>();
    
    public Category(String name){
        Name = name;
    }
    
    public void setName(String name){
        Name = name;
    }
    
    public String getName(){
        return Name;
    }
    
    public void setParent(Category cat){
        parent = cat;
    }
    
    public Category getParent(){
        return parent;
    }
    
    public void addChild(Category cat){
        categories.add(cat);
        cat.setParent(this);
    }
    
    public ArrayList<Category> getChildren(){
        return categories;
    }
    
    public void addNote(Note note){
        notes.add(note);
        note.setParent(this);
    }
    
    public ArrayList<Note> getNotes(){
        return notes;
    }
    
    //Print out the entire hierarchy underneath a
    //category for testing purposes.
    public void printHierarchy(int depth){
        for(int k = 0; k < depth; k++){System.out.print("    ");}
        System.out.println(this.getName());
        
        //Go through all categories first.
        for(int j = 0; j < categories.size(); j++){
            for(int k = 0; k < depth; k++){System.out.print("    ");}
            System.out.println("Categories:");
            categories.get(j).printHierarchy(depth + 1);
        }
        
        
        
        
        
        //Finish by printing the name of notes.
        for(int j = 0; j < notes.size(); j++){
            for(int k = 0; k < depth; k++){System.out.print("    ");}
            System.out.println("Notes:");
            for(int k = 0; k < depth + 1; k++){System.out.print("    ");}
            System.out.println(notes.get(j).getName());
        }
    }
}
