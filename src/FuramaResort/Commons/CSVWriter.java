package FuramaResort.Commons;

import FuramaResort.Models.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {
    // Delimiter used in CSV file
    private static final char COMMA_DELIMITER = ',';
    private static final char NEW_LINE_SEPARATOR = '\n';
    private static final int NUM_OF_LINE_SKIP = 1;

    // CSV file header
    private static final String VILLA_FILE_HEADER = "id,typeServices,nameServises,areaUse,rentalCosts,maxUser,tieuChuan,moTa,soTang,dienTichHoBoi";
    private static final String HOUSE_FILE_HEADER = "id,typeServices,nameServises,areaUse,rentalCosts,maxUser,tieuChuan,moTa,soTang";
    private static final String ROOM_FILE_HEADER = "id,typeServices,nameServises,areaUse,rentalCosts,maxUser";
    private static final String CUSTUMER_FILE_HEADER = "id,nameCustumer,gender,birtherday,idCard,phoneNumber,email,loại,address";
    private static final String BOOKING_FILE_HEADER = "id,nameCustumer,gender,birtherday,idCard,phoneNumber,email,loại,address,typeServices,nameServises,areaUse,rentalCosts,maxUser";

    public static void writeVillaToCsvFile(List<Services> villa) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/FuramaResort/Data/Villa.csv");

            // Write the CSV file header
            fileWriter.append(VILLA_FILE_HEADER);

            // Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            // Write a new Service object list to the CSV file
            for (Services v : villa) {
                fileWriter.append(String.valueOf(v.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(((Villa) v).getTypeServices());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(((Villa) v).getNameServises());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(((Villa) v).getAreaUse()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(((Villa) v).getRentalCosts()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(((Villa) v).getMaxUser()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(((Villa) v).getTieuChuan());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(((Villa) v).getMoTa());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(((Villa) v).getSoTang()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(((Villa) v).getDienTichHoBoi()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    public static void writeHouseToCsvFile(List<Services> house) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/FuramaResort/Data/House.csv");

            // Write the CSV file header
            fileWriter.append(HOUSE_FILE_HEADER);

            // Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            // Write a new Service object list to the CSV file
            for (Services v : house) {
                fileWriter.append(String.valueOf(v.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(((House) v).getTypeServices());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(((House) v).getNameServises());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(((House) v).getAreaUse()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(((House) v).getRentalCosts()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(((House) v).getMaxUser()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(((House) v).getTieuChuan());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(((House) v).getMoTa());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(((House) v).getSoTang()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    public static void writeRoomToCsvFile(List<Services> room) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/FuramaResort/Data/Room.csv");

            // Write the CSV file header
            fileWriter.append(ROOM_FILE_HEADER);

            // Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            // Write a new Service object list to the CSV file
            for (Services v : room) {
                fileWriter.append(String.valueOf(v.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(((Room) v).getTypeServices());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(((Room) v).getNameServises());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(((Room) v).getAreaUse()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(((Room) v).getRentalCosts()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(((Room) v).getMaxUser()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    public static void writeCustumerToCsvFile(List<Customer> customers) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/FuramaResort/Data/Custumer.csv");

            // Write the CSV file header
            fileWriter.append(CUSTUMER_FILE_HEADER);

            // Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            // Write a new Service object list to the CSV file
            for (Customer v : customers) {
                fileWriter.append(String.valueOf(v.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(v.getNameCustumer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(v.isGender());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(v.getBirtherday());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(v.getIdCard()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(v.getPhoneNumber()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(v.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(v.getLoại());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(v.getAddress());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
    public static void writeBookingToCsvFile(Customer customers) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/FuramaResort/Data/Booking.csv");

            // Write the CSV file header
            fileWriter.append(BOOKING_FILE_HEADER);

            // Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            // Write a new Service object list to the CSV file
                fileWriter.append(String.valueOf(customers.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customers.getNameCustumer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customers.isGender());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customers.getBirtherday());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customers.getIdCard()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customers.getPhoneNumber()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customers.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customers.getLoại());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customers.getAddress());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customers.getServices().getTypeServices());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customers.getServices().getNameServises());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customers.getServices().getAreaUse()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customers.getServices().getRentalCosts()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customers.getServices().getMaxUser()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
    public static ArrayList<Villa> readCsvFileToVilla() {
        String[] newVillaHeader = VILLA_FILE_HEADER.split(",");
        Path path = Paths.get("src/FuramaResort/Data/Villa.csv");
        if (!Files.exists(path))
            try {
                Writer writer = new FileWriter("src/FuramaResort/Data/Villa.csv");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        ColumnPositionMappingStrategy<Villa> column = new ColumnPositionMappingStrategy<>();
        column.setType(Villa.class);
        column.setColumnMapping(newVillaHeader);
        CsvToBean<Villa> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Villa>(new FileReader("src/FuramaResort/Data/Villa.csv"))
                    .withMappingStrategy(column)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar('"')
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<Villa>) csvToBean.parse();
    }

    public static ArrayList<Room> readCsvFileToRoom() {
        String[] newVillaHeader = ROOM_FILE_HEADER.split(",");
        Path path = Paths.get("src/FuramaResort/Data/Room.csv");
            if (!Files.exists(path))
                try{
                    Writer writer = new FileWriter("src/FuramaResort/Data/Room.csv");
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
        ColumnPositionMappingStrategy<Room> column = new ColumnPositionMappingStrategy<>();
        column.setType(Room.class);
        column.setColumnMapping(newVillaHeader);
        CsvToBean<Room> csvToBean = null;

        try {
            csvToBean = new CsvToBeanBuilder<Room>(new FileReader("src/FuramaResort/Data/Room.csv"))
                    .withMappingStrategy(column)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar('"')
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<Room>) csvToBean.parse();
    }

    public static ArrayList<House> readCsvFileToHouse() {
        String[] newVillaHeader = ROOM_FILE_HEADER.split(",");
        Path path = Paths.get("src/FuramaResort/Data/House.csv");
            if (!Files.exists(path))
                try{
                    Writer writer = new FileWriter("src/FuramaResort/Data/House.csv");
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
        ColumnPositionMappingStrategy<House> column = new ColumnPositionMappingStrategy<>();
        column.setType(House.class);
        column.setColumnMapping(newVillaHeader);
        CsvToBean<House> csvToBean = null;

        try {
            csvToBean = new CsvToBeanBuilder<House>(new FileReader("src/FuramaResort/Data/House.csv"))
                    .withMappingStrategy(column)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar('"')
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<House>) csvToBean.parse();
    }

    public static ArrayList<Customer> readCsvFileToCustumer() {
        String[] newCustumerHeader = CUSTUMER_FILE_HEADER.split(",");
        Path path = Paths.get("src/FuramaResort/Data/Custumer.csv");
        if (!Files.exists(path))
            try{
                Writer writer = new FileWriter("src/FuramaResort/Data/Custumer.csv");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        ColumnPositionMappingStrategy<Customer> column = new ColumnPositionMappingStrategy<>();
        column.setType(Customer.class);
        column.setColumnMapping(newCustumerHeader);
        CsvToBean<Customer> csvToBean = null;

        try {
            csvToBean = new CsvToBeanBuilder<Customer>(new FileReader("src/FuramaResort/Data/Custumer.csv"))
                    .withMappingStrategy(column)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar('"')
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<Customer>) csvToBean.parse();
    }
    public static ArrayList<Customer> readCsvBooKingToCustumer() {
        String[] newCustumerHeader = BOOKING_FILE_HEADER.split(",");
        Path path = Paths.get("src/FuramaResort/Data/Booking.csv");
        if (!Files.exists(path))
            try{
                Writer writer = new FileWriter("src/FuramaResort/Data/Booking.csv");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        ColumnPositionMappingStrategy<Customer> column = new ColumnPositionMappingStrategy<>();
        column.setType(Customer.class);
        column.setColumnMapping(newCustumerHeader);
        CsvToBean<Customer> csvToBean = null;

        try {
            csvToBean = new CsvToBeanBuilder<Customer>(new FileReader("src/FuramaResort/Data/Booking.csv"))
                    .withMappingStrategy(column)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar('"')
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<Customer>) csvToBean.parse();
    }


}
