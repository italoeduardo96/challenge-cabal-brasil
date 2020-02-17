
# CHALLENGE-MERCHANT-API

> Este projeto tem como objetivo disponibilizar uma interface grafica para o consumo de uma API RESST que cuida dos dados de merchant.

## Como é executado

>O projeto pode ser executado via linha de comando, entre na pasta raiz do projeto 'challenge-merchant-ui'
e siga os comandos abaixo:

1 - É necessário que se tenha o Node.js instalado na máquina.
Cheque as versões com os comandos abaixo.
```
node -v
v10.16.0

npm -v
6.9.0
```


2 - O projeto utiliza Angular CLI para inicializar e desenvolver o projeto,
caso não tenha instalado, execute os comandos abaixo para instalar:
```
npm install -g @angular/cli
```

2 - O projeto utiliza Angular CLI para inicializar e desenvolver o projeto,
caso não tenha instalado, execute os comandos abaixo para instalar:
```
npm install -g @angular/cli
```

3 - Atualize as dependências do npm:
```
npm install
```

4 - Entre no diretorio do projeto '/challenge-merchant-ui', e execute o comando:
```
ng serve
```

5 - Navegue para `http://localhost:4200/`


## Variaveis de ambiente

> Dentro do arquivo 'environments.ts' se encontra as variáveis de ambiente ncessárias.
> EM abiente de desenvolvimento se contra os valores abaixo:
```
  apiUrl: 'http://localhost:8080'
  apiWhitelisted: 'localhost:8080'
```
