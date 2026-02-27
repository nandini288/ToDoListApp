import java.util.ArrayList;
import java.util.Scanner;

class ToDoList{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int choice ;
        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<String> completedTasks = new ArrayList<>();
        ArrayList<String> deletedTasks = new ArrayList<>();
        do { 
            System.out.println("1.Add Task");
            System.out.println("2.View Task");
            System.out.println("3.Task Completed");
            System.out.println("4.Delete Task");
            System.out.println("5.Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline left by nextInt()
            switch(choice){
                case 1:
                    System.out.println("Enter the Task: ");
                    String task=sc.nextLine();
                    tasks.add(task);
                    System.out.println("Task added successfully");
                    break;
                case 2:
                    if(tasks.isEmpty()){
                        System.out.println("No tasks to show");
                        break;
                    }else{
                        System.out.println("Your tasks are:");
                        System.out.println("-----your tasks-----");
                        for(int i=0;i<tasks.size();i++){
                            System.out.println((i+1)+". "+tasks.get(i));    
                        }
                        System.out.println("------------------------");
                        break;
                    } 
                case 3:
                    System.out.println("Enter the task number to mark as completed:");
                    String completedTask = sc.nextLine();
                    String[] completedTaskArr = completedTask.split(",");                    
                    for(String taskNum : completedTaskArr){
                        int taskIndex = Integer.parseInt(taskNum.trim()) - 1;
                        if(taskIndex >= 0 && taskIndex < tasks.size()){
                            completedTasks.add(tasks.get(taskIndex));
                        }
                    }
                    System.out.println("the completed tasks are: "+completedTasks);
                    break;
                case 4:
                    System.out.println("Enter the task number to delete:");
                    String deletedTask = sc.nextLine();
                    String[] deletedTaskArr = deletedTask.split(",");
                    for(String taskNum : deletedTaskArr){
                        int taskIndex = Integer.parseInt(taskNum.trim()) - 1;
                        if(taskIndex >= 0 && taskIndex < tasks.size()){
                            deletedTasks.add(tasks.get(taskIndex));
                            tasks.remove(taskIndex);
                        }
                    }
                    
                    System.out.println("Deleted tasks:");
                    for(String t : deletedTasks){
                        System.out.println(t);
                    }
                    System.out.println("Task deleted successfully");
                    break;
                case 5:
                    System.out.println("Exiting the program");
                    break; 
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }
}
