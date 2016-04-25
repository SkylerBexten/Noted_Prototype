
package noted_prototype;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class NotePanel extends FilePanel{
    
    private Note thisNote = null;
    private static Noted_Screen parent = null;
    
    
    public NotePanel(int depth, Note note, Noted_Screen ns) {
        initComponents();
        thisNote = note;
        parent = ns;
        NoteName.setText(thisNote.getName());
        Depth = depth;
    }
    
    public void setName(){
        NoteName.setText(thisNote.getName());
    }
    
    public String getName(){
        return thisNote.getName();
    }
    
    public int getDepth(){
        return Depth;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NotePopupMenu = new javax.swing.JPopupMenu();
        RenameItem = new javax.swing.JMenuItem();
        NoteName = new javax.swing.JLabel();
        OpenNoteButton = new javax.swing.JButton();

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

        OpenNoteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noted_prototype/Media/Page.png"))); // NOI18N
        OpenNoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenNoteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(NoteName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(OpenNoteButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(NoteName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(OpenNoteButton))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RenameItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RenameItemActionPerformed
        JTextField field = new JTextField();
        field.setBounds(0, 0, 120, 30);
        
        //Add key listener to field.
        field.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent key){
                if(key.getKeyCode() == KeyEvent.VK_ENTER){
                    remove(field);
                    thisNote.setName(field.getText());
                    setName();
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

    private void OpenNoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenNoteButtonActionPerformed
        thisNote.setOpen();
        parent.changeCurrentNote(thisNote);
    }//GEN-LAST:event_OpenNoteButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NoteName;
    private javax.swing.JPopupMenu NotePopupMenu;
    private javax.swing.JButton OpenNoteButton;
    private javax.swing.JMenuItem RenameItem;
    // End of variables declaration//GEN-END:variables
}
