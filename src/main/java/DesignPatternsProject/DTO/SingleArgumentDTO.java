package DesignPatternsProject.DTO;

/**
 * Created by lucjan on 13.06.15.
 */
public class SingleArgumentDTO {
    private long value;

    public SingleArgumentDTO() {
    }

    public SingleArgumentDTO(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
