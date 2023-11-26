package me.minkh.core.singleton;

public class StatefulService {

//    private int price; // 상태를 유지하는 필드 10_000 -> 20_000

//    public void order(String name, int price) {
//        System.out.println("name = " + name + ", price = " + price);
//        this.price = price; // 여기가 문제가 된다.
//    }

    public int order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        return price;
    }

//    public int getPrice() {
//         return price;
//    }

}
