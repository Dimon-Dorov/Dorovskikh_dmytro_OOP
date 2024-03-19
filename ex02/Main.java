package ex02;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/** Обчислення та відображення результатів<br>
* Реалізація статичного методу main() 
* @author xone
* @version 2.0
* @see Main#main
*/
public class Main {
/** Реалізує інтерфейс {@linkplain View};
* обробляє колекцію {@linkplain ex01.Item2d}
*/
    private View view;
    /** Ініціалізація поля {@linkplain Main#view view}. */
    public Main(View view) {
    this.view = view;
    }
    /** Відображення меню. */
    protected void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
        do {
            System.out.println("Enter command...");
            System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
            try {
            s = in.readLine();
            } catch(IOException e) {
            System.out.println("Error: " + e);
            System.exit(0);
            }
        } while (s.length() != 1);
        switch (s.charAt(0)) {
        case 'q':
            System.out.println("Exit.");
            break;
        case 'v':
            System.out.println("View current.");
            view.viewShow();
            break;
        case 'g':
            System.out.println("Random generation.");
            view.viewInit();
            view.viewShow();
            break;
        case 's':
            System.out.println("Save current.");
            try {
                view.viewSave();
            } catch (IOException e) {
                System.out.println("Serialization error: " + e);
            }
            view.viewShow();
            break;
        case 'r':
            System.out.println("Restore last saved.");
            try {
                view.viewRestore();
            } catch (Exception e) {
                System.out.println("Serialization error: " + e);
            }
            view.viewShow();
            break;
        default:
        System.out.println("Wrong command.");
        }
        }
        while(s.charAt(0) != 'q');
    }/** Виконується при виконанні програми;
    * визиває {@linkplain Main#menu() menu()}
    */
    public static void main(String[] args) {
        Main main = new Main(new ViewableResult().getView());
        main.menu();
    }
}