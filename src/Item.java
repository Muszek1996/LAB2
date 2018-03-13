public class Item implements Comparable<Item>{
    String name;
    ItemCondition state;
    double mass;
    int quantity;

    public Item(String name, ItemCondition state, double mass, int quantity) {
        this.name = name;
        this.state = state;
        this.mass = mass;
        this.quantity = quantity;
    }
    public Item(Item source) {
        this.name = source.name;
        this.state = source.state;
        this.mass = source.mass;
        this.quantity = source.quantity;
    }

    public void Print(){
        System.out.println("Nazwa:"+ name);
        System.out.println("Stan:"+ state.name());
        System.out.println("Masa:"+ mass);
        System.out.println("Ilość:"+ quantity+"\n");

    }

    @Override
    public int compareTo(Item o) {
        return name.compareTo(o.name);
    }


    public int compareAmount(Item o) {
        return Integer.compare(o.quantity,quantity) ;
    }



}
