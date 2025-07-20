package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoController {

    private long todoid;
    private Scanner scanner;
    private ArrayList<Todo> todos;

    public TodoController() {
        todoid = 0;
        todos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void add() {
        System.out.print("할일 : ");
        String content = scanner.nextLine().trim();
        Todo todo = new Todo(todoid, content);
        todos.add(todo);
        System.out.printf("%d번 할일이 생성되었습니다.\n", todoid);
        todoid++;
    }
    public void list() {
        System.out.println("번호 / 내용");
        for (Todo todo : todos){
            System.out.printf("%d / %s\n", todo.getId(), todo.getContent());
        }
    }
    public void del() {
        System.out.print("삭제할 할일의 번호 : ");
        long id = Long.parseLong(scanner.nextLine().trim());
        boolean isRemoved = todos.removeIf(todo -> todo.getId() == id);
        if (isRemoved) {
            System.out.printf("%d번 할일이 삭제되었습니다.\n", id);
            return;
        }
        System.out.printf("%d번 할일은 존재하지 않습니다.\n", id);
    }
    public void modify() {
        System.out.print("삭제할 할일의 번호 : ");
        long id = Long.parseLong(scanner.nextLine().trim());
        Todo foundTodo = todos.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        if (foundTodo == null) {
            System.out.printf("%d번 할일은 존재하지 않습니다.\n", id);
            return;
        }
        System.out.printf("기존 할일 : %s\n", foundTodo.getContent());
        System.out.print("새 할일 : ");
        String newContent = scanner.nextLine().trim();
        foundTodo.setContent(newContent);
        System.out.printf("%d번 할일이 수정되었습니다.\n", id);
    }
}
