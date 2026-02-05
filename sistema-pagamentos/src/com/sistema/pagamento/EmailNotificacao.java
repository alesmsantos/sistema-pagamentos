package com.sistema.pagamentos;

public class EmailNotificacao implements PagamentoObserver {
    private String email;
    
    public EmailNotificacao(String email) {
        this.email = email;
    }
    
    @Override
    public void atualizar(String mensagem) {
        System.out.println("Enviando email para " + email + ": " + mensagem);
    }
}