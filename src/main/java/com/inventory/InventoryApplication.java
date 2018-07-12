package com.inventory;

import com.inventory.enums.CommandsEnum;

import java.util.Scanner;

public class InventoryApplication {

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        int exit = 1;
        System.out.println("Welcome to Mr. X inventory management! \n");
        System.out.println("Write one of the following commands with the required parameters");
        do {

            Scanner sc = new Scanner(System.in);

            System.out.println("1. Create new item -> create itemName costPrice sellingPrice");
            System.out.println("2. Delete existing item -> delete itemName");
            System.out.println("3. Update Buy item quantity -> updateBuy itemName quantity");
            System.out.println("4. Update Sell item quantity -> updateSell itemName quantity");
            System.out.println("5. Report -> report");
            System.out.println("0. Exit -> exit\n");
            System.out.println("Your command: ");

            String command = sc.next();

            if (command.equalsIgnoreCase("exit")) {
                exit = 0;
                System.out.println("Bye!");
            } else if (!command.contains(CommandsEnum.CREATE.getCommandName())
                        && !command.contains(CommandsEnum.DELETE.getCommandName())
                    && !command.contains(CommandsEnum.UPDATE_BUY.getCommandName())
                    && !command.contains(CommandsEnum.UPDATE_SELL.getCommandName())
                    && !command.contains(CommandsEnum.REPORT.getCommandName())) {
                System.out.println("Invalid Command. Try again!");
            }



        } while (exit != 0);
    }

}
