package com.teamg.entregas;

import java.util.ArrayList;

public class TreeNode {
    private int number;
    private String name;
    private boolean flag;
    public TreeNode[] children = new TreeNode[10]; // posições iniciam com null
    private NodeDisplay nodeDisplay;

    TreeNode(int number, String name, boolean flag, NodeDisplay nodeDisplay) {
        this.number = number;
        this.name = name;
        this.flag = flag;
        this.nodeDisplay = nodeDisplay;
    }

    public void showNode() {
        if (nodeDisplay != null) {
            nodeDisplay.display("Número: " + this.number);
            nodeDisplay.display("Nome: " + this.name);
            nodeDisplay.display("Flag: " + this.flag);
        }
    }

    public int getNumber() {
        return number;
    }
}
