package participant;

import FightingStyle.FightStyle;

//Fight styles - боен стил.
//Всеки участник е от определен боен стил. Има следните бойни стилове:
//Karate
//могат да удрят и да ритат
//Judo
//могат да хвърлят и да удрят
//Muay Thai
//могат да удрят, ритат и да се въртят
//Box
//могат да удрят само

// add enum for fight styles
public class Participant {
    private int id;
    private String name;
    private int power;
    private int health;
    FightStyle fightStyle;

    public Participant(int id, String name, int power, int health) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.health = health;
        this.fightStyle = FightStyle.getRandomFightStyle();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getHealth() {
        return health;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void takeDamage(double damage) {
        this.health -= damage;
    }

    public boolean isKnockedOut() {
        return this.health <= 0;
    }

    public void attack(Participant participant) {
        switch (this.fightStyle) {
            case KARATE:
                System.out.println("Using karate");
                this.punch(participant);
                this.kick(participant);
                break;
            case JUDO:
                System.out.println("Using judo");
                this.toss(participant);
                this.punch(participant);
                break;
            case MUAY_THAI:
                System.out.println("Using muay thai");
                int savePower = this.power;
                this.setPower(savePower * 2);
                this.punch(participant);
                this.kick(participant);
                this.setPower(savePower);
                break;
            case BOX:
                System.out.println("Using box");
                this.punch(participant);
                break;
        }
    }

    public void punch(Participant participant) {
        participant.takeDamage(this.power);
    }

    public void kick(Participant participant) {
        participant.takeDamage(this.power * 1.5);
    }

    public void toss(Participant participant) {
        participant.takeDamage(this.power * 2);
    }
}
