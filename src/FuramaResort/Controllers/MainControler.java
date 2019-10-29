package FuramaResort.Controllers;

import FuramaResort.Commons.CSVWriter;
import FuramaResort.Models.*;
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
    private ArrayList<Customer> arrayBooking = new ArrayList<>();
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
                "\n 6.         Show Information Employee " +
                "\n 7.         Exit");
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
                showInfomationeEmployee();
            case 7:
                System.exit(0);
            default:
                System.out.println("Chọn lại ");
                displayMainMenu();
                break;
        }
    }

    public void addNewBooking() {
        ArrayList<Customer> arrCustomer = new ArrayList<>();
        for (Customer cus : CSVWriter.readCsvFileToCustumer()) {
            arrCustomer.add(cus);
        }
        for (int i = 0; i < arrCustomer.size(); i++) {
            System.out.println((i + 1) + ", " + arrCustomer.get(i).showInformation());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        }
        System.out.println("Select Custumer");
        // select custumer
        int select = new Scanner(System.in).nextInt();
        while (select<0 || select> arrCustomer.size()){
            System.out.println(" select >0 Vaf select <"+arrCustomer.size());
            select = new Scanner(System.in).nextInt();
        }
        // setService cho Custumer
        bookingService(arrCustomer.get(select - 1));
        // lay trong booking ra
        for (Customer element : CSVWriter.readBookingToCustumer()) {
            arrayBooking.add(element);
        }
        arrayBooking.add(arrCustomer.get(select - 1));
        //Viet lai vao booking
        CSVWriter.writeBookingToCsvFile(arrayBooking);

        new Scanner(System.in).nextLine();
        displayMainMenu();
    }

    public void bookingService(Customer customer) {
        System.out.println("-------Booking Service----------" +
                "\n1, Booking Villa" +
                "\n2, Booking House" +
                "\n3, Booking Room");
        Scanner sc = new Scanner(System.in);
        int chooseTypeService = sc.nextInt();
        while (chooseTypeService <0 || chooseTypeService >3){
            System.out.println("Chon lai di");
            chooseTypeService = sc.nextInt();
        }
        chooseShowService(chooseTypeService);
        System.out.println("Select service booking");
        int choose = sc.nextInt();
        if (chooseTypeService == 1) {
            customer.setServices(CSVWriter.readCsvFileToVilla().get(choose - 1));
        } else if (chooseTypeService == 2) {
            customer.setServices(CSVWriter.readCsvFileToHouse().get(choose - 1));
        } else if (chooseTypeService == 3) {
            customer.setServices(CSVWriter.readCsvFileToRoom().get(choose - 1));
        } else {
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
        sc.nextLine();
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
                "1. Show All Villa\n" +
                "2. Show All House\n" +
                "3. Show All Room\n" +
                "4. Show All Name Villa Not Duplicate\n" +
                "5. Show All Name House Not Duplicate\n" +
                "6. Show All Name Room Not Duplicate\n" +
                "7. Back to menu\n" +
                "8. Exit\n");
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
                showVillaNotDuplicate();
                break;
            case 5:
                showHouseNotDuplicate();
                break;
            case 6:
                showRoomNotDuplicate();
                break;
            case 7:
                displayMainMenu();
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println(" Chon sai trở lại main menu");
                break;
        }
    }

    public void showVillaNotDuplicate(){
        TreeSet<String> nameVilla= CSVWriter.showNameServiceNotDuplicate("src/FuramaResort/Data/Villa.csv");
        for (String name : nameVilla ) {
            System.out.println(" "+name);
        }
        new Scanner(System.in).nextLine();
    }

    public void showHouseNotDuplicate(){
        TreeSet<String> nameVilla= CSVWriter.showNameServiceNotDuplicate("src/FuramaResort/Data/House.csv");
        for (String name : nameVilla ) {
            System.out.println(" "+name);
        }
        new Scanner(System.in).nextLine();
    }

    public void showRoomNotDuplicate(){
        TreeSet<String> nameVilla= CSVWriter.showNameServiceNotDuplicate("src/FuramaResort/Data/Room.csv");
        for (String name : nameVilla ) {
            System.out.println(" "+name);
        }
        new Scanner(System.in).nextLine();
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
        int soTang = 0;
        Scanner sc;
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
            } catch (InputMismatchException e) {
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
        int soTang = 0;
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Enter Số Tầng ");
                soTang = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(" Số tâng là số Dương");
            }
        } while (soTang < 0);
        ((Villa) newVilla).setSoTang(soTang);

        // Diện Tích Hồ Bơi

        float area = 0;
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Diện Tích Hồ Bơi ");
                area = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(" Diện tích là số Dương");
            }
        } while (area > 30);

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
        int i = 1;
        for (Services e : CSVWriter.readCsvFileToHouse()) {
            System.out.println(i + " -  " + ((House) e).showInfor());
            i++;
        }
    }

    public void printArrVilla() {
        int i = 1;
        for (Services e : CSVWriter.readCsvFileToVilla()) {
            System.out.println(i + " -  " + ((Villa) e).showInfor());
            i++;
        }
    }

    public void printArrRoom() {
        int i = 1;
        for (Services e : CSVWriter.readCsvFileToRoom()) {
            System.out.println(i + " -  " + ((Room) e).showInfor());
            i++;
        }
    }

    public void showInfomationeEmployee(){
        Employee employee1 = new Employee("NV01","Ha",40,"Quang Binh");
        Employee employee2 = new Employee("NV02","Ha1",40,"Quang Binh");
        Employee employee3 = new Employee("NV03","Ha2",40,"Quang Binh");
        Employee employee4 = new Employee("NV04","Ha3",40,"Quang Binh");
        Employee employee5 = new Employee("NV05","Ha4",40,"Quang Binh");
        Employee employee6 = new Employee("NV06","Ha5",40,"Quang Binh");
        Employee employee7 = new Employee("NV07","Ha6",40,"Quang Binh");
        Employee employee8 = new Employee("NV08","Ha7",40,"Quang Binh");
        Employee employee9 = new Employee("NV09","Ha8",40,"Quang Binh");
        Employee employee10 = new Employee("NV10","Ha9",40,"Quang Binh");
        Map<String, Employee> map = new HashMap<String, Employee>();
        map.put(employee1.getId(), employee1);
        map.put(employee2.getId(), employee2);
        map.put(employee3.getId(), employee3);
        map.put(employee4.getId(), employee4);
        map.put(employee5.getId(), employee5);
        map.put(employee6.getId(), employee6);
        map.put(employee7.getId(), employee7);
        map.put(employee8.getId(), employee8);
        map.put(employee9.getId(), employee9);
        map.put(employee10.getId(), employee10);
        // show map
        Set<String> set = map.keySet();
        for (String key : set) {
            System.out.println(key + " " + map.get(key).getNameEmployee());
        }
        new Scanner(System.in).nextLine()   ;
    }

    public void buyTicket(){
    }
}
