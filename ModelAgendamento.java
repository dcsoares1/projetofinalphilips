
package trabalhofinal.model;

import java.util.Date;


public class ModelAgendamento {
    
    private int cd_agenda;
    private String nmPaciente;
    private String nmMedico;
    private Date data;
    private String tipoExame;
    private String status;

    /**
     * @return the cd_agenda
     */
    public int getCd_agenda() {
        return cd_agenda;
    }

    /**
     * @param cd_agenda the cd_agenda to set
     */
    public void setCd_agenda(int cd_agenda) {
        this.cd_agenda = cd_agenda;
    }

    /**
     * @return the nmPaciente
     */
    public String getNmPaciente() {
        return nmPaciente;
    }

    /**
     * @param nmPaciente the nmPaciente to set
     */
    public void setNmPaciente(String nmPaciente) {
        this.nmPaciente = nmPaciente;
    }

    /**
     * @return the nmMedico
     */
    public String getNmMedico() {
        return nmMedico;
    }

    /**
     * @param nmMedico the nmMedico to set
     */
    public void setNmMedico(String nmMedico) {
        this.nmMedico = nmMedico;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the tipoExame
     */
    public String getTipoExame() {
        return tipoExame;
    }

    /**
     * @param tipoExame the tipoExame to set
     */
    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
