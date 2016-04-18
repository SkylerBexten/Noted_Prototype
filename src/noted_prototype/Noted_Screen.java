
package noted_prototype;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class Noted_Screen extends javax.swing.JFrame {

    private static int lastCategoryIndex = 0;
    private ArrayList<JComponent> fileHierarchy = new ArrayList<JComponent>();
    private static int numUntitledNotes = 0;
    private static int numUntitledCategories = 0;
    private static int numWidgets = 0;
    private static ArrayList<JPanel> widgets = new ArrayList<>();
    
    public Noted_Screen() {
        initComponents();
        SearchBar bar = new SearchBar();
        bar.setBounds(0,0,177,30);
        SearchPanel.add(bar);
        UpdateWidgetsPanel();
    }
    
    private void UpdateWidgetsPanel(){
        WidgetPanel.removeAll();
        
       //Record x and y coordinates for adding
       //in new components to the widgets panel
        int x = 0;
        int y = 0;
        
        //Add all widgets to the panel.
        for(JPanel widget: widgets){
            widget.setLocation(x, 0);
            x += widget.getWidth();
            WidgetPanel.add(widget);
        }
        
       //Create combo box for widget options
       JComboBox<String> widgetOptions = new JComboBox<>();
       widgetOptions.addItem("Unit Converter");
       widgetOptions.addItem("Calculator");
       widgetOptions.addItem("Clock");
       widgetOptions.setBounds(x, 20, 120, 20);
       
       AddWidgetButton.setBounds(x, 40, 120, 20);
       WidgetPanel.add(AddWidgetButton);
       WidgetPanel.add(widgetOptions);
       WidgetPanel.revalidate();
       WidgetPanel.repaint();
    }
    
    //Add a new category panel to the screen.
    public void addCategoryPanel(String name, int depth){
        CategoryPanel newPanel = new CategoryPanel(depth,new Category(name));
        //Add a new category panel at the specified position
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
    
    //Add a new note to the program, updating the file
    //hierarchy and the FileViewerPanel.
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

        WidgetPanel = new javax.swing.JPanel();
        AddWidgetButton = new javax.swing.JButton();
        NoteTitleLabel = new javax.swing.JLabel();
        LeftHandPanel = new javax.swing.JPanel();
        AddCategoryButton = new javax.swing.JButton();
        AddNoteButton = new javax.swing.JButton();
        FileViewerScrollPane = new javax.swing.JScrollPane();
        FileViewerPanel = new javax.swing.JPanel();
        FileViewerScrollBar = new javax.swing.JScrollBar();
        SearchPanel = new javax.swing.JPanel();
        NoteScrollPane = new javax.swing.JScrollPane();
        NotePanel = new javax.swing.JPanel();
        NoteScrollBar = new javax.swing.JScrollBar();
        WidgetLabel = new javax.swing.JLabel();
        NotedMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        QuitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));

        WidgetPanel.setBackground(new java.awt.Color(248, 255, 255));
        WidgetPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AddWidgetButton.setText("Add Widget");
        AddWidgetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddWidgetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout WidgetPanelLayout = new javax.swing.GroupLayout(WidgetPanel);
        WidgetPanel.setLayout(WidgetPanelLayout);
        WidgetPanelLayout.setHorizontalGroup(
            WidgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WidgetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddWidgetButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        WidgetPanelLayout.setVerticalGroup(
            WidgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WidgetPanelLayout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(AddWidgetButton)
                .addGap(33, 33, 33))
        );

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

        FileViewerScrollPane.setBackground(new java.awt.Color(248, 255, 255));
        FileViewerScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

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

        FileViewerScrollPane.setViewportView(FileViewerPanel);

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

        javax.swing.GroupLayout LeftHandPanelLayout = new javax.swing.GroupLayout(LeftHandPanel);
        LeftHandPanel.setLayout(LeftHandPanelLayout);
        LeftHandPanelLayout.setHorizontalGroup(
            LeftHandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddCategoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AddNoteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(FileViewerScrollPane)
            .addComponent(SearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LeftHandPanelLayout.setVerticalGroup(
            LeftHandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftHandPanelLayout.createSequentialGroup()
                .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FileViewerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                .addGap(0, 897, Short.MAX_VALUE)
                .addComponent(NoteScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        NotePanelLayout.setVerticalGroup(
            NotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NoteScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
        );

        NoteScrollPane.setViewportView(NotePanel);

        WidgetLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        WidgetLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WidgetLabel.setText("Widgets");

        jMenu1.setText("File");

        QuitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        QuitMenuItem.setText("Quit");
        QuitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(QuitMenuItem);

        NotedMenuBar.add(jMenu1);

        setJMenuBar(NotedMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LeftHandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(WidgetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NoteTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NoteScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
                    .addComponent(WidgetLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(WidgetLabel)
                .addGap(3, 3, 3)
                .addComponent(WidgetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoteTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoteScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
            .addComponent(LeftHandPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void AddWidgetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddWidgetButtonActionPerformed
        JPanel newPanel = new JPanel();
        newPanel.setSize(140, WidgetPanel.getHeight());
        newPanel.setBackground(Color.white);
        newPanel.setBorder(new LineBorder(Color.black));
        newPanel.setVisible(true);
        widgets.add(newPanel);
        UpdateWidgetsPanel();
    }//GEN-LAST:event_AddWidgetButtonActionPerformed
    
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
    private javax.swing.JButton AddWidgetButton;
    private javax.swing.JPanel FileViewerPanel;
    private javax.swing.JScrollBar FileViewerScrollBar;
    private javax.swing.JScrollPane FileViewerScrollPane;
    private javax.swing.JPanel LeftHandPanel;
    private javax.swing.JPanel NotePanel;
    private javax.swing.JScrollBar NoteScrollBar;
    private javax.swing.JScrollPane NoteScrollPane;
    private javax.swing.JLabel NoteTitleLabel;
    private javax.swing.JMenuBar NotedMenuBar;
    private javax.swing.JMenuItem QuitMenuItem;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JLabel WidgetLabel;
    private javax.swing.JPanel WidgetPanel;
    private javax.swing.JMenu jMenu1;
    // End of variables declaration//GEN-END:variables
}
