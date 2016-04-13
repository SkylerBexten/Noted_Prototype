/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noted_prototype;

import java.awt.Color;
import javax.swing.border.LineBorder;

public class CodeLine extends javax.swing.JPanel {

   private String Text = "";
   private int LineNumber = 0;
   private final Color Celeste = new Color(178, 255, 255);
   
   private void setColor(){
       //Use different line colors on even
       //and odd line numbers.
       if(LineNumber % 2 == 1){
           setBackground(Celeste);
       }
       else{
           setBackground(Color.white);
       }
   }
   
    public CodeLine(int lineNumber,String text) {
        initComponents();
        
        setBorder(new LineBorder(Color.black));
        
        Text = text;
        LineNumber = lineNumber;
        
        CodeLineTextLabel.setText(Text);
        LineNumberLabel.setText(String.valueOf(LineNumber));
        setColor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LineNumberLabel = new javax.swing.JLabel();
        CodeLineTextLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(500, 20));
        setMinimumSize(new java.awt.Dimension(500, 20));

        LineNumberLabel.setText("N");
        LineNumberLabel.setMaximumSize(new java.awt.Dimension(20, 20));
        LineNumberLabel.setMinimumSize(new java.awt.Dimension(20, 20));
        LineNumberLabel.setName(""); // NOI18N

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
