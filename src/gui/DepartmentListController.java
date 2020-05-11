
package gui;

import Application.Main;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable{
    
    private DepartmentService service;
            
    @FXML
    private TableView<Department> tableViewDepartment;
    
    @FXML
    private TableColumn<Department, Integer> tableCollumnId;
    
    @FXML
    private TableColumn<Department, String> tableCollumnName;
    
    @FXML
    private ObservableList<Department> obsList;
    
    @FXML
    private Button btNew;
    
    public void setDepartmentService(DepartmentService service){
        this.service = service;
    }
    
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
    
    public void updateTableView(){
        if (service == null){
            throw new IllegalAccessError("Service Was null!");
        }
        
        List<Department> list = service.findAll();
        obsList = FXCollections.observableArrayList(list);
        tableViewDepartment.setItems(obsList);
    }
    
}
