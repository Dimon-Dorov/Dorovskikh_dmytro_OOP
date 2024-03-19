package ex05;
import java.util.concurrent.TimeUnit;
import ex01.Item2d;
import ex02.ViewResult;
import ex04.Command;
/** Завдання, що використовується
*  обробником потоку;
* шаблон Worker Thread
* @author xone
* @version 1.0
* @see Command
* @see CommandQueue
*/
public class MinMaxCommand implements Command /*, Runnable */ {
    /** Зберігає результат обробки колекції */
    private int resultMin = -1;
    /** Зберігає результат обробки колекції */
    private int resultMax = -1;
    /** Прапор готовності результату */
    private int progress = 0;
    /** Обслуговує колекцію об'єктів {@linkplain ex01.Item2d} */
    private ViewResult viewResult;
    /** Повертає поле {@linkplain MinMaxCommand#viewResult}
    * @return значення {@linkplain MinMaxCommand#viewResult}
    */
    public ViewResult getViewResult() {
        return viewResult;
    }
    /** Встановлює поле {@linkplain MinMaxCommand#viewResult}
    * @param viewResult значення для {@linkplain MinMaxCommand#viewResult}
    * @return нове значення {@linkplain MinMaxCommand#viewResult}
    */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }
    /** Ініціалізує поле {@linkplain MinMaxCommand#viewResult}
    * @param viewResult об'єкт класу {@linkplain ViewResult}
    */
    public MinMaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }
    /** Повертає результат
    * @return поле {@linkplain MinMaxCommand#resultMin}
    */
    public int getResultMin() {
        return resultMin;
    }
    /** Повертає результат
    * @return поле {@linkplain MinMaxCommand#resultMax}
    */
    public int getResultMax() {
        return resultMax;
    }
    /** Перевіряє готовність результату
    * @return false – якщо результат знайдено, інакше – true
    */
    public boolean running() {
        return progress < 100;
    }
    /** Використовується обробником потоку {@linkplain CommandQueue};
    * шаблон Worker Thread
    */
    @Override
    public void execute() {
        progress = 0;
        System.out.println("MinMax executed...");
        int idx = 0, size = viewResult.getItems().size();
        for (Item2d item : viewResult.getItems()) {
            if (item.getP() < 0) {
                if ((resultMax == -1) || 
                (viewResult.getItems().get(resultMax).getP() < item.getP())) {
                    resultMax = idx;
                }
            } else {
                if ((resultMin == -1) || 
                (viewResult.getItems().get(resultMin).getP() > item.getP())) {
                    resultMin = idx;
                }
            }
            idx++;
            progress = idx * 100 / size;
            if (idx % (size / 5) == 0) {
                System.out.println("MinMax P " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(5000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.print("MinMax P done. ");
        if (resultMin > -1) {
            System.out.print("Min P positive #" + 
            resultMin + " found: " +
            String.format("%.2f.", 
            viewResult.getItems().get(resultMin).getP()));
        } else {
            System.out.print("Min P positive not found.");
        }
        if (resultMax > -1) {
            System.out.println(" Max P negative #" + 
            resultMax + " found: " +
            String.format("%.2f.", 
            viewResult.getItems().get(resultMax).getP()));
        } else {
            System.out.println(" Max P negative item not found.");
        }
        progress = 0;
        idx = 0;
        resultMin = -1;
        resultMax = -1;
        for (Item2d item : viewResult.getItems()) {
            if (item.getS() < 0) {
                if ((resultMax == -1) || 
                (viewResult.getItems().get(resultMax).getS() < item.getS())) {
                    resultMax = idx;
                }
            } else {
                if ((resultMin == -1) || 
                (viewResult.getItems().get(resultMin).getS() > item.getS())) {
                    resultMin = idx;
                }
            }
            idx++;
            progress = idx * 100 / size;
            if (idx % (size / 5) == 0) {
                System.out.println("MinMax S " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(5000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.print("MinMax S done. ");
        if (resultMin > -1) {
            System.out.print("Min S positive #" + 
            resultMin + " found: " +
            String.format("%.2f.", 
            viewResult.getItems().get(resultMin).getS()));
        } else { 
            System.out.print("Min S positive not found.");
        }
        if (resultMax > -1) {
            System.out.println(" Max S negative #" + 
            resultMax + " found: " +
            String.format("%.2f.", 
            viewResult.getItems().get(resultMax).getS()));
        } else {
            System.out.println(" Max S negative item not found.");
        }
        progress = 0;
        idx = 0;
        resultMin = -1;
        resultMax = -1;
        for (Item2d item : viewResult.getItems()) {
            if (item.getV() < 0) {
                if ((resultMax == -1) || 
                (viewResult.getItems().get(resultMax).getV() < item.getV())) {
                    resultMax = idx;
                }
            } else {
                if ((resultMin == -1) || 
                (viewResult.getItems().get(resultMin).getV() > item.getV())) {
                    resultMin = idx;
                }
            }
            idx++;
            progress = idx * 100 / size;
            if (idx % (size / 5) == 0) {
                System.out.println("MinMax V " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(5000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.print("MinMax V done. ");
        if (resultMin > -1) {
            System.out.print("Min V positive #" + 
            resultMin + " found: " +
            String.format("%.2f.", 
            viewResult.getItems().get(resultMin).getV()));
        } else { 
            System.out.print("Min V positive not found.");
        }
        if (resultMax > -1) {
            System.out.println(" Max V negative #" + 
            resultMax + " found: " +
            String.format("%.2f.", 
            viewResult.getItems().get(resultMax).getV()));
        } else {
            System.out.println(" Max V negative item not found.");
        }
        progress = 100;
    }
    /**
    @Override
    public void run() {
    execute();
    }
    /**/
}