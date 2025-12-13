/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.Vendas;

import bean.VmanVendasProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u05578596207
 */
public class VmanControllerVendasProdutoVs extends AbstractTableModel {

    private List lstVendasProdutos;

    public void setList(List lstVendasProdutos) {
        this.lstVendasProdutos = lstVendasProdutos;
        this.fireTableDataChanged();
    }

    public VmanVendasProdutos getBean(int rowIndex) {
        return (VmanVendasProdutos) lstVendasProdutos.get(rowIndex);
    }

    public void addBean(VmanVendasProdutos vmanVendasProd) {
        lstVendasProdutos.add(vmanVendasProd);
        this.fireTableDataChanged();
    }

    public void removeBean(int rowIndex) {
        lstVendasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstVendasProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VmanVendasProdutos vmanVendasProd = (VmanVendasProdutos) lstVendasProdutos.get(rowIndex);
        if (columnIndex == 0) {
            return vmanVendasProd.getVmanIdVendasProdutos();
        } else if (columnIndex == 1) {
            return vmanVendasProd.getVmanProdutos().getVmanProduto();
        } else if (columnIndex == 2) {
            return vmanVendasProd.getVmanQuantidade();
        } else if (columnIndex == 3) {
            return vmanVendasProd.getVmanValorUnitario();
        } else if (columnIndex == 4) {
            return vmanVendasProd.getVmanValorUnitario()* vmanVendasProd.getVmanQuantidade();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Produto";
        } else if (columnIndex == 2) {
            return "Quantidade";
        } else if (columnIndex == 3) {
            return "Valor Unitário";
        } else if (columnIndex == 4) {
            return "Total";
        }
        return "";
    }
}
