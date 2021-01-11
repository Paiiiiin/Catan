package com.denisiuk.catan.entity;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int player_id;

    @Column(name = "stone")
    private int stone;

    @Column(name = "grain")
    private int grain;

    @Column(name = "wood")
    private int wood;

    @Column(name = "sheep")
    private int sheep;

    @Column(name = "ore")
    private int ore;

    @Column(name = "knight")
    private int knight;

    @Column(name = "monopoly")
    private int monopoly;

    @Column(name = "invention")
    private int invention;

    @Column(name = "freeroads")
    private int freeRoads;

    @Column(name = "victorypointsvisible")
    private int victoryPointsVisible;

    @Column(name = "victorypoints")
    private int victoryPoints;

    public Player(){}

    public Player(int player_id, int stone, int grain, int wood,
                  int sheep, int ore, int knight, int monopoly,
                  int invention, int freeRoads, int victoryPointsVisible,
                  int victoryPoints) {
        this.player_id = player_id;
        this.stone = stone;
        this.grain = grain;
        this.wood = wood;
        this.sheep = sheep;
        this.ore = ore;
        this.knight = knight;
        this.monopoly = monopoly;
        this.invention = invention;
        this.freeRoads = freeRoads;
        this.victoryPointsVisible = victoryPointsVisible;
        this.victoryPoints = victoryPoints;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public int getStone() {
        return stone;
    }

    public void setStone(int stone) {
        this.stone = stone;
    }

    public int getGrain() {
        return grain;
    }

    public void setGrain(int grain) {
        this.grain = grain;
    }

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getSheep() {
        return sheep;
    }

    public void setSheep(int sheep) {
        this.sheep = sheep;
    }

    public int getOre() {
        return ore;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public int getKnight() {
        return knight;
    }

    public void setKnight(int knight) {
        this.knight = knight;
    }

    public int getMonopoly() {
        return monopoly;
    }

    public void setMonopoly(int monopoly) {
        this.monopoly = monopoly;
    }

    public int getInvention() {
        return invention;
    }

    public void setInvention(int invention) {
        this.invention = invention;
    }

    public int getFreeRoads() {
        return freeRoads;
    }

    public void setFreeRoads(int freeRoads) {
        this.freeRoads = freeRoads;
    }

    public int getVictoryPointsVisible() {
        return victoryPointsVisible;
    }

    public void setVictoryPointsVisible(int victoryPointsVisible) {
        this.victoryPointsVisible = victoryPointsVisible;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }

    public void setVictoryPoints(int victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    @Override
    public String toString() {
        return "Player{" +
                "player_id=" + player_id +
                ", stone=" + stone +
                ", grain=" + grain +
                ", wood=" + wood +
                ", sheep=" + sheep +
                ", ore=" + ore +
                ", knight=" + knight +
                ", monopoly=" + monopoly +
                ", invention=" + invention +
                ", freeRoads=" + freeRoads +
                ", victoryPointsVisible=" + victoryPointsVisible +
                ", victoryPoints=" + victoryPoints +
                '}';
    }
}
