package ru.mamchekova.menuPackage;

import ru.mamchekova.cachePackage.CacheHandler;
import ru.mamchekova.cachePackage.TestCache;
import ru.mamchekova.defaultPackage.DefaultHandler;
import ru.mamchekova.defaultPackage.TestDefault;
import ru.mamchekova.invokePackage.InvokeHandler;
import ru.mamchekova.invokePackage.TestInvoke;
import ru.mamchekova.toStringPackage.Client;
import ru.mamchekova.toStringPackage.ToStringHandler;
import ru.mamchekova.twoPackage.TwoHandler;
import ru.mamchekova.twoPackage.TwoTest;
import ru.mamchekova.validatePackage.ValidateTest;
import ru.mamchekova.validatePackage.ValidateHandler;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Класс для управления меню и валидации ввода пользователя.
 * Предоставляет интерфейс для тестирования всех реализованных аннотаций
 * с поддержкой ручного и автоматического ввода данных.
 *
 * @author MamchenkovaArinaIT-13
 * @version 1.0
 * @since 2025
 */
public class MenuAndValidator {

  /**
   * Сканер для чтения ввода пользователя из консоли.
   */
  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Основное меню программы для выбора способа ввода данных.
   * Предоставляет возможность выбора между ручным и автоматическим вводом,
   * а также выхода из программы.
   *
   * @return код выхода из меню.
   */
  public int menu() {
    while (true) {
      System.out.println("\nЗдравствуйте, это Лабораторная работа №6!");
      System.out.println("Выберите способ ввода данных:");
      System.out.println("1. Ручной ввод");
      System.out.println("2. Автоматический ввод (готовые данные)");
      System.out.println("0. Выход");

      System.out.print("Ваш выбор: ");

      if (scanner.hasNextInt()) {
        int inputMethod = scanner.nextInt();
        scanner.nextLine();

        switch (inputMethod) {
          case 1:
            return manualInputMenu(scanner);
          case 2:
            return autoInputMenu(scanner);
          case 0:
            System.out.println("Выход из программы...");
            System.exit(0);
          default:
            System.out.println("Неверный выбор способа ввода!");
            break;
        }
      } else {
        scanner.next();
        System.out.println("Неверно! Введите число от 0 до 2");
      }
    }
  }

