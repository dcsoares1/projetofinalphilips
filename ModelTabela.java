package trabalhofinal.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelTabela extends AbstractTableModel{
    
    
    private ArrayList linhas = null;
    private String[] colunas = null;
    
public ModelTabela(ArrayList lin, String[] col){
    setLinhas(lin);
    setColunas(col);
}        

    /**
     * @return the linhas
     */
    public ArrayList getLinhas() {
        return linhas;
    }

    /**
     * @param linhas the linhas to set
     */
    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    public int getColumnCount(){
        return colunas.length;
    }
    
    public int getRowCount(){
        return linhas.size();
    }
    
    public String getColumnName(int numCol){
        return colunas[numCol];
    }
    
    public Object getValueAt(int numLin, int numCol){
        Object[] linha =(Object[])getLinhas().get(numLin);
        return linha[numCol];
    }  
}
