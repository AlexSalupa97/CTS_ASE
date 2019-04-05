package dubluri;

import interfete.IBanca;

public class BancaStub implements IBanca {

    @Override
    public String getNume() {
        return "Banca Stub";
    }

    @Override
    public int getNumar() {
        return 1;
    }

    @Override
    public boolean getStare() {
        return true;
    }
}
