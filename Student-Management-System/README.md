# Read Me First

# Spring Boot Project:- Student Portal

This guide will help you set up a Spring Boot project with specified models and their respective CRUD operations.

### Prerequisites

- Java 8 or higher
- Your preferred IDE (E.g., IntelliJ IDEA, Eclipse, etc.)
- Maven for project management (optional).

### Step 1: Set Up a Spring Boot Project

1. Open your preferred IDE.
2. Create a new Spring Boot project using Spring Initializer or your IDE's project creation wizard.
3. Add the following dependencies:
    - Spring Web
    - Spring Data JPA
    - Spring Mysql (or any other database you prefer)
    - Lombok.
    - Validation.
## Step 2: Define Entity Classes Details

Create the following classes in the `model` package:

### Student

- Fields: ID, name, age, phoneNumber, branch, department.
- Relationships: One-to-one with Address, One-to-many with Book.

### Student.java

```java
@Entity
public class Student {
    // ... (existing fields)

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Book> books;

    // Getters and setters
}

```

### Laptop

- Fields: ID, name, brand, price.
- Relationship: One-to-one with Student.
### Laptop.java

```java
@Entity
public class Laptop {
    // ... (existing fields)

    @OneToOne
    private Student student;

    // Getters and setters
}
```

### Course

- Fields: ID, title, description, duration.
- Relationship: Many-to-many with Student.
### Course.java

```java
@Entity
public class Course {
    // ... (existing fields)

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> studentSet;

    // Getters and setters
}
```

### Book

- Fields: ID, title, author, description, price.
- Relationship: Many-to-one with Student.
### Book.java

```java
@Entity
public class Book {
    // ... (existing fields)

    @ManyToOne
    private Student student;

    // Getters and setters
}
```

### Address

- Fields: addressId, landmark, zipcode, district, state, country.
- Relationship: One-to-one with Student.
### Address.java

```java
@Entity
public class Address {
    // ... (existing fields)

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Student student;

    // Getters and setters
}
```
## Student

- **GET** `/students`: Get all students.
- **GET** `/students/{id}`: Get student by ID.
- **POST** `/students`: Create a new student.
- **PUT** `/students/{id}`: Update an existing student.
- **DELETE** `/students/{id}`: Delete student by ID.

_Repeat similar endpoints for Laptop, Course, Book, and Address._

## Step 3: Create Repositories
* Create repositories for each entity in the repository package:

```
StudentRepository.java
LaptopRepository.java
CourseRepository.java
BookRepository.java
AddressRepository.java
```

## Step 4: Create Services
* Create services for each entity in the service package:
```
StudentService.java
LaptopService.java
CourseService.java
BookService.java
AddressService.java
```
## Step 5: Create Controllers
* Create controllers for each entity in the controller package:
```
StudentController.java
LaptopController.java
CourseController.java
BookController.java
AddressController.java
```

### Reference Documentation
For further reference, please consider the following sections:

* [Github Link](https://github.com/Anish1430/Student-Portal)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web)
* [Validation](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#io.validation)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

