package aulacomparators.banco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContaCorrente implements Comparable<ContaCorrente>{

    String codigo;
    double saldo;
    int tipo;
    
    public ContaCorrente(String codigo, double saldo, int tipo) {
        this.codigo = codigo;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public int getTipo(){
        return tipo;
    }

    @Override
    public int compareTo(ContaCorrente cc) {
        if (this.saldo < cc.getSaldo()) {
            return -1;
        }
        if (this.saldo > cc.getSaldo()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" + "codigo=" + codigo + ", saldo=" + saldo + ", tipo="+ tipo + '}';
    }

    public static void main(String[] args) {
        ContaCorrente cc1 = new ContaCorrente("123", 1000.0,1);
        ContaCorrente cc2 = new ContaCorrente("222", 100.0,2);
        ContaCorrente cc3 = new ContaCorrente("333", 10000.0,3);
        ContaCorrente cc4 = new ContaCorrente("444", 982.0,1);
        ContaCorrente cc5 = new ContaCorrente("144", 990.0,3);

        List<ContaCorrente> contas = new ArrayList();
        contas.add(cc1);
        contas.add(cc2);
        contas.add(cc3);
        contas.add(cc4);
        contas.add(cc5);
    
        //listar sem ordenadr
        System.out.println("Lista RAW");
        for(ContaCorrente contaCorrente : contas){
            System.out.println(contaCorrente);
        }
        //listar ordenando
        System.out.println("Lista em ordem crescente");
        Collections.sort(contas, new TipoCcComparator());
        for(ContaCorrente contaCorrente : contas){
            System.out.println(contaCorrente);
        }
    }
}
