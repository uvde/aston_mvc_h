# Clevertec Test Task

## Vasily Urusov

### Contacts
- __Location__: Minsk, Belarus
- __Phone__: +375 29 778-48-36
- __Email__: uvd.1994@gmail.com
- __GitHub__: [uvde](https://github.com/uvde)

Stack
+ Java 17
+ Maven
+ TomCat
+ Spring MVC
+ Hibernate
+ PostgreSQL
+ Bootstrap

###Описание проекта.

Это java приложение которое позволяет совершить crud для простейших entity.
В проекте представлины три вида связи. 

+ @OneToMany (Position -> Employee)
+ @ManyToOne (Employee -> Position)
+ @ManyToMany (Employee <-> Project)

![Схема в базе данных](/tables.png "Схема в базе данных")

###Проблема n+1

Проблема n+1, возникшая при извлечении списка Employees была решена с помошью Join Fetch в HQL запросе.
```java
@Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("SELECT e" +
                " FROM Employee e JOIN FETCH e.position", Employee.class);
        return query.list();
    }
```

### Dto
Для передачи информации от репозитория к браузеру используются dto.