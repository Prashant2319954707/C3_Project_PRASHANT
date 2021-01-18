
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {

    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) {
        //return null;
        Restaurant restaurant = null;
        //boolean isFound = false;
        if (restaurants.size() > 0 && restaurantName != null) {
            for (Restaurant restObj : restaurants) {
                if (restObj.getName().equalsIgnoreCase(restaurantName)) {
                    restaurant = restObj;
                    //isFound = true;
                    break;
                }
            }
            return restaurant;
        } else {
            return null;
        }

        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
