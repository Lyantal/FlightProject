/*
 * Automated reservation system for flights which assigns seats on each
 * flight of which there are
 */
package flighttickets;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.scene.control.Hyperlink;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.text.FontWeight;
import javafx.stage.WindowEvent;
import java.io.*;
import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.stage.Window;
import javafx.scene.control.Alert;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.scene.control.TextArea;
import javafx.beans.binding.Bindings;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Alejandro Flores
 */
public class FlightTickets extends Application {
     Stage mainStage;
    TreeView<String> tree;
            
    
    
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
    
        
        
        
        
        stage.setTitle("COLLOSUS AIRLINES");

        Button button1 = new Button("MAKE RESERVATION");
        button1.setOnAction(new EventHandler<ActionEvent>() {
                        @Override 
                        public void handle(ActionEvent t){
                            
                            
                            ButtonType Smoke = new ButtonType("Smoking", ButtonBar.ButtonData.YES);
                            ButtonType NotSmoke = new ButtonType("Non-Smoking", ButtonBar.ButtonData.NO);
                            Alert alert = new Alert(AlertType.NONE,
        "DO YOU WANT TO RESERVE IN THE SMOKING SECTION?",
        Smoke,
        NotSmoke);
                            alert.setTitle("MAKE RESERVATION");
                            alert.setHeaderText("");
                            

                                Optional<ButtonType> result = alert.showAndWait();
                                if (result.isPresent() && result.get() == Smoke){
                                    //Go to smoking section options.
                                Stage stage2 = new Stage();
                                
                                stage2.setTitle("CHOOSE FLIGHT NUMBER (SMOKING)");
                                Button flight1 = new Button("FLIGHT 100");
                                flight1.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent t){
                                stage.setTitle("Enter Customer Info");

        

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(600, 600);
        grid.setVgap(5);
        grid.setHgap(5);

        Text name = new Text("Name:");
        grid.add(name, 0, 0);
        TextField text = new TextField();
        text.setPrefColumnCount(10);
        grid.add(text, 1, 0);
        name.getText();
        
        Text address = new Text("Street Address:");
        grid.add(address, 0, 1);  
        TextField text2 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text2, 1, 1);
        address.getText();
        
        Text city = new Text("City:");
        grid.add(city, 0, 2);
        TextField text3 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text3, 1, 2);
        city.getText();
        
        Text zip = new Text("ZIP Code:");
        grid.add(zip, 0, 3);
        TextField text4 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text4, 1, 3);
        zip.getText();
        
        Text seat = new Text("Seat Number (1-5):");
        grid.add(seat, 0, 4);
        TextField text5 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text5, 1, 4);
        seat.getText();
        
        Button submit = new Button("Submit");
GridPane.setConstraints(submit, 1, 5);
grid.getChildren().add(submit);

Button clear = new Button("Clear");
GridPane.setConstraints(clear, 2, 5);
grid.getChildren().add(clear);

TextArea textArea = new TextArea();

final Label label = new Label();
GridPane.setConstraints(label, 0, 7);
GridPane.setColumnSpan(label, 7);
grid.getChildren().add(label);



submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
        if ( (text.getText() == null || text.getText().trim().isEmpty()) || (text2.getText() == null || text2.getText().trim().isEmpty())  ||                
                (text3.getText() == null || text3.getText().trim().isEmpty()) ||(text4.getText() == null || text4.getText().trim().isEmpty()) ||
                 (text5.getText() == null || text5.getText().trim().isEmpty()) ) {
            label.setText("ALL FIELDS ARE REQUIRED");
            
        } else {
            
           FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
             
            //Show save file dialog
            
                Label fullstring = new Label();
                
                fullstring.textProperty().bind(Bindings.concat(text.textProperty(), " ", text2.textProperty(), " ", 
                        text3.textProperty(), " ", 
                        text4.textProperty(), " ", text5.textProperty(), " 100"));
                
                
                
                 
                String fileName = "test.txt";
                try{
                FileWriter fileWriter = new FileWriter(fileName);
                
                
                
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                
                bufferedWriter.write(fullstring.getText());
                
                bufferedWriter.close();
                }
                catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            
        }
                
                
            
            label.setText("Saved");
            
        }
     }
 });
 



clear.setOnAction(new EventHandler<ActionEvent>() {

@Override
    public void handle(ActionEvent e) {
        text.clear();
        text2.clear();
        text3.clear();
        text4.clear();
        text5.clear();
        label.setText(null);
        
        
    }
});




        Scene scene = new Scene(grid, 450, 250);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              
          }
      });  
        

                                }    
                                }); 
                                
                                Button flight2 = new Button("FLIGHT 200");
                                flight2.setOnAction(new EventHandler<ActionEvent>() {
                                @Override 
                                public void handle(ActionEvent t){
                                
                                    
                                    GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Text name = new Text("Name:");
        grid.add(name, 0, 0);
        TextField text = new TextField();
        text.setPrefColumnCount(10);
        grid.add(text, 1, 0);
        
        Text address = new Text("Street Address:");
        grid.add(address, 0, 1);  
        TextField text2 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text2, 1, 1);
        
        
        Text city = new Text("City:");
        grid.add(city, 0, 2);
        TextField text3 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text3, 1, 2);
        
        Text zip = new Text("ZIP Code:");
        grid.add(zip, 0, 3);
        TextField text4 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text4, 1, 3);
        
        Text seat = new Text("Seat Number (1-5):");
        grid.add(seat, 0, 4);
        TextField text5 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text5, 1, 4);
        
        Button submit = new Button("Submit");
