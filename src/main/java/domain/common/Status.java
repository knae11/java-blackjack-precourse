package domain.common;

public enum Status {

    WINNER("winner"),
    LOSER("loser");

    private final String status;
    Status(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
