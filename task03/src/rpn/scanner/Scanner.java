package rpn.scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rpn.lexer.Token;
import rpn.lexer.TokenType;
import rpn.regex.*;

public class Scanner {
	
	public List<String> lines;
	public List<Token> tokens;
	public String fileName;
	
	public Scanner(String fileName) {
		this.lines = new ArrayList<>();
		this.tokens = new ArrayList<>();
		this.fileName = fileName;
	}
	
	public List<String> read() {
		
		try (FileReader reader = new FileReader(this.fileName);
             BufferedReader br = new BufferedReader(reader)) {

			String line;
			while ((line = br.readLine()) != null) {
				this.lines.add(line);
			}

		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
			return null;
		}
		
		return this.lines;
	}
	
	public List<Token> tokenize() {
		
		for(String line : this.lines) {
			if(Regex.isOP(line)) {
				if(line.equalsIgnoreCase("^")) this.tokens.add(new Token(TokenType.HAT, line));
				else if(line.equalsIgnoreCase("*")) this.tokens.add(new Token(TokenType.STAR, line));
				else if(line.equalsIgnoreCase("/")) this.tokens.add(new Token(TokenType.SLASH, line));
				else if(line.equalsIgnoreCase("-")) this.tokens.add(new Token(TokenType.MINUS, line));
				else if(line.equalsIgnoreCase("+")) this.tokens.add(new Token(TokenType.PLUS, line));
			} else if(Regex.isNum(line)) this.tokens.add(new Token(TokenType.NUM, line));
			else {
				System.out.println("Error: Unexpected character: " + line);
				return null;
			}
		}
		
		return this.tokens;
	}
}
