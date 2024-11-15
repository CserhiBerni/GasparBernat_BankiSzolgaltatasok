package hu.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla {
    private final int hitelKeret;

    public HitelSzamla(Tulajdonos tulajdonos, int hitelKeret) {
        super(tulajdonos);
        this.hitelKeret = hitelKeret;
    }

    public int getHitelKeret() {
        return hitelKeret;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (osszeg > 0 && (getAktualisEgyenleg() - osszeg) >= -hitelKeret) {
            befizet(-osszeg);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "HitelSzámla tulajdonosa: " + getTulajdonos() + ", Egyenleg: " + getAktualisEgyenleg() + ", Hitelkeret: " + hitelKeret;
    }
}

