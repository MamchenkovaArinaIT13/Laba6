package ru.mamchekova.invokePackage;

/**
 * Тестовый класс с различными методами, помеченными аннотацией @Invoke.
 * Демонстрирует работу аннотации @Invoke с методами разных модификаторов доступа
 * и типами возвращаемых значений.
 *
 * @author MamchenkovaArinaIT-13
 * @version 1.0
 * @since 2025
 */
public class TestInvoke {

  /**
   * Числовое поле для тестирования изменений состояния объекта после вызова методов.
   */
  private int num = 1;

  /**
   * Public нестатический метод без возвращаемого значения.
   * Изменяет состояние объекта, устанавливая значение поля num = 2.
   */
  @Invoke
  public void Test1() {
    System.out.println("Вызвали public void тест под номером один!");
    this.num = 2;
  }

  /**
   * Public нестатический метод с возвращаемым значением.
   * Возвращает целочисленное значение 232.
   *
   * @return целое число 232.
   */
  @Invoke
  public int Test2() {
    System.out.println("Вызвали public int тест под номером два!");
    return 232;
  }

  /**
   * Public нестатический метод без возвращаемого значения.
   * Выводит сообщение в консоль.
   */
  @Invoke
  public void Test3() {
    System.out.println("Вызвали public void тест под номером три!");
  }

  /**
   * Public статический метод без возвращаемого значения.
   * Выводит сообщение в консоль.
   */
  @Invoke
  public static void Test4() {
    System.out.println("Вызвали public static void тест под номером четыре!");
  }

  /**
   * Private нестатический метод без возвращаемого значения.
   * Выводит сообщение в консоль.
   */
  @Invoke
  private void Test5() {
    System.out.println("Вызвали private void тест под номером пять!");
  }

  /**
   * Private статический метод без возвращаемого значения.
   * Выводит сообщение в консоль.
   */
  @Invoke
  private static void Test6() {
    System.out.println("Вызвали private static void тест под номером шесть!");
  }

  /**
   * Protected нестатический метод без возвращаемого значения.
   * Выводит сообщение в консоль.
   */
  @Invoke
  protected void Test7() {
    System.out.println("Вызвали protected void тест под номером семь!");
  }

  /**
   * Protected статический метод без возвращаемого значения.
   * Выводит сообщение в консоль.
   */
  @Invoke
  protected static void Test8() {
    System.out.println("Вызвали protected static void тест под номером восемь!");
  }

  /**
   * Возвращает текущее значение поля num.
   *
   * @return текущее значение поля num.
   */
  public int getNum() {
    return this.num;
  }
}
