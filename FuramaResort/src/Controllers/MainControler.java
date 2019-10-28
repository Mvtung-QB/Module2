package Controllers;

import Commons.CSVWriter;
import Models.*;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.awt.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MainControler {
    ArrayList<Services> arrayVilla = new ArrayList<>();
    ArrayList<Services> arrayHouse = new ArrayList<>();
    ArrayList<Services> arrayRoom = new ArrayList<>();
    ArrayList<Customer> arrayCustumer = new ArrayList<>();
    String text = "sadsad";
    Pattern filterNameService = Pattern.compile("^([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$");
    Pattern filteGender = Pattern.compile("^[Male|Female|Unknow]$");
    Matcher matcher;

    public void displayMainMenu() {
        System.out.println("=======// Main Menu //=======" +
                "\n 1.         Add New Services" +
                "\n 2.         Show Services" +
                "\n 3.         Add New Custumer" +
                "\n 4.         Show information Custumer" +
                "\n 5.         Exit");
        Scanner sc = new Scanner(System.in);
        chooseService(sc.nextInt());
    }

    public void chooseService(int num) {
        switch (num) {
            case 1:
                addNewServies();
                break;
            case 2:
                ShowServies();
                break;
            case 3:
                System.exit(0);
            case 4:
                addNewCustumer();
                break;
            case 5:
                showInfomationCustumer();
                break;
            default:
                System.out.println("Chọn lại ");
                displayMainMenu();
                break;
        }
    }
   public void addNewCustumer(){
        Customer customer = new Customer();
        Scanner sc= new Scanner(System.in);
        String name,gender;
        customer.setId(UUID.randomUUID().toString().replace("-", ""));
       do {
           System.out.println("Enter Name Custumer ");
           name = sc.nextLine();
           matcher = filterNameService.matcher(name);
       } while (!matcher.find());
       customer.setNameCustumer(name);
       do {
           System.out.println("Enter Gender Custumer ");
           gender = sc.nextLine();
           matcher = filteGender.matcher(gender);
       } while (!matcher.find());
       String birtherday;
       int idCard;
       int phoneNumber;
       String email;
       String loại;
       String address;
       Services services;


    }
    public void showInfomationCustumer(){

    }

    public void addNewServies() {
        System.out.println("=======// Add New Service //=======\n" +
                "1. Add New Villa\n" +
                "2. Add New House\n" +
                "3. Add New Room\n" +
                "4. Back to menu\n" +
                "5. Exit\n");
        Scanner sc = new Scanner(System.in);
        chooseNewService(sc.nextInt());
    }

    public void chooseNewService(int num) {
        switch (num) {
            case 1:
                addVilla(new Villa());
                break;
            case 2:
                addHouse(new House());
                break;
            case 3:
                addRoom(new Room());
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Chọn sai trở lại main menu");
                displayMainMenu();
                break;
        }
    }

    public void ShowServies() {
        System.out.println("=======// Show Service //=======\n" +
                "1. Show Villa\n" +
                "2. Show House\n" +
                "3. Show Room\n" +
                "4. Back to menu\n" +
                "5. Exit\n");
        Scanner sc = new Scanner(System.in);
        chooseShowService(sc.nextInt());
    }

    public void chooseShowService(int num) {
        switch (num) {
            case 1:
                printArrVilla();
                break;
            case 2:
                printArrHouse();
                break;
            case 3:
                printArrRoom();
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println(" Chon sai trở lại main menu");
                break;
        }
    }

    public void addService(Services newService) {
        newService.setId(UUID.randomUUID().toString().replace("-", ""));
        Scanner sc = new Scanner(System.in);
        String typeSv, nameSv;
        float areaUse;
        int rentCost, maxUser;
        do {
            System.out.println("Enter Type  Service ");
            typeSv = sc.nextLine();
            matcher = filterNameService.matcher(typeSv);
        } while (!matcher.find());
        newService.setTypeServices(typeSv);
        do {
            System.out.println("Enter Name Service ");
            nameSv = sc.nextLine();
            matcher = filterNameService.matcher(nameSv);
        } while (!matcher.find());
        newService.setNameServises(nameSv);
        do {
            System.out.println("Enter Area use (>30)");
            areaUse = sc.nextFloat();
        } while (areaUse < 30);
        newService.setAreaUse(areaUse);
        do {
            System.out.println("Enter Rent Costs ");
            rentCost = sc.nextInt();
        } while (rentCost < 0);
        newService.setRentalCosts(rentCost);
        do {
            System.out.println("Enter Max User (>0 and <20");
            maxUser = sc.nextInt();
        } while (maxUser < 0 || maxUser > 20);
        newService.setMaxUser(maxUser);
    }

    public void addHouse(Services newHouse) {
        addService(newHouse);
        int soTang;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Tiêu chuẩn ");
        ((House) newHouse).setTieuChuan(sc.nextLine());
        System.out.println("Enter Mô Tả ");
        ((House) newHouse).setMoTa(sc.nextLine());
        do {
            System.out.println("Enter Số Tầng ");
            soTang = sc.nextInt();
        } while (soTang < 0);
        ((House) newHouse).setSoTang(soTang);

        for (House element : CSVWriter.readCsvFileToHouse()) {
            arrayHouse.add(element);
        }
        arrayHouse.add((House) newHouse);
        CSVWriter.writeHouseToCsvFile(arrayHouse);
    }

    public void addVilla(Services newVilla) {
        addService(newVilla);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Tiêu chuẩn ");
        ((Villa) newVilla).setTieuChuan(sc.nextLine());
        System.out.println("Enter Mô Tả ");
        ((Villa) newVilla).setMoTa(sc.nextLine());
        System.out.println("Enter Số Tầng ");
        ((Villa) newVilla).setSoTang(sc.nextInt());
        System.out.println("Diện Tích Hồ Bơi ");
        ((Villa) newVilla).setDienTichHoBoi(sc.nextFloat());
        for (Villa element : CSVWriter.readCsvFileToVilla()) {
            arrayVilla.add(element);
        }
        arrayVilla.add((Villa) newVilla);
        CSVWriter.writeVillaToCsvFile(arrayVilla);
    }

    public void addRoom(Services newRoom) {
        Scanner sc = new Scanner(System.in);
        addService(newRoom);
        for (Room element : CSVWriter.readCsvFileToRoom()) {
            arrayRoom.add(element);
        }
        arrayRoom.add((Room) newRoom);
        CSVWriter.writeRoomToCsvFile(arrayRoom);
    }

    public void printArrHouse() {
        for (Services e : CSVWriter.readCsvFileToHouse()) {
            System.out.println(((House) e).showInfor());
        }
    }

    public void printArrVilla() {
        for (Services e : CSVWriter.readCsvFileToVilla()) {
            System.out.println(((Villa) e).showInfor());
        }
    }

    public void printArrRoom() {
        for (Services e : CSVWriter.readCsvFileToRoom()) {
            System.out.println(((Room) e).showInfor());
        }
    }

}
