package SocialMedia.demo.dto;

public class MessageSendToUserDTO {

   public String title;
    public String message;

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

    @Override
    public String toString() {
        return "MessageSendToUserDTO{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
