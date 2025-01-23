package com.example.handballprojekt.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.handballprojekt.DB.DBTeamStatements;
import com.example.handballprojekt.DBO.TeamDBO;

import HelperMethods.HelperMethods.HelperMethods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FrontpageController implements Initializable {

    @FXML
    private Button btn_createTeam;

    @FXML
    private Button btn_deleteTeam;

    @FXML
    private Label welcomeText;

    @FXML
    private TableColumn<TeamDBO, Integer> col_teamID;

    @FXML
    private TableColumn<TeamDBO, String> col_Name;

    @FXML
    private TableColumn<TeamDBO, Integer> col_Score;

    @FXML
    private TableColumn<TeamDBO, Integer> col_Wins;

    @FXML
    private TableColumn<TeamDBO, Integer> col_Loss;

    @FXML
    private TableColumn<TeamDBO, Integer> col_Draw;

    @FXML
    private TableView<TeamDBO> table_Teams;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Fetch the teams from the database
        DBTeamStatements dbCon = new DBTeamStatements();
        List<TeamDBO> teams = dbCon.getAllTeams();

        // Create an ObservableList from the teams
        ObservableList<TeamDBO> teamList = FXCollections.observableArrayList(teams);

        // Bind the data to the TableView
        table_Teams.setItems(teamList);

        // Set cell value factories for each column
        col_teamID.setCellValueFactory(new PropertyValueFactory<>("teamID"));
        col_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_Score.setCellValueFactory(new PropertyValueFactory<>("score"));
        col_Wins.setCellValueFactory(new PropertyValueFactory<>("wins"));
        col_Loss.setCellValueFactory(new PropertyValueFactory<>("losses"));
        col_Draw.setCellValueFactory(new PropertyValueFactory<>("draws"));
    }

    @FXML
    void on_createTeam(ActionEvent event) throws IOException {
        HelperMethods.switchWindow("com/example/handballprojekt/CreateTeamPage.fxml", event);
    }

    @FXML
    void onAction_goToMatchView(ActionEvent event) throws IOException {

        HelperMethods.switchWindow("com/example/handballprojekt/MatchViewPage.fxml", event);
    }

    @FXML
    void on_deleteTeam(ActionEvent event) {
        // Implement delete team functionality here
    }
}
