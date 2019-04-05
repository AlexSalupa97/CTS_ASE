package dubluri;

import interfete.IBanca;

public class BancaFake implements IBanca {

    private String valoaredeReturnNume;
    private int valoareDeReturnNumar;
    private boolean valoareDeReturnStare;

    public void setValoaredeReturnNume(String valoaredeReturnNume) {
        this.valoaredeReturnNume = valoaredeReturnNume;
    }

    public void setValoareDeReturnNumar(int valoareDeReturnNumar) {
        this.valoareDeReturnNumar = valoareDeReturnNumar;
    }

    public void setValoareDeReturnStare(boolean valoareDeReturnStare) {
        this.valoareDeReturnStare = valoareDeReturnStare;
    }

    @Override
    public String getNume() {
        return valoaredeReturnNume;
    }

    @Override
    public int getNumar() {
        return valoareDeReturnNumar;
    }

    @Override
    public boolean getStare() {
        return valoareDeReturnStare;
    }
}
