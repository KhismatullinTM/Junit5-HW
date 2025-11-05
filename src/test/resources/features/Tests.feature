#language:ru


@WebTest
  Функционал: Тестирование 'DemoQA.com'

    @Test-1
    Сценарий: Проверка вложенных фреймов
      Дано открыт сайт DemoQA.com
      Когда пользователь нажимает по карточке "Alerts, Frame & Windows"
      Тогда в меню отображаются пункты:
        | Browser Windows |
        | Alerts          |
        | Frames          |
        | Nested Frames   |
        | Modal Dialogs   |
      Когда пользователь выбирает пункт меню "Nested Frames"
      Тогда отображается текст "Nested Frames"
      Когда пользователь переключается на родительский фрейм
      Тогда во фрейме отображается текст "Parent frame"
      Когда пользователь переключается на дочерний фрейм
      Тогда во фрейме отображается текст "Child Iframe"
      Когда пользователь возвращается на основную страницу
      Тогда отображается текст "Sample Nested Iframe page"

    @Test-2
    Сценарий: Проверка progress bar-а на странице Widgets - Progress Bar
      Дано открыт сайт DemoQA.com
      Когда пользователь нажимает по карточке "Widgets"
      И пользователь выбирает пункт меню "Progress Bar"
      Тогда на форме отображается кнопка с текстом "Start"
      Когда пользователь нажимает кнопку "Start"
      Тогда кнопка изменяет текст на "Stop"
      Когда прогресс достигает 30 процентов
      И пользователь нажимает кнопку "Stop"
      Тогда кнопка снова отображает "Start"

    @Test-3
    Структура сценария: Проверка select-ов на странице Widgets - Select Menu
      Дано открыт сайт DemoQA.com
      Когда пользователь нажимает по карточке "Widgets"
      И пользователь выбирает пункт меню "Select Menu"
      Тогда на странице отображается пункт "Old Style Select Menu"
      Когда пользователь нажимает на выпадающий список Old Style Select Menu
      И выбирает значение "<oldValue>"
      Тогда значение в пункте Old Style Select Menu становится "<oldValue>"
      Когда пользователь нажимает на выпадающий список Multiselect drop down
      И выбирает значение "<first>" и значение "<second>"
      Тогда в пункте Multiselect drop down отображаются "<first>" и "<second>"


      Примеры:
        | oldValue | first | second |
        | Blue     | Black | Red    |
        | Green    | Blue  | Black  |
#        | Yellow   | Red   | Blue   |
#        | Purple   | Green | Black  |
#        | Black    | Blue  | Red    |
#        | White    | Green | Red    |
#        | Violet   | Blue  | Black  |
#        | Indigo   | Green | Blue   |
#        | Magenta  | Black | Red    |
#        | Aqua     | Red   | Green  |