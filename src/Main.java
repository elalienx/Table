import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> cars =List.of(
                new Item(1, "Ferrari", "F-30", "Red", "Gold"),
                new Item(2, "Tesla", "Model S", "Silver", "Black")
        );
        List<String> headers = List.of("Manufacturer", "Model", "Car color", "Wheel color");
        List<List<String>> data = parseData(cars);
        List<Integer> columnWidths = List.of(20, 20, 40, 20);
        Table table = new Table(headers, data, columnWidths);

        table.showData();
    }

    private static List<List<String>> parseData(List<Item> items) {
        List<List<String>> result = new ArrayList<>();

        for (Item item: items) {
            List<String> data = List.of(item.manufacturer(), item.model(), item.paintScheme(), item.wheelColor());

            result.add(data);
        }
        
        return result;
    } 
}