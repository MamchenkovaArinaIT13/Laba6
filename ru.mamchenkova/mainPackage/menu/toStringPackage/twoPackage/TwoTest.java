package ru.mamchekova.twoPackage;

/**
 * Тестовый класс для демонстрации работы аннотации @Two.
 * Содержит поля, соответствующие свойствам аннотации, и аннотирован
 * с конкретными значениями параметров.
 *
 * @author MamchenkovaArinaIT-13
 * @version 1.0
 * @since 2025
 */
@Two(first = "1", second = 2)
public class TwoTest {

  /**
   * Строковое поле, соответствующее свойству first аннотации.
   */
  private String first;

  /**
   * Числовое поле, соответствующее свойству second аннотации.
   */
  private int second;

  /**
   * Конструктор по умолчанию.
   * Инициализирует поля значениями по умолчанию.
   */
  public TwoTest() {
    this.first = null;
    this.second = 0;
  }

  /**
   * Конструктор с параметрами для инициализации всех полей объекта.
   *
   * @param first строковое значение для поля first
   * @param second целочисленное значение для поля second
   */
  public TwoTest(String first, int second) {
    this.first = first;
    this.second = second;
  }

  /**
   * Возвращает значение поля first.
   *
   * @return текущее значение поля first
   */
  public String getFirst() {
    return first;
  }

  /**
   * Устанавливает новое значение для поля first.
   *
   * @param first новое значение для поля first
   */
  public void setFirst(String first) {
    this.first = first;
  }

  /**
   * Возвращает значение поля second.
   *
   * @return текущее значение поля second
   */
  public int getSecond() {
    return second;
  }

  /**
   * Устанавливает новое значение для поля second.
   *
   * @param second новое значение для поля second
   */
  public void setSecond(int second) {
    this.second = second;
  }

  /**
   * Возвращает строковое представление объекта TwoTest.
   *
   * @return строковое представление объекта в формате "TwoTest{first='значение', second=число}"
   */
  @Override
  public String toString() {
    return "TwoTest{" +
            "first='" + first + '\'' +
            ", second=" + second +
            '}';
  }
}
