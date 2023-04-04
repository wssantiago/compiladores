def read_input():
    entry = input()
    ans = []

    while(entry != 'end'):
        ans.append(entry)
        entry = input()
    
    return ans

def operate(stack, e):
    operand_2 = stack.pop()
    operand_1 = stack.pop()

    if e == '^':
        res = operand_1 ** operand_2
    elif e == '*':
        res = operand_1 * operand_2
    elif e == '/':
        res = operand_1 / operand_2
    elif e == '-':
        res = operand_1 - operand_2
    elif e == '+':
        res = operand_1 + operand_2

    stack.append(res)
    return stack

def rpn(exp):
    stack = []
    
    for e in exp:
        if e.isnumeric():
            stack.append(int(e))
        else:
            stack = operate(stack, e)

    return stack.pop()

exp = read_input()
result = rpn(exp)
print(result)