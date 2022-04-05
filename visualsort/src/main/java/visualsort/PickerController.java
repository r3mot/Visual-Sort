package visualsort;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import visualsort.Utility.ComboValues;
import visualsort.Utility.RandomArray;

public class PickerController implements Initializable {

    @FXML private ComboBox<Integer> maxCombo;
    @FXML private ComboBox<Integer> minCombo;
    @FXML private ComboBox<String> algoCombo;
    @FXML private ComboBox<String> algoCombo2;
    private ObservableList<Integer> minOptions;
    private ObservableList<Integer> maxOptions;
    private ObservableList<String> algoOptions;
    @FXML private Button homeButton;
    @FXML private Button genCustomButton;
    @FXML private Button genRandButton;
    @FXML private TextField e1;
    @FXML private TextField e10;
    @FXML private TextField e2;
    @FXML private TextField e3;
    @FXML private TextField e4;
    @FXML private TextField e5;
    @FXML private TextField e6;
    @FXML private TextField e7;
    @FXML private TextField e8;
    @FXML private TextField e9;
    @FXML private SplitPane split;
    @FXML private Label arrayLabel;
    private TextField[] tfArray;
    public static String sortType;

    private boolean arrayCreated = false;
    private static ArrayList<Integer> arrayToSend;
    private int minValue;
    private int maxValue;

    @FXML void switchToHome(ActionEvent event) throws IOException{
        App.setRoot("Home");
    }

    /* Random Array Minimum Value */
    @FXML void minSelected(ActionEvent event) {
        this.minValue = minCombo.getValue();
        initMaxCombo();
    }

    /* Random Array Maximum Value */
    @FXML void maxSelected(ActionEvent event) {
        this.maxValue = maxCombo.getValue();
    }

    /* User Has Selected A Sorting Algorithm */
    @FXML void algoSelected(ActionEvent event){
        genRandButton.setDisable(false);
        sortType = algoCombo.getValue();
    }

    @FXML void algoSelected2(ActionEvent event){
        genCustomButton.setDisable(false);
        sortType = algoCombo2.getValue();
    }


    /* User Selected Custom Array */
    @FXML void genCustomClicked(ActionEvent event) throws IOException {
        if(tfEmpty()){
            arrayLabel.setText("Make sure all values are entered!");
            arrayLabel.setTextFill(Color.RED);
            return;
        }
        arrayLabel.setText("Array Values");
        arrayLabel.setTextFill(Color.WHITE);
        createCustom();
        if(arrayCreated)
            App.setRoot("Sorter");

    }

    /* User Selected Random Array */
    @FXML void genRandClicked(ActionEvent event) throws IOException {

        createRandom(minValue, maxValue);
        if(arrayCreated)
            App.setRoot("Sorter");

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        arrayToSend = new ArrayList<>();
        setDividerHeight();
        initMinCombo();
        initAlgoCombo();
        fill_tf_array();
    }



    /* Creates User Defined Array */
    private void createCustom(){

        for(int i = 0; i < 10; i++){
            arrayToSend.add(i, Integer.parseInt(tfArray[i].getText())); 
            System.out.println("EL: " + tfArray[i].getText());
        }
        arrayCreated = true;

    }

    /* Creates Randomly Generated Array */
    private void createRandom(int min, int max){

        RandomArray random = new RandomArray(min, max);
        arrayToSend = random.getArray();
        arrayCreated = true;

    }

    /* Populates Combo Box Values */
    private void initMinCombo() {

        ComboValues values = new ComboValues();
        minOptions = FXCollections.observableArrayList();

        for (int el: values.getMinValues()) 
            minOptions.add(el);
        
        minCombo.setItems(minOptions);

    }

    /* Populates Combo Box Values */
    private void initMaxCombo() {

        ComboValues values = new ComboValues();
        maxOptions = FXCollections.observableArrayList();

        for (int el: values.getMaxValues(minValue)) 
            maxOptions.add(el);

        maxCombo.setItems(maxOptions);
    }

    /* Populates Combo Box Values */
    private void initAlgoCombo(){

        algoOptions = FXCollections.observableArrayList();
        String bubble = "Bubble Sort";
        String merge = "Merge Sort";

        algoOptions.add(bubble);
        algoOptions.add(merge);

        algoCombo.setItems(algoOptions);
        algoCombo2.setItems(algoOptions);
    }

    /* Fills Array of Text Fields */
    private void fill_tf_array(){

        tfArray = new TextField[10];
        tfArray[0] = this.e1;
        tfArray[1] = this.e2;
        tfArray[2] = this.e3;
        tfArray[3] = this.e4;
        tfArray[4] = this.e5;
        tfArray[5] = this.e6;
        tfArray[6] = this.e7;
        tfArray[7] = this.e8;
        tfArray[8] = this.e9;
        tfArray[9] = this.e10;
        
    }

    /* Checking if Text Field Array is Empty */
    private boolean tfEmpty(){

        for(int i = 0; i < 10; i++){
            if(tfArray[i].getText().isEmpty()){
                return true;
            }
        }

        return false;
    }


    /* Public Modifiers */
    public void setDividerHeight(){
        split.setDividerPosition(0,HomeController.dividerPosition);
    }

    public ArrayList<Integer> getArray(){
        return arrayToSend;
    }

    public String getSortType(){
        return sortType;
    }
}