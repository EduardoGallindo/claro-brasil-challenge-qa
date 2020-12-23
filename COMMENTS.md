A arquitetura utilizada para elaboração do projeto segue o padrão de projeto Maven, sendo separada basicamente em uma parte Main, que contém a lógica programada para o projeto e os recursos necessários para a execução, e uma parte Test, que contém as funcionalidades, cenários de teste e classes para execução.

Foi utilizado o Desenvolvimento Orientado a Comportamento (BDD) com o Cucumber e Gherkin para descrição e elaboração dos casos de teste, com as dependências cucumber-java e cucumber-junit.

Para a interação com as plataformas Web e Mobile, foram incorporadas as dependências do Appium e do Selenium para a linguagem Java. Utilizamos o JUnit na programação dos métodos e validações executados ao longo dos testes e para a elaboração das classes Runner, responsáveis pela execução das features do projeto.

Por fim, o plugin Maven Surefire foi acrescentado ao projeto para o gerenciamento e execução de testes em paralelo e o BrowserStack foi incorporado como meio para a execução de testes em drivers remotos.

Essa arquitetura foi escolhida com base nos frameworks mais difundidos e versáteis para a elaboração de projetos de testes, permitindo a leitura e manutenção do projeto de forma simples e intuitiva, bem como facilitando a busca de soluções para problemas encontrados ao longo do ciclo de vida do projeto.

Um ponto de melhoria interessante seria a inclusão de testes Cross-Browser, validando os cenários de testes em diversos navegadores diferentes de forma simultânea. 

Outro ponto importante para atualizações futuras do projeto é a inclusão de métodos para geração de evidências de teste, permitindo um maior controle e rastreabilidade das execuções.

Não foi possível entregar os testes para a plataforma Mobile IOS devido a limitações dos recursos utilizados no desenvolvimento. Os emuladores para dispositivos IOS são exclusivos para o sistema operacional MAC e a máquina utilizada não possui capacidade de processamento e memória para a execução em máquina virtual.