GridPane.setConstraints(submit, 1, 5);
grid.getChildren().add(submit);
//Defining the Clear button
Button clear = new Button("Clear");
GridPane.setConstraints(clear, 2, 5);
grid.getChildren().add(clear);

        final Label label = new Label();
GridPane.setConstraints(label, 0, 7);
GridPane.setColumnSpan(label, 7);
grid.getChildren().add(label);



submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
        if ( (text.getText() == null || text.getText().trim().isEmpty()) || (text2.getText() == null || text2.getText().trim().isEmpty())  ||                
                (text3.getText() == null || text3.getText().trim().isEmpty()) ||(text4.getText() == null || text4.getText().trim().isEmpty()) ||
                 (text5.getText() == null || text5.getText().trim().isEmpty()) ) {
            label.setText("ALL FIELDS ARE REQUIRED");
            
        } else {
            
            FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
             
            //Show save file dialog
            
                
                
                Label fullstring = new Label();
                
                fullstring.textProperty().bind(Bindings.concat(text.textProperty(), " ", text2.textProperty(), " ", 
                        text3.textProperty(), " ", 
                        text4.textProperty(), " ", text5.textProperty(), " 200"));
                
                
                
                String fileName = "test.txt";
                try{
                FileWriter fileWriter = new FileWriter(fileName);
                
                
                
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                
                bufferedWriter.write(fullstring.getText());
                
                bufferedWriter.close();
                }
                catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            
            
        }
                
            
            label.setText("Saved");
            }
            
        }
     
 });
 

clear.setOnAction(new EventHandler<ActionEvent>() {

@Override
    public void handle(ActionEvent e) {
        text.clear();
        text2.clear();
        text3.clear();
        text4.clear();
        text5.clear();
        label.setText(null);
        
        
    }
});




        Scene scene = new Scene(grid, 450, 250);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              
          }
      });  
                                    
                                }
                                }); 
                                
                                Button flight3 = new Button("FLIGHT 300");
                                flight3.setOnAction(new EventHandler<ActionEvent>() {
                                @Override 
                                public void handle(ActionEvent t){
                                
                                    
                                    GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Text name = new Text("Name:");
        grid.add(name, 0, 0);
        TextField text = new TextField();
        text.setPrefColumnCount(10);
        grid.add(text, 1, 0);
        
        Text address = new Text("Street Address:");
        grid.add(address, 0, 1);  
        TextField text2 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text2, 1, 1);
        
        
        Text city = new Text("City:");
        grid.add(city, 0, 2);
        TextField text3 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text3, 1, 2);
        
        Text zip = new Text("ZIP Code:");
        grid.add(zip, 0, 3);
        TextField text4 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text4, 1, 3);
        
        Text seat = new Text("Seat Number (1-5):");
        grid.add(seat, 0, 4);
        TextField text5 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text5, 1, 4);
        
        Button submit = new Button("Submit");
GridPane.setConstraints(submit, 1, 5);
grid.getChildren().add(submit);
//Defining the Clear button
Button clear = new Button("Clear");
GridPane.setConstraints(clear, 2, 5);
grid.getChildren().add(clear);

        final Label label = new Label();
GridPane.setConstraints(label, 0, 7);
GridPane.setColumnSpan(label, 7);
grid.getChildren().add(label);



submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
        if ( (text.getText() == null || text.getText().trim().isEmpty()) || (text2.getText() == null || text2.getText().trim().isEmpty())  ||                
                (text3.getText() == null || text3.getText().trim().isEmpty()) ||(text4.getText() == null || text4.getText().trim().isEmpty()) ||
                 (text5.getText() == null || text5.getText().trim().isEmpty()) ) {
            label.setText("ALL FIELDS ARE REQUIRED");
            
        } else {
            FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
             
            //Show save file dialog
            
                Label fullstring = new Label();
                
                fullstring.textProperty().bind(Bindings.concat(text.textProperty(), " ", text2.textProperty(), " ", 
                        text3.textProperty(), " ", 
                        text4.textProperty(), " ", text5.textProperty(), " 300"));
                
                String fileName = "test.txt";
                try{
                FileWriter fileWriter = new FileWriter(fileName);
                
                
                
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                
                bufferedWriter.write(fullstring.getText());
                
                bufferedWriter.close();
                }
                catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            
        }
                
            
            label.setText("Saved");
            }
        }
     
 });
 

