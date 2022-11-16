import Tournament.Tournament;
import participant.Participant;

public class Main {
    public static void main(String[] args) {
        // create tournament
        Tournament tournament = new Tournament("Tournament 1");

        // add participants
        tournament.addParticipant(new Participant(0,"Pesho", 100, 100));
        tournament.addParticipant(new Participant(0,"Gosho", 100, 100));
        tournament.addParticipant(new Participant(0,"Ivan", 100, 100));
        tournament.addParticipant(new Participant(0,"Misho", 100, 100));
        tournament.addParticipant(new Participant(0,"Tosho", 100, 100));
        tournament.addParticipant(new Participant(0,"Marto", 100, 100));

        // start tournament
        tournament.start();
    }
}