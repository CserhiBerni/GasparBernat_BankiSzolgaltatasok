package hu.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends Szamla {
    public static final double alapKamat = 1.1;
    private double kamat;

    public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.kamat = alapKamat;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        if (kamat > 0) {
            this.kamat = kamat;
        }
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (osszeg > 0 && getAktualisEgyenleg() >= osszeg) {
            befizet(-osszeg);
            return true;
        }
        return false;
    }

    public void kamatJovairas() {
        int kamatOsszeg = (int) ((getAktualisEgyenleg() * kamat) - getAktualisEgyenleg());
        befizet(kamatOsszeg);
    }

    @Override
    public String toString() {
        return "Megtakarítási Számla tulajdonosa: " + getTulajdonos() + ", Egyenleg: " + getAktualisEgyenleg() + ", Kamat: " + kamat;
    }

    public static double getAlapKamat() {
        return alapKamat;
    }
}