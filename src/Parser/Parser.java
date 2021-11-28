package Parser;

import exceptions.synt;
import lexico.Scanner;
import lexico.Token;

public class Parser {

    private Scanner scanner; // analisador léxico
	private Token   token;   // o token atual
	
	/* o Parser recebe o analisador léxico como parâmetro no construtor
	 * pois a cada procedimento invoca-o sob demanda
	 */

	public Parser(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void E() {
		T();
		El();
		
	}
	
	public void El() {
		token = scanner.nextToken();
		if (token != null) {
			OP();
			T();
			El();
		}
	}
	
	public void T() {
		token = scanner.nextToken();
		if (token.getType() != Token.TK_IDENTIFIER && token.getType() != Token.TK_NUMBER) {
			throw new synt("ID ou Número, "+Token.TK_TEXT[token.getType()]+" ("+token.getText()+") na linha "+token.getLine()+" coluna "+token.getColumn());
		}
		
	}
	
	public void OP() {
		if (token.getType() != Token.TK_OPERATOR) {
			throw new synt("Operador, "+Token.TK_TEXT[token.getType()]+" ("+token.getText()+") na linha "+token.getLine()+" coluna "+token.getColumn());
		}
	}
    
}
