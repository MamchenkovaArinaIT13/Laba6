ОТЧЕТ ПО ЛАБОРАТОРНОЙ РАБОТЕ №6 ПО JAVA
Работа с аннотациями и рефлексией

ОБЩЕЕ ОПИСАНИЕ РАБОТЫ
Лабораторная работа №6 посвящена изучению аннотаций и рефлексии в Java. Реализованы различные типы аннотаций с соответствующими обработчиками, использующими механизм рефлексии для анализа классов, полей и методов. Все задачи реализованы в едином проекте с дружественным консольным интерфейсом, поддерживающим как ручной, так и автоматический ввод данных. Дополнительно реализовано тестирование с использованием JUnit 5.

 ЗАДАНИЕ 1. АННОТАЦИЯ @CACHE

 ОПИСАНИЕ АННОТАЦИИ @Cache:
Аннотация для маркировки классов, указывающая кешируемые области.

Метаданные аннотации:
- Target: ElementType.TYPE (применяется только к классам)
- Retention: RetentionPolicy.RUNTIME (доступна в runtime)

Свойства:
- String[] value() default {} - массив строк с названиями кешируемых областей

 КЛАСС CacheHandler:
Обработчик аннотации @Cache для анализа классов.

Основные методы:
- startCache(Class<?> class1) - анализ класса на наличие аннотации @Cache

Логика обработки:
1. Проверка наличия аннотации @Cache на классе
2. Если аннотация отсутствует - вывод сообщения
3. Если аннотация присутствует - вывод списка кешируемых областей

 КЛАСС TestCache:
Тестовый класс для демонстрации работы аннотации @Cache.

Поля класса:
- private String userName - имя пользователя
- private int clientId - идентификатор клиента

Конструкторы:
- TestCache() - конструктор по умолчанию
- TestCache(String userName, int clientId) - конструктор с параметрами

Методы:
- Геттеры и сеттеры для всех полей
- getUserName(), setUserName(String userName)
- getClientId(), setClientId(int clientId)

 ТЕСТИРОВАНИЕ:
java
@Cache({"clientData","sessionData","applicationData"})
public class TestCache {
    // поля и методы класса
}

// Использование:
CacheHandler.startCache(TestCache.class);
// Вывод: "Класс TestCache - кешируемые области: 1. clientData, 2. sessionData, 3. applicationData"


 ЗАДАНИЕ 2. АННОТАЦИЯ @DEFAULT

 ОПИСАНИЕ АННОТАЦИИ @Default:
Аннотация для указания классов и полей по умолчанию.

Метаданные аннотации:
- Target: {ElementType.FIELD, ElementType.TYPE} (применяется к классам и полям)
- Retention: RetentionPolicy.RUNTIME

Свойства:
- Class<?> value() - класс по умолчанию

 КЛАСС DefaultHandler:
Обработчик аннотации @Default.

Основные методы:
- DefaultStart(Class<?> class1) - анализ класса на аннотации @Default

Логика обработки:
1. Проверка аннотации на уровне класса
2. Поиск аннотаций на полях класса
3. Вывод информации о найденных аннотациях

 КЛАСС TestDefault:
Тестовый класс для демонстрации работы аннотации @Default.

Поля класса:
- private String name - имя с аннотацией @Default

Конструкторы:
- TestDefault() - конструктор по умолчанию
- TestDefault(String name) - конструктор с параметром

Методы:
- getName(), setName(String name) - геттер и сеттер для name
- toString() - строковое представление объекта

 ТЕСТИРОВАНИЕ:
java
@Default(String.class)
public class TestDefault {
    @Default(String.class)
    private String name;
}

// Использование:
DefaultHandler.DefaultStart(TestDefault.class);
// Вывод информации о аннотациях на классе и полях

 ЗАДАНИЕ 3. АННОТАЦИЯ @INVOKE

 ОПИСАНИЕ АННОТАЦИИ @Invoke:
Аннотация для автоматического вызова методов.

Метаданные аннотации:
- Target: ElementType.METHOD (применяется только к методам)
- Retention: RetentionPolicy.RUNTIME

 КЛАСС InvokeHandler:
Обработчик для вызова методов с аннотацией @Invoke.

Основные методы:
- InvokeStart(Object object) - вызов всех методов с аннотацией @Invoke

Логика обработки:
1. Получение всех методов класса через рефлексию
2. Поиск методов с аннотацией @Invoke
3. Установка доступности для private методов
4. Вызов методов через reflection

 КЛАСС TestInvoke:
Тестовый класс с различными методами, помеченными @Invoke.

Поля класса:
- private int num = 1 - числовое поле для тестирования изменений состояния

Методы с аннотацией @Invoke:
- public void Test1() - public нестатический метод, изменяет состояние объекта
- public int Test2() - public нестатический метод с возвращаемым значением
- public void Test3() - public нестатический метод
- public static void Test4() - public статический метод
- private void Test5() - private нестатический метод
- private static void Test6() - private статический метод
- protected void Test7() - protected нестатический метод
- protected static void Test8() - protected статический метод

