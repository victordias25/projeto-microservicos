# <h1 align="center"> Trabalho Final - 43SCJ - MICROSERVICES DEVELOPMENT  </h1>

# Objetivo do projeto

Desenvolvimento de uma solução para Cadeia Produtiva do Setor Automobilístico utilizando Microsserviços e Apache Kafka. 

# Solucção

Desenvolvido APIs do Fornecedor, Centro de Distribuição e Concessionárias. Cada um com seus microserviços. Aonde o Fornecedor efetua vendas consignadas de veículos para as Concessionárias (Producer). E as ao efetuarem a venda desse veículo para um Cliente Final será enviada uma  mensagem para um tópico especifico do Kafka que o Fornecedor/ Fabricante do Veículo (Consumer) é quem se conecta ao Kafka e consome essa mensagem do tópico. Essa mensagem é o chassi do Veículo. Atavés do Chassi do Veículo que foi efetuado uma venda para um cliente Final por parte da Concessionaria, o Fornecedor efetua o faturamento desse Veículo para a Concessionárias. 

# Serviços síncronos
CRUDS Veículos e Clientes
Pedido de Venda
Pedido de Devolução

# Serviços assíncronos 

Apache Kafka para faturamento dos veículos para as Concessionárias.


> :construction: Projeto Concluído
