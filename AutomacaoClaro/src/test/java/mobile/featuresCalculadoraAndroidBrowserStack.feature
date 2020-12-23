#language: pt
Funcionalidade: Validar operações matemáticas básicas do aplicativo apk-android-calculator do android

  Cenário de Fundo: 
    Dado que possuo um dispositivo "Android" e desejo efetuar um teste "BrowserStack"
    E que desejo efetuar uma operação matemática com os valores "8" e "2"

  @CT01
  Cenário: Efetuar uma soma de dois valores na calculadora
    Quando acessar o aplicativo da calculadora
    Então devo somar os dois valores
    E validar que o resultado da soma está correto

  @CT02
  Cenário: Efetuar uma subtração de dois valores na calculadora
    Quando acessar o aplicativo da calculadora
    Então devo subtrair os dois valores
    E validar que o resultado da subtração está correto

  @CT03
  Cenário: Efetuar uma multiplicação de dois valores na calculadora
    Quando acessar o aplicativo da calculadora
    Então devo multiplicar os dois valores
    E validar que o resultado da multiplicação está correto

  @CT04
  Cenário: Efetuar uma divisão de dois valores na calculadora
    Quando acessar o aplicativo da calculadora
    Então devo dividir os dois valores
    E validar que o resultado da divisão está correto
