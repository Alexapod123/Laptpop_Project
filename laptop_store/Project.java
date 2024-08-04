package laptop_store;

import java.util.*;

public class Project {
    public static void main(String[] args) {
        LaptopsOptions offer = new LaptopsOptions();
        offer.generationLaptops(50);

        Scanner scan = new Scanner(System.in);
        int choise;
        do{
            System.out.println("ДОБРО ПОЖАЛОВАТЬ В МАГАЗИН НОУТБУКОВ!");
            System.out.println("1. Показать все ноутбуки");
            System.out.println("2. Отфильтровать ноутбуки");
            System.out.println("0. Выйти");
            System.out.print("Выберите действие: ");
            choise = scan.nextInt();
            switch(choise){
                case 1:
                    offer.showAllLaptops();
                    break;
                case 2:
                    offer.filterLaptops();
                    break;
                case 0:
                    System.out.println("До новых встреч!");
                    break;
                default:
                System.out.println("Некорректный выбор!");

            }

        }while(choise!=0);
        scan.close();
    }
}