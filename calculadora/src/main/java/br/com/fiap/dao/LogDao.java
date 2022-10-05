package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.model.Log;

public class LogDao {
    
    public void inserir(Log log) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        var stm = con.prepareStatement("INSERT INTO DDD_CALCULADORA_TB_LOG VALUES (?, ?, ?, ?)");
        stm.setDouble(1, log.getNumero1());
        stm.setDouble(2, log.getNumero2());
        stm.setString(3, log.getOperacao());
        stm.setDouble(4, log.getResultado());

        stm.execute();
        con.close();
    }

}
