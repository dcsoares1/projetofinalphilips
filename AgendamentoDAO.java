/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal.persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import trabalhofinal.model.ModelAgendamento;
import java.util.*;

/**
 *
 * @author 320079589
 */
public class AgendamentoDAO {

    ModelAgendamento agenda = new ModelAgendamento();
    ConexaoBD connect = new ConexaoBD();
    ConexaoBD connPaciente = new ConexaoBD();
    ConexaoBD connMedico = new ConexaoBD();

    int codPac;
    int codMed;

    public void salvarAgenda(ModelAgendamento model) {
        buscarPac(model.getNmPaciente());
        buscarMed(model.getNmMedico());
        connect.conexao();
        try {
            PreparedStatement pst = connect.conn.prepareStatement("insert into agendamento(cd_agenda, agenda_cd_pac, agenda_cd_med, tipo_exame, agenda_data, agenda_status) values (cd_agenda.nextval,?,?,?,?,?)");
            pst.setInt(1, codPac);
            pst.setInt(2, codMed);
            pst.setString(3, model.getTipoExame());
            pst.setDate(4, new java.sql.Date(model.getData().getTime()));
            pst.setString(5, model.getStatus());       
            pst.execute();         
            JOptionPane.showMessageDialog(null, "Agendamento salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar Agendamento" + ex);
        }
        
        connect.desconectar();
    }

    public void buscarPac(String pac) {
        connPaciente.conexao();

        connPaciente.executaPesquisa("select *from pessoa where nm_pessoa = '" +pac+ "'");
        try {
            connPaciente.rs.first();
            codPac = connPaciente.rs.getInt("cd_pessoa");            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Paciente não encontrado");
        }     
    }

    public void buscarMed(String med) {
        connMedico.conexao();
        connMedico.executaPesquisa("select * from medico where nm_medico = '" +med + "'");
        try {
            connMedico.rs.first();
            codMed = connMedico.rs.getInt("cd_medico");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Médico não encontrado" + ex);
        }    
    }

}
