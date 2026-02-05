package com.sistema.pagamentos;

public class PagamentoPayPal implements MetodoPagamento {
    private String email;
    
    public PagamentoPayPal(String email) {
        this.email = email;
    }
    
    @Override
    public boolean processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via PayPal");
        System.out.println("Email: " + email);
        return Math.random() > 0.05;
    }
    
    @Override
    public String getTipo() {
        return "PAYPAL";
    }
}