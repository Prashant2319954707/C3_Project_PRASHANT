
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author psharma1
 */
public class ItemService {

    private static List<Item> items = new ArrayList<>();

    public Item findItemByName(String itemName) {
        //return null;
        Item item = null;
        //boolean isFound = false;
        if (items.size() > 0 && itemName != null) {
            for (Item itemObj : items) {
                if (itemObj.getName().equalsIgnoreCase(itemName)) {
                    item = itemObj;
                    //isFound = true;
                    break;
                }
            }
            return item;
        } else {
            return null;
        }

        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }

    public Item addItem(String name, int price) {
        Item newItem = new Item(name, price);
        items.add(newItem);
        return newItem;
    }

    public Item removeItem(String itemName) throws itemNotFoundException {
        Item itemToBeRemoved = findItemByName(itemName);
        items.remove(itemToBeRemoved);
        return itemToBeRemoved;
    }

    public List<Item> getItems() {
        return items;
    }

}
