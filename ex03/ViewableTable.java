package ex03;
import ex02.ViewableResult;
import ex02.View;
/** ConcreteCreator
* (шаблон Factory Method)<br>
* Оголошує метод, 
* який "фабрикує" об'єкти
* @author xone
* @version 1.0
* @see ViewableResult
* @see ViewableTable#getView()
*/
public class ViewableTable extends ViewableResult {
/** Створює відображаючий об'єкт {@linkplain ViewTable} */
    @Override
    public View getView() {
        return new ViewTable();
    }
}