package academy.learnprogramming.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {

    // == fields ==
    private static int idValue = 1;

    private final List<TodoItem> items = new ArrayList<>();

    // == constructors ==
    public TodoData(){

        addItem(new TodoItem("First", "First Item", LocalDate.now()));
        addItem(new TodoItem("Second", "Second Item", LocalDate.now()));
        addItem(new TodoItem("Third", "Third Item", LocalDate.now()));

    }
    // == public methods ==

    public List<TodoItem> getItems(){
        return Collections.unmodifiableList(items);
    }
    public void addItem(@NonNull TodoItem toAdd){
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }
    public void removeItem(int id){
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while (itemIterator.hasNext()){
            TodoItem item = itemIterator.next();

            if (item.getId() == id){
                itemIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id){
        for (TodoItem item : items){
            if (item.getId()==id){
                return item;
            }
        }
        return null;
    }

    public void updateItem(TodoItem toUpdate){
            ListIterator<TodoItem> itemIterator = items.listIterator();

            while (itemIterator.hasNext()){
                TodoItem item = itemIterator.next();

                if (item.equals(toUpdate)){
                    itemIterator.set(toUpdate);
                    break;
                }
            }
    }

}
