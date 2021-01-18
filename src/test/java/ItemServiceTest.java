
import org.junit.jupiter.api.*;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {

    ItemService service = new ItemService();
    Item item;
    //REFACTOR ALL THE REPEATED LINES OF CODE

    //>>>>>>>>>>>>>>>>>>>>>>SEARCHING<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void searching_for_existing_item_should_return_expected_item_object()
            throws itemNotFoundException {
        item = new Item();
        item = service.findItemByName("Tea");
        assertNotNull(item);
        //WRITE UNIT TEST CASE HERE
    }

    //You may watch the video by Muthukumaran on how to write exceptions in Course 3: Testing and Version control: Optional content
    @Test
    public void searching_for_non_existing_item_should_throw_exception() throws itemNotFoundException {
        item = new Item();
        item = service.findItemByName("Coffee1");
        assertNull(item);
    }
    //<<<<<<<<<<<<<<<<<<<<SEARCHING>>>>>>>>>>>>>>>>>>>>>>>>>>

    //>>>>>>>>>>>>>>>>>>>>>>ADMIN: ADDING & REMOVING RESTAURANTS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void remove_item_should_reduce_list_of_items_size_by_1() throws itemNotFoundException {
        item = service.addItem("Water",5);
        
        int initialNumberOfItems = service.getItems().size();
        service.removeItem("Water");
        assertEquals(initialNumberOfItems - 1, service.getItems().size());
    }

    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() throws itemNotFoundException {
        item = service.addItem("Water", 5);
        
        assertThrows(itemNotFoundException.class, () -> service.removeItem("Wine"));
    }

    @Test
    public void add_item_should_increase_list_of_items_size_by_1() {
        item = service.addItem("Coffee", 25);

        int initialNumberOfItems = service.getItems().size();
        service.addItem("Tea", 10);
        assertEquals(initialNumberOfItems + 1, service.getItems().size());
    }
    //<<<<<<<<<<<<<<<<<<<<ADMIN: ADDING & REMOVING RESTAURANTS>>>>>>>>>>>>>>>>>>>>>>>>>>
}
