/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.pkudiet;

import db.DBConnection;
import db.DBStatement;
import db.entities.Patient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author olga
 */
public class PKUDietUI extends javax.swing.JFrame {

    /**
     * Creates new form PKUDietUI
     */
    private javax.swing.DefaultListModel ListModel;
    private ArrayList<Patient> patients;

    public PKUDietUI() {
        //initComponents();
        SelectPatientButton = new javax.swing.JButton();
        ChangePatientButton = new javax.swing.JButton();
        DeletePatientButton = new javax.swing.JButton();
        AddPatientButton = new javax.swing.JButton();
        TitleLabel = new javax.swing.JLabel();
        ExitButton = new javax.swing.JButton();
        PatientScrollPane = new javax.swing.JScrollPane();
        PatientList = new javax.swing.JList();
        ListModel = new javax.swing.DefaultListModel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PKU Diet For Life");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.lightGray);
        setName("MainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 400));

        SelectPatientButton.setText("Выбрать");
        SelectPatientButton.setPreferredSize(new java.awt.Dimension(120, 30));
        SelectPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectPatientButtonActionPerformed(evt);
            }
        });

        ChangePatientButton.setText("Изменить");
        ChangePatientButton.setPreferredSize(new java.awt.Dimension(120, 30));
        ChangePatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangePatientButtonActionPerformed(evt);
            }
        });

        DeletePatientButton.setText("Удалить");
        DeletePatientButton.setPreferredSize(new java.awt.Dimension(120, 30));
        DeletePatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletePatientButtonActionPerformed(evt);
            }
        });

        AddPatientButton.setText("Добавить");
        AddPatientButton.setPreferredSize(new java.awt.Dimension(120, 30));
        AddPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPatientButtonActionPerformed(evt);
            }
        });

        TitleLabel.setText("Пациенты");

        ExitButton.setText("Выйти");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        DBConnection connect = new DBConnection("localhost", "olga", "pku", "pku_diet");
        connect.initProperties();
        connect.init();
        DBStatement stmt = new DBStatement(connect);
        ResultSet rs = stmt.getQuery("SELECT * FROM patient;");
        ArrayList<Patient> patients = new ArrayList<Patient>();
        try {
            while (rs.next()) {
                Patient p = new Patient();
                p.setID(rs.getInt("id"));
                p.setSurname(rs.getString("surname"));
                p.setName(rs.getString("name"));
                p.setDateOfBirth(rs.getDate("date_of_birth"));
                p.setGender(rs.getString("gender"));
                patients.add(p);
                System.out.println(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PKUDietUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        stmt.finalize();
        connect.finalize();
        for (int i = 0; i < patients.size(); i++){
            ListModel.addElement(patients.get(i).getName()+" "+patients.get(i).getSurname());
        }
        
            

        PatientList.setModel(ListModel);
        PatientScrollPane.setViewportView(PatientList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TitleLabel)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(PatientScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(SelectPatientButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(AddPatientButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(DeletePatientButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ExitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ChangePatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(103, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{AddPatientButton, ChangePatientButton, DeletePatientButton, ExitButton, SelectPatientButton});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(TitleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(SelectPatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(AddPatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(ChangePatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(DeletePatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(PatientScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(ExitButton)
                        .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{AddPatientButton, ChangePatientButton, DeletePatientButton, ExitButton, SelectPatientButton});

        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SelectPatientButton = new javax.swing.JButton();
        ChangePatientButton = new javax.swing.JButton();
        DeletePatientButton = new javax.swing.JButton();
        AddPatientButton = new javax.swing.JButton();
        TitleLabel = new javax.swing.JLabel();
        ExitButton = new javax.swing.JButton();
        PatientScrollPane = new javax.swing.JScrollPane();
        PatientList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PKU Diet For Life");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.lightGray);
        setName("MainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 400));

        SelectPatientButton.setText("Выбрать");
        SelectPatientButton.setPreferredSize(new java.awt.Dimension(120, 30));
        SelectPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectPatientButtonActionPerformed(evt);
            }
        });

        ChangePatientButton.setText("Изменить");
        ChangePatientButton.setPreferredSize(new java.awt.Dimension(120, 30));
        ChangePatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangePatientButtonActionPerformed(evt);
            }
        });

        DeletePatientButton.setText("Удалить");
        DeletePatientButton.setPreferredSize(new java.awt.Dimension(120, 30));
        DeletePatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletePatientButtonActionPerformed(evt);
            }
        });

        AddPatientButton.setText("Добавить");
        AddPatientButton.setPreferredSize(new java.awt.Dimension(120, 30));
        AddPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPatientButtonActionPerformed(evt);
            }
        });

        TitleLabel.setText("Пациенты");

        ExitButton.setText("Выйти");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        PatientList.setModel(new javax.swing.AbstractListModel() {
            ArrayList<String> strings = new ArrayList<>();
            public int getSize() { return strings.size(); }
            public Object getElementAt(int i) { return strings.get(i); }
        });
        PatientList.setPreferredSize(new java.awt.Dimension(200, 200));
        PatientScrollPane.setViewportView(PatientList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TitleLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PatientScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SelectPatientButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddPatientButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeletePatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ChangePatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AddPatientButton, ChangePatientButton, DeletePatientButton, ExitButton, SelectPatientButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(TitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PatientScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SelectPatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(AddPatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(ChangePatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeletePatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addComponent(ExitButton)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AddPatientButton, ChangePatientButton, DeletePatientButton, ExitButton, SelectPatientButton});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPatientButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddPatientButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void ChangePatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangePatientButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChangePatientButtonActionPerformed

    private void SelectPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectPatientButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelectPatientButtonActionPerformed

    private void DeletePatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletePatientButtonActionPerformed
        
    }//GEN-LAST:event_DeletePatientButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PKUDietUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PKUDietUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PKUDietUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PKUDietUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                PKUDietUI mainFrame = new PKUDietUI();
                mainFrame.setVisible(true);

            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPatientButton;
    private javax.swing.JButton ChangePatientButton;
    private javax.swing.JButton DeletePatientButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JList PatientList;
    private javax.swing.JScrollPane PatientScrollPane;
    private javax.swing.JButton SelectPatientButton;
    private javax.swing.JLabel TitleLabel;
    // End of variables declaration//GEN-END:variables
}
