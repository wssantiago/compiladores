### Task01: RPNStacker Adhoc [Python 3.10.6]

Esse script em python implementa uma estrutura de pilha para resolver expressões no formato RPN. Para testar, execute o arquivo [task01](./task01.py) utilizando ```python3 task01.py``` e alimente-o com uma expressão no formato RPN seguida de 'end' para indicar seu final:

```
3
4
2
*
1
5
-
2
3
^
^
/
+
end
```

Ao digitar cada operando ou operador, pressione enter para digitar o próximo. Após finalizar a entrada com 'end', o executável deve retornar a resposta do cálculo da expressão ou uma mensagem indicando que a entrada é inválida. No caso acima, o script deve retornar:

```
The result for the inputed expression is:  3.0001220703125
```
