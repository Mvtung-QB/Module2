package Controllers;

import Commons.CSVWriter;
import Models.*;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.awt.*;
import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MainControler {
    private ArrayList<Services> arrayVilla = new ArrayList<>();
    private ArrayList<Services> arrayHouse = new ArrayList<>();
    private ArrayList<Services> arrayRoom = new ArrayList<>();
    private ArrayList<Customer> arrayCustumer = new ArrayList<>();
    private Pattern filterNameService = Pattern.compile("^([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$");
    private Pattern filteGender = Pattern.compile("^\\bMale|\\bFemale|\\bUnknow$");
    private Pattern filteBirthday = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$$");
    private Pattern filteIdCard = Pattern.compile("^[0-9]{9}$");
    Pattern filteService = Pattern.compile("^\\bVilla|\\bHouse|\\bRoom$");
    private Pattern filteEmail = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private Matcher matcher;

    public void displayMainMenu() {
        System.out.println("=======// Main Menu //=======" +
                "\n 1.         Add New Services" +
                "\n 2.         Show Services" +
                "\n 3.         Add New Custumer" +
                "\n 4.         Show information Custumer" +
                "\n 5.         Add New Booking Resort " +
                "\n 6.         Exit");
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
                addNewCustumer();
                break;
            case 4:
                showInfomationCustumer();
                break;
            case 5:
                addNewBooking();
            case 6:
                System.exit(0);
            default:
                System.out.println("Chọn lại ");
                displayMainMenu();
                break;
        }
    }

    public void addNewBooking(){
        ArrayList<Customer> customer = new ArrayList<>();
        for (Customer cus : CSVWriter.readCsvFileToCustumer()) {
            customer.add(cus);
        }
        for (int i = 0; i <customer.size()-1 ; i++) {
            System.out.println((i+1)+ ", "+customer.get(i).showInformation());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        }
        System.out.println("Select Custumer");
        int select = new Scanner(System.in).nextInt();
        bookingService(customer.get(select-1));
        CSVWriter.writeBookingToCsvFile(customer);
    }

    public void bookingService(Customer customer){
        System.out.println("-------Booking Service----------" +
                "\n1, Booking Villa" +
                "\n2, Booking House" +
                "\n3, Booking Room" +
                "\n4, Back to main menu" +
                "\n5, Exist");
        Scanner sc = new Scanner(System.in);
        int chooseTypeService = sc.nextInt();
        chooseShowService(chooseTypeService);
        System.out.println("Select service booking");
        int choose = sc.nextInt();
        if (chooseTypeService==1) {
            customer.setServices(CSVWriter.readCsvFileToVilla().get(choose-1));
        }else if (chooseTypeService == 2 ){
            customer.setServices(CSVWriter.readCsvFileToHouse().get(choose-1));
        }else if (chooseTypeService == 3){
            customer.setServices(CSVWriter.readCsvFileToRoom().get(choose-1));
        }else {
            System.out.println("Chon sai");
        }
    }

    public void addNewCustumer() {
        Customer customer = new Customer();
        Scanner sc = new Scanner(System.in);
        String name, gender;
        String birthday;
        int idCard;
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
        customer.setGender(gender);
        System.out.println("Enter Address Custumer ");
        customer.setAddress(sc.nextLine());
        System.out.println("Enter Loai Custumer ");
        customer.setLoại(sc.nextLine());
        do {
            System.out.println("Enter birthay Custumer (dd/mm/yyyy)");
            birthday = sc.nextLine();
            matcher = filteBirthday.matcher(birthday);
        } while (!matcher.find());
        customer.setBirtherday(birthday);
        do {
            System.out.println("Enter ID card");
            idCard = sc.nextInt();
            matcher = filteIdCard.matcher(idCard + "");
        } while (!matcher.find());
        customer.setIdCard(idCard);
        int phoneNumber;
        do {
            System.out.println("Enter PhoneNumber");
            phoneNumber = sc.nextInt();
            matcher = filteIdCard.matcher(phoneNumber + "");
        } while (!matcher.find());
        customer.setPhoneNumber(phoneNumber);
        String email;
        do {
            System.out.println("Enter Email Custumer");
            email = sc.nextLine();
            matcher = filteEmail.matcher(email);
        } while (!matcher.find());
        customer.setEmail(email);
//       String services;
//       do {
//           System.out.println("Enter Service Custumer");
//           services = sc.nextLine() ;
//           matcher = filteService.matcher(services);
//       }while (!matcher.find());
        for (Customer cus : CSVWriter.readCsvFileToCustumer()) {
            arrayCustumer.add(cus);
        }
        arrayCustumer.add(customer);
        CSVWriter.writeCustumerToCsvFile(arrayCustumer);
    }

    public void sapXep(ArrayList<Customer> arrayCustumer) {
        Collections.sort(arrayCustumer, new Comparator<Customer>() {
            @Override
            public int compare(Customer cus1, Customer cus2) {
                return cus1.getNameCustumer().compareTo(cus2.getNameCustumer());
            }
        });
    }

    public void showInfomationCustumer() {
        ArrayList<Customer> arr = new ArrayList<>();
        for (Customer cus : CSVWriter.readCsvFileToCustumer()) {
            arr.add(cus);
        }
        sapXep(arr);
        for (Customer cus : arr) {
            System.out.println(cus.showInformation());
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
        Scanner scs;
        String typeSv, nameSv;
        float areaUse = 0;
        int rentCost = 0, maxUser = 0;

        // Nhập Type Service

        do {
            System.out.println("Enter Type  Service ");
            typeSv = sc.nextLine();
            matcher = filterNameService.matcher(typeSv);
        } while (!matcher.find());
        newService.setTypeServices(typeSv);

        // Nhập Tên service

        do {
            System.out.println("Enter Name Service ");
            nameSv = sc.nextLine();
            matcher = filterNameService.matcher(nameSv);
        } while (!matcher.find());
        newService.setNameServises(nameSv);

        // Nhập Area use

        while (areaUse < 30) {
            try {
                System.out.println("Enter Area use (>30)");
                scs = new Scanner(System.in);
                areaUse = scs.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Area use là số ");
            }
        }
        newService.setAreaUse(areaUse);

        // NHập Rent Cost

        do {
            try {
                System.out.println("Enter Rent Costs ");
                scs = new Scanner(System.in);
                rentCost = scs.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Rent Costs Là Số Dương");
            }
        } while (rentCost < 0);
        newService.setRentalCosts(rentCost);

        // Nhập Max user

        do {
            try {
                scs = new Scanner(System.in);
                System.out.println("Enter Max User (>0 and <20)");
                maxUser = scs.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Max User là Số và (>0 and <20)");
            }

        } while (maxUser < 0 || maxUser > 20);
        newService.setMaxUser(maxUser);

    }

    public void addHouse(Services newHouse) {
        addService(newHouse);
        int soTang=0;
        Scanner sc ;
        System.out.println("Enter Tiêu chuẩn ");
        ((House) newHouse).setTieuChuan(new Scanner(System.in).nextLine());
        System.out.println("Enter Mô Tả ");
        ((House) newHouse).setMoTa(new Scanner(System.in).nextLine());

        // Số tâng

        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Enter Số Tầng ");
                soTang = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println(" Số tâng là số Dương");
            }
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
        int soTang= 0;
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Enter Số Tầng ");
                soTang = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println(" Số tâng là số Dương");
            }
        } while (soTang < 0);
        ((Villa) newVilla).setSoTang(soTang);

        // Diện Tích Hồ Bơi

        float area=0;
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Diện Tích Hồ Bơi ");
                area = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println(" Diện tích là số Dương");
            }
        } while (area> 30);

        ((Villa) newVilla).setDienTichHoBoi(area);
        // Lấy DL từ file CSV sang arrayList
        for (Villa element : CSVWriter.readCsvFileToVilla()) {
            arrayVilla.add(element);
        }
        arrayVilla.add((Villa) newVilla);
        // Ghi Lại Vào file CSV
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
        int i=1;
        for (Services e : CSVWriter.readCsvFileToHouse()) {
            System.out.println(i+" -  "+((House) e).showInfor());
            i++;
        }
    }

    public void printArrVilla() {
        int i=1;
        for (Services e : CSVWriter.readCsvFileToVilla()) {
            System.out.println(i+" -  "+((Villa) e).showInfor());
        }
    }

    public void printArrRoom() {
        int i=1;
        for (Services e : CSVWriter.readCsvFileToRoom()) {
            System.out.println(i+" -  "+((Room) e).showInfor());
        }
    }

}
