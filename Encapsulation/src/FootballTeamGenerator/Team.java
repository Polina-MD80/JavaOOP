package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public
class Team {

    private String name;
    private int rating;
    private List<Player> players;

    public
    Team (String name) {
        setName (name);
        this.rating = 0;
        this.players = new ArrayList<> ();
    }

    private
    void setName (String name) {
        if (name == null || name.trim ().isEmpty ()) {
            throw new IllegalArgumentException ("A name should not be empty.");
        }
        this.name = name;
    }

    public
    String getName () {
        return this.name;
    }

    public
    void addPlayer (Player player) {
        this.players.add (player);
    }

    public
    void removePlayer (String name) {
        boolean playerIsInTeam = false;
        for (Player player : players) {
            if (player.getName ().equals (name)) {
                players.remove (player);
                playerIsInTeam = true;
                break;
            }
        }
        if (!playerIsInTeam) {
            throw new IllegalArgumentException (String.format ("Player %s is not in %s team.", name, this.name));
        }
    }

    public
    long setRatting () {
        double currRating = 0;
        for (Player player : this.players) {
            currRating += player.overallSkillLevel ();
        }
        if (currRating == 0) {
            this.rating = (int) currRating;
        } else {
            currRating = (int) Math.round (currRating / players.size ());
            this.rating = (int) currRating;
        }
        return this.rating;
    }

    public
    int getRating () {
        return (int) Math.round (this.players.stream ().mapToDouble (Player::overallSkillLevel).sum ());
    }
}

