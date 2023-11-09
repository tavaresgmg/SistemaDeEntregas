package com.teamg.entregas;

import java.util.ArrayList;

public class TreeNode {
    private int number;
    private String name;
    private boolean flag;

    public ArrayList<TreeNode> children = new ArrayList<>();

    TreeNode(int number, String name, boolean flag) {
        this.number = number;
        this.name = name;
        this.flag = flag;
    }
}
