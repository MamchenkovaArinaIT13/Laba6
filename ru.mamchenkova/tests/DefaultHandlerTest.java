package ru.mamchekova.defaultPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки работы аннотации @Default и обработчика DefaultHandler.
 * Содержит тесты для проверки корректности аннотации, извлечения значений
 * и обработки Reflection API.
 *
 * @author MamchenkovaArinaIT-13
 * @version 1.0
 * @since 2025
 */
class DefaultHandlerTest {

    /**
     * Тест для проверки корректности аннотации @Default на уровне класса.
     * Проверяет наличие аннотации и соответствие значения ожидаемому классу.
     */
    @Test
    void correctClassAnnotationTest() {
        // Получаем аннотацию с класса
        Default annotation = TestDefault.class.getAnnotation(Default.class);

        // Проверяем наличие аннотации
        assertNotNull(annotation, "Класс должен иметь аннотацию @Default");

        // Проверяем значение аннотации
        Class<?> defaultClass = annotation.value();
        assertEquals(String.class, defaultClass,
                "Значение аннотации должно быть String.class");

        System.out.println("Класс " + TestDefault.class.getSimpleName() +
                " имеет аннотацию @Default с типом: " + defaultClass.getSimpleName());
    }

    /**
     * Тест для проверки корректности аннотации @Default на поле.
     * Проверяет наличие аннотации на поле и соответствие значения ожидаемому классу.
     */
    @Test
    void correctFieldAnnotationTest() throws NoSuchFieldException {
        // Получаем поле name
        Field nameField = TestDefault.class.getDeclaredField("name");

        // Проверяем наличие аннотации на поле
        assertTrue(nameField.isAnnotationPresent(Default.class),
                "Поле 'name' должно иметь аннотацию @Default");

        // Получаем аннотацию с поля
        Default annotation = nameField.getAnnotation(Default.class);
        assertNotNull(annotation, "Аннотация @Default должна присутствовать на поле");

        // Проверяем значение аннотации
        Class<?> defaultClass = annotation.value();
        assertEquals(String.class, defaultClass,
                "Значение аннотации на поле должно быть String.class");

        System.out.println("Поле '" + nameField.getName() +
                "' имеет аннотацию @Default с типом: " + defaultClass.getSimpleName());
    }

    /**
     * Тест для проверки Reflection API - получение аннотации через Reflection.
     * Проверяет, что Reflection корректно возвращает экземпляр аннотации.
     */
    @Test
    void reflectionAnnotationRetrievalTest() {
        // Проверка аннотации на классе через Reflection
        Default classAnnotation = TestDefault.class.getAnnotation(Default.class);
        assertNotNull(classAnnotation, "Reflection должен возвращать аннотацию для класса");

        // Проверка значения через Reflection
        Class<?> classValue = classAnnotation.value();
        assertEquals(String.class, classValue,
                "Reflection должен возвращать правильное значение аннотации для класса");

        System.out.println("Reflection корректно вернул аннотацию для класса: " +
                classValue.getSimpleName());
    }

    /**
     * Тест для проверки Reflection API - получение аннотации с поля через Reflection.
     */
    @Test
    void reflectionFieldAnnotationRetrievalTest() throws NoSuchFieldException {
        Field nameField = TestDefault.class.getDeclaredField("name");

        // Проверяем, что поле аннотировано
        assertTrue(nameField.isAnnotationPresent(Default.class),
                "Reflection должен определять наличие аннотации на поле");

        // Получаем аннотацию через Reflection
        Default fieldAnnotation = nameField.getAnnotation(Default.class);
        assertNotNull(fieldAnnotation, "Reflection должен возвращать аннотацию для поля");

        // Проверяем значение аннотации
        Class<?> fieldValue = fieldAnnotation.value();
        assertEquals(String.class, fieldValue,
                "Reflection должен возвращать правильное значение аннотации для поля");

        System.out.println("Reflection корректно вернул аннотацию для поля '" +
                nameField.getName() + "': " + fieldValue.getSimpleName());
    }

