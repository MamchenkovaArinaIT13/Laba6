package ru.mamchekova.validatePackage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для валидации классов, указывающая список классов,
 * которые должны быть проверены при валидации аннотированного класса.
 * Может применяться как к классам, так и к другим аннотациям.
 *
 * @author MamchenkovaArinaIT-13
 * @version 1.0
 * @since 2025
 */
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {

  /**
   * Массив классов для валидации.
   * Определяет список классов, которые должны быть проверены
   * при обработке аннотированного элемента.
   *
   * @return массив классов для валидации
   */
  Class<?>[] value();
}
