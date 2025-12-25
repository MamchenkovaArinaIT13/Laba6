package ru.mamchekova.twoPackage;

/**
 * Обработчик аннотации @Two для анализа классов и извлечения значений свойств аннотации.
 * Предоставляет функциональность для проверки наличия аннотации @Two
 * и вывода информации о её свойствах.
 *
 * @author MamchenkovaArinaIT-13
 * @version 1.0
 * @since 2025
 */
public class TwoHandler {

  /**
   * Анализирует класс на наличие аннотации @Two и выводит информацию о её свойствах.
   * Если аннотация присутствует, извлекает значения свойств first и second
   * и выводит их в форматированном виде.
   *
   * @param class1 класс для анализа на наличие аннотации @Two
   */
  public static void twoStart(Class<?> class1) {
    if(class1.isAnnotationPresent(Two.class)) {
      Two two = class1.getAnnotation(Two.class);
      String first = two.first();
      int second = two.second();
      System.out.println("Класс " + class1.getSimpleName() + " аннотирован @Two");
      System.out.println("first: \"" + first + "\"");
      System.out.println("second: " + second);
    } else {
      System.out.println("Класс " + class1.getSimpleName() + " не аннотирован @Two");
    }
  }
}