clear.setOnAction(new EventHandler<ActionEvent>() {

@Override
    public void handle(ActionEvent e) {
        text.clear();
        text2.clear();
        text3.clear();
        text4.clear();
        text5.clear();
        label.setText(null);
    }
});




        Scene scene = new Scene(grid, 450, 250);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              
          }
      });  
                                    
                                }
                                }); 
                                
                                Button flight4 = new Button("FLIGHT 400");
                                flight4.setOnAction(new EventHandler<ActionEvent>() {
                                @Override 
                                public void handle(ActionEvent t){
                                
                                    
                                    GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Text name = new Text("Name:");
        grid.add(name, 0, 0);
        TextField text = new TextField();
        text.setPrefColumnCount(10);
        grid.add(text, 1, 0);
        
        Text address = new Text("Street Address:");
        grid.add(address, 0, 1);  
        TextField text2 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text2, 1, 1);
        
        
        Text city = new Text("City:");
        grid.add(city, 0, 2);
        TextField text3 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text3, 1, 2);
        
        Text zip = new Text("ZIP Code:");
        grid.add(zip, 0, 3);
        TextField text4 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text4, 1, 3);
        
        Text seat = new Text("Seat Number (1-5):");
        grid.add(seat, 0, 4);
        TextField text5 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text5, 1, 4);
        
        Button submit = new Button("Submit");
GridPane.setConstraints(submit, 1, 5);
grid.getChildren().add(submit);
//Defining the Clear button
Button clear = new Button("Clear");
GridPane.setConstraints(clear, 2, 5);
grid.getChildren().add(clear);

        final Label label = new Label();
GridPane.setConstraints(label, 0, 7);
GridPane.setColumnSpan(label, 7);
grid.getChildren().add(label);



submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
        if ( (text.getText() == null || text.getText().trim().isEmpty()) || (text2.getText() == null || text2.getText().trim().isEmpty())  ||                
                (text3.getText() == null || text3.getText().trim().isEmpty()) ||(text4.getText() == null || text4.getText().trim().isEmpty()) ||
                 (text5.getText() == null || text5.getText().trim().isEmpty()) ) {
            label.setText("ALL FIELDS ARE REQUIRED");
            
        } else {
            FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
             
            //Show save file dialog
            
                Label fullstring = new Label();
                
                fullstring.textProperty().bind(Bindings.concat(text.textProperty(), " ", text2.textProperty(), " ", 
                        text3.textProperty(), " ", 
                        text4.textProperty(), " ", text5.textProperty(), " 400"));
                
                String fileName = "test.txt";
                try{
                FileWriter fileWriter = new FileWriter(fileName);
                
                
                
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                
                bufferedWriter.write(fullstring.getText());
                
                bufferedWriter.close();
                }
                catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            
        }
                
            
            label.setText("Saved");
            }
        }
     
 });
 

clear.setOnAction(new EventHandler<ActionEvent>() {

@Override
    public void handle(ActionEvent e) {
        text.clear();
        text2.clear();
        text3.clear();
        text4.clear();
        text5.clear();
        label.setText(null);
    }
});




        Scene scene = new Scene(grid, 450, 250);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              
          }
      });  
                                    
                                }
                                });
                                
                                Button flight5 = new Button("FLIGHT 500");
                                flight5.setOnAction(new EventHandler<ActionEvent>() {
                                @Override 
                                public void handle(ActionEvent t){
                                
                                    
                                    GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Text name = new Text("Name:");
        grid.add(name, 0, 0);
        TextField text = new TextField();
        text.setPrefColumnCount(10);
        grid.add(text, 1, 0);
        
        Text address = new Text("Street Address:");
        grid.add(address, 0, 1);  
        TextField text2 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text2, 1, 1);
        
        
        Text city = new Text("City:");
        grid.add(city, 0, 2);
        TextField text3 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text3, 1, 2);
        
        Text zip = new Text("ZIP Code:");
        grid.add(zip, 0, 3);
        TextField text4 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text4, 1, 3);
        
        Text seat = new Text("Seat Number (1-5):");
        grid.add(seat, 0, 4);
        TextField text5 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text5, 1, 4);
        
        Button submit = new Button("Submit");
GridPane.setConstraints(submit, 1, 5);
grid.getChildren().add(submit);
//Defining the Clear button
Button clear = new Button("Clear");
GridPane.setConstraints(clear, 2, 5);
grid.getChildren().add(clear);

        final Label label = new Label();
GridPane.setConstraints(label, 0, 7);
GridPane.setColumnSpan(label, 7);
grid.getChildren().add(label);



submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
        if ( (text.getText() == null || text.getText().trim().isEmpty()) || (text2.getText() == null || text2.getText().trim().isEmpty())  ||                
                (text3.getText() == null || text3.getText().trim().isEmpty()) ||(text4.getText() == null || text4.getText().trim().isEmpty()) ||
                 (text5.getText() == null || text5.getText().trim().isEmpty()) ) {
            label.setText("ALL FIELDS ARE REQUIRED");
            
        } else {
            FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
             
            //Show save file dialog
            
                Label fullstring = new Label();
                
                fullstring.textProperty().bind(Bindings.concat(text.textProperty(), " ", text2.textProperty(), " ", 
                        text3.textProperty(), " ", 
                        text4.textProperty(), " ", text5.textProperty(), " 500"));
                
                String fileName = "test.txt";
                try{
                FileWriter fileWriter = new FileWriter(fileName);
                
                
                
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                
                bufferedWriter.write(fullstring.getText());
                
                bufferedWriter.close();
                }
                catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");

           
        }
                
            
            label.setText("Saved");
            }
        }
     
 });
 

clear.setOnAction(new EventHandler<ActionEvent>() {

@Override
    public void handle(ActionEvent e) {
        text.clear();
        text2.clear();
        text3.clear();
        text4.clear();
        text5.clear();
        label.setText(null);
    }
});




        Scene scene = new Scene(grid, 450, 250);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              
          }
      });  
                                    
                                }
                                });
                                
                                    
                                VBox vbox = new VBox(flight1, flight2,
                                flight3, flight4, flight5);

                                Scene scene2 = new Scene(vbox, 400, 200);
                                vbox.setSpacing(10);
                                stage2.setScene(scene2);
                                stage2.show();
                                    
                                    
                                    
                                
                            } else if(result.isPresent() && result.get() == NotSmoke) {
                                    //Go to nonsmoking section options.
                                    
                                    Stage stage2 = new Stage();
                                
                                stage2.setTitle("CHOOSE FLIGHT NUMBER (NON-SMOKING)");
                                Button flight1 = new Button("FLIGHT 100");
                                flight1.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent t){
                                stage.setTitle("Enter Customer Info");

        

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Text name = new Text("Name:");
        grid.add(name, 0, 0);
        TextField text = new TextField();
        text.setPrefColumnCount(10);
        grid.add(text, 1, 0);
        
        Text address = new Text("Street Address:");
        grid.add(address, 0, 1);  
        TextField text2 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text2, 1, 1);
        
        
        Text city = new Text("City:");
        grid.add(city, 0, 2);
        TextField text3 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text3, 1, 2);
        
        Text zip = new Text("ZIP Code:");
        grid.add(zip, 0, 3);
        TextField text4 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text4, 1, 3);
        
        Text seat = new Text("Seat Number (1-5):");
        grid.add(seat, 0, 4);
        TextField text5 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text5, 1, 4);
        
        Button submit = new Button("Submit");
GridPane.setConstraints(submit, 1, 5);
grid.getChildren().add(submit);
//Defining the Clear button
Button clear = new Button("Clear");
GridPane.setConstraints(clear, 2, 5);
grid.getChildren().add(clear);

        final Label label = new Label();
GridPane.setConstraints(label, 0, 7);
GridPane.setColumnSpan(label, 7);
grid.getChildren().add(label);



submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
        if ( (text.getText() == null || text.getText().trim().isEmpty()) || (text2.getText() == null || text2.getText().trim().isEmpty())  ||                
                (text3.getText() == null || text3.getText().trim().isEmpty()) ||(text4.getText() == null || text4.getText().trim().isEmpty()) ||
                 (text5.getText() == null || text5.getText().trim().isEmpty()) ) {
            label.setText("ALL FIELDS ARE REQUIRED");
            
        } else {
            FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
             
            //Show save file dialog
            
                Label fullstring = new Label();
                
                fullstring.textProperty().bind(Bindings.concat(text.textProperty(), " ", text2.textProperty(), " ", 
                        text3.textProperty(), " ", 
                        text4.textProperty(), " ", text5.textProperty(), " 100"));
                
                String fileName = "test.txt";
                try{
                FileWriter fileWriter = new FileWriter(fileName);
                
                
                
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                
                bufferedWriter.write(fullstring.getText());
                
                bufferedWriter.close();
                }
                catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            
        }
                
                
            
            label.setText("Saved");
            }
        }
     
 });
 

clear.setOnAction(new EventHandler<ActionEvent>() {

@Override
    public void handle(ActionEvent e) {
        text.clear();
        text2.clear();
        text3.clear();
        text4.clear();
        text5.clear();
        label.setText(null);
    }
});




        Scene scene = new Scene(grid, 450, 250);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              
          }
      });  
                                    
                                    
                                }
                                }); 
                                
                                Button flight2 = new Button("FLIGHT 200");
                                flight2.setOnAction(new EventHandler<ActionEvent>() {
                                @Override 
                                public void handle(ActionEvent t){
                                
                                    
                                    GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Text name = new Text("Name:");
        grid.add(name, 0, 0);
        TextField text = new TextField();
        text.setPrefColumnCount(10);
        grid.add(text, 1, 0);
        
        Text address = new Text("Street Address:");
        grid.add(address, 0, 1);  
        TextField text2 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text2, 1, 1);
        
        
        Text city = new Text("City:");
        grid.add(city, 0, 2);
        TextField text3 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text3, 1, 2);
        
        Text zip = new Text("ZIP Code:");
        grid.add(zip, 0, 3);
        TextField text4 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text4, 1, 3);
        
        Text seat = new Text("Seat Number (1-5):");
        grid.add(seat, 0, 4);
        TextField text5 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text5, 1, 4);
        
        Button submit = new Button("Submit");
