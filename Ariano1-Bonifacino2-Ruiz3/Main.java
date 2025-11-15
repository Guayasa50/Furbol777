import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            parser p = new parser(new Lexer(new FileReader(args[0])));
            p.parse(); // <-- importante
            System.out.println("Parseo finalizado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

