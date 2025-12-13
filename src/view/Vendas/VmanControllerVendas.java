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
 * @author u05578596207
 */
public class VmanControllerVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VmanVendas vmanVendas = (VmanVendas) lstVendas.get(rowIndex);
        if (columnIndex == 0) {
            return vmanVendas.getVmanIdVendas();
        } else if (columnIndex == 1) {
            return vmanVendas.getVmanDataVendas();
        } else if (columnIndex == 2) {
            return vmanVendas.getVmanTotal();
        } else if (columnIndex == 3) {
            return vmanVendas.getVmanClientes().getVmanNome();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Data da Venda";
        } else if (columnIndex == 2) {
            return "Total";
        } else if (columnIndex == 3) {
            return "Cliente";
        }
        return "";
    }
}
