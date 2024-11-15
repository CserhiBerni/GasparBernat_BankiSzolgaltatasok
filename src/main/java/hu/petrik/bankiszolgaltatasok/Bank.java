package hu.petrik.bankiszolgaltatasok;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Szamla> szamlak;

    public Bank() {
        this.szamlak = new ArrayList<>();
    }

    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelkeret) {
        if (hitelkeret < 0) {
            throw new IllegalArgumentException("A hitelkeret nem lehet negatív.");
        }

        Szamla ujSzamla;
        if (hitelkeret > 0) {
            ujSzamla = new HitelSzamla(tulajdonos, hitelkeret);
        } else {
            ujSzamla = new MegtakaritasiSzamla(tulajdonos);
        }

        szamlak.add(ujSzamla);
        return ujSzamla;
    }

    public int getOsszEgyenleg(Tulajdonos tulajdonos) {
        int osszegyenleg = 0;
        for (Szamla szamla : szamlak) {
            if (szamla.getTulajdonos().equals(tulajdonos)) {
                osszegyenleg += szamla.getAktualisEgyenleg();
            }
        }
        return osszegyenleg;
    }

    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos) {
        Szamla legnagyobbSzamla = null;
        int maxEgyenleg = Integer.MIN_VALUE;

        for (Szamla szamla : szamlak) {
            if (szamla.getTulajdonos().equals(tulajdonos) && szamla.getAktualisEgyenleg() > maxEgyenleg) {
                maxEgyenleg = szamla.getAktualisEgyenleg();
                legnagyobbSzamla = szamla;
            }
        }

        return legnagyobbSzamla;
    }

    public int getOsszHitelkeret() {
        int osszHitelkeret = 0;

        for (Szamla szamla : szamlak) {
            if (szamla instanceof HitelSzamla) {
                osszHitelkeret += ((HitelSzamla) szamla).getHitelKeret();
            }
        }

        return osszHitelkeret;
    }
}

