package DesignPatternsProject.DTO;

/**
 * Created by lucjan on 13.06.15.
 */
public class MailFromDTO {
    private Long fromId;
    private Long toId;
    private String title;
    private String message;


    public MailFromDTO() {
    }

    public MailFromDTO(Long fromId, Long toId, String title, String message) {
        this.fromId = fromId;
        this.toId = toId;
        this.title = title;
        this.message = message;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
