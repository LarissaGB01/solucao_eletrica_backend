# POST /dimensionar/condutores

Para o dimensionamento de condutores de um circuito elétrico residencial, 
basta acionar o endpoint '/dimensionar/condutores' com o metodo POST, informando o JSON com os dados de requisição.

## Indice
- [POST /dimensionar/condutores](#post-dimensionarcondutores)
  - [Indice](#indice)
  - [Requisicao](#requisicao)
    - [Campos](#campos)
    - [Exemplo](#exemplo)
  - [Resposta](#resposta)
    - [Campos](#campos-1)
    - [Exemplo](#exemplo-1)

## Requisicao

### Campos
| nome do campo                | obrigatorio | tipo    | unidade | valores aceitos                        |
|------------------------------|-------------|---------|---------|----------------------------------------|
| tipoCircuito                 | sim         | string  | -       | "DISTRIBUICAO" e "TERMINAL"            |
| utilizacaoCircuito           | sim         | string  | -       | "TOMADA" e "ILUMINACAO"                |
| fasesVoltagem                | sim         | string  | -       | "MONOFASICO", "BIFASICO" e "TRIFASICO" |
| voltagem                     | sim         | inteiro | V       | -                                      |
| metodoInstalacao             | sim         | string  | -       | "A1", "A2", "B1", "B2", "C" e "D"      |
| tipoCabo                     | sim         | string  | -       | "ALUMINIO", "EPR" e "PVC"              |
| potenciaAtiva                | não         | inteiro | W       | -                                      |
| potenciaAparente             | não         | inteiro | VA      | -                                      |
| fatorDePotencia              | não         | decimal | -       | Mínimo = 0<br>Máximo = 1               |
| temperaturaAmbiente          | sim         | inteiro | °C      | -                                      |
| quantidadeCircuitosAgrupados | sim         | inteiro | -       | -                                      |
| comprimentoFio               | sim         | inteiro | m       | -                                      |

### Exemplo
```JSON
{
	"tipoCircuito": "DISTRIBUICAO",
	"utilizacaoCircuito": "TOMADA",
	"fasesVoltagem": "TRIFASICO",
	"voltagem": 380,
	"metodoInstalacao": "A1",
	"tipoCabo": "ALUMINIO",
	"potenciaAtiva": 12000,
	"potenciaAparente": 0,
	"fatorDePotencia": 0.8,
	"temperaturaAmbiente": 50,
	"quantidadeCircuitosAgrupados": 2,
	"comprimentoFio": 60
}
```

## Resposta

### Campos
| nome do campo                                                                                   | tipo      | unidade | descrição                                                                                                                                         | fonte                                                                         |
|-------------------------------------------------------------------------------------------------|-----------|---------|---------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------|
| cabeamento<br/>.correnteMaximaCondutor                                                          | decimal   | A       | Valor definido como corrente máxima considerando a seção definida para o condutor.                                                                | NBR5410                                                                       |
| cabeamento<br/>.secaoNominalCondutor                                                            | decimal   | mm²     | Valor definido como seção nominal do condutor.                                                                                                    | NBR5410                                                                       |
| cabeamento<br/>.diametroExternoCaboRecomendado                                                  | decimal   | mm      | Condutor recomendado dada a seção nominal calculada.                                                                                              | Marca Sil                                                                     |
| cabeamento<br/>.diametroNominalCaboRecomendado                                                  | decimal   | mm      | Condutor recomendado dada a seção nominal calculada.                                                                                              | Marca Sil                                                                     |
| dadosUtilizadosParaCalculo                                                                      | agrupador | -       | Dados utilizados para a realização dos cálculos de dimensionamento.                                                                               | -                                                                             |
| dadosUtilizadosParaCalculo<br/>.calculoPotenciaAparente<br/>.indicadorPotenciaAparenteInformada | boolean   | -       | Indica caso a potência aparente foi informada ou deve ser calculada.                                                                              | requisição<br/>.potenciaAparente                                              |
| dadosUtilizadosParaCalculo<br/>.calculoPotenciaAparente<br/>.potenciaAtiva                      | decimal   | W       | Utilizada para cálculo da potência aparente caso indicadorPotenciaAparenteInformada for falso.                                                    | requisição<br/>.potenciaAtiva                                                 |
| dadosUtilizadosParaCalculo<br/>.calculoPotenciaAparente<br/>.fatorDePotencia                    | decimal   | -       | Utilizado para cálculo da potência aparente caso indicadorPotenciaAparenteInformada for falso.                                                    | requisição<br/>.fatorDePotencia                                               |
| dadosUtilizadosParaCalculo<br/>.calculoPotenciaAparente<br/>.potenciaAparente                   | decimal   | VA      | Valor final para potência aparente do circuito.                                                                                                   | -                                                                             |
| dadosUtilizadosParaCalculo<br/>.calculoCorrenteProjeto<br/>.indicadorCircuitoTrifasico          | boolean   | -       | Indica caso as fases voltagem informadas se referem a um circuito trifásico. Isso gera ajustes na equação de cálculo da corrente de circuito.     | requisição<br/>.fasesVoltagem                                                 |
| dadosUtilizadosParaCalculo<br/>.calculoCorrenteProjeto<br/>.potenciaAparente                    | decimal   | VA      | Utilizada para cálculo da corrente do circuito.                                                                                                   | dadosUtilizadosParaCalculo<br/>.calculoPotenciaAparente<br/>.potenciaAparente |
| dadosUtilizadosParaCalculo<br/>.calculoCorrenteProjeto<br/>.voltagem                            | inteiro   | V       | Utilizado para cálculo da corrente do circuito.                                                                                                   | requisição<br/>.voltagem                                                      |
| dadosUtilizadosParaCalculo<br/>.calculoCorrenteProjeto<br/>.correnteCircuito                    | decimal   | A       | Valor final para corrente do circuito. Utilizada para cálculo da corrente de projeto.                                                             | -                                                                             |
| dadosUtilizadosParaCalculo<br/>.calculoCorrenteProjeto<br/>.quantidadeCircuitosAgrupados        | inteiro   | -       | Utilizado para cálculo do fator de agrupamento.                                                                                                   | requisição<br/>.quantidadeCircuitosAgrupados                                  |
| dadosUtilizadosParaCalculo<br/>.calculoCorrenteProjeto<br/>.fatorAgrupamento                    | decimal   | -       | Valor final para fator de agrupamento do circuito. Utilizado para cálculo da corrente de projeto.                                                 | -                                                                             |
| dadosUtilizadosParaCalculo<br/>.calculoCorrenteProjeto<br/>.temperaturaAmbiente                 | inteiro   | °C      | Utilizado para obtenção do fator de temperatura.                                                                                                  | requisição<br/>.temperaturaAmbiente                                           |
| dadosUtilizadosParaCalculo<br/>.calculoCorrenteProjeto<br/>.isolacaoCabo                        | string    | -       | Utilizado para obtenção do fator de temperatura.                                                                                                  | requisição<br/>.tipoCabo                                                      |
| dadosUtilizadosParaCalculo<br/>.calculoCorrenteProjeto<br/>.fatorTemperatura                    | decimal   | -       | Valor final para fator de temperatura do circuito. Utilizado para cálculo da corrente de projeto.                                                 | NBR5410                                                                       |
| dadosUtilizadosParaCalculo<br/>.calculoCorrenteProjeto<br/>.correnteProjeto                     | decimal   | A       | Valor final para corrente de projeto do circuito.                                                                                                 | -                                                                             |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.tipoCabo                         | string    | -       | Utilizado para obtenção da resistividade do cabo.                                                                                                 | requisição<br/>.tipoCabo                                                      |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.resistividadeCabo                | decimal   | Ω·mm²/m | Valor final para resistividade do cabo. Utilizada para cálculo da seção mínima do condutor.                                                       | -                                                                             |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.tipoCircuito                     | string    | -       | Utilizado para obtenção do valor de variação da tensão.                                                                                           | requisição<br/>.tipoCircuito                                                  |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.valorVariacaoTensao              | inteiro   | %       | Valor final para valor de variação da tensão. Utilizada para cálculo da seção mínima do condutor.                                                 | -                                                                             |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.indicadorCircuitoTrifasico       | boolean   | -       | Indica caso as fases voltagem informadas se referem a um circuito trifásico. Isso gera ajustes na equação de cálculo da seção mínima do condutor. | requisição<br/>.fasesVoltagem                                                 |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.comprimentoFio                   | inteiro   | m       | Utilizada para cálculo da seção mínima do condutor.                                                                                               | requisição<br/>.comprimentoFio                                                |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.voltagem                         | inteiro   | V       | Utilizada para cálculo da seção mínima do condutor.                                                                                               | requisição<br/>.voltagem                                                      |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.correnteProjeto                  | decimal   | A       | Utilizada para cálculo da seção mínima do condutor.                                                                                               | dadosUtilizadosParaCalculo<br/>.calculoCorrenteProjeto<br/>.correnteProjeto   |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.diametroCalculado                | decimal   | mm²     | Seção mínima do condutor calculada.                                                                                                               | -                                                                             |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.utilizacaoCircuito               | string    | -       | Utilizado para obtenção do valor do diametro mínimo aceito para o circuito.                                                                       | requisição<br/>.utilizacaoCircuito                                            |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.minimoDiametroCabo               | decimal   | mm²     | Valor final para diametro mínimo aceito para o circuito.                                                                                          | -                                                                             |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.indicadorMinimoDiametroUtilizado | boolean   | -       | Indica caso o diâmetro mínimo aceito é menor do que o diâmetro calculado para o cabo. Isso define qual o valor da seção recomendada.              | -                                                                             |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.fasesVoltagem                    | string    | -       | Utilizado para obtenção da quantidade de cabos carregados.                                                                                        | requisição<br/>.fasesVoltagem                                                 |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.cabosCarregados                  | inteiro   | -       | Valor final para quantidade de cabos carregados. Utilizado para obtenção da seção mínima do cabo.                                                 | -                                                                             |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.metodoInstalacao                 | string    | -       | Utilizado para obtenção da seção mínima do cabo.                                                                                                  | requisição<br/>.metodoInstalacao                                              |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.materialCabo                     | string    | -       | Utilizado para obtenção da seção mínima do cabo.                                                                                                  | requisição<br/>.tipoCabo                                                      |
| dadosUtilizadosParaCalculo<br/>.calculoDiametroMinimoCabo<br/>.isolamentoCabo                   | string    | -       | Utilizado para obtenção da seção mínima do cabo.                                                                                                  | requisição<br/>.tipoCabo                                                      |

### Exemplo
```JSON
{
  "cabeamento": {
    "correnteMaximaCondutor": 57.0,
    "secaoNominalCondutor": 25.0,
    "diametroExternoCaboRecomendado": 19.90,
    "diametroNominalCaboRecomendado": 6.50
  },
  "dadosUtilizadosParaCalculo": {
    "calculoPotenciaAparente": {
      "indicadorPotenciaAparenteInformada": false,
      "potenciaAtiva": 12000,
      "fatorDePotencia": 0.8,
      "potenciaAparente": 15000
    },
    "calculoCorrenteProjeto": {
      "indicadorCircuitoTrifasico": true,
      "potenciaAparente": 15000,
      "voltagem": 380,
      "correnteCircuito": 23,
      "quantidadeCircuitosAgrupados": 2,
      "fatorAgrupamento": 0.7071067811865475,
      "temperaturaAmbiente": 50,
      "isolacaoCabo": "PVC",
      "fatorTemperatura": 0.71,
      "correnteProjeto": 45
    },
    "calculoDiametroMinimoCabo": {
      "tipoCabo": "ALUMINIO",
      "resistividadeCabo": 0.02857,
      "tipoCircuito": "DISTRIBUICAO",
      "indicadorCircuitoTrifasico": true,
      "comprimentoFio": 60,
      "correnteProjeto": 45,
      "valorVariacaoTensao": 2,
      "voltagem": 380,
      "diametroCalculado": 17.5800877954020550435,
      "utilizacaoCircuito": "TOMADA",
      "minimoDiametroCabo": 2.5,
      "indicadorMinimoDiametroUtilizado": false,
      "fasesVoltagem": "TRIFASICO",
      "cabosCarregados": 3,
      "metodoInstalacao": "A1",
      "materialCabo": "ALUMINIO",
      "isolamentoCabo": "PVC"
    }
  }
}
```