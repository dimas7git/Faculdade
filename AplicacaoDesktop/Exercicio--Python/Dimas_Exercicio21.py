linha = 0
coluna = 0
mat = [[0]*5, [0]*5, [0]*5,[0]*5, [0]*5]


for linha in range(0,5,1):
    for coluna in range(0,5,1):
        mat[linha][coluna] = int(input("Informe o numero para a posição" + str(linha) + " " + str(coluna)+ ": "))


for linha in range(0,5,1):
    for coluna in range(0,5,1):
       if (linha == coluna): 
        print("[",mat[linha][coluna],"[", end='')
    print()          