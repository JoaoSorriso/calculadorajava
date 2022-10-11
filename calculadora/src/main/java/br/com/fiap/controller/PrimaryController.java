package br.com.fiap.controller;

import java.sql.SQLException;

import br.com.fiap.dao.LogDao;
import br.com.fiap.model.Log;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController {

    @FXML private TextField display;

    private double numero1;
    private String operacao;

    public void digitarNumero(ActionEvent event){
        Button botao = (Button) event.getSource();
        String valorDoDisplay = display.getText();
        if(valorDoDisplay.equals("0")) valorDoDisplay = "";
        display.setText(valorDoDisplay + botao.getText());
    }

    public void clear(){
        display.setText("0");
    }

    public void clearElement(){
        String valorDoDisplay = display.getText();
        valorDoDisplay = valorDoDisplay.substring(0, valorDoDisplay.length()-1);
        display.setText(valorDoDisplay);
    }

    public void raiz(){
        double valorDoDisplay = Double.valueOf(display.getText());
        double raiz = Math.sqrt(valorDoDisplay);
        display.setText(String.valueOf(raiz));
        salvarLog(new Log(valorDoDisplay, 0, "raiz", raiz));
    }
    
    public void quadrado(){
        double valorDoDisplay = Double.valueOf(display.getText());
        double quadrado = Math.pow(valorDoDisplay, 2);
        display.setText(String.valueOf(quadrado));
        salvarLog(new Log(valorDoDisplay, 0, "quadrado", quadrado));
    }

    public void operacao(ActionEvent event){
        Button botao = (Button) event.getSource();
        this.numero1 = Double.valueOf(display.getText());
        this.operacao = botao.getText();
        clear();
    }


    public void calcular(){
        double numero2 = Double.valueOf(display.getText());
        double resultado = 0;
        if (operacao.equals("+")) resultado = numero1 + numero2;
        if (operacao.equals("-")) resultado = numero1 - numero2;
        if (operacao.equals("/")) resultado = numero1 / numero2;
        if (operacao.equals("X")) resultado = numero1 * numero2;

        display.setText(String.valueOf(resultado));
        
        salvarLog(new Log(numero1, numero2, operacao, resultado));

    }

    private void salvarLog(Log log){
        try{
            new LogDao().inserir(log);
        }catch(SQLException e){
            var alerta = new Alert(AlertType.ERROR);
            alerta.setContentText("Não foi possível salvar a operação no BD"+e.getMessage());
            alerta.show();
        }
    }
}
