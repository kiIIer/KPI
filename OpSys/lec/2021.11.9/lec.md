- Оргінізація файлів у Юнікс системах
  - Файл задається перерахунком його блоків 
  - Розділено на 13 полів
  - Перші 10 - адреси блоків
  - якщо більше - в 11 одреса блока де може буте 128 номерів наступних плоків
  - Якщо ще більше - в 12 полі адреса на блок де 128 адресів і в кожному з них посилання на ще 128 блоків
  - Якщо ще більше - використовуємо 13 поле, де блок зі 128 в кожному з них 128 і в кожному з них 128
- Права доступу до файлів
  - Це значить зрозуміти для кожного користувача що він може з файлом робити
  - Права
    - Доповнення файлаа
    - Пошук у файлі
    - Здобуття атрибутів
    - багато чого іншого
  - Можна поисати все матрицею прав
    - Стовпчик - ім'я користувача
    - Рядок - ім'я файлів
    - На преретині - права
  - Існують 2 підходи, які визначають права доступу
    - Виборчий доступ
      - Коли доя кожного файла та кожного користувача сам володар може визначити можливі операції
    - Мандатний підхід
      - Система надає користувачам прива по відношенню до кожного розділеному ресурсу
- Загальна модель файлової системи
  - Це багаторівнева модель, кожен рівень надає певний інтерфейс рівню вище та користується інтерфейсом що знаходиться нижче
    - Символьний рівень
      - Перетворення того що ввів користувач у повне ім'я файлу
    - Базовий рівень
      - Визначається характеристики файла
    - Рівень перевірки прав доступа
      - Порівняння атрибутів характеристик файла і перевіряються права надані користувачу
    - Логічний рівень
      - Логічна організація файла
      - Визначаються коорданати логічного запису
    - Фактичний рівень
      - Фізична оргінізація файла
      - Беруться логічні координати
      - Тут визначаютсья блок де знаходяться ці данні
    - Ввод-вивід
- Принцип роботи на фізичному рівні
- Сучасна архітектура файлової системи
  - Має надавати можливість працювати з різними файловими системами
  - Складається з декілької рівнів
    - Веремикач файлової системи
      - Дає можливість працювати з різними системами
      - Перероблює запит до форми певної файлової системи 
      - Потім запит іде уже в файлову систему
      - Перемекач знає у яку форму переводити
        - Перший запит - реєстрація системи
    - Після того як запит іде до файлової системи
      - Організована як звичайна файлова система
    - Потім на підсистему вводу-виводу
    -  