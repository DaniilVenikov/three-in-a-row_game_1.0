import java.util.List;

public class Combination {
    private final List<Field> fields;
    private final ElementType elementType;

    public Combination(List<Field> fields, ElementType type) {
        this.fields = fields;
        this.elementType = type;
    }

    public List<Field> getFields() {
        return fields;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public int getSize() {
        return fields.size();
    }
}
