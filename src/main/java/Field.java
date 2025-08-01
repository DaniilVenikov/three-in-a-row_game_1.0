public class Field {
    private ElementType type;
    private Bonus bonus;

    public Field(ElementType type) {
        this.type = type;
        this.bonus = null;
    }

    public ElementType getElementType() {
        return type;
    }

    public boolean isEmpty() {
        return type == null;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public void setElementType(ElementType type) {
        this.type = type;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }
}
