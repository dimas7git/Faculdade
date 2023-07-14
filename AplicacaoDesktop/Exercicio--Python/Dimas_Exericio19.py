num = 1
maior = 0
menor = 1
while num != 0:
    num = int(input("Informe um numero : "))
    if (num > maior) and (num != 0):
        maior = num
        if num < menor and num > 0 :
            menor = num
print("O maior numero é: ", str(maior), " e o menor é: ", str(menor))        