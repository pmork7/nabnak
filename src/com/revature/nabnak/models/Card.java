package com.revature.nabnak.models;

public class Card {
    // Attributes
    private String card_id;
    private String description;
    private int points;
    private String tech;
    private int status;
    private String member_email;

    // Constructor
    public Card(String card_id, String description, int points, String tech, int status, String member_email) {
        this.card_id = card_id;
        this.description = description;
        this.points = points;
        this.tech = tech;
        this.status = status;
        this.member_email = member_email;
    }

    public Card() {
        // super();
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }

    @Override
    public String toString() {
        return "Card{" +
                "card_id='" + card_id + '\'' +
                ", description='" + description + '\'' +
                ", points=" + points +
                ", tech='" + tech + '\'' +
                ", status=" + status +
                ", member_email='" + member_email + '\'' +
                '}';
    }
}
