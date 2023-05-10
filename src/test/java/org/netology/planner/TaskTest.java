package org.netology.planner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldFindMatchingTasksSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        simpleTask.matches("родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("родителям");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindMatchingTasksEpicInOneSubtask() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(2, subtasks);

        epic.matches("Хлеб");

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFindDifferentTasksEpicInOneSubtask() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(2, subtasks);

        epic.matches("Сыр");

        boolean expected = false;
        boolean actual = epic.matches("Сыр");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindMatchingTasksEpicInTwoSubtasks() {
        String[] subtasks = { "Сыр свежий", "Яйца", "Хлеб свежий" };
        Epic epic = new Epic(2, subtasks);

        epic.matches("свежий");

        boolean expected = true;
        boolean actual = epic.matches("свежий");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindMatchingTasksMeetingIfTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        meeting.matches("версии");

        boolean expected = true;
        boolean actual = meeting.matches("версии");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFindDifferentTasksMeetingIfTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        meeting.matches("сдача");

        boolean expected = false;
        boolean actual = meeting.matches("сдача");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindMatchingTasksMeetingIfProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        meeting.matches("НетоБанка");

        boolean expected = true;
        boolean actual = meeting.matches("НетоБанка");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFindDifferentTasksMeetingIfProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        meeting.matches("проект");

        boolean expected = false;
        boolean actual = meeting.matches("проект");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFindId() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(5, subtasks);

        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        simpleTask.matches("5");
        epic.matches("5");
        meeting.matches("5");

        boolean expected = false;
        boolean actual = simpleTask.matches("5"); epic.matches("5"); meeting.matches("5");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindIdInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(3, subtasks);

        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        simpleTask.getId();
//        epic.getId();
//        meeting.getId();

        int expected = 7;
        int actual = simpleTask.getId();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindIdInEpic() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(3, subtasks);

        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


       epic.getId();

        int expected = 3;
        int actual = epic.getId();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindIdInMeeting() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(3, subtasks);

        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        meeting.getId();

        int expected = 5;
        int actual = meeting.getId();

        Assertions.assertEquals(expected, actual);
    }

}
