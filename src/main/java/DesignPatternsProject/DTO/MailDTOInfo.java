package DesignPatternsProject.DTO;

/**
 * Created by lucjan on 13.06.15.
 */
public class MailDTOInfo {

    private Long mailId;

    private String addresEmailFrom;
    private Long personFromId;

    private String addresEmailTo;
    private Long toId;

    private String title;
    private String message;


    public MailDTOInfo() {
    }



    public MailDTOInfo(Long mailId, String addresEmailFrom, Long personFromId, String addresEmailTo, Long toId, String title, String message) {
        this.mailId = mailId;
        this.addresEmailFrom = addresEmailFrom;
        this.personFromId = personFromId;
        this.addresEmailTo = addresEmailTo;
        this.toId = toId;
        this.title = title;
        this.message = message;
    }

    public String getAddresEmailFrom() {
        return addresEmailFrom;
    }

    public void setAddresEmailFrom(String addresEmailFrom) {
        this.addresEmailFrom = addresEmailFrom;
    }

    public Long getPersonFromId() {
        return personFromId;
    }

    public void setPersonFromId(Long personFromId) {
        this.personFromId = personFromId;
    }

    public String getAddresEmailTo() {
        return addresEmailTo;
    }

    public void setAddresEmailTo(String addresEmailTo) {
        this.addresEmailTo = addresEmailTo;
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
