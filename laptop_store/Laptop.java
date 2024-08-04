package laptop_store;

public class Laptop {
    String brand;
    String os;
    String colour;
    int ram;
    int capacityhd;
    int price;

    public Laptop(String brand, String os, String colour, int ram, int capacityhd, int price) {
        this.brand = brand;
        this.os = os;
        this.colour = colour;
        this.ram = ram;
        this.capacityhd = capacityhd;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getOs() {
        return os;
    }

    public String getColour() {
        return colour;
    }

    public int getRam() {
        return ram;
    }

    public int getCapacityhd() {
        return capacityhd;
    }

    public int getPrice() {
        return price;
    }

public String toString(){
    return "Вашему вниманию ноутбук: {" +
                "Бренд='" + brand + '\'' +
                ", ОЗУ=" + ram +
                ", Объем ЖД=" + capacityhd +
                ", ОС='" + os + '\'' +
                ", Цвет='" + colour + '\'' +
                ", Цена=" + price +
                '}';
}

}