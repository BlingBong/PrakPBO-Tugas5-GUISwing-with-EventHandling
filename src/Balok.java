public class Balok extends PersegiPanjang implements MenghitungRuang {
    private double tinggiBalok;

    public Balok(double panjang, double lebar, double tinggiBalok) {
        super(panjang, lebar);
        this.tinggiBalok = tinggiBalok;
    }

    public double getTinggiBalok() {
        return tinggiBalok;
    }

    public void setTinggiBalok(double tinggiBalok) {
        this.tinggiBalok = tinggiBalok;
    }

    @Override
    public double volume() {
        return luas()*getTinggiBalok();
    }

    @Override
    public double luasPermukaan() {
        return 2*(getPanjang()*getLebar() + getLebar()*getTinggiBalok() + getTinggiBalok()*getPanjang());
    }
}
