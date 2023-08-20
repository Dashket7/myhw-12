package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldFindQueryInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInSimpleTaskFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить");

        boolean expected = false;
        boolean actual = simpleTask.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicTrue() {
        String[] subtasks = {"Молоко", "Яйца"};
        Epic epic = new Epic(55, subtasks);
        boolean expected = true;
        boolean actual = epic.matches("Молоко");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicFalse() {
        String[] subtasks = {"Молоко", "Яйца"};
        Epic epic = new Epic(55, subtasks);
        boolean expected = false;
        boolean actual = epic.matches("Вино");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindQueryInMeetingFalse() {
        Meeting meeting = new Meeting(555, "Выкатка", "Приложение", "Вторник");
        boolean expected = false;
        boolean actual = meeting.matches("Выкатка Версии");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMeetingProjectTrue() {
        Meeting meeting = new Meeting(555, "Выкатка", "Приложение", "Вторник");
        boolean expected = true;
        boolean actual = meeting.matches("Приложение");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMeetingTopicTrue() {
        Meeting meeting = new Meeting(555, "Выкатка", "Приложение", "Вторник");
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");
        Assertions.assertEquals(expected, actual);
    }
}
