package ex04;
import ex01.Item2d;
import ex02.View;
import ex02.ViewResult;
/** Консольна команда
* Change item;
* шаблон Command
* @author xone
* @version 1.0
*/
public class ChangeConsoleCommand
extends ChangeItemCommand
implements ConsoleCommand {
    /** Об'єкт, реалізуючий інтерфейс {@linkplain View};
    * обслуговує колекцію об'єктів {@linkplain ex01.Item2d}
    */
    private View view;
    public View getView() {
        return view;
    }

    public View setView(View view) {
        return this.view = view;
    }
    /** Ініціалізує поле {@linkplain ChangeConsoleCommand#view}
    * @param view об'єкт, реалізуючий інтерфейс {@linkplain View}
    */
    public ChangeConsoleCommand(View view) {
        this.view = view;
    }
    @Override
    public char getKey() {
        return 'c';
    }
    @Override
    public String toString() {
        return "'c'hange";
    }
    @Override
    public void execute() {
        System.out.println("Change item: scale factor " + setOffset(Math.random() * 100.0));
        for (Item2d item : ((ViewResult)view).getItems()) {
            super.setItem(item);
            super.execute();
        }
        view.viewShow();
    }
}