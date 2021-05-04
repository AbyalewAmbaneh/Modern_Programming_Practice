package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.ButtonGroup;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import object.Airline;
import object.Airport;
import object.FlightInstance;
import object.Passenger;
import object.Reservation;
import object.Ticket;
import service.ReservationSystemFacade;
import service.ReservationSystemFacadeImpl;

public class userInterface extends Application {
	ReservationSystemFacade dataSource = new ReservationSystemFacadeImpl();
	RadioButton passenger = new RadioButton("Passenger");
	RadioButton makeReservation = new RadioButton("Make Reservation");

	TextField id = new TextField();
	TextField deparAiro = new TextField();
	TextField arrivAiro = new TextField();
	TextField date = new TextField();
	TextField reservationCode = new TextField();

	/////////////////////////// For scene Make
	/////////////////////////// reservation//////////////////////////////////

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {

		stage.setTitle("Address Form");
/////////////////////////////////////
		Button btShowAirPort = new Button("View List of Airports");
		Button btViewlistairlines = new Button("View list of airlines by Airports");
		Button btViewlistflights = new Button("View list of flights");
		Button btmyreservations = new Button("View list of my reservations");
		Button btMakeReservation = new Button("Make a reservation");
		Button btCancelReservation = new Button("Cancel a Reservation");

		final ToggleGroup group = new ToggleGroup();
		passenger.setToggleGroup(group);
///////////////////////////////////////
		BorderPane bPane = new BorderPane();
		FlowPane flowpane1 = new FlowPane();
		FlowPane flowpane2 = new FlowPane();
		flowpane1.setAlignment(Pos.CENTER);
		flowpane2.setAlignment(Pos.CENTER);
////////////////////////////////////////
		GridPane gridP = new GridPane();
		gridP.setPadding(new Insets(5, 5, 5, 5));
		gridP.add(passenger, 0, 1);
		gridP.add(makeReservation, 0, 2);

/////////////////////////////////////////
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(5, 5, 5, 5));
		grid.add(new Text("ID"), 0, 0);
		grid.add(id, 0, 1);
/////////////////////////////////////////
		GridPane grid1 = new GridPane();
		grid1.setPadding(new Insets(5, 5, 5, 5));
		grid1.add(new Text("Departure"), 0, 0);
		grid1.add(deparAiro, 0, 1);
////////////////////////////////////////
		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(5, 5, 5, 5));
		grid2.add(new Text("Arrival"), 0, 0);
		grid2.add(arrivAiro, 0, 1);
////////////////////////////////////////
		GridPane grid3 = new GridPane();
		grid3.setPadding(new Insets(5, 5, 5, 5));
		grid3.add(new Text("Date (YYYY-MM-DD)"), 0, 0);
		grid3.add(date, 0, 1);
////////////////////////////////////////
		GridPane grid4 = new GridPane();
		grid4.setPadding(new Insets(5, 5, 5, 5));
		grid4.add(new Text("reservation Code"), 0, 0);
		grid4.add(reservationCode, 0, 1);

////////////////////////////////////////
		flowpane1.getChildren().add(gridP);
		flowpane1.getChildren().add(grid);
		flowpane1.getChildren().add(grid1);
		flowpane1.getChildren().add(grid2);
		flowpane1.getChildren().add(grid3);
		flowpane1.getChildren().add(grid4);
		flowpane1.setHgap(10);
		flowpane1.setVgap(5);
		passenger.setSelected(true);
		btMakeReservation.setVisible(false);

////////////////////////////////////////
		flowpane2.getChildren().add(btShowAirPort);
		flowpane2.getChildren().add(btViewlistairlines);
		flowpane2.getChildren().add(btViewlistflights);
		flowpane2.getChildren().add(btmyreservations);
		flowpane2.getChildren().add(btMakeReservation);
		flowpane2.getChildren().add(btCancelReservation);

//////////////////////////////////////////////////
		bPane.setTop(flowpane1);
		bPane.setBottom(flowpane2);
		flowpane2.setPadding(new Insets(5, 5, 5, 5));
