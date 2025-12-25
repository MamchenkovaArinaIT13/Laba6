package ru.mamchekova.cachePackage;

/**
 * Тестовый класс для демонстрации работы аннотации @Cache.
 * Содержит основные поля пользовательских данных и аннотирован
 * с указанием трех областей кеширования.
 *
 * @author DalerSafoevIT-13
 * @version 1.0
 * @since 2025
 */
@Cache({"clientData","sessionData","applicationData"})
public class TestCache {

  /**
   * Имя пользователя для хранения в кешируемых данных.
   */
  private String userName;

  /**
   * Идентификатор клиента для хранения в кешируемых данных.
   */
  private int clientId;

  /**
   * Конструктор по умолчанию.
   * Инициализирует поля значениями по умолчанию.
   */
  public TestCache() {
    this.userName = null;
    this.clientId = 0;
  }

  /**
   * Конструктор с параметрами для инициализации всех полей объекта.
   *
   * @param userName имя пользователя
   * @param clientId идентификатор клиента
   */
  public TestCache(String userName, int clientId) {
    this.userName = userName;
    this.clientId = clientId;
  }

  /**
   * Возвращает имя пользователя.
   *
   * @return текущее имя пользователя
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Устанавливает новое имя пользователя.
   *
   * @param userName новое имя пользователя
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Возвращает идентификатор клиента.
   *
   * @return текущий идентификатор клиента
   */
  public int getClientId() {
    return clientId;
  }

  /**
   * Устанавливает новый идентификатор клиента.
   *
   * @param clientId новый идентификатор клиента
   */
  public void setClientId(int clientId) {
    this.clientId = clientId;
  }
}
