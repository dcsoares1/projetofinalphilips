
package trabalhofinal.model;

/**
 *
 * @author Douglas Soares
 */
public class ModelPessoa {
    
    private int cod;   
    private String nome;
    private String cpf;
    private String sexo;
    private String estCivil;
    private String telefone;
    private String dtn;
    private String pesquisa;

    
     public int getCod() {
        return cod;
    }
     
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the estCivil
     */
    public String getEstCivil() {
        return estCivil;
    }

    /**
     * @param estCivil the estCivil to set
     */
    public void setEstCivil(String estCivil) {
        this.estCivil = estCivil;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the dtn
     */
    public String getDtn() {
        return dtn;
    }

    /**
     * @param dtn the dtn to set
     */
    public void setDtn(String dtn) {
        this.dtn = dtn;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    
    
}
