package menu;

public class Menu extends Element {
    private final String menuDescription;
    private boolean isFolded;
    private Element[] menu = new Element[20];

    public Menu(String menuId, String menuDescription) {
        super(menuId);
        this.menuDescription = menuDescription;
        this.isFolded = false;
    }

    public String getText() {
        return this.menuDescription;
    }

    public void setFolded(boolean foldedFeature) {
        this.isFolded = foldedFeature;
    }

    public boolean isFolded() {
        return this.isFolded;
    }

    public boolean addElement(Element element) {
        // TODO: FALTA COMPROBAR SI EL NUMERO DE ELEMENTOS CONTENIDOS EN EL ARRAY ES 20
        for(int i = 0; i < this.menu.length; i++) {
            if(this.menu[i] == element) {
                return false;
            }
        }
        this.menu[this.menu.length -1] = element;
        return true;
    }

    // TODO: FALLA
    public boolean isContain(String elementId) {
        for(int i = 0; i < this.menu.length; i++) {
            if(this.menu[i].getId().equalsIgnoreCase(elementId)) {
                // TODO: COMO SE COMPRUEBA SI ESTA CONTENIDO DIRECTA O INDIRECTAMENTE
                return true;
            }
        }
        return false;
    }

    // TODO: FALLA
    public Element[] getElements() {
        Element[] copyOfMenu = new Element[this.menu.length];
        return copyOfMenu;
    }

    // TODO: FALLA
    @Override
    public String print(int levelOfIndentation) {
        if(this.isFolded) {
            return super.print(levelOfIndentation) + "\n" + this.menuDescription;
        } else {
            String format = "";

            for(int i = 0; i < this.menu.length; i++) {
                format += super.print(levelOfIndentation + 1) + "\n" + this.menu[i];
            }
            return super.print(levelOfIndentation) + "\n" + this.menuDescription + format;
        }
    }
}