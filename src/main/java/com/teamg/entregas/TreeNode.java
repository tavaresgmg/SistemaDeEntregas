package com.teamg.entregas;

import java.util.ArrayList;

public class TreeNode {
    private int number;
    private String name;
    private boolean flag;
    public TreeNode[] children = new TreeNode[10]; // posições iniciam com null

    TreeNode(int number, String name, boolean flag) {
        this.number = number;
        this.name = name;
        this.flag = flag;
    }

    public void showNode() {
        System.out.println("Número: " + this.number);
        System.out.println("Nome: " + this.name);
        System.out.println("Flag: " + this.flag);
        System.out.println();
    }

    public int getNumber() {
        return number;
    }
}
