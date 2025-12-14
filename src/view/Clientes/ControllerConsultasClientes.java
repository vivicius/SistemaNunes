package view.Clientes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import bean.VmanClientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author 
 */
public class ControllerConsultasClientes extends AbstractTableModel {

    private List lstClientes;

    public void setList(List lstClientes) {
        this.lstClientes = lstClientes;
        this.fireTableDataChanged();
        
    }
    
    public VmanClientes getBean(int rowIndex) {
        return (VmanClientes) lstClientes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstClientes.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VmanClientes cl = (VmanClientes) lstClientes.get( rowIndex);
        if ( columnIndex == 0 ){
            return cl.getVmanIdClientes();
        } else if (columnIndex ==1) {
            return cl.getVmanNome();        
        } else if (columnIndex ==2) {
            return cl.getVmanCpf();
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
            return "CPF";
        } 
        return "";
    }
}
