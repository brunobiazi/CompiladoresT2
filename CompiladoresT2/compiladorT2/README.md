# Trabalho 2 - Sintático

Grupo:

Bruno de Silveira Biaziolli - RA: 760318

Gabriel Pandolfi Correa dos Santos - RA: 769831

Leandro Keller Salto - RA: 791014

Nesse trabalho utilizamos a IDE Netbeans, mais especificamente versão 12.6, pode ser facilmente instalada a partir do 
link: https://www.apache.org/dyn/closer.cgi/netbeans/netbeans-installers/12.6/Apache-NetBeans-12.6-bin-windows-x64.exe 
para o sistema operacional Windows, o link: 
https://www.apache.org/dyn/closer.cgi/netbeans/netbeans-installers/12.6/Apache-NetBeans-12.6-bin-linux-x64.sh para Linux.
E para o sistema MAC utilizar o link: https://www.apache.org/dyn/closer.cgi/netbeans/netbeans-installers/12.6/Apache-NetBeans-12.6-bin-macosx.dmg
Dito isso, após o download, siga a intalação padrão, sem mudanças diretas na configuração, isso deve permitir que o programa seja compilado corretamente.
Também foi utilizado o Maven na versão 3.8.4, (o qual é instalado automaticamente junto ao netbeans), e o Antlr4, usado para criação de dicionários.
Mais informações sobre eles podem sem obtidas nos seguintes links: 
https://maven.apache.org/
https://www.antlr.org/

Para executar o código utilizar o comando:*** 

java -jar "C:\localização_do_arquivo_fonte\compiladorT2-1.0-SNAPSHOT-jar-with-dependencies.jar" "C:\localização_do_arquivo_de_entrada\entrada.txt" "C:\localização_do_arquivo_de_saida\saida.txt"


*** SE ATENTE A USAR OS DIRETÓRIOS DE SUA PRÓPRIA MÁQUINA, E OS NOMES DOS ARQUIVOS DE ENTRADA E SAÍDA DESEJADOS 
*** VERIFIQUE O <maven.compiler.source> E </maven.compiler.target> NO ARQUIVO POM DE SEU PROGRAMA, O ARQUIVO BASE CONSTA COMO 1.8***

E para compilar o código em um arquivo a parte, abra o projeto na IDE Netbeans, utilize a função de "Clean and Build" 
localizada no canto superior esquerdo. Se o arquivo fonte for modificado, se atente a erros e warnings, eles podem comprometer o funcionamento da aplicação.

Bom Proveito!
