
package noted_prototype;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class NotePanel extends javax.swing.JPanel {
    
    private static Note thisNote = null;
    private String Name = "";
    
    public NotePanel(int depth, Note note) {
        initComponents();
        thisNote = note;
        NoteName.setText(note.getName());
    }
    
    public void setName(String name){
        Name = name;
        NoteName.setText(name);
        thisNote.setName(name);
    }
    
    public String getName(){
        return Name;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NotePopupMenu = new javax.swing.JPopupMenu();
        RenameItem = new javax.swing.JMenuItem();
        NoteName = new javax.swing.JLabel();

        RenameItem.setText("Rename Note");
        RenameItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RenameItemActionPerformed(evt);
            }
        });
        NotePopupMenu.add(RenameItem);

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        NoteName.setText("Default");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(NoteName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NoteName, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RenameItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RenameItemActionPerformed
        remove(NoteName);
        JTextField field = new JTextField();
        field.setBounds(0, 0, 120, 30);
        
        //Add key listener to field.
        field.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent key){
                if(key.getKeyCode() == KeyEvent.VK_ENTER){
                    System.out.println();
                    remove(field);
                    add(NoteName);
                    setName(field.getText());
                    repaint();
                }
            }
        });
        
        add(field);
        field.requestFocusInWindow();
        repaint();
    }//GEN-LAST:event_RenameItemActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(SwingUtilities.isRightMouseButton(evt)){
            NotePopupMenu.show(this, 0, 30);
        }
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NoteName;
    private javax.swing.JPopupMenu NotePopupMenu;
    private javax.swing.JMenuItem RenameItem;
    // End of variables declaration//GEN-END:variables
}
