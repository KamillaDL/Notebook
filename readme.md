# Notebook

Проект представляет из себя записную книжку с возможностью *добавления, 
редактирования и удаления* контактов.

Для того, чтобы пользоваться данной записной книжкой, необходимо авторизоваться <small>(для
этого в проект был добавлен Spring Security, который предоставляет механизмы
построения систем аутентификации и авторизации, также другие возможности, к примеру,
разрешение и ограничение доступа)</small>, если же аккаунт не создан, то зарегистрироваться.

Для того, чтобы воспользоваться записной книжкой, необходимо запустить приложение и перейти
по [адресу](http://localhost:8080).

###### RegistrationController
Представляет собой обработку get и post запросов по маппингу "/registration".

Метод, обрабатывающий post запросы на данный маппинг, имеет следующую сигнатуру:
```java
AddUser(User user, Model model)
```
Данный метод сохраняет данные зарегистрированного пользователя в БД.

На get запрос:
```java
registration()
```
Возвращает пользователю view на регистрацию.

######ContactsController
Обрабатывает get запрос по маппингу "/".

Метод, обрабатывающий данный запрос имеет данную сигнатуру:
```java
contacts(@RequestParam(defaultValue = "0") Integer page, Principal principal, Model model)
```
Возвращает пользователю veiw с его контактами.

######AddNewContactController
Обрабатывает get и post запросы на маппинг "/addNewContact"
Сигнатура метода, обрабатывающего get запрос:
```java
add()
```
Возвращает view на добавление контакта.

Сигнатура метода на post запрос:
```java
addNewContact(Contact contact, Model model, Principal principal)
```
Добавляет данные контакта в БД.
######EditContactController
Обрабатывает get и post запросы по маппингу "/editContact"

Сигнатура метода, обрабатывающего get запрос:
```java
editContact(@RequestParam(value = "contactId") Integer contactId, Model model)
```
Возвращает view на редактирование контакта.
Сигнатура метода на post запрос:
```java
saveEditedContact(@RequestParam(value = "contactId") Integer contactId, Contact contact)
```
Сохраняет в БД отредактированный контакт и редиректит на показ контактов пользователя.
######DeleteContactController
Обрабатывает post запрос на маппинг "/deleteContact"
Метод имеет следующую сигнатуру:
```java
deleteUser(@ModelAttribute(value = "id") String id)
```
Удаляет контакт из БД и редиректит на view контаков пользователя.

