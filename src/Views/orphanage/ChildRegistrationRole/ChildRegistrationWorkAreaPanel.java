/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.orphanage.ChildRegistrationRole;

import Model.Child.Child;
import Model.Child.ChildDirectory;
import Model.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.Network.Network;
import Model.Organization.Organization;
import Model.Organization.Orphanage.ChildRegistrationOrganization;
import Model.UserAccount.UserAccount;
import Model.WorkQueue.DoctorWorkRequest;
import Model.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author just_chakri
 */
public class ChildRegistrationWorkAreaPanel extends javax.swing.JPanel {

    /**
     * Creates new form ChildRegistrationWorkAreaPanel
     */
    //Attributes though which the data will flow
    JPanel userProcessContainer;
    UserAccount account;
    ChildRegistrationOrganization childRegistrationOrganization;
    Enterprise enterprise;
   Child child;
    ChildDirectory directory;
    EcoSystem business;
    Network network;
    //ChildDirectory anewdir =  this.business.getChildDirectory();
/*Constructor to initialize the componoents*/
    public ChildRegistrationWorkAreaPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory directory) {
     initComponents();
     this.userProcessContainer=userProcessContainer;
  this.account=account;
   this.childRegistrationOrganization= (ChildRegistrationOrganization)organization;
   this.business = business;
    this.directory = directory;
    this.enterprise=enterprise;
     valueLabel.setText(enterprise.getName());
 
  valueLabel1.setText(childRegistrationOrganization.getName());
 
  for(Network net: business.getNetworkList()){
      for(Enterprise ent: net.getEnterpriseDirectory().getEnterpriseList()){
          if(ent.equals(enterprise)){
              network= net;
          }
      }
  }
  
  
  
  poplulateTable();
               populateChildRequestTable();
    }
//Another constructor that is called from the register new child jpanel
//    ChildRegistrationWorkAreaPanel(JPanel userProcessContainer, Child child, ChildDirectory directory, UserAccount account) {
//       initComponents();
//        this.userProcessContainer=userProcessContainer;
//      
//this.directory = directory;
//   //this.anewdir = directory;
// this.account = account;
////        childRegistrationOrganization.getChildDirectory();
//               this.child=child;
////                 valueLabel.setText(childRegistrationOrganization.getName());
//               poplulateTable();
//               populateChildRequestTable();
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        createChildBtn = new javax.swing.JButton();
        viewChildBtn = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        deleteBtn = new javax.swing.JButton();
        enterpriseLabel1 = new javax.swing.JLabel();
        valueLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Child Id", "Child Name", "Gender", "Age", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        createChildBtn.setText("Register new child");
        createChildBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createChildBtnActionPerformed(evt);
            }
        });

        viewChildBtn.setText("View Child Details");
        viewChildBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewChildBtnActionPerformed(evt);
            }
        });

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Organization:");

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valueLabel.setText("<value>");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medical Status", "Sender", "Message", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
        }

        deleteBtn.setText("Delete Child");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        enterpriseLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel1.setText("EnterPrise :");

        valueLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valueLabel1.setText("<value>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(createChildBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(viewChildBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(valueLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(392, 392, 392))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(enterpriseLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(841, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createChildBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewChildBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(enterpriseLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(520, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createChildBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createChildBtnActionPerformed
        // TODO add your handling code here:
        /*This code will take the flow to register a new child*/
       RegisterNewChildJPanel registerChildJpanel = new RegisterNewChildJPanel(userProcessContainer, directory, account, enterprise, business, childRegistrationOrganization);
       this.userProcessContainer.add("RegisterNewChildJPanel", registerChildJpanel);
       CardLayout layout = (CardLayout)this.userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_createChildBtnActionPerformed

    private void viewChildBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewChildBtnActionPerformed
        
        /*This set of code will take the UI to the vie child details*/
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a child to view details");
            return;
        }
        
        child = (Child)jTable1.getValueAt(selectedRow, 0);
             
        ViewChildDetailsJPanel viewChildJpanel = new ViewChildDetailsJPanel(userProcessContainer, child);
       this.userProcessContainer.add("ViewChildDetailsJPanel", viewChildJpanel);
       CardLayout layout = (CardLayout)this.userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewChildBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
       int selectedRow = jTable1.getSelectedRow();
       if(selectedRow<0){
           JOptionPane.showMessageDialog(null, "Please select a child to delete");
       }
       Child ch = (Child) jTable1.getValueAt(selectedRow, 0);
       int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the child?", "Alert", JOptionPane.YES_NO_CANCEL_OPTION);
       if(result==0){
      directory.removeChild(ch);
       }
       poplulateTable();
       
    }//GEN-LAST:event_deleteBtnActionPerformed

/*Method to populate the table of with child details*/    
    public void poplulateTable(){
      
        DefaultTableModel dtms = (DefaultTableModel)jTable1.getModel();
           dtms.setRowCount(0);
       
        for(Child child : directory.getChildList()){
            Object[] row = new Object[dtms.getColumnCount()];
            row[0] = child;
            row[1]=child.getChildname();
            row[2]=child.getChildGender();
            row[3]=child.getChildAge();
            row[4]=child.getStatus();
            dtms.addRow(row);
        
        }
    }
    /*Method to populate the table with work request that has been created for the doctor*/
        public void populateChildRequestTable(){
      
       DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : account.getWorkQueue().getWorkRequestList()){
         
            if(request instanceof DoctorWorkRequest){
            Object[] row = new Object[4];
           row[0]=request;
           row[1]=request.getSender().getEmployee().getName();
           row[2]=request.getMessage();
          
            
            String result = ((DoctorWorkRequest) request).getTestResult();
            row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createChildBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel enterpriseLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JLabel valueLabel1;
    private javax.swing.JButton viewChildBtn;
    // End of variables declaration//GEN-END:variables
}
