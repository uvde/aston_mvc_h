# Aston Intensive  

## Vasily Urusov

### Contacts
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

### Описание проекта.

Это java приложение которое позволяет совершить crud для простейших entity.
В проекте представлины три вида связи. 

+ @OneToMany (Position -> Employee)
+ @ManyToOne (Employee -> Position)
+ @ManyToMany (Employee <-> Project)

![Схема в базе данных](/image/tables.png "Схема в базе данных")

### Проблема n+1

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
### Persistence context

Сохранение нового отношения многие ко многим производиться
путем добавления экземпляра объектов в списки.
```java
@Override
    public void addEmployeeToProject(long employeeId, long projectId) {
        Session session = getCurrentSession();
        Project project = session.get(Project.class, projectId);
        Employee employee = session.get(Employee.class, employeeId);
        project.getEmployees().add(employee);
        employee.getProjects().add(project);
    }
```

### Transaction 
Транзакции отслеживает аннотация @Transaction указанная над названием метода в Services.
```java
@Override
    @Transactional(readOnly = true)
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeesDao.getAllEmployees()
                .forEach(e -> employeeDtoList
                        .add(new EmployeeDto(e.getId(),
                                e.getName(),
                                e.getBirthday(),
                                e.getCity(),
                                e.getPosition().getSalary(),
                                e.getPosition().getName())));
        return employeeDtoList;
    }

```
### View of Project
![Employees](/image/Employees.png "View for crud Employee entity")
![Employees](/image/projects.png "View for crud Project entity")
![Employees](/image/positions.png "View for crud Position entity")


