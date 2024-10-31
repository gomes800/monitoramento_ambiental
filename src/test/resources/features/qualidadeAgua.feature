Feature: Qualidade da Água
  Como usuário
  Quero gerenciar dados de qualidade da água
  Para que eu possa registrar, consultar e atualizar informações

  Scenario: Criar um novo registro de qualidade da água com informações válidas
    Given que eu tenho um registro com localização "Lagoa Rodrigo de Freitas", nível de poluição "Baixo" e data e hora "2024-10-31T10:00:00Z"
    When eu envio uma requisição para criar esse registro
    Then o sistema deve retornar uma resposta com status 200
    And o sistema deve registrar o registro com essas informações

  Scenario: Tentar criar um registro de qualidade da água com dados inválidos
    Given que eu tenho um registro sem localização
    When eu envio uma requisição para criar esse registro
    Then o sistema deve retornar uma resposta com status 400
    And o sistema deve exibir uma mensagem de erro informando os campos obrigatórios

  Scenario: Consultar um registro de qualidade da água por ID existente
    Given que existe um registro de qualidade da água com ID 1
    When eu envio uma requisição para buscar o registro com ID 1
    Then o sistema deve retornar uma resposta com status 200
    And as informações do registro devem ser retornadas

  Scenario: Consultar um registro de qualidade da água por ID inexistente
    Given que não existe um registro com ID 999
    When eu envio uma requisição para buscar o registro com ID 999
    Then o sistema deve retornar uma resposta com status 404
    And o sistema deve exibir uma mensagem informando que o registro não foi encontrado

  Scenario: Atualizar um registro de qualidade da água com informações válidas
    Given que existe um registro de qualidade da água com ID 1
    When eu envio uma requisição para atualizar o registro com ID 1
    Then o sistema deve retornar uma resposta com status 200
    And o sistema deve atualizar o registro com as novas informações
