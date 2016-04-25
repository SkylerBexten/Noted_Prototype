/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noted_prototype;

import java.awt.Color;

public class CodeLine extends javax.swing.JPanel {

   private String Text = "";
   private int LineNumber = 0;
   private final Color Beige = new Color(245, 245, 220);
   
   private void setColor(){
       //Use different line colors on even
       //and odd line numbers.
       if(LineNumber % 2 == 1){
           setBackground(Beige);
       }
       else{
           setBackground(Color.white);
       }
   }
   
    public CodeLine(int lineNumber,String text, int width) {
        initComponents();
        Text = text;
        LineNumber = lineNumber;
        CodeLineTextLabel.setText(Text.replaceAll("\t", "       "));
        LineNumberLabel.setText(String.valueOf(LineNumber));
        setColor();
        setSize(width,this.getHeight());
        CodeLineTextLabel.setSize(width,this.getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LineNumberLabel = new javax.swing.JLabel();
        CodeLineTextLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(500, 20));
        setMinimumSize(new java.awt.Dimension(500, 20));

        LineNumberLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        LineNumberLabel.setText("N");
        LineNumberLabel.setMaximumSize(new java.awt.Dimension(20, 20));
        LineNumberLabel.setMinimumSize(new java.awt.Dimension(20, 20));
        LineNumberLabel.setName(""); // NOI18N

        CodeLineTextLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CodeLineTextLabel.setText("Code Here");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LineNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CodeLineTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(LineNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CodeLineTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CodeLineTextLabel;
    private javax.swing.JLabel LineNumberLabel;
    // End of variables declaration//GEN-END:variables
}
