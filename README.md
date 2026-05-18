# APOIO Platform - Backend API

> **APOIO** (Avaliação Pós-Ocupação Integrada Orientada ao Urbanismo) é uma plataforma de auditoria cidadã para projetos urbanos. O sistema permite que cidadãos e técnicos avaliem o desempenho de espaços públicos (praças, parques, calçadões) em uso, cruzando dados de percepção humana com planejamento urbano.

Este repositório abriga a **API REST** do ecossistema, desenvolvida com foco em alta coesão, baixo acoplamento e arquitetura escalável.

---

## Tecnologias e Ferramentas

O ecossistema foi desenhado utilizando o padrão de mercado para aplicações corporativas e microsserviços:

* **Java 17** - Linguagem robusta com recursos modernos.
* **Spring Boot 3.x** - Framework base para a construção da API REST.
* **Spring Data JPA** - Abstração de persistência de dados.
* **PostgreSQL** - Banco de dados relacional para armazenamento seguro e robusto.
* **Docker & Docker Compose** - Containerização do ambiente de banco de dados.
* **Git & GitHub** - Controle de versão utilizando fluxo de ramificação profissional.

---

## Arquitetura e Boas Práticas

O projeto foi estruturado seguindo o padrão **Package by Layer (Organização por Camada)**, garantindo uma separação clara de responsabilidades:

* **Controllers:** Exposição dos endpoints REST e manipulação de respostas HTTP.
* **Services:** Camada de negócio isolada, contendo as regras e validações do ecossistema.
* **Repositories:** Roteamento de consultas e persistência com o banco através do Spring Data.
* **DTOs (Data Transfer Objects):** Uso de **Java Records** para a entrada e saída de dados, blindando as entidades do banco e impedindo vazamento de dados sensíveis (ex: senhas).

### Diferenciais Técnicos Implementados:
* **Injeção de Dependência via Construtor:** Garantia de imutabilidade dos componentes e facilitação de testes unitários.
* **Auditoria Automática (Spring Auditing):** Centralização de logs de criação e modificação (`createdAt` e `updatedAt`) através de herança com `@MappedSuperclass` (`Auditable`).
* **Relacionamentos Complexos:** Modelagem de banco de dados mapeando entidades ligadas de forma performática (`@ManyToOne`).

---

## Modelo de Dados (Domínios)

O sistema gerencia três pilares fundamentais, pensados sob medida para os conceitos de Arquitetura e Urbanismo:

1.  **User (Usuário):** Cidadãos ou técnicos auditores do espaço.
2.  **Urban Project (Projeto Urbano):** Espaços e intervenções urbanas categorizadas (Praças, Parques, etc.).
3.  **Evaluation (Avaliação Pós-Ocupação):** Diagnóstico multifatorial focado no desempenho real do projeto:
    * *Comfort Score* (Conforto térmico/espacial)
    * *Security Score* (Percepção de segurança)
    * *Lightning Score* (Qualidade da iluminação pública)
    * *Accessibility Score* (Acessibilidade universal)
    * *Furniture Score* (Estado do mobiliário urbano)

---

## Como Executar o Projeto Localmente

### Pré-requisitos
* Java 17 instalado.
* Maven instalado (ou uso do `./mvnw`).
* Docker / Docker Compose instalado e rodando.

### 1. Clonar o repositório
```
git clone [https://github.com/seu-usuario/apoio-platform.git](https://github.com/seu-usuario/apoio-platform.git)
```
### 2. Subir o banco de dados
```
docker compose up -d
```
3. Executar a Aplicação Spring Boot
```
./mvnw spring-boot:run
```
A API estará disponível em http://localhost:8080.

---

## Testando a API

As requisições podem ser validadas utilizando clientes HTTP como **Postman** ou **Insomnia**.

### Usuários (Users)
* `POST /users` - Cadastro de novo usuário
* `GET /users` - Listagem global de usuários
* `GET /users/{id}` - Busca de um usuário específico por ID
* `PUT /users/{id}` - Atualização dos dados do usuário
* `DELETE /users/{id}` - Remoção de um usuário do sistema

### Projetos Urbanos (Urban Projects)
* `POST /urban-projects` - Cadastro de novo projeto urbano
* `GET /urban-projects` - Listagem global de projetos urbanos
* `GET /urban-projects/{id}` - Busca de um projeto específico por ID
* `PUT /urban-projects/{id}` - Atualização dos dados de um projeto
* `DELETE /urban-projects/{id}` - Remoção de um projeto do sistema

### Avaliações (Evaluations)
* `POST /evaluations` - Envio de uma avaliação
* `GET /evaluations` - Listagem global de avaliações realizadas
* `GET /evaluations/{id}` - Busca de uma avaliação específica por ID
* `PUT /evaluations/{id}` - Atualização das notas ou comentários de uma avaliação
* `DELETE /evaluations/{id}` - Remoção de uma avaliação existente

> **Documentação Completa da API:** Com a aplicação rodando localmente, você pode acessar a interface interativa do **Swagger UI** em: `http://localhost:8080/swagger-ui.html` para testar os endpoints diretamente pelo navegador.
---

## Padrão de Commits

Para manter o histórico do repositório limpo e legível, este projeto adota o padrão **Conventional Commits**:

* `feat(...)`: Adição de novas funcionalidades.
* `refactor(...)`: Alterações de código que melhorem a legibilidade ou estrutura, sem mudar o comportamento.
* `chore(...)`: Atualizações de build, configuração do projeto ou dependências do Maven.