Дополнительные методы:
- getNum() - геттер для поля num

 ТЕСТИРОВАНИЕ С JUNIT 5:

 КЛАСС InvokeHandlerTest:
Тесты для проверки работы аннотации @Invoke.

Методы тестирования:
- @BeforeEach createObject() - создание тестового объекта перед каждым тестом
- @Test test1() - комплексный тест вызова методов с аннотацией @Invoke

Логика тестов:
1. Проверка корректного вызова методов без исключений
2. Проверка возвращаемых значений методов
3. Проверка изменений состояния объекта после вызова методов

java
@Test
public void test1() {
    int initialNum = testInvoke.getNum();
    
    // Вызов всех методов с аннотацией @Invoke
    for (Method method : methods) {
        if(method.isAnnotationPresent(Invoke.class)) {
            Assertions.assertDoesNotThrow(() -> {
                method.setAccessible(true);
                method.invoke(testInvoke);
            });
        }
    }
    
    // Проверка возвращаемого значения
    Assertions.assertEquals(232, testInvoke.Test2());
    // Проверка изменения состояния
    Assertions.assertEquals(initialNum + 1, testInvoke.getNum());
}


 ТЕСТИРОВАНИЕ:
java
TestInvoke testInvoke = new TestInvoke();
InvokeHandler.InvokeStart(testInvoke);
// Автоматический вызов всех методов с аннотацией @Invoke

 ЗАДАНИЕ 4. АННОТАЦИЯ @TOSTRING

 ОПИСАНИЕ АННОТАЦИИ @ToString:
Аннотация для кастомного строкового представления объектов.

Метаданные аннотации:
- Target: {ElementType.TYPE, ElementType.FIELD}
- Retention: RetentionPolicy.RUNTIME

Перечисление Mode:
- YES - включать поле в toString
- NO - исключать поле из toString

Свойства:
- Mode value() default Mode.YES - режим отображения

 КЛАСС ToStringHandler:
Обработчик для генерации строкового представления.

Основные методы:
- toStringStart(Object object) - генерация строки на основе аннотаций

Логика обработки:
1. Проверка аннотации @ToString на классе
2. Получение режима по умолчанию из аннотации класса
3. Анализ аннотаций на полях
4. Построение строки только для полей с Mode.YES

 КЛАСС Client:
Тестовый класс с различными настройками аннотаций.

Поля класса:
- @ToString(Mode.YES) private String name - имя (включается в вывод)
- private int age - возраст (использует режим по умолчанию)
- @ToString(Mode.YES) private String email - email (включается в вывод)
- @ToString(Mode.NO) private String phone - телефон (исключается из вывода)

Конструкторы:
- Client() - конструктор по умолчанию
- Client(String name, int age, String email, String phone) - конструктор с параметрами

Методы:
- Геттеры и сеттеры для всех полей

 ТЕСТИРОВАНИЕ:
java
Client client = new Client("Арина", 19, "mam@gmail.com", "+79655666091");
String result = ToStringHandler.toStringStart(client);
// Результат: "Client{name=Арина, email=mam@gmail.com}"
// (поля age и phone исключены из вывода)

 ЗАДАНИЕ 5. АННОТАЦИЯ @TWO

 ОПИСАНИЕ АННОТАЦИИ @Two:
Аннотация с двумя свойствами разных типов.

Метаданные аннотации:
- Target: ElementType.TYPE
- Retention: RetentionPolicy.RUNTIME

Свойства:
- String first() - строковое свойство
- int second() - числовое свойство

 КЛАСС TwoHandler:
Обработчик аннотации @Two.

Основные методы:
- twoStart(Class<?> class1) - анализ и вывод свойств аннотации

 КЛАСС TwoTest:
Тестовый класс для демонстрации работы аннотации @Two.

Поля класса:
- private String first - строковое поле
- private int second - числовое поле

Конструкторы:
- TwoTest() - конструктор по умолчанию
- TwoTest(String first, int second) - конструктор с параметрами

Методы:
- Геттеры и сеттеры для всех полей
- toString() - строковое представление объекта

 ТЕСТИРОВАНИЕ:
java
@Two(first = "1", second = 2)
public class TwoTest {
    // поля и методы класса
}

// Использование:
TwoHandler.twoStart(TwoTest.class);
// Вывод: "Класс TwoTest аннотирован @Two: first: "1", second: 2"

 ЗАДАНИЕ 6. АННОТАЦИЯ @VALIDATE

 ОПИСАНИЕ АННОТАЦИИ @Validate:
Аннотация для валидации классов.

Метаданные аннотации:
- Target: {ElementType.TYPE, ElementType.ANNOTATION_TYPE}
- Retention: RetentionPolicy.RUNTIME

Свойства:
- Class<?>[] value() - массив классов для валидации

 КЛАСС ValidateHandler:
Обработчик аннотации @Validate.

Основные методы:
- ValidateStart(Class<?> classes) - вывод информации о классах валидации

 КЛАСС ValidateTest:
Тестовый класс для демонстрации работы аннотации @Validate.

Поля класса:
- private String title - заголовок
- private int duration - продолжительность

Конструкторы:
- ValidateTest() - конструктор по умолчанию
- ValidateTest(String title, int duration) - конструктор с параметрами

