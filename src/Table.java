import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {
    // Properties
    List<String> header;
    List<List<String>> body;
    List<Integer> columnWidths;
    String format;

    // Constructor
    public Table(List<String> header, List<List<String>> body, List<Integer> columnWidths) {
        this.header = header;
        this.body = body;
        this.columnWidths = columnWidths;
        this.format = createFormat(columnWidths);
    }

    // Public
    public void showData() {
        generateBorder();
        generateHeader();
        generateBorder();
        generateBody();
        generateBorder();
    }

    // Private
    private String createFormat(List<Integer> columnWidths) {
        StringBuilder result = new StringBuilder();

        for (Integer item : columnWidths) {
            result.append("| %-").append(item).append("s ");
        }
        result.append("|%n");

        return result.toString();
    }

    private void generateBorder() {
        List<String> tableCells = new ArrayList<>();

        for (Integer item : columnWidths) {
            char[] repeat = new char[item];
            Arrays.fill(repeat, '-');
            String result = new String(repeat);

            tableCells.add(result);
        }

        System.out.format(format, tableCells.toArray());
    }

    private void generateHeader() {
        System.out.format(format, header.toArray());
    }

    private void generateBody() {
        for (List<String> item : body) {
            System.out.format(format, item.toArray());
        }
    }
}