package dubluri;

import interfete.IBanca;

public class BancaDummy implements IBanca {

    @Override
    public String getNume() {
        return null;
    }

    @Override
    public int getNumar() {
        return 0;
    }

    @Override
    public boolean getStare() {
        return false;
    }
}
