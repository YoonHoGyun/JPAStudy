package com.example.jpaStudy.main;

import com.example.jpaStudy.domain.Address;
import com.example.jpaStudy.domain.User;
import com.example.jpaStudy.jpa.EMF;
import com.example.jpaStudy.service.ChangeNameService;
import com.example.jpaStudy.service.GetUserService;
import com.example.jpaStudy.service.NewUserService;
import com.example.jpaStudy.service.RemoveUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    private static NewUserService newUserService = new NewUserService();
    private static GetUserService getUserService = new GetUserService();
    private static ChangeNameService changeNameService = new ChangeNameService();
    private static RemoveUserService removeUserService = new RemoveUserService();

    public static void main(String[] args) throws IOException {
        EMF.init();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("명령어를 입력하세요:");
                String line = reader.readLine();
                if (line == null) break;
                if (line.startsWith("new")) {
                    handleNew(line);
                } else if (line.startsWith("get")) {
                    handleGet(line);
                } else if (line.startsWith("change name")) {
                    handleChangeName(line);
                } else if (line.startsWith("remove")) {
                    handleRemove(line);
                } else if (line.equals("exit")) {
                    break;
                }
            }
        } finally {
            EMF.close();
        }
    }

    private static void handleNew(String line){
        String[] result = line.substring(4).split("/");
        Address address = new Address(result[2], result[3], result[4]);
        User user = new User(result[0], result[1], address, LocalDateTime.now());
        try {
            newUserService.saveNewUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void handleGet(String line){
        String email = line.substring(4);
        try {
            User user = getUserService.getUser(email);
            logger.info("사용자 정보 : {}, {}, {}", user.getEmail(), user.getName(),
                    user.getAddress().getAddress1() + " " +
                    user.getAddress().getAddress2() + " " +
                    user.getAddress().getZipcode());
        } catch (Exception e){
            logger.info("사용자가 존재하지 않음 : {}", email);
        }
    }

    private static void handleChangeName(String line){
        String[] result = line.substring(12).split("/");
        String email = result[0];
        String newName = result[1];
        try {
            changeNameService.changeName(email, newName);
            logger.info("사용자 이름 변경: {}, {}", email, newName);
        } catch (Exception e) {
            logger.info("사용자가 존재하지 않음: {}", email);
        }
    }

    private static void handleRemove(String line) {
        String email = line.substring(7);
        try {
            removeUserService.removeUser(email);
            logger.info("사용자 삭제함: {}", email);
        } catch (Exception e) {
            logger.info("사용자가 존재하지 않음: {}", email);
        }
    }

}
