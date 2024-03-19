package ex01;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/** Реалізація обчислення, збереження, відновлення та виведення. */
public class Calc {
    private static final String FNAME = "Item2d.bin";
    /** Зберігає результати обчислень. Объект класу {@linkplain Item2d} */
    private Item2d result;
    public Calc() {
        result = new Item2d();
    }

    public void setResult(Item2d result) {
        this.result = result;
    }

    public Item2d getResult() {
        return result;
    }
    /** Обчислює та зберігає результат в {@linkplain Calc#result} */
    public double init(double leng, double widt, double heig) {
        result.setL(leng);
        result.setW(widt);
        result.setH(heig);
        double p = calcP(leng, widt, heig);
        double s = calcS(leng, widt, heig);
        double v = calcV(leng, widt, heig);
        result.setP(p);
        result.setS(s);
        result.setV(v);
        return v;
    }

    private double calcP(double leng, double widt, double heig) {
        return 4 * (leng + widt + heig);
    }

    private double calcS(double leng, double widt, double heig){
        return 2*(leng*widt+leng*heig+widt*heig);
    }

    private double calcV(double leng, double widt, double heig){
        return leng*widt*heig;
    }

    /** Виведення. */
    public void show() {
        System.out.println(result);
    }
    /** Зберігає {@linkplain Calc#result} в файлі {@linkplain Calc#FNAME}
    * @throws IOException
    */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }
    /** Відновлює {@linkplain Calc#result} з файлу {@linkplain Calc#FNAME}
    * @throws Exception
    */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Item2d)is.readObject();
        is.close();
    }
}