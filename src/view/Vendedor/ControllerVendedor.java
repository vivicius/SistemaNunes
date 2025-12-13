/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Vendedor;

import view.Vendedor.*;
import bean.VmanVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u1845853
 */
public class ControllerVendedor extends AbstractTableModel {

    private List lstVendedor;

    public void setList(List lstVendedor) {
        this.lstVendedor = lstVendedor;
    }
    
    public VmanVendedor getBean(int rowIndex) {
        return (VmanVendedor) lstVendedor.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendedor.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VmanVendedor usuarios = (VmanVendedor) lstVendedor.get( rowIndex);
        if ( columnIndex == 0 ){
            return usuarios.getVmanIdVendedor();
        } else if (columnIndex ==1) {
            return usuarios.getVmanNome();        
        } else if (columnIndex ==2) {
            return usuarios.getVmanEmail();
        } else if (columnIndex ==3) {
            return usuarios.getVmanCpf();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Email";
        } else if ( columnIndex == 3) {
            return "Cpf";
        } 
        return "";
    }
    
}
