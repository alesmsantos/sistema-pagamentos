package com.sistema.pagamentos;

public interface MetodoPagamento {
    boolean processarPagamento(double valor);
    String getTipo();
}