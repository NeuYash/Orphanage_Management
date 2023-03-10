/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Adoption.AdoptersRole;

import Model.Adopter.Adopter;
import Model.Adopter.AdopterDirectory;
import Model.Child.ChildDirectory;
import Model.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.Organization.Adoption.AdopterOrganization;
import Model.Organization.Organization;
import Model.UserAccount.UserAccount;
import Model.WorkQueue.AdopterWorkRequest;
import Model.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yashpawar
 */
public class CheckStatusJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CheckStatusJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    EcoSystem business;
    AdopterDirectory udirectory;
    AdopterOrganization adopterorganization;
    Adopter adopter;
    String bgcstatus,financestatus;
    int uid;
    ChildDirectory directory;
    CheckStatusJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, AdopterDirectory udirectory,int uid, ChildDirectory directory) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.udirectory=udirectory;
        this.account=account;
        this.enterprise=enterprise;
        this.business = business;
        this.adopterorganization =(AdopterOrganization) organization;
        this.uid = uid;
        this.directory = directory;
        //if condition for enabling proceed with adoption button if BGC and fin checks are approved
       for(Adopter a: udirectory.getAdoptersList()){
           if(a.getUsername().equals(account.getUsername())){
               adopter=a;
           }
       }
        
        populateTable();
//        if(bgcstatus.equals("Approved")&& financestatus.equals("Approved")){
//            btnProceedWithAdoption.setEnabled(true);
//        }
        
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
        btnProceedWithAdoption = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Adoption Request Status Page");

        workTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "BGC Status", "Finance Check Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workTable);

        btnProceedWithAdoption.setText("Proceed with Adoption");
        btnProceedWithAdoption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedWithAdoptionActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 949, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(317, 317, 317)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(btnProceedWithAdoption, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnProceedWithAdoption, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProceedWithAdoptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedWithAdoptionActionPerformed
       
        if(workTable.getRowCount()<1){
            JOptionPane.showMessageDialog(null, "Adoption request is still in process with the Investigation team");
        }
        if(bgcstatus.equals("Approved")&& financestatus.equals("Approved")){
            
        ChildSelectionJPanel csjp = new ChildSelectionJPanel(userProcessContainer, account, adopterorganization, enterprise, business, udirectory, uid, directory);
        this.userProcessContainer.add("ChildSelectionJPanel", csjp);
        CardLayout layout = (CardLayout) this.userProcessContainer.getLayout();
        layout.next(userProcessContainer); 
        }
        else if(bgcstatus.equals("Pending")|| financestatus.equals("Pending")){
            JOptionPane.showMessageDialog(null, "Adoption request is still in process with the Investigation team");
        }
        else
            JOptionPane.showMessageDialog(null, "Adoption request denied by Investigation Team");
    }//GEN-LAST:event_btnProceedWithAdoptionActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnProceedWithAdoption;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable workTable;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
       DefaultTableModel dtms = (DefaultTableModel) workTable.getModel();
       dtms.setRowCount(0);
       
       for(WorkRequest req: adopterorganization.getWorkQueue().getWorkRequestList()){
           System.out.println("check status vaala page req user id, uid, account"+req.getUserId()+" "+uid+" "+account.getUsername());
           if(req instanceof AdopterWorkRequest ) {
               if(req.getUserId()==adopter.getUserId()){
               Object[] row = new Object[dtms.getColumnCount()];
               row[0]=req;
               row[1]=((AdopterWorkRequest) req).getBgcStatus();
               row[2]=((AdopterWorkRequest) req).getFinanceStatus();
               dtms.addRow(row);
               
               bgcstatus = ((AdopterWorkRequest) req).getBgcStatus();
               financestatus = ((AdopterWorkRequest) req).getFinanceStatus();
               }
           }
       }
    }
}
