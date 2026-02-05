package com.sistema.pagamentos;

public class PagamentoCartaoCredito implements MetodoPagamento {
    private String numeroCartao;
    private String nomeTitular;
    
    public PagamentoCartaoCredito(String numeroCartao, String nomeTitular) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
    }
    
    @Override
    public boolean processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Cartão de Crédito");
        System.out.println("Cartão: ****" + numeroCartao.substring(numeroCartao.length() - 4));
        return Math.random() > 0.1;
    }
    
    @Override
    public String getTipo() {
        return "CARTÃO_CRÉDITO";
    }
}