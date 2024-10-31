Feature: Gerenciamento de Desastres Naturais
  Como usuário
  Quero gerenciar dados de desastres naturais
  Para que eu possa registrar, consultar e atualizar informações

  Scenario: Criar um novo registro de desastre natural com informações válidas
    Given que eu tenho um registro com tipo "Inundação", localização "Centro", severidade "Alta" e data e hora "2024-10-31T10:00:00Z"
    When eu envio uma requisição para criar esse registro
    Then o sistema deve retornar uma resposta com status 200
    And o sistema deve registrar o registro com essas informações

  Scenario: Tentar criar um registro de desastre natural com dados inválidos
    Given que eu tenho um registro sem tipo
    When eu envio uma requisição para criar esse registro
    Then o sistema deve retornar uma resposta com status 400
    And o sistema deve exibir uma mensagem de erro informando os campos obrigatórios

  Scenario: Consultar um registro de desastre natural por ID existente
    Given que existe um registro de desastre natural com ID 1
    When eu envio uma requisição para buscar o registro com ID 1
    Then o sistema deve retornar uma resposta com status 200
    And as informações do registro devem ser retornadas

  Scenario: Atualizar um registro de desastre natural com informações válidas
    Given que existe um registro de desastre natural com ID 1
    When eu envio uma requisição para atualizar o registro com ID 1
    Then o sistema deve retornar uma resposta com status 200
    And o sistema deve atualizar o registro com as novas informações
