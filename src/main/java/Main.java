import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Введите размер списка: ");
            int size = sc.nextInt();

            System.out.print("Введите верхнюю границу для значений: ");
            int maxValue = sc.nextInt();

            List<Integer> source = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                source.add(random.nextInt(maxValue + 1));
            }

            logger.log("Создаём и наполняем список");
            System.out.println("Вот случайный список: " + StringUtils.join(source, " "));

            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.print("Введите порог для фильтра: ");
            int treshold = sc.nextInt();

            logger.log("Запускаем фильтрацию");
            Filter filter = new Filter(treshold);
            List<Integer> filteredList = filter.filterOut(source);

            logger.log("Выводим результат на экран");
            System.out.println("Отфильтрованный список: " + StringUtils.join(filteredList, " "));

            logger.log("Завершаем программу");
        }
    }
}