package statistics;

import cls.Person;

import java.util.*;

public class BirthdayStat {
    // happyMonth, sadMonth, printEvents
    public static int happyMonth(Set<Person> people) {
        int[] month = getMonthCounter(people);
        int max = month[0];
        int maxIndex = 0;
        for (int index = 1; index < month.length; index++) {
            if (month[index] > max) {
                max = month[index];
                maxIndex = index;
            }
        }
        return maxIndex + 1;
    }

    public static int sadMonth(Set<Person> people) {
        int[] month = getMonthCounter(people);
        int min = month[0];
        int minIndex = 0;
        for (int index = 1; index < month.length; index++) {
            if (month[index] < min) {
                min = month[index];
                minIndex = index;
            }
        }
        return minIndex + 1;
    }

    private static int[] getMonthCounter(Set<Person> people) {
        int[] months = new int[12];
        for (Person person : people) {
            months[person.getBirthday().getMonthValue() - 1]++;
        }
        return months;
    }

    public static final int MONTHS = 12;

    // on each month -> all the birthdays in that month
    public static Map<Integer, List<Person>> getEvents(Set<Person> people) {
        Map<Integer, List<Person>> events = new HashMap<>();

        //initialize every object in the array
        for (int counter = 1; counter <= MONTHS; counter++) {
            events.put(counter, new ArrayList<>());
        }

        for (Person person : people) {
            //getting person's month of birthday
            int month = person.getBirthday().getMonthValue();
            // getting the list of birthdays from this month
            List<Person> monthEvents = events.get(month);
            // adding the person to this month list
            monthEvents.add(person);
            //return the new list
            events.put(month, monthEvents);
        }
        return events;
    }
}
