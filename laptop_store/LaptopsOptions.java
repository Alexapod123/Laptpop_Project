package laptop_store;

import java.util.*;

class LaptopsOptions {
    private Set<Laptop> laptops = new HashSet<>();
    private Random random = new Random();

    public void generationLaptops(int quantity) {
        String[] brands = { "Lenovo", "HP", "Asus", "Acer", "Dell", "LG", "Tecno" };
        String[] optionsOfOs = { "Windows", "Linux", "Ubuntu" };
        String[] colours = { "Black", "Grey", "White", "Blue", "Red", "Yellow", "Silver" };
        int[] optionsOfRam = { 4, 8, 16, 32, 64 };
        int[] optionsOfCapacityhdd = { 256, 512, 1024, 2048 };
        for (int i = 0; i < quantity; i++) {
            String brand = brands[random.nextInt(brands.length)];
            String os = optionsOfOs[random.nextInt(optionsOfOs.length)];
            String colour = colours[random.nextInt(colours.length)];
            int ram = optionsOfRam[random.nextInt(optionsOfRam.length)];
            int capacityhd = optionsOfCapacityhdd[random.nextInt(optionsOfCapacityhdd.length)];
            int price = random.nextInt(100000 - 15000 + 1) + 15000;

            laptops.add(new Laptop(brand, os, colour, ram, capacityhd, price));
        }
    }

    public void showAllLaptops() {
        System.out.println("Возможные к выбору ноутбуки: ");
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }
        System.out.println("К выбору доступно: " + laptops.size() + " ноутбуков.");
    }

    public void filterLaptops(){
        Map<String, Object> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите критерий фильтра:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("5 - Цена");
            System.out.println("6 - Бренд");
            System.out.println("0 - Вывести отфильтрованный список");

            int option = scanner.nextInt();
            if (option == 0) break;
            switch(option){
                case 1:
                    System.out.println("Введите минимальный оперативной памяти(4, 8, 16, 32, 64): ");
                    filters.put("ram", scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Введите минимальный объем жесткого диска(256, 512, 1024, 2048): ");
                    filters.put("capacityhd", scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Введите желаемую операционную систему(Windows,Linux, Ubuntu): ");
                    filters.put("os", scanner.next());
                    break;
                case 4:
                    System.out.println("Введите желаемый цвет(Black, Grey, White, Blue, Red, Yellow, Silver): ");
                    filters.put("colour", scanner.next());
                    break;
                case 5:
                    System.out.println("Введите верхнюю границу цены(15000-100000): ");
                    filters.put("price", scanner.nextInt());
                    break;
                case 6:
                    System.out.println("Введите желаемый бренд(Lenovo, HP, Asus, Acer, Dell, LG, Tecno): ");
                    filters.put("brand", scanner.next());
                    break;
            }
        }
        Set<Laptop> filtrLaptops=new HashSet<>(laptops);
        for (Laptop laptop : laptops) {
            if (filters.containsKey("ram")&&laptop.getRam()<(int) filters.get("ram")){
                filtrLaptops.remove(laptop);
            }
            if (filters.containsKey("capacityhd")&&laptop.getCapacityhd()<(int) filters.get("capacityhd")){
                filtrLaptops.remove(laptop);
            }
            if (filters.containsKey("os") && !laptop.getOs().equalsIgnoreCase((String) filters.get("os"))) {
                filtrLaptops.remove(laptop);
            }
            if (filters.containsKey("colour") && !laptop.getColour().equalsIgnoreCase((String) filters.get("colour"))) {
                filtrLaptops.remove(laptop);
            }
            if (filters.containsKey("price") && laptop.getPrice() > (int) filters.get("price")) {
                filtrLaptops.remove(laptop);
            }
            if (filters.containsKey("brand") && !laptop.getBrand().equalsIgnoreCase((String) filters.get("brand"))) {
                filtrLaptops.remove(laptop);
            }
        }
        System.out.println("Результаты фильтра:");
        for (Laptop laptop : filtrLaptops) {
            System.out.println(laptop);
        }

    }

}