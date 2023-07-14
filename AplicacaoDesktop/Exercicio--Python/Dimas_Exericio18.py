n = 0
maior = 0
contador = 0

for contador in range(1,5,1):
    n = int(input("Informe um numero inteiro: "))

    if(n>maior):
        maior = n

print("O maior numero é: ",str(maior))