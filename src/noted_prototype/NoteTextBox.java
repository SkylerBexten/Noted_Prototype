
package noted_prototype;

//A class that can be added to a Note

import java.awt.Color;
import javax.swing.border.LineBorder;

//object to store text for notetaking.
public class NoteTextBox extends javax.swing.JTextArea{
    
    public NoteTextBox(){
        setEditable(true);
        setSize(100, 100);
        setBorder(new LineBorder(Color.black));
    }
    
}
