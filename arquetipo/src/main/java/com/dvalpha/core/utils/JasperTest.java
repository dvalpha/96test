package com.dvalpha.core.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dvalpha.core.entity.MstClialb;
import com.dvalpha.core.entity.MstCliente;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class JasperTest {

	public static void main(String[] args) {
		/*try {
			
			List<MstClialb>albaranes=(List<MstClialb>)dao.findAll(new MstClialb());
			List<MstCliente>clientes=(List<MstCliente>)dao.find_By_SQL_Generic("SELECT * FROM mst_cliente where id=113;", MstCliente.class);
			JRDataSource dataSourceAlbaranes = new JRBeanCollectionDataSource(albaranes);
			
			
			Map<String,Object> parameterMap = new HashMap<String,Object>();
	        parameterMap.put("albaranes", dataSourceAlbaranes);
	    
	        parameterMap.put("nombreCliente",clientes.get(0).getNombre());
	        parameterMap.put("mailCliente",clientes.get(0).getMail());
	        parameterMap.put("nifCliente",clientes.get(0).getNif());
	        
	        
	        JasperReport jasperReport = JasperCompileManager
	             .compileReport("C:\\workspaces\\spumas96\\arquetipo\\src\\main\\java\\com\\dvalpha\\core\\reports\\test.jrxml");
	        
	        JasperPrint jasperPrint;
			jasperPrint = JasperFillManager.fillReport(jasperReport,
					 parameterMap, dataSourceAlbaranes);
		
			// Make sure the output directory exists.
			File outDir = new File("C:/jasperoutput");
			outDir.mkdirs();

		     // Export to PDF.
		     JasperExportManager.exportReportToPdfFile(jasperPrint,
		             "C:/jasperoutput/StyledTextReport.pdf");
		      
		     System.out.println("Done!");
		
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

	}

}
