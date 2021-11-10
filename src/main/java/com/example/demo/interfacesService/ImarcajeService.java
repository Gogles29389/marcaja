package com.example.demo.interfacesService;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Marcaje;

import net.sf.jasperreports.engine.JRException;

public interface ImarcajeService {

	public List<Marcaje>listar();
	public Optional<Marcaje>listarId(int id_marcaje);
	public int save(Marcaje m);
	public void delete(int id_marcaje);
	public String exportReport(String format) throws FileNotFoundException, JRException;
}
