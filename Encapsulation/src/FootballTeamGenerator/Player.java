package FootballTeamGenerator;

public
class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;



    public
    Player (String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName (name);
        setEndurance (endurance);
        setSprint (sprint);
        setDribble (dribble);
        setPassing (passing);
        setShooting (shooting);
    }

    private
    void validateStatistics (String statisticType, int statistic) {
        if (statistic < 0 || statistic > 100) {
            throw new IllegalArgumentException (statisticType + " should be between 0 and 100.");
        }
    }

    private
    void validateName (String name) {
        if (name == null || name.trim ().isEmpty ()) {
            throw new IllegalArgumentException ("A name should not be empty.");
        }
    }

    public
    String getName () {
        return this.name;
    }

    private
    void setName (String name) {
        this.name = name;
    }

    private
    void setEndurance (int endurance) {
        validateStatistics ("Endurance", endurance);
        this.endurance = endurance;
    }

    private
    void setSprint (int sprint) {
        validateStatistics ("Sprint", sprint);
        this.sprint = sprint;
    }

    private
    void setDribble (int dribble) {
        validateStatistics ("Dribble", dribble);
        this.dribble = dribble;
    }

    private
    void setPassing (int passing) {
        validateStatistics ("Passing", passing);
        this.passing = passing;
    }

    private
    void setShooting (int shooting) {
        validateStatistics ("Shooting", shooting);
        this.shooting = shooting;
    }

    public
    double overallSkillLevel () {
        return (this.dribble + this.endurance + this.passing + this.shooting + this.sprint) / 5.0;
    }

}
