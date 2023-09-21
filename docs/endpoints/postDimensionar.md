# POST /dimensionar

Para o dimensionamento de condutores, eletrodutos e disjuntores de um circuito elétrico residencial, 
basta acionar o endpoint '/dimensionar' com o metodo POST, informando o JSON com os dados de requisição.

## Indice
- [POST /dimensionar](#post-dimensionar)
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
| nome do campo                                                                                                             | tipo      | unidade | descrição                                                                                                                                         | fonte                                                                                                   |
|---------------------------------------------------------------------------------------------------------------------------|-----------|---------|---------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| dadosDimensionados                                                                                                        | agrupador | -       | Dados de resposta após a realização dos cálculos                                                                                                  | -                                                                                                       |
| dadosDimensionados<br/>.cabeamento<br/>.correnteMaximaCondutor                                                            | decimal   | A       | Valor definido como corrente máxima considerando a seção definida para o condutor.                                                                | NBR5410                                                                                                 |
| dadosDimensionados<br/>.cabeamento<br/>.secaoNominalCondutor                                                              | decimal   | mm²     | Valor definido como seção nominal do condutor.                                                                                                    | NBR5410                                                                                                 |
| dadosDimensionados<br/>.cabeamento<br/>.diametroExternoCaboRecomendado                                                    | decimal   | mm      | Condutor recomendado dada a seção nominal calculada.                                                                                              | Marca Sil                                                                                               |
| dadosDimensionados<br/>.cabeamento<br/>.diametroNominalCaboRecomendado                                                    | decimal   | mm      | Condutor recomendado dada a seção nominal calculada.                                                                                              | Marca Sil                                                                                               |
| dadosDimensionados<br/>.disjuntor<br/>.correnteNominalDisjuntorRecomendado                                                | inteiro   | A       | Disjuntor recomendado dadas as correntes de projeto e do condutor.                                                                                | Marca Siemens                                                                                           |
| dadosDimensionados<br/>.disjuntor<br/>.nomeDisjuntorRecomendado                                                           | string    | -       | Disjuntor recomendado dadas as correntes de projeto e do condutor.                                                                                | Marca Siemens                                                                                           |
| dadosDimensionados<br/>.eletroduto<br/>.diametroNominalEletrodutoSugeridoPolegadas                                        | string    | "       | Eletroduto recomendado dado o diâmetro interno ocupado pelo cabeamento.                                                                           | Marca Canaflex                                                                                          |
| dadosDimensionados<br/>.eletroduto<br/>.diametroNominalEletrodutoSugeridoMilimetros                                       | inteiro   | mm      | Eletroduto recomendado dado o diâmetro interno ocupado pelo cabeamento.                                                                           | Marca Canaflex                                                                                          |
| dadosDimensionados<br/>.eletroduto<br/>.diametroExternoEletrodutoSugerido                                                 | decimal   | mm      | Eletroduto recomendado dado o diâmetro interno ocupado pelo cabeamento.                                                                           | Marca Canaflex                                                                                          |
| dadosDimensionados<br/>.eletroduto<br/>.diametroInternoEletrodutoSugerido                                                 | decimal   | mm      | Eletroduto recomendado dado o diâmetro interno ocupado pelo cabeamento.                                                                           | Marca Canaflex                                                                                          |
| dadosUtilizadosParaCalculo                                                                                                | agrupador | -       | Dados utilizados para a realização dos cálculos de dimensionamento.                                                                               | -                                                                                                       |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoPotenciaAparente<br/>.indicadorPotenciaAparenteInformada | boolean   | -       | Indica caso a potência aparente foi informada ou deve ser calculada.                                                                              | requisição<br/>.potenciaAparente                                                                        |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoPotenciaAparente<br/>.potenciaAtiva                      | decimal   | W       | Utilizada para cálculo da potência aparente caso indicadorPotenciaAparenteInformada for falso.                                                    | requisição<br/>.potenciaAtiva                                                                           |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoPotenciaAparente<br/>.fatorDePotencia                    | decimal   | -       | Utilizado para cálculo da potência aparente caso indicadorPotenciaAparenteInformada for falso.                                                    | requisição<br/>.fatorDePotencia                                                                         |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoPotenciaAparente<br/>.potenciaAparente                   | decimal   | VA      | Valor final para potência aparente do circuito.                                                                                                   | -                                                                                                       |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoCorrenteProjeto<br/>.indicadorCircuitoTrifasico          | boolean   | -       | Indica caso as fases voltagem informadas se referem a um circuito trifásico. Isso gera ajustes na equação de cálculo da corrente de circuito.     | requisição<br/>.fasesVoltagem                                                                           |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoCorrenteProjeto<br/>.potenciaAparente                    | decimal   | VA      | Utilizada para cálculo da corrente do circuito.                                                                                                   | dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoPotenciaAparente<br/>.potenciaAparente |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoCorrenteProjeto<br/>.voltagem                            | inteiro   | V       | Utilizado para cálculo da corrente do circuito.                                                                                                   | requisição<br/>.voltagem                                                                                |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoCorrenteProjeto<br/>.correnteCircuito                    | decimal   | A       | Valor final para corrente do circuito. Utilizada para cálculo da corrente de projeto.                                                             | -                                                                                                       |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoCorrenteProjeto<br/>.quantidadeCircuitosAgrupados        | inteiro   | -       | Utilizado para cálculo do fator de agrupamento.                                                                                                   | requisição<br/>.quantidadeCircuitosAgrupados                                                            |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoCorrenteProjeto<br/>.fatorAgrupamento                    | decimal   | -       | Valor final para fator de agrupamento do circuito. Utilizado para cálculo da corrente de projeto.                                                 | -                                                                                                       |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoCorrenteProjeto<br/>.temperaturaAmbiente                 | inteiro   | °C      | Utilizado para obtenção do fator de temperatura.                                                                                                  | requisição<br/>.temperaturaAmbiente                                                                     |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoCorrenteProjeto<br/>.isolacaoCabo                        | string    | -       | Utilizado para obtenção do fator de temperatura.                                                                                                  | requisição<br/>.tipoCabo                                                                                |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoCorrenteProjeto<br/>.fatorTemperatura                    | decimal   | -       | Valor final para fator de temperatura do circuito. Utilizado para cálculo da corrente de projeto.                                                 | NBR5410                                                                                                 |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoCorrenteProjeto<br/>.correnteProjeto                     | decimal   | A       | Valor final para corrente de projeto do circuito.                                                                                                 | -                                                                                                       |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.tipoCabo                         | string    | -       | Utilizado para obtenção da resistividade do cabo.                                                                                                 | requisição<br/>.tipoCabo                                                                                |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.resistividadeCabo                | decimal   | Ω·mm²/m | Valor final para resistividade do cabo. Utilizada para cálculo da seção mínima do condutor.                                                       | -                                                                                                       |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.tipoCircuito                     | string    | -       | Utilizado para obtenção do valor de variação da tensão.                                                                                           | requisição<br/>.tipoCircuito                                                                            |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.valorVariacaoTensao              | inteiro   | %       | Valor final para valor de variação da tensão. Utilizada para cálculo da seção mínima do condutor.                                                 | -                                                                                                       |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.indicadorCircuitoTrifasico       | boolean   | -       | Indica caso as fases voltagem informadas se referem a um circuito trifásico. Isso gera ajustes na equação de cálculo da seção mínima do condutor. | requisição<br/>.fasesVoltagem                                                                           |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.comprimentoFio                   | inteiro   | m       | Utilizada para cálculo da seção mínima do condutor.                                                                                               | requisição<br/>.comprimentoFio                                                                          |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.voltagem                         | inteiro   | V       | Utilizada para cálculo da seção mínima do condutor.                                                                                               | requisição<br/>.voltagem                                                                                |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.correnteProjeto                  | decimal   | A       | Utilizada para cálculo da seção mínima do condutor.                                                                                               | dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoCorrenteProjeto<br/>.correnteProjeto   |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.diametroCalculado                | decimal   | mm²     | Seção mínima do condutor calculada.                                                                                                               | -                                                                                                       |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.utilizacaoCircuito               | string    | -       | Utilizado para obtenção do valor do diametro mínimo aceito para o circuito.                                                                       | requisição<br/>.utilizacaoCircuito                                                                      |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.minimoDiametroCabo               | decimal   | mm²     | Valor final para diametro mínimo aceito para o circuito.                                                                                          | -                                                                                                       |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.indicadorMinimoDiametroUtilizado | boolean   | -       | Indica caso o diâmetro mínimo aceito é menor do que o diâmetro calculado para o cabo. Isso define qual o valor da seção recomendada.              | -                                                                                                       |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.fasesVoltagem                    | string    | -       | Utilizado para obtenção da quantidade de cabos carregados.                                                                                        | requisição<br/>.fasesVoltagem                                                                           |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.cabosCarregados                  | inteiro   | -       | Valor final para quantidade de cabos carregados. Utilizado para obtenção da seção mínima do cabo.                                                 | -                                                                                                       |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.metodoInstalacao                 | string    | -       | Utilizado para obtenção da seção mínima do cabo.                                                                                                  | requisição<br/>.metodoInstalacao                                                                        |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.materialCabo                     | string    | -       | Utilizado para obtenção da seção mínima do cabo.                                                                                                  | requisição<br/>.tipoCabo                                                                                |
| dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoDiametroMinimoCabo<br/>.isolamentoCabo                   | string    | -       | Utilizado para obtenção da seção mínima do cabo.                                                                                                  | requisição<br/>.tipoCabo                                                                                |
| dadosUtilizadosParaCalculo<br/>.calculoDisjuntor<br/>.fasesVoltagem                                                       | string    | -       | Utilizado para obtenção da quantidade de cabos carregados.                                                                                        | requisição<br/>.fasesVoltagem                                                                           |
| dadosUtilizadosParaCalculo<br/>.calculoDisjuntor<br/>.cabosCarregados                                                     | inteiro   | -       | Valor final para quantidade de cabos carregados. Utilizado para obtenção do disjuntor recomendado.                                                | -                                                                                                       |
| dadosUtilizadosParaCalculo<br/>.calculoDisjuntor<br/>.correnteProjeto                                                     | decimal   | A       | Utilizado para obtenção do disjuntor recomendado.                                                                                                 | dadosUtilizadosParaCalculo<br/>.calculoSecaoCondutor<br/>.calculoCorrenteProjeto<br/>.correnteProjeto   |
| dadosUtilizadosParaCalculo<br/>.calculoDisjuntor<br/>.correnteMaximaCabo                                                  | decimal   | A       | Utilizado para obtenção do disjuntor recomendado.                                                                                                 | dadosDimensionados<br/>.cabeamento<br/>.correnteMaximaCondutor                                          |
| dadosUtilizadosParaCalculo<br/>.calculoEletroduto<br/>.secaoNominalCabo                                                   | decimal   | mm²     | Utilizado para obtenção do diâmetro do condutor.                                                                                                  | dadosDimensionados<br/>.cabeamento<br/>.secaoNominalCondutor                                            |
| dadosUtilizadosParaCalculo<br/>.calculoEletroduto<br/>.diametroCabo                                                       | decimal   | mm      | Valor final para diâmetro do condutor. Utilizado para para cálculo do diâmetro mínimo aceito para o eletroduto.                                   | -                                                                                                       |
| dadosUtilizadosParaCalculo<br/>.calculoEletroduto<br/>.quantidadeCondutores                                               | inteiro   | -       | Utilizado para para cálculo do diâmetro mínimo aceito para o eletroduto.                                                                          | requisição<br/>.quantidadeCircuitosAgrupados                                                            |
| dadosUtilizadosParaCalculo<br/>.calculoEletroduto<br/>.diametroMinimoCalculado                                            | decimal   | mm      | Diâmetro mínimo aceito para o eletroduto. Utilizado para obtenção do eletroduto recomendado.                                                      | requisição<br/>.quantidadeCircuitosAgrupados                                                            |

### Exemplo
```JSON
{
	"dadosDimensionados": {
		"cabeamento": {
			"correnteMaximaCondutor": 57.0,
			"secaoNominalCondutor": 25.0,
			"diametroExternoCaboRecomendado": 19.90,
			"diametroNominalCaboRecomendado": 6.50
		},
		"disjuntor": {
			"correnteNominalDisjuntorRecomendado": 50,
			"nomeDisjuntorRecomendado": "5SL1 350-7MB"
		},
		"eletroduto": {
			"diametroNominalEletrodutoSugeridoPolegadas": "1.1/4\"",
			"diametroNominalEletrodutoSugeridoMilimetros": 30,
			"diametroExternoEletrodutoSugerido": 41.30,
			"diametroInternoEletrodutoSugerido": 31.50
		}
	},
	"dadosUtilizadosParaCalculo": {
		"calculoSecaoCondutor": {
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
		},
		"calculoDisjuntor": {
			"fasesVoltagem": "TRIFASICO",
			"cabosCarregados": 3,
			"correnteProjeto": 45,
			"correnteMaximaCabo": 57.0
		},
		"calculoEletroduto": {
			"secaoNominalCabo": 25.0,
			"diametroCabo": 5.639148871948674,
			"quantidadeCondutores": 2,
			"diametroMinimoCalculado": 28.195744359743365
		}
	}
}
```