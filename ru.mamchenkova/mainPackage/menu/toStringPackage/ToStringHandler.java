package ru.mamchekova.toStringPackage;

import java.lang.reflect.Field;

/**
 * Обработчик для генерации строкового представления объектов
 * на основе аннотаций @ToString. Использует механизм рефлексии
 * для анализа аннотаций и построения кастомной строки.
 *
 * @author MamchenkovaArinaIT-13
 * @version 1.0
 * @since 2025
 */
public class ToStringHandler {

  /**
   * Генерирует строковое представление объекта на основе аннотаций @ToString.
   * Анализирует аннотации на уровне класса и полей, включая в результат
   * только те поля, которые помечены режимом YES.
   *
   * @param object объект для преобразования в строку
   * @return строковое представление объекта в формате "ClassName{field1=value1, field2=value2}"
   * @throws IllegalAccessException если нет доступа к полям объекта через рефлексию
   */
  public static String toStringStart(Object object) throws IllegalAccessException {
    Class<?> classObject = object.getClass();
    StringBuilder clientString = new StringBuilder();

    // Проверка наличия аннотации на классе
    if (!classObject.isAnnotationPresent(ToString.class)) {
      return "На классе нет аннотации ToString!";
    }

    clientString.append(classObject.getSimpleName()).append("{");

    // Получение аннотации класса и режима по умолчанию
    ToString classAnnotation = classObject.getAnnotation(ToString.class);
    ToString.Mode defaultMode = classAnnotation.value();

    Field[] fields = classObject.getDeclaredFields();
    boolean firstField = true;

    // Обработка каждого поля класса
    for (Field field : fields) {
      ToString.Mode fieldMode = defaultMode;

      // Если поле имеет свою аннотацию, используем её
      if (field.isAnnotationPresent(ToString.class)) {
        ToString fieldAnnotation = field.getAnnotation(ToString.class);
        fieldMode = fieldAnnotation.value();
      }

      // Включение поля в строковое представление если режим YES
      if (fieldMode == ToString.Mode.YES) {
        field.setAccessible(true);
        Object value = field.get(object);

        // Добавление разделителя для всех полей кроме первого
        if (!firstField) {
          clientString.append(", ");
        }

        clientString.append(field.getName()).append("=").append(value);
        firstField = false;
      }
    }

    clientString.append("}");
    return clientString.toString();
  }
}
