package Controllers;

import Commons.CSVWriter;
import Models.House;
import Models.Room;
import Models.Services;
import Models.Villa;

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
    private String filterNameService = "^L";

    public void displayMainMenu() {
        System.out.println("=======// Main Menu //=======" +
                "\n 1.         Add New Services" +
                "\n 2.         Show Services" +
                "\n 3.         Exit");
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
            default:
                System.out.println("Chọn lại ");
                displayMainMenu();
                break;
        }
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
        System.out.println("Enter Type  Service ");
        newService.setTypeServices(sc.nextLine());
        System.out.println("Enter Name Service ");
        newService.setNameServises(sc.nextLine());
        System.out.println("Enter Area use ");
        newService.setAreaUse(sc.nextFloat());
        System.out.println("Enter Rent Costs ");
        newService.setRentalCosts(sc.nextInt());
        System.out.println("Enter Max User ");
        newService.setMaxUser(sc.nextInt());
    }

    public void addHouse(Services newHouse) {
        addService(newHouse);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Tiêu chuẩn ");
        ((House) newHouse).setTieuChuan(sc.nextLine());
        System.out.println("Enter Mô Tả ");
        ((House) newHouse).setMoTa(sc.nextLine());
        System.out.println("Enter Số Tầng ");
        ((House) newHouse).setSoTang(sc.nextInt());
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
        arrayVilla.add((Villa) newVilla);
        CSVWriter.writeVillaToCsvFile(arrayVilla);
    }

    public void addRoom(Services newRoom) {
        Scanner sc = new Scanner(System.in);
        addService(newRoom);
        arrayRoom.add((Room) newRoom);
        CSVWriter.writeRoomToCsvFile(arrayRoom);
    }

    public void printArrHouse() {
        for (Services e : arrayHouse) {
            System.out.println(((House) e).showInfor());
        }
    }

    public void printArrVilla() {
        for (Services e : CSVWriter.readCsvFileToVilla()) {
            System.out.println(((Villa) e).showInfor());
        }
    }

    public void printArrRoom() {
        for (Services e : arrayRoom) {
            System.out.println(((Room) e).showInfor());
        }
    }

}
