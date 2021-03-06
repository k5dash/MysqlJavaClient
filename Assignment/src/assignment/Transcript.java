/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author alfredx
 */
public class Transcript extends javax.swing.JFrame {

    /**
     * Creates new form Transcript
     */
    JavaConnector jc;
    List<courseGrade> courseGrades;
    int [] transcriptCounter;
    MenuObjects MenuObjects;
    public Transcript(JavaConnector jc, int[] transcriptCounter,MenuObjects MenuObjects) {
        initComponents();
        this.jc = jc;
        getTranscript();
        this.transcriptCounter = transcriptCounter;
        this.MenuObjects = MenuObjects;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        CoursesTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        CoursesTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 51, 255));
        jLabel4.setText("Student Menu");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        CoursesTable.setAutoCreateRowSorter(true);
        CoursesTable.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        CoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "UosCode", "Semester", "Year", "Grade"
            }
        ));
        CoursesTable.setRowHeight(30);
        CoursesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CoursesTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(CoursesTable);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 51, 255));
        jLabel5.setText("Transcript");

        CoursesTable1.setAutoCreateRowSorter(true);
        CoursesTable1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        CoursesTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "UosCode", "Title", "Semester", "Year", "Enrollment", "Max Enrollment", "Instructor Name", "Grade"
            }
        ));
        CoursesTable1.setRowHeight(30);
        CoursesTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CoursesTable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(CoursesTable1);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 51, 255));
        jLabel6.setText("Course Details");

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CoursesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoursesTableMouseClicked

         getCourseDetails();
    }//GEN-LAST:event_CoursesTableMouseClicked

    private void CoursesTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoursesTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CoursesTable1MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        transcriptCounter[0]--;
    }//GEN-LAST:event_formWindowClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        getTranscript();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void getCourseDetails(){
         int rowIndex = this.CoursesTable.getSelectedRow();                    // TODO add your handling code here:
         courseGrade courseGrade= courseGrades.get(rowIndex);
         try{
             courseDetails cd = jc.getCourseDetails(courseGrade.course.UosCode, courseGrade.course.semester, courseGrade.course.year);
              DefaultTableModel model = (DefaultTableModel) CoursesTable1.getModel();
                int rows = model.getRowCount(); 
                for(int i = rows - 1; i >=0; i--){
                   model.removeRow(i); 
                }
                 Object[] row = {cd.UosCode,cd.CourseTitle,cd.semester,cd.year,cd.Enrollment,cd.MaxEnrollment,cd.Name,cd.Grade};
                 model.addRow(row);
         }
         catch(SQLException except) {
            JOptionPane.showMessageDialog(rootPane, except.getMessage());
         }
    }
    
    public void getTranscript(){
        try{
             courseGrades = jc.getTranscript();
                DefaultTableModel model = (DefaultTableModel) CoursesTable.getModel();
                int rows = model.getRowCount(); 
                for(int i = rows - 1; i >=0; i--){
                   model.removeRow(i); 
                }
                for (int i = 0; i< courseGrades.size(); i++){
                    courseGrade courseGrade= courseGrades.get(i);               
                    Object[] row = {courseGrade.course.UosCode,courseGrade.course.semester,courseGrade.course.year,courseGrade.grade};
                    model.addRow(row);
                } 
                
        } catch(SQLException except) {
            JOptionPane.showMessageDialog(rootPane, except.getMessage());
       }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CoursesTable;
    private javax.swing.JTable CoursesTable1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
