package clippy.ui.fx;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class DialogBox extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    public DialogBox(String text, Image img) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);
        displayPicture.setImage(img);
        double radius = Math.min(displayPicture.getFitHeight(), displayPicture.getFitWidth()) / 2;
        javafx.scene.shape.Circle clip = new javafx.scene.shape.Circle(radius, radius, radius);
        displayPicture.setClip(clip);
        displayPicture.getStyleClass().add("profile-pic");
    }

    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
        dialog.getStyleClass().add("reply-label");
    }

    public static DialogBox getUserDialog(String text, Image img) {
        DialogBox db = new DialogBox(text, img);
        db.dialog.getStyleClass().add("user-label");
        db.setAlignment(Pos.TOP_RIGHT);

        return db;
    }

    public static DialogBox getClippyDialog(String text, Image img, String commandType) {
        DialogBox db = new DialogBox(text, img);
        db.setAlignment(Pos.TOP_LEFT);
        db.flip();
        if (commandType != null && commandType.equals("Error")) {
            db.dialog.getStyleClass().add("error-label");
        } else {
            db.changeDialogStyle(commandType);
        }
        return db;
    }

    private void changeDialogStyle(String commandType) {
        if (commandType == null) {
            return; // Do nothing if commandType is null
        }
        switch(commandType) {
        case "AddDeadlineCommand":
        case "AddEventCommand":
        case "TodoCommand":
        case "AddCommand":
            dialog.getStyleClass().add("add-label");
            break;
        case "MarkCommand":
            dialog.getStyleClass().add("marked-label");
            break;
        case "DeleteCommand":
            dialog.getStyleClass().add("delete-label");
            break;
        case "ListCommand":
            dialog.getStyleClass().add("list-label");
            break;
        default:
        }
    }
}
