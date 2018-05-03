package com.ntu.ui;

import com.ntu.dao.LoadDAO;
import com.ntu.dao.LoadDAOImpl;
import com.ntu.domain.Load;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewFocusModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.scene.layout.VBox;

public class LoadUI extends BorderPane {


    private Label msgLabel = new Label();
    private TextField idField = new TextField();
    private TextField typeField = new TextField();
    private TextField customerField = new TextField();
    private TextField madeField = new TextField();
    private TextField weightField = new TextField();

    private Button createButton = new Button("New...");
    private Button updateButton = new Button("Update...");
    private Button deleteButton = new Button("Delete...");

    private TableView<Load> loadTable = new TableView<>();
    private TableColumn<Load, Long> idColumn = new TableColumn<Load, Long>("ID");
    private TableColumn<Load, String> typeColumn = new TableColumn<Load, String>("�����");
    private TableColumn<Load, String> customerColumn = new TableColumn<Load, String>("�����");
    private TableColumn<Load, Integer> madeColumn = new TableColumn<Load, Integer>("г� �������");
    private TableColumn<Load, Integer> weightColumn = new TableColumn<Load, Integer>("ʳ������ �������");
    private ObservableList<Load> masterData = FXCollections.observableArrayList();


    private LoadDAO loadDAO = new LoadDAOImpl();

    public LoadUI() {
        setPadding(new Insets(10, 10, 10, 10));
        setTop(msgLabel);
        setCenter(initFields());
        setBottom(initTable());
        setRight(initButtons());
        initListeners();

        setFieldData(loadDAO.getFirstLoad());

        setTabledData();
    }

    private Pane initButtons() {
        HBox box = new HBox();
        box.setAlignment(Pos.TOP_CENTER);
        box.setSpacing(5);
        box.getChildren().add(createButton);
        createButton.setOnAction(new ButtonHandler());
        box.getChildren().add(updateButton);
        updateButton.setOnAction(new ButtonHandler());
        box.getChildren().add(deleteButton);
        deleteButton.setOnAction(new ButtonHandler());

        return box;

    }


    private Pane initFields() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(20);
        grid.setVgap(2);

        grid.add(new Label("�����"), 1, 0);
        grid.add(typeField, 2, 0);
        grid.add(new Label("�����"), 1, 1);
        grid.add(customerField, 2, 1);
        grid.add(new Label("г� �������"), 1, 2);
        grid.add(madeField, 2, 2);
        grid.add(new Label("ʳ������ �������"), 1, 3);
        grid.add(weightField, 2, 3);

        return grid;


    }

    private Pane initTable() {
        //StackPane pane = new StackPane();
        VBox pane = new VBox();
        pane.setPadding(new Insets(10, 10, 10, 10));
        loadTable.setMinHeight(490);
        PropertyValueFactory<Load, Long> idCellValueFactory = new PropertyValueFactory<>("id");
        idColumn.setCellValueFactory(idCellValueFactory);

        PropertyValueFactory<Load, String> typeCellValueFactory = new PropertyValueFactory<>("type");
        typeColumn.setCellValueFactory(typeCellValueFactory);

        PropertyValueFactory<Load, String> customerCellValueFactory = new PropertyValueFactory<>("customer");
        customerColumn.setCellValueFactory(customerCellValueFactory);

        PropertyValueFactory<Load, Integer> madeCellValueFactory = new PropertyValueFactory<>("made");
        madeColumn.setCellValueFactory(madeCellValueFactory);

        PropertyValueFactory<Load, Integer> weightCellValueFactory = new PropertyValueFactory<>("weight");
        weightColumn.setCellValueFactory(weightCellValueFactory);

        loadTable.getColumns().addAll(idColumn, typeColumn, customerColumn, madeColumn, weightColumn);
        pane.getChildren().add(loadTable);


        return pane;
    }

    private void setTabledData() {
        masterData = loadDAO.getAllLoads();
        loadTable.setItems(masterData);

    }

    private void initListeners() {

        loadTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Load  load = newSelection;
                setFieldData(load);
            }
        });


    }

    private Load getFieldData() {
        Load load = new Load();
        load.setId(Integer.parseInt(idField.getText()));
        load.setType(typeField.getText());
        load.setCustomer(customerField.getText());
        load.setMade(Integer.parseInt(madeField.getText()));
        load.setWeight(Integer.parseInt(weightField.getText()));

        return load;
    }

    private void setFieldData(Load load) {
        idField.setText(String.valueOf(load.getId()));
        typeField.setText(load.getType());
        customerField.setText(load.getCustomer());
        madeField.setText(String.valueOf(load.getMade()));
        weightField.setText(String.valueOf(load.getWeight()));
    }

    private boolean isEmptyFieldData() {

        if (typeField.getText().isEmpty() || customerField.getText().isEmpty() ) {

            return true;
        }
        else {
            return false;
        }
    }



    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            Load load = getFieldData();
            if (e.getSource().equals(createButton)
                    && createButton.getText().equals("Save")) {
                if (isEmptyFieldData()) {
                    msgLabel.setText("Cannot create an empty record");
                    return;
                }
                if (loadDAO.insertLoad(load) ) {
                    msgLabel.setText("New load created successfully.");
                }
                createButton.setText("New...");
                refreshTable();

            } else if (e.getSource().equals(createButton)
                    && createButton.getText().equals("New...")) {
                load.setType("");
                load.setCustomer("");
                load.setMade(2017);
                load.setWeight(0);

                setFieldData(load);
                createButton.setText("Save");


            } else if (e.getSource().equals(updateButton)) {

                if (isEmptyFieldData()) {
                    msgLabel.setText("Cannot update an empty record");
                    return;
                }

                if (loadDAO.updateLoad(load))
                    msgLabel.setText("load with ID:"
                            + String.valueOf(load.getId()
                            + " is updated successfully"));

                refreshTable();

            } else if (e.getSource().equals(deleteButton)) {

                if (isEmptyFieldData()) {
                    msgLabel.setText("Cannot delete an empty record");
                    return;
                }
                load = loadDAO.getLoadById(load.getId());
                loadDAO.deleteLoad(load.getId());
                msgLabel.setText("Load with ID:"
                        + String.valueOf(load.getId()
                        + " is deleted successfully"));

                refreshTable() ;
            }


        }
    }



    private void refreshTable() {

        TableViewFocusModel<Load> loadModelFocused =  loadTable.getFocusModel();
        setTabledData();
        loadTable.setFocusModel(loadModelFocused);


    }


}
