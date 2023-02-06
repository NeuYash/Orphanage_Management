/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Role;

import Model.Adopter.AdopterDirectory;
import Model.Child.ChildDirectory;
import Model.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.Organization.Organization;
import Model.Organization.PharmacistOrganization;
import Model.UserAccount.UserAccount;
import javax.swing.JPanel;
import Views.PharmacistRole.PharmacistWorkAreaJPanel;

/**
 *
 * @author just_chakri
 */
public class PharmacistRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory directory, AdopterDirectory udirectorDirectory) {
        return new PharmacistWorkAreaJPanel(userProcessContainer, account, (PharmacistOrganization)organization,enterprise, business,directory);
    }
    
}
