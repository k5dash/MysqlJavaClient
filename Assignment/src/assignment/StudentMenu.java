/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
 import javax.swing.table.DefaultTableModel;
import java.util.List;
/**
 *
 * @author alfredx
 */
public class StudentMenu extends javax.swing.JFrame {

    /**
     * Creates new form StudentMenu
     */
    JavaConnector jc;
    Date date;
    List<course> courses;
    int[] transcriptCounter;
    int[] EnrollmentCounter;
    MenuObjects MenuObjects;
    public StudentMenu(JavaConnector jc) {
        initComponents();
        this.jc = jc;
        date = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        this.Time.setText("Date: "+df.format(date));
        this.SideMenu.setSelectedIndex(0);
        getAllCourses();
        transcriptCounter = new int[]{0};
        EnrollmentCounter = new int[]{0};
        MenuObjects = new MenuObjects();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jLabel4 = new javax.swing.JLabel();
        welcomeMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        SideMenu = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        CoursesTable = new javax.swing.JTable();
        LogOutBTN = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 51, 255));
        jLabel4.setText("Student Menu");

        welcomeMessage.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        welcomeMessage.setForeground(new java.awt.Color(204, 0, 204));
        welcomeMessage.setText("Some Text");
        welcomeMessage.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 51, 255));
        jLabel1.setText("Welcome!");

        Time.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Time.setForeground(new java.awt.Color(102, 51, 255));
        Time.setText("Today is");

        SideMenu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SideMenu.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Current Courses", "Transcript", "Enroll", "Withdraw", "Personal Detail", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        SideMenu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        SideMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SideMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SideMenuMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SideMenuMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(SideMenu);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 51, 255));
        jLabel5.setText("Current Courses");

        CoursesTable.setAutoCreateRowSorter(true);
        CoursesTable.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        CoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "UosCode", "Semester", "Year"
            }
        ));
        CoursesTable.setRowHeight(32);
        jScrollPane3.setViewportView(CoursesTable);

        LogOutBTN.setText("Log Out");
        LogOutBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(468, 468, 468)
                                .addComponent(LogOutBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(welcomeMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Time)
                .addGap(128, 128, 128))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Time)
                    .addComponent(jLabel1)
                    .addComponent(welcomeMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LogOutBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    private void SideMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SideMenuMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SideMenuMouseClicked

    private void SideMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SideMenuMousePressed

           if (SideMenu.getSelectedIndex() == 0){
                getAllCourses();
            }
           else if (SideMenu.getSelectedIndex() == 1 && transcriptCounter[0] == 0){
               Transcript t = new Transcript(jc, transcriptCounter, MenuObjects);
               this.MenuObjects.Transcript = t;
               transcriptCounter[0] ++;
               t.setVisible(true);
           }
           else if (SideMenu.getSelectedIndex() == 2 && EnrollmentCounter[0] == 0){
               Enrollment e = new Enrollment(jc, EnrollmentCounter, MenuObjects);
               this.MenuObjects.Enrollment = e;
               EnrollmentCounter[0] ++;
               e.setVisible(true);
           }
    }//GEN-LAST:event_SideMenuMousePressed

    private void LogOutBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutBTNActionPerformed
        jc.logOut();
        this.setVisible(false);
        StudentLogin sl = new StudentLogin(jc);             
        sl.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_LogOutBTNActionPerformed
    
    public void getAllCourses() {
        try{
                DateFormat df = new SimpleDateFormat("MMyyyy");
                Date dateobj = new Date();
                String dateString =df.format(dateobj);
                int month = Integer.valueOf(dateString.substring(0,2));
                int year =Integer.valueOf(dateString.substring(2,6));
                String quarter;
                if (month>=9 && month<=12) {
                    quarter = "Q1";
                }
                else if(month<=8 && month>=7){
                    quarter = "Q4";
                }
                else if(month>=4 && month<=6){
                    quarter = "Q3";
                }
                else {
                    quarter = "Q2";
                }
                jc.month = month;
                jc.year = year;
                jc.quarter = quarter;
                
                courses = jc.getCurrentCources(jc.getStudentID(),year,quarter);
               
                DefaultTableModel model = (DefaultTableModel) CoursesTable.getModel();
                int rows = model.getRowCount(); 
                for(int i = rows - 1; i >=0; i--){
                   model.removeRow(i); 
                }
                for (int i = 0; i< courses.size(); i++){
                    course course= courses.get(i);               
                    Object[] row = {course.UosCode,course.semester,course.year};
                    model.addRow(row);
                }
       }
       catch(SQLException except) {
            JOptionPane.showMessageDialog(rootPane, except.getMessage());
       }
    }
    /**
     * @param args the command line arguments
     */
    public void setMessage (String message) {
        welcomeMessage.setText(message);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CoursesTable;
    private javax.swing.JButton LogOutBTN;
    private javax.swing.JList<String> SideMenu;
    private javax.swing.JLabel Time;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel welcomeMessage;
    // End of variables declaration//GEN-END:variables
}
class MenuObjects{
    public Transcript Transcript;
    public Enrollment Enrollment;
}