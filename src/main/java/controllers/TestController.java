package controllers;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gerenciamentoderedes.database.Database;

@RestController
@RequestMapping("/")
public class TestController {
	
	@GetMapping("/db")
	public ResponseEntity<String> testDB(){
		System.out.println("Endpoint acessado");
		try(Connection con = Database.getConnection()){
			return new ResponseEntity<>("BANCO ESTÁ OK!", HttpStatus.OK);
		}catch(SQLException ex) {
			return new ResponseEntity<>("BANCO NÃO TA CONECTADO", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/alive")
	public ResponseEntity<String> isAlive(){
		String msg = "Estou vivo";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}
