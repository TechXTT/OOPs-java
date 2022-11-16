package Tournament;

import participant.Participant;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private String name;
    private List<Participant> participants;

    public Tournament(String name) {
        this.name = name;
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Participant participant) {
        participant.setId(this.participants.size() + 1);
        this.participants.add(participant);
    }

    public void start() {
        if (this.participants.size() == 1) {
            throw new IllegalArgumentException("There must be at least two participants");
        }

        List<Participant> group1 = new ArrayList<>();
        List<Participant> group2 = new ArrayList<>();

        for (int i = 0; i < this.participants.size(); i++) {
            if (i % 2 == 0) {
                group1.add(this.participants.get(i));
            } else {
                group2.add(this.participants.get(i));
            }
        }

        while (group1.size() > 1 && group2.size() > 1) {
            Participant participant1 = group1.get((int) (Math.random() * group1.size()));
            Participant participant2 = group2.get((int) (Math.random() * group2.size()));
            System.out.println(participant1.getName() + " vs " + participant1.getName());
            Participant winner = fight(participant1, participant1);
            System.out.println(winner.getName() + " wins!");
            if (winner == participant1) {
                group2.remove(participant2);
            } else {
                group1.remove(participant1);
            }
        }

        if (group1.size() == 1) {
            System.out.println(group1.get(0).getName() + " is the winner of the tournament " + this.name);
        } else {
            System.out.println(group2.get(0).getName() + " is the winner of the tournament " + this.name);
        }
    }

    private Participant fight(Participant participant1, Participant participant2) {
        while (!participant1.isKnockedOut() && !participant2.isKnockedOut()) {
            System.out.println(participant1.getName() + " attacks " + participant2.getName());
            participant1.attack(participant2);
            if (participant2.isKnockedOut()) {
                break;
            }
            System.out.println(participant2.getName() + " attacks " + participant1.getName());
            participant2.attack(participant1);
        }

        if (!participant1.isKnockedOut()) {
            participant1.setHealth(100);
            return participant1;
        } else {
            participant2.setHealth(100);
            return participant2;
        }
    }
}
