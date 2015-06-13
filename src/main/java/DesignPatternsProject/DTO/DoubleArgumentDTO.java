package DesignPatternsProject.DTO;

/**
 * Created by lucjan on 13.06.15.
 */
public class DoubleArgumentDTO {
    private long firstArgument;
    private long secondArgument;


    public DoubleArgumentDTO() {
    }

    public DoubleArgumentDTO(long firstArgument, long secondArgument) {
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
    }

    public long getFirstArgument() {
        return firstArgument;
    }

    public void setFirstArgument(long firstArgument) {
        this.firstArgument = firstArgument;
    }

    public long getSecondArgument() {
        return secondArgument;
    }

    public void setSecondArgument(long secondArgument) {
        this.secondArgument = secondArgument;
    }
}
