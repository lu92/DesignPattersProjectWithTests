package DesignPatternsProject.DTO;

/**
 * Created by lucjan on 13.06.15.
 */
public class CategoryFormDTO {
    private String name;

    public CategoryFormDTO() {
    }

    public CategoryFormDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
