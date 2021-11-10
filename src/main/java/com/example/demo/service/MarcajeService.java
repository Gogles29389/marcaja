package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.demo.interfaces.IMarcaje;
import com.example.demo.interfacesService.ImarcajeService;
import com.example.demo.modelo.Marcaje;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class MarcajeService implements ImarcajeService {

	@Autowired
	private IMarcaje data;
	
	@Override
	public List<Marcaje> listar() {
		return (List<Marcaje>) data.findAll();
	}

	@Override
	public Optional<Marcaje> listarId(int id_marcaje) {
		return data.findById(id_marcaje);
	}

	@Override
	public int save(Marcaje m) {
		int res=0;
		Marcaje marcaje=data.save(m);
	if(!marcaje.equals(null)) {
		res=1;
	}	
		return res;
	}

	@Override
	public void delete(int id_marcaje) {
		data.deleteById(id_marcaje);
		}

	public String exportReport(String format) throws FileNotFoundException, JRException {
		List<Marcaje> useMarcaje= listar();
		String path="C:\\Jasperreportes\\";
		File file = ResourceUtils.getFile("classpath:Marcajes.jrxml");
		JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(useMarcaje);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("gain java","knowledge");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parameters, ds);
		
		if(format.equalsIgnoreCase("html")) {
		JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "marcajes.html");
	}
	
	if(format.equalsIgnoreCase("pdf")) {
		JasperExportManager.exportReportToPdfFile(jasperPrint, path + "marcajes.pdf");
	}
	
	return " path : " +path;
		
	
	}
	 
	
	}
	
	
