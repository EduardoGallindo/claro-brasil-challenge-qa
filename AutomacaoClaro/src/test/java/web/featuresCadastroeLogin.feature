#language: pt
Funcionalidade: Realizar cadastro e efetuar login no site automationpractice

  Cenário de Fundo: 
    Dado que desejo efetuar o teste no navegador "Chrome" na máquina "local"

  @CT01
  Delineação do Cenário: Efetuar cadastro no site automationpractice
    Dado que desejo me cadastrar no site automationpractice
    Quando acessar o site
    Então devo preencher o <email> da minha nova conta e clicar no botão Create an account
    Quando for direcionado para a aba de dados da conta
    Então devo preencher meu <nome>, <sobrenome> e <data de nascimento>
    E escolher uma <senha>
    E preencher os dados de endereço
    E preencher o <celular>
    E clicar em Register
    E validar que a conta foi criada com sucesso

    Exemplos: 
      | email                                 | nome      | sobrenome  | data de nascimento | senha      | celular       |
      | "testeautomacaoclaro4@mailinator.com" | "Eduardo" | "Oliveira" | "03/05/1998"       | "senhA123" | "11996826338" |

  @CT02
  Delineação do Cenário: Tentar cadastrar novamente o mesmo e-mail no site automationpractice
    Dado que desejo me cadastrar no site automationpractice
    Mas o meu email já foi cadastrado anteriormente
    Quando acessar o site
    Então devo preencher o <email> da minha nova conta e clicar no botão Create an account
    E validar que foi apresentada mensagem de erro

    Exemplos: 
      | email                                |
      | "testeautomacaoclaro@mailinator.com" |

  @CT03
  Delineação do Cenário: Efetuar login no site automationpractice
    Dado que desejo acessar minha conta no site automationpractice
    Quando acessar o site
    Então devo preencher meu <email> e <senha>
    E validar que a conta foi acessada com sucesso

    Exemplos: 
      | email                                 | senha      |
      | "testeautomacaoclaro1@mailinator.com" | "senhA123" |
