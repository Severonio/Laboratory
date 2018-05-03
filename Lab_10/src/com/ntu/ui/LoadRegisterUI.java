package com.ntu.ui;



import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;

import com.ntu.DateUtil;
import com.ntu.dao.LoadDAO;
import com.ntu.dao.LoadDAOImpl;
import com.ntu.dao.LoadRegisterDAO;
import com.ntu.dao.LoadRegisterDAOImpl;
import com.ntu.dao.OwnerListDAO;
import com.ntu.dao.OwnerListDAOImpl;
import com.ntu.domain.Load;
import com.ntu.domain.LoadRegister;
import com.ntu.domain.OwnerList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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

public class LoadRegisterUI extends BorderPane {

    private Label msgLabel = new Label();
    private TextField idField = new TextField();

    private ComboBox<Load> loadComboBox = new ComboBox<Load>();

    private DatePicker broughtDatePicker = new DatePicker();
    private DatePicker takenDatePicker = new DatePicker();


    private ComboBox<OwnerList> ownerComboBox = new ComboBox<OwnerList>();


    private Button createButton = new Button("New...");
    private Button updateButton = new Button("Update...");
    private Button deleteButton = new Button("Delete...");
    private Button refreshButton = new Button("Refresh...");

    private Button loadButton = new Button("Loads...");
    private Button ownerButton = new Button("Owners...");

    private TableView<LoadRegister> loadRegisterTable = new TableView<>();
    private TableColumn<LoadRegister, Long> idColumn = new TableColumn<LoadRegister, Long>("ID");
    private TableColumn<LoadRegister, Load> loadColumn = new TableColumn<LoadRegister, Load>("�����");

    private TableColumn<LoadRegister, Date> broughtDtColumn = new TableColumn<LoadRegister, Date>("���� ������");
    private TableColumn<LoadRegister, OwnerList> ownerColumn = new TableColumn<LoadRegister, OwnerList>("������");



    private TableColumn<LoadRegister, Date> takenDtColumn = new TableColumn<LoadRegister, Date>("���� ����������");
    private ObservableList<LoadRegister> masterData = FXCollections.observableArrayList();


    private LoadRegisterDAO loadRegisterDAO = new LoadRegisterDAOImpl();
    private LoadDAO loadDAO = new LoadDAOImpl();
    private OwnerListDAO ownerListDAO = new OwnerListDAOImpl();

    public LoadRegisterUI() {
        setPadding(new Insets(10, 10, 10, 10));

        setTop(msgLabel);

        setCenter(initFields());
        setBottom(initTable());
        setRight(initButtons());

        initListeners();

        setFieldData(loadRegisterDAO.getFirstLoadRegister());

        setTabledData();

    }



    private Pane initButtons() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(20);
        grid.setVgap(20);

        grid.add(createButton,  0, 0);
        createButton.setOnAction(new ButtonHandler());
        grid.add(updateButton, 1, 0);
        updateButton.setOnAction(new ButtonHandler());
        grid.add(deleteButton, 2, 0);
        deleteButton.setOnAction(new ButtonHandler());
        grid.add(loadButton, 0, 1);
        loadButton.setOnAction(new ButtonHandler());
        grid.add(ownerButton, 1, 1);
        ownerButton.setOnAction(new ButtonHandler());
        grid.add(refreshButton, 2, 1);
        refreshButton.setOnAction(new ButtonHandler());

