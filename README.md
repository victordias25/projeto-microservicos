# <h1 align="center"> Trabalho Final - 43SCJ - MICROSERVICES DEVELOPMENT  </h1>

# Objetivo do projeto

Desenvolvimento de uma solução para Cadeia Produtiva do Setor Automobilístico utilizando Microsserviços e Apache Kafka. 

# Solução

Desenvolvido APIs do Fornecedor, Centro de Distribuição e Concessionárias. Cada um com seus microserviços. Aonde o Fornecedor efetua vendas consignadas de veículos para as Concessionárias (Producer). E as ao efetuarem a venda desse veículo para um Cliente Final será enviada uma  mensagem para um tópico especifico do Kafka que o Fornecedor/ Fabricante do Veículo (Consumer) é quem se conecta ao Kafka e consome essa mensagem do tópico. Essa mensagem é o chassi do Veículo. Atavés do Chassi do Veículo que foi efetuado uma venda para um Cliente Final por parte da Concessionaria, o Fornecedor efetua o faturamento desse Veículo para a Concessionárias. 

> :construction: Projeto Concluído

# Serviços síncronos
CRUDS Veículos e Clientes
Pedido de Venda
Pedido de Devolução

# Serviços assíncronos 

Apache Kafka para faturamento dos veículos para as Concessionárias.

# Diagrama de Microserviços

<img src="https://github.com/victordias25/projeto-microservicos/blob/main/Imagens/diagrama-microservicos.png">

# Fluxo das APIs/ Microserviços

<img src="https://github.com/victordias25/projeto-microservicos/blob/main/Imagens/fluxo-microservicos.png">

## 🔨 COMO EXECUTAR O PROJETO

## ✔️ Docker (usando Windows)
 - `` Como o Docker instalado na sua máquina e com ele executando. Usando um terminal de sua preferência dentro da Pasta Docker do projeto execute o seguinte 
      comando: docker-compose -f docker-compose.yml up -d.``
      
 - `` Com o comando acima será criado e iniciado os contêineres.``
 
 - `` Será criado uma imagem do wso2, postgres, zookeeper/ kafka.``

## ✔️ Postgre
- `` Dentro arquivo .YML do Docker foi criado uma imagem do Postgree. O mesmo você poderá concectar usando o DBEAVER com as credenciais:`` 
    
- ``     POSTGRES_DB: postgres``
- ``     POSTGRES_USER: postgres``
 - ``    POSTGRES_PASSWORD: postgres``
 
 ## ✔️ Rotas
   - ``Todas as rotas para executar via Postman encontram-se na raiz do repositório no arquivo: “APIs - Fornecedor e Concessionaria.postman_collection.json”``
   
  ## ✔️ Abaixo o projeto sendo executado conforme as rotas acima
  
  <img src="https://github.com/victordias25/projeto-microservicos/blob/main/Imagens/1.png">
