package com.example.demosidequests;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    ArrayList<Goal> goalList = new ArrayList<>();
    ArrayList<Goal> completedGoalsList = new ArrayList<>();
    List<Button> completeGoalButtons = new ArrayList<>();
    List<Attributes> attributesList = new ArrayList<>();
    Button submitName, cancelName, buttonCreateGoal, checkAttributes, buttonHome, buttonHome2;
    Label welcomeLabel, mainUIWelcomeLabel, completedGoalsLabel, currentGoal, attributesLabel;
    TextField textNameField;
    User myUser;
    String userName;
    BackgroundFill frontPageBGColor = new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY);
    Background mainBrownBG = new Background(frontPageBGColor);
    BackgroundFill goalInfoBG = new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY);
    Background whitePagesBG = new Background(goalInfoBG);
    LocalDateTime todayDate = LocalDateTime.now();
    ComboBox<Attributes> attributesComboBox;


    @Override
    public void start(Stage primaryStage) throws IOException {

        initializeAttributesList();

        // front page
        VBox frontPageMainBox = new VBox();
        VBox borderBox = new VBox();
        VBox welcomeLabelBox = new VBox();
        HBox buttonBox = new HBox();
        frontPageMainBox.setAlignment(Pos.CENTER);
        frontPageMainBox.setBackground(mainBrownBG);
        frontPageMainBox.setPadding(new Insets(10));
        welcomeLabelBox.setPadding(new Insets(10));
        borderBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        borderBox.setAlignment(Pos.CENTER);
        borderBox.setMinWidth(150);
        borderBox.setMinHeight(400);
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        welcomeLabel = new Label("Welcome!");
        welcomeLabel.setPadding(new Insets(10));
        textNameField = new TextField();
        textNameField.setPromptText("Enter your name");
        BackgroundFill welcomeLabelBoxBG = new BackgroundFill(Color.BLANCHEDALMOND, CornerRadii.EMPTY, Insets.EMPTY);
        Background welcomeLabelBoxFill = new Background(welcomeLabelBoxBG);
        welcomeLabelBox.setBackground(welcomeLabelBoxFill);
        welcomeLabelBox.setBorder(new Border(new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        welcomeLabelBox.setMaxWidth(200);
        welcomeLabelBox.setMinWidth(200);
        Font font = Font.font("Verdana", FontWeight.BOLD, 25);
        welcomeLabel.setFont(font);
        welcomeLabelBox.setAlignment(Pos.CENTER);
        welcomeLabelBox.getChildren().addAll(welcomeLabel, textNameField);
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        submitName = new Button("Submit Name");
        cancelName = new Button("Cancel");
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.setSpacing(20);
        buttonBox.setPadding(new Insets(45));
        buttonBox.getChildren().addAll(submitName, cancelName);
        borderBox.getChildren().addAll(welcomeLabelBox, buttonBox);
        frontPageMainBox.getChildren().addAll(borderBox);
        Scene primaryScene = new Scene(frontPageMainBox, 420, 420);
        submitName.requestFocus();

        //mainUIPage
        Stage mainUIStage = new Stage();
        VBox mainAppBox = new VBox();
        mainAppBox.setBackground(mainBrownBG);
        mainUIWelcomeLabel = new Label();
        mainUIWelcomeLabel.setAlignment(Pos.CENTER);
        VBox currentGoalDisplayBox = new VBox();
        currentGoalDisplayBox.setAlignment(Pos.CENTER);
        currentGoal = new Label();
        currentGoal.setBackground(whitePagesBG);
        currentGoal.setMinSize(130, 130);
        HBox mainUIButtonBox = new HBox();
        mainUIButtonBox.setSpacing(20);
        mainUIButtonBox.setPadding(new Insets(15));
        mainUIButtonBox.setAlignment(Pos.CENTER);
        buttonCreateGoal = new Button("Create Quest");
        checkAttributes = new Button("Check Attributes");
        mainUIButtonBox.getChildren().addAll(buttonCreateGoal, checkAttributes);
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        VBox completedGoalsBox = new VBox();
        BackgroundFill completedGoalsBG = new BackgroundFill(Color.CHARTREUSE, CornerRadii.EMPTY,Insets.EMPTY);
        Background completedLabelBG = new Background(completedGoalsBG);
        completedGoalsBox.setBackground(completedLabelBG);
        completedGoalsLabel = new Label("Completed Goals");
        completedGoalsBox.getChildren().addAll(completedGoalsLabel);
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        attributesLabel = new Label(" Label");

        Scene mainScene = new Scene(mainAppBox, 420, 420);
        currentGoalDisplayBox.getChildren().addAll(currentGoal);
        mainAppBox.getChildren().addAll(mainUIWelcomeLabel, currentGoalDisplayBox, mainUIButtonBox, completedGoalsBox, attributesLabel);

        //create goal
        Stage createGoal = new Stage();
        VBox createGoalMainBox = new VBox();
        createGoalMainBox.setAlignment(Pos.TOP_CENTER);
        createGoalMainBox.setPadding(new Insets(5));
        Label createGoalWelcomeLabel = new Label("Welcome " + myUser + " please create your journey.");
        createGoalWelcomeLabel.setPadding(new Insets(5));
        //createGoalWelcomeLabel.setAlignment(Pos.CENTER);
        createGoalMainBox.getChildren().add(createGoalWelcomeLabel);
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        VBox goalInfoBoxesBox = new VBox();
        goalInfoBoxesBox.setBackground(whitePagesBG);
        goalInfoBoxesBox.setMaxSize(380, 380);
        goalInfoBoxesBox.setPadding(new Insets(10));
        goalInfoBoxesBox.setSpacing(5);
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        HBox goalInfo1 = new HBox();
        Label labelGoalInfo1 = new Label("I want to:  ");
        TextField textGoalInfo1 = new TextField();
        textGoalInfo1.setPromptText("Action");
        goalInfo1.setAlignment(Pos.CENTER);
        goalInfo1.getChildren().addAll(labelGoalInfo1, textGoalInfo1);
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        HBox goalInfo2 = new HBox();
        Label labelGoalInfo2 = new Label("How many: ");
        TextField textGoalInfo2 = new TextField();
        textGoalInfo2.setPromptText("Goal amount");
        goalInfo2.setAlignment(Pos.CENTER);
        goalInfo2.getChildren().addAll(labelGoalInfo2, textGoalInfo2);
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        HBox goalInfo3 = new HBox();
        Label labelGoalInfo3 = new Label("Of: ");
        TextField textUnitOfMeasure = new TextField();
        textUnitOfMeasure.setPromptText("Miles, Pages, etc.");
        goalInfo3.setAlignment(Pos.CENTER);
        goalInfo3.getChildren().addAll(labelGoalInfo3, textUnitOfMeasure);
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        HBox goalInfo4 = new HBox();
        Label labelGoalInfo4 = new Label("How often: ");
        ComboBox comboFrequency = new ComboBox<>();
        comboFrequency.getItems().addAll( "Day", "Week", "Month");
        goalInfo4.setAlignment(Pos.CENTER);
        comboFrequency.setPromptText("Please choose: ");
        goalInfo4.getChildren().addAll(labelGoalInfo4, comboFrequency);
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        HBox goalInfo5 = new HBox();
        Label labelGoalInfo5 = new Label("By when:  ");
        DatePicker goalCompletionDatePicker = new DatePicker();
        //  modify for currentTime value??? LocalDate value = goalCompletionDatePicker.getValue();
        goalInfo5.setAlignment(Pos.CENTER);
        goalInfo5.getChildren().addAll(labelGoalInfo5, goalCompletionDatePicker);
        goalInfoBoxesBox.getChildren().addAll(goalInfo1, goalInfo2, goalInfo3, goalInfo4, goalInfo5);
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        HBox goalInfo6 = new HBox();
        Label labelGoalInfo6 = new Label();
        attributesComboBox = new ComboBox<>();
        attributesComboBox.getItems().addAll(attributesList);
        attributesComboBox.setPromptText("Select attribute to level up: ");
        goalInfo6.setAlignment(Pos.CENTER);
        goalInfo6.getChildren().addAll(labelGoalInfo6, attributesComboBox);
        goalInfoBoxesBox.getChildren().addAll(goalInfo6);

        HBox createGoalButtonBox = new HBox();
        Button submitGoal, cancelGoal;
        submitGoal = new Button("Submit Quest");
        cancelGoal = new Button("Clear Quest");
        buttonHome = new Button("Home");
        createGoalButtonBox.setAlignment(Pos.CENTER);
        createGoalButtonBox.getChildren().addAll(submitGoal, cancelGoal, buttonHome);
        createGoalButtonBox.setPadding(new Insets(20));
        createGoalButtonBox.setSpacing(20);
        createGoalMainBox.setBackground(welcomeLabelBoxFill);
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        Scene createGoalScene = new Scene(createGoalMainBox, 420, 420);
        createGoalMainBox.getChildren().addAll(goalInfoBoxesBox, createGoalButtonBox);

        // attributes page
        Stage attributesPageStage = new Stage();
        VBox attributesPageMainBox = new VBox();
        VBox attributeMainBox = new VBox();
        attributeMainBox.setAlignment(Pos.CENTER);
        attributeMainBox.setSpacing(10);

        Label attributeHeaderLabel = new Label("Attributes and Levels");
        attributeHeaderLabel.setStyle("-fx-font-weight: bold");

        attributeMainBox.getChildren().add(attributeHeaderLabel);

        for (Attributes attribute : attributesList) {
            HBox attributeRow = new HBox();
            attributeRow.setAlignment(Pos.CENTER);
            attributeRow.setSpacing(20);

            Label attributeNameLabel = new Label(attribute.getDescription() + ": ");
            Label attributeLevelLabel = new Label("Level " + attribute.getLevel());

            attributeRow.getChildren().addAll(attributeNameLabel, attributeLevelLabel);
            attributeMainBox.getChildren().add(attributeRow);
        }

        buttonHome2 = new Button("Home");
        attributeMainBox.getChildren().addAll(buttonHome2);
        attributesPageMainBox.getChildren().addAll(attributeMainBox);
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        Scene attributesPageScene = new Scene(attributesPageMainBox);

        // DND ****************
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Welcome to Side Quests");
        mainUIStage.setScene(mainScene);
        mainUIStage.setTitle("Side Quests");
        createGoal.setScene(createGoalScene);
        createGoal.setTitle("Create a New Quest ");
        attributesPageStage.setScene(attributesPageScene);
        attributesPageStage.setTitle("View Attributes");
        //mainUIStage.show();
        primaryStage.show();
        //createGoal.show();
        //attributesPageStage.show();

        // TODO: All events
        // front Page
        submitName.setOnAction(e -> {

            userName = textNameField.getText();

            if (!InputValidator.isValidName(userName)) {

                textNameField.setPromptText("Please enter a name to continue.");
                textNameField.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

            } else {

                myUser = new User(userName);
                mainUIWelcomeLabel.setText("Welcome " + myUser.getUserName());
                createGoalWelcomeLabel.setText("Welcome " + myUser.getUserName() + " please create your journey.");
                mainUIStage.show();
                primaryStage.close();
            }
        });
        // clear text fields
        cancelName.setOnAction(e -> textNameField.clear());

        // check attributes
        checkAttributes.setOnAction(e-> {
            updateAttributesLabel();
            attributesPageStage.show();
        });
        buttonHome2.setOnAction(e -> {

            attributesPageStage.close();

        });

        //Create goal

        buttonHome.setOnAction(e -> {
            createGoal.close();
            mainUIStage.show();
        });

        buttonCreateGoal.setOnAction(e -> {

            mainUIStage.close();
            createGoal.show();

        });

        submitGoal.setOnAction(e -> {

            String goalTitle = textGoalInfo1.getText();
            String unitOfMeasure =  textGoalInfo2.getText();
            String frequency = comboFrequency.getValue().toString();
            String completionDate = String.valueOf(goalCompletionDatePicker.getValue());
            String amount = textUnitOfMeasure.getText();
            Attributes selectedAttribute = attributesComboBox.getValue();

            if (!InputValidator.isValidName(goalTitle) || !InputValidator.isValidInteger(amount)) {

                textGoalInfo1.setPromptText("Please enter a valid goal title.");
                textGoalInfo1.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                textUnitOfMeasure.setPromptText("Please enter a valid number.");
                textUnitOfMeasure.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

            }

            LocalDate goalCompletionDate = goalCompletionDatePicker.getValue();
            if (!InputValidator.isValidDate(goalCompletionDate)) {

                goalCompletionDatePicker.setPromptText("Invalid date. Must be today or a future date.");
                return;
            }

            Goal myGoal = new Goal(goalTitle, amount, unitOfMeasure, frequency, completionDate, selectedAttribute);
            // TODO: ADD TO A LIST
            goalList.add(myGoal);
            updateCurrentGoalLabel();
            textGoalInfo1.clear();
            textGoalInfo2.clear();
            textUnitOfMeasure.clear();
            goalCompletionDatePicker.setValue(null);
            attributesComboBox.setValue(null);
            mainUIStage.show();
            createGoal.close();

        });

    }
    private void initializeAttributesList() {

        attributesList.add(new Attributes("Health"));
        attributesList.add(new Attributes("Happiness"));
        attributesList.add(new Attributes("Knowledge"));
        attributesList.add(new Attributes("Strength"));

    }
    private void updateCurrentGoalLabel() {

        VBox goalContainer = new VBox();

        for (int i = 0; i < goalList.size(); i++) {
         Goal goal = goalList.get(i);

         HBox goalRow = new HBox();
         goalRow.setAlignment(Pos.CENTER);
         goalRow.setPadding(new Insets(5));
         goalRow.setSpacing(20);
         goalRow.getChildren().add(new Label(goal.toString()));

         int currentIndex = i;
         Button completeButton = new Button("Complete");
         completeButton.setOnAction(e -> handleCompleteGoal(currentIndex));
         completeGoalButtons.add(completeButton);

         goalRow.getChildren().add(completeButton);
         goalContainer.getChildren().add(goalRow);

        }
        currentGoal.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        currentGoal.setGraphic(goalContainer);

        updateCompletedGoalsLabel();
    }

    private void handleCompleteGoal(int index) {
        Goal completedGoal = goalList.remove(index);
        Attributes selectedAttribute = completedGoal.getSelectedAttribute();
        if (selectedAttribute != null) {
            selectedAttribute.levelUp();
            attributesComboBox.getSelectionModel().select(selectedAttribute);
        }
        completedGoalsList.add(completedGoal);
        updateCurrentGoalLabel();
        updateCompletedGoalsLabel();
        updateAttributesLabel();
    }

    private void updateCompletedGoalsLabel() {

        StringBuilder completedGoalsText = new StringBuilder("Completed Goals: \n");

        for (Goal completedGoal : completedGoalsList) {
            completedGoalsText.append(completedGoal).append("\n");
        }

        completedGoalsLabel.setText(completedGoalsText.toString());
    }

    private void updateAttributesLabel() {

        VBox attributesContainer = new VBox();
        attributesContainer.setAlignment(Pos.CENTER);

        for (Attributes attribute : attributesList) {
            HBox attributeRow = new HBox();
            attributeRow.setAlignment(Pos.CENTER);
            attributeRow.setPadding(new Insets(5));
            attributeRow.setSpacing(20);

            Label attributeNameLabel = new Label(attribute.getDescription() + ": ");
            Label attributeLevelLabel = new Label("Level " + attribute.getLevel());

            attributeRow.getChildren().addAll(attributeNameLabel, attributeLevelLabel);
            attributesContainer.getChildren().add(attributeRow);
        }

        attributesLabel.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        attributesLabel.setGraphic(attributesContainer);
    }

    public static void main(String[] args) {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.initializeAttributesList();
        launch();
    }
}