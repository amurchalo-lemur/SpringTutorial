package org.example.dataBot;

import org.example.entities.User;
import org.example.service.DataBaseService;
import org.example.service.I18nService;
import org.example.service.IOService;
import org.example.service.LanguageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("bot")
public class DataBot {
    private final IOService ioService;
    private final I18nService i18nService;
    private final LanguageService languageService;
    private final DataBaseService dataBaseService;


    public DataBot(IOService ioService, I18nService i18nService, LanguageService languageService, DataBaseService dataBaseService) {
        this.ioService = ioService;
        this.i18nService = i18nService;
        this.languageService = languageService;
        this.dataBaseService = dataBaseService;
    }

    public void conversation() {
        selectLanguage();
        sayHello();
        dataBaseManage();
        pressAnyKey();
    }

    private void selectLanguage() {
        ioService.print("Select language(ru/en): ");
        var language = ioService.readLine();
        languageService.setCurrentLanguage(language);
    }

    private void dataBaseManage(){
        ioService.println(i18nService.getMessage("askFind"));
        String req = ioService.readLine();
        String [] arrRequest = req.strip().split("\\s+");
        for(var c : arrRequest) {
            ioService.print(c + " ");
        }
        switch (arrRequest[0].toLowerCase()){
            case "find" -> find(arrRequest);
            case "find-all" ->find(arrRequest);
            case "add" -> add(arrRequest);
            case "remove" -> remove(arrRequest);
            case "update" -> update(arrRequest);
            default -> ioService.print("unknown command");
        }
    }

    private void add(String [] arrRequest){
        User user = new User(arrRequest[1], arrRequest[2], Integer.parseInt(arrRequest[3]), Boolean.parseBoolean(arrRequest[3]));
        dataBaseService.addUser(user);
    }

    private void remove(String [] arrRequest){dataBaseService.removeUser(Integer.parseInt(arrRequest[1]));}

    private void update(String [] arrRequest){
        User user = new User(arrRequest[2], arrRequest[3], Integer.parseInt(arrRequest[4]), Boolean.parseBoolean(arrRequest[5]));
        ioService.println(String.valueOf(user.isMan()));
        dataBaseService.updateUser(Integer.parseInt(arrRequest[1]), user);
    }

    public void find(String [] arrRequest){
        Iterable<User> users = new ArrayList<>();
        if(arrRequest[0].equals("find-all")) {
            users = dataBaseService.printAllUsers();
            for(var c : users){
                print(c);
            }
        }else{
            String sb = String.valueOf(new StringBuilder(Arrays.toString(arrRequest)));
            String paramReq = sb.replace("find", "").strip().toLowerCase();
            users = dataBaseService.printNameParam(paramReq);
            for (var c : users){
                print(c);
            }

        }
    }
    private void print(User user){
        ioService.println("-------->>----------");
        ioService.println(i18nService.getMessage("id") + ":" + user.getId());
        ioService.println(i18nService.getMessage("name") + ":" + user.getName());
        ioService.println(i18nService.getMessage("mail") + ":" + user.getMail());
        ioService.println(i18nService.getMessage("age") + ":" + user.getAge());
        ioService.println(i18nService.getMessage("isman") + ":" + user.isMan());
        ioService.println("--------<<----------");
    }

    private void sayHello() {
        ioService.println(i18nService.getMessage("hello"));
    }


    private void pressAnyKey() {
        ioService.print(i18nService.getMessage("press-any-key"));
        ioService.readLine();
    }

}