  /**
   * Меню для ручного ввода данных пользователем.
   * Предоставляет выбор задания и обработку введенных данных.
   *
   * @param scanner сканер для чтения ввода пользователя.
   * @return код возврата в основное меню.
   */
  private int manualInputMenu(Scanner scanner) {
    while (true) {
      System.out.println("\n=== РУЧНОЙ ВВОД ===");
      System.out.println("Выберите задание (вы будете вводить данные):");
      System.out.println("1. @Invoke - вызов методов с аннотацией");
      System.out.println("2. @Default - классы и поля по умолчанию");
      System.out.println("3. @ToString - строковое представление");
      System.out.println("4. @Validate - валидация классов");
      System.out.println("5. @Two - аннотация с двумя свойствами");
      System.out.println("6. @Cache - кешируемые области");
      System.out.println("0. Назад к выбору способа ввода");
      System.out.print("Ваш выбор задания: ");

      if (scanner.hasNextInt()) {
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
          case 1:
            manualInput1();
            break;
          case 2:
            manualInput2();
            break;
          case 3:
            manualInput3();
            break;
          case 4:
            manualInput4();
            break;
          case 5:
            manualInput5();
            break;
          case 6:
            manualInput6();
            break;
          case 0:
            return menu();
          default:
            System.out.println("Неверный номер задания!");
            break;
        }
      } else {
        scanner.next();
        System.out.println("Неверно! Введите число от 0 до 6");
      }
    }
  }

  /**
   * Меню для автоматического ввода данных с использованием готовых тестовых данных.
   *
   * @param scanner сканер для чтения ввода пользователя.
   * @return код возврата в основное меню.
   */
  private int autoInputMenu(Scanner scanner) {
    while (true) {
      System.out.println("\n=== АВТОМАТИЧЕСКИЙ ВВОД ===");
      System.out.println("Выберите задание (будут использованы готовые данные):");
      System.out.println("1. @Invoke - вызов методов с аннотацией");
      System.out.println("2. @Default - классы и поля по умолчанию");
      System.out.println("3. @ToString - строковое представление");
      System.out.println("4. @Validate - валидация классов");
      System.out.println("5. @Two - аннотация с двумя свойствами");
      System.out.println("6. @Cache - кешируемые области");
      System.out.println("0. Назад к выбору способа ввода");
      System.out.print("Ваш выбор задания: ");

      if (scanner.hasNextInt()) {
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
          case 1:
            autoInput1();
            break;
          case 2:
            autoInput2();
            break;
          case 3:
            autoInput3();
            break;
          case 4:
            autoInput4();
            break;
          case 5:
            autoInput5();
            break;
          case 6:
            autoInput6();
            break;
          case 0:
            return menu();
          default:
            System.out.println("Неверный номер задания!");
            break;
        }
      } else {
        scanner.next();
        System.out.println("Неверно! Введите число от 0 до 6");
      }
    }
  }

  // ========== МЕТОДЫ ДЛЯ РУЧНОГО ВВОДА ==========

  /**
   * Обработка ручного ввода для аннотации @Invoke.
   * Создает объект TestInvoke и вызывает все методы с аннотацией @Invoke.
   */
  private void manualInput1() {
    System.out.println("\n=== @Invoke - Ручной ввод ===");
    try {
      TestInvoke testInvoke = new TestInvoke();
      System.out.println("Создан объект TestInvoke");
      System.out.println("Вызываем методы с аннотацией @Invoke...");
      InvokeHandler.InvokeStart(testInvoke);
    } catch (Exception e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }

  /**
   * Обработка ручного ввода для аннотации @Default.
   * Запрашивает имя класса и анализирует его на наличие аннотации @Default.
   */
  private void manualInput2() {
    System.out.println("\n=== @Default - Ручной ввод ===");
    System.out.print("Введите имя класса для проверки (TestDefault): ");
    String className = scanner.nextLine();

    try {
      if ("TestDefault".equals(className)) {
        DefaultHandler.DefaultStart(TestDefault.class);
      } else {
        System.out.println("Класс не найден. Используется TestDefault по умолчанию.");
        DefaultHandler.DefaultStart(TestDefault.class);
      }
    } catch (Exception e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }

  /**
   * Обработка ручного ввода для аннотации @ToString.
   * Запрашивает данные пользователя и создает объект Client с последующим
   * преобразованием в строку с учетом аннотаций.
   */
  private void manualInput3() {
    System.out.println("\n=== @ToString - Ручной ввод ===");
    System.out.print("Введите имя: ");
    String name = scanner.nextLine();

    System.out.print("Введите возраст: ");
    int age = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Введите email: ");
    String email = scanner.nextLine();

    System.out.print("Введите телефон: ");
    String phone = scanner.nextLine();

    try {
      Client client = new Client(name, age, email, phone);
      String result = ToStringHandler.toStringStart(client);
      System.out.println("Результат: " + result);
    } catch (Exception e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }

  /**
   * Обработка ручного ввода для аннотации @Validate.
   * Запрашивает имя класса и проверяет его на наличие аннотации @Validate.
   */
  private void manualInput4() {
    System.out.println("\n=== @Validate - Ручной ввод ===");
    System.out.print("Введите имя класса для валидации (ValidateTest): ");
    String className = scanner.nextLine();

    try {
      if ("ValidateTest".equals(className)) {
        ValidateHandler.ValidateStart(ValidateTest.class);
      } else {
        System.out.println("Класс не найден. Используется ValidateTest по умолчанию.");
        ValidateHandler.ValidateStart(ValidateTest.class);
      }
    } catch (Exception e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }

  /**
   * Обработка ручного ввода для аннотации @Two.
   * Запрашивает имя класса и анализирует его на наличие аннотации @Two.
   */
  private void manualInput5() {
    System.out.println("\n=== @Two - Ручной ввод ===");
    System.out.print("Введите имя класса (TwoTest): ");
    String className = scanner.nextLine();

    try {
      if ("TwoTest".equals(className)) {
        TwoHandler.twoStart(TwoTest.class);
      } else {
        System.out.println("Класс не найден. Используется TwoTest по умолчанию.");
        TwoHandler.twoStart(TwoTest.class);
      }
    } catch (Exception e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }

  /**
   * Обработка ручного ввода для аннотации @Cache.
   * Запрашивает имя класса и анализирует его на наличие аннотации @Cache.
   */
  private void manualInput6() {
    System.out.println("\n=== @Cache - Ручной ввод ===");
    System.out.print("Введите имя класса (TestCache): ");
    String className = scanner.nextLine();

    try {
      if ("TestCache".equals(className)) {
        CacheHandler.startCache(TestCache.class);
      } else {
        System.out.println("Класс не найден. Используется TestCache по умолчанию.");
        CacheHandler.startCache(TestCache.class);
      }
    } catch (Exception e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }

  // ========== МЕТОДЫ ДЛЯ АВТОМАТИЧЕСКОГО ВВОДА ==========

  /**
   * Автоматический тест для аннотации @Invoke с готовыми данными.
   */
  private void autoInput1() {
    System.out.println("\n=== @Invoke - Автоматический ввод ===");
    try {
      TestInvoke testInvoke = new TestInvoke();
      System.out.println("Создан объект TestInvoke с готовыми данными");
      System.out.println("Вызываем методы с аннотацией @Invoke...");
      InvokeHandler.InvokeStart(testInvoke);
    } catch (Exception e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }

  /**
   * Автоматический тест для аннотации @Default с готовыми данными.
   */
  private void autoInput2() {
    System.out.println("\n=== @Default - Автоматический ввод ===");
    try {
      System.out.println("Используется класс TestDefault с аннотацией @Default(String.class)");
      DefaultHandler.DefaultStart(TestDefault.class);
    } catch (Exception e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }

  /**
   * Автоматический тест для аннотации @ToString с готовыми данными.
   */
  private void autoInput3() {
    System.out.println("\n=== @ToString - Автоматический ввод ===");
    try {
      Client client = new Client("Далер", 19, "dsafoev40@gmail.com", "+79655666091");
      System.out.println("Создан объект Client с готовыми данными:");
      System.out.println("Имя: Далер, Возраст: 19, Email: dsafoev40@gmail.com, Телефон: +79655666091");
      String result = ToStringHandler.toStringStart(client);
      System.out.println("Результат: " + result);
    } catch (Exception e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }

  /**
   * Автоматический тест для аннотации @Validate с готовыми данными.
   */
  private void autoInput4() {
    System.out.println("\n=== @Validate - Автоматический ввод ===");
    try {
      System.out.println("Используется класс ValidateTest с аннотацией @Validate({String.class, Integer.class})");
      ValidateHandler.ValidateStart(ValidateTest.class);
    } catch (Exception e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }

  /**
   * Автоматический тест для аннотации @Two с готовыми данными.
   */
  private void autoInput5() {
    System.out.println("\n=== @Two - Автоматический ввод ===");
    try {
      System.out.println("Используется класс TwoTest с аннотацией @Two(first = \"1\", second = 2)");
      TwoHandler.twoStart(TwoTest.class);
    } catch (Exception e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }

  /**
   * Автоматический тест для аннотации @Cache с готовыми данными.
   */
  private void autoInput6() {
    System.out.println("\n=== @Cache - Автоматический ввод ===");
    try {
      System.out.println("Используется класс TestCache с аннотацией @Cache(['clientData','sessionData','applicationData'])");
      CacheHandler.startCache(TestCache.class);
    } catch (Exception e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }
}
