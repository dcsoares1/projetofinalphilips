/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhofinal.persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import trabalhofinal.model.ModelMed;
import trabalhofinal.model.ModelTabela;

/**
 *
 * @author 320079589
 */
public class MedicoDAO {
    

    
    ConexaoBD connect = new ConexaoBD();
    ModelMed medico = new ModelMed();
    
    public void salvar(ModelMed medico){
        connect.conexao();
        try {
            PreparedStatement pst = connect.conn.prepareStatement("insert into medico (cd_medico, nm_medico, cpf_med, crm_medico, sexo_medico, tel_medico, dtn_medico) values (cd_med.nextval,?,?,?,?,?,?)");
            pst.setString(1, medico.getNome());
            pst.setString(2, medico.getCpf());
            pst.setInt(3, medico.getCrm());
            pst.setString(4, medico.getSexo());
            pst.setString(5, medico.getTelefone());
            pst.setString(6, medico.getDtn());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar o cadastro" + ex.getMessage());
        }
        connect.desconectar();        
    }    
    public void editar (ModelMed mod) {
        connect.conexao();
        try {
            PreparedStatement pst = connect.conn.prepareStatement("update medico set nm_medico=?, cpf_med=?, crm_medico= ?, sexo_medico= ?, tel_medico= ?, dtn_medico= ? where cd_medico = ? ");
            pst.setString(1, medico.getNome());
            pst.setString(2, medico.getCpf());
            pst.setInt(3, medico.getCrm());
            pst.setString(4, medico.getSexo());
            pst.setString(5, medico.getTelefone());
            pst.setString(6, medico.getDtn());
            pst.setInt(7, medico.getCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos Dados /"+ ex);
        }        
        connect.desconectar();
    }
    
    public void deletarMed(ModelMed model){        
        connect.conexao();
        try {
            PreparedStatement pst = connect.conn.prepareStatement("delete from medico where cd_medico =?");
            pst.setInt(1, model.getCod());
            pst.execute();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Dados");
        }        
        connect.desconectar();
    }
    
    
    public ModelMed buscaMed(ModelMed model){
        connect.conexao();
        connect.executaPesquisa("select * from medico where nm_medico like '%"+model.getPesquisa()+"%'");
        try {
            connect.rs.first();
            model.setCod(connect.rs.getInt("cd_medico"));
            model.setNome(connect.rs.getString("nm_medico"));
            model.setCpf(connect.rs.getString("cpf_med"));
            model.setCrm(connect.rs.getInt("crm_medico"));
            model.setSexo(connect.rs.getString("sexo_medico"));
            model.setTelefone(connect.rs.getString("tel_medico"));            
            model.setDtn(connect.rs.getString("dtn_medico"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Cadastro não encontrado" );
        }  
        connect.desconectar();
        return model;        
    }
        
    
}
