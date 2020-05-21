package ru.geekbrains.zvereva.lesson3;
public class Main {
    public static void main(String[] args) {
        DataBase usersData = new DataBase("users");

        usersData.newUsers("Vikatr 96 turtjvf@jhgdf.rt");
        usersData.deleteUserByName("null");
        usersData.printAllUsers();
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        usersData.printUsersByAge(25,50);
    }
}
