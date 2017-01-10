/**
 * Created by VINNI on 06.01.17.
 */
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Order implements Comparable<Order> {
    private  long id;
    private int price;
    private Currency currency=Currency.USD;
    private String itemName;
    private String shopIdentificator;
    private  User user;

    public Order(long id, int price, Currency currency, String itemName, String shopIdentificator, User user) {
        this.id = id;
        this.price = price;
        this.currency = currency;
        this.itemName = itemName;
        this.shopIdentificator = shopIdentificator;
        this.user = user;
    }



    public  long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getItemName() {
        return itemName;
    }

    public  String getCity() {
        return getUser().getCity();


    }

    public String getShopIdentificator() {
        return shopIdentificator;
    }

    public User getUser() {
        return user;
    }


    public boolean Petrov(Order o) {
        boolean flag = o.getUser().getLastName().equals("Petrov");
        return flag;
    }


    public int compareTo(Order o) {
        int res = o.getPrice() - this.getPrice();
        return res;
    }

    public static int compare(Order o1, Order o2) {

        int flag = o1.getPrice() - o2.getPrice();


        if(flag == 0)
        {
            flag = o1.getUser().getCity().compareTo(o2.getUser().getCity());
        }

        return flag;
    }

    public static int compare2(Order o1, Order o2) {

        int flag = o1.getItemName().compareTo(o2.getItemName());



        if(flag == 0)
        {
            flag = (int)o1.getId() - (int)o2.getId();
            if(flag == 0){
                flag = o1.getUser().getCity().compareTo(o2.getUser().getCity());
            }
        }

        return flag;
    }





    @Override
    public String toString() {
        return "\n Order{" +
                "id=" + id +
                ", price=" + price +
                ", currency=" + currency +
                ", itemName='" + itemName + '\'' +
                ", shopIdentificator='" + shopIdentificator + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (price != order.price) return false;
        if (currency != order.currency) return false;
        if (!itemName.equals(order.itemName)) return false;
        if (!shopIdentificator.equals(order.shopIdentificator)) return false;
        return user.equals(order.user);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + price;
        result = 31 * result + currency.hashCode();
        result = 31 * result + itemName.hashCode();
        result = 31 * result + shopIdentificator.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
