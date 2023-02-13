package lk.ijse.dep10.ds.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import lk.ijse.dep10.ds.util.DynamicArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class MainFormController {

    public TextField txtNumber;
    public Button btnAdd;
    public Button btnPrintAll;
    public Button btnPrint;
    public Button btnRemove;
    public Button btnContains;
    public Button btnSize;
    public Button btnClear;
    private DynamicArray numbers = new DynamicArray();

    public void btnAddOnAction(ActionEvent event) {
        String value = txtNumber.getText();
        numbers.add(value); // numbers.add(0,value) --> 10,20,30 // sout --> 30,20,10
        txtNumber.clear();
        txtNumber.requestFocus();
    }

    public void btnPrintAllOnAction(ActionEvent event) {System.out.println(numbers);
    }

    public void btnClearOnAction(ActionEvent event) {
        numbers.clear();
    }

    public void btnRemoveOnAction(ActionEvent event) {
        TextInputDialog prompt = new TextInputDialog("Enter the Index");
        Optional<String> outInput = prompt.showAndWait();
        if (outInput.isEmpty() || outInput.get().isBlank()) return;

        String input = outInput.get();
        int index = Integer.parseInt(input);

        if (index < 0 || index >= numbers.size()) {
            System.err.println("Invalid Index");
            return;
        }
        numbers.remove(index);
    }

    public void btnPrintOnAction(ActionEvent event) {
        TextInputDialog prompt = new TextInputDialog("Enter the Index");
        Optional<String> outInput = prompt.showAndWait();
        if (outInput.isEmpty() || outInput.get().isBlank()) return;

        int index = Integer.parseInt(outInput.get());
        if(index < 0 || index >= numbers.size()) {
            System.err.println("Invalid Index");
            return;
        }

        System.out.println(numbers.get(index));

    }

    public void btnContainsOnAction(ActionEvent event) {
        TextInputDialog prompt = new TextInputDialog("Enter the Index");
        Optional<String> outInput = prompt.showAndWait();
        if (outInput.isEmpty() || outInput.get().isBlank()) return;

        String input = outInput.get();
        System.out.println(numbers.contains(input));
    }

    public void btnSizeOnAction(ActionEvent event) {
        System.out.println("Size : "+numbers.size());
    }
}