        return grid;

    }



    private Pane initFields() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(20);
        grid.setVgap(2);

        loadComboBox.getItems().addAll((loadDAO.getAllLoads()));
        loadComboBox.setMaxWidth(350);
        ownerComboBox.getItems().addAll((ownerListDAO.getAllOwnerLists()));
        ownerComboBox.setMaxWidth(350);


        grid.add(new Label("�����"), 1, 0);
        grid.add(loadComboBox, 2, 0);


        grid.add(new Label("���� ������"), 1, 2);
        grid.add(broughtDatePicker, 2, 2);

        grid.add(new Label("�����"), 1, 1);
        grid.add(ownerComboBox, 2, 1);

        grid.add(new Label("���� ����������"), 1, 5);
        grid.add(takenDatePicker, 2, 5);



        return grid;
    }


    private Pane initTable() {
        //StackPane pane = new StackPane();
        VBox pane = new VBox();
        pane.setPadding(new Insets(10, 10, 10, 10));
        loadRegisterTable.setMinHeight(560);
        PropertyValueFactory<LoadRegister, Long> idCellValueFactory = new PropertyValueFactory<>("id");
        idColumn.setCellValueFactory(idCellValueFactory);

        PropertyValueFactory<LoadRegister, Load> loadCellValueFactory = new PropertyValueFactory<>("load");
        loadColumn.setCellValueFactory(loadCellValueFactory);

        PropertyValueFactory<LoadRegister, OwnerList> ownerCellValueFactory = new PropertyValueFactory<>("ownerList");
        ownerColumn.setCellValueFactory(ownerCellValueFactory);

        PropertyValueFactory<LoadRegister, Date> broughtDtCellValueFactory = new PropertyValueFactory<>("broughtDt");
        broughtDtColumn.setCellValueFactory(broughtDtCellValueFactory);

        PropertyValueFactory<LoadRegister, Date> takenDtCellValueFactory = new PropertyValueFactory<>("takenDt");
        takenDtColumn.setCellValueFactory(takenDtCellValueFactory);


        loadRegisterTable.getColumns().addAll(idColumn, broughtDtColumn, takenDtColumn,  loadColumn, ownerColumn);
        pane.getChildren().add(loadRegisterTable);


        return pane;
    }

    private void setTabledData() {
        masterData = loadRegisterDAO.getAllLoadRegisters();
        loadRegisterTable.setItems(masterData);

    }

    private void initListeners() {

        loadRegisterTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                LoadRegister  loadRegister = newSelection;
                setFieldData(loadRegister);
            }
        });


    }

    private LoadRegister getFieldData() {

        LoadRegister loadRegister = new LoadRegister();

        Load load = (Load)loadComboBox.getValue();
        OwnerList ownerList = (OwnerList) ownerComboBox.getValue();

        loadRegister.setId(Integer.parseInt(idField.getText()));

        loadRegister.setLoad(load);

        loadRegister.setOwnerList(ownerList);

        loadRegister.setBroughtDt(DateUtil.convertStringIntoSqlDate(/*broughtDtField.getText()*/ broughtDatePicker.getValue().toString()));

        if (takenDatePicker.getValue() != null) {
            loadRegister.setTakenDt(DateUtil.convertStringIntoSqlDate(/*takenDtField.getText()*/ takenDatePicker.getValue().toString()));
        }


        return loadRegister;
    }


    private void setFieldData(LoadRegister loadRegister) {
        idField.setText(String.valueOf(loadRegister.getId()));
        loadComboBox.setValue(loadRegister.getLoad());
        ownerComboBox.setValue(loadRegister.getOwnerList());

        if (loadRegister.getBroughtDt() != null) {
            broughtDatePicker.setValue(loadRegister.getBroughtDt().toLocalDate());
        }
        else {
            broughtDatePicker.setValue(null);
        }

        if (loadRegister.getTakenDt() != null) {
            takenDatePicker.setValue(loadRegister.getTakenDt().toLocalDate());
        }
        else {
            takenDatePicker.setValue(null);
        }
    }

    private boolean isEmptyFieldData() {

        if (loadComboBox.getValue() == null || ownerComboBox.getValue() == null || broughtDatePicker.getValue() == null ) {
            return true;
        }
        else {
            return false;
        }
    }


    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            LoadRegister loadRegister = getFieldData();
            if (e.getSource().equals(createButton)
                    && createButton.getText().equals("Save")) {
                if (isEmptyFieldData()) {
                    msgLabel.setText("Cannot create an empty record");
                    return;
                }
                if (loadRegisterDAO.insertLoadRegister(loadRegister) ) {
                    msgLabel.setText("New record created successfully.");
                }
                createButton.setText("New...");
                refreshTable();

            } else if (e.getSource().equals(createButton)
                    && createButton.getText().equals("New...")) {
                loadRegister.setLoad(null);
                loadRegister.setOwnerList(null);
                loadRegister.setBroughtDt(null);
                loadRegister.setTakenDt(null);

                setFieldData(loadRegister);
                createButton.setText("Save");


            } else if (e.getSource().equals(updateButton)) {

                if (isEmptyFieldData()) {
                    msgLabel.setText("Cannot update an empty record");
                    return;
                }

                if (loadRegisterDAO.updateLoadRegister(loadRegister))
                    msgLabel.setText("LoadRegister with ID:"
                            + String.valueOf(loadRegister.getId()
                            + " is updated successfully"));

                refreshTable();

            } else if (e.getSource().equals(deleteButton)) {

                if (isEmptyFieldData()) {
                    msgLabel.setText("Cannot delete an empty record");
                    return;
                }
                loadRegister = loadRegisterDAO.getLoadRegisterById(loadRegister.getId());
                loadRegisterDAO.deleteLoadRegister(loadRegister.getId());
                msgLabel.setText("LoadRegister with ID:"
                        + String.valueOf(loadRegister.getId()
                        + " is deleted successfully"));

                refreshTable() ;
            }
            else if (e.getSource().equals(refreshButton)) {
                loadComboBox.getItems().clear();
                loadComboBox.getItems().addAll((loadDAO.getAllLoads()));
                ownerComboBox.getItems().clear();
                ownerComboBox.getItems().addAll((ownerListDAO.getAllOwnerLists()));
                refreshTable() ;

            }
            else if (e.getSource().equals(loadButton)) {

                Modal.display("������ ������", new LoadUI());


            }
            else if (e.getSource().equals(ownerButton)) {

                Modal.display("������ �������", new OwnerListUI());


            }

        }
    }


    private void refreshTable() {

        TableViewFocusModel<LoadRegister> loadModelFocused =  loadRegisterTable.getFocusModel();
        setTabledData();
        loadRegisterTable.setFocusModel(loadModelFocused);

    }

}

