package ex01;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/** Содержит реализацию методов для вычисления и отображения результатов.
* @author xone
* @version 1.0
*/
public class Calc {
/** Имя файла, используемое при сериализации. */
private static final String FNAME = "Item2d.bin";
/** Сохраняет результат вычислений. Объект класса {@linkplain Item2d} */
private Item2d result;
/** Инициализирует {@linkplain Calc#result} */
public Calc() {
result = new Item2d();
}
/** Установить значение {@linkplain Calc#result}
* @param result - новое значение ссылки на объект {@linkplain Item2d}
*/
public void setResult(Item2d result) {this.result = result;
}
/** Получить значение {@linkplain Calc#result}
* @return текущее значение ссылки на объект {@linkplain Item2d}
*/
public Item2d getResult() {
return result;
}
/** Вычисляет значение.
* @param leng - довжина
* @param widt - ширина
* @param heig - висота
* @return результат вычисления функции.
*/
private double calc(double leng, double widt, double heig) {
return (leng+widt+heig)*4;
}
/** Вычисляет значение и сохраняет
* результат в объекте {@linkplain Calc#result}
* @param leng - довжина
* @param widt - ширина
* @param heig - висота
*/
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
    return 2 * (leng + widt + heig);
}

private double calcS(double leng, double widt, double heig){
    return 2*(leng*widt+leng*heig+widt*heig);
}

private double calcV(double leng, double widt, double heig){
    return leng*widt*heig;
}

/** Выводит результат вычислений. */
public void show() {
System.out.println(result);
}
/** Сохраняет {@linkplain Calc#result} в файле {@linkplain Calc#FNAME}
* @throws IOException
*/
public void save() throws IOException {
ObjectOutputStream os = new ObjectOutputStream(new
FileOutputStream(FNAME));
os.writeObject(result);
os.flush();
os.close();
}
/** Восстанавливает {@linkplain Calc#result} из файла {@linkplain Calc#FNAME}
* @throws Exception
*/
public void restore() throws Exception {
ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
result = (Item2d)is.readObject();
is.close();
}
}