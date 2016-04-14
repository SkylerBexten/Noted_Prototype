
package noted_prototype;

public class CategoryPanel extends javax.swing.JPanel {

    boolean categoryExpanded = false;
    
    public CategoryPanel(int position, int depth, String name) {
        initComponents();
        CategoryNameLabel.setText(name);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CategoryNameLabel = new javax.swing.JLabel();
        ExpandLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        CategoryNameLabel.setText("Default");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(CategoryNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(ExpandLabel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CategoryNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExpandLabel)))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CategoryNameLabel;
    private javax.swing.JLabel ExpandLabel;
    // End of variables declaration//GEN-END:variables
}
