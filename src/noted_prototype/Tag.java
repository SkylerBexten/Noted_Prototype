
package noted_prototype;

public class Tag {
    
    private String Name = "";
    private int Count = 0;
    
    public Tag(String name, int count){
        Name = name;
        Count = count;
    }
    
    public void setName(String name){
        Name = name;
    }
    
    public String getName(){
        return Name;
    }
    
    public void setCount(int count){
        Count = count;
    }
    
    public int getCount(){
        return Count;
    }
    
}
