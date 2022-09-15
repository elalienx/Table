import java.util.List;

public record Item(int id, String manufacturer, String model, String paintScheme, String wheelColor) {
    public List<String> generateSimpleList() {
        return List.of(manufacturer, model, paintScheme, wheelColor);
    }
}
