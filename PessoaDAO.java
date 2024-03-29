package trabalhofinal.persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;
import trabalhofinal.model.ModelMed;
import trabalhofinal.model.ModelPessoa;

/**
 *
 * @author 320079589
 */
public class PessoaDAO {
        
    ConexaoBD connect = new ConexaoBD();
    ModelPessoa pessoa = new ModelPessoa();
  
    
   public void salvar(ModelPessoa pessoa){
       connect.conexao();
       try {
            PreparedStatement pst = connect.conn.prepareCall("{call insere_pessoa(?,?,?,?,?,?)}");                    
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getCpf());
            pst.setString(3, pessoa.getSexo());
            pst.setString(4, pessoa.getEstCivil());
            pst.setString(5, pessoa.getTelefone());
            pst.setString(6, pessoa.getDtn());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar o cadastro" + ex.getMessage());
        }
        connect.desconectar();        
    }   
   
   public ModelPessoa buscaPes(ModelPessoa model){
        connect.conexao();
        connect.executaPesquisa("select * from pessoa where nm_pessoa like '%"+model.getPesquisa()+"%'");
        try {
            connect.rs.first();
            model.setCod(connect.rs.getInt("cd_pessoa"));
            model.setNome(connect.rs.getString("nm_pessoa"));
            model.setCpf(connect.rs.getString("cpf_pessoa"));
            model.setEstCivil(connect.rs.getString("est_civil_pessoa"));
            model.setSexo(connect.rs.getString("sexo_pessoa"));
            model.setTelefone(connect.rs.getString("telefone_pessoa"));            
            model.setDtn(connect.rs.getString("dtn_pessoa"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Cadastro não encontrado" );
        }  
        connect.desconectar();
        return model;        
    }
   public void editar (ModelPessoa mod) {
        connect.conexao();
        try {
            PreparedStatement pst = connect.conn.prepareCall("{call atualiza_pessoa (?,?,?,?,?,?,?)}");
            pst.setInt(1, mod.getCod());
            pst.setString(2, mod.getNome());
            pst.setString(3, mod.getCpf());
            pst.setString(4, mod.getSexo());
            pst.setString(5, mod.getEstCivil());
            pst.setString(6, mod.getTelefone());
            pst.setString(7, mod.getDtn());           
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos Dados /"+ ex);
        }        
        connect.desconectar();
    }
    
    public void deletarPac(ModelPessoa model){        
        connect.conexao();
        try {
            PreparedStatement pst = connect.conn.prepareStatement("{call exclui_pessoa (?)}");
            pst.setInt(1, model.getCod());
            pst.execute();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Dados" + ex);
        }        
        connect.desconectar();
    }
   }
       

