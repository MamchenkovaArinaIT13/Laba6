package ru.mamchekova.defaultPackage;

import java.lang.reflect.Field;

/**
 * Обработчик аннотации @Default для анализа классов и полей.
 * Предоставляет функциональность для проверки наличия аннотации @Default
 * и вывода информации о аннотированных элементах.
 *
 * @author MamchenkovaArinaIT-13
 * @version 1.0
 * @since 2025
 */
public class DefaultHandler {

  /**
   * Анализирует класс на наличие аннотаций @Default и выводит информацию
   * о аннотированных элементах. Проверяет как сам класс, так и его поля.
   *
   * @param class1 класс для анализа на наличие аннотаций @Default.
   */
  public static void DefaultStart(Class<?> class1) {

    Class<?> classDefault = class1.getClass();

    System.out.println("Имя класса: " + classDefault.getSimpleName());

    if (classDefault.isAnnotationPresent(Default.class)) {
      Default annotation = classDefault.getAnnotation(Default.class);
      Class<?> defaultClass = annotation.value();
      System.out.println("Класс имеет аннотацию @Default с типом: " + defaultClass.getSimpleName());
    } else {
      System.out.println("Класс не имеет аннотации @Default на типе");
    }

    Field[] fields = classDefault.getDeclaredFields();
    for (Field field : fields) {
      if(field.isAnnotationPresent(Default.class)) {
        System.out.println("Поле " + "\"" + field.getName() + "\"" + " имеет аннотацию @Default");
      }
    }
  }
}
