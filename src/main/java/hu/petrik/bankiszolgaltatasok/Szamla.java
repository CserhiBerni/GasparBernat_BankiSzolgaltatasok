package hu.petrik.bankiszolgaltatasok;

public class Szamla extends BankiSzolgaltatas {
    public int aktualisEgyenleg;

    public Szamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.aktualisEgyenleg = 0;
    }

    public int getAktualisEgyenleg() {
        return aktualisEgyenleg;
    }

    public void befizet(int osszeg) {
        if (osszeg > 0) {
            aktualisEgyenleg += osszeg;
        }
    }

    public boolean kivesz(int osszeg) {
        if (osszeg > 0 && aktualisEgyenleg >= osszeg) {
            aktualisEgyenleg -= osszeg;
            return true;
        }
        return false;
    }

    public Kartya ujKartya(String kartyaSzam) {
        return new Kartya(getTulajdonos(), this, kartyaSzam);
    }

    @Override
    public String toString() {
        return "Számla tulajdonosa: " + getTulajdonos() + ", Egyenleg: " + aktualisEgyenleg;
    }
}

