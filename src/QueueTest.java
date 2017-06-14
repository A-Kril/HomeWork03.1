import com.sun.istack.internal.NotNull;

import java.util.Scanner;

public class QueueTest {
    public static void queueTest() throws Exception{
        CollectionQueue <String> queueCollection = new CollectionQueue<>();
        Scanner input = new Scanner(System.in);
        queueCollection.printMenu();
        boolean test;
        System.out.println("Введите элементы коллекции.");
        do {
            try {
                @NotNull
                String choice;
                if ((choice = input.next()) != null) {
                    if (choice.equals("q")) {
                        test = false;
                        queueCollection.queueElem();
                        return;
                    }

                    if (choice.equals("Q")) {
                        test = false;
                        queueCollection.queueElem();
                        return;

                    } else {
                        queueCollection.addObject(choice);
                        queueCollection.queueElem();
                        test = true;
                    }
                }else throw new Exception();
            }
            catch (Exception e) {
                System.out.println("Ошибка! Повторите снова");
                return;
            }
        }
        while (test=true);

    }

}