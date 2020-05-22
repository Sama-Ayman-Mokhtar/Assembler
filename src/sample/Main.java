package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

public class Main extends Application {
     BorderPane bp;
     GridPane middleGP = new GridPane();
     ScrollPane sp = getSp();
     HBox topHBox;
     VBox bottomVBox;
     int dynamic = 0;
     VBox leftVBox;
     static Boolean start = false;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            bp = new BorderPane();
        HBox topi = new HBox();
         Label inst = new Label("Please, Delete The Assembly Instructions Below, Paste Yours, and  click Continue");
        inst.setStyle("-fx-font-size: 16pt;");
        topi.getChildren().addAll(inst);
        topi.setSpacing(20);
        topi.setAlignment(Pos.CENTER);
        topi.setPadding(new Insets(20,20,20,20));
         bp.setTop(topi);
         VBox bv = new VBox();
        Button cont = new Button("Continue");
        cont.setStyle("-fx-font-size: 16pt");
        bv.getChildren().add(cont);
        bv.setAlignment(Pos.CENTER);
        bv.setPadding(new Insets(20,20,20,20));
        cont.setOnAction(e -> nextAction());
        bp.setBottom(bv);
         TextArea ta = new TextArea();
         ta.setText("sub $s1, $s2, $s5 \nsra $t0, $t1, 3 \nori $s6, $at, 15 \nbne $s0, $s1, Go \nj Exit \nlui $t0, 1 \nGo: sw $s5, 3($s5)\nExit: ");
         bp.setCenter(ta);
         cont.setOnAction(e-> {
             FileWriter.writeFile(ta.getText());
             Mapping.setResiterMap();
            Mapping.setJandIOperationMap();
            Mapping.setRFunctionMap();
            FileReader.openFile();
            FileReader.readFile();
            FileReader.closeFile();
            Controller.start();
            middleGP.setVgap(10);
            middleGP.setPadding(new Insets(20,20,20,20));
            bp.setTop(getTopHBox(0));
            bp.setCenter(sp);
            bp.setBottom(getBottomVBox("Next Instruction"));
         });
        Scene scene = new Scene(bp, 900, 600);
        primaryStage.setTitle("Assembler");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
     VBox getBottomVBox(String s){
        bottomVBox = new VBox();
        Button nextInstruction = new Button(s);
        nextInstruction.setStyle("-fx-font-size: 16pt");
        bottomVBox.getChildren().add(nextInstruction);
        bottomVBox.setAlignment(Pos.CENTER);
        bottomVBox.setPadding(new Insets(20,20,20,20));
        nextInstruction.setOnAction(e -> nextAction());
        return bottomVBox;
    }
    void nextAction(){
        addRowMiddleGP(dynamic);
        bp.setCenter(sp);
        bp.setTop(getTopHBox(dynamic + 1));
        if(dynamic < Controller.instruction.size())
            dynamic ++;
    }
    ScrollPane getSp(){
        ScrollPane sp = new ScrollPane();
        addRowMiddleGP(-1);
        sp.setContent(middleGP);
        sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        sp.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        //sp.setFitToWidth(true);
        sp.setPannable(true);
        return  sp;
    }
    HBox getTopHBox( int line){
        topHBox = new HBox();
        Label inst;
        if(line == 0){
             inst = new Label("Click Next Instruction To Start");
        }
        else if(line >= Controller.instruction.size()){
            inst = new Label("End of Program");
        }
        else{
             inst = new Label("Line #" + line);
        }
        inst.setStyle("-fx-font-size: 16pt;");
        topHBox.getChildren().addAll(inst);
        topHBox.setSpacing(20);
        topHBox.setAlignment(Pos.CENTER);
        topHBox.setPadding(new Insets(20,20,20,20));
        return topHBox;
    }
    void addRowMiddleGP(int instNum){
        if(instNum == -1){
            Label f = new Label("Instruction                            ");
             f.setStyle("-fx-font-weight: bold;");
             middleGP.add(f,0,0);
             Label l1 = new Label("bit [31 -> 26]        ");
             l1.setStyle("-fx-font-weight: bold;");
             middleGP.add(l1,1,0);
             Label l2 = new Label("bit [25 -> 22]        ");
             l2.setStyle("-fx-font-weight: bold;");
             middleGP.add(l2,2,0);
             Label l3 = new Label("bit [21 -> 16]        ");
             l3.setStyle("-fx-font-weight: bold;");
             middleGP.add(l3,3,0);
             Label l4 = new Label("bit [15 -> 11]        ");
             l4.setStyle("-fx-font-weight: bold;");
             middleGP.add(l4,4,0);
             Label l5 = new Label("bit [10 -> 6]         ");
             l5.setStyle("-fx-font-weight: bold;");
             middleGP.add(l5,5,0);
             Label l6 = new Label("bit [5 -> 0]");
             l6.setStyle("-fx-font-weight: bold;");
             middleGP.add(l6,6,0);
        }
        else if(instNum >= Controller.instruction.size()){
        }
        else {
            Label f = new Label(Controller.instruction.get(instNum));
            f.setStyle("-fx-font-weight: bold;");
            middleGP.add(f, 0, instNum + 1);
            if(instNum < MachineCode.machineCode.size()){
                Label l1 = new Label(MachineCode.machineCode.get(instNum).substring(0,6));
                //l1.setStyle("-fx-font-weight: bold;");
                middleGP.add(l1, 1, instNum + 1);
                Label l2 = new Label(MachineCode.machineCode.get(instNum).substring(6,11));
                //l2.setStyle("-fx-font-weight: bold;");
                middleGP.add(l2, 2, instNum + 1);
                Label l3 = new Label(MachineCode.machineCode.get(instNum).substring(11,16));
                //l3.setStyle("-fx-font-weight: bold;");
                middleGP.add(l3, 3, instNum + 1);
                Label l4 = new Label(MachineCode.machineCode.get(instNum).substring(16,21));
                //l4.setStyle("-fx-font-weight: bold;");
                middleGP.add(l4, 4, instNum + 1);
                Label l5 = new Label(MachineCode.machineCode.get(instNum).substring(21,26));
                //l5.setStyle("-fx-font-weight: bold;");
                middleGP.add(l5, 5, instNum + 1);
                Label l6 = new Label(MachineCode.machineCode.get(instNum).substring(26,32));
                //l6.setStyle("-fx-font-weight: bold;");
                middleGP.add(l6, 6, instNum + 1);
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
