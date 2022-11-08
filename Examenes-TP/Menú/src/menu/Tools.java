package menu;

public class Tools {

    public static String getIndent(int levelOfIndentation) {
        String format = "";

        for(int i = 0; i < levelOfIndentation; i++) {
            format += "  -";
        }
        return "nivel " + levelOfIndentation + " => " + format;
    }
}