package com.teamg.entregas;

import java.util.Objects;

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

    public void findRoute(String nome) {
        String marg, av, r;
        boolean interditado = false;


        for (TreeNode marginal : this.root.children) {
            if (marginal == null) {
                continue;
            }
            if (!marginal.getFlag()) {
                interditado = !marginal.getFlag();
                continue;
            }

            marg = marginal.getName();
            if (Objects.equals(marg, nome)) {
                System.out.println(this.root.getName() + " -> " + marg);
                return;
            }

            for (TreeNode avenida : marginal.children) {
                if (avenida == null) {
                    continue;
                }
                if (!avenida.getFlag()) {
                    interditado = !avenida.getFlag();
                    continue;
                }

                av = avenida.getName();
                if (Objects.equals(av, nome)) {
                    System.out.println(this.root.getName() + " -> " + marg + " -> " + av);
                    return;
                }

                for (TreeNode rua : avenida.children) {
                    if (rua == null) {
                        continue;
                    }
                    if (!rua.getFlag()) {
                        interditado = !rua.getFlag();
                        continue;
                    }
                    r = rua.getName();
                    if (Objects.equals(r, nome)) {
                        System.out.println(this.root.getName() + " -> " + marg + " -> " + av + " -> " + r);
                        return;
                    }
                }
            }
        }

        if (interditado) {
            nodeDisplay.display("Não foi possível encontrar uma rota. Parte do caminho está interditado.");
        } else {
            nodeDisplay.display("Não foi possível encontrar uma rota. Essa rua não existe no mapa.");
        }
    }

    public void closeNode(String nome) {

        for (TreeNode marginal : this.root.children) {
            if (marginal == null) {
                continue;
            }
            if (Objects.equals(marginal.getName(), nome)) {
                marginal.setFlag(false);
                nodeDisplay.display("Marginal interditada com sucesso!");
                return;
            }

            for (TreeNode avenida : marginal.children) {
                if (avenida == null) {
                    continue;
                }
                if (Objects.equals(avenida.getName(), nome)) {
                    avenida.setFlag(false);
                    nodeDisplay.display("Avenida interditada com sucesso!");
                    return;
                }

                for (TreeNode rua : avenida.children) {
                    if (rua == null) {
                        continue;
                    }
                    if (Objects.equals(rua.getName(), nome)) {
                        rua.setFlag(false);
                        nodeDisplay.display("Rua interditada com sucesso!");
                        return;
                    }
                }
            }
        }


        nodeDisplay.display("Não foi possível encontrar essa Rua.");
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
    /*
     void percursoPreOrdem(TreeNode no) {
            if (no != null) {
                no.showNode();
                for (TreeNode child : no.children) {
                    percursoPreOrdem(child);
                }
            }
        }
    
        void percursoCentral(TreeNode no) {
            if (no != null) {
            int numChildren = 0;
            int lastChild = 0;
            for (int i = 0; i <= 9; i++) {
                if ( no.children[i] != null ){
                    numChildren++;
                    lastChild = i;
                }
            }
            for (int i = 0; i <= 9; i++) {
                    if ( i == lastChild){
                        no.showNode();
                    } 
                    percursoCentral(no.children[i]);
            }
        }
        }
    
        void percursoPosOrdem(TreeNode no) {
            if (no != null) {
                for (TreeNode child : no.children) {
                    percursoPosOrdem(child);
                }
                no.showNode();
            }
        }
    */
}
