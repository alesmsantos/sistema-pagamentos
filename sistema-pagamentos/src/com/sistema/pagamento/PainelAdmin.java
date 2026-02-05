package com.sistema.pagamentos;

public class PainelAdmin implements PagamentoObserver {
    @Override
    public void atualizar(String mensagem) {
        System.out.println("[PAINEL ADMIN] Nova atividade: " + mensagem);
    }
}