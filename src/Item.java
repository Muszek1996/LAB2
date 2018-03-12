public class Item implements Comparable<Item>{
    String nazwa;
    ItemCondiotion stan;
    double masa;
    int ilość;

    public Item(String nazwa, ItemCondiotion stan, double masa, int ilość) {
        this.nazwa = nazwa;
        this.stan = stan;
        this.masa = masa;
        this.ilość = ilość;
    }

    public void Print(){
        System.out.println("Nazwa:"+ nazwa);
        System.out.println("Stan:"+ stan.name());
        System.out.println("Masa:"+ masa);
        System.out.println("Ilość:"+ ilość);

    }

    @Override
    public int compareTo(Item o) {
        return nazwa.compareTo(o.nazwa);
    }

}
