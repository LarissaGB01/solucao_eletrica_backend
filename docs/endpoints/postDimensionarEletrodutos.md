# POST /dimensionar/eletrodutos

Para o dimensionamento de eletrodutos de um circuito elétrico residencial, 
basta acionar o endpoint '/dimensionar/eletrodutos' com o metodo POST, informando o JSON com os dados de requisição.

## Indice
- [POST /dimensionar/eletrodutos](#post-dimensionareletrodutos)
  - [Indice](#indice)
  - [Requisicao](#requisicao)
    - [Campos](#campos)
    - [Exemplo](#exemplo)
  - [Resposta](#resposta)
    - [Campos](#campos-1)
    - [Exemplo](#exemplo-1)

## Requisicao

### Campos
| nome do campo        | obrigatorio | tipo    | unidade | valores aceitos |
|----------------------|-------------|---------|---------|-----------------|
| quantidadeCondutores | sim         | inteiro | -       | -               |
| secaoNominalCabo     | sim         | decimal | mm²     | -               |

### Exemplo
```JSON
{
  "secaoNominalCabo": 25.0,
  "quantidadeCondutores": 2
}
```

## Resposta

### Campos
| nome do campo                                               | tipo      | unidade | descrição                                                                                                       | fonte                                |
|-------------------------------------------------------------|-----------|---------|-----------------------------------------------------------------------------------------------------------------|--------------------------------------|
| eletroduto<br/>.diametroNominalEletrodutoSugeridoPolegadas  | string    | "       | Eletroduto recomendado dado o diâmetro interno ocupado pelo cabeamento.                                         | Marca Canaflex                       |
| eletroduto<br/>.diametroNominalEletrodutoSugeridoMilimetros | inteiro   | mm      | Eletroduto recomendado dado o diâmetro interno ocupado pelo cabeamento.                                         | Marca Canaflex                       |
| eletroduto<br/>.diametroExternoEletrodutoSugerido           | decimal   | mm      | Eletroduto recomendado dado o diâmetro interno ocupado pelo cabeamento.                                         | Marca Canaflex                       |
| eletroduto<br/>.diametroInternoEletrodutoSugerido           | decimal   | mm      | Eletroduto recomendado dado o diâmetro interno ocupado pelo cabeamento.                                         | Marca Canaflex                       |
| dadosUtilizadosParaCalculo                                  | agrupador | -       | Dados utilizados para a realização dos cálculos de dimensionamento.                                             | -                                    |
| dadosUtilizadosParaCalculo<br/>.secaoNominalCabo            | decimal   | mm²     | Utilizado para obtenção do diâmetro do condutor.                                                                | requisição<br/>.secaoNominalCabo     |
| dadosUtilizadosParaCalculo<br/>.diametroCabo                | decimal   | mm      | Valor final para diâmetro do condutor. Utilizado para para cálculo do diâmetro mínimo aceito para o eletroduto. | -                                    |
| dadosUtilizadosParaCalculo<br/>.quantidadeCondutores        | inteiro   | -       | Utilizado para para cálculo do diâmetro mínimo aceito para o eletroduto.                                        | requisição<br/>.quantidadeCondutores |
| dadosUtilizadosParaCalculo<br/>.diametroMinimoCalculado     | decimal   | mm      | Diâmetro mínimo aceito para o eletroduto. Utilizado para obtenção do eletroduto recomendado.                    | requisição<br/>.quantidadeCondutores |

### Exemplo
```JSON
{
  "eletroduto": {
    "diametroNominalEletrodutoSugeridoPolegadas": "1.1/4\"",
    "diametroNominalEletrodutoSugeridoMilimetros": 30,
    "diametroExternoEletrodutoSugerido": 41.30,
    "diametroInternoEletrodutoSugerido": 31.50
  },
  "dadosUtilizadosParaCalculo": {
    "secaoNominalCabo": 25.0,
    "diametroCabo": 5.639148871948674,
    "quantidadeCondutores": 2,
    "diametroMinimoCalculado": 28.195744359743365
  }
}
```