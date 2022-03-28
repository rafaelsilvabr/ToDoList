package mainPackage;

import static org.junit.jupiter.api.Assertions.*;

class ToDoTasksTest {

    //
    // Given
    //

    @org.junit.jupiter.api.Test
    void criaTasks() {
        ToDoTasks tasks = new ToDoTasks();
        System.out.println("-----------criaTasks--------------");
        System.out.println("CRIANDO TASK ");

        String name = "task0";
        String description = "A description";
        String deadline = "10/10/21";
        int priorityLevel = 1;
        String category = "job";
        String status = "todo";

        System.out.println(">> "+ name + " " + description + " " + status);

        tasks.create(name, description, deadline, priorityLevel, category, status);
        assertEquals("[Task{name='task0', description='A description', deadline='10/10/21', priorityLevel=1, category='job', status='todo'}]",tasks.tasks.toString());

        System.out.println("-------------------------------");
    }

    @org.junit.jupiter.api.Test
    void criaTasksErrado() {
        ToDoTasks tasks = new ToDoTasks();
        System.out.println("-----------criaTasksErrado--------------");
        System.out.println("CRIANDO TASK ");

        String name = "task0";
        String description = "A description";
        String deadline = "10/10/21";
        int priorityLevel = 7;
        String category = "job";
        String status = "todo";

        System.out.println(">> "+ name + " " + description + " " + status);

        tasks.create(name, description, deadline, priorityLevel, category, status);
        assertEquals(true,tasks.tasks.isEmpty());

        System.out.println("-------------------------------");
    }

    @org.junit.jupiter.api.Test
    void removeTask() {
        ToDoTasks tasks = new ToDoTasks();
        System.out.println("-----------removeTask--------------");
        System.out.print("CRIANDO TASK ");

        String name = "task1";
        String description = "A description";
        String deadline = "10/12/21";
        int priorityLevel = 4;
        String category = "job";
        String status = "todo";

        System.out.println(">> "+ name + " " + description + " " + status);
        tasks.create(name, description, deadline, priorityLevel, category, status);


        System.out.println("REMOVENDO TASK");
        tasks.delete(0);


        assertEquals(true,tasks.tasks.isEmpty());

        System.out.println("-------------------------------");
    }

    @org.junit.jupiter.api.Test
    void removeTaskidErrada() {
        ToDoTasks tasks = new ToDoTasks();
        System.out.println("-----------removeTaskidErrada--------------");
        System.out.print("CRIANDO TASK ");

        String name = "task1";
        String description = "A description";
        String deadline = "10/12/21";
        int priorityLevel = 4;
        String category = "job";
        String status = "todo";

        System.out.println(">> "+ name + " " + description + " " + status);
        tasks.create(name, description, deadline, priorityLevel, category, status);


        System.out.println("TENTA REMOVER TASK INEXISTENTE");
        tasks.delete(3); // REMOVE ID ERRADA


        assertEquals(false,tasks.tasks.isEmpty());

        System.out.println("-------------------------------");
    }

    @org.junit.jupiter.api.Test
    void listTasks() {

        ToDoTasks tasks = new ToDoTasks();
        System.out.println("-----------listTasks--------------");
        System.out.println("CRIANDO TASKS ");

        tasks.create("task0", "description", "01/02/20", 1, "work", "todo");
        tasks.create("task1", "description2", "02/05/22", 4, "home", "doing");
        tasks.create("task2", "description3", "07/06/12", 3, "fun", "done");

        tasks.list();
        assertEquals("[Task{name='task1', description='description2', deadline='02/05/22', priorityLevel=4, category='home', status='doing'}, Task{name='task2', description='description3', deadline='07/06/12', priorityLevel=3, category='fun', status='done'}, Task{name='task0', description='description', deadline='01/02/20', priorityLevel=1, category='work', status='todo'}]",tasks.tasks.toString());

        System.out.println("TAREFAS LISTADAS!");

        System.out.println("-------------------------------");

    }

}