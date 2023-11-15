package com.teamg.entregas;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    public void clearTextArea() { //limpar o terminal
        textAreaTerminal.setText("");
    }

    @FXML
    private TextArea textAreaTerminal;

    private Tree minhaArvore;

    public void appendText (String text){
        textAreaTerminal.appendText(text + "\n");
    }

    @FXML
    private ChoiceBox<Integer> choiceBoxMarginal;

    @FXML
    private ChoiceBox<Integer> choiceBoxAvenida;

    @FXML
    private ChoiceBox<Integer> choiceBoxRua;

    @FXML
    private TextField textFieldNome;

    private String ruainterditar;

    @FXML
    private TextField textFieldRuaInterditar;

    @FXML
    public void cleanTerminal () {
        clearTextArea();
    }

    public void interditarButton(){
        if(textFieldRuaInterditar != null){
            minhaArvore.closeNode(textFieldRuaInterditar.getText());
        } else {
            return;
        }

    }
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    public void rota(){
        if(radioButton1.isSelected()){
            minhaArvore.findRoute();
        } else if (radioButton2.isSelected()){

        } else if (radioButton3.isSelected()){

        }
    }
    public void ajuda(){

    }

    public void mostrarRuas(){
        minhaArvore.showRuas();
    }
    public void mostrarAvenidas(){
        minhaArvore.showAvenidas();
    }
    public void mostrarMarginais(){
        minhaArvore.showMarginais();
    }

    @FXML
    public void handleButtonAction(){
        //obtendo os numeros inseridos
        Integer marginal = choiceBoxMarginal.getValue();
        Integer avenida = choiceBoxAvenida.getValue();
        Integer rua = choiceBoxRua.getValue();
        String nome = textFieldNome.getText();

     if (nome == null || nome.isEmpty()){
         appendText("Nome e marginal são obrigatórios!");
         return;
     }

     int numeroNo = marginal * 100 + (avenida != null ? avenida * 10 : 0) + (rua != null ? rua : 0);

     TreeNode novoNo = new TreeNode(numeroNo, nome, true, text -> appendText(text)); // Criando a instância novoNo

     minhaArvore.insertNode(novoNo);

    }

    @FXML
    public void initialize() {
        for (int i=1; i<=9; i++){
            choiceBoxMarginal.getItems().add(i);
        }
        for (int i=0; i<=9; i++){
            choiceBoxAvenida.getItems().add(i);
            choiceBoxRua.getItems().add(i);
        }

        // Inicialmente desabilita os ChoiceBoxes de avenida e rua
        choiceBoxAvenida.setDisable(true);
        choiceBoxRua.setDisable(true);

        // Listener para o ChoiceBox de marginal
        choiceBoxMarginal.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            choiceBoxAvenida.setDisable(newVal == null);
            if (newVal == null) {
                choiceBoxRua.setDisable(true);  // Desabilita o ChoiceBox de rua se a marginal não for selecionada
            }
        });

        // Listener para o ChoiceBox de avenida
        choiceBoxAvenida.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            choiceBoxRua.setDisable(newVal == null);
        });

        textAreaTerminal.setEditable(false);

        Tree tempTree = new Tree(text -> appendText(text)); // Criar uma instância temporária de Tree
        minhaArvore = tempTree.createMap(text -> appendText(text));
    }
}
