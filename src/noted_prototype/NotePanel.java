
package noted_prototype;

public class NotePanel extends javax.swing.JPanel {
    
    private final Note thisNote;
    
    public NotePanel(int depth, Note note) {
        initComponents();
        thisNote = note;
        NoteName.setText(note.getName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NoteName = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        NoteName.setText("Default");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(NoteName)
                .addGap(0, 154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NoteName, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NoteName;
    // End of variables declaration//GEN-END:variables
}
