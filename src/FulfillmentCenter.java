import javax.sql.rowset.serial.SerialRef;
import java.util.*;

public class FulfillmentCenter {
    List<Item> items = new LinkedList<Item>();
    public double capacityMax = 1000;
    public double capacity;

    public FulfillmentCenter(double capacity) {
        this.capacityMax = capacity;
    }

    public void addProduct(Item e) {
        if(e.quantity*e.mass<=(capacityMax-capacity)){
            Item inList = contains(e);
            if(inList!=null){
                inList.quantity+=e.quantity;
                capacity+= e.quantity*e.mass;
            }else{
                items.add(new Item(e));
                capacity+= e.mass*e.quantity;
            }
        }else{
            System.err.println("Przepełnienie podczas dodawania: "+e.name);
            e.Print();
        }
    }

    private Item contains(Item potentialSameItem){
      if(items.isEmpty()){
          return null;
      }
      else{
          for(Item i: items){
              if(i.compareTo(potentialSameItem)==0){
                  return i;
              }
          }
      }
      return null;
    };


    public void getProduct(Item e) {
        Item inList = contains(e);
        if (inList!=null && e.quantity > 0) {
            inList.quantity--;
            capacity-=e.mass;
        }
        if (e.quantity == 0) {
            items.remove(inList);
        }
    }

    public void removeProduct(Item e) {
        capacity-=e.mass*e.quantity;
        items.remove(items.indexOf(e));
    }

    public Item search(String name) {

        for (Item i : items) {
           if(i.name.compareTo(name)==0)return i;
        }
        return null;
    }

    public List<Item> searchPartial(String partOfName){
        List<Item> matchingItems = new LinkedList<Item>();
        for (Item i : items){
            if(i.name.contains(partOfName)){
                matchingItems.add(i);
            }
        }
        return matchingItems;
    }
    public int countByCondition(ItemCondition condition){
        int quantity=0;
        for(Item i : items){
            if(i.state == condition){
                quantity+=i.quantity;
            }
        }
        return quantity;
    }
   public void summary(){
       System.out.println("Zapełnienie:"+capacity/capacityMax*100+"%");
       if(items.isEmpty())
           System.out.print("Magazyn Pusty!\n");
        for(Item i : items){
            System.out.println(i.name +","+i.state +","+i.mass +","+i.quantity);
        }
       System.out.println();
   }

   public List<Item> sortByName(){
        List<Item> sorted = new LinkedList<>(items);
        Collections.sort(sorted);
    return sorted;
   }
    public List<Item> sortByAmount(){
        List<Item> sorted = new LinkedList<>(items);
        Collections.sort(sorted,Item::compareAmount);
        return sorted;
    };

    public Item max() {
        Collections.max(items);
        return Collections.max(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.quantity, o2.quantity);
            }
        });


    }

}

