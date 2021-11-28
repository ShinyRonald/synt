package main;

import exceptions.lexic;
import exceptions.synt;
import lexico.Scanner;
import Parser.Parser;

public class App {
    public static void main(String[] args) throws Exception {
        
        try {
			Scanner sc = new Scanner("src/txt.txt");
			Parser  pa = new Parser(sc);
			
			pa.E();
			
			System.out.println("Compilation Successful!");
		} catch (lexic ex) {
			System.out.println("Lexical Error "+ex.getMessage());
		}
		catch (synt ex) {
			System.out.println("Syntax Error "+ex.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Generic Error!!");
			System.out.println(ex.getClass().getName());
		}

    }
}