GridPane.setConstraints(submit, 1, 5);
grid.getChildren().add(submit);
//Defining the Clear button
Button clear = new Button("Clear");
GridPane.setConstraints(clear, 2, 5);
grid.getChildren().add(clear);

        final Label label = new Label();
GridPane.setConstraints(label, 0, 7);
GridPane.setColumnSpan(label, 7);
grid.getChildren().add(label);



submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
        if ( (text.getText() == null || text.getText().trim().isEmpty()) || (text2.getText() == null || text2.getText().trim().isEmpty())  ||                
                (text3.getText() == null || text3.getText().trim().isEmpty()) ||(text4.getText() == null || text4.getText().trim().isEmpty()) ||
                 (text5.getText() == null || text5.getText().trim().isEmpty()) ) {
            label.setText("ALL FIELDS ARE REQUIRED");
            
        } else {
            FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
             
            //Show save file dialog
            
                Label fullstring = new Label();
                
                fullstring.textProperty().bind(Bindings.concat(text.textProperty(), " ", text2.textProperty(), " ", 
                        text3.textProperty(), " ", 
                        text4.textProperty(), " ", text5.textProperty(), " 200"));
                
                String fileName = "test.txt";
                try{
                FileWriter fileWriter = new FileWriter(fileName);
                
                
                
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                
                bufferedWriter.write(fullstring.getText());
                
                bufferedWriter.close();
                }
                catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            
        }
                
                
            
            label.setText("Saved");
            }
        }
     
 });
 

clear.setOnAction(new EventHandler<ActionEvent>() {

@Override
    public void handle(ActionEvent e) {
        text.clear();
        text2.clear();
        text3.clear();
        text4.clear();
        text5.clear();
        label.setText(null);
    }
});




        Scene scene = new Scene(grid, 450, 250);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              
          }
      });  
                                    
                                }
                                }); 
                                
                                Button flight3 = new Button("FLIGHT 300");
                                flight3.setOnAction(new EventHandler<ActionEvent>() {
                                @Override 
                                public void handle(ActionEvent t){
                                
                                    
                                    GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Text name = new Text("Name:");
        grid.add(name, 0, 0);
        TextField text = new TextField();
        text.setPrefColumnCount(10);
        grid.add(text, 1, 0);
        
        Text address = new Text("Street Address:");
        grid.add(address, 0, 1);  
        TextField text2 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text2, 1, 1);
        
        
        Text city = new Text("City:");
        grid.add(city, 0, 2);
        TextField text3 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text3, 1, 2);
        
        Text zip = new Text("ZIP Code:");
        grid.add(zip, 0, 3);
        TextField text4 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text4, 1, 3);
        
        Text seat = new Text("Seat Number (1-5):");
        grid.add(seat, 0, 4);
        TextField text5 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text5, 1, 4);
        
        Button submit = new Button("Submit");
GridPane.setConstraints(submit, 1, 5);
grid.getChildren().add(submit);
//Defining the Clear button
Button clear = new Button("Clear");
GridPane.setConstraints(clear, 2, 5);
grid.getChildren().add(clear);

        final Label label = new Label();
GridPane.setConstraints(label, 0, 7);
GridPane.setColumnSpan(label, 7);
grid.getChildren().add(label);



submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
        if ( (text.getText() == null || text.getText().trim().isEmpty()) || (text2.getText() == null || text2.getText().trim().isEmpty())  ||                
                (text3.getText() == null || text3.getText().trim().isEmpty()) ||(text4.getText() == null || text4.getText().trim().isEmpty()) ||
                 (text5.getText() == null || text5.getText().trim().isEmpty()) ) {
            label.setText("ALL FIELDS ARE REQUIRED");
            
        } else {
            FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
             
            //Show save file dialog
            
                Label fullstring = new Label();
                
                fullstring.textProperty().bind(Bindings.concat(text.textProperty(), " ", text2.textProperty(), " ", 
                        text3.textProperty(), " ", 
                        text4.textProperty(), " ", text5.textProperty(), " 300"));
                
               String fileName = "test.txt";
                try{
                FileWriter fileWriter = new FileWriter(fileName);
                
                
                
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                
                bufferedWriter.write(fullstring.getText());
                
                bufferedWriter.close();
                }
                catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            
            
        }
                
                
            
            label.setText("Saved");
            }
        }
     
 });
 

