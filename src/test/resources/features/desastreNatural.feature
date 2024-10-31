Feature: Desastre Natural
  Como usuário
  Quero gerenciar desastres naturais
  Para que eu possa registrar, consultar e atualizar informações de desastres

  # Criação de desastre
  Scenario: Criar um novo desastre com informações válidas
    Given que eu tenho um desastre com tipo "Inundação", localização "São Paulo", severidade "Alta" e data e hora "2024-10-31T10:00:00Z"
    When eu envio uma requisição para criar esse desastre
    Then o sistema deve retornar uma resposta com status 200
    And o sistema deve registrar o desastre com essas informações

  Scenario: Tentar criar um desastre com dados inválidos
    Given que eu tenho um desastre sem tipo e sem severidade
    When eu envio uma requisição para criar esse desastre
    Then o sistema deve retornar uma resposta com status 400
    And o sistema deve exibir uma mensagem de erro informando os campos obrigatórios

  # Consulta de desastre por ID
  Scenario: Consultar um desastre com ID existente
    Given que existe um desastre com ID 1
    When eu envio uma requisição para buscar o desastre com ID 1
    Then o sistema deve retornar uma resposta com status 200
    And as informações do desastre devem ser retornadas

  Scenario: Consultar um desastre com ID inexistente
    Given que não existe um desastre com ID 999
    When eu envio uma requisição para buscar o desastre com ID 999
    Then o sistema deve retornar uma resposta com status 404
    And o sistema deve exibir uma mensagem informando que o desastre não foi encontrado

  # Atualização de desastre
  Scenario: Atualizar um desastre com informações válidas
    Given que existe um desastre com ID 1 com tipo "Incêndio" e severidade "Média"
    When eu envio uma requisição para atualizar o tipo para "Inundação" e a severidade para "Alta" para o desastre com ID 1
    Then o sistema deve retornar uma resposta com status 200
    And o sistema deve atualizar o desastre com as novas informações

  Scenario: Tentar atualizar um desastre inexistente
    Given que não existe um desastre com ID 999
    When eu envio uma requisição para atualizar o desastre com ID 999
    Then o sistema deve retornar uma resposta com status 404
    And o sistema deve exibir uma mensagem informando que o desastre não foi encontrado
