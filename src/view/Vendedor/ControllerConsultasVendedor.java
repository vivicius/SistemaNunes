/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.Vendedor;

import bean.VmanVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author 
 */
public class ControllerConsultasVendedor extends AbstractTableModel {

    private List lstVendedores;

    public void setList(List lstVendedores) {
        this.lstVendedores = lstVendedores;
        this.fireTableDataChanged();
        
    }
    
    public VmanVendedor getBean(int rowIndex) {
        return (VmanVendedor) lstVendedores.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendedores.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VmanVendedor vend = (VmanVendedor) lstVendedores.get( rowIndex);
        if ( columnIndex == 0 ){
            return vend.getVmanIdVendedor();
        } else if (columnIndex ==1) {
            return vend.getVmanNome();        
        } else if (columnIndex ==2) {
            return vend.getVmanEmail();
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
        } 
        return "";
    }
}
