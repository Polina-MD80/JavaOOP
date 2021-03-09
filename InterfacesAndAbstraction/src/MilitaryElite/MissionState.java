package MilitaryElite;

public
enum MissionState {
    INPROGRESS("inProgress"),
    FINISHED("finished");
    private String status;

    MissionState (String status) {
        this.status = status;
    }

    @Override
    public
    String toString () {
        return this.status;
    }
}
