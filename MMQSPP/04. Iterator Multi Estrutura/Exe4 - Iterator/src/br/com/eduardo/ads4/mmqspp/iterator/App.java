package br.com.eduardo.ads4.mmqspp.iterator;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author eduardo
 */
public class App extends Application {

    public static int nthreads;
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/br/com/eduardo/ads4/mmqspp/iterator/view/Principal.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setTitle("Lista Arquivo");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
