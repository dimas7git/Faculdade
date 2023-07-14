n1 = 0.0
n2 = 0.0
n3 = 0.0
media = 0.0
t_med = ""


def mediaf(numero1,numero2,numero3,medias): 
     if(medias == "a"):    
        media = (numero1+numero2+numero3)/3
     else:
      media = (numero1*5 + numero2*3 + numero3*2) / 10
     return media      


n1 = float(input("Informe a primeira nota: "))
n2 = float(input("Informe a segunda nota: "))
n3 = float(input("Informe a terceira nota: "))
t_med = (input("Informe o tipo de media - A para aritmetica, P para ponderada"))

print("A media é: " +str(mediaf(n1,n2,n3,t_med)))

