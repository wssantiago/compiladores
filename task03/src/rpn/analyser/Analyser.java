package rpn.analyser;

import java.util.ArrayList;
import java.util.List;
import rpn.lexer.*;
import rpn.scanner.Scanner;

public class Analyser {
	
	public List<Token> tokens;
	public List<Double> stack;
	
	public Analyser() {
		this.tokens = new ArrayList<>();
		this.stack = new ArrayList<>();
	}
	
	public List<Token> readFile() {
		
		List<Token> tokens = new ArrayList<>();

		tokens.add(new Token(TokenType.NUM, "10"));
		tokens.add(new Token(TokenType.NUM, "10"));
		tokens.add(new Token(TokenType.PLUS, "+"));
		
		return tokens; 
	}
	
	public List<Double> operate(List<Double> stack, Token e) {
		if(stack.size() >= 2) {
			double operation = 0;
			double b = stack.remove(stack.size()-1);
			double a = stack.remove(stack.size()-1);
			
			if(e.type == TokenType.HAT) operation = Math.pow(a, b);
			else if(e.type == TokenType.STAR) operation = a * b;
			else if(e.type == TokenType.SLASH) operation = a / b;
			else if(e.type == TokenType.MINUS) operation = a - b;
			else if(e.type == TokenType.PLUS) operation = a + b;
			
			stack.add(operation);
		}
		
		return stack;
	}
	
	public double analyse() {
		
		for(Token token : this.tokens) {
			System.out.println(this.stack);
			if(token.type == TokenType.NUM) {
				this.stack.add(Double.parseDouble(token.lexeme));
			}
			else {
				this.stack = operate(this.stack, token);
			}
		}
		
		return this.stack.get(0);
	}
	
	public static void main(String[] args) {
		Analyser anal = new Analyser();
		Scanner scan = new Scanner("exp.stk");
		scan.read();
		anal.tokens = scan.tokenize();
		if(anal.tokens != null) {
			System.out.println("\n----------- Tokens scanned -----------\n");
			for(Token token : anal.tokens)
				System.out.println(token);
			System.out.println("\n----------- Stack that evaluates the expression (rightmost element is the top) -----------\n");
			double result = anal.analyse();
			System.out.println("\nExpression is evaluated as: " + result);
		}
	}

}
