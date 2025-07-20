package org.example;

import java.util.Scanner;

public class App {
    private Scanner scanner;
    private TodoController todoController;
    public App() {
        scanner = new Scanner(System.in);
        todoController = new TodoController();
    }

    public void run() {
        System.out.println("할일 관리 앱, 시작");
        while(true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();
            if (cmd.equals("exit")) break;
            else if (cmd.equals("add")){
                todoController.add();
            }
            else if (cmd.equals("list")){
                todoController.list();
            }
            else if (cmd.equals("del")){
                todoController.del();
            }
            else if (cmd.equals("modify")){
                todoController.modify();
            }
        }
        System.out.println("할일 관리 앱, 끝");

    }
}
