package br.com.fiap.model;

public class Log {
    private double numero1;
    private double numero2;
    private String operacao;
    private double resultado;

    

    public Log(double numero1, double numero2, String operacao, double resultado) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacao = operacao;
        this.resultado = resultado;
    }

    public double getNumero1() {
        return numero1;
    }
    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }
    public double getNumero2() {
        return numero2;
    }
    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }
    public String getOperacao() {
        return operacao;
    }
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
    public double getResultado() {
        return resultado;
    }
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Log [numero1=" + numero1 + ", numero2=" + numero2 + ", operacao=" + operacao + ", resultado="
                + resultado + "]";
    }

    
    
}
