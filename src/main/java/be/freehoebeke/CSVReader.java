package be.freehoebeke;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("H:mm");
    private final String[] HEADERS = {"date", "go_to_sleep_hour", "wake_up_hour", "amount_of_sleep"};

    public void createCSVFile(String newFileName) throws IOException {
        FileWriter out = new FileWriter(newFileName);
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(HEADERS))) {
            System.out.println("file created");
        }
    }

    public void addLineToFile(String fileName, String date, String goToSleepHour, String wakeUpHour, String amountOfSleep) throws IOException {
        FileWriter out = new FileWriter(fileName);
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(HEADERS))) {
            printer.printRecord(date, goToSleepHour, wakeUpHour, amountOfSleep);
            System.out.println("line added");
        }
    }

    public NightOfSleep accessDataByDate(String fileName, LocalDate date) throws IOException {
        Reader in = new FileReader(fileName);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(in);
        for (CSVRecord record : records) {
            if (record.get("date").equals(date.toString())) {
                return new NightOfSleep(LocalDate.parse(record.get("date")), LocalTime.parse(record.get("go_to_sleep_hour"), FORMATTER), LocalTime.parse(record.get("wake_up_hour"), FORMATTER), LocalTime.parse(record.get("amount_of_sleep"), FORMATTER));
            }
        }
        return null;
    }

    public List<NightOfSleep> accessAllLines(String fileName) throws IOException {
        Reader in = new FileReader(fileName);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(in);
        List<NightOfSleep> listOfResults = new ArrayList<>();
        for (CSVRecord record : records) {
            listOfResults.add(new NightOfSleep(LocalDate.parse(record.get("date")), LocalTime.parse(record.get("go_to_sleep_hour"), FORMATTER), LocalTime.parse(record.get("wake_up_hour"), FORMATTER), LocalTime.parse(record.get("amount_of_sleep"), FORMATTER)));
        }
        return listOfResults;
    }

    public void tryTimeFormat() {
        System.out.println(LocalDateTime.now().format(FORMATTER));
        System.out.println(LocalTime.parse("22:23", FORMATTER));
    }


}

