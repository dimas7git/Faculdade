package aulacomparators.banco;

import java.util.*;

public class TipoCcComparator implements Comparator<ContaCorrente> {

    @Override
    public int compare(ContaCorrente cc1, ContaCorrente cc2) {
        if (cc1.getTipo() < cc2.getTipo()) {
            return -1;
        }

        if (cc1.getTipo() > cc2.getTipo()) {
            return 1;
        }

        if ((cc1.getTipo() == cc2.getTipo()) && (cc1.getSaldo() < cc2.getSaldo())) {
            return -1;
        }

        if ((cc1.getTipo() == cc2.getTipo()) && (cc1.getSaldo() > cc2.getSaldo())) {
            return 1;
        }
        
        else{
            return 0;
        }
    }
}
