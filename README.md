Cidades Inteligentes: Implementação DevOps com CI/CD
Descrição do Projeto

Este projeto visa automatizar o ciclo de vida de uma aplicação de monitoramento ambiental, aplicando práticas de DevOps e CI/CD para facilitar a integração, entrega contínua e escalabilidade. Usando ferramentas como GitHub Actions, Docker Compose e Azure Pipelines, a aplicação é desenvolvida, testada e implantada em ambientes de staging e produção de forma automatizada e consistente.
Alunos

    Iago Santarelli
    João Victor Gomes
    Washington
    Daniel Nunes Schwartz

Ferramentas Utilizadas

    GitHub: Controle de versão e integração com GitHub Actions.
    GitHub Actions: Automação de build, testes e deploy.
    Docker Compose: Orquestração de containers para desenvolvimento e produção.
    Azure Pipelines: Automação de CI/CD, incluindo integração com Azure App Services para staging e produção.

Requisitos de Sistema

Antes de iniciar, certifique-se de que você possui as seguintes ferramentas instaladas no seu sistema:

    Docker e Docker Compose
    Java 17 (OpenJDK)
    Maven
    Azure CLI
    Git
    WSL (Windows Subsystem for Linux) - Se estiver usando Windows

Configurações de Ambiente
Clonar o Repositório

Primeiro, clone o repositório do projeto:

bash

git clone https://github.com/gomes800/monitoramento_ambiental.git
cd monitoramento_ambiental

Variáveis de Ambiente

Certifique-se de configurar as seguintes variáveis de ambiente para que a aplicação funcione corretamente:

    AZURE_SUBSCRIPTION_ID: ID da assinatura do Azure usada para deploy.
    AZURE_RESOURCE_GROUP: Nome do grupo de recursos onde os recursos serão criados.
    APP_NAME: Nome do aplicativo no Azure.
    DOCKER_IMAGE_NAME: Nome da imagem Docker para construir e implantar.

Docker Compose

O projeto usa Docker Compose para orquestrar os serviços da aplicação. Certifique-se de que o docker-compose.yml está configurado corretamente.
Build e Execução Local
Compilando a Aplicação

Antes de executar a aplicação, compile o projeto com Maven:

bash

mvn clean install

Executando com Docker Compose

Para iniciar a aplicação localmente usando Docker Compose, execute:

bash

docker-compose up --build

A aplicação estará acessível em http://localhost:8080.