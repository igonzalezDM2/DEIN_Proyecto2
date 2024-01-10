module Proyecto_DEIN_2 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
	opens model to javafx.graphics, javafx.fxml, javafx.base;
	opens controller to javafx.graphics, javafx.fxml, java.sql, javafx.base;
}
