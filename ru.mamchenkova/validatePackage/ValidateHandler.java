package ru.mamchekova.validatePackage;

/**
 * Обработчик аннотации @Validate для анализа классов и извлечения информации
 * о классах валидации. Предоставляет функциональность для проверки
 * наличия аннотации @Validate и вывода списка классов для валидации.
 *
 * @author MamchenkovaArinaIT-13
 * @version 1.0
 * @since 2025
 */
public class ValidateHandler {

  /**
   * Анализирует класс на наличие аннотации @Validate и выводит информацию
   * о классах для валидации. Проверяет, что массив классов не пустой,
   * и выводит подробную информацию о каждом классе.
   *
   * @param classes класс для анализа на наличие аннотации @Validate
   * @throws IllegalArgumentException если массив классов для валидации пустой
   */
  public static void ValidateStart(Class<?> classes) {
    if (classes.isAnnotationPresent(Validate.class)) {
      Validate validateAnnotation = classes.getAnnotation(Validate.class);
      Class<?>[] validationClasses = validateAnnotation.value();

      // Проверка на пустой массив классов
      if(validationClasses.length == 0) {
        throw new IllegalArgumentException("Массив классов для валидации не может быть пустым!");
      }

      System.out.println("Класс " + classes.getSimpleName() + " помечен @Validate");
      System.out.println("Список классов для проверки:");

      // Вывод информации о каждом классе валидации
      for (int i = 0; i < validationClasses.length; i++) {
        Class<?> validationClass = validationClasses[i];
        System.out.println((i + 1) + ". " + validationClass.getName() +
                " (простое имя: " + validationClass.getSimpleName() + ")");
      }

      System.out.println("Всего классов: " + validationClasses.length);
    } else {
      System.out.println("Класс " + classes.getSimpleName() + " не аннотирован @Validate");
    }
  }
}
