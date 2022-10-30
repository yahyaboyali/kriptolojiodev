package entities;

public class Mod {
    private int mod;
    private int deger;

    public Mod(int mod, int deger) {
        this.mod = mod;
        this.deger = deger;
    }

    public Mod() {
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

    public int getDeger() {
        return deger;
    }

    public void setDeger(int deger) {

        this.deger = deger;
    }
}
