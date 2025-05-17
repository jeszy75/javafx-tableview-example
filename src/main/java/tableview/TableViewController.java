package tableview;

import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tableview.countries.CountryManager;
import tableview.countries.Country;

import java.io.IOException;

public class TableViewController {

    @FXML
    private TableView<Country> tableView;

    @FXML
    private TableColumn<Country, String> code;

    @FXML
    private TableColumn<Country, String> name;

    @FXML
    private TableColumn<Country, String> capital;

    @FXML
    private TableColumn<Country, Long> population;

    @FXML
    private TableColumn<Country, Integer> numberOfTimezones;

    @FXML
    private void initialize() throws IOException {
        code.setCellValueFactory(new PropertyValueFactory<>("code"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        capital.setCellValueFactory(new PropertyValueFactory<>("capital"));
        population.setCellValueFactory(new PropertyValueFactory<>("population"));
        numberOfTimezones.setCellValueFactory(
                cellData -> new ReadOnlyIntegerWrapper(cellData.getValue().getTimezones().size()).asObject()
        );
        ObservableList<Country> observableList = FXCollections.observableArrayList();
        observableList.addAll(new CountryManager().getAll());
        tableView.setItems(observableList);
    }

}
