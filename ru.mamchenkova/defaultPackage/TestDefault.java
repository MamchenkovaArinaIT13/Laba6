package ru.mamchekova.defaultPackage;

/**
 * Тестовый класс для демонстрации работы аннотации @Default.
 * Класс аннотирован на уровне типа и содержит поле с аннотацией.
 *
 * @author DalerSafoevIT-13
 * @version 1.0
 * @since 2025
 */
@Default(String.class)
public class TestDefault {

  /**
   * Поле name с аннотацией @Default, указывающей на строковый тип по умолчанию.
   */
  @Default(String.class)
  private String name;

  /**
   * Конструктор по умолчанию, инициализирует поле name значением null.
   */
  public TestDefault() {
    this.name = null;
  }

  /**
   * Конструктор с параметром для инициализации поля name.
   *
   * @param name значение для инициализации поля name.
   */
  public TestDefault(String name) {
    this.name = name;
  }

  /**
   * Возвращает значение поля name.
   *
   * @return текущее значение поля name.
   */
  public String getName() {
    return name;
  }

  /**
   * Устанавливает новое значение для поля name.
   *
   * @param name новое значение для поля name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Возвращает строковое представление объекта TestDefault.
   *
   * @return строковое представление объекта в формате "TestDefault{name='значение'}".
   */
  @Override
  public String toString() {
    return "TestDefault{" +
            "name='" + name + '\'' +
            '}';
  }
}
