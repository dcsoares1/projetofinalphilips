/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhofinal.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBD {

    
    public Statement stm;  //pesquisa no banco
    public ResultSet rs;   //armazena resultado da pesquisa
    private String driver = "oracle.jdbc.driver.OracleDriver"; 
    private String caminho = "jdbc:oracle:thin:@localhost:1521:xe"; 
    private String usuario = "douglasAdm"; 
    private String senha = "260188"; 
    public Connection conn;    
    public boolean conectado;
    
   public void conexao() {
       System.setProperty("jdbc.Drivers", driver);
        try {
            conn = DriverManager.getConnection(caminho, usuario, senha);      
            conectado = true;
        } catch (SQLException ex) {
            conectado = false;
            JOptionPane.showMessageDialog(null,"Conecção mal sucedida:\n" + ex.getMessage());
        }
   }
   
   public void executaPesquisa(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Executar SQL:\n" + ex.getMessage());
        }
       
   }
   
   public void desconectar(){
        try {
            conn.close();           
        } catch (SQLException ex) {          
        }
   }
   
}

