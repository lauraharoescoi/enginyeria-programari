package data;
import data.goalTypes;

public class Goal {
    private final goalTypes goalType;

    public Goal (goalTypes goalType ) {
        this.goalType = goalType;
    }

    public goalTypes getGoalType () {
        if (goalType == null) {
            throw new IllegalArgumentException("Goal type is null");
        }
        return goalType;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goal goal = (Goal) o;
        return goalType == goal.goalType;
    }

    @Override
    public int hashCode () { return goalType.hashCode(); }

    @Override
    public String toString () {
        return "Goal{" + "goalType=" + goalType + ", goalDescription='" + '\'' + '}';
    }
}
