package com.acciojob.RockApi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController // Annotation
public class APIEndPoints {
    HashMap<Integer,User> UserDb = new HashMap<>();
    @GetMapping("/getWeatherInfo")  // if this api called from client then below function will be called
    public String getWeatherInfo(){
        return "Today's weather is awesome.";
    }

    @GetMapping("/CalculateSum")
    public String CalculateSum(@RequestParam("n1") Integer n1 , @RequestParam("n2") Integer n2){
            int sum = n1 + n2;
            return "The calculate sum is " +sum +".";
        }
        @PostMapping("/signUpUser")
                public String signUpUser(@RequestBody User user){
            int primaryKey = user.getUserId();
            UserDb.put(primaryKey,user);
            return "User" + user.getName()+ " is successfully added to our system.";
        }
        @GetMapping("/get-userById")
                public User findUser(@RequestParam("userId") Integer userId){
            User user = UserDb.get(userId);
            return user;
        }
        // I want to find people who are from given country
        @GetMapping("/getListOfPeople/{country}")
    public List<User> getListOfPeople(@PathVariable("country") String country) {
            List<User> users = new ArrayList<>();
            for (User user : UserDb.values()) {
                if (user.getCountry().equals(country)) {
                    users.add(user);
                }
            }
            return users;
        }
        @GetMapping("/getAllUsers")
            public List<User> getAllUsers(){
            List<User> users = new ArrayList<>();
            for (User user : UserDb.values()) {
               users.add(user);
            }
            return users;
        }

        @PutMapping("updateUserInfo")

        public String updateUserInfo(@RequestBody User user){
            int primarykey = user.getUserId();
            UserDb.put(primarykey,user);
            return user.getName();
        }
        @PutMapping("/UpdateSpecificDetails")
    public String UpdateSpecificDetails(@RequestParam ("key") Integer key, @RequestParam("age") Integer age){
        User user = UserDb.get(key);
        user.setAge(age);
        return  user.getName() + " age has been updated to " + age +" successfully.";
        }

        @DeleteMapping("/deleteUser")
    public String deleteUser(@PathVariable("name") String name){

        for (int key : UserDb.keySet()){
            if(UserDb.get(key).getName().equals(name)){
                UserDb.remove(key);
            }
        }
        return "The user " + name + " has been successfully removed from database.";
        }
    }
