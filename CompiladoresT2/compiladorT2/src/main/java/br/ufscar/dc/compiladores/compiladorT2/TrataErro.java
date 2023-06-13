/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.compiladorT2;

/**
 *
 * @author jeanf
 */
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import java.util.HashMap;
import java.util.Map;


public class TrataErro extends BaseErrorListener {    

    public static final TrataErro INSTANCE = new TrataErro();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
            int charPositionInLine, String msg, RecognitionException e) 
                throws ParseCancellationException{
        

        Token token = (Token) offendingSymbol;


        // Cria o padrÃ£o de todos os prints de erro.
        String base = "Linha " + token.getLine() + ": "; 

            
        if(eh_erro(token.getType())) {//Parte resposÃ¡vel pelo tratamento dos erros LÃ©xicos(a checagem Ã© feita pela funÃ§Ã£o eh_erro() )
            if (token.getType() == AlgumaLexer.Caracter_invalido) {
                throw new ParseCancellationException(base + token.getText() + " - simbolo nao identificado\nFim da compilacao");
            }
            else if(AlgumaLexer.VOCABULARY.getSymbolicName(token.getType()).equals("CADEIA_SEM_FIM"))
            {
                throw new ParseCancellationException(base + "cadeia literal nao fechada\nFim da compilacao");
            }
            else {
                throw new ParseCancellationException(base + "comentario nao fechado\nFim da compilacao");
            }

        }
        else if (token.getType() == Token.EOF)//Se o erro nÃ£o for lÃ©xico, ele cai nos casos restantes(sintatico ou EOF )
                throw new ParseCancellationException(base + "erro sintatico proximo a EOF\nFim da compilacao");
        else
                throw new ParseCancellationException(base + "erro sintatico proximo a " + token.getText()+ "\nFim da compilacao");
        }

    private static Boolean eh_erro(int tkType) {//retorna True quando se trata de um dos 3 erros lÃ©xicos
        if(tkType == AlgumaLexer.CADEIA_SEM_FIM || tkType == AlgumaLexer.COMENTARIO_SEM_FIM
        || tkType == AlgumaLexer.Caracter_invalido )
            return true;
        return false;
    }
}