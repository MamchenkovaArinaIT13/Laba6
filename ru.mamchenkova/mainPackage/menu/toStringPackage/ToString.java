package ru.mamchekova.toStringPackage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для кастомного строкового представления объектов.
 * Позволяет управлять включением полей в строковое представление
 * как на уровне класса, так и на уровне отдельных полей.
 *
 * @author MamchenkovaArinaIT-13
 * @version 1.0
 * @since 2025
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {

  /**
   * Перечисление режимов отображения полей в строковом представлении.
   */
  enum Mode{
    /** Включать поле в строковое представление */
    YES,
    /** Исключать поле из строкового представления */
    NO
  }

  /**
   * Определяет режим отображения для аннотированного элемента.
   * Для класса устанавливает режим по умолчанию для всех полей.
   * Для поля переопределяет режим, установленный на уровне класса.
   *
   * @return режим отображения элемента (по умолчанию YES)
   */
  Mode value() default Mode.YES;
}
