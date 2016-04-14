
package noted_prototype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import java.util.Scanner;

public class CodeBox extends javax.swing.JPanel {

    private ArrayList<CodeLine> codeLines = new ArrayList<>();
    
    public CodeBox() {
        initComponents();
        setLayout(new BoxLayout(this, 1));
        /*for(int j = 1; j < 20; j++){
            CodeLine codeLine = new CodeLine(j, "Hey");
            codeLines.add(codeLine);
            add(codeLine);
        }*/
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
        /*FileReader fr = new FileReader(imported);
        BufferedReader br = new BufferedReader(fr);
        String line = null;*/
        int count = 0;
        while (scanFile.hasNextLine()){
            count++;
            String line = null;
            line = scanFile.nextLine();
            CodeLine codeLine = new CodeLine(count, line);
            codeLines.add(codeLine);
            add(codeLine);
            System.out.println(line);
        }
        //while(imported.){
            
        //}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ExpandCollapseCodeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        ExpandCollapseCodeButton.setText("Hide");

        jLabel1.setText("Code.ending");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExpandCollapseCodeButton))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ExpandCollapseCodeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 275, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExpandCollapseCodeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
