package ex01;
import java.io.Serializable;
/**Зберігає дані.
* @author xone
* @version 1.0
*/
public class Item2d implements Serializable {
    /** Значення довжини, широти та висоти. */
    private double leng;
    private double widt;
    private double heig;
    /** Результат обчислення периметра, площі та об'єму */
    private double p;
    private double s;
    private double v;
    private static final long serialVersionUID = 1L;
    /** Ініціалізація полів 
     * {@linkplain Item2d#leng}, {@linkplain Item2d#widt}
     * {@linkplain Item2d#heig}, {@linkplain Item2d#p}
     * {@linkplain Item2d#s}, {@linkplain Item2d#v}
    */
    public Item2d() {
        leng = .0;
        widt = .0;
        heig = .0;
        p = .0;
        s = .0;
        v = .0;
    }
    /** Встановлення всіх значень та результатів. */
    public Item2d(double leng, double widt, 
    double heig, double p, double s, double v) {
        this.leng = leng;
        this.widt = widt;
        this.heig = heig;
        this.p = p;
        this.s = s;
        this.v = v;
    }

    public double setL(double leng) {
        return this.leng = leng;
    }
    public double setW(double widt) {
        return this.widt = widt;
    }
    public double setH(double heig) {
        return this.heig = heig;
    }

    public double getL() {
        return leng;
    }
    public double getW() {
        return widt;
    }
    public double getH() {
        return heig;
    }

    public double setP(double p) {
        return this.p = p;
    }
    public double setS(double s) {
        return this.s = s;
    }
    public double setV(double v) {
        return this.v = v;
    }

    public double getP() {
        return p;
    }
    public double getS() {
        return s;
    }
    public double getV() {
        return v;
    }

    /** Встановлення значень {@linkplain Item2d#leng}, 
     * {@linkplain Item2d#widt}, {@linkplain Item2d#heig} та
     * {@linkplain Item2d#p}, {@linkplain Item2d#s},
     * {@linkplain Item2d#v} */
    public Item2d setLHWPSV(double leng, double heig, 
    double widt, double p, double s, double v) {
        this.leng = leng;
        this.heig = heig;
        this.widt = widt;
        this.p = p;
        this.s = s;
        this.v = v;
        return this;
    }

    /** Виведення всіх значень.<br>{@inheritDoc} */
    @Override
    public String toString() {
        return "leng = " + leng + ", heig = " + heig + ", widt = " + 
        widt + ", perimetr = " + p + ", Plosha = " + s + ", Obyem = " + v;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item2d other = (Item2d) obj;
        if (Double.doubleToLongBits(leng) != Double.doubleToLongBits(other.leng))
            return false;
        if (Double.doubleToLongBits(widt) != Double.doubleToLongBits(other.widt))
            return false;
        if (Double.doubleToLongBits(heig) != Double.doubleToLongBits(other.heig))
            return false;
        if (Double.doubleToLongBits(p) != Double.doubleToLongBits(other.p))
            return false;
        if (Double.doubleToLongBits(s) != Double.doubleToLongBits(other.s))
            return false;
        if (Double.doubleToLongBits(v) != Double.doubleToLongBits(other.v))
            return false;
        return true;
    }
}