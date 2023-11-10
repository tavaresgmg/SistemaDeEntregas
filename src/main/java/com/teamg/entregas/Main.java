package com.teamg.entregas;

public class Main {
    public static void main(String[] args) {
        Tree arvore1 = new Tree();
        arvore1 = arvore1.createMap();
        arvore1.showMarginais();
        System.out.println("--------------------------------------------------------------------------------------");
        arvore1.showAvenidas();
        System.out.println("--------------------------------------------------------------------------------------");
        arvore1.showRuas();
    }
}