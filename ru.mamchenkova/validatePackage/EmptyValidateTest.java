package ru.mamchekova.validatePackage;

/**
 * Тестовый класс для демонстрации обработки пустого массива классов
 * в аннотации @Validate. Используется для тестирования исключительных
 * ситуаций при валидации.
 *
 * @author MamchenkovaArinaIT-13
 * @version 1.0
 * @since 2025
 */
@Validate({})
public class EmptyValidateTest {

  /**
   * Заголовок тестового объекта.
   */
  private String title;

  /**
   * Продолжительность тестового объекта.
   */
  private int duration;

  /**
   * Конструктор по умолчанию.
   * Инициализирует поля значениями по умолчанию.
   */
  public EmptyValidateTest() {
    this.title = null;
    this.duration = 0;
  }

  /**
   * Конструктор с параметрами для инициализации всех полей объекта.
   *
   * @param title заголовок тестового объекта
   * @param duration продолжительность тестового объекта
   */
  public EmptyValidateTest(String title, int duration) {
    this.title = title;
    this.duration = duration;
  }

  /**
   * Возвращает заголовок тестового объекта.
   *
   * @return текущий заголовок тестового объекта
   */
  public String getTitle() {
    return title;
  }

  /**
   * Устанавливает новый заголовок тестового объекта.
   *
   * @param title новый заголовок тестового объекта
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Возвращает продолжительность тестового объекта.
   *
   * @return текущая продолжительность тестового объекта
   */
  public int getDuration() {
    return duration;
  }

  /**
   * Устанавливает новую продолжительность тестового объекта.
   *
   * @param duration новая продолжительность тестового объекта
   */
  public void setDuration(int duration) {
    this.duration = duration;
  }

  /**
   * Возвращает строковое представление объекта EmptyValidateTest.
   *
   * @return строковое представление объекта в формате "Test1{title='значение', duration=число}"
   */
  @Override
  public String toString() {
    return "Test1{" +
            "title='" + title + '\'' +
            ", duration=" + duration +
            '}';
  }
}
