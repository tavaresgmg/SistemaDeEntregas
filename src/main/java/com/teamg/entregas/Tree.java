package com.teamg.entregas;

public class Tree {
    private final TreeNode root;
    private NodeDisplay nodeDisplay;

    Tree(NodeDisplay nodeDisplay) {
        this.root = new TreeNode(0, "Empresa", true, nodeDisplay);
        this.nodeDisplay = nodeDisplay;
    }
    public void insertNode(TreeNode no) {
        TreeNode aux = root;
        int numNo = no.getNumber();
        int marginal = 0, avenida = 0, rua = 0;


        marginal = numNo / 100;
        avenida = (numNo % 100) / 10;
        rua = (numNo % 10);

        if (avenida == 0 && rua == 0) {
            root.children[marginal] = no;
            nodeDisplay.display("Marginal inserida com sucesso!");
            return;
        }
        if (rua == 0) {
            if (root.children[marginal] != null) {
                root.children[marginal].children[avenida] = no;
                nodeDisplay.display("Avenida inserida com sucesso!");
            } else {
                nodeDisplay.display("Não é possível colocar essa rua");
            }
        } else {
            if (root.children[marginal] != null && root.children[marginal].children[avenida] != null) {
                root.children[marginal].children[avenida].children[rua] = no;
                nodeDisplay.display("Rua inserida com sucesso!");
            } else {
                nodeDisplay.display("Não é possível colocar essa rua");
            }

        }
    }

    public Tree createMap(NodeDisplay nodeDisplay) {
        Tree arvoreMapa = new Tree(nodeDisplay);
        arvoreMapa.insertNode(new TreeNode(100, "Marginal Botafogo", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(200, "Marginal Tietê", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(300, "Marginal Ramos", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(400, "Marginal Oliveiras", true, nodeDisplay));

        arvoreMapa.insertNode(new TreeNode(110, "Avenida A", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(120, "Avenida H", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(130, "Avenida B", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(210, "Avenida C", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(220, "Avenida D", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(230, "Avenida E", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(310, "Avenida F", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(320, "Avenida G", true, nodeDisplay));

        arvoreMapa.insertNode(new TreeNode(111, "Rua 11", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(121, "Rua 21", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(234, "Rua 34", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(325, "Rua 25", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(313, "Rua 13", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(127, "Rua 27", true, nodeDisplay));
        arvoreMapa.insertNode(new TreeNode(115, "Rua 15", true, nodeDisplay));

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
