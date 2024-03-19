package ex02;
/** ConcreteCreator
* (шаблон Factory Method)<br>
* Оголошує метод, 
* який "фабрикує" об'єкти
*/
public class ViewableResult implements Viewable {
    /** Створює відображаючий об'єкт {@linkplain ViewResult} */
    @Override
    public View getView() {
        return new ViewResult();
    }
}