package ru.geekbrains.zvereva.lesson3;
import java.sql.*;

public class DataBase {
    String tableName;
    static Connection connection;
    static Statement stmt;
    private PreparedStatement ps;

    public DataBase(String tableName) {
        this.tableName = tableName;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatest", "root", "password");
            stmt = connection.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException("Невозможно подключиться к базе данных");
        }
    }

    public void disconnect(){
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void newUsers(String userInform) {
        this.connect();
        String[] token = userInform.split(" ");
        int age1 = Integer.parseInt(token[1]);
        try {
            ps = connection.prepareStatement("INSERT INTO users (name, age, email) VALUES (?, ?, ?);");
            ps.setString(1, token[0]);
            ps.setInt(2, age1);
            ps.setString(3, token[2]);
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            this.disconnect();
        }
    }

    public void deleteUserByName(String userName){
        this.connect();
        try{
            ps = connection.prepareStatement("DELETE FROM users WHERE name = ?;");
            ps.setString(1, userName);
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            this.disconnect();
        }
    }

    public void printAllUsers(){
        this.connect();
        try{
            ResultSet rs = stmt.executeQuery("SELECT * FROM users;");
            while (rs.next()){
                System.out.println(rs.getInt("id") + "  " + rs.getString("name") + "  " + rs.getInt("age") + "  " + rs.getString("email"));
            }
            rs.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            this.disconnect();
        }
    }

    public void printUsersByAge(int min, int max){
        this.connect();
        try{
            ps = connection.prepareStatement("SELECT * FROM users WHERE age > ? AND age < ?;");
            ps.setInt(1, min);
            ps.setInt(2, max);
            ResultSet rs = ps.executeQuery();
            //ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE age > min AND age < max;");
            while (rs.next()){
                System.out.println(rs.getInt("id") + "  " + rs.getString("name") + "  " + rs.getInt("age") + "  " + rs.getString("email"));
            }
            rs.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            this.disconnect();
        }
    }
}

