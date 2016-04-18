
package noted_prototype;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.MouseInfo;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

public class Noted_Screen extends javax.swing.JFrame {

    private static int lastCategoryIndex = 0;
    private ArrayList<JComponent> fileHierarchy = new ArrayList<JComponent>();
    private static int numUntitledNotes = 0;
    private static int numUntitledCategories = 0;
    private static Note currentNote = null;
    
    public Noted_Screen() {
        initComponents();
        SearchBar bar = new SearchBar();
        bar.setBounds(0,0,177,30);
        SearchPanel.add(bar);
    }
    
    //Change the screen currently open note
    public void changeCurrentNote(Note note){
        currentNote = note;
        UpdateNotePanel();
    }
    
    //Update the note panel area.
    public void UpdateNotePanel(){
        NoteTitleLabel.setText(currentNote.getName());
    }
    
    //Add a new category panel to the screen.
    public void addCategoryPanel(String name, int depth){
        CategoryPanel newPanel = new CategoryPanel(depth,new Category(name));
        fileHierarchy.add(lastCategoryIndex, newPanel);
        lastCategoryIndex++;
        redrawFileHierarchy();
    }
    
    //Using an arraylist of the category and note panels,
    //redraw the file viewer after a new note or category
    //has been added.
    private void redrawFileHierarchy(){
        for(int j = 0; j < fileHierarchy.size(); j++){
            JComponent comp = fileHierarchy.get(j);
            comp.setBounds(0, j * 30, 177, 30);
            FileViewerPanel.add(comp);
        }
        FileViewerPanel.revalidate();
        FileViewerPanel.repaint();
    }
    
    public void addNotePanel(int depth, Note note){
        NotePanel newPanel = new NotePanel(0, note);
        fileHierarchy.add(newPanel);
        redrawFileHierarchy();
    }
    
