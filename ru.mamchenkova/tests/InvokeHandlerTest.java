package ru.mamchekova.invokePackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Тестовый класс для проверки работы аннотации @Invoke и обработчика InvokeHandler.
 * Содержит тесты для проверки корректного вызова методов с аннотацией @Invoke
 * и проверки изменений состояния объекта после вызова методов.
 *
 * @author MamchenkovaArinaIT-13
 * @version 1.0
 * @since 2025
 */
public class InvokeHandlerTest {

  /**
   * Тестовый объект для проверки работы аннотации @Invoke.
   */
  private TestInvoke testInvoke;

  /**
   * Метод, выполняемый перед каждым тестом.
   * Создает новый экземпляр TestInvoke для изоляции тестов.
   */
  @BeforeEach
  public void createObject() {
    testInvoke = new TestInvoke();
  }

  /**
   * Комплексный тест для проверки работы аннотации @Invoke.
   * Проверяет корректный вызов всех методов с аннотацией @Invoke,
   * возвращаемые значения методов и изменения состояния объекта.
   */
  @Test
  public void test1() {
    // Получение методов через Reflection API
    Class<?> invokeClass = testInvoke.getClass();
    Method[] methods = invokeClass.getDeclaredMethods();
    int initialNum = testInvoke.getNum();

    // Проверка вызова всех методов с аннотацией @Invoke без исключений
    for (Method method : methods) {
      if(method.isAnnotationPresent(Invoke.class)) {
        Assertions.assertDoesNotThrow(() -> {
          method.setAccessible(true);
          method.invoke(testInvoke);
        });
      }
    }

    // Проверка возвращаемого значения метода Test2
    Assertions.assertEquals(232, testInvoke.Test2());

    // Проверка изменения состояния объекта после вызова методов
    Assertions.assertEquals(initialNum + 1, testInvoke.getNum());
  }
}
