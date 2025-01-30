package org.example.app;
import javafx.beans.property.SimpleStringProperty; // Добавлена строка импорта
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class WorkDetailsWindow extends Stage {
    private TableView<Edition> editionTableView;
    private ObservableList<Edition> editionData;

    public WorkDetailsWindow(ObservableList<Edition> editions) {
        initModality(Modality.APPLICATION_MODAL);
        setTitle("Данные о писателях и их произведениях");

        editionData = FXCollections.observableArrayList();
        editionData.addAll(editions);
        editionTableView = new TableView<>();
        editionTableView.setItems(editionData);

        TableColumn<Edition, String> authorColumn = new TableColumn<>("Автор");
        authorColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWork().getAuthor().getName()));
        authorColumn.setPrefWidth(150);

        TableColumn<Edition, String> titleColumn = new TableColumn<>("Название");
        titleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWork().getTitle()));
        titleColumn.setPrefWidth(150);

        TableColumn<Edition, String> genreColumn = new TableColumn<>("Жанр");
        genreColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWork().getGenre().getGenreName()));
        genreColumn.setPrefWidth(150);

        TableColumn<Edition, String> languageColumn = new TableColumn<>("Язык");
        languageColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWork().getLanguage().getLanguageName()));
        languageColumn.setPrefWidth(150);

        TableColumn<Edition, String> publisherColumn = new TableColumn<>("Издатель");
        publisherColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPublisher().getPublisherName()));
        publisherColumn.setPrefWidth(150);

        TableColumn<Edition, Integer> quantityColumn = new TableColumn<>("Тираж");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("printingQuantity"));
        quantityColumn.setPrefWidth(100);

        TableColumn<Edition, String> countryColumn = new TableColumn<>("Страна автора");
        countryColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWork().getAuthor().getCountry().getCountryName()));
        countryColumn.setPrefWidth(120);


        editionTableView.getColumns().addAll(authorColumn, titleColumn, genreColumn, languageColumn, publisherColumn, quantityColumn, countryColumn);

        VBox root = new VBox(10, editionTableView);
        root.setPadding(new Insets(10));
        setScene(new Scene(root, 1000, 400));
    }
}