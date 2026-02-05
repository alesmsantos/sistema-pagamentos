package com.sistema.pagamentos;

import java.util.HashMap;
import java.util.Map;

public class MetodoPagamentoFactory {
    
    public static MetodoPagamento criarMetodoPagamento(String tipo, Map<String, String> dados) {
        return switch (tipo.toUpperCase()) {
            case "CARTAO_CREDITO", "CARTAO", "CREDITO" -> 
                new PagamentoCartaoCredito(
                    dados.get("numeroCartao"), 
                    dados.get("nomeTitular")
                );
            
            case "PAYPAL" -> 
                new PagamentoPayPal(dados.get("email"));
            
            case "PIX" -> 
                new PagamentoPix(dados.get("chavePix"));
            
            default -> throw new IllegalArgumentException("Método de pagamento não suportado: " + tipo);
        };
    }
    
    public static MetodoPagamento criarCartaoCredito(String numero, String titular) {
        Map<String, String> dados = new HashMap<>();
        dados.put("numeroCartao", numero);
        dados.put("nomeTitular", titular);
        return criarMetodoPagamento("CARTAO_CREDITO", dados);
    }
    
    public static MetodoPagamento criarPayPal(String email) {
        Map<String, String> dados = new HashMap<>();
        dados.put("email", email);
        return criarMetodoPagamento("PAYPAL", dados);
    }
    
    public static MetodoPagamento criarPix(String chave) {
        Map<String, String> dados = new HashMap<>();
        dados.put("chavePix", chave);
        return criarMetodoPagamento("PIX", dados);
    }
}