clear.setOnAction(new EventHandler<ActionEvent>() {

@Override
    public void handle(ActionEvent e) {
        text.clear();
        text2.clear();
        text3.clear();
        text4.clear();
        text5.clear();
        label.setText(null);
    }
});




        Scene scene = new Scene(grid, 450, 250);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              
          }
      });  
                                    
                                }
                                }); 
                                
                                Button flight4 = new Button("FLIGHT 400");
                                flight4.setOnAction(new EventHandler<ActionEvent>() {
                                @Override 
                                public void handle(ActionEvent t){
                                
                                    
                                    GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Text name = new Text("Name:");
        grid.add(name, 0, 0);
        TextField text = new TextField();
        text.setPrefColumnCount(10);
        grid.add(text, 1, 0);
        
        Text address = new Text("Street Address:");
        grid.add(address, 0, 1);  
        TextField text2 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text2, 1, 1);
        
        
        Text city = new Text("City:");
        grid.add(city, 0, 2);
        TextField text3 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text3, 1, 2);
        
        Text zip = new Text("ZIP Code:");
        grid.add(zip, 0, 3);
        TextField text4 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text4, 1, 3);
        
        Text seat = new Text("Seat Number (1-5):");
        grid.add(seat, 0, 4);
        TextField text5 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text5, 1, 4);
        
        Button submit = new Button("Submit");
GridPane.setConstraints(submit, 1, 5);
grid.getChildren().add(submit);
//Defining the Clear button
Button clear = new Button("Clear");
GridPane.setConstraints(clear, 2, 5);
grid.getChildren().add(clear);

        final Label label = new Label();
GridPane.setConstraints(label, 0, 7);
GridPane.setColumnSpan(label, 7);
grid.getChildren().add(label);



submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
        if ( (text.getText() == null || text.getText().trim().isEmpty()) || (text2.getText() == null || text2.getText().trim().isEmpty())  ||                
                (text3.getText() == null || text3.getText().trim().isEmpty()) ||(text4.getText() == null || text4.getText().trim().isEmpty()) ||
                 (text5.getText() == null || text5.getText().trim().isEmpty()) ) {
            label.setText("ALL FIELDS ARE REQUIRED");
            
        } else {
            FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
             
            //Show save file dialog
            
                Label fullstring = new Label();
                
                fullstring.textProperty().bind(Bindings.concat(text.textProperty(), " ", text2.textProperty(), " ", 
                        text3.textProperty(), " ", 
                        text4.textProperty(), " ", text5.textProperty(), " 400"));
                
                String fileName = "test.txt";
                try{
                FileWriter fileWriter = new FileWriter(fileName);
                
                
                
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                
                bufferedWriter.write(fullstring.getText());
                
                bufferedWriter.close();
                }
                catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            
        }
                
            
            label.setText("Saved");
            }
        }
     
 });
 

clear.setOnAction(new EventHandler<ActionEvent>() {

@Override
    public void handle(ActionEvent e) {
        text.clear();
        text2.clear();
        text3.clear();
        text4.clear();
        text5.clear();
        label.setText(null);
    }
});




        Scene scene = new Scene(grid, 450, 250);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              
          }
      });  
                                    
                                }
                                });
                                
                                Button flight5 = new Button("FLIGHT 500");
                                flight5.setOnAction(new EventHandler<ActionEvent>() {
                                @Override 
                                public void handle(ActionEvent t){
                                
                                    
                                    GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Text name = new Text("Name:");
        grid.add(name, 0, 0);
        TextField text = new TextField();
        text.setPrefColumnCount(10);
        grid.add(text, 1, 0);
        
        Text address = new Text("Street Address:");
        grid.add(address, 0, 1);  
        TextField text2 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text2, 1, 1);
        
        
        Text city = new Text("City:");
        grid.add(city, 0, 2);
        TextField text3 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text3, 1, 2);
        
        Text zip = new Text("ZIP Code:");
        grid.add(zip, 0, 3);
        TextField text4 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text4, 1, 3);
        
        Text seat = new Text("Seat Number (1-5):");
        grid.add(seat, 0, 4);
        TextField text5 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text5, 1, 4);
        
        Button submit = new Button("Submit");
GridPane.setConstraints(submit, 1, 5);
grid.getChildren().add(submit);
//Defining the Clear button
Button clear = new Button("Clear");
GridPane.setConstraints(clear, 2, 5);
grid.getChildren().add(clear);

        final Label label = new Label();
GridPane.setConstraints(label, 0, 7);
GridPane.setColumnSpan(label, 7);
grid.getChildren().add(label);



submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
        if ( (text.getText() == null || text.getText().trim().isEmpty()) || (text2.getText() == null || text2.getText().trim().isEmpty())  ||                
                (text3.getText() == null || text3.getText().trim().isEmpty()) ||(text4.getText() == null || text4.getText().trim().isEmpty()) ||
                 (text5.getText() == null || text5.getText().trim().isEmpty())) {
            label.setText("ALL FIELDS ARE REQUIRED");
            
        } else {
            FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
             
            //Show save file dialog
            
                Label fullstring = new Label();
                
                fullstring.textProperty().bind(Bindings.concat(text.textProperty(), " ", text2.textProperty(), " ", 
                        text3.textProperty(), " ", 
                        text4.textProperty(), " ", text5.textProperty(), " 500"));
                
                String fileName = "test.txt";
                try{
                FileWriter fileWriter = new FileWriter(fileName);
                
                
                
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                
                bufferedWriter.write(fullstring.getText());
                
                bufferedWriter.close();
                }
                catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            
        } 
                
                
                
            
            label.setText("Saved");
            }
        }
     
 });
 

