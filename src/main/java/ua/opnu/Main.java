package ua.opnu;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Петренко", "Петро", 45);
        Student student = new Student("Іваненко", "Іван", 20, "АІ-245", "СК12345678");
        Lecturer lecturer = new Lecturer("Сидоренко", "Сидір", 35, "Інформаційних технологій", 15000.0);

        Person[] people = new Person[3];

        people[0] = person;
        people[1] = student;
        people[2] = lecturer;

        System.out.println("Інформація про людей в масиві:");

        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
}