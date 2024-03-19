package ex02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import ex01.Item2d;
/** ConcreteProduct
* (шаблон Factory Method)<br>
* Оголошує метод, 
* Обчислює,
* зберігає та відображає
* результати
* @author xone
* @version 1.0
* @see View
*/
public class ViewResult implements View {
    private static final String FNAME = "items.bin";
    /** Максимальна кількість значень для обчислень */
    private static final int DEFAULT_NUM = 10;
    /** Колекція значень та результатів обчислень */
    private ArrayList<Item2d> items = new ArrayList<Item2d>();
    /** Викликає {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
    * з параметром {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
    */
    public ViewResult() {
        this(DEFAULT_NUM);
    }
    /** Ініціалізація колекції {@linkplain ViewResult#items}
    * @param n початкове значення елементів
    */
    public ViewResult(int n) {
        for(int ctr = 0; ctr < n; ctr++) {
            items.add(new Item2d());
        }
    }

    public ArrayList<Item2d> getItems() {
        return items;
    }
    /** Обчислює індив. завдання
    * @param leng - довжина
    * @param widt - ширина
    * @param heig - висота
    * @return результат
    */

    private double calcP(double leng, double widt, double heig) {
        return 4 * (leng + widt + heig);
    }

    private double calcS(double leng, double widt, double heig){
        return 2*(leng*widt+leng*heig+widt*heig);
    }

    private double calcV(double leng, double widt, double heig){
        return leng*widt*heig;
    }
        /** Обчислює значення індив. завдання та
        * записує результат в колекцію {@linkplain ViewResult#items}
        * @param stepL шаг
        * @param stepW шаг
        * @param stepH шаг
        */
        public void init(double stepL, double stepW, double stepH) {
            double leng = 0.0;
            double widt = 0.0;
            double heig = 0.0;
            for(Item2d item : items) {
                item.setLHWPSV(leng, widt, heig, calcP(leng, widt, heig), 
                calcS(leng, widt, heig), calcV(leng, widt, heig));
                leng += stepL;
                widt += stepW;
                heig += stepH;
            }
        }

        @Override
        public void viewInit() {
            init(Math.random() * 100, 
            Math.random() * 100, Math.random() * 100);
        }
        /** Реалізація методу {@linkplain View#viewSave()}<br>
        * {@inheritDoc}
        */
        @Override
        public void viewSave() throws IOException {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
            os.writeObject(items);
            os.flush();
            os.close();
        }
        /** Реалізація методу {@linkplain View#viewRestore()}<br>
        * {@inheritDoc}
        */
        @SuppressWarnings("unchecked")
        @Override
        public void viewRestore() throws Exception {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
            items = (ArrayList<Item2d>) is.readObject();
            is.close();
        }
        /** Реалізація методу {@linkplain View#viewHeader()}<br>
        * {@inheritDoc}
        */
        @Override
        public void viewHeader() {
            System.out.println("Results:");
        }
        /** Реалізація методу {@linkplain View#viewBody()}<br>
        * {@inheritDoc}
        */
        @Override
        public void viewBody() {
            for(Item2d item : items) {
                System.out.printf("(%.0f; %.0f; %.0f; %.3f; %.3f; %.3f) ", 
                item.getL(), item.getW(), item.getH(), item.getP(), item.getS(), item.getV());
            }
            System.out.println();
        }
        /** Реалізація методу {@linkplain View#viewFooter()}<br>
        * {@inheritDoc}
        */
        @Override
        public void viewFooter() {
            System.out.println("End.");
        }
        /** Реалізація методу {@linkplain View#viewShow()}<br>
        * {@inheritDoc}
        */
        @Override
        public void viewShow() {
            viewHeader();
            viewBody();
            viewFooter();
    }
}