clear.setOnAction(new EventHandler<ActionEvent>() {

@Override
    public void handle(ActionEvent e) {
        text.clear();
        text2.clear();
        text3.clear();
        text4.clear();
        text5.clear();
        label.setText(null);
    }
});




        Scene scene = new Scene(grid, 450, 250);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              
          }
      });  
                                    
                                }
                                });
                                
                                    
                                VBox vbox = new VBox(flight1, flight2,
                                flight3, flight4, flight5);

                                Scene scene2 = new Scene(vbox, 400, 200);
                                vbox.setSpacing(10);
                                stage2.setScene(scene2);
                                stage2.show();
                                stage2.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              
          }    
          });                            
                                    
                                
                                
                                
                                
                            }
                            else{
                                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              
          }
      });  
                                
                                
                                
                                
                            }
                                
                             }
                        
                        
                        
                        
                    });   
        
        
        
        Button button2 = new Button("CANCEL A RESERVATION");
        button2.setOnAction(new EventHandler<ActionEvent>() {
                        @Override 
                        public void handle(ActionEvent t){
                        stage.setTitle("ENTER YOUR NAME AND FLIGHT NUMBER");
                        GridPane grid = new GridPane();
                        Label title = new Label("Border Title");
                        
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Text name = new Text("Name:");
        grid.add(name, 0, 0);
        TextField text = new TextField();
        text.setPrefColumnCount(10);
        grid.add(text, 1, 0);
        
        Text address = new Text("Flight Number:");
        grid.add(address, 0, 1);  
        TextField text2 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text2, 1, 1);
        
        Scene scene = new Scene(grid, 400, 200);
        
        final Label label = new Label();
        GridPane.setConstraints(label, 0, 3);
        GridPane.setColumnSpan(label, 3);
        grid.getChildren().add(label);
        
        Button submit = new Button("Submit");
GridPane.setConstraints(submit, 1, 2);
grid.getChildren().add(submit);

submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
        if ( (text.getText() == null || text.getText().trim().isEmpty()) || (text2.getText() == null || text2.getText().trim().isEmpty()) ) {
            label.setText("ALL FIELDS ARE REQUIRED");
            
        } else {
            label.setText("thnx");
        }
     }
 });



//Defining the Clear button
Button clear = new Button("Clear");
GridPane.setConstraints(clear, 2, 2);
grid.getChildren().add(clear);

clear.setOnAction(new EventHandler<ActionEvent>() {

@Override
    public void handle(ActionEvent e) {
        text.clear();
        text2.clear();
        
    }
});
        
        
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              
          }                    
          });                   
                            
                            
                             }
                    });   
        
        Button button3 = new Button("DISPLAY A SEAT ASSIGNMENT");
        button3.setOnAction(new EventHandler<ActionEvent>() {
                        @Override 
                        public void handle(ActionEvent t){
                        stage.setTitle("ENTER TWO OF THESE: NAME, FLIGHT NUMBER OR SEAT NUMBER");
                        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Text name = new Text("Name:");
        grid.add(name, 0, 0);
        TextField text = new TextField();
        text.setPrefColumnCount(10);
        grid.add(text, 1, 0);
        
        Text flight = new Text("Flight Number:");
        grid.add(flight, 0, 1);  
        TextField text2 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text2, 1, 1);
        
        Text seat = new Text("Seat Number:");
        grid.add(seat, 0, 2);  
        TextField text3 = new TextField();
        text3.setPrefColumnCount(10);
        grid.add(text3, 1, 2);
        
        final Label label = new Label();
GridPane.setConstraints(label, 0, 4);
GridPane.setColumnSpan(label, 4);
grid.getChildren().add(label);
        
        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 3);
        grid.getChildren().add(submit);
        
        submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
        if ( (text.getText() == null || text.getText().trim().isEmpty()) && (text2.getText() == null || text2.getText().trim().isEmpty())    ) {
            label.setText("AT LEAST TWO OF THREE FIELDS REQUIRED");
        }
            
            else if( (text2.getText() == null || text2.getText().trim().isEmpty()) && (text3.getText() == null || text3.getText().trim().isEmpty())    ) {
            label.setText("AT LEAST TWO OF THREE FIELDS REQUIRED");
                    }
            else if( (text2.getText() == null || text2.getText().trim().isEmpty()) && (text.getText() == null || text.getText().trim().isEmpty())    ) {
            label.setText("AT LEAST TWO OF THREE FIELDS REQUIRED");
                    }
            else if( (text3.getText() == null || text3.getText().trim().isEmpty()) && (text.getText() == null || text.getText().trim().isEmpty())    ) {
            label.setText("AT LEAST TWO OF THREE FIELDS REQUIRED");
                    }
            
            
         else {
            label.setText("thnx");
        }
     }
 });
        

