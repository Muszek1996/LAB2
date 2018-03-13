import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FulfillmentCenterContainer {
    Map<String,FulfillmentCenter> magazines = new HashMap<String,FulfillmentCenter>();
    public void addCenter(String name, double capacity) {
        final FulfillmentCenter center = magazines.put(name, new FulfillmentCenter(capacity));
    };
    public void removeCenter(String nazwa){
        magazines.remove(nazwa);
    };

    public List<FulfillmentCenter> findEmpty(){
        List<FulfillmentCenter> emptyMagazines = new LinkedList<FulfillmentCenter>();
        for(Map.Entry<String,FulfillmentCenter> entry : magazines.entrySet()){
            if(entry.getValue().capacity == 0 ){
                System.out.println(entry.getKey());
                emptyMagazines.add(entry.getValue());
            }
        }
        return emptyMagazines;
    };

    public void summary(){
        for(Map.Entry<String,FulfillmentCenter> entry : magazines.entrySet()){
            System.out.println(entry.getKey() +" "+ entry.getValue().capacity /entry.getValue().capacityMax*100 +"%");
        }
        System.out.print("\n");
    };
}
