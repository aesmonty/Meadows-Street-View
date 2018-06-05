import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.WorldController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * Main program, extends the Application class of JavaFX. Source adopted from the
 * JavaFX examples of the IJP course.
 * 
 * @author Paul Anderson
 * @version 1.0
 *
 */
public class MainProgram extends Application {

	public void start(Stage stage) {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			String viewerFxml = "WorldViewer.fxml";
			AnchorPane page = (AnchorPane) fxmlLoader.load(this.getClass().getResource(viewerFxml).openStream());
			Scene scene = new Scene(page);
			stage.setScene(scene);

			WorldController viewer = (WorldController) fxmlLoader.getController();
			viewer.Initialise();

			stage.show();

		} catch (IOException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
			System.exit(1);
		}
	}

	public static void main(String args[]) {
		launch(args);
		System.exit(0);

	}
}