Методы:
- Геттеры и сеттеры для всех полей
- toString() - строковое представление объекта

 ТЕСТИРОВАНИЕ С JUNIT 5:

 КЛАСС ValidateHandlerTest:
Тесты для проверки работы аннотации @Validate.

Методы тестирования:
- @Test CorrectAnnotationTestMB() - тест с выводом подробной информации
- @Test CorrectAnnotationTest() - тест проверки корректности аннотации
- @Test ExceptionTest() - тест обработки исключительных ситуаций

Логика тестов:
java
@Test
void CorrectAnnotationTest() {
    Validate validate = ValidateTest.class.getAnnotation(Validate.class);
    Assertions.assertNotNull(validate);
    
    Class<?>[] validationClasses = validate.value();
    Assertions.assertEquals(2, validationClasses.length);
    Assertions.assertEquals(String.class, validationClasses[0]);
    Assertions.assertEquals(Integer.class, validationClasses[1]);
}

@Test
void ExceptionTest() {
    IllegalArgumentException exception = Assertions.assertThrows(
        IllegalArgumentException.class, () -> ValidateHandler.ValidateStart(EmptyValidateTest.class)
    );
    assertEquals("Массив классов для валидации не может быть пустым!", exception.getMessage());
}


 ТЕСТИРОВАНИЕ:
java
@Validate({String.class, Integer.class})
public class ValidateTest {
    // поля и методы класса
}

// Использование:
ValidateHandler.ValidateStart(ValidateTest.class);
// Вывод списка классов для валидации


 СИСТЕМА МЕНЮ И ТЕСТИРОВАНИЯ

 КЛАСС MenuAndValidator:
Полная система тестирования всех реализованных функциональностей.

Возможности системы:
- Два режима ввода: ручной и автоматический
- Полная валидация входных данных
- Обработка исключений и ошибок
- Наглядное представление результатов

Структура меню:
1. Выбор способа ввода (ручной/авто)
2. Выбор задания (1-6)
3. Интерактивный ввод данных или готовые тесты
4. Вывод результатов с подробным объяснением

Особенности реализации:
- Защита от некорректного ввода
- Подробные сообщения об ошибках
- Дружественный пользовательский интерфейс
- Поддержка всех типов аннотаций

 ПРИНЦИПЫ РЕФЛЕКСИИ

 ОСНОВНЫЕ МЕТОДЫ РЕФЛЕКСИИ:
- Class<?> getClass() - получение класса объекта
- getAnnotation(Class<T>) - получение аннотации
- getDeclaredFields() - получение всех полей класса
- getDeclaredMethods() - получение всех методов класса
- setAccessible(true) - обеспечение доступа к private элементам
- method.invoke(object) - вызов метода через рефлексию

 ОБРАБОТКА АННОТАЦИЙ:
1. Анализ на уровне класса - class.isAnnotationPresent()
2. Анализ полей - field.isAnnotationPresent()
3. Анализ методов - method.isAnnotationPresent()
4. Получение значений аннотаций - annotation.value()

 ТЕСТИРОВАНИЕ С JUNIT 5

 РЕАЛИЗОВАННЫЕ ТЕСТЫ:

 DefaultHandlerTest:
- Проверка корректного вызова методов с аннотацией @Default
- Проверка отсутствия исключений при вызове методов
- Проверка возвращаемых значений
- Проверка изменений состояния объекта

 ValidateHandlerTest:
- Проверка наличия и корректности аннотации @Validate
- Проверка количества и типов классов для валидации
- Проверка обработки исключительных ситуаций
- Подробный вывод информации для отладки

XML ДОКУМЕНТАЦИЯ 
Также к каждому классу и методу была реализована xml-документация

 ПРЕИМУЩЕСТВА JUNIT 5:
- Assertions - богатый набор методов для проверок
- Annotations - удобная система аннотаций для организации тестов
- Exception testing - удобная проверка исключений
- Lifecycle methods - методы для подготовки и очистки тестового окружения

 ЗАКЛЮЧЕНИЕ

Все задачи лабораторной работы №6 успешно реализованы и протестированы:

1. Задание 1 - Аннотация @Cache для маркировки кешируемых областей
2. Задание 2 - Аннотация @Default для указания классов и полей по умолчанию
3. Задание 3 - Аннотация @Invoke для автоматического вызова методов
4. Задание 4 - Аннотация @ToString для кастомного строкового представления
5. Задание 5 - Аннотация @Two с двумя свойствами разных типов
6. Задание 6 - Аннотация @Validate для валидации классов

Дополнительные достижения:
- Реализация комплексной системы меню с двумя режимами ввода
- Создание модульных тестов с использованием JUnit 5
- Обработка исключительных ситуаций и валидация входных данных
- Детальное документирование кода и создание отчета

Программа демонстрирует практическое применение аннотаций и рефлексии в Java, обеспечивая гибкость, модульность и удобство использования. Реализованная система меню позволяет легко тестировать все функциональности как с ручным вводом, так и с готовыми тестовыми данными. Модульные тесты обеспечивают надежность и корректность работы всех компонентов системы.
