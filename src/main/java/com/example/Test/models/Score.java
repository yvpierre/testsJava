package com.example.Test.models;

public class Score {
    private int wins;
    private int losses;
    private int ties;

    public Score() {
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
    }

    public Score(int wins, int losses, int ties) {
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public String toString() {
        return "Wins: " + wins + ", Losses: " + losses + ", Ties: " + ties;
    }

}
