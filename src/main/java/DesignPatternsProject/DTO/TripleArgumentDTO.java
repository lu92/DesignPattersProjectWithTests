package DesignPatternsProject.DTO;

/**
 * Created by lucjan on 13.06.15.
 */
public class TripleArgumentDTO {
    private long firstArgument;
    private long secondArgument;
    private long thirdArgument;

    public TripleArgumentDTO() {
    }

    public TripleArgumentDTO(long firstArgument, long secondArgument, long thirdArgument) {
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
        this.thirdArgument = thirdArgument;
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

    public long getThirdArgument() {
        return thirdArgument;
    }

    public void setThirdArgument(long thirdArgument) {
        this.thirdArgument = thirdArgument;
    }
}
