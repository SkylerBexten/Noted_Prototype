
package noted_prototype;

import java.io.*;
import java.util.ArrayList;

public class FileSaver {
    
    //Name of folders
    private final File saveFolder = new File("Saved_Notes");
    private final File fileStructre = new File("File_Structure");
    
    public FileSaver(){
        //Create note folder, if one doesn't exist.
        if(!saveFolder.isDirectory()){saveFolder.mkdir();}
        if(!fileStructre.isDirectory()){fileStructre.mkdir();}
    }
    
    //Used for recursive calls to write category tags for
    //xml files.
    private void writeXMLCategories(FileWriter writer,Category category){
       try{
           //Start category tag
            writer.write("<Category name=\"");
            writer.write(category.getName() + "\">\n");
            
            //Add child categories
            ArrayList<Category> childCategories = category.getChildren();
            
            for(Category cat: childCategories){
                writeXMLCategories(writer, cat);
            }
            
            //Add child categories
            ArrayList<Note> notes = new ArrayList<>();
            notes = category.getNotes();
            
            for(Note note: notes){
                writer.write("<Note>");
                writer.write(note.getName());
                writer.write("</Note>\n");
            }
            
            //Close category tag
            writer.write("</Category>\n");
        
        //Throw error.    
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    //Save the new file hierarchy.
    public void saveFileHierarchy(){
        String filePath = fileStructre.getAbsolutePath() + "\\New_Hierarchy.txt";
        System.out.println(filePath);
        
        
        for(Tag tag: Noted_Prototype.TagList){
            System.out.println(tag.getCount());
        }
        
        //Create new file
        File saveFile = new File(filePath);
        
        try{
            saveFile.createNewFile();
            FileWriter writer = new FileWriter(saveFile);
            
            //Create xml header
            writer.write("<?xml version=\"1.0\"?>\n");
            
            //Start files header
            writer.write("<Files>\n");
            
            //Add category tags
            for(Category category: Noted_Prototype.TopCategories){
                writeXMLCategories(writer, category);
            }
            
            //Add top notes to the xml file.
            for(Note note: Noted_Prototype.TopNotes){
                writer.write("<Note>");
                writer.write(note.getName());
                writer.write("</Note>\n");
            }
            
            //Add tag xml tags to the xml file.
            for(Tag tag: Noted_Prototype.TagList){
                writer.write("<Tag count=\"" + tag.getCount() + "\">");
                writer.write(tag.getName());
                writer.write("</Tag>\n");
            }
            
            //End files header
            writer.write("</Files>");
            writer.flush();
            writer.close();
          
        //Throw error.    
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    //Save a note to its file.
    public void saveFile(Note saveNote){
        //Get the name of the top folder.
        String filePath = saveFolder.getAbsolutePath();
        String fileEnding = "";
        
        //If the note doesn't have any parents
        //save it at the top directory.
        if(saveNote.getParent() != null){
            Category parent = saveNote.getParent();
            while(parent != null){
                fileEnding = parent.getName() + "\\" + fileEnding;
                parent = parent.getParent();
            }
        }
        filePath += "\\";
        filePath += fileEnding;
        
        //Create folders, if none exist.
        File saveFolder = new File(filePath);
        if(!saveFolder.isDirectory()){  saveFolder.mkdirs();}
        
        filePath += saveNote.getName();
        filePath += ".txt";
        
        //Create new file
        File newFile = new File(filePath);
        writeFile(newFile);
    }
    
    //Write the contents of the note to the file.
    private void writeFile(File saveFile){
        try{
            saveFile.createNewFile();
            FileWriter writer = new FileWriter(saveFile);
            writer.write("Hey.");
            writer.flush();
            writer.close();
          
        //Throw error.    
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
