import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

public class CollectionQueue<E> {
    Queue<E> queue = new LinkedList<E>();
    Scanner elem;
    int size;

    public void printMenu() {
        System.out.println("Задайте размер коллекции: ");
        System.out.println("1: по умолчанию 16.");
        System.out.println("2: по указанию пользователя.");
        optionMenu();
    }

    public void optionMenu(){
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

    public void specifiedSize(){
        System.out.println("Введите размер коллекции: ");
        try{
            if (elem.hasNext()) {
                size = elem.nextInt();
                if (size > 0) {
                    System.out.println("Размер коллекции [" + size + "], после инициализации не меняется.");
                }
                else {
                    System.out.println("Ошибка! Введите число > 0.");
                    specifiedSize();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка! Введите число > 0. " + e);
            elem.next();
            specifiedSize();
        }
    }

    public void notSize(){
        System.out.println("Ошибка! Повтор: введите 1 или 2...");
        optionMenu();

    }
}