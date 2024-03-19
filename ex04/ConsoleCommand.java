package ex04;
/** Інтерфейс
* консольної команди;
* шаблон Command
* @author xone
* @version 1.0
*/
public interface ConsoleCommand extends Command {
    /** Горяча клавіша команди;
    * шаблон Command
    * @return символ горячої клавіши
    */
    public char getKey();
}