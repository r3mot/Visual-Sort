package visualsort;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import visualsort.Sorting.BubbleSort;
import visualsort.Sorting.MergeSort;


public class MainController implements Initializable{

    private final double TOP = 0;
    private final double MIDDLE = 0.83;

    /* GUI Components */
    @FXML private Button startButton;
    @FXML private Button stepButton;
    @FXML private Button resetButton;
    @FXML private Button randomButton;
    @FXML private Button enterButton;
    @FXML private Button sortAllButton;
    @FXML private Button viewButton;
    @FXML private Button hideButton;
    @FXML private Button homeButton;
    @FXML private Pane menuPane;
    @FXML private Pane vizualizerPane;
    @FXML private RadioButton bubbleRadio;
    @FXML private RadioButton mergeRadio;
    @FXML private SplitPane splitPane;
    @FXML private TextArea textArea;
    @FXML private TextField userInput;
    @FXML private TextField lowInput;
    @FXML private TextField highInput;
    @FXML private Label sortedLabel;
    @FXML private Rectangle r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
    @FXML private Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;

    private Rectangle[] rectangles;
    private Label[] valueLabes;
    private String valueDisplay;
    private String sortType;


     /* Sorting Variables */
     private ArrayList<Integer> arrayToSort;
     private static String[] iterations;
     private static int[][] iterations_int;
     private int globalIndex = 0;
     private boolean sorted = false;



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        PickerController picker = new PickerController();
        arrayToSort = picker.getArray();
        sortType = PickerController.sortType;
        sortedLabel.setText("Press Start!");
        stepButton.setDisable(true);
        setValueLabels();
        setRectangles();

    }

    @FXML void switchToHome(ActionEvent event) throws IOException {

        App.setRoot("Home");

    }

    /* Sorting has begun */
    @FXML void startClicked(ActionEvent event) {

        sortedLabel.setText("");
        startButton.setDisable(true);
        stepButton.setDisable(false);
        startSorting();
        updateRectangles();

    }

    /* Iterate through array */
    @FXML void stepClicked(ActionEvent event) {

        incrementStep();
        updateRectangles();

    }

    /* Reset Fields */
    @FXML void resetClicked(ActionEvent event) throws IOException {

        App.setRoot("Picker");

    }

    /* Hides Text Area that houses iterations in text format */
    @FXML void hideSteps(ActionEvent event){

        splitPane.setDividerPosition(0, MIDDLE);

    }

    @FXML void viewClicked(ActionEvent event){

        splitPane.setDividerPosition(0, TOP);

    }
    
    private void startSorting() {

        displayUnsorted();
        sortArray(sortType);

    }

    /* Appends Unsorted Array to Text Area */
    private void displayUnsorted() {

        textArea.appendText("Sort Type: "  + sortType + "\n");
        String toAppend = "Start: " + arrayToSort.toString() + "\n";
        textArea.appendText(toAppend);

    }

    /* Determines which algorithm to use */
    private void sortArray(String algorithm) {

        BubbleSort bubble = new BubbleSort();
        MergeSort merge = new MergeSort();

        switch (algorithm) {
        case "Merge Sort":
            merge.sort(arrayToSort);
            break;

        case "Bubble Sort":
            bubble.sort(arrayToSort);
            break;
        }
    }

    /* Dynamically changes Rectangle heights */
    private void updateRectangles() {
       
        for (int i = 0; i < 10; i++) {

            int value = iterations_int[globalIndex][i];
            int height = (int) (value  + (value * 0.5));

            if (height >= 230) {
                height = 230;
            }

            if(height < 100){
                height += 2;
            }
         
            rectangles[i].setLayoutY(161);
            rectangles[i].setHeight(height);
            valueLabes[i].setText(String.valueOf(value));
        }

    }

    /* Increment steps */
    private void incrementStep() {

        String sortedString = arrayToSort.toString();
        String current = iterations[globalIndex];

        sorted = sortedString.equals(current) ? true : false;

       if(finished(sorted, current)) {
            stringToDisplay();
            stepButton.setDisable(true);
            return;
       }

        stringToDisplay();
        globalIndex++;
    }

    /* Determine whether array is sorted or not */
    private boolean finished(boolean isSorted, String current){
        
        if (isSorted || current == null) 
        {
            sortedLabel.setText("Array is sorted!");
            return true;
        }
        return false;
    }

    /* Text to display in Text Area */
    private void stringToDisplay(){

        valueDisplay = iterations[globalIndex];
        String toDisplay = (("Pass ") + (globalIndex + 1) + ": " + (valueDisplay));
        textArea.appendText((toDisplay) + "\n");

    }

    private void setRectangles() {

        rectangles = new Rectangle[10];
        rectangles[0] = this.r1;
        rectangles[1] = this.r2;
        rectangles[2] = this.r3;
        rectangles[3] = this.r4;
        rectangles[4] = this.r5;
        rectangles[5] = this.r6;
        rectangles[6] = this.r7;
        rectangles[7] = this.r8;
        rectangles[8] = this.r9;
        rectangles[9] = this.r10;

    }

    private void setValueLabels() {

        valueLabes = new Label[10];
        valueLabes[0] = this.l1;
        valueLabes[1] = this.l2;
        valueLabes[2] = this.l3;
        valueLabes[3] = this.l4;
        valueLabes[4] = this.l5;
        valueLabes[5] = this.l6;
        valueLabes[6] = this.l7;
        valueLabes[7] = this.l8;
        valueLabes[8] = this.l9;
        valueLabes[9] = this.l10;

    }

    /* Public Modifiers */
    public static void setStringIterations(String[] strIterations){
        iterations = strIterations;
    }

    public static void setIntIterations(int[][] intIterations){
        iterations_int = intIterations;
    }

    public void setArrayToSort(ArrayList<Integer> array){
        arrayToSort = array;
    }

}
