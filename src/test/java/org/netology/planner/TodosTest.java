package org.netology.planner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchMatchingTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchMatchingTasksIfTwo() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить сыр");

        String[] subtasks = { "сыр", "яйца", "хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("сыр");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchMatchingTasksIfThree() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить в Нетобанк");

        String[] subtasks = { "сыр", "банки", "хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("банк");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotSearchDifferentTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("сок");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void equalsTest() {
        SimpleTask simpleTask = new SimpleTask(6, "Позвонить родителям");

//        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
//        Epic epic = new Epic(55, subtasks);
//
//        Meeting meeting = new Meeting(
//                555,
//                "Выкатка 3й версии приложения",
//                "Приложение НетоБанка",
//                "Во вторник после обеда"
//        );
        Task task = new Task(6);
        Todos todos = new Todos();

        todos.add(simpleTask);


        boolean expected = true;
        boolean actual = task.equals(simpleTask.id);

        Assertions.assertEquals(expected, actual);
    }

}