//////////////////////////////////////////////////
		makeReservation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (makeReservation.isSelected()) {
					btMakeReservation.setVisible(true);
					btViewlistairlines.setVisible(false);
					btShowAirPort.setVisible(false);
					btViewlistflights.setVisible(false);
					btmyreservations.setVisible(false);
					btCancelReservation.setVisible(false);
					grid3.setVisible(true);
					grid4.setVisible(false);
				} else {
					btMakeReservation.setVisible(false);
					btViewlistairlines.setVisible(true);
					btShowAirPort.setVisible(true);
					btViewlistflights.setVisible(true);
					btmyreservations.setVisible(true);
					btCancelReservation.setVisible(true);
					grid3.setVisible(true);
					grid4.setVisible(true);

				}

			}
		});

////////////////////////////////////////////////
		btShowAirPort.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				if (deparAiro.getText().trim().equals("")) {
					for (Airport airoport : dataSource.findAllAirports())
						System.out.println(airoport);
					System.out
							.println("##############################################################################");

				}

				else {
					System.out.println(dataSource.findAirportByAirportCode(deparAiro.getText()));
					System.out
							.println("##############################################################################");
				}

			}
		});
///////////////////////////////////////////////////
		btViewlistairlines.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!deparAiro.getText().trim().equals("")) {
					for (Airline airline : dataSource.findAirlinesByAirportCode(deparAiro.getText()))
						System.out.println(airline);
					System.out
							.println("##############################################################################");

				}
			}
		});
///////////////////////////////////////////////////
		btViewlistflights.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!deparAiro.getText().trim().equals("") && !arrivAiro.getText().trim().equals("")
						&& !date.getText().trim().equals("")) {

					String date1 = date.getText();
					LocalDate localDate = LocalDate.parse(date1);
					
					
					List<FlightInstance> flightInstances = dataSource.findFlightsFromTo(deparAiro.getText(), arrivAiro.getText(), localDate);
					
					
					for (FlightInstance flight : flightInstances) {
						System.out.println(flight);					
					}
					
					if (flightInstances.size() == 0) {
						String msg = String.format("There is no any flight from %s to %s at %s ", 
										deparAiro.getText(), arrivAiro.getText(), localDate);
						System.out.println(msg);
					}
					
					
					System.out.println("##############################################################################");

				}
			}
		});
///////////////////////////////////////////////////
		btmyreservations.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				if (passenger.isSelected() && !id.getText().trim().equals("")) {
					for (Reservation reservation : dataSource.findReservationsByPassengerId(id.getText()))
						System.out.println(reservation);
					System.out
							.println("##############################################################################");
				}


			}
		});

		///////////////////////////////////////////////////
		btMakeReservation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!deparAiro.getText().trim().equals("") && !arrivAiro.getText().trim().equals("")
						&& !date.getText().trim().equals("")) {

					String departure = deparAiro.getText();
					String arrival = arrivAiro.getText();
					String date1 = date.getText();
					LocalDate localDate = LocalDate.parse(date1);
					
					List<FlightInstance> flightInstances = dataSource.findFlightsFromTo(departure, arrival, localDate);

					if (flightInstances.size() == 0) {
						String msg = String.format("Can not make find flight from %s to %s at %s ", 
														departure, arrival, localDate);
						System.out.println(msg);
						return;
					}
					
					if (passenger.isSelected() && !id.getText().trim().equals("")) {
						Reservation reservation = dataSource.createReservation(id.getText(), flightInstances);
						System.out.println(reservation);
						System.out
						.println("##############################################################################");

					}

				}
			}
		});
///////////////////////////////////////////////////
		btCancelReservation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!reservationCode.getText().trim().equals("")) {
					boolean var = dataSource.cancelReservation(reservationCode.getText());
					if (var)
						System.out.println("the reservation is successfully removed");
					else
						System.out.println("the reservation not Found");

				}
			}
		});


//////////////////////////////////////////////////
		stage.setScene(new Scene(bPane, 850, 200));
		stage.show();

	}

}