package mainPackage;

public interface crudTasks {

    void update(int idToUpdate);
    void create(String name, String description, String deadline, int priorityLevel, String category, String status);
    void delete(int idToRemove);
    void list();
}
