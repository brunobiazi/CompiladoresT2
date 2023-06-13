
package br.ufscar.dc.compiladores.compiladorT2;

/**
 *
 * @author jeanf
*/
import br.ufscar.dc.compiladores.compiladorT2.AlgumaLexer;
import br.ufscar.dc.compiladores.compiladorT2.AlgumaParser;
import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;


public class Principal
{
    public static void main(String[] args) throws RuntimeException, FileNotFoundException, IOException 
    {       
        // Verifica se a foi passado para a função o número correto de parâmetros.
        // Em caso de falha, é apresentado um erro na tela e encerra o programa.
         if (args.length < 2) {
            System.out.println("Falha na execução.\nNúmero de parâmetros inválidos.");
            System.exit(0);
        }
         
        // Faz a leitura do arquivo e cria o analisador léxico e sintático do programa.
        AlgumaLexer entrada = new AlgumaLexer(CharStreams.fromFileName(args[0]));
        AlgumaParser parser = new AlgumaParser(new CommonTokenStream(entrada));

        parser.removeErrorListeners();
        parser.addErrorListener(TrataErro.INSTANCE);
        
        // Verifica se é possível abrir o arquivo
        try (PrintWriter saida = new PrintWriter(args[1])) {

            try {
                parser.programa();
            }
            // Printa as mensagens de erro no arquivo saida.
            catch (ParseCancellationException mensagem_erro) {
                saida.println(mensagem_erro.getMessage());
                saida.close();
        } 
        // Se não for possível abrir o arquivo, apresenta uma mensagem de erro na tela.
        } catch (IOException exception) {
            System.out.println("Falha na execução.\nO programa não conseguiu abrir o arquivo: " + args[1]+ ".");
           }   
        
     
    }
}