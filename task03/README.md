### Task 03 - RPNStacker Automatic/Regex Scanning

Nessa atividade, implementa-se as mesmas features da [task02](../task02). No entanto, a validação das string numéricas e dos caracteres operadores é feita utilizando regex. No diretório [regex](./src/rpn/regex), a classe implementa dois métodos para validação de operandos numéricos e operadores:

```
package rpn.regex;

public class Regex {
	
	public static boolean isNum(String token) {
		String integer = "^[-]?[1-9][0-9]*|0$";
		String floating = "^[-]?([1-9][0-9]*|0)[.][0-9]+$";
		return token.matches(integer + "|" + floating);
	}
	
	public static boolean isOP(String token) {
		String ops = "[\\^*/+\\-]";
		return token.matches(ops);
	}

}
```

Em ```isNum```, a string *integer* define uma expressão regular para inteiros positivos ou negativos (caso seja informado o caractere '-'). Já a string *floating* define uma regex para validar pontos flutuantes. Agora, no método ```isOP```, a string *ops* determina os caracteres operadores suportados pelo analisador RPN: exponenciação, multiplicação, divisão, adição e subtração.

O retorno desses dois métodos é computado na classe [Scanner](./src/rpn/scanner/Scanner.java) para corretamente tokenizar a entrada do arquivo correspondente à expressão a ser avaliada em Reverse Polish Notation.
