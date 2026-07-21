package ui;

import java.util.Scanner;

import model.User;
import services.LoginService;

public class LoginUI {

    Scanner sc = new Scanner(System.in);

    LoginService loginService = new LoginService();

    public void login() {

        System.out.println("===== VendorIQ Login =====");

        System.out.print("Email : ");
        String email = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        User user = loginService.login(email, password);

        if (user != null) {

            System.out.println("\nLogin Successful!");
            System.out.println("Welcome " + user.getFullName());
            System.out.println("Role : " + user.getRole());

        } else {

            System.out.println("\nInvalid Email or Password");

        }

    }

}