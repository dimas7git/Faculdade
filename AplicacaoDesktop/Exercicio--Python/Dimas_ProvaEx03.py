

vm = 0.0
nome = ""
situacao = ""
nome = input("Digite o seu nome ")
vm = float(input("Digite o venda do mês "))

if (vm > 50000):
    situacao = "ótima"

if(vm < 10000):
        situacao = "baixa"
else:
        if(vm > 10000) and (vm <= 50000):
            situacao = "ideal"   

            
print(nome, " a venda está: " ,situacao)
