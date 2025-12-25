package ru.mamchekova.mainPackage;

import ru.mamchekova.menuPackage.MenuAndValidator;

/**
 * Главный класс приложения, содержащий точку входа в программу.
 * Инициализирует и запускает систему меню для тестирования функциональности аннотаций.
 *
 * @author DalerSafoevIT-13
 * @version 1.0
 * @since 2025
 */
public class Main {

  /**
   * Точка входа в приложение. Создает экземпляр класса MenuAndValidator
   * и запускает основное меню программы.
   *
   * @param args аргументы командной строки (не используются).
   */
  public static void main(String[] args) {
    MenuAndValidator menu = new MenuAndValidator();
    menu.menu();
  }
}
