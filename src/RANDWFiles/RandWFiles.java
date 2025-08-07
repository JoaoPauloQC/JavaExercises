package RANDWFiles;

import SImpleLogin.SimpleLogin;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RandWFiles {


    public static void writingLoginFile(SimpleLogin simpleLogin) {

        try {
            List<String> lines = Files.readAllLines(Paths.get("C:/EasyAccess/logins.txt"));
            List<String> names = new ArrayList<>();
            for (String str : lines) {
                names.add(str.split(";")[0]);
            }


            try {


                Path mynewFile = Files.createFile(Paths.get("C:/EasyAccess/security.txt"));
                for (String name : names) {
                    Files.writeString(mynewFile, name + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                }

                System.out.println(lines);
            } catch (Exception e) {
                System.out.println(e);
                try {
                    Path mynewFile = Paths.get("C:/EasyAccess/security.txt");
                    for (String name : names) {
                        Files.writeString(mynewFile, name, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
                    }
                } catch (Exception e2) {

                }
            }
        } catch (Exception e3) {

        }


    }

}
