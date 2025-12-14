/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.Vendas;

import bean.VmanVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author 
 */
public class VmanControllerConsultasVenda extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
        this.fireTableDataChanged();
        
    }
    
    public VmanVendas getBean(int rowIndex) {
        return (VmanVendas) lstVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3 ;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VmanVendas vend = (VmanVendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return vend.getVmanIdVendas();
        } else if (columnIndex ==2) {
            return vend.getVmanClientes();        
        } else if (columnIndex ==1) {
            return vend.getVmanVendedor();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 2) {
            return "Nome Cliente";         
        } else if ( columnIndex == 1) {
            return "Nome Vendedor";
        } 
        return "";
    }
}
