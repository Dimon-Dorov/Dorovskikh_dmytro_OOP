package ex03;
import java.util.Formatter;
import ex01.Item2d;
import ex02.ViewResult;
/** ConcreteProduct
* (шаблон Factory Method)<br>
* Виведення у вигляді таблиці
* @author xone
* @version 1.0
* @see ViewResult
*/
public class ViewTable extends ViewResult {
    /** Ширина таблиці за замовчуванням */
    private static final int DEFAULT_WIDTH = 20;
    /** Теперішня ширина таблиці */
    private int width;
    
    public ViewTable() {
        width = DEFAULT_WIDTH;
    }
    /** Встановлює {@linkplain ViewTable#width} значенням <b>width</b><br>
    * Визивається конструктор суперкласу {@linkplain ViewResult#ViewResult() ViewResult()}
    * @param width ширина таблиці
    */
    public ViewTable(int width) {
        this.width = width;
    }
    
    /** Встановлює {@linkplain ViewTable#width} значенням <b>width</b><br>
    * Визивається конструктор суперкласу {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
    * @param width ширина таблиці
    * @param n кількість елементів колекції; надсилається суперконструктору
    */
    public ViewTable(int width, int n) {
        super(n);
        this.width = width;
    }
    /** Встановлює {@linkplain ViewTable#width} значенням <b>width</b><br>
    * @param width ширина таблиці
    * @return встановлена ширина значенням <b>width</b>
    */
    public int setWidth(int width) {
        return this.width = width;
    }

    public int getWidth() {
        return width;
    }

    private void outLine() {
        for(int i = width*2; i > 0; i--) {
            System.out.print('-');
        }
    }
    /** Викликає {@linkplain ViewTable#outLine()}; закінчує вивід строки */
    private void outLineLn() {
        outLine();
        System.out.println();
    }
    /** Виводить заголовок таблиці шириною {@linkplain ViewTable#width} символів */
    private void outHeader() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width-3)/2, "s | %", "s\n");
        System.out.printf(fmt.toString(), "leng, widt, heig ", "perimetr, plosha, obyem ");
    }
    /** Виводить тіло таблиці шириною {@linkplain ViewTable#width} символів */
    private void outBody() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%s%s%2$d%s%s%s", "%", (width-3)/2, 
        ".0f ", "%.0f ", "%.0f | %", ".3f ", "%.3f ", "%.3f\n");
        for(Item2d item : getItems()) {
            System.out.printf(fmt.toString(), item.getL(), item.getW(), 
            item.getH(), item.getP(), item.getS(), item.getV());
        }
    }
    /** Перевантаження (поєднання, overloading) методу суперкласу;
    * встановлює поле {@linkplain ViewTable#width} значенням <b>width</b><br>
    * Викликає метод {@linkplain ViewResult#viewInit() viewInit()}
    * @param width ширина таблиці
    */
    public final void init(int width) { // method overloading
        this.width = width;
        viewInit();
    }
    /** Перевантаження методу суперкласу;
    * встановлює поле {@linkplain ViewTable#width} значенням <b>width</b><br>
    * Для об'єкту {@linkplain ViewTable} викликає метод {@linkplain ViewTable#init(double stepX)
    * @param width ширина таблиці.
    * @param stepX передається до метода <b>init(double)</b>
    */
    public final void init(int width, double stepL, double stepW, double stepH) { // method overloading
        this.width = width;
        init(stepL, stepW, stepH);
    }
    /** Перевизначення (заміщення, overriding) методу суперкласу;
    * виводить повідомлення та викликає метод суперкласу
    */
    @Override
    public void init(double stepL, double stepW, double stepH) { // method overriding
        System.out.print("Initialization... ");
        super.init(stepL, stepW, stepH);
        System.out.println("done. ");
    }
    /** Вивід елементу<br>{@inheritDoc} */
    @Override
    public void viewHeader() {
        outHeader();
        outLineLn();
    }
    /** Вивід елементу<br>{@inheritDoc} */
    @Override
    public void viewBody() {
        outBody();
    }
    /** Вивід елементу<br>{@inheritDoc} */
    @Override
    public void viewFooter() {
        outLineLn();
    }
}