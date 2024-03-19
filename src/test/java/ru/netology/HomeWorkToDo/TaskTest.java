package ru.netology.HomeWorkToDo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testConstructorAndGetId() {
        int id = 13;
        Task task = new Task(id);

        assertEquals(id, task.getId());
    }

    @Test
    public void testEqualsAndHashCode() {
        Task task1 = new Task(13);
        Task task2 = new Task(13);

        Assertions.assertTrue(task1.equals(task2));
        Assertions.assertEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    public void testMatches() {
        Task task = new Task(13);
        Assertions.assertFalse(task.matches("query"));
    }
    @Test
    public void testEqualsNotEqualObjects() {
        Task task1 = new Task(13);
        Task task2 = new Task(23);

        Assertions.assertFalse(task1.equals(task2));
    }
    @Test
    public void testEqualsNullObject() {
        Task task1 = new Task(1);

        Assertions.assertFalse(task1.equals(null));
    }
    @Test
    public void testEqualsDifferentClass() {
        Task task1 = new Task(1);
        Object object = new Object();

        Assertions.assertFalse(task1.equals(object));
    }
    @Test
    public void testEqualsSameObjectReference() {
        Task task1 = new Task(1);

        assertTrue(task1.equals(task1)); // Проверка, что объект равен самому себе по ссылке
    }

    @Test
    public void testGetSimpleTask() {
        String title = "Позвонить родителям";
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");


        Assertions.assertEquals(title, simpleTask.getTitle());
    }

    @Test
    public void testSimpleTaskWhenMatch() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        boolean actual = simpleTask.matches("Позвонить");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testSimpleTaskWhenNoMatch() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        boolean actual = simpleTask.matches("Написать");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetTopic() {
        String topic = "Новый проект";
        Meeting meeting = new Meeting(7, "Новый проект", "Обучение сотрудника", "Пятнадцать месяцев");

        Assertions.assertEquals(topic, meeting.getTopic());
    }

    @Test
    public void testGetProject() {
        String project = "Обучение сотрудника";
        Meeting meeting = new Meeting(7, "Новый проект", "Обучение сотрудника", "Пятнадцать месяцев");

        Assertions.assertEquals(project, meeting.getProject());
    }

    @Test
    public void testGetStart() {
        String start = "Пятнадцать месяцев";
        Meeting meeting = new Meeting(7, "Новый проект", "Обучение сотрудника", "Пятнадцать месяцев");

        Assertions.assertEquals(start, meeting.getStart());
    }
    @Test
    public void testMeetingTopic() {
        Meeting Meeting = new Meeting(2, "Новый проект", "Обучение сотрудника", "Пятнадцать месяцев");
        boolean actual = Meeting.matches("проект");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testMeetingProject() {
        Meeting Meeting = new Meeting(2, "Новый проект", "Обучение сотрудника", "Пятнадцать месяцев");
        boolean actual = Meeting.matches("Обучение");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testNoMeeting() {
        Meeting Meeting = new Meeting(2, "Новый проект", "Обучение сотрудника", "Пятнадцать месяцев");
        boolean actual = Meeting.matches("Кофе");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testGetSubtask() {
        String[] subtasks = {"Задача 1", "Задача 2", "Задача 3"};
        Epic epic = new Epic(1, subtasks);

        Assertions.assertArrayEquals(subtasks, epic.getSubtasks());
    }

    @Test
    public void testEpicMatchesSubtask() {
        String[] subtasks = {"Задача 1", "Задача 2", "Задача 3"};
        Epic epic = new Epic(1, subtasks);

        Assertions.assertTrue(epic.matches("Задача 1"));
    }

    @Test
    public void testEpicNoSubtask() {
        String[] subtasks = {"Задача 1", "Задача 2", "Задача 3"};
        Epic epic = new Epic(1, subtasks);

        Assertions.assertFalse(epic.matches("Задача 4"));
    }


}
