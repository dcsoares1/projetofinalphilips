/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhofinal.persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import trabalhofinal.model.ModelExames;

/**
 *
 * @author 320079589
 */
public class ExamesDAO {
    
    ModelExames exames = new ModelExames();
    ConexaoBD connect = new ConexaoBD();      
    
    public void salvarExame(ModelExames model) {      
        connect.conexao();
        try {
            PreparedStatement pst = connect.conn.prepareCall("{call executa_agendamento(?,?,?,?,?)}");           
            pst.setInt(1, model.getCd_agenda());
            pst.setString(2, model.getStatus());
            pst.setDate(3, new java.sql.Date(model.getData_agendamento().getTime()));
            pst.setDate(4, new java.sql.Date(model.getDataEx().getTime()));
            pst.setString(5, model.getParecer());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exame salvo com sucesso!");
        } catch (SQLException ex) {
            String msg = ex.getMessage().substring(ex.getLocalizedMessage().indexOf(":"));
            msg = msg.substring(0, msg.indexOf("ORA"));
            JOptionPane.showMessageDialog(null, "Erro ao salvar Exame" + msg);
        }
        
        connect.desconectar();
    } 

    
}
