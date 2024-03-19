package ex03;
import ex02.View;
/** Обчислення та відображення результатів<br>
* Реалізація статичного методу main()
* @author xone
* @version 3.0
* @see Main#main
*/
public class Main extends ex02.Main {
/** Ініціалізує поле {@linkplain ex02.Main#view view} */
    public Main(View view) {
        super(view);
    }

    public static void main(String[] args) {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}