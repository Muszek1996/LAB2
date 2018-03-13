import java.util.List;

public class Main {


    public static void main(String[] args) {
        Item[] przedmioty = {
                new Item("PC", ItemCondition.Used,80,1),
                new Item("Tablet", ItemCondition.Used,10,10),
                new Item("Mac", ItemCondition.Refubrished,50,2),
                new Item("Keyboard", ItemCondition.New,5,10),
                new Item("Palmtop", ItemCondition.Refubrished,5,18),
                new Item("Nitrogen", ItemCondition.New,10,2)
        };


        FulfillmentCenter centrum = new FulfillmentCenter(1000);



        for(Item i: przedmioty)
            centrum.addProduct(i);

        centrum.summary();

        centrum.getProduct(przedmioty[1]);
        centrum.getProduct(przedmioty[1]);

        centrum.summary();

        for(int i = 0;i<9;i++){
            centrum.addProduct(przedmioty[0]);
        }
        centrum.summary();
        centrum.removeProduct(centrum.items.get(1));
        centrum.summary();

        centrum.search("PC").Print();

        for(Item i: centrum.searchPartial("P")){
            i.Print();
        };

        System.out.println(centrum.countByCondition(ItemCondition.New)+"\n");

        List<Item> sortedItems = centrum.sortByName();
        for(Item i: sortedItems){
            System.out.println(i.name);
        }
        System.out.println();


        List<Item> sortedByAmountItems = centrum.sortByAmount();
        for(Item i: sortedByAmountItems){
            System.out.println(i.name+" "+i.quantity);

        }
        System.out.println();


        centrum.max().Print();


        FulfillmentCenterContainer Poland = new FulfillmentCenterContainer();
        Poland.addCenter("Wrocław",6000);
        Poland.addCenter("Warszawa", 20000);
        Poland.addCenter("Kraków", 8000);

        Poland.summary();
        Poland.removeCenter("Warszawa");
        Poland.summary();

        Poland.magazines.get("Wrocław").capacity += 4000;
        Poland.summary();

        for(FulfillmentCenter i :Poland.findEmpty()){
            i.summary();
        }

        Poland.summary();

    }
}
