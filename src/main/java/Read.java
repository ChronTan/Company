import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read {

    public static void main(String[] args) throws IOException {
        Application app=new Application();
        BufferedReader bf=new BufferedReader(new FileReader(app.file));
        String line;
        while((line=bf.readLine())!=null){
            System.out.println(line);
        }
    }
}
