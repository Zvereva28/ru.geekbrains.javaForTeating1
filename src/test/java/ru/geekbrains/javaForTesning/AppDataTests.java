package ru.geekbrains.javaForTesning;

import org.junit.Test;
import ru.geekbrains.javaForTesting2.AppData;

public class AppDataTests {

    @Test
    public void appDataTest1() {
        AppData appData = new AppData("file.txt");
        appData.printAllData();
    }
}
