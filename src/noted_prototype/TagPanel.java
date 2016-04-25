
package noted_prototype;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TagPanel extends javax.swing.JPanel {

    private Tag thisTag = null;
    
    public TagPanel(Tag tag) {
        initComponents();
        thisTag = tag;
        TagLabel.setText(tag.getName());
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TagPopupMenu = new javax.swing.JPopupMenu();
        RenameTagMenuItem = new javax.swing.JMenuItem();
        RemoveTagButton = new javax.swing.JButton();
        TagLabel = new javax.swing.JLabel();

        RenameTagMenuItem.setText("Rename Tag");
        RenameTagMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RenameTagMenuItemActionPerformed(evt);
            }
        });
        TagPopupMenu.add(RenameTagMenuItem);

        RemoveTagButton.setText("x");

        TagLabel.setText("NewTag");
        TagLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TagLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(TagLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RemoveTagButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RemoveTagButton, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(TagLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RenameTagMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RenameTagMenuItemActionPerformed
        JTextField field = new JTextField();
        field.setBounds(0, 0, 120, 30);
        
        //Add key listener to field.
        field.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent key){
                if(key.getKeyCode() == KeyEvent.VK_ENTER){
                    remove(field);
                    thisTag.setName(field.getText());
                    TagLabel.setText(thisTag.getName());
                    repaint();
                }
            }
        });
        
        add(field);
        field.requestFocusInWindow();
        repaint();
    }//GEN-LAST:event_RenameTagMenuItemActionPerformed

    private void TagLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TagLabelMouseClicked
        if(SwingUtilities.isRightMouseButton(evt)){
            TagPopupMenu.show(this, 0, 30);
        }
    }//GEN-LAST:event_TagLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RemoveTagButton;
    private javax.swing.JMenuItem RenameTagMenuItem;
    private javax.swing.JLabel TagLabel;
    private javax.swing.JPopupMenu TagPopupMenu;
    // End of variables declaration//GEN-END:variables
}
