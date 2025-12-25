package ru.mamchekova.defaultPackage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания классов и полей по умолчанию.
 * Может применяться как к классам, так и к отдельным полям.
 *
 * @author DalerSafoevIT-13
 * @version 1.0
 * @since 2025
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {
  /**
   * Определяет класс по умолчанию для аннотированного элемента.
   *
   * @return класс по умолчанию для аннотированного элемента.
   */
  Class<?> value();
}
