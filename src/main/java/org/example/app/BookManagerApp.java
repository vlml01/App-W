package org.example.app;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class BookManagerApp extends Application {

    private List<Author> authors = new ArrayList<>();
    private List<Work> works = new ArrayList<>();
    private List<Genre> genres = new ArrayList<>();
    private List<Country> countries = new ArrayList<>();
    private List<Language> languages = new ArrayList<>();
    private List<Edition> editions = new ArrayList<>();
    private List<Publisher> publishers = new ArrayList<>();


    //  Теперь authorNameField ComboBox
    private ComboBox<Author> authorCombo;
    private ComboBox<Country> authorCountryCombo;
    private TextField workTitleField;
    private ComboBox<Genre> workGenreCombo;
    private ComboBox<Language> workLanguageCombo;
    private TextField publisherNameField;
    private TextField editionQuantityField;


    // Объявляем inputGrid, menuBar, root как поля класса
    private GridPane inputGrid;
    private MenuBar menuBar;
    private BorderPane root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Writer`s work");

        // Инициализация элементов ввода
        setupInputFields();

        Button addButton = new Button("Добавить произведение");
        addButton.setOnAction(e -> addBook());


        Button addGenreButton = new Button("Добавить жанр");
        addGenreButton.setOnAction(e -> addGenre());
        Button addLanguageButton = new Button("Добавить язык");
        addLanguageButton.setOnAction(e -> addLanguage());

        Button addAuthorButton = new Button("Добавить автора");
        addAuthorButton.setOnAction(e -> addAuthor());


        inputGrid = new GridPane();
        inputGrid.setPadding(new Insets(10));
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);

        inputGrid.add(new Label("Автор:"), 0, 0);
        inputGrid.add(authorCombo, 1, 0);
        inputGrid.add(new Label("Страна автора:"), 0, 1);
        inputGrid.add(authorCountryCombo, 1, 1);
        inputGrid.add(new Label("Название книги:"), 0, 2);
        inputGrid.add(workTitleField, 1, 2);
        inputGrid.add(new Label("Жанр:"), 0, 3);
        inputGrid.add(workGenreCombo, 1, 3);
        inputGrid.add(new Label("Язык:"), 0, 4);
        inputGrid.add(workLanguageCombo, 1, 4);
        inputGrid.add(new Label("Издательство:"), 0, 5);
        inputGrid.add(publisherNameField, 1, 5);
        inputGrid.add(new Label("Тираж:"), 0, 6);
        inputGrid.add(editionQuantityField, 1, 6);

        // Создание меню
        menuBar = new MenuBar();
        Menu fileMenu = new Menu("Созданные записи");
        MenuItem showDetailsItem = new MenuItem("Данные о писателях и их книгах");
        showDetailsItem.setOnAction(e -> showWorkDetails());
        fileMenu.getItems().add(showDetailsItem);

        menuBar.getMenus().add(fileMenu);

        // Создание HBox для кнопок в верхнем правом углу
        HBox topRightButtons = new HBox(10);
        topRightButtons.setAlignment(Pos.TOP_RIGHT);
        topRightButtons.getChildren().addAll(addAuthorButton,  addGenreButton, addLanguageButton);

        //Создаем VBox для меню и кнопок
        VBox menuButtonsBox = new VBox(10);
        menuButtonsBox.getChildren().addAll(menuBar, topRightButtons);
        //Создание HBox для размещения кнопки добавить книгу
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.getChildren().add(addButton);

        VBox content = new VBox(10);
        content.getChildren().addAll(inputGrid, buttonBox);
        // Создаем корневой BorderPane и добавляем в него элементы
        root = new BorderPane();
        root.setTop(menuButtonsBox);
        root.setCenter(content);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setupInputFields() {
        authorCombo = new ComboBox<>(FXCollections.observableArrayList(authors));
        authorCountryCombo = new ComboBox<>(FXCollections.observableArrayList(countries));
        workTitleField = new TextField();
        workGenreCombo = new ComboBox<>(FXCollections.observableArrayList(genres));
        workLanguageCombo = new ComboBox<>(FXCollections.observableArrayList(languages));
        publisherNameField = new TextField();
        editionQuantityField = new TextField();
    }


    private void addBook() {
        Author author = authorCombo.getValue();
        Country country = authorCountryCombo.getValue();
        String workTitle = workTitleField.getText();
        Genre genre = workGenreCombo.getValue();
        Language language = workLanguageCombo.getValue();
        String publisherName = publisherNameField.getText();
        String editionQuantityText = editionQuantityField.getText();



        if (author == null) {
            showAlert("Имя автора не может быть пустым");
            return;
        }

        if (country == null) {
            showAlert("Страна автора не может быть пустой");
            return;
        }

        if (workTitle == null || workTitle.trim().isEmpty()) {
            showAlert("Название книги не может быть пустым");
            return;
        }
        if (genre == null) {
            showAlert("Жанр не может быть пустым");
            return;
        }
        if (language == null) {
            showAlert("Язык не может быть пустым");
            return;
        }
        if (publisherName == null || publisherName.trim().isEmpty()) {
            showAlert("Поле 'Издатель' не может быть пустым");
            return;
        }
        if (editionQuantityText == null || editionQuantityText.trim().isEmpty()) {
            showAlert("Поле 'Тираж' не может быть пустым");
            return;
        }
        int printingQuantity = 0;
        try {
            printingQuantity = Integer.parseInt(editionQuantityText);
        } catch (NumberFormatException e) {
            showAlert("Тираж должен быть числом");
            return;
        }


        if (!authors.contains(author)) {
            authors.add(author);
        }
        Work work = new Work(workTitle, author, genre, language);
        works.add(work);

        Publisher publisher = new Publisher(publisherName);
        publishers.add(publisher);
        Edition edition = new Edition(work, publisher, printingQuantity);
        editions.add(edition);

        clearInputFields();
    }



    private void addGenre() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Добавить жанр");
        dialog.setHeaderText("Введите название жанра");
        dialog.setContentText("Жанр:");

        dialog.showAndWait().ifPresent(name -> {
            Genre genre = new Genre(name);
            genres.add(genre);
            workGenreCombo.getItems().add(genre);
        });
    }

    private void addLanguage() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Добавить язык");
        dialog.setHeaderText("Введите название языка");
        dialog.setContentText("Язык:");

        dialog.showAndWait().ifPresent(name -> {
            Language language = new Language(name);
            languages.add(language);
            workLanguageCombo.getItems().add(language);
        });
    }



    private void addAuthor() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Добавить автора");
        dialog.setHeaderText("Введите имя автора");
        dialog.setContentText("Имя:");

        dialog.showAndWait().ifPresent(name -> {
            TextInputDialog countryDialog = new TextInputDialog();
            countryDialog.setTitle("Добавить страну");
            countryDialog.setHeaderText("Введите страну автора");
            countryDialog.setContentText("Страна:");
            countryDialog.showAndWait().ifPresent(countryName -> {
                Country country = new Country(countryName);
                if (!countries.contains(country)) {
                    countries.add(country);
                    authorCountryCombo.getItems().add(country);
                }

                Author author = new Author(name, country);
                if (!authors.contains(author)) {
                    authors.add(author);
                    authorCombo.getItems().add(author);
                }
            });
        });
    }

    private void clearInputFields() {
        authorCombo.setValue(null);
        authorCountryCombo.setValue(null);
        workTitleField.clear();
        workGenreCombo.setValue(null);
        workLanguageCombo.setValue(null);
        publisherNameField.clear();
        editionQuantityField.clear();
    }

    private void showWorkDetails() {
        WorkDetailsWindow workDetailsWindow = new WorkDetailsWindow(FXCollections.observableArrayList(editions));
        workDetailsWindow.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка ввода");
        alert.setHeaderText("Некорректный ввод");
        alert.setContentText(message);
        alert.showAndWait();
    }
}