package todolist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ToDoTasks implements crudTasks{
    ArrayList<Task> tasks;

    public ToDoTasks() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public void create(String name, String description, String deadline, int priorityLevel, String category, String status) {
        if(priorityLevel>0 && priorityLevel<=5){
            Task newTask = new Task(name,description,deadline,priorityLevel,category,status);
            tasks.add(newTask);

            System.out.println("Nova Task Adicionada");
            sort();
        }
        else {
            System.out.println("Nível de Prioridade permitido apenas entre 1 e 5!");
        }

    }

    @Override
    public void delete(int idToRemove) {
        if(idToRemove < tasks.size()){
            tasks.remove(idToRemove);
            System.out.println("Tarefa removida com sucesso!!");
        }else {
            System.out.println("ID inválido, task não removida!");
        }
    }

    @Override
    public void update(int idToUpdate) {
        if(idToUpdate<tasks.size()) {
            delete(idToUpdate + 1);

            String name;
            String description;
            String deadline;
            int priorityLevel;
            String category;
            String status;

            Scanner input = new Scanner(System.in);

            System.out.println("Informe o novo nome da tarefa");
            name = input.nextLine();
            System.out.println("Informe a nova descrição da tarefa");
            description = input.nextLine();
            System.out.println("Informe a nova deadline da tarefa");
            deadline = input.nextLine();
            System.out.println("Informe o novo nível de prioridade da tarefa (de 1 a 5)");
            priorityLevel = input.nextInt();
            input.nextLine();
            System.out.println("Informe nova a categoria da tarefa");
            category = input.nextLine();
            System.out.println("Informe o novo status da tarefa");
            status = input.nextLine();

            create(name, description, deadline, priorityLevel, category, status);
            System.out.println("Task atualizada com sucesso");
        }else{
            System.out.println("ID Inválido, task não atualizada!");
        }
    }

    @Override
    public void list() {
        if(tasks.size()>0){
            for (int i=0; i<tasks.size();i++){
                System.out.println(i+1 + " - " + tasks.get(i));
            }
        }else{
            System.out.println("Não existe nenhuma task criada\n");
        }
    }

    private void sort(){
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task a, Task b) {
                if(a.getPriorityLevel()<b.getPriorityLevel()){
                    return 1;
                }return -1;
            }
        });
    }

    @Override
    public String toString() {
        return "" + tasks;
    }
}

