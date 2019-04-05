package dubluri;

import interfete.IBanca;

public class BancaSpy implements IBanca {

    private int ctGetNume;
    private int ctGetNumar;
    private int ctGetStare;

    public BancaSpy() {
        ctGetStare = 0;
        ctGetNumar = 0;
        ctGetNume = 0;
    }

    public int getCtGetNume() {
        return ctGetNume;
    }

    public int getCtGetNumar() {
        return ctGetNumar;
    }

    public int getCtGetStare() {
        return ctGetStare;
    }

    @Override
    public String getNume() {
        ctGetNume++;
        return null;
    }

    @Override
    public int getNumar() {
        ctGetNumar++;
        return 0;
    }

    @Override
    public boolean getStare() {
        ctGetStare++;
        return false;
    }
}
