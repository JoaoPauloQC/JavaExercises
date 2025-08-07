package SImpleLogin;

import java.util.HashMap;
import java.util.Objects;

public class SimpleLogin {

    private HashMap<String,String> logins = new HashMap<>();

    public HashMap<String, String> getLogins() {
        return logins;
    }

    public SimpleLogin (HashMap<String,String> logins){
        this.logins = logins;
    }

    public void addingUser(String name){
        logins.putIfAbsent(name,"");
    }

    public void addingUser(String name, String password){
        logins.putIfAbsent(name,password);
    }

    public void printLoginMap(){
        for (String key : logins.keySet()){
            System.out.println(key + " -> " + logins.get(key));
        }
    }

    public void puttingPassword (String name, String password){
        if (logins.keySet().contains(name)){
            logins.put(name,password);
        }
    }

    public boolean authentication(String name, String password){
        if (logins.containsKey(name)){
            if (Objects.equals(logins.get(name), password)){
                return true;
            }

        }
        return false;
    }

}
