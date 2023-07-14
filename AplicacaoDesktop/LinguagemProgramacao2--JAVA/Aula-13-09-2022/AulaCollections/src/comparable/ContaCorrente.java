package comparable;

import java.util.*;

public class ContaCorrente implements Comparable<ContaCorrente> {

    String codigo;
    double saldo;

    public ContaCorrente(String codigo, double saldo) {
        this.codigo = codigo;
        this.saldo = saldo;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getSaldo() {
        return saldo;
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
        return "ContaCorrente{" + "codigo=" + codigo + ", saldo=" + saldo + '}';
    }

    public static void main(String[] args) {
        ContaCorrente cc1 = new ContaCorrente("123", 1000.0);
        ContaCorrente cc2 = new ContaCorrente("222", 100.0);
        ContaCorrente cc3 = new ContaCorrente("333", 10000.0);
        ContaCorrente cc4 = new ContaCorrente("444", 982.0);

        List<ContaCorrente> contas = new ArrayList();

    }

}
