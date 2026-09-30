# Shopify Inventory Rebuild

Estou recriando do zero o [shopify-inventory-challenge](https://github.com/BrunoBergamin/shopify-inventory-challenge) (o projeto original pronto) para aprender Java, Spring Boot, JPA e SQL. **Nunca faça push deste código no repositório original.**

- Guia passo a passo: https://claude.ai/artifact/FpR3sCowoRQ3cUkBScCMnT. Leia com as ferramentas de Docs, não com web fetch.
- A aba **"Onde parei e próximos passos"** do guia tem o status, as correções ao guia e o passo a passo da etapa atual.

## Como me ajudar

- Eu escrevo o código à mão. Não edite meus arquivos em `src/` a menos que eu peça.
- Responda em português.
- Explique a próxima etapa em passos pequenos e numerados. Escreva primeiro o que os outros usam, para os erros vermelhos sumirem um de cada vez.
- Para cada decisão, explique o porquê: qual é o problema, quais eram as opções e por que esta foi escolhida.
- Quando eu pedir revisão, leia o arquivo, rode os testes e aponte erro por erro, com a linha.
- Os blocos de código do guia são trechos. Quando estiverem incompletos, avise e passe a versão completa.
- No fim de cada sessão, atualize a seção "Onde parei" abaixo e a aba do guia.

## Onde parei

- Prontos: Etapa 2 (configuração), Etapa 3 (Flyway V1 e V2), Etapa 4 Parte 1 (exceções + `InventoryItem`).
- Próximo: **Etapa 4 Parte 2**: `ShipmentStatus`, `ShipmentItem`, `Shipment`. O código completo e testado está na aba do guia.
- Depois: Etapa 5 (testes do domínio).

## Comandos (Windows)

- Testes: `.\mvnw.cmd test | Select-String "BUILD|Tests run:|migration|Schema-validation|ERROR"`
- Texto vermelho sobre Mockito ou Java agent no PowerShell não é erro. O que vale é `BUILD SUCCESS` ou `BUILD FAILURE`.

## Fatos do projeto

- Os testes usam H2 em memória. `src/test/resources/application.properties` substitui o de `main` inteiro.
- O app usa Postgres em `localhost:5432`, com usuário, senha e banco `inventory`. É preciso criar com `CREATE USER` e `CREATE DATABASE`.
- `ddl-auto=validate`: quem cria as tabelas é o Flyway, e o Hibernate só confere.
- Depois que uma migration rodar no Postgres, ela não pode mais ser editada. Mudança nova vira a próxima versão.
- Na Etapa 10 (Docker), a porta 5432 pode conflitar com um Postgres instalado localmente.
