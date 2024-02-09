package org.example.slotmachine;

import java.util.Arrays;

public class SlotMachine implements ISlotMachine {
    private String name;
    private int reels;
    private double jackpot;

    private SYMBOL[] symbols;

    public SlotMachine(String name, int reels, double jackpot) {
        this.name = name;
        this.reels = reels;
        this.jackpot = jackpot;
    }

    public SlotMachine() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReels() {
        return reels;
    }

    public void setReels(int reels) {
        this.reels = reels;
    }

    public double getJackpot() {
        return jackpot;
    }

    public void setJackpot(double jackpot) {
        this.jackpot = jackpot;
    }

    public String spin() {
        if (symbols == null || symbols.length == 0) {
            throw new IllegalStateException("Symbols are not set up correctly.");
        }
        //we have to spin x reels
        SYMBOL[] resultFromEachSpin = new SYMBOL[reels];
        for(int i = 0 ; i<reels ; ++i) {
            int randomIndex = generateRandom(0, symbols.length-1);
            resultFromEachSpin[i] = symbols[randomIndex];
        }
        System.out.println("After SPIN");
        System.out.println(Arrays.toString(resultFromEachSpin));
        return getResult(resultFromEachSpin);
    }

    private String getResult(SYMBOL[] results) {
        for(int i =0 ; i<results.length-1 ; ++i) {
            if(!results[i].equals(results[i+1])){
                return "LOST";
            }
        }
        return "WON THE JACKPOT $" + jackpot;
    }

    public void setupSymbols(SYMBOL[] symbols) {
        this.symbols = symbols;
    }

    private int generateRandom(int min, int max) {
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }

}
