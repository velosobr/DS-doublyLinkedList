public class Caixa {

    private Object elemento;
    private Caixa anterior;
    private Caixa proximo;


    public Caixa(Object elemento, Caixa anterior, Caixa proximo) {
        this.elemento = elemento;
        this.anterior = anterior;
        this.proximo = proximo;
    }

    public Caixa(Object elemento) {
        this.elemento = elemento;
    }

    public Caixa() {

    }

    public Caixa(Caixa proximo, Object elemento) {
        this.proximo = proximo;
        this.elemento = elemento;
    }

    public Object getElemento() {
        return this.elemento;
    }
    
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public Caixa getAnterior() {
        return this.anterior;
    }

    public Caixa getProximo() {
        return this.proximo;
    }

    public void setAnterior(Caixa anterior) {
        this.anterior = anterior;
    }

    public void setProximo(Caixa topo) {
        this.proximo = topo;
    }
}
