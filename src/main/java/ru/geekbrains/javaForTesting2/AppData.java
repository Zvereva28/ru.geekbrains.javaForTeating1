package ru.geekbrains.javaForTesting2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String fileName) {
        this.readFromCSVFile(fileName);
    }

    public void readFromCSVFile(String fileName) {
        List<String[]> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String str = reader.readLine();
            this.header = str.split(";");

            while ((str = reader.readLine()) != null) {
                if (str.split(";").length !=header.length){
                    System.out.println("Не корректные данные");// разобраться с исключением, передалать!!!!
                    break;}
               dataList.add(str.split(";"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.data = new int[dataList.size()][header.length];
        for (int j =0; j < dataList.size(); j++){
        for (int i=0; i < header.length; i++ ){

                data[j][i]= Integer.parseInt(dataList.get(j)[i]);
            }
        }
    }

    public void printAllData(){
        for(String title: header){
        System.out.print(title + "  ");}
        System.out.println();

        for (int i=0; i < data.length; i++ ){
            for (int j =0; j < header.length; j++){
                System.out.print(data[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
