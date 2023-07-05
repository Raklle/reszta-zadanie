import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        ChangeMaker change = new ChangeMaker();
        change.setInitialValues();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.print("Podaj kwotę: ");
            try {
                String number = reader.readLine();
                if(number.matches("\\d+\\.\\d{2}")){
                    change.makeChange((int)(Double.parseDouble(number) * 100));
                }else if(number.matches("\\d+")){
                    change.makeChange(Integer.parseInt(number) * 100);
                }else{
                    System.out.println("Nieprawidłowy format liczby, podaj liczbę całkowitą lub z dwoma miejscami po przecinku");
                }
            } catch(IOException e){
                System.out.println("Error: " + e);
            }


        }

    }
}