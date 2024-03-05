package ex02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import ex01.Item2d;
/** ConcreteProduct
* (Шаблон проектирования
* Factory Method)<br>
* Вычисление,
* сохранение и отображение
* результатов
* @author xone
* @version 1.0
* @see View
*/
public class ViewResult implements View {
/** Имя файла, используемое при сериализации */
private static final String FNAME = "items.bin";
/** Определяет количество значений для вычисления по умолчанию */
private static final int DEFAULT_NUM = 10;
/** Коллекция аргументов и результатов вычислений */
private ArrayList<Item2d> items = new ArrayList<Item2d>();
/** Вызывает {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
* с параметром {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
*/
public ViewResult() {
this(DEFAULT_NUM);
}
/** Инициализирует коллекцию {@linkplain ViewResult#items}
* @param n начальное количество элементов
*/
public ViewResult(int n) {
for(int ctr = 0; ctr < n; ctr++) {
items.add(new Item2d());
}
}
/** Получить значение {@linkplain ViewResult#items}
* @return текущее значение ссылки на объект {@linkplain ArrayList}
*/
public ArrayList<Item2d> getItems() {
return items;
}
/** Вычисляет значение функции
* @param leng - довжина
* @param widt - ширина
* @param heig - висота
* @return результат вычисления
*/

private double calcP(double leng, double widt, double heig) {
    return 2 * (leng + widt + heig);
}

private double calcS(double leng, double widt, double heig){
    return 2*(leng*widt+leng*heig+widt*heig);
}

private double calcV(double leng, double widt, double heig){
    return leng*widt*heig;
}
    /** Вычисляет значение и сохраняет
    * результат в коллекции {@linkplain ViewResult#items}
    * @param stepL шаг приращения
    * @param stepW шаг приращения
    * @param stepH шаг приращения
    */
    public void init(double stepL, double stepW, double stepH) {
    double leng = 0.0;
    double widt = 0.0;
    double heig = 0.0;
    for(Item2d item : items) {
    item.setLHWPSV(leng, widt, heig, calcP(leng, widt, heig), calcS(leng, widt, heig), calcV(leng, widt, heig));
    leng += stepL;
    widt += stepW;
    heig += stepH;
    }
    }
    /** Вызывает <b>init(double stepL, double stepW, double stepH)</b> со случайным значением аргумента<br>
    * {@inheritDoc}
    */
    @Override
    public void viewInit() {
    init(Math.random() * 100, Math.random() * 100, Math.random() * 100);
    }
    /** Реализация метода {@linkplain View#viewSave()}<br>
    * {@inheritDoc}
    */
    @Override
    public void viewSave() throws IOException {
    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
    os.writeObject(items);
    os.flush();
    os.close();
    }
    /** Реализация метода {@linkplain View#viewRestore()}<br>
    * {@inheritDoc}
    */
    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
    ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
    items = (ArrayList<Item2d>) is.readObject();
    is.close();
    }
    /** Реализация метода {@linkplain View#viewHeader()}<br>
    * {@inheritDoc}
    */
    @Override
    public void viewHeader() {
    System.out.println("Results:");
    }
    /** Реализация метода {@linkplain View#viewBody()}<br>
    * {@inheritDoc}
    */
    @Override
    public void viewBody() {
    for(Item2d item : items) {
    System.out.printf("(%.0f; %.0f; %.0f; %.3f; %.3f; %.3f) ", item.getL(), item.getW(), item.getH(), item.getP(), item.getS(), item.getV());
    }
    System.out.println();
    }
    /** Реализация метода {@linkplain View#viewFooter()}<br>
    * {@inheritDoc}
    */
    @Override
    public void viewFooter() {
    System.out.println("End.");
    }
    /** Реализация метода {@linkplain View#viewShow()}<br>
    * {@inheritDoc}
    */
    @Override
    public void viewShow() {
    viewHeader();
    viewBody();
    viewFooter();
}
}