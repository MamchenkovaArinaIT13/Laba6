package ru.mamchekova.twoPackage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация с двумя свойствами разных типов для маркировки классов.
 * Демонстрирует использование аннотаций с обязательными параметрами.
 *
 * @author MamchenkovaArinaIT-13
 * @version 1.0
 * @since 2025
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {

  /**
   * Строковое свойство аннотации.
   * Обязательный параметр без значения по умолчанию.
   *
   * @return строковое значение свойства first
   */
  String first();

  /**
   * Числовое свойство аннотации.
   * Обязательный параметр без значения по умолчанию.
   *
   * @return целочисленное значение свойства second
   */
  int second();
}
