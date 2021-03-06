package todolist;

import java.io.*;
import java.util.*;

public class App {

    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        ToDoTasks tasks = new ToDoTasks();
        int flag = 0;

        System.out.println(ClassLoader.getSystemResource("tasks.txt").getFile());

        //Carrega lista de tasks na memória
        FileReader fileR = new FileReader("src/main/resources/tasks.txt");
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

            tasks.create(name,description,deadline,priorityLevel,category,status);
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

                    tasks.create(name,description,deadline,priorityLevel,category,status);
                }
                catch (Exception e) {
                    throw new Exception("Erro ao criar nova tarefa");
                }
            }

            if(action == 2){//Update
                if(tasks.tasks.size()>0){
                    tasks.list();

                    try{
                        System.out.println("Informe o id da Task que será atualizada");
                        int idToUpdate = input.nextInt();
                        input.nextLine();
                        tasks.update(idToUpdate-1);

                    } catch (Exception e) {
                        throw new Exception("Erro ao tentar atualizar task");
                    }
                }else{
                    System.out.println("Não há nenhuma task criada");
                }
            }

            if(action == 3){//Delete
                if(tasks.tasks.size()>0){
                    tasks.list();

                    try {
                        System.out.println("Informe o ID da tafera que será removida\n");
                        int idToRemove = input.nextInt();
                        input.nextLine();

                        tasks.delete(idToRemove-1);

                    } catch (Exception e) {
                        throw new Exception("Erro ao tentar deletar task");
                    }

                }else{
                    System.out.println("Não existe nenhuma task criada");
                }
            }

            if(action == 4){//List
                tasks.list();
            }
        }
        //salvar arraylist em .txt

        FileWriter file = new FileWriter("src/main/resources/tasks.txt");
        PrintWriter printFile = new PrintWriter(file);

        for (Task task : tasks.tasks) {
            printFile.println(task);
        }
        file.close();
        input.close();
    }


}
