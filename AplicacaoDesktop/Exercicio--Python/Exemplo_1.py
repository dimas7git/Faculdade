nome = ""
nota1 = 0.0
nota2 = 0.0
media = 0.0


nome = input("Informe o nome do aluno: ")
nota1 = float(input("Informe a nota 1: "))
nota2 = float(input("Informe a nota 2: "))

media = (nota1 + nota2)/2

print(nome, " A sua média é: " ,str(media))