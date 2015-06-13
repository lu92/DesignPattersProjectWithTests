package DesignPatternsProject.DTO;

/**
 * Created by lucjan on 13.06.15.
 */
public class ServiceFormDTO {
    private String name;
    private double netto;
    private Long categoryId;
    private Long workerId;

    public ServiceFormDTO() {
    }

    public ServiceFormDTO(String name, double netto, Long categoryId, Long workerId) {
        this.name = name;
        this.netto = netto;
        this.categoryId = categoryId;
        this.workerId = workerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNetto() {
        return netto;
    }

    public void setNetto(double netto) {
        this.netto = netto;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }
}
