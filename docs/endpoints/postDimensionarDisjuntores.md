# POST /dimensionar/disjuntores

Para o dimensionamento de disjuntores de um circuito elétrico residencial, 
basta acionar o endpoint '/dimensionar/disjuntores' com o metodo POST, informando o JSON com os dados de requisição.

## Indice
- [POST /dimensionar/disjuntores](#post-dimensionardisjuntores)
  - [Indice](#indice)
  - [Requisicao](#requisicao)
    - [Campos](#campos)
    - [Exemplo](#exemplo)
  - [Resposta](#resposta)
    - [Campos](#campos-1)
    - [Exemplo](#exemplo-1)

## Requisicao

### Campos
| nome do campo      | obrigatorio | tipo    | unidade | valores aceitos                        |
|--------------------|-------------|---------|---------|----------------------------------------|
| fasesVoltagem      | sim         | string  | -       | "MONOFASICO", "BIFASICO" e "TRIFASICO" |
| correnteMaximaCabo | sim         | decimal | A       | -                                      |
| correnteProjeto    | sim         | decimal | A       | -                                      |

### Exemplo
```JSON
{
  "fasesVoltagem": "TRIFASICO",
  "correnteMaximaCabo": 63.0,
  "correnteProjeto": 45
}
```

## Resposta

### Campos
| nome do campo                                      | tipo      | unidade | descrição                                                                                          | fonte                              |
|----------------------------------------------------|-----------|---------|----------------------------------------------------------------------------------------------------|------------------------------------|
| disjuntor<br/>.correnteNominalDisjuntorRecomendado | inteiro   | A       | Disjuntor recomendado dadas as correntes de projeto e do condutor.                                 | Marca Siemens                      |
| disjuntor<br/>.nomeDisjuntorRecomendado            | string    | -       | Disjuntor recomendado dadas as correntes de projeto e do condutor.                                 | Marca Siemens                      |
| dadosUtilizadosParaCalculo                         | agrupador | -       | Dados utilizados para a realização dos cálculos de dimensionamento.                                | -                                  |
| dadosUtilizadosParaCalculo<br/>.fasesVoltagem      | string    | -       | Utilizado para obtenção da quantidade de cabos carregados.                                         | requisição<br/>.fasesVoltagem      |
| dadosUtilizadosParaCalculo<br/>.cabosCarregados    | inteiro   | -       | Valor final para quantidade de cabos carregados. Utilizado para obtenção do disjuntor recomendado. | -                                  |
| dadosUtilizadosParaCalculo<br/>.correnteProjeto    | decimal   | A       | Utilizado para obtenção do disjuntor recomendado.                                                  | requisição<br/>.correnteProjeto    |
| dadosUtilizadosParaCalculo<br/>.correnteMaximaCabo | decimal   | A       | Utilizado para obtenção do disjuntor recomendado.                                                  | requisição<br/>.correnteMaximaCabo |

### Exemplo
```JSON
{
  "disjuntor": {
    "correnteNominalDisjuntorRecomendado": 50,
    "nomeDisjuntorRecomendado": "5SL1 350-7MB"
  },
  "dadosUtilizadosParaCalculo": {
    "fasesVoltagem": "TRIFASICO",
    "cabosCarregados": 3,
    "correnteProjeto": 45,
    "correnteMaximaCabo": 63.0
  }
}
```