//Defining the Clear button
Button clear = new Button("Clear");
GridPane.setConstraints(clear, 2, 3);
grid.getChildren().add(clear);  

clear.setOnAction(new EventHandler<ActionEvent>() {

@Override
    public void handle(ActionEvent e) {
        text.clear();
        text2.clear();
        text3.clear();
        
        
    }
});






        
        
        
        Scene scene = new Scene(grid, 550, 200);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
  
          }                    
          });  
                            
                            
                             }
                    });  
        
        Button button4 = new Button("DISPLAY ALL SEAT ASSIGNMENT");
        button4.setOnAction(new EventHandler<ActionEvent>() {
                        @Override 
                        public void handle(ActionEvent t){
                        
                            
                            
                             }
                    });  
        
        Button button5 = new Button("PRINT A BOARDING PASS");
        button5.setOnAction(new EventHandler<ActionEvent>() {
                        @Override 
                        public void handle(ActionEvent t){
                        stage.setTitle("ENTER TWO OF THESE: NAME, FLIGHT NUMBER OR SEAT NUMBER");
                        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Text name = new Text("Name:");
        grid.add(name, 0, 0);
        TextField text = new TextField();
        
        
        text.setPrefColumnCount(10);
        grid.add(text, 1, 0);
        
        Text flight = new Text("Flight Number:");
        grid.add(flight, 0, 1);  
        TextField text2 = new TextField();
        text2.setPrefColumnCount(10);
        grid.add(text2, 1, 1);
        
        
        
        final Label label = new Label();
GridPane.setConstraints(label, 0, 4);
GridPane.setColumnSpan(label, 4);
grid.getChildren().add(label);
        
        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 3);
        grid.getChildren().add(submit);
        
        submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
        if ( (text.getText() == null || text.getText().trim().isEmpty()) && (text2.getText() == null || text2.getText().trim().isEmpty())    ) {
            label.setText("NAME AND FLIGHT NUMBER ARE REQUIRED");
        }
           
            
            
         else {
            
            
            String name = String.valueOf(text.getText());
            String flight = String.valueOf(text2.getText());
            
            
            
            System.out.println(" --------------------------------");
            System.out.println("|COLLOSUS AIRLINES--BOARDING PASS|");
            System.out.printf("%s%s%s\n", name, "\t", flight);
            
            
            System.out.println(" --------------------------------");
        }
     }
 });
               //Defining the Clear button
Button clear = new Button("Clear");
GridPane.setConstraints(clear, 2, 3);
grid.getChildren().add(clear);  

clear.setOnAction(new EventHandler<ActionEvent>() {

@Override
    public void handle(ActionEvent e) {
        text.clear();
        text2.clear();
        
        
        
    }
});             
                           
Scene scene = new Scene(grid, 550, 200);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
  
          }                    
          });  
                            
                            
                             }
                    });  
        
        
        
        Button quit = new Button("QUIT");
                    quit.setOnAction(new EventHandler<ActionEvent>() {
                        @Override 
                        public void handle(ActionEvent t){
                        
                            Alert alert2 = new Alert(Alert.AlertType.NONE);
                            alert2.getDialogPane().getButtonTypes().add(ButtonType.YES);
                            alert2.getDialogPane().getButtonTypes().add(ButtonType.NO);
                            alert2.setTitle("QUIT");
                            alert2.setHeaderText("");
                            alert2.setContentText("ARE YOU SURE?");

                                Optional<ButtonType> result = alert2.showAndWait();
                                if (result.get() == ButtonType.YES){
                                System.exit(0);
                            } else {
                                //Nothing needed here?
                            }
                            
                            
                            
                            
                            
                        }
                    });

        VBox vbox = new VBox(button1, button2, button3, 
                button4, button5, quit);

        Scene scene = new Scene(vbox, 500, 300);
        vbox.setSpacing(10);
        stage.setScene(scene);
        stage.show();
        
        this.mainStage = stage;
        stage.setOnCloseRequest(confirmCloseEventHandler);

        Button closeButton = new Button("Close Application");
        closeButton.setOnAction(event ->
                stage.fireEvent(
                        new WindowEvent(
                                stage,
                                WindowEvent.WINDOW_CLOSE_REQUEST
                        )
                )
        );
        
        
        
        
    }
        
    private EventHandler<WindowEvent> confirmCloseEventHandler = event -> {
        Alert alert3 = new Alert(Alert.AlertType.NONE);
        alert3.getDialogPane().getButtonTypes().add(ButtonType.YES);
        alert3.getDialogPane().getButtonTypes().add(ButtonType.NO);
        alert3.setTitle("QUIT");
        alert3.setHeaderText("");
        alert3.setContentText("ARE YOU SURE?");

                                Optional<ButtonType> result = alert3.showAndWait();
                                if (result.get() == ButtonType.YES){
                                    
                                System.exit(0);
                            } else {
                                event.consume();
                            }
    };

    
    
    
    public static void main(String[] args) {
        launch(args);
    }
    

 

 
 
}


