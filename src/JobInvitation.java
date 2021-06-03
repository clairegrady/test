public class JobInvitation {

    private String message;
    private int dateInvited;

    public JobInvitation() {
        message = "";
        dateInvited = 0;
    }

    public int getDateInvited() {
        return dateInvited;
    }

    public String getMessage() {
        return message;
    }

    public void setDateInvited(int dateInvited) {
        this.dateInvited = dateInvited;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}