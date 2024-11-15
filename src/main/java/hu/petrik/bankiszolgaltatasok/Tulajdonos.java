package hu.petrik.bankiszolgaltatasok;

public final class Tulajdonos {
    public String nev;
    public Tulajdonos(String nev) {
        this.nev = nev;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    @Override
    public String toString() {
        return "Tulajdonos: " + nev;
    }
}
