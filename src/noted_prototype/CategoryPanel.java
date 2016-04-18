
package noted_prototype;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CategoryPanel extends javax.swing.JPanel {

    private boolean categoryExpanded = false;
    private String Name = "";
    private static Category thisCategory;
    
    public CategoryPanel(int depth, Category cat) {
        initComponents();
        thisCategory = cat;
        setName(cat.getName());
        
        //Remove the arrow if the category has no children.
        System.out.println(thisCategory.hasChildren());
    }
    
    public void setName(String name){
        Name = name;
        CategoryNameLabel.setText(name);
        thisCategory.setName(name);
    }
    
    public String getName(){
        return Name;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CategoryPopupMenu = new javax.swing.JPopupMenu();
        RenameItem = new javax.swing.JMenuItem();
        CategoryNameLabel = new javax.swing.JLabel();
        ExpandLabel = new javax.swing.JLabel();

        RenameItem.setText("Rename Category");
        RenameItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RenameItemActionPerformed(evt);
            }
        });
        CategoryPopupMenu.add(RenameItem);

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setComponentPopupMenu(CategoryPopupMenu);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        CategoryNameLabel.setText("Default");

        ExpandLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ExpandLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ExpandLabel.setText(">");
        ExpandLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExpandLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CategoryNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(ExpandLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CategoryNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(ExpandLabel)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ExpandLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpandLabelMouseClicked
        categoryExpanded = !categoryExpanded;
        if(categoryExpanded){
            ExpandLabel.setText("V");
        }
        else{
            ExpandLabel.setText(">");
        }
    }//GEN-LAST:event_ExpandLabelMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(SwingUtilities.isRightMouseButton(evt)){
            CategoryPopupMenu.show(this, 0, 0);
        }
    }//GEN-LAST:event_formMouseClicked

    private void RenameItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RenameItemActionPerformed
        remove(CategoryNameLabel);
        JTextField field = new JTextField();
        field.setBounds(0, 0, 120, 30);
        
        //Add key listener to field.
        field.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent key){
                if(key.getKeyCode() == KeyEvent.VK_ENTER){
                    System.out.println();
                    remove(field);
                    add(CategoryNameLabel);
                    setName(field.getText());
                    repaint();
                }
            }
        });
        
        add(field);
        field.requestFocusInWindow();
        repaint();
    }//GEN-LAST:event_RenameItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CategoryNameLabel;
    private javax.swing.JPopupMenu CategoryPopupMenu;
    private javax.swing.JLabel ExpandLabel;
    private javax.swing.JMenuItem RenameItem;
    // End of variables declaration//GEN-END:variables
}
