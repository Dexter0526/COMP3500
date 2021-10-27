package academy.pocu.ch09.knapsack;

public class App {
    public static void main(String[] args) {
        Item[] items = new Item[5];

        items[0] = new Item(3, 5);
        items[1] = new Item(9, 12);
        items[2] = new Item(1, 2);
        items[3] = new Item(5, 4);
        items[4] = new Item(7, 9);

        int maxValue = getMaxValue(15, items);

        System.out.println(String.format("Max Value: %d", maxValue));
        
    }

    private static int getMaxValue(int numSpace, Item[] items){
        int numItems = items.length;

        int cache[][] = new int[numItems][numSpace + 1];

//        첫 번째 칸
        for(int i = 1; i <= numSpace; i++){
            if(items[0].getSpace() > i) continue;

            cache[0][i] = items[0].getValue();
        }

        for (int i = 1; i < numItems; i++){
            for(int j = 1; j <= numSpace; j++){
                if(items[i].getSpace() > j){
                    cache[i][j] = cache[i - 1][j];
                    continue;
                }

                int remainingSpace = j - items[i].getSpace();
                int remainingMaxValue = cache[i - 1][remainingSpace];

                int choice1 = cache[i - 1][j];
                int choice2 = items[i].getValue() + remainingMaxValue;

                cache[i][j] = Math.max(choice1, choice2);
            }
        }

        return cache[numItems - 1][numSpace];
    }
}
