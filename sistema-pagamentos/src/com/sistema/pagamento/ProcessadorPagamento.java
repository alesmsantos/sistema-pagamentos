package com.sistema.pagamentos;

import java.util.ArrayList;
import java.util.List;

public class ProcessadorPagamento {
    private List<PagamentoObserver> observers = new ArrayList<>();
    private MetodoPagamento metodoPagamento;
    
    public ProcessadorPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    
    public void adicionarObserver(PagamentoObserver observer) {
        observers.add(observer);
    }
    
    public void removerObserver(PagamentoObserver observer) {
        observers.remove(observer);
    }
    
    private void notificarObservers(String mensagem) {
        for (PagamentoObserver observer : observers) {
            observer.atualizar(mensagem);
        }
    }
    
    public boolean executarPagamento(double valor) {
        notificarObservers("Iniciando processamento de pagamento via " + metodoPagamento.getTipo());
        
        boolean sucesso = metodoPagamento.processarPagamento(valor);
        
        if (sucesso) {
            notificarObservers("Pagamento de R$" + valor + " realizado com sucesso!");
        } else {
            notificarObservers("Falha no processamento do pagamento de R$" + valor);
        }
        
        return sucesso;
    }
}