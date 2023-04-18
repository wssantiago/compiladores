def read_input():
    print("Input any well formed expression in reverse polished notation:\n")
    entry = input()
    ans = []

    while(entry != 'end'):
        ans.append(entry)
        entry = input()
    
    return ans

def operate(stack, e):
    if len(stack) >= 2:
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
        else: 
            res = operand_1 + operand_2 # default operation for unknown operator
        
        stack.append(res)
        return stack
    return None

def rpn(exp):
    stack = []
    
    for e in exp:
        if e.isnumeric():
            stack.append(int(e))
        else:
            stack = operate(stack, e)
            if not stack:
                return "Invalid RPN expression"

    return stack.pop() if len(stack) == 1 else "Invalid RPN expression"

exp = read_input()
result = rpn(exp)
print("The result for the inputed expression is: ", result)
