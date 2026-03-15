import java.sql.*;
import java.util.Scanner;

public class TodoMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Connection con = DBConnection.getConnection();

        while(true){

            System.out.println("\n===== TODO LIST MENU =====");
            System.out.println("1 Add Task");
            System.out.println("2 View Tasks");
            System.out.println("3 Complete Task");
            System.out.println("4 Delete Task");
            System.out.println("5 Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try{

                if(choice==1){

                    System.out.print("Enter Task: ");
                    String task = sc.nextLine();

                    String q = "INSERT INTO tasks(task,status) VALUES(?,?)";

                    PreparedStatement ps = con.prepareStatement(q);
                    ps.setString(1,task);
                    ps.setString(2,"Pending");

                    ps.executeUpdate();

                    System.out.println("Task Added Successfully");

                }

                else if(choice==2){

                    String q="SELECT * FROM tasks";
                    Statement st = con.createStatement();

                    ResultSet rs = st.executeQuery(q);

                    System.out.println("\nID | TASK | STATUS");

                    while(rs.next()){
                        System.out.println(
                                rs.getInt("id")+" | "+
                                rs.getString("task")+" | "+
                                rs.getString("status")
                        );
                    }
                }

                else if(choice==3){

                    System.out.print("Enter Task ID to Complete: ");
                    int id=sc.nextInt();

                    String q="UPDATE tasks SET status='Completed' WHERE id=?";

                    PreparedStatement ps=con.prepareStatement(q);
                    ps.setInt(1,id);

                    ps.executeUpdate();

                    System.out.println("Task Marked Completed");

                }

                else if(choice==4){

                    System.out.print("Enter Task ID to Delete: ");
                    int id=sc.nextInt();

                    String q="DELETE FROM tasks WHERE id=?";

                    PreparedStatement ps=con.prepareStatement(q);
                    ps.setInt(1,id);

                    ps.executeUpdate();

                    System.out.println("Task Deleted");

                }

                else if(choice==5){

                    System.out.println("Exiting Program...");
                    break;
                }

                else{
                    System.out.println("Invalid Choice");
                }

            }catch(Exception e){
                e.printStackTrace();
            }

        }

    }

}