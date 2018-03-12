import java.util.*;

public class FulfillmentCenter {
    List<Item> items = new LinkedList<Item>();
    public final double CAPACITY_MAX = 1000;
    public double CAPACITY;

    public void addProduct(Item a) {
        items.add(a);
    }

    public void getProduct(Item e) {
        if (items.contains(e) && e.ilość > 0) {
            e.ilość--;
        }
        if (e.ilość == 0) {
            items.remove(e);
        }
    }

    public void removeProduct(Item e) {
        items.remove(items.indexOf(e));
    }

    public Item search(String nazwa) {
        for (Item i : items) {
            if (i.nazwa.equals(nazwa)) return i;
        }
        return null;
    }

    //    public void searchPartial(String)
//    public void countByCondition(ItemCondition)
//    public void summary()
//    public void sortByName()
//    public void sortByAmount()
    public Item max() {
        Collections.max(items);
        Item s1 = Collections.max(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.ilość, o2.ilość);
            }
        });

        return null;
    }

}

