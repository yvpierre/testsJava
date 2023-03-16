package com.example.Test.controllers;

import com.example.Test.models.Score;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SpringBootApplication
@RestController
@RequestMapping("/game")
public class TestController {
    private int wins;
    private int losses;
    private int ties;

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

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestController that = (TestController) o;
        return wins == that.wins && losses == that.losses && ties == that.ties;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wins, losses, ties);
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    @GetMapping("/play/{playerAction}")
    public String play(@PathVariable String playerAction) {
        String[] validActions = {"pierre", "feuille", "ciseaux"};
        String computerAction = validActions[(int) (Math.random() * validActions.length)];
        String result = getResult(playerAction, computerAction);
        updateScore(result);
        return "You played " + playerAction + ". The computer played " + computerAction + ". " + result;
    }

    @PostMapping("/restart")
    public void restart() {
        wins = 0;
        losses = 0;
        ties = 0;
    }

    @GetMapping("/score")
    public String score() {
        return "Victoires: " + wins + ", Défaites: " + losses + ", Égalités: " + ties;
    }

    @PutMapping("/score/{wins}/{losses}/{ties}")
    public void setScore(@PathVariable int wins, @PathVariable int losses, @PathVariable int ties) {
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }

    @GetMapping("/scores/")
    public Score getScore() {
        return new Score(this.wins, this.losses, this.ties);
    }



    private String getResult(String playerAction, String computerAction) {
        if (playerAction.equals(computerAction)) {
            ties++;
            return "Égalité !";
        }
        switch (playerAction) {
            case "pierre":
                if (computerAction.equals("ciseaux")) {
                    wins++;
                    return "You win!";
                } else {
                    losses++;
                    return "You lose!";
                }
            case "paper":
                if (computerAction.equals("rock")){
                    wins++;
                    return "You win!";
                } else {
                    losses++;
                    return "You lose!";
                }
            case "scissors":
                if (computerAction.equals("paper")){
                    wins++;
                    return "You win!";
                } else {
                    losses++;
                    return "You lose!";
                }
            default:
                return "Invalid action!";
        }
    }

    private void updateScore(String result) {
        if (result.equals("You win!")) {
            wins++;
        } else if (result.equals("You lose!")) {
            losses++;
        } else {
            ties++;
        }
    }



}


