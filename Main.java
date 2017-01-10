/**
 * Created by VINNI on 06.01.17.
 */
import com.sun.corba.se.impl.resolver.ORBDefaultInitRefResolverImpl;

import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Set;


import static java.util.Comparator.comparing;


public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User(1, "firstName", "Petrov", "city", 10000));
        users.add(new User(2, "firstName2", "lastName2", "city2", 9000));
        users.add(new User(3, "firstName3", "lastName3", "city3", 8000));
        users.add(new User(4, "firstName4", "lastName4", "city4", 7000));
        users.add(new User(5, "firstName5", "lastName5", "city5", 6000));
        users.add(new User(6, "firstName6", "lastName6", "city6", 5000));
        users.add(new User(7, "firstName7", "lastName7", "city7", 4000));
        users.add(new User(8, "firstName8", "lastName8", "city8", 3000));
        users.add(new User(10, "firstName10", "lastName10", "city10", 1000));
        users.add(new User(9, "firstName9", "lastName9", "city9", 2000));


        List<Order> oder = new ArrayList<>();

        oder.add(new Order(300, 500, Currency.USD, "itemName3", "shopIdentificator", users.get(8)));
        oder.add(new Order(3000, 12000, Currency.GRN, "itemName33", "shopIdentificator33", users.get(0)));
        oder.add(new Order(200, 3000, Currency.USD, "itemName2", "shopIdentificator2", users.get(1)));
        oder.add(new Order(400, 4000, Currency.GRN, "itemName8", "shopIdentificator3", users.get(2)));
        oder.add(new Order(100, 7000, Currency.USD, "itemName8", "shopIdentificator2", users.get(5)));
        oder.add(new Order(800, 6000, Currency.USD, "itemName7", "shopIdentificator1", users.get(1)));
        oder.add(new Order(900, 9000, Currency.USD, "itemName10", "shopIdentificator23", users.get(4)));
        oder.add(new Order(700, 11000, Currency.USD, "itemName4", "shopIdentificator7", users.get(7)));
        oder.add(new Order(900,9000, Currency.USD, "itemName10", "shopIdentificator23", users.get(4)));
        oder.add(new Order(700, 11000, Currency.EUR, "itemName11", "shopIdentificator6", users.get(7)));

        // List<Order> oderSort = oder.stream()
           //     .sorted(Order::compareTo)
             //   .collect(Collectors.toList());

        /*List<Order> oderSort = oder.stream()
                .sorted(comparing(Order::getPrice))
                .collect(Collectors.toList());*/

        List<Order> oderSort = oder.stream()
                .sorted(comparing(Order::getPrice).reversed())
                .collect(Collectors.toList());

        List<Order> oderSort2 = oder.stream()
                .sorted(Order::compare)
                .collect(Collectors.toList());

        List<Order> oderSort3 = oder.stream()
                .sorted(Order::compare2)
                .collect(Collectors.toList());

        Set<Order> oderSort4 = new HashSet(oder);
        //oder.stream().distinct().collect(Collectors.toList());

        List<Order> oderSort5 = oder.stream()
                .filter(s -> s.getPrice()<1500)
                .collect(Collectors.toList());

        List<Order> oderSort6 = oder.stream()
                .filter(s -> s.getCurrency().equals(Currency.USD))
                .collect(Collectors.toList());

        List<Order> oderSort7 = oder.stream()
                .filter(s -> s.getCurrency().equals(Currency.GRN))
                .collect(Collectors.toList());

        Map<String, List<Order>> groupByCity =
                oder.stream().collect(Collectors.groupingBy(Order::getCity));

        long userPetrov = users.stream()
                .filter((p) -> p.getLastName().equals("Petrov")).count();

        List<Order> oderSort8 = oder.stream()
                .filter(s -> !s.getCurrency().equals(Currency.USD))
                .collect(Collectors.toList());


        System.out.println(oderSort);
        System.out.println("*****");
        System.out.println(oderSort2);
        System.out.println("*****");
        System.out.println(oderSort3);
        System.out.println("*****");
        System.out.println(oderSort4);
        System.out.println("*****");
        System.out.println(oderSort5);
        System.out.println("*****");
        System.out.println(oderSort6);
        System.out.println("*****");
        System.out.println(oderSort7);
        System.out.println("*****");
       System.out.println(groupByCity);
        System.out.println("*****");
        System.out.println(oderSort8);
        System.out.println("*****");

        if (userPetrov>0) System.out.println("Есть Petrov");
        else System.out.println("Нет Petrov");

    }
    }

