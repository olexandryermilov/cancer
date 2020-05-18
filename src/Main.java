import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<String> BCrars = listBC();
        for(String file: BCrars){
            System.out.println(file);
            String name = file.split("\\.")[0];
            unrar(name);
        }
    }

    private static List<String> listBC() {
        File f = new File("BC/");
        List<String> result = Arrays.asList(f.list());
        return result;
    }

    private static void unrar(String name) {
        Runtime runtime = Runtime.getRuntime();
        try {
            String command = "unrar e BC/" + name + ".rar BC/" + name + "/";
            System.out.println(command);
            Process process = runtime.exec(command);
            process.waitFor();
            BufferedReader input =
                    new BufferedReader
                            (new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
        } catch (Exception e) {
        }
    }
}