package ex05;
import ex04.Command;
/** Представляє методи для встановки
* та вилучення завдань обробником потоку;
* шаблон Worker Thread
*/
public interface Queue {
    /** Додає нову задачу у чергу; шаблон Worker Thread
    * @param cmd задача
    */
    void put(Command cmd);
    /** Видаляє задачу із черги; шаблон Worker Thread
    * @return завдання, що видаляється
    */
    Command take();
}