
package gui;

import Application.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable{
    
    @FXML
    private TableView<Department> tableViewDepartment;
    
    @FXML
    private TableColumn<Department, Integer> tableCollumnId;
    
    @FXML
    private TableColumn<Department, String> tableCollumnName;
    
    @FXML
    private Button btNew;
    
    @FXML
    public void onButtonNew(){
        System.out.println("onButtonNew");
    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNode();
        
    }

    private void initializeNode() {
        tableCollumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableCollumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        Stage stage = (Stage) Main.getMainScene().getWindow();
        tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
    }
    
}
