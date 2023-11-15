package com.teamg.entregas;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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

    @FXML
    private TextField textFieldRuaInterditar;

    @FXML
    private TextField ruaRota;

    @FXML
    public void cleanTerminal () {
        clearTextArea();
    }

    public void interditarButton(){ //Ao apertar o botão, a rua informada será interditada
        if(textFieldRuaInterditar != null){
            minhaArvore.closeNode(textFieldRuaInterditar.getText());
        } else {
            return;
        }

    }
    @FXML
    private RadioButton radioButton1;
    @FXML
    private RadioButton radioButton2;
    @FXML
    private RadioButton radioButton3;
    public void rota(){
        minhaArvore.findRoute(ruaRota.getText());
    }

    public void percurso(){
        if (radioButton1.isSelected()){
            minhaArvore.percursoPreOrdem(minhaArvore.getRoot());
        } else if(radioButton2.isSelected()){
            minhaArvore.percursoCentral(minhaArvore.getRoot());
        } else if(radioButton3.isSelected()){
            minhaArvore.percursoPosOrdem(minhaArvore.getRoot());
        }
    }

    public String lerReadme() throws IOException {
        String conteudo = "";

        conteudo = new String(Files.readAllBytes(Paths.get("README.md")));

        return conteudo;
    }

    public void mostrarReadme() {
        String readme;
        try {
            readme = lerReadme();
        } catch (IOException e) {
            e.printStackTrace();
            readme = "Não foi possível ler o arquivo README.";
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajuda");
        alert.setHeaderText("Informações do README");
        alert.setContentText(readme);

        alert.showAndWait();
    }


    public void mostrarRuas(){ //Ao apertar o botão, serão impressas as ruas cadastradas no programa
        minhaArvore.showRuas();
    }
    public void mostrarAvenidas(){ //Ao apertar o botão, serão impressas as avenidas cadastradas no programa
        minhaArvore.showAvenidas();
    }
    public void mostrarMarginais(){ //Ao apertar o botão, serão impressas as marginais cadastradas no programa
        minhaArvore.showMarginais();
    }

    @FXML
    public void handleButtonAction(){ //Ao apertar o botão inserir, será conferido se existe um nome, e um código válido,
        //após isso, será inserida uma marginal/avenida/rua ao sistema
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
