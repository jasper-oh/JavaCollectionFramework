import java.util.*;

public class AdventureMap {


    public static void main(String[] args) {
        int menu;
        HashMap<String, Phone> map = new HashMap<>();
        System.out.println("----------------------------------------------------");
        System.out.println(" 전화번호 관리 프로그램을 시작합니다. ");
        System.out.println("----------------------------------------------------");

        while (true){
            System.out.print("삽입:0, 삭제:1, 찾기:2, 전체보기:3, 종료:4 >> ");
            Scanner scanner = new Scanner(System.in);
            menu = scanner.nextInt();

            switch (menu){
                case 0:
                    insert(map);
                    break;
                case 1:
                    delete(map);
                    break;
                case 2:
                    search(map);
                    break;
                case 3:
                    findAll(map);
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }


    }

    public static void insert(HashMap<String, Phone> map){
        Phone phone;
        String name, address, telephone;
        Scanner scanner = new Scanner(System.in);

        System.out.println("이름 = " );
        name = scanner.next();
        System.out.println("주소 = " );
        address = scanner.next();
        System.out.println("전화번호 = ");
        telephone = scanner.next();

        phone = new Phone(name, address, telephone);

        map.put(phone.getName(), phone);
    }

    public static void delete(HashMap<String, Phone> map){
        String deleteName;
//        Scanner scanner = new Scanner(System.in);

        System.out.println("삭제할 이름 = " );
        Scanner scanner = new Scanner(System.in);
        deleteName = scanner.next();

        if (map.containsKey(deleteName)) {
            map.remove(deleteName);
            System.out.println(deleteName + " 삭제완료");
        }else{
            System.out.println("등록되지 않은 회원입니다.");
        }
    }

    public static void search(HashMap<String, Phone> map){
        String searchName;

        System.out.println("찾을 이름 = " );
        Scanner scanner = new Scanner(System.in);
        searchName = scanner.next();

        if (map.containsKey(searchName)) {
            System.out.println(searchName + map.get(searchName).getAddress() + map.get(searchName).getTelephone());
        }else{
            System.out.println("없는 정보입니다.");
        }

    }

    public static void findAll(HashMap<String, Phone> map) {
        Set<String> names = map.keySet();
        Iterator<String> iterator = names.iterator();

        while(iterator.hasNext()){
            String name = iterator.next();
            Phone info = map.get(name);

            System.out.println(name +" "+info.getAddress() +" "+info.getTelephone());
        }
    }
}

class Phone{
    private String name;
    private String address;
    private String telephone;

    public Phone(String name, String address, String telephone) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }
}
