package Java新特性.stream;

import Java新特性.stream.pojo.Dish;
import Java新特性.stream.pojo.Trader;
import Java新特性.stream.pojo.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author SongShengLin
 * @date 2021/9/4
 */
public class CollectDemo {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        // groupBy分组
        Map<Trader, List<Transaction>> collect = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getTrader));

    }
}
