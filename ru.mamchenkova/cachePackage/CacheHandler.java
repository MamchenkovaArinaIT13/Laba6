package ru.mamchekova.cachePackage;

/**
 * Обработчик аннотации @Cache для анализа классов и извлечения информации
 * о кешируемых областях. Предоставляет функциональность для проверки
 * наличия аннотации @Cache и вывода списка областей кеширования.
 *
 * @author DalerSafoevIT-13
 * @version 1.0
 * @since 2025
 */
public class CacheHandler {

  /**
   * Анализирует класс на наличие аннотации @Cache и выводит информацию
   * о кешируемых областях. Если аннотация присутствует, извлекает
   * массив областей кеширования и выводит их в нумерованном списке.
   *
   * @param class1 класс для анализа на наличие аннотации @Cache
   */
  public static void startCache(Class<?> class1) {
    Cache cache = class1.getAnnotation(Cache.class);
    if (cache == null) {
      System.out.println("Класс " + class1.getSimpleName() + " не аннотирован @Cache");
      return;
    }
    String[] cacheAreas = cache.value();
    if (cacheAreas.length == 0) {
      System.out.println("Класс " + class1.getSimpleName() + ": список кешируемых областей пуст");
    } else {
      System.out.println("Класс " + class1.getSimpleName() + " - кешируемые области:");
      for (int i = 0; i < cacheAreas.length; i++) {
        System.out.println("  " + (i + 1) + ". " + cacheAreas[i]);
      }
    }
  }
}
