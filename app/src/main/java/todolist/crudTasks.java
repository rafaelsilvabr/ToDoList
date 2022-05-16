package todolist;

public interface crudTasks {

    void create(String name, String description, String deadline, int priorityLevel, String category, String status);
    void delete(int idToRemove);
    void update(int idToUpdate);
    void list();
}
