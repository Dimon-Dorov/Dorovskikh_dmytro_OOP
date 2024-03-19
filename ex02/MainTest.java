package ex02;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import java.io.IOException;
import ex01.Item2d;
/** Виконує тестування розроблених класів.
* @author xone
* @version 2.0
*/
public class MainTest {
    /** Перевірка основної функціональності класу {@linkplain ViewResult} */
    @Test
    public void testCalc() {
        ViewResult view = new ViewResult(5);
        view.init(1.0, 1.0, 1.0);
        Item2d item = new Item2d();
        int ctr = 0;
        item.setLHWPSV(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">", 
        view.getItems().get(ctr).equals(item));

        ctr++;
        item.setLHWPSV(1.0, 1.0, 1.0, 12.0, 6.0, 1.0);
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
        view.getItems().get(ctr).equals(item));

        ctr++;
        item.setLHWPSV(2.0, 2.0, 2.0, 24.0, 24.0, 8.0);
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
        view.getItems().get(ctr).equals(item));

        ctr++;
        item.setLHWPSV(3.0, 3.0, 3.0, 36.0, 54.0, 27.0);
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
        view.getItems().get(ctr).equals(item));

        ctr++;
        item.setLHWPSV(4.0, 4.0, 4.0, 48.0, 96.0, 64.0);
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
        view.getItems().get(ctr).equals(item));
    }
    /** Перевірка серіалізації. Коректність відновлення даних. */
    @Test
    public void testRestore() {
        ViewResult view1 = new ViewResult(1000);
        ViewResult view2 = new ViewResult();
        // Обчислимо значення функції з випадковим кроком збільшення значення
        view1.init(Math.random()*100.0, Math.random()*100.0, Math.random()*100.0);
        // Збережемо колекцію view1.items
        try {
            view1.viewSave();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
        // Завантажимо колекцію view2.items
        try {
            view2.viewRestore();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        // Повинно завантажити стільки ж елементів, скільки зберегли
        assertEquals(view1.getItems().size(), view2.getItems().size());
        // Причому ці елементи мають бути рівними.
        // Для цього потрібно визначити метод equals
        assertTrue("containsAll()", view1.getItems().containsAll(view2.getItems()));
    }
}