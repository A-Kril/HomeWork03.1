import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

public class CollectionQueue<E> {
    Queue<E> queue = new LinkedList<E>();
    Scanner elem;
    int size;

    public void printMenu() throws Exception{
        System.out.println("Задайте размер коллекции: ");
        System.out.println("1: по умолчанию 16.");
        System.out.println("2: по указанию пользователя.");
        optionMenu();
    }

    public void optionMenu() throws Exception{
        elem = new Scanner(System.in);
        String a = elem.next();
        switch (a) {
            case "1":
                fixedSize();
                break;
            case "2":
                specifiedSize();
                break;
            default:
                notSize();
                break;
        }
    }

    public E addObject(E object) {
        if (queue.size() < size) {
            queue.offer(object);
        }else {
            queue.poll();
            queue.offer(object);
        }
        return object;
    }

    public void queueElem(){
        System.out.println(queue + " - выход \"Q\"");
    }

    public void fixedSize(){
        size = 16;
    }

    public void specifiedSize() throws Exception {
        System.out.println("Введите размер коллекции: ");
        try {
            if (elem.hasNext()){
                size = elem.nextInt();
                if (size < 1) throw new Exception();
                {
                    System.out.println("Размер коллекции [" + size + "], после инициализации не меняется.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка! Введите число > 0. " + e);
            elem.next();
            specifiedSize();
        } catch (Exception ex) {
            System.out.println("Ошибка! Введите число > 0. " + ex);
            specifiedSize();
        }
    }

    public void notSize() throws Exception{
        System.out.println("Ошибка! Повтор: введите 1 или 2...");
        optionMenu();
    }
}