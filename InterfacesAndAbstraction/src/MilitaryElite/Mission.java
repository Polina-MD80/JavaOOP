package MilitaryElite;

public
class Mission {
    private String name;
    private Enum<MissionState> missionState;

    public
    Mission (String name, Enum<MissionState> missionState) {
        this.name = name;
        this.missionState = missionState;
    }

    public
    Enum<MissionState> getMissionState () {
        return missionState;
    }

    @Override
    public
    String toString () {
        return String.format ("Code Name: %s State: %s", this.name, missionState.toString ());
    }
}
