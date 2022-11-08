package menu;

public class Separator extends Element {

    public Separator(String separatorId) {
        super(separatorId);
    }

    @Override
    public String print(int levelOfIndentation) {
        return super.print(levelOfIndentation) + "\n" + "---------";
    }
}