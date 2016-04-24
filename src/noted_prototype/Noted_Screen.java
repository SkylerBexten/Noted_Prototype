
package noted_prototype;

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
        WidgetPanel.add(new TimeWidget());
        //WidgetPanel.add(new Add)
        SearchBar bar = new SearchBar();
        bar.setBounds(0,0,177,30);
        SearchPanel.add(bar);
    }
    
    //Change the screen currently open note
    public void changeCurrentNote(Note note){
        if(currentNote != null){currentNote.setClosed();}
        currentNote = note;
        UpdateNotePanel();
    }
    
    //Update the note panel area.
    public void UpdateNotePanel(){
        NoteTitleField.setText(currentNote.getName());
        NoteTitleField.repaint();
        
        System.out.println(currentNote.getContents().size());
        ArrayList<JComponent> comps = currentNote.getContents();
        NotePanel.removeAll();
        for(int j = 0; j < comps.size(); j++){
            JComponent comp = comps.get(j);
            comp.setLocation(0, j*100);
            comp.setSize(NotePanel.getWidth(),comp.getHeight());
            NotePanel.add(comp);
        }
        NotePanel.validate();
        NotePanel.repaint();
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
    
    //Add a new note panel to the file
    //viewer panel
    public void addNotePanel(int depth, Note note){
        NotePanel newPanel = new NotePanel(0, note, this);
        fileHierarchy.add(newPanel);
        redrawFileHierarchy();
    }
    
    //Returns true if another note already has this name.
    private boolean checkName(String name,String newName){
        return name.compareTo(newName) == 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WidgetPopupMenu = new javax.swing.JPopupMenu();
        WidgetPanel = new javax.swing.JPanel();
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
        NoteTitleField = new javax.swing.JTextField();
        NotedMenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        QuitMenuItem = new javax.swing.JMenuItem();
        InsertMenu = new javax.swing.JMenu();
        ImportCodeMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        C2FMenuItem = new javax.swing.JMenuItem();
        F2CMenuItem = new javax.swing.JMenuItem();
        TMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        WidgetPanel.setBackground(new java.awt.Color(248, 255, 255));
        WidgetPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        WidgetPanel.setLayout(new java.awt.GridBagLayout());

        AddCategoryButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddCategoryButton.setText("Add Category");
        AddCategoryButton.setIconTextGap(10);
        AddCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCategoryButtonActionPerformed(evt);
            }
        });

        AddNoteButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddNoteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noted_prototype/Media/Plus.png"))); // NOI18N
        AddNoteButton.setText("Add Note");
        AddNoteButton.setIconTextGap(10);
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

        SearchPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SearchPanelMousePressed(evt);
            }
        });

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
            .addComponent(SearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddNoteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddCategoryButton)
                .addContainerGap())
        );

        NotePanel.setBackground(new java.awt.Color(248, 255, 255));
        NotePanel.setPreferredSize(new java.awt.Dimension(800, 413));

        javax.swing.GroupLayout NotePanelLayout = new javax.swing.GroupLayout(NotePanel);
        NotePanel.setLayout(NotePanelLayout);
        NotePanelLayout.setHorizontalGroup(
            NotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NotePanelLayout.createSequentialGroup()
                .addContainerGap(783, Short.MAX_VALUE)
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

        NoteTitleField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NoteTitleField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NoteTitleField.setText("Note Title");
        NoteTitleField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NoteTitleFieldKeyTyped(evt);
            }
        });

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

        jMenu1.setText("Widgets");

        C2FMenuItem.setText("Celsius to Fahrenheit");
        C2FMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C2FMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(C2FMenuItem);

        F2CMenuItem.setText("Fahrenheit to Celsius");
        F2CMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F2CMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(F2CMenuItem);

        TMenuItem.setText("Current Time");
        TMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(TMenuItem);

        NotedMenuBar.add(jMenu1);

        setJMenuBar(NotedMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(WidgetLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NoteScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                            .addComponent(WidgetPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NoteTitleField))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(WidgetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WidgetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoteTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoteScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCategoryButtonActionPerformed
        //Create default name for a new category.
        numUntitledCategories++;
        String newName = "Category" + String.valueOf(numUntitledCategories);
        for(JComponent comp: fileHierarchy){
            if(checkName(comp.getName(),newName)){
               numUntitledCategories++;
               newName = "Category" + String.valueOf(numUntitledCategories);
            }
        }
        //Create a new category panel
        //with a name and depth
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
        
        Note note = new Note(newName);
        note.addTextBox();
        currentNote = note;
        addNotePanel(0, note);
        NoteTitleField.setText(newName); 
        
        //Get note contents and display them in
        //the note panel.
        UpdateNotePanel();
    }//GEN-LAST:event_AddNoteButtonActionPerformed

    private void C2FMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C2FMenuItemActionPerformed
        WidgetPanel.add(new ConverterWidget());
        validate();
        repaint();
    }//GEN-LAST:event_C2FMenuItemActionPerformed

    private void ImportCodeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportCodeMenuItemActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(Noted_Screen.this);
        System.out.println(NotePanel.getWidth());
        CodeBox codebox = new CodeBox(NotePanel.getWidth());
        codebox.setVisible(true);
        currentNote.addCodeBox(codebox);
        
        UpdateNotePanel();
    }//GEN-LAST:event_ImportCodeMenuItemActionPerformed

    private void F2CMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F2CMenuItemActionPerformed
        WidgetPanel.add(new ConverterWidget2());
        validate();
        repaint();
    }//GEN-LAST:event_F2CMenuItemActionPerformed

    private void NoteTitleFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoteTitleFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_NoteTitleFieldKeyTyped

    private void SearchPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchPanelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchPanelMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseReleased

    private void TMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TMenuItemActionPerformed
        // TODO add your handling code here:
        WidgetPanel.add(new TimeWidget());
        validate();
        repaint();
    }//GEN-LAST:event_TMenuItemActionPerformed
    
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
    private javax.swing.JTextField NoteTitleField;
    private javax.swing.JMenuBar NotedMenuBar;
    private javax.swing.JMenuItem QuitMenuItem;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JMenuItem TMenuItem;
    private javax.swing.JLabel WidgetLabel;
    private javax.swing.JPanel WidgetPanel;
    private javax.swing.JPopupMenu WidgetPopupMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
