# solucao_eletrica_backend

## Para rodar o projeto
O projeto foi construido utilizando maven e spring-boot, logo para rodar o projeto utilize o comando:
```
mvn clean spring-boot:run
```
O swagger da aplicacao esta disponivel nesse [link](http://localhost:8080/swagger-ui.html), quando o projeto e rodado localmente

## Endpoints
Para a conexao com o endpoint para calculo de dimensionamento dos elementos eletricos, 
deve-se chamar o endpoint '/dimensionar' com o metodo POST, utilizado o JSON com os dados:

### Requisicao

#### Chamada
| nome do campo                | obrigatorio | tipo    | descricao                                                                                              |
|------------------------------|-------------|---------|--------------------------------------------------------------------------------------------------------|
| tipoCircuito                 | sim         | string  | tipo do circuito em questao. Valores aceitos sao "DISTRIBUICAO" e "TERMINAL"                           |
| utilizacaoCircuito           | sim         | string  | forma de utilizacao do circuito em questao. Valores aceitos sao "TOMADA" e "ILUMINACAO"                |
| fasesVoltagem                | sim         | string  | quantidade de fases do circuito em questao. Valores aceitos sao "MONOFASICO", "BIFASICO" e "TRIFASICO" |
| voltagem                     | sim         | inteiro | valor da voltagem no sistema                                                                           |
| metodoInstalacao             | sim         | string  | metodo de instalacao dos cabos. Valores aceitos sao "A1", "A2", "B1", "B2", "C" e "D"                  |
| tipoCabo                     | sim         | string  | material do cabo utilizado no projeto. Valores aceitos sao "ALUMINIO", "EPR" e "PVC"                   |
| potenciaAtiva                | nao         | inteiro | valor da potencia ativa do sistema                                                                     |
| potenciaAparente             | nao         | inteiro | valor da potencia aparente do sistema                                                                  |
| fatorDePotencia              | nao         | decimal | valor do fator de potencia do sistema                                                                  |
| temperaturaAmbiente          | sim         | inteiro | valor da temperatura ambiente do local da instalacao                                                   |
| quantidadeCircuitosAgrupados | sim         | inteiro | quantidade de circuitos agrupados na instalacao                                                        |
| comprimentoFio               | sim         | inteiro | valor do comprimento do fio que sera utilizado                                                         |

### Exemplo:
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