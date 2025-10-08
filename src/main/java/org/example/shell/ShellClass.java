package org.example.shell;

import org.example.User;
import org.example.dataBot.DataBot;
import org.example.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Service;

import java.util.List;

@ShellComponent
@Service
public class ShellClass {
    private final DataBaseService dataBaseService;

    @Autowired
    public ShellClass(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }


    @ShellMethod("find")
    public List<User> find(@ShellOption String param) {
        if(param.equals("all")){
            return dataBaseService.printAllUsers();
        }else{
            return dataBaseService.printNameParam(param);
        }
    }

}
