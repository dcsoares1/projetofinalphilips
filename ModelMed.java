/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhofinal.model;

/**
 *
 * @author 320079589
 */
public class ModelMed {
    
    private int cod;
    private String nome;
    private String cpf;
    private int crm;
    private String sexo; 
    private String dtn; 
    private String telefone;
    private String pesquisa;
    
    public String getPesquisa() {
        return pesquisa;
    }
    
    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getCrm() {
        return crm;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDtn() {
        return dtn;
    }

    public String getTelefone() {
        return telefone;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @param crm the crm to set
     */
    public void setCrm(int crm) {
        this.crm = crm;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @param dtn the dtn to set
     */
    public void setDtn(String dtn) {
        this.dtn = dtn;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }    
}
