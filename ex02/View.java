package ex02;
import java.io.IOException;
/** Product
* (шаблон Factory Method)<br>
* Інтерфейс "фабрикуючих"
* об'єктів<br>
* Оголошує методи
* відображення об'єктів
* @author xone
* @version 1.0
*/
public interface View {
    /** Відображає заголовок */
    public void viewHeader();
    /** Відображає основну частину */
    public void viewBody();
    /** Відображає закінчення */
    public void viewFooter();
    /** Відображає об'єкт */
    public void viewShow();
    /** Виконує ініціалізацію */
    public void viewInit();
    /** Зберігає дані */
    public void viewSave() throws IOException;
    /** Відновлює збережені дані */
    public void viewRestore() throws Exception;
}