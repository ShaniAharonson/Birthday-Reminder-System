package cls;

import statistics.BirthdayStat;

import java.util.*;

public class BirthdaySystemReminder {
    private Set<Person> people;
    private BirthdayTask task;
    private static Scanner scanner = new Scanner(System.in);

    public BirthdaySystemReminder() {
        this.people = new HashSet<>();
        task = new BirthdayTask(this.people); // initialize the task
        Thread thread = new Thread(task); // initialize the thread
        thread.start();
        //thread.setDaemon(true);
        startSystem();
    }

    private void startSystem() {
        System.out.println("System was started!!!!!\n");
        while (true) {
            showMenu();
            System.out.println("> ");
            String input = scanner.nextLine();
            System.out.println();
            switch (input) {
                case "1":
                    addPerson(new Person());
                    break;
                case "2":
                    deletePerson();
                    break;
                case "3":
                    printAllPeople();
                    break;
                case "4":
                    System.out.println("Total count " + this.people.size());
                    break;
                case "5":
                    System.out.println("Happy month is: " + BirthdayStat.happyMonth(this.people));
                    break;
                case "6":
                    System.out.println("Sad month is: " + BirthdayStat.sadMonth(this.people));
                    break;
                case "7":
                    printEvents();
                    break;
                case "0":
                    endSystem();
                    break;
                default:
                    System.out.println("Not an option!!!");
            }
        }
    }

    private void printEvents() {
        Map<Integer, List<Person>> events = BirthdayStat.getEvents(this.people);
        // iteration on Map
        for (Map.Entry<Integer, List<Person>> peopleEvents : events.entrySet()) {
            System.out.println("Month : " + peopleEvents.getKey());
            System.out.println("=========================================");
            System.out.println("Birthdays:" + peopleEvents.getValue());
        }
    }

    private void endSystem() {
        scanner.close();
        System.out.println("Birthday reminder is ended!!!!");
        System.exit(0);
    }

    private void printAllPeople() {
        if (this.people.size() == 0) {
            System.out.println("No people in the system");
        }
        this.people.forEach(System.out::println);
    }


    private void deletePerson() {
        System.out.println("Please insert id of person to delete");
        System.out.println("> ");
        int id = scanner.nextInt();
        for (Person person : people) {
            if (person.getId() == id) {
                people.remove(person);
                System.out.println("Person was erased!!!");
                break;
            }
        }
    }

    private void addPerson(Person person) {
        if (this.people.add(person)) {
            System.out.println("Person was added!!!\n");
        } else {
            System.out.println("Person already exists!!!!\n");
        }
    }

    private void showMenu() {
        System.out.println("\n\n\n Birthday System Menu \n" +
                "=================================\n" +
                "1. Add person\n" +
                "2. Delete person\n" +
                "3. Print all people \n" +
                "4. Print people count\n" +
                "5. Print Happy month\n" +
                "6. Print sad month\n" +
                "7. Print events\n" +
                "\n" +
                "0. Exit System");
    }

}
