package cls;

import DateCls.DateFactory;

import java.time.LocalDate;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private Integer id;
    private String name;
    private LocalDate birthday;

    private static Integer counter = 0;

    public Person() {
        this(0, "Person", null);
    }

    public Person(String name, LocalDate birthday) {
        this(0, name, birthday);
    }

    public Person(Integer id, String name, LocalDate birthday) {
        counter++;
        setId(counter);
        setName(name);
        setBirthday(DateFactory.getLocalDate());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name + this.id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Person o) {
        return this.birthday.compareTo(o.getBirthday());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(birthday, person.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthday);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + DateFactory.changeFormat(this.getBirthday()) +
                '}';
    }
}
