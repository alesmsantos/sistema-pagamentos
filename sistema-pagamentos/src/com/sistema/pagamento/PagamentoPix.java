package com.sistema.pagamentos;

public class PagamentoPix implements MetodoPagamento {
    private String chavePix;
    
    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
    }
    
    @Override
    public boolean processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via PIX");
        System.out.println("Chave PIX: " + chavePix);
        return Math.random() > 0.01;
    }
    
    @Override
    public String getTipo() {
        return "PIX";
    }
}