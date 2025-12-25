package ru.mamchekova.cachePackage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для маркировки классов, указывающая кешируемые области.
 * Позволяет определить список областей, которые должны кешироваться
 * для аннотированного класса.
 *
 * @author MamchenkovaArinaIT-13
 * @version 1.0
 * @since 2025
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {

  /**
   * Массив строк с названиями кешируемых областей.
   * Каждая строка представляет отдельную область кеширования.
   *
   * @return массив названий областей кеширования (по умолчанию пустой массив)
   */
  String[] value() default {};
}
