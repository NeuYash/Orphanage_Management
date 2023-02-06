/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Verification.BackgroundAndCriminalCheckRole;

import Views.Verification.BackgroundAndCriminalCheckRole.BackgroundAndCriminalCheckProcessRequestJPanel;
import Model.Adopter.Adopter;
import Model.Adopter.AdopterDirectory;
import Model.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.Organization.Verification.BackgroundAndCriminalCheckOrganization;
import Model.Organization.Organization;
import Model.UserAccount.UserAccount;
import Model.WorkQueue.BGCWorkRequest;
import Model.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yashpawar
 */
public class BackgroundAndCriminalCheckWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    EcoSystem business;
    AdopterDirectory udirectory;
    BackgroundAndCriminalCheckOrganization bgcOrganization;
    Adopter adopter;
    public BackgroundAndCriminalCheckWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, AdopterDirectory udirectory) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.udirectory=udirectory;
        this.account=account;
        this.enterprise=enterprise;
        this.business = business;
        this.bgcOrganization = (BackgroundAndCriminalCheckOrganization)organization;
        valueLabel.setText(enterprise.getName());
        orgLabel.setText(organization.getName());
        this.adopter = adopter;
        populateWorkRequest();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workTable = new javax.swing.JTable();
        processBtn = new javax.swing.JButton();
        assignBtn = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        orgLabel = new javax.swing.JLabel();
        enterpriseLabel1 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Work Queue");

        workTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Receiver", "UserId", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workTable);
        if (workTable.getColumnModel().getColumnCount() > 0) {
            workTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            workTable.getColumnModel().getColumn(1).setResizable(false);
            workTable.getColumnModel().getColumn(3).setResizable(false);
            workTable.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        processBtn.setText("Process Request");
        processBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processBtnActionPerformed(evt);
            }
        });

        assignBtn.setText("Assign to me");
        assignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignBtnActionPerformed(evt);
            }
        });

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Organization:");

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valueLabel.setText("<value>");

        orgLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        orgLabel.setText("<value>");

        enterpriseLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel1.setText("EnterPrise :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(enterpriseLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(orgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1048, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(assignBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(processBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(processBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assignBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void processBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processBtnActionPerformed
        int selectedRow = workTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a workrequest");
            return;
        }
        WorkRequest req = (WorkRequest) workTable.getValueAt(selectedRow, 0);
        Object receiverval =  workTable.getValueAt(selectedRow, 2);
        Object statusval =  workTable.getValueAt(selectedRow, 4);
        for(Adopter a: udirectory.getAdoptersList()){
            if(a.getUserId()==req.getUserId()){
                adopter=a;
            }
        }
        if(receiverval==null){
            JOptionPane.showMessageDialog(null,"Please first assign it to yourself");
        }
        else{
        if( receiverval.equals(account.getUsername()) && statusval.equals("BGC organization processing")){
        BackgroundAndCriminalCheckProcessRequestJPanel baccprj = new BackgroundAndCriminalCheckProcessRequestJPanel(userProcessContainer,account, bgcOrganization, enterprise, business, udirectory,(BGCWorkRequest) req, adopter);
        this.userProcessContainer.add("BackgroundAndCriminalCheckProcessRequestJPanel", baccprj);
        CardLayout layout = (CardLayout)this.userProcessContainer.getLayout();
        layout.next(userProcessContainer);}
        else if(statusval.equals("Approved")|| statusval.equals("Denied"))
            JOptionPane.showMessageDialog(null,"The selected workrerequest is already processed");
        else if(!receiverval.equals(account.getUsername()))
            JOptionPane.showMessageDialog(null,"Please select the work request assigned to you to proceed");
        } 
    }//GEN-LAST:event_processBtnActionPerformed

    private void assignBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignBtnActionPerformed
        int selectedRow = workTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a workrequest");
            return;
        }
        Object receiverval =  workTable.getValueAt(selectedRow, 2);
        Object statusval =  workTable.getValueAt(selectedRow, 4);
        
        
        if(statusval.equals("Pending with BGC organization")){
        WorkRequest re = (WorkRequest) workTable.getValueAt(selectedRow, 0);
        re.setReceiver(account);
        re.setStatus("BGC organization processing");
        populateWorkRequest();
        }
        else{
        if(statusval.equals("Approved")||statusval.equals("Denied"))
            JOptionPane.showMessageDialog(null,"Please select some other request,this work request is already processed");
        else if(!receiverval.equals(account.getUsername()))
            JOptionPane.showMessageDialog(null,"Work request is assigned to someone else");
        else if(receiverval.equals(account.getUsername()))
            JOptionPane.showMessageDialog(null,"Work request is already assigned to you");
        } 
    }//GEN-LAST:event_assignBtnActionPerformed

public void populateWorkRequest(){
      
        DefaultTableModel dtm = (DefaultTableModel)workTable.getModel();
            dtm.setRowCount(0);
        for (WorkRequest request : bgcOrganization.getWorkQueue().getWorkRequestList()){
            if(request instanceof BGCWorkRequest){
           Object[] row = new Object[dtm.getColumnCount()];
           row[0]=request;
           row[1]=request.getSender().getEmployee().getName();
           row[2]=request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
           row[3] = request.getUserId();
           row[4] = request.getStatus();
            dtm.addRow(row);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignBtn;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel enterpriseLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel orgLabel;
    private javax.swing.JButton processBtn;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workTable;
    // End of variables declaration//GEN-END:variables
}
