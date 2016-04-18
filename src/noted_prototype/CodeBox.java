
package noted_prototype;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import java.util.Scanner;

public class CodeBox extends javax.swing.JPanel {

    private ArrayList<CodeLine> codeLines = new ArrayList<>();
    
    public CodeBox() {
        initComponents();
        setLayout(new BoxLayout(this, 1));
        try{
            importCode();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    //Import code from file.
    private void importCode() throws IOException{
        File imported = new File("fake.py");
        Scanner scanFile = new Scanner(imported);
        int count = 0;
        while (scanFile.hasNextLine()){
            count++;
            String line = null;
            line = scanFile.nextLine();
            CodeLine codeLine = new CodeLine(count, line);
            codeLines.add(codeLine);
            add(codeLine);
        }
        
        CodeNameLabel.setText("fake.py");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CodeBoxPanel = new javax.swing.JPanel();
        ExpandCollapseCodeButton = new javax.swing.JButton();
        CodeNameLabel = new javax.swing.JLabel();

        ExpandCollapseCodeButton.setText("Hide");

        CodeNameLabel.setText("Code.ending");
        CodeNameLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout CodeBoxPanelLayout = new javax.swing.GroupLayout(CodeBoxPanel);
        CodeBoxPanel.setLayout(CodeBoxPanelLayout);
        CodeBoxPanelLayout.setHorizontalGroup(
            CodeBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CodeBoxPanelLayout.createSequentialGroup()
                .addComponent(CodeNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExpandCollapseCodeButton))
        );
        CodeBoxPanelLayout.setVerticalGroup(
            CodeBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ExpandCollapseCodeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(CodeNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CodeBoxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CodeBoxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 275, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CodeBoxPanel;
    private javax.swing.JLabel CodeNameLabel;
    private javax.swing.JButton ExpandCollapseCodeButton;
    // End of variables declaration//GEN-END:variables
}
