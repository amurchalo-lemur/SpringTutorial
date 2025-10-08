package org.example;

import org.example.dataBot.DataBot;
import org.example.shell.ShellClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args).getBean(ShellClass.class);
    }
}