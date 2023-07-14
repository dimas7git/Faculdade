sal = 0.0
c1 = 0.0
c2 = 0.0 
salf = 0.0
imp = 0.0
imp2 = 0.0
impf = 0.0 

sal =  float(input("Digite o valor do salario: "))
c1 = float(input("Informe quanto quer tirar no primeiro cheque: "))
c2 = float(input("Informe quanto quer tirar no segundo cheque"))

imp = c1*0.38/100
imp2 = c2*0.38/100
impf = imp+imp2
salf = (sal-impf) - (c1 + c2)

print(str(salf), "$ é o salario final!")