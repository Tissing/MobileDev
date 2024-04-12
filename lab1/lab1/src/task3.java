import java.sql.*;

public class task3 {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost/database";
        String username = "login";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            read(connection);
            System.out.println("_____________________________________________");
            delete(connection, "Elon");
            read(connection);
            System.out.println("_____________________________________________");
            update(connection, "Maxim", "mymail@email.com",
                    "www.internet.com", "Измененная запись");
            read(connection);
            System.out.println("_____________________________________________");
            createTable(connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void read(Connection con){
        try{
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT username, email, homepage, usermessage FROM guests LIMIT 20");
            while (results.next()) {
                String username = results.getString(1);
                String email = results.getString(2);
                String homepage = results.getString(3);
                String message = results.getString(4);
                System.out.println(username + " "+ email + " " + homepage + " " + message);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Connection con, String name){
        var s = "DELETE FROM guests WHERE username='"+name+"'";
        try{
            Statement statement = con.createStatement();
            int results = statement.executeUpdate(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Connection con, String username, String email, String homepage, String message){
        var s = "UPDATE guests " +
                "SET username = '" + username + "', email = '" + email + "', homepage = '" + homepage
                + "', usermessage = '" + message + "' WHERE id = 1;";
        try{
            Statement statement = con.createStatement();
            int results = statement.executeUpdate(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(Connection con){
        var s = "CREATE TABLE users (id INT, name VARCHAR(50))";
        try{
            Statement statement = con.createStatement();
            statement.executeUpdate(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Таблица users создана");
    }

}
