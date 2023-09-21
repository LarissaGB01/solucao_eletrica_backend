# solucao_eletrica_backend

## Indice
- [solucao_eletrica_backend](#solucaoeletricabackend)
  - [Indice](#indice)
  - [Contextualização do projeto](#contextualização-do-projeto)
  - [Documentação Teórica](#documentação-teórica)
  - [Rodando o projeto](#rodando-o-projeto)
  - [Endpoints](#endpoints)

## Contextualização do projeto

Trabalho de Conclusão de Curso (TCC) apresentado como um dos requisitos para a conclusão do curso de Engenharia Elétrica do UniCEUB – Centro Universitário de Brasília.

**DESENVOLVIMENTO DE APLICATIVO PARA DIMENSIONAMENTO DE CABOS, DISJUNTOR E ELETRODUTO VERSÃO ANDROID**

Orientador (a): Luciano Henrique Duque

Desenvolvedor (a): Larissa Galvão Barcelos

Maiores informações sobre o contexto do trabalho e o objetivo do mesmo estão disponíveis [aqui](docs/introducaoTCC.md).
<p align="center">Brasília, 2023</p>

## Documentação Teórica

A lógica útilizada para a realização dos cálculos presentes nessa aplicação e um exemplo de utilização dos mesmos foram documentados [nesse pdf](docs/passo_a_passo.pdf), disponível para consulta.

É importante mencionar que o dimensionamento de condutores é feito com base no cálculo da seção mínima do condutor. Todos os cálculos são baseados na norma NRB5410 e nas teorias sobre o assunto de dimensionamento publicadas até o dia 21/09/2023.

## Rodando o projeto

O projeto foi construido utilizando maven e spring-boot, logo para rodar o projeto utilize o comando:
```
mvn clean spring-boot:run
```

Quando rodado localmente, fica disponível o [swagger](http://localhost:8080/swagger-ui.html) dessa aplicação para acesso aos endpoints fornecidos.

## Endpoints

Para a conexao com o endpoint para calculo de dimensionamento dos elementos eletricos, 
basta acionar os endpoints disponibilizados. 

* [POST/dimensionar](docs/endpoints/postDimensionar.md)
* [POST/dimensionar/condutores](docs/endpoints/postDimensionarCondutores.md)
* [POST/dimensionar/disjuntores](docs/endpoints/postDimensionarDisjuntores.md)
* [POST/dimensionar/eletrodutos](docs/endpoints/postDimensionarEletrodutos.md)