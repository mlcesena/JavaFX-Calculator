import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FXCalculator extends Application {
    private TextField num1;
    private TextField num2;
    private TextField operator;
    private Button equal;
    private Label result;

    public void start(Stage stage) throws Exception {
        num1 = new TextField();
        num2 = new TextField();
        operator = new TextField();
        equal = new Button("=");
        result = new Label("0");

        operator.setPrefWidth(50);
        result.setPrefWidth(200);
        
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.add(num1, 0, 1);
        pane.add(operator, 1, 1);
        pane.add(num2, 2, 1);
        pane.add(equal, 3, 1);
        pane.add(result, 4, 1);
        Scene scene = new Scene(pane);

        stage.setScene(scene);
        
        //EventHandler eh = new MyEventHandler();
        // EventHandler eh = new EventHandler<ActionEvent>() {
        //     public void handle(ActionEvent e) {
        //         calculate();
        //     }
        // };
        
        //equal.setOnAction(eh);
        
        equal.setOnAction(e -> calculate());
            
        // Stage properties
        stage.setTitle("JavaFX Calculator");
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(); // optional
    }

    public void calculate() {
        double n1 = Double.parseDouble(num1.getText());
        String op = operator.getText();
        double n2 = Double.parseDouble(num2.getText());

        if (op.equals("+"))
            result.setText(n1 + n2 + "");
        else if (op.equals("-"))
            result.setText(n1 - n2 + "");
        else if (op.equals("*"))
            result.setText(n1 * n2 + "");
        else if (op.equals("/"))
            result.setText(n1 / n2 + "");
    }

    class MyEventHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent e) {  
            calculate(); 
        }
    }
}

// javac --module-path ../javafx-sdk-15.0.1/lib --add-modules javafx.controls,javafx.fxml FXCalculator.java && java --module-path ../javafx-sdk-15.0.1/lib --add-modules javafx.controls,javafx.fxml FXCalculator
