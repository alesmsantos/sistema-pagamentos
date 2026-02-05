📊 Sistema de Processamento de Pagamentos com Padrões de Projeto

Um sistema educativo que demonstra a aplicação prática de três padrões de projeto GoF (Gang of Four) em um contexto realista de processamento de pagamentos.

🎯 Objetivo do Projeto
Este projeto foi desenvolvido para ilustrar como os padrões de projeto podem ser aplicados de forma prática e conjunta para resolver problemas comuns de design de software, criando um sistema flexível, extensível e de fácil manutenção.

🏗️ Padrões de Projeto Implementados
1. Strategy Pattern 🎯
Problema resolvido: Variações no comportamento de algoritmos de pagamento.

Implementação: Interface MetodoPagamento com múltiplas implementações:

PagamentoCartaoCredito

PagamentoPayPal

PagamentoPix

Benefícios:

Troca dinâmica de algoritmos em tempo de execução

Baixo acoplamento entre cliente e algoritmos

Fácil adição de novos métodos de pagamento

2. Factory Method Pattern 🏭
Problema resolvido: Criação complexa de objetos relacionados.

Implementação: Classe MetodoPagamentoFactory com métodos estáticos para criação de diferentes tipos de pagamento.

Benefícios:

Encapsula a lógica de criação

Facilita manutenção e testes

Permite extensão sem modificar código cliente

3. Observer Pattern 👁️
Problema resolvido: Notificação automática a múltiplos componentes sobre eventos do sistema.

Implementação:

Interface PagamentoObserver

Subject: ProcessadorPagamento

Observers concretos: EmailNotificacao, SistemaLog, PainelAdmin

Benefícios:

Acoplamento fraco entre componentes

Sistema de eventos flexível

Fácil adição/remoção de observadores

📁 Estrutura do Projeto

sistema-pagamentos/
├── src/
│   └── com/
│       └── sistema/
│           └── pagamentos/
│               ├── MetodoPagamento.java          # Interface Strategy
│               ├── PagamentoCartaoCredito.java   # Strategy Concreto 1
│               ├── PagamentoPayPal.java          # Strategy Concreto 2
│               ├── PagamentoPix.java             # Strategy Concreto 3
│               ├── MetodoPagamentoFactory.java   # Factory Method
│               ├── PagamentoObserver.java        # Interface Observer
│               ├── ProcessadorPagamento.java     # Subject
│               ├── EmailNotificacao.java         # Observer Concreto 1
│               ├── SistemaLog.java               # Observer Concreto 2
│               ├── PainelAdmin.java              # Observer Concreto 3
│               └── SistemaPagamento.java         # Classe Principal
├── .vscode/
│   └── settings.json                            # Configurações VSCODE
├── README.md                                    # Este arquivo
└── bin/                                         # Arquivos compilados (gerado)

- Como Executar
Pré-requisitos
Java JDK 11 ou superior

VSCODE (recomendado) ou outra IDE

Extensão Java para VSCODE (recomendado)

Passo a Passo:

1 - Clone ou baixe o projeto:

git clone https://github.com/alesmsantos/sistema-pagamentos.git
cd sistema-pagamentos

2 - Abra no VSCODE:
code .

3 - Compile o projeto:

Abra o terminal no VSCODE (Ctrl+`)

Execute: javac -d bin src/com/sistema/pagamentos/*.java

4 - Execute o programa:

java -cp bin com.sistema.pagamentos.SistemaPagamento

Execução Simplificada no VSCODE:
Abra o arquivo SistemaPagamento.java

Clique no botão "▶️ Run" no canto superior direito

Ou pressione F5 para debug

📊 Saída do Programa
Ao executar, você verá uma demonstração completa:

=== SISTEMA DE PAGAMENTOS ===

1. Criando métodos de pagamento via Factory Method:

2. Executando pagamentos:

--- Pagamento 1: Cartão de Crédito ---
Processando pagamento de R$150.5 via Cartão de Crédito
Cartão: ****5678
Enviando email para cliente@email.com: Iniciando processamento de pagamento via CARTÃO_CRÉDITO
[LOG] Mon Feb 05 10:00:00 BRT 2024 - Iniciando processamento de pagamento via CARTÃO_CRÉDITO
[PAINEL ADMIN] Nova atividade: Iniciando processamento de pagamento via CARTÃO_CRÉDITO
...
Resultado: SUCESSO


🔧 Extensão do Projeto
Adicionar Novo Método de Pagamento
Implemente a interface MetodoPagamento

Adicione na MetodoPagamentoFactory

Pronto! O sistema já suporta o novo método.

Exemplo: public class PagamentoBoleto implements MetodoPagamento {
    // Implementação...
}

Adicionar Novo Observer: public class NotificacaoSMS implements PagamentoObserver {
    // Implementação...
}

📈 Diagrama UML:

┌─────────────────────┐
│   <<interface>>     │
│   MetodoPagamento   │◄─────┐
├─────────────────────┤      │
│ + processar()       │      │
│ + getTipo()         │      │
└─────────────────────┘      │
                             │
┌─────────────────────┐      │      ┌─────────────────────┐
│  Factory Method     │──────┼─────►│   <<interface>>     │
├─────────────────────┤      │      │   PagamentoObserver │
│ + criar()           │      │      ├─────────────────────┤
└─────────────────────┘      │      │ + atualizar()       │
                             │      └─────────────────────┘
      ▲                     │               ▲
      │                     │               │
┌─────┴─────┐       ┌───────┴───────┐   ┌───┴────┐
│ Strategy  │       │   Subject     │   │Observer│
│ Concretos │       │ (Processador) │   │Concretos│
└───────────┘       └───────────────┘   └────────┘


🧪 Casos de Uso
1. Sistemas de E-commerce
Múltiplos métodos de pagamento

Notificações por email/SMS

Log de transações

2. Aplicações Financeiras
Processamento de transações

Auditoria e logs

Painéis administrativos

3. Sistemas de Assinatura
Pagamentos recorrentes

Notificações de renovação

Múltiplos gateways de pagamento

🎓 Aprendizados
Boas Práticas Demonstradas:
Princípio Open/Closed: Aberto para extensão, fechado para modificação

Inversão de Dependência: Dependa de abstrações, não de implementações

Separação de Responsabilidades: Cada classe tem uma única responsabilidade

Baixo Acoplamento: Componentes independentes e intercambiáveis

🔍 Análise de Complexidade
Aspecto	Com Padrões	Sem Padrões
Adicionar novo pagamento	1 classe + 1 linha na Factory	Modificar múltiplas classes
Adicionar nova notificação	1 classe	Modificar lógica de processamento
Manutenção	Baixa	Alta
Testabilidade	Alta	Baixa


📚 Referências
Design Patterns: Elements of Reusable Object-Oriented Software (GoF Book)

Head First Design Patterns (O'Reilly)

Refactoring Guru: https://refactoring.guru/design-patterns

👥 Contribuição
Faça um Fork do projeto

Crie uma branch para sua feature (git checkout -b feature/nova-feature)

Commit suas mudanças (git commit -m 'Add nova feature')

Push para a branch (git push origin feature/nova-feature)

Abra um Pull Request

📄 Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para detalhes.

✨ Autor: Alessandra Santos (https://www.linkedin.com/in/alessandrasantoss/)
Desenvolvido como parte do desafio de Padrões de Projeto da DIO (Digital Innovation One).

⭐ Se este projeto te ajudou, considere dar uma estrela no repositório!

"Padrões de projeto não são receitas prontas, mas sim soluções testadas para problemas recorrentes de design."
