/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Network;

import Model.Adopter.AdopterDirectory;
import Model.Child.ChildDirectory;
import Model.Enterprise.EnterpriseDirectory;

/**
 *
 * @author yashpawar
 */
public class Network {
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
         private ChildDirectory directory;
         private AdopterDirectory adirectory;

    public Network(){
        enterpriseDirectory=new EnterpriseDirectory();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    @Override
    public String toString(){
        return name;
    }
    
}
