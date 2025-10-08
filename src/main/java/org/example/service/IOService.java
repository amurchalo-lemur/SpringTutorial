package org.example.service;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;
@Service
public class IOService {
    private final Scanner scanner;
    private final PrintWriter writer;


    public IOService(InputStream inputStream, OutputStream outputStream) {
        this.scanner = new Scanner(inputStream);
        this.writer = new PrintWriter(outputStream);
    }

    public void print(String string){
        writer.print(string);
        writer.flush();
    }

    public void println(String string){
        writer.println(string);
        writer.flush();
    }

    public String readLine(){
        return scanner.nextLine();
    }
}
