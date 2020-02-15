## Desenvolvendo um microservice:

Para desenvolver um microservice nos padrões da arquitetura, o projeto deve atender os seguintes requisitos:

### Idioma

Inglês. Tudo em Inglês.

### pom.xml
 
O pom do microservice:

* O *parent* deve ser a última versão estável do **super-pom-microservice**.
* O *groupId* deve ser composto pelo prefixo "br.com.sippe" + *business* + *modulo*.
* O *artifact* deve ser o nome do projeto.
* A tag **scm** deve conter URL com protocolo SSH e não HTTP.
* As bibliotecas necessárias a construção de um microservice são herdadas do super pom, com isso não é necessária a inclusão de biliotecas externas, a menos que a inclusão seja uma necessidade e que a equipe de arquitetura tenha avaliado.
* Descomente a dependência do driver da Oracle para poder fazer conexão com o banco de dados.
* A tag **name** deve ter o artifactId do microservice.

### Arquivos de Configuração

Os arquivos de configurações do código principal ficam em **src/main/resources** e dos testes unitários ficam em **src/test/resources**.

* Em src/main/resources devem ter:

    * Os arquivos de mensagem na pasta **i18n**.
    * Os arquivos *application.properties* e *bootstrap.properties*.

### Entidades

Entidades são representações de objetos do mundo real. Em hibernate, elas são representações das tabelas do banco de dados.

Para desenvolvê-las, deve-se:

* Colocá-las na pasta **model**.
* Colocar o sufixo Entity em todas.
* Estender a classe **SippeEntity**.

O mapeamendo das entidades pode ser feito de duas formas, com ```@IdClass``` ou ```@EmbeddedId```. A diferença é que na primeira anotação, todoas atributos da entidade ficam na mesma classe, incluindo os id's.

Para mais esclarecimentos, veja a [implementação](https://www.objectdb.com/java/jpa/entity/id) das duas anotações. Ou olhe o mapeamento da entidade **CommerceEntity** no projeto **sippe-issuer-microservice-commerce**.

### DTO

*Data Transfer Object*, ou DTO, são objetos espelhos das entidades e são utilizados nas requisições. Eles devem estender a classe **SippeDto**.

Estão no pacote **api.dto**

Há dois tipos:
1. ResponseDto: objeto que é respondido por uma requisição.
2. RequestDto: objeto que enviado no corpo da requisição.

### Mapper

Necessária para transforma uma Entidade em Dto ou vice-versa com poucas linhas de código. Todo **microservice** que possui Entidades e Dto's devem ter uma classe Mapper.

Regras:
* A classe Mapper deve estender de **SippeMapper**.
* O nome é: *microservice name* + Mapper.
* Deve ficar dentro do pacote **mapper**.
* Pode utilizar o mapstruct ou o orika. 

Todos os **microservices** implementados possuem essa classe. Como exemplo, tem-se **CommerceMapper** no projeto **sippe-issuer-microservice-commerce**.

### Controller

Classe que recebe as requisições e possuem os método de uma API REST. 

No Framework, existe uma classe **SippeAbstractCrudDtoApiController** que implementa todos os métodos REST para uma entidade.Se não for preciso utilzar os métodos já implementados por ela, use **SippeAbstractApiController** e implemente os seus métodos REST.
OBS: Para mais de uma entidade no projeto, a classe **SippeAbstractCrudDtoApiController** só pode ser usada em uma classe API.

Regras:
* A classes controladores devem estar no pacote **api.controller**.
* Seu nome *microservice name* + Dto + ApiController.
* Deve estender uma classe da Controller. 

### Repository

É a **interface** resposável por gerenciar as transações com o banco de dados, em que possui as assinaturas dos métodos do Hibernate.

Microservices que não fazem conexão com o banco de dados não precisam dessa classe, como exemplo *gateways*.

Regras:

* Devem estar no pacote **repository** e implementar a interface **SippeCrudRepository**.
* Podem conter assinaturas de métodos que tenha uma Query específica, exemplo: [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation).

### Service

É a camada reponsável por implementar as regras de negócio. É ela quem faz todas as operações sobre os dados antes de persistir ou buscar. Nem todo **microservice** deve implementar essa camada, pois os controladores que estendem **SippeAbstractCrudDtoApiController** já ganham um **Service** genérico da Arquiteruta.

Como exemplo, o projeto **sippe-issuer-microservice-branch** implementa essa camada.

Regras (Se for implementar):

* Os services devem estar dentro do pacote service.
* O nome: *microservice name* + Service

### Microservices que acessam mais de um banco de dados

O projeto **sippe-issuer-microservice-branch** implementa esse caso.

### Testes Unitários

Cada **microservice** deve ter no mínimo **80%** de cobertura de código.

Todos **microservices** desse projeto possuem testes unitários e cobertura acima de 90%. Utilize-os como exemplo.

### Dockerfile

Todo microservice deve ter, em:

    - microservice
        - main
            - docker
                Dockerfile

### Regras Genérias

* O **microservice** deve possuir o arquivo Jenkinsfile, .gitignore e CHANGELOG.md na raiz do porjeto.

* Toda classe, interface ou enum deve possui o comentário:

``` 
    /*
    * CABAL BRASIL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
    * Copyright (c) 2018, Cabal Brasil and/or its affiliates. All rights reserved.
    */
```

* INDENTAÇÃO: dois espaços.

* O projeto deve compilar sem erros e, se possível, sem *warnings*.

