import java.util.TreeMap;


public class ChangeMaker {
    private final TreeMap<Integer, Integer> money = new TreeMap<>();

    public void setInitialValues(){
        money.put(500, 1);
        money.put(200, 3);
        money.put(100, 5);
        money.put(50, 10);
        money.put(20, 20);
        money.put(10, 200);
        money.put(5, 100);
        money.put(2, 100);
        money.put(1, 10000);
    }

    public void makeChange(int amount){
        int currentDenomination = money.lastKey();
        while(amount > 0){
            //szukanie najwyższego nomianłu, mniejszego niż kwota
            if(amount < currentDenomination){
                currentDenomination = money.lowerKey(currentDenomination);
                continue;
            }

            //obliczenie ile monet tego nominału wydajemy
            var tmp = money.get(currentDenomination);
            int coinsUsed = Math.min(amount / currentDenomination, tmp);
            amount = amount - coinsUsed * currentDenomination;

            printChange(coinsUsed, currentDenomination);

            //zapisanie wydanych monet
            if(tmp - coinsUsed > 0){
                money.put(currentDenomination, tmp - coinsUsed);
            }else{
                money.remove(currentDenomination);
                if(money.isEmpty()){
                    System.out.println("Koniec pieniędzy.");
                    System.exit(0);
                }
                currentDenomination =  money.lastKey();
            }
        }
    }

    private void printChange(int coinsUsed, int denomination){
        if(denomination >= 100){
            System.out.println("Wydaj " + coinsUsed + " monet " + denomination/100 + "zł");
        }else{
            System.out.println("Wydaj " + coinsUsed + " monet " + denomination + "gr");
        }
    }

    public void printMoney(){
        System.out.println(money);
    }
}
