<h1 align="center"> Solução Elétrica </h1>
<h4 align="center">Projeto destinado a ser o backend para uma solução de cálculo de dimensionamento de cabos, disjuntores e condutos</h4>
<p>
  <img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge" alt="Badge em Desenvolvimento">
</p>


:woman_technologist:
[Larissa Galvão Barcelos](https://github.com/LarissaGB01)


<h2> Indice </h2>

- [Contextualização do projeto](#contextualização-do-projeto)
- [Documentação Teórica](#documentação-teórica)
- [Rodando o projeto](#rodando-o-projeto)
- [Endpoints](#endpoints)
- [Configuração local](#configuração-local)
  - [Banco de Dados](#banco-de-dados)
  - [Swagger](#swagger)

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

## Endpoints

Para a conexao com o endpoint para calculo de dimensionamento dos elementos eletricos, 
basta acionar os endpoints disponibilizados. 

* [POST/dimensionar](docs/endpoints/postDimensionar.md)
* [POST/dimensionar/condutores](docs/endpoints/postDimensionarCondutores.md)
* [POST/dimensionar/disjuntores](docs/endpoints/postDimensionarDisjuntores.md)
* [POST/dimensionar/eletrodutos](docs/endpoints/postDimensionarEletrodutos.md)


## Configuração local

### Banco de Dados
Para que o projeto rode localmente é necessário a realização da configuração de um banco de dados. Atenção aos seguintes pontos:

* As tabelas são automaticamente criadas e populadas quando o projeto é iniciado. Basta que você possua um servidor do mysql rodando localmente.
* Configurações banco de dados: devem ser atualizadas [nesse arquivo](src/main/resources/application.properties)

### Swagger
Quando rodado localmente, fica disponível o [swagger](http://localhost:8080/swagger-ui.html) dessa aplicação para acesso aos endpoints fornecidos.