public class PilhaArray implements Pilha {

    private int topo;
    private Object O[];

    public PilhaArray(int tamanho){
        O = new Object[tamanho];
        this.topo = -1;
    }

    private void increase(int incremento) {
        Object[] auxiliar;
        if (incremento != 0){
            auxiliar = new Object[incremento];
            for (int i = 0; i < topo; i++){
                auxiliar[i] = O[i];
            }
            O = auxiliar;
        }
    }

    @Override
    public int size() { // retorna a quantidade de itens na pilha
            return topo + 1;
        }

    @Override
    public boolean isEmpty() { 
        return size() != 0;
        
    }

    @Override
    public Object top() throws PilhaVaziaExcecao {
        return O[topo]; 
    }

    @Override
    public void push(Object o) {
        if (this.topo+1 == size()){
            increase(2*size());
        }
        O[topo+1] = o;
    }

    @Override
    public Object pop() throws PilhaVaziaExcecao {
        if(isEmpty()){
            PilhaVaziaExcecao e;
            e = new PilhaVaziaExcecao(null);
            throw e;
        }
        
        return O[topo -1];
    }


    
}
