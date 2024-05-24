package cls;

import DateCls.DateFactory;

import java.time.LocalDate;
import java.util.Set;

public class BirthdayTask implements Runnable {
    private final Set<Person> people;
    private final Integer TIME = 1000 * 60 * 60 * 24;
    private boolean isRunning = true;

    public BirthdayTask(Set<Person> people) {
        this.people = people;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    private boolean isBirthMonth(Person person) {
        return person.getBirthday().getMonth() == LocalDate.now().getMonth();
    }

    private boolean isBirthDay(Person person) {
        return person.getBirthday().getDayOfMonth() == LocalDate.now().getDayOfMonth();
    }

    private void printHappy(Person person) {
        System.out.println(person.getName() + "hava a birthday in " +
                DateFactory.changeFormat(person.getBirthday()));
    }

    @Override
    public void run() {
        while (isRunning) {
            boolean found = false;
            for (Person person : people) {
                if (isBirthMonth(person) && isBirthMonth(person)) {
                    found = true;
                    printHappy(person);
                }
            }
            if (!found) {
                System.out.println("Another day...");
            }
            try {
                Thread.sleep(TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
