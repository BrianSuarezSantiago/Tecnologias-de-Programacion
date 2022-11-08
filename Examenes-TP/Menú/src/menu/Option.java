package menu;

public class Option extends Element {
    private final String optionDescription;

    public Option(String optionId, String optionDescription) {
        super(optionId);
        this.optionDescription = optionDescription;
    }

    public String getText() {
        return this.optionDescription;
    }

    @Override
    public String print(int levelOfIndentation) {
        return super.print(levelOfIndentation) + "\n" + this.optionDescription;
    }
}