package com.sistema.pagamentos;

public class SistemaPagamento {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE PAGAMENTOS ===\n");
        
        // Usando Factory Method para criar métodos de pagamento
        System.out.println("1. Criando métodos de pagamento via Factory Method:");
        MetodoPagamento cartao = MetodoPagamentoFactory.criarCartaoCredito(
            "1234567812345678", "João Silva"
        );
        
        MetodoPagamento paypal = MetodoPagamentoFactory.criarPayPal(
            "joao.silva@email.com"
        );
        
        MetodoPagamento pix = MetodoPagamentoFactory.criarPix(
            "123.456.789-00"
        );
        
        // Criando processadores com diferentes estratégias
        ProcessadorPagamento processador1 = new ProcessadorPagamento(cartao);
        ProcessadorPagamento processador2 = new ProcessadorPagamento(paypal);
        ProcessadorPagamento processador3 = new ProcessadorPagamento(pix);
        
        // Adicionando observers (Observer Pattern)
        processador1.adicionarObserver(new EmailNotificacao("cliente@email.com"));
        processador1.adicionarObserver(new SistemaLog());
        processador1.adicionarObserver(new PainelAdmin());
        
        processador2.adicionarObserver(new SistemaLog());
        processador2.adicionarObserver(new PainelAdmin());
        
        processador3.adicionarObserver(new EmailNotificacao("cliente@email.com"));
        processador3.adicionarObserver(new SistemaLog());
        
        // Executando pagamentos (Strategy Pattern)
        System.out.println("\n2. Executando pagamentos:");
        
        System.out.println("\n--- Pagamento 1: Cartão de Crédito ---");
        boolean resultado1 = processador1.executarPagamento(150.50);
        System.out.println("Resultado: " + (resultado1 ? "SUCESSO" : "FALHA"));
        
        System.out.println("\n--- Pagamento 2: PayPal ---");
        boolean resultado2 = processador2.executarPagamento(75.30);
        System.out.println("Resultado: " + (resultado2 ? "SUCESSO" : "FALHA"));
        
        System.out.println("\n--- Pagamento 3: PIX ---");
        boolean resultado3 = processador3.executarPagamento(200.00);
        System.out.println("Resultado: " + (resultado3 ? "SUCESSO" : "FALHA"));
        
        // Demonstração de flexibilidade do Strategy Pattern
        System.out.println("\n3. Mudando estratégia em tempo de execução:");
        
        // Alterando o método de pagamento do processador1 para PIX
        processador1 = new ProcessadorPagamento(pix);
        processador1.adicionarObserver(new SistemaLog());
        
        System.out.println("\n--- Pagamento 4: Mesmo processador, nova estratégia (PIX) ---");
        boolean resultado4 = processador1.executarPagamento(99.90);
        System.out.println("Resultado: " + (resultado4 ? "SUCESSO" : "FALHA"));
        
        System.out.println("\n=== PROCESSAMENTO CONCLUÍDO ===");
    }
}