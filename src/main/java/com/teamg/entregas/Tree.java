package com.teamg.entregas;

public class Tree {
    private final TreeNode root;

    Tree() {
        this.root = new TreeNode(0, "Empresa", true);
    }
    public void insertNode(TreeNode no) {
        TreeNode aux = root;
        int numNo = no.getNumber();
        int marginal = 0, avenida = 0, rua = 0;

        if (numNo < 100 || numNo > 999) {
            System.out.println("Número do nó inválido!");
            return;
        }

        marginal = numNo / 100;
        avenida = (numNo % 100) / 10;
        rua = (numNo % 10);

        if (avenida == 0 && rua != 0) {
            System.out.println("Número do nó inválido!");
            return;
        }

        if (avenida == 0 && rua == 0) {
            root.children[marginal] = no;
            return;
        }
        if (rua == 0) {
            if (root.children[marginal] != null) {
                root.children[marginal].children[avenida] = no;
            } else {
                System.out.println("Não é possível colocar essa rua");
            }
        } else {
            if (root.children[marginal] != null && root.children[marginal].children[avenida] != null) {
                root.children[marginal].children[avenida].children[rua] = no;
            } else {
                System.out.println("Não é possível colocar essa rua");
            }

        }
    }

    public Tree createMap() {
        Tree arvoreMapa = new Tree();
        arvoreMapa.insertNode(new TreeNode(100, "Marginal Botafogo", true));
        arvoreMapa.insertNode(new TreeNode(200, "Marginal Tietê", true));
        arvoreMapa.insertNode(new TreeNode(300, "Marginal Ramos", true));
        arvoreMapa.insertNode(new TreeNode(400, "Marginal Oliveiras", true));

        arvoreMapa.insertNode(new TreeNode(110, "Avenida A", true));
        arvoreMapa.insertNode(new TreeNode(120, "Avenida H", true));
        arvoreMapa.insertNode(new TreeNode(130, "Avenida B", true));
        arvoreMapa.insertNode(new TreeNode(210, "Avenida C", true));
        arvoreMapa.insertNode(new TreeNode(220, "Avenida D", true));
        arvoreMapa.insertNode(new TreeNode(230, "Avenida E", true));
        arvoreMapa.insertNode(new TreeNode(310, "Avenida F", true));
        arvoreMapa.insertNode(new TreeNode(320, "Avenida G", true));

        arvoreMapa.insertNode(new TreeNode(111, "Rua 11", true));
        arvoreMapa.insertNode(new TreeNode(121, "Rua 21", true));
        arvoreMapa.insertNode(new TreeNode(234, "Rua 34", true));
        arvoreMapa.insertNode(new TreeNode(325, "Rua 25", true));
        arvoreMapa.insertNode(new TreeNode(313, "Rua 13", true));
        arvoreMapa.insertNode(new TreeNode(127, "Rua 27", true));
        arvoreMapa.insertNode(new TreeNode(115, "Rua 15", true));

        return arvoreMapa;
    }

    public void showMarginais() {
        for (TreeNode marginal : root.children) {
            if (marginal != null) {
                marginal.showNode();
            }
        }
    }

    public void showAvenidas() {
        for (TreeNode marginal : root.children) {
            if(marginal == null) {
                continue;
            }
            for (TreeNode avenida : marginal.children) {
                if (avenida != null) {
                    avenida.showNode();
                }
            }
        }
    }

    public void showRuas() {
        for (TreeNode marginal : root.children) {
            if(marginal == null) {
                continue;
            }
            for (TreeNode avenida : marginal.children) {
                if (avenida == null) {
                    continue;
                }
                for (TreeNode rua : avenida.children) {
                    if (rua != null) {
                        rua.showNode();
                    }
                }
            }
        }
    }
}
