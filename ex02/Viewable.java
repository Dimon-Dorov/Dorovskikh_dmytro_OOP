package ex02;
/** Creator
* (шаблон Factory Method)<br>
* Оголошує метод, 
* який "фабрикує" об'єкти
* @author xone
* @version 1.0
* @see Viewable#getView()
*/
public interface Viewable {
    /** Створює об'єкт, який реалізує {@linkplain View} */
    public View getView();
}