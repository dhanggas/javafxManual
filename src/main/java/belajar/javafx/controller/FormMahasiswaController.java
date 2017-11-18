/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar.javafx.controller;

import belajar.javafxjdbc.Mahasiswa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dhanggas
 */
public class FormMahasiswaController implements Initializable {

    @FXML
    private TextField txtnim;
    @FXML
    private TextField txtnama;
    @FXML
    private ChoiceBox<String> txtjurusan;
    @FXML
    private TableView<Mahasiswa> tableview;
    @FXML
    private TableColumn<Mahasiswa, String> columnNim;
    @FXML
    private TableColumn<Mahasiswa, String> columnNama;
    @FXML
    private TableColumn<Mahasiswa, String> columnJurusan;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnNim.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nim"));
        columnNama.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nama"));
        columnJurusan.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("jurusan"));
    }

    @FXML
    public void doSave(ActionEvent ae) {
        Mahasiswa m = new Mahasiswa();
        m.setNim(txtnim.getText());
        m.setNama(txtnama.getText());
        m.setJurusan(txtjurusan.getSelectionModel().getSelectedItem());
        tableview.getItems().add(m);
    }

    @FXML
    public void doReset(ActionEvent ae) {
        Platform.exit();
    }

}
