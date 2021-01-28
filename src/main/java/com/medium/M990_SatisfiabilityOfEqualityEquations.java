package com.medium;

public class M990_SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String e : equations) {
            if(e.charAt(1) == '='){
                char x = e.charAt(0);
                char y = e.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }

        for (String e : equations) {
            if(e.charAt(1) == '!'){
                char x = e.charAt(0);
                char y = e.charAt(3);
                if(uf.connected(x - 'a', y - 'a')){
                    return false;
                }
            }

        }
        return true;
    }
}


