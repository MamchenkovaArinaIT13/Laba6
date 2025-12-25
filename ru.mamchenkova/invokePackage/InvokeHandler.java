package ru.mamchekova.invokePackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Обработчик для вызова методов с аннотацией @Invoke.
 * Использует механизм рефлексии для автоматического вызова всех методов,
 * помеченных аннотацией @Invoke у переданного объекта.
 *
 * @author DalerSafoevIT-13
 * @version 1.0
 * @since 2025
 */
public class InvokeHandler {

  /**
   * Вызывает все методы с аннотацией @Invoke у переданного объекта.
   * Методы вызываются независимо от их модификатора доступа (public, private, protected).
   *
   * @param object объект, методы которого нужно вызвать.
   * @throws InvocationTargetException если произошла ошибка при вызове метода через рефлексию.
   * @throws IllegalAccessException если нет доступа к методу через рефлексию.
   */
  public static void InvokeStart(Object object) throws InvocationTargetException, IllegalAccessException {
    Class<?> classInvoke = object.getClass();

    Method[] methods = classInvoke.getDeclaredMethods();
    for (Method method : methods) {
      if(method.isAnnotationPresent(Invoke.class)) {
        method.setAccessible(true);
        System.out.print("Метод " + "\"" + method.getName() + "\""  + " (модификатор доступа: " + method.getModifiers() + ")" + " имеет аннотацию @Invoke, поэтому вызываем его: ");
        method.invoke(object);
        method.setAccessible(false);
      }
    }
  }
}
