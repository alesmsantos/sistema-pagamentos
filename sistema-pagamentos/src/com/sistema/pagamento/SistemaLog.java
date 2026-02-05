package com.sistema.pagamentos;

import java.util.Date;

public class SistemaLog implements PagamentoObserver {
    @Override
    public void atualizar(String mensagem) {
        System.out.println("[LOG] " + new Date() + " - " + mensagem);
    }
}