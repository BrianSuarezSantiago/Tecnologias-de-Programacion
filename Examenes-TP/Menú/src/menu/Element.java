package menu;

public abstract class Element {
    private final String elementId;

    public Element(String elementId) {
        this.elementId = elementId;
    }

    public String getId() {
        return this.elementId;
    }

    public String print(int levelOfIndentation) {
        String format = "";    // StringBuilder

        for (int i = 0; i < levelOfIndentation; i++) {
            format += "  -";
        }
        return "nivel " + levelOfIndentation + " => " + format;
    }
}

/*
ALTERNATIVA AL MÉTODO print()
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < levelOfIndentation; i++) {
            sb.append("  -");
        }
        return String.format("nivel %d => " + sb.toString(), levelOfIndentation);
*/