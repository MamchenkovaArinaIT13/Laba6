package ru.mamchekova.toStringPackage;

/**
 * Класс Client для демонстрации работы аннотации @ToString.
 * Содержит поля с различными настройками аннотаций для кастомного
 * строкового представления объекта.
 *
 * @author MamchenkovaArinaIT-13
 * @version 1.0
 * @since 2025
 */
@ToString
public class Client {

  /**
   * Имя клиента с явным указанием включения в строковое представление.
   */
  @ToString(ToString.Mode.YES)
  private String name;

  /**
   * Возраст клиента без явной аннотации (использует режим по умолчанию).
   */
  private int age;

  /**
   * Email клиента с явным указанием включения в строковое представление.
   */
  @ToString(ToString.Mode.YES)
  private String email;

  /**
   * Телефон клиента с явным указанием исключения из строкового представления.
   */
  @ToString(ToString.Mode.NO)
  private String phone;

  /**
   * Конструктор по умолчанию.
   * Создает объект Client с неинициализированными полями.
   */
  public Client() {}

  /**
   * Конструктор с параметрами для инициализации всех полей объекта.
   *
   * @param name имя клиента
   * @param age возраст клиента
   * @param email email клиента
   * @param phone телефон клиента
   */
  public Client(String name, int age, String email, String phone) {
    this.name = name;
    this.age = age;
    this.email = email;
    this.phone = phone;
  }

  /**
   * Возвращает имя клиента.
   *
   * @return имя клиента
   */
  public String getName() {
    return name;
  }

  /**
   * Устанавливает новое имя клиента.
   *
   * @param name новое имя клиента
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Возвращает возраст клиента.
   *
   * @return возраст клиента
   */
  public int getAge() {
    return age;
  }

  /**
   * Устанавливает новый возраст клиента.
   *
   * @param age новый возраст клиента
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * Возвращает email клиента.
   *
   * @return email клиента
   */
  public String getEmail() {
    return email;
  }

  /**
   * Устанавливает новый email клиента.
   *
   * @param email новый email клиента
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Возвращает телефон клиента.
   *
   * @return телефон клиента
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Устанавливает новый телефон клиента.
   *
   * @param phone новый телефон клиента
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }
}
