
//Basic Program for learning collaction class And Switch


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class MenuProgram {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Method For Choosing Dish

    String Orders(ArrayList<MenuCard> MList, LinkedList<MenuCard> Order) {
        System.out.println("\n \n \n");
        System.out.println("########################################");
        System.out.println("Menu List");

        BufferedReader orderNo = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        while (true) {
            for (MenuCard list : MList) {

                System.out.println(count++ + " - " + ANSI_YELLOW + "Dish : " + list.DishName + ANSI_RESET + " ---- "
                        + ANSI_RED + "Price : " + list.Price + ANSI_RESET);
            }

            System.out.println(ANSI_YELLOW + "99 To Go Back" + ANSI_RESET);
            System.out.println("########################################");
            System.out.println("Choose Order");

            try {
                int index = Integer.parseInt(orderNo.readLine());

                if (index == 99) {

                    return "";

                } else {
                    Order.add(MList.get(index));
                    count = 0;
                    // System.out.println("order Size " + Order.size());
                }
            } catch (Exception e) {
                System.out.println(e);

            }
            System.out.println(ANSI_GREEN + "Your Order is placed" + ANSI_RESET);

        }

    }

    // Method For Checking Order And  Bill

    void Checkorder(LinkedList<MenuCard> Order) {
        int cost = 0;
        System.out.println("\n \n \n");
        System.out.println("##########################################\n");

        for (MenuCard odc : Order) {
            System.out.println(ANSI_YELLOW + "Dish :" + odc.DishName + ANSI_RESET + " ---- " + ANSI_RED + "Price :"
                    + odc.Price + ANSI_RESET);
            cost += odc.Price;
        }
        System.out.println("\n" + ANSI_RED + "Total Cost  = " + cost + ANSI_RESET);
    }

// Method For Altering Order

    void Del(LinkedList<MenuCard> Order) {
        int count = 0;
        int odno;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("##############################################\n");
        for (MenuCard l : Order) {
            System.out.println(count++ + " - " + ANSI_YELLOW + "Dish : " + l.DishName + ANSI_RESET + " ---- " + ANSI_RED
                    + "Price : " + l.Price + ANSI_RESET);
        }
        System.out.println("Enter Number to remove order");
        try {
            odno = Integer.parseInt(in.readLine());
            Order.remove(odno);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(ANSI_GREEN + "Your Order is Altered" + ANSI_RESET);
    }

// Main Mehod

    public static void main(String[] args) {
        // pre define menu list
        ArrayList<MenuCard> MList = new ArrayList<MenuCard>() {
            {
                add(new MenuCard("Rice Dal", 100));
                add(new MenuCard("Meat", 200));
                add(new MenuCard("Drinks", 500));
                add(new MenuCard("Thali", 300));
                add(new MenuCard("Dosa", 150));
            }
        };
        LinkedList<MenuCard> Order = new LinkedList<>();

        boolean ex = true;
        int opt;
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        while (ex) {

            System.out.println("\n \n");

           
            System.out.println("####################################################\n");
            System.out.println(ANSI_PURPLE + "1 : To Choose Order" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "2 : To check Order" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "3 : To delete order" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "4 : To Exit" + ANSI_RESET);
            System.out.println(ANSI_WHITE + "Enter Number of your choise" + ANSI_RESET + "\n");
            System.out.println("####################################################");
            // for string trollers
            try {

                opt = Integer.parseInt(inp.readLine());

            } catch (Exception e) {
                opt = 0;
                System.out.println(e);
            }

            switch (opt) {
                case 1:
                    System.out.println(new MenuProgram().Orders(MList, Order));
                    break;
                case 2:
                    new MenuProgram().Checkorder(Order);
                    break;
                case 3:
                    new MenuProgram().Del(Order);
                    break;
                case 4:
                    ex = false;
                    break;
                default:
                    System.out.println("Wrong option");
                    break;

            }

        }

    }
}

// MenuCard Format

class MenuCard {
    String DishName;
    int Price;

    public MenuCard(String dishName, int price) {
        DishName = dishName;
        Price = price;
    }

}