    /**
     * Параметризованный тест для проверки нескольких классов с разными типами по умолчанию.
     * Использует @ParameterizedTest для тестирования разных конфигураций.
     */
    @ParameterizedTest
    @MethodSource("provideClassesWithDefaults")
    void parameterizedClassAnnotationTest(Class<?> testClass, Class<?> expectedDefaultType) {
        // Проверяем наличие аннотации
        assertTrue(testClass.isAnnotationPresent(Default.class),
                "Класс " + testClass.getSimpleName() + " должен иметь аннотацию @Default");

        // Получаем аннотацию
        Default annotation = testClass.getAnnotation(Default.class);
        assertNotNull(annotation, "Аннотация не должна быть null");

        // Проверяем значение
        Class<?> actualDefaultType = annotation.value();
        assertEquals(expectedDefaultType, actualDefaultType,
                "Тип по умолчанию должен совпадать с ожидаемым");

        System.out.println("Параметризованный тест: " + testClass.getSimpleName() +
                " -> " + expectedDefaultType.getSimpleName());
    }

    /**
     * Источник данных для параметризованного теста.
     * Предоставляет различные классы с аннотацией @Default.
     */
    private static Stream<Arguments> provideClassesWithDefaults() {
        return Stream.of(
                // Классы с аннотацией @Default
                Arguments.of(StringDefaultClass.class, String.class),
                Arguments.of(IntegerDefaultClass.class, Integer.class),
                Arguments.of(DoubleDefaultClass.class, Double.class),
                Arguments.of(ObjectDefaultClass.class, Object.class)
        );
    }

    /**
     * Тест для проверки обработчика DefaultHandler.
     * Проверяет корректность работы метода DefaultStart.
     */
    @Test
    void defaultHandlerTest() {
        // Вызываем обработчик - он должен работать без исключений
        Assertions.assertDoesNotThrow(() -> DefaultHandler.DefaultStart(TestDefault.class),
                "DefaultHandler.DefaultStart не должен выбрасывать исключение");

        System.out.println("\nDefaultHandler успешно обработал класс TestDefault");
    }

    /**
     * Тест для проверки отсутствия аннотации на неаннотированном классе.
     */
    @Test
    void noAnnotationTest() {
        // Класс без аннотации @Default
        class NonAnnotatedClass {
            private int value;
        }

        // Проверяем, что аннотация отсутствует
        Default annotation = NonAnnotatedClass.class.getAnnotation(Default.class);
        assertNull(annotation, "Неаннотированный класс не должен иметь аннотацию @Default");

        System.out.println("Класс без аннотации корректно обработан: аннотация = " + annotation);
    }

    /**
     * Тест для проверки аннотации на вложенном классе.
     */
    @Test
    void nestedClassAnnotationTest() {
        // Вложенный класс с аннотацией
        @Default(Long.class)
        class NestedAnnotatedClass {
            @Default(Boolean.class)
            private boolean flag;
        }

        // Проверяем аннотацию на вложенном классе
        Default classAnnotation = NestedAnnotatedClass.class.getAnnotation(Default.class);
        assertNotNull(classAnnotation, "Вложенный класс должен иметь аннотацию");
        assertEquals(Long.class, classAnnotation.value(),
                "Вложенный класс должен иметь Long.class как тип по умолчанию");

        System.out.println("Вложенный класс имеет аннотацию: " +
                classAnnotation.value().getSimpleName());
    }
}

// ==================== ТЕСТОВЫЕ КЛАССЫ ДЛЯ ПАРАМЕТРИЗОВАННОГО ТЕСТА ====================

/**
 * Тестовый класс с аннотацией @Default для строкового типа.
 */
@Default(String.class)
class StringDefaultClass {
    @Default(String.class)
    private String text;
}

/**
 * Тестовый класс с аннотацией @Default для целочисленного типа.
 */
@Default(Integer.class)
class IntegerDefaultClass {
    @Default(Integer.class)
    private Integer number;
}

/**
 * Тестовый класс с аннотацией @Default для вещественного типа.
 */
@Default(Double.class)
class DoubleDefaultClass {
    @Default(Double.class)
    private Double value;
}

/**
 * Тестовый класс с аннотацией @Default для Object типа.
 */
@Default(Object.class)
class ObjectDefaultClass {
    @Default(Object.class)
    private Object obj;
}
