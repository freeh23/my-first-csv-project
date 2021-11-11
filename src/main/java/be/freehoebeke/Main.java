package be.freehoebeke;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {

        String myFile = "personalData.csv";

        CSVReader csvReader = new CSVReader();
        //csvReader.createCSVFile(myFile);


        //csvReader.addLineToFile(myFile, "2021-11-11", "22:47", "3:54", "5:05");

        System.out.println(csvReader.accessDataByDate(myFile, LocalDate.of(2021, 11, 11)));
        //System.out.println(LocalDate.of(2021, 11, 11));
        //csvReader.tryTimeFormat();
    }
}