    //Returns true if another note already has this name.
    private boolean checkName(String name,String newName){
        if(name.compareTo(newName) == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        WidgetPopupMenu = new javax.swing.JPopupMenu();
        C2FMenuItem = new javax.swing.JMenuItem();
        F2CMenuItem = new javax.swing.JMenuItem();
        WidgetPanel = new javax.swing.JPanel();
        AddWigetButton = new javax.swing.JButton();
        NoteTitleLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        AddCategoryButton = new javax.swing.JButton();
        AddNoteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        FileViewerPanel = new javax.swing.JPanel();
        FileViewerScrollBar = new javax.swing.JScrollBar();
        SearchPanel = new javax.swing.JPanel();
        NoteScrollPane = new javax.swing.JScrollPane();
        NotePanel = new javax.swing.JPanel();
        NoteScrollBar = new javax.swing.JScrollBar();
        WidgetLabel = new javax.swing.JLabel();
        NotedMenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        QuitMenuItem = new javax.swing.JMenuItem();
        InsertMenu = new javax.swing.JMenu();
        ImportCodeMenuItem = new javax.swing.JMenuItem();

        C2FMenuItem.setText("Celsius to Fahrenheit");
        C2FMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C2FMenuItemActionPerformed(evt);
            }
        });
        WidgetPopupMenu.add(C2FMenuItem);

        F2CMenuItem.setText("Fahrenheit to Celsius");
        F2CMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F2CMenuItemActionPerformed(evt);
            }
        });
        WidgetPopupMenu.add(F2CMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));

        WidgetPanel.setBackground(new java.awt.Color(248, 255, 255));
        WidgetPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        WidgetPanel.setLayout(new java.awt.GridBagLayout());

        AddWigetButton.setText("Add Widget +");
        AddWigetButton.setToolTipText("Click to add a new widget.");
        AddWigetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddWigetButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 2;
        WidgetPanel.add(AddWigetButton, gridBagConstraints);

        NoteTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NoteTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NoteTitleLabel.setText("Note Title");
        NoteTitleLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AddCategoryButton.setText("Add Category");
        AddCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCategoryButtonActionPerformed(evt);
            }
        });

        AddNoteButton.setText("Add Note");
        AddNoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNoteButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(248, 255, 255));

        FileViewerPanel.setBackground(new java.awt.Color(248, 255, 255));

        FileViewerScrollBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                FileViewerScrollBarAdjustmentValueChanged(evt);
            }
        });

        javax.swing.GroupLayout FileViewerPanelLayout = new javax.swing.GroupLayout(FileViewerPanel);
        FileViewerPanel.setLayout(FileViewerPanelLayout);
        FileViewerPanelLayout.setHorizontalGroup(
            FileViewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FileViewerPanelLayout.createSequentialGroup()
                .addGap(0, 179, Short.MAX_VALUE)
                .addComponent(FileViewerScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        FileViewerPanelLayout.setVerticalGroup(
            FileViewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FileViewerScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(FileViewerPanel);

        javax.swing.GroupLayout SearchPanelLayout = new javax.swing.GroupLayout(SearchPanel);
        SearchPanel.setLayout(SearchPanelLayout);
        SearchPanelLayout.setHorizontalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        SearchPanelLayout.setVerticalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddCategoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AddNoteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(SearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddNoteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddCategoryButton))
        );

        NotePanel.setBackground(new java.awt.Color(248, 255, 255));

        javax.swing.GroupLayout NotePanelLayout = new javax.swing.GroupLayout(NotePanel);
        NotePanel.setLayout(NotePanelLayout);
        NotePanelLayout.setHorizontalGroup(
            NotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NotePanelLayout.createSequentialGroup()
                .addContainerGap(1036, Short.MAX_VALUE)
                .addComponent(NoteScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        NotePanelLayout.setVerticalGroup(
            NotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NoteScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );

        NoteScrollPane.setViewportView(NotePanel);

        WidgetLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        WidgetLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WidgetLabel.setText("Widgets");

        FileMenu.setText("File");

        QuitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        QuitMenuItem.setText("Quit");
        QuitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(QuitMenuItem);

        NotedMenuBar.add(FileMenu);

        InsertMenu.setText("Insert");

        ImportCodeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        ImportCodeMenuItem.setText("Import Code");
        ImportCodeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportCodeMenuItemActionPerformed(evt);
            }
        });
        InsertMenu.add(ImportCodeMenuItem);

        NotedMenuBar.add(InsertMenu);

        setJMenuBar(NotedMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(WidgetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NoteTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NoteScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                    .addComponent(WidgetLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(WidgetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WidgetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoteTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoteScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCategoryButtonActionPerformed
        numUntitledCategories++;
        String newName = "Category" + String.valueOf(numUntitledCategories);
        for(JComponent comp: fileHierarchy){
            if(checkName(comp.getName(),newName)){
               numUntitledCategories++;
               newName = "Category" + String.valueOf(numUntitledCategories);
            }
        }
        
        addCategoryPanel(newName,0);
    }//GEN-LAST:event_AddCategoryButtonActionPerformed

    private void FileViewerScrollBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_FileViewerScrollBarAdjustmentValueChanged
        
    }//GEN-LAST:event_FileViewerScrollBarAdjustmentValueChanged

    private void QuitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitMenuItemActionPerformed
        dispose();
    }//GEN-LAST:event_QuitMenuItemActionPerformed

    private void AddNoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNoteButtonActionPerformed
        numUntitledNotes++;
        String newName = "Note" + String.valueOf(numUntitledNotes);
        for(JComponent comp: fileHierarchy){
            if(checkName(comp.getName(),newName)){
               numUntitledNotes++;
               newName = "Note" + String.valueOf(numUntitledNotes);
            }
        }
        addNotePanel(0, new Note(newName));
        NoteTitleLabel.setText(newName); 
    }//GEN-LAST:event_AddNoteButtonActionPerformed

    private void AddWigetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddWigetButtonActionPerformed
        WidgetPopupMenu.show(this, (int)MouseInfo.getPointerInfo().getLocation().getX(), (int)MouseInfo.getPointerInfo().getLocation().getY());
    }//GEN-LAST:event_AddWigetButtonActionPerformed

    private void C2FMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C2FMenuItemActionPerformed
        WidgetPanel.remove(AddWigetButton);
        WidgetPanel.add(new ConverterWidget());
        WidgetPanel.add(AddWigetButton);
        validate();
    }//GEN-LAST:event_C2FMenuItemActionPerformed

    private void ImportCodeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportCodeMenuItemActionPerformed
        /*JFileChooser fc = new JFileChooser();
        fc.setBounds(300, 300, 500, 500);
        fc.setVisible(true);
        add(fc);
        repaint();*/
        
        CodeBox codebox = new CodeBox();
        codebox.setBounds(0, 0,500,400);
        codebox.setVisible(true);
        NotePanel.add(codebox);
        NotePanel.revalidate();
        NotePanel.repaint();
    }//GEN-LAST:event_ImportCodeMenuItemActionPerformed

    private void F2CMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F2CMenuItemActionPerformed
        WidgetPanel.remove(AddWigetButton);
        WidgetPanel.add(new ConverterWidget2());
        WidgetPanel.add(AddWigetButton);
        validate();
    }//GEN-LAST:event_F2CMenuItemActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Noted_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Noted_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Noted_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Noted_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Noted_Screen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCategoryButton;
    private javax.swing.JButton AddNoteButton;
    private javax.swing.JButton AddWigetButton;
    private javax.swing.JMenuItem C2FMenuItem;
    private javax.swing.JMenuItem F2CMenuItem;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JPanel FileViewerPanel;
    private javax.swing.JScrollBar FileViewerScrollBar;
    private javax.swing.JMenuItem ImportCodeMenuItem;
    private javax.swing.JMenu InsertMenu;
    private javax.swing.JPanel NotePanel;
    private javax.swing.JScrollBar NoteScrollBar;
    private javax.swing.JScrollPane NoteScrollPane;
    private javax.swing.JLabel NoteTitleLabel;
    private javax.swing.JMenuBar NotedMenuBar;
    private javax.swing.JMenuItem QuitMenuItem;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JLabel WidgetLabel;
    private javax.swing.JPanel WidgetPanel;
    private javax.swing.JPopupMenu WidgetPopupMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
