package mainPackage;

import java.io.*;
import java.util.*;

public class Todolist {

    public static void main (String [] args) throws Exception{

        Scanner input = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        int flag = 0;

        //Carrega lista de tasks na memória
        FileReader fileR = new FileReader("tasks.txt");
        BufferedReader readFile = new BufferedReader(fileR);

        String line= readFile.readLine();
        while(line != null){

            //Encontra Nome
            int i=0;
            int nameStartin = line.indexOf("name=", i);
            int startWord = nameStartin + 5;
            int endWord = line.indexOf(",", startWord);
            String name = line.substring(startWord+1, endWord-1);
            i = endWord+1;

            //Encontra Descrição
            nameStartin = line.indexOf("description=", i);
            startWord = nameStartin + 12;
            endWord = line.indexOf(",", startWord);
            String description = line.substring(startWord+1, endWord-1);
            i = endWord+1;

            //Encontra deadline
            nameStartin = line.indexOf("deadline=", i);
            startWord = nameStartin + 9;
            endWord = line.indexOf(",", startWord);
            String deadline = line.substring(startWord+1, endWord-1);
            i = endWord+1;

            //Encontra priorityLevel
            nameStartin = line.indexOf("priorityLevel=", i);
            startWord = nameStartin + 14;
            endWord = line.indexOf(",", startWord);
            int priorityLevel = Integer.parseInt(line.substring(startWord, endWord));
            i = endWord+1;

            //Encontra category
            nameStartin = line.indexOf("category=", i);
            startWord = nameStartin + 9;
            endWord = line.indexOf(",", startWord);
            String category = line.substring(startWord+1, endWord-1);
            i = endWord+1;

            //Encontra status
            nameStartin = line.indexOf("status=", i);
            startWord = nameStartin + 7;
            endWord = line.indexOf("}", startWord);
            String status = line.substring(startWord+1, endWord-1);
            i = endWord+1;

            tasks.add(new Task(name,description,deadline,priorityLevel,category,status));
            line = readFile.readLine();
        }

        while(flag!=1) {

            System.out.print("""
                    
                    ToDoList:
                    Qual será sua próxima ação?

                    1 - Criar nova Task
                    2 - Alterar task existente
                    3 - Deletar task
                    4 - Listar tasks

                    -PRESSIONE 0 PARA ENCERRAR-
                    
                    """
            );
            int action = input.nextInt();
            System.out.println(action);
            input.nextLine();

            if(action == 0){
                flag=1;
            }

            if(action == 1){ //Create
                String name;
                String description;
                String deadline;
                int priorityLevel;
                String category;
                String status;

                try {
                    System.out.println("Informe o nome da nova tarefa");
                    name = input.nextLine();
                    System.out.println("Informe a descrição da nova tarefa");
                    description = input.nextLine();
                    System.out.println("Informe a deadline da nova tarefa");
                    deadline = input.nextLine();
                    System.out.println("Informe o nível de prioridade da nova tarefa (de 1 a 5)");
                    priorityLevel = input.nextInt();
                    input.nextLine();
                    System.out.println("Informe a categoria da nova tarefa");
                    category = input.nextLine();
                    System.out.println("Informe status da nova tarefa");
                    status = input.nextLine();

                    Task newTask = new Task(name,description,deadline,priorityLevel,category,status);

                    tasks.add(newTask);
                    System.out.println("Nova Task Adicionada");
                }
                catch (Exception e) {
                    throw new Exception("Erro ao criar nova tarefa");
                }
            }

            if(action == 2){//Update
                if(tasks.size()>0){
                    for (int i=0; i<tasks.size();i++){
                        System.out.println(i+1 + " - " + tasks.get(i) + "\n");
                    }

                    try{
                        System.out.println("Informe o id da Task que será atualizada");
                        int idToRemove = input.nextInt();
                        input.nextLine();
                        tasks.remove(idToRemove+1);

                        String name;
                        String description;
                        String deadline;
                        int priorityLevel;
                        String category;
                        String status;

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

                        Task newTask = new Task(name,description,deadline,priorityLevel,category,status);

                        tasks.add(newTask);
                        System.out.println("Task atualizada com sucesso");

                    } catch (Exception e) {
                        throw new Exception("Erro ao tentar atualizar task");
                    }
                }else{
                    System.out.println("Não há nenhuma task criada");
                }
            }

            if(action == 3){//Delete
                if(tasks.size()>0){
                    for (int i=0; i<tasks.size();i++){
                        System.out.println(i+1 + " - " + tasks.get(i) + "\n");
                    }

                    try {
                        System.out.println("Informe o ID da tafera que será removida\n");
                        int idToRemove = input.nextInt();
                        input.nextLine();

                        tasks.remove(idToRemove+1);
                        System.out.println("Tarefa removida com sucesso!!");

                    } catch (Exception e) {
                        throw new Exception("Erro ao tentar deletar task");
                    }

                }else{
                    System.out.println("Não existe nenhuma task criada");
                }
            }

            if(action == 4){//List
                if(tasks.size()>0){
                    for (int i=0; i<tasks.size();i++){
                        System.out.println(i+1 + " - " + tasks.get(i));
                    }
                }else{
                    System.out.println("Não existe nenhuma task criada\n");
                }
            }

            // Ordena Array de Tasks
            Collections.sort(tasks, new Comparator<Task>() {
                @Override
                public int compare(Task a, Task b) {
                    if(a.getPriorityLevel()<b.getPriorityLevel()){
                        return 1;
                    }return -1;
                }
            });
        }
        //salvar arraylist em .txt

        FileWriter file = new FileWriter("tasks.txt");
        PrintWriter printFile = new PrintWriter(file);

        for (int i=0; i<tasks.size(); i++){
            printFile.println(tasks.get(i));
        }
        file.close();
        input.close();
    }

}
