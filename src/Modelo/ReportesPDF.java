/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: .java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Modelo;

import Controlador.RegistrarVenta_Eventos;
import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.HorizontalAlignment;
import be.quodlibet.boxable.Row;
import be.quodlibet.boxable.VerticalAlignment;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Camilo Ruiz Casanova
 * clase para generar archivos pdf
 */
public class ReportesPDF 
{
    private static PDPage agregarPagina(PDDocument doc) 
    {
        PDPage page = new PDPage();
        doc.addPage(page);
        return page;
    }

    public static void generarRecibo(Venta venta) 
    {
	if (venta != null) 
	{
	    //margenes
	    float margin = 10;
	    //inicializacion del documento
	    PDDocument doc = new PDDocument();
	    PDPage page = agregarPagina(doc);
	    float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
	    //inicializacion de la tabla
	    float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
	    boolean drawContent = true;
	    float yStart = yStartNewPage;
	    float bottomMargin = 70;
	    try 
	    {
		BaseTable table = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, drawContent);
		//fila de titulo
		Row<PDPage> headerRow = table.createRow(15.0F);
		Cell<PDPage> cell = headerRow.createCell(100, "EMPRESA FLASH", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		table.setHeader(headerRow);
		
		headerRow = table.createRow(15.0F);
		cell = headerRow.createCell(100, "NIT xxx.xxx.xxx-x", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		
		headerRow = table.createRow(15.0F);
		cell = headerRow.createCell(100, "RECIBO DE VENTA NO. " + venta.getId(), HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		
		//fila de los campos
		Row<PDPage> campos = table.createRow(15.0F);
		cell = campos.createCell(1 * 100 / 3, "POS", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		cell = campos.createCell(2 * 100 / 3, venta.getPos(), HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		
		campos = table.createRow(15.0F);
		cell = campos.createCell(1 * 100 / 3, "FECHA", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		cell = campos.createCell(2 * 100 / 3, venta.getFecha(), HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		
		Row<PDPage> row;
		row = table.createRow(15.0F);
		cell = row.createCell(100, "DATOS DEL CLIENTE");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		
		row = table.createRow(15.0F);
		cell = row.createCell(100 / 2, "CEDULA");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		cell = row.createCell(100 / 2, venta.getCedula());
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		
		row = table.createRow(15.0F);
		cell = row.createCell(100 / 2, "NOMBRE");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		cell = row.createCell(100 / 2, venta.getNombre());
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		
		row = table.createRow(15.0F);
		cell = row.createCell(100 / 2, "DIRECCION");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		cell = row.createCell(100 / 2, venta.getDireccion());
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		
		row = table.createRow(15.0F);
		cell = row.createCell(100, "PAQUETES");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		
		for (Paquete p : venta.getPaquetes()) 
		{
		    row = table.createRow(15.0F);
		    cell = row.createCell(100 / 2, "NUMERO");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 2, String.valueOf(p.getNumero()));
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    
		    row = table.createRow(15.0F);
		    cell = row.createCell(100 / 2, "VOLUMEN (cm^3)");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 2, String.valueOf(p.getVolumen()));
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    
		    row = table.createRow(15.0F);
		    cell = row.createCell(100 / 2, "PESO (g)");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 2, String.valueOf(p.getPeso()));
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    
		    row = table.createRow(15.0F);
		    cell = row.createCell(100 / 2, "DESCRIPCION");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 2, p.getDescripcion());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    
		    row = table.createRow(15.0F);
		    cell = row.createCell(100 / 2, "COSTO");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 2, String.valueOf(p.getCosto()));
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		}
		
		row = table.createRow(15.0F);
		cell = row.createCell(100, "PAGO");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		
		row = table.createRow(15.0F);
		cell = row.createCell(100 / 2, "METODO");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		cell = row.createCell(100 / 2, venta.getMetodo());
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		
		row = table.createRow(15.0F);
		cell = row.createCell(100 / 2, "SUBTOTAL");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		cell = row.createCell(100 / 2, String.valueOf(venta.getSubtotal()));
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		
		row = table.createRow(15.0F);
		cell = row.createCell(100 / 2, "IVA (16%)");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		cell = row.createCell(100 / 2, String.valueOf(venta.getIva()));
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		
		row = table.createRow(15.0F);
		cell = row.createCell(100 / 2, "SEGURO");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		cell = row.createCell(100 / 2, String.valueOf(venta.getSeguro()));
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		
		row = table.createRow(15.0F);
		cell = row.createCell(100 / 2, "TOTAL");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		cell = row.createCell(100 / 2, String.valueOf(venta.getTotal()));
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		
		table.draw();
		
		//cerrar flujo y guardar pdf
		File file = new File("Recibo_" + venta.getId() + ".pdf");
		System.out.println("Sample file saved at : " + file.getAbsolutePath());
		doc.save(file);
		doc.close();
		Desktop.getDesktop().open(file);
	    }
	    catch (IOException ex) 
	    {
		Logger.getLogger(RegistrarVenta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
    
    public static void generarReciboPQR(PQR pqr) 
    {
	if (pqr != null) 
	{
	    //margenes
	    float margin = 10;
	    //inicializacion del documento
	    PDDocument doc = new PDDocument();
	    PDPage page = agregarPagina(doc);
	    float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
	    //inicializacion de la tabla
	    float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
	    boolean drawContent = true;
	    float yStart = yStartNewPage;
	    float bottomMargin = 70;
	    try 
	    {
		BaseTable table = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, drawContent);
		//fila de titulo
		Row<PDPage> headerRow = table.createRow(15.0F);
		Cell<PDPage> cell = headerRow.createCell(100, "EMPRESA FLASH", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		table.setHeader(headerRow);
		
		headerRow = table.createRow(15.0F);
		cell = headerRow.createCell(100, "NIT xxx.xxx.xxx-x", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		
		headerRow = table.createRow(15.0F);
		cell = headerRow.createCell(100, "PQR NO. " + pqr.getNumero(), HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		
		//fila de los campos
		Row<PDPage> campos = table.createRow(15.0F);
		cell = campos.createCell(1 * 100 / 3, "SEDE", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		cell = campos.createCell(2 * 100 / 3, pqr.getSede(), HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		
		campos = table.createRow(15.0F);
		cell = campos.createCell(1 * 100 / 3, "FECHA", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		cell = campos.createCell(2 * 100 / 3, pqr.getFecha(), HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		
		Row<PDPage> row;
		row = table.createRow(15.0F);
		cell = row.createCell(100, "DATOS DEL CLIENTE");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		
		row = table.createRow(15.0F);
		cell = row.createCell(100 / 2, "CEDULA");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		cell = row.createCell(100 / 2, pqr.getCedula());
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		
		row = table.createRow(15.0F);
		cell = row.createCell(100 / 2, "NOMBRE");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		cell = row.createCell(100 / 2, pqr.getNombre());
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);		
		
		row = table.createRow(15.0F);
		cell = row.createCell(100, "PQR");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		
		row = table.createRow(15.0F);
		cell = row.createCell(100 / 2, "TIPO");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		cell = row.createCell(100 / 2, pqr.getTipo());
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		
		row = table.createRow(15.0F);
		cell = row.createCell(100 / 2, "ESTADO");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		cell = row.createCell(100 / 2, String.valueOf(pqr.getEstado()));
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		
		row = table.createRow(15.0F);
		cell = row.createCell(100, "CONTENIDO");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);
		
		String c = pqr.getContenido();
		c = c.replace('\n', ' ');
		
		row = table.createRow(15.0F);
		cell = row.createCell(100, c);
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		table.draw();
		
		//cerrar flujo y guardar pdf
		File file = new File("PQR_" + pqr.getNumero() + ".pdf");
		System.out.println("Sample file saved at : " + file.getAbsolutePath());
		doc.save(file);
		doc.close();
		Desktop.getDesktop().open(file);
	    }
	    catch (IOException ex) 
	    {
		Logger.getLogger(RegistrarVenta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }

    public static void generarListadoUsuarios(ArrayList<Usuario> lista) 
    {
	if (lista != null) 
	{
	    //margenes
	    float margin = 10;
	    //inicializacion del documento
	    PDDocument doc = new PDDocument();
	    PDPage page = agregarPagina(doc);
	    float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
	    //inicializacion de la tabla
	    float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
	    boolean drawContent = true;
	    float yStart = yStartNewPage;
	    float bottomMargin = 70;
	    try 
	    {
		BaseTable table = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, drawContent);
		//fila de titulo
		Row<PDPage> headerRow = table.createRow(15.0F);
		Cell<PDPage> cell = headerRow.createCell(100, "EMPRESA FLASH", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		table.setHeader(headerRow);
		
		headerRow = table.createRow(15.0F);
		cell = headerRow.createCell(100, "NIT xxx.xxx.xxx-x", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		
		headerRow = table.createRow(15.0F);
		cell = headerRow.createCell(100, "LISTADO DE TODOS LOS USUARIOS DEL SISTEMA", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		
		Row<PDPage> row;
		
		for (Usuario u : lista)
		{
		    row = table.createRow(15.0F);
		    cell = row.createCell(100/2, "USUARIO: " + u.getCedula());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(12);
		    cell.setFillColor(Color.LIGHT_GRAY);
		    cell = row.createCell(100/2, "ESTADO: " + u.getEstado());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(12);
		    cell.setFillColor(Color.LIGHT_GRAY);
		    
		    row = table.createRow(15.0F);
		    cell = row.createCell(100 / 4, "NOMBRE");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, u.getNombre());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, "APELLIDO");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, u.getApellido());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    
		    row = table.createRow(15.0F);
		    cell = row.createCell(100 / 4, "ROL");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, u.getRol());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, "SEDE");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, u.getNumeroSede());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		}
		
		row = table.createRow(15.0F);
		cell = row.createCell(100, "<< " + lista.size() + " Usuarios >>");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);

		table.draw();
		
		//cerrar flujo y guardar pdf
		File file = new File("ListadoUsuarios.pdf");
		System.out.println("Sample file saved at : " + file.getAbsolutePath());
		doc.save(file);
		doc.close();
		Desktop.getDesktop().open(file);
	    }
	    catch (IOException ex) 
	    {
		Logger.getLogger(RegistrarVenta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
    
    public static void generarListadoSedes(ArrayList<Sede> lista) 
    {
	if (lista != null) 
	{
	    //margenes
	    float margin = 10;
	    //inicializacion del documento
	    PDDocument doc = new PDDocument();
	    PDPage page = agregarPagina(doc);
	    float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
	    //inicializacion de la tabla
	    float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
	    boolean drawContent = true;
	    float yStart = yStartNewPage;
	    float bottomMargin = 70;
	    try 
	    {
		BaseTable table = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, drawContent);
		//fila de titulo
		Row<PDPage> headerRow = table.createRow(15.0F);
		Cell<PDPage> cell = headerRow.createCell(100, "EMPRESA FLASH", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		table.setHeader(headerRow);
		
		headerRow = table.createRow(15.0F);
		cell = headerRow.createCell(100, "NIT xxx.xxx.xxx-x", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		
		headerRow = table.createRow(15.0F);
		cell = headerRow.createCell(100, "LISTADO DE TODAS LAS SEDES DEL SISTEMA", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		
		Row<PDPage> row;
		
		for (Sede s : lista)
		{
		    row = table.createRow(15.0F);
		    cell = row.createCell(100/2, "SEDE: " + s.getNumero());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(12);
		    cell.setFillColor(Color.LIGHT_GRAY);
		    cell = row.createCell(100/2, "NOMBRE: " + s.getNombre());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(12);
		    cell.setFillColor(Color.LIGHT_GRAY);
		    
		    row = table.createRow(15.0F);
		    cell = row.createCell(100 / 4, "DIRECCION");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, s.getDireccion());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, "CIUDAD");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, s.getCiudad());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    
		    row = table.createRow(15.0F);
		    cell = row.createCell(100 / 4, "GERENTE");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, s.getGerente());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, "CAMIONES");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, String.valueOf(s.getCamiones()));
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		}
		
		row = table.createRow(15.0F);
		cell = row.createCell(100, "<< " + lista.size() + " Sedes >>");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);

		table.draw();
		
		//cerrar flujo y guardar pdf
		File file = new File("ListadoSedes.pdf");
		System.out.println("Sample file saved at : " + file.getAbsolutePath());
		doc.save(file);
		doc.close();
		Desktop.getDesktop().open(file);
	    }
	    catch (IOException ex) 
	    {
		Logger.getLogger(RegistrarVenta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
    
    public static void generarListadoPQR(ArrayList<PQR> lista) 
    {
	if (lista != null) 
	{
	    //margenes
	    float margin = 10;
	    //inicializacion del documento
	    PDDocument doc = new PDDocument();
	    PDPage page = agregarPagina(doc);
	    float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
	    //inicializacion de la tabla
	    float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
	    boolean drawContent = true;
	    float yStart = yStartNewPage;
	    float bottomMargin = 70;
	    try 
	    {
		BaseTable table = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, drawContent);
		//fila de titulo
		Row<PDPage> headerRow = table.createRow(15.0F);
		Cell<PDPage> cell = headerRow.createCell(100, "EMPRESA FLASH", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		table.setHeader(headerRow);
		
		headerRow = table.createRow(15.0F);
		cell = headerRow.createCell(100, "NIT xxx.xxx.xxx-x", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		
		headerRow = table.createRow(15.0F);
		cell = headerRow.createCell(100, "LISTADO DE TODOS LOS PQR DEL SISTEMA", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		
		Row<PDPage> row;
		
		for (PQR p : lista)
		{
		    row = table.createRow(15.0F);
		    cell = row.createCell(100/3, "PQR N° " + p.getNumero());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(12);
		    cell.setFillColor(Color.LIGHT_GRAY);
		    cell = row.createCell(100/3, "ESTADO: " + p.getEstado());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(12);
		    cell.setFillColor(Color.LIGHT_GRAY);
		    cell = row.createCell(100/3, "SEDE: " + p.getSede());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(12);
		    cell.setFillColor(Color.LIGHT_GRAY);
		    
		    row = table.createRow(15.0F);
		    cell = row.createCell(100 / 4, "TIPO");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, p.getTipo());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, "FECHA");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, p.getFecha());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    
		    row = table.createRow(15.0F);
		    cell = row.createCell(100 / 4, "CEDULA");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, p.getCedula());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, "NOMBRE");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, p.getNombre());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    
		    row = table.createRow(15.0F);
		    cell = row.createCell(100, "CONTENIDO: " + p.getContenido().replace('\n', ' '));
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		}
		
		row = table.createRow(15.0F);
		cell = row.createCell(100, "<< " + lista.size() + " PQR >>");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);

		table.draw();
		
		//cerrar flujo y guardar pdf
		File file = new File("ListadoPQR.pdf");
		System.out.println("Sample file saved at : " + file.getAbsolutePath());
		doc.save(file);
		doc.close();
		Desktop.getDesktop().open(file);
	    }
	    catch (IOException ex) 
	    {
		Logger.getLogger(RegistrarVenta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
    
    public static void generarListadoPOS(ArrayList<POS> lista) 
    {
	if (lista != null) 
	{
	    //margenes
	    float margin = 10;
	    //inicializacion del documento
	    PDDocument doc = new PDDocument();
	    PDPage page = agregarPagina(doc);
	    float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
	    //inicializacion de la tabla
	    float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
	    boolean drawContent = true;
	    float yStart = yStartNewPage;
	    float bottomMargin = 70;
	    try 
	    {
		BaseTable table = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, drawContent);
		//fila de titulo
		Row<PDPage> headerRow = table.createRow(15.0F);
		Cell<PDPage> cell = headerRow.createCell(100, "EMPRESA FLASH", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		table.setHeader(headerRow);
		
		headerRow = table.createRow(15.0F);
		cell = headerRow.createCell(100, "NIT xxx.xxx.xxx-x", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		
		headerRow = table.createRow(15.0F);
		cell = headerRow.createCell(100, "LISTADO DE TODOS LOS POS DEL SISTEMA", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		
		Row<PDPage> row;
		
		row = table.createRow(15.0F);
		cell = row.createCell(100/3, "ID");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		cell = row.createCell(100/3, "NOMBRE");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		cell = row.createCell(100/3, "DIRECCION");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);
		
		for (POS p : lista)
		{
		    row = table.createRow(15.0F);
		    cell = row.createCell(100 / 3, p.getId());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 3, p.getNombre());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 3, p.getDireccion());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		}
		
		row = table.createRow(15.0F);
		cell = row.createCell(100, "<< " + lista.size() + " POS >>");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);

		table.draw();
		
		//cerrar flujo y guardar pdf
		File file = new File("ListadoPOS.pdf");
		System.out.println("Sample file saved at : " + file.getAbsolutePath());
		doc.save(file);
		doc.close();
		Desktop.getDesktop().open(file);
	    }
	    catch (IOException ex) 
	    {
		Logger.getLogger(RegistrarVenta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
    
    public static void generarListadoVentas(ArrayList<Venta> lista) 
    {
	if (lista != null) 
	{
	    //margenes
	    float margin = 10;
	    //inicializacion del documento
	    PDDocument doc = new PDDocument();
	    PDPage page = agregarPagina(doc);
	    float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
	    //inicializacion de la tabla
	    float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
	    boolean drawContent = true;
	    float yStart = yStartNewPage;
	    float bottomMargin = 70;
	    try 
	    {
		BaseTable table = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, drawContent);
		//fila de titulo
		Row<PDPage> headerRow = table.createRow(15.0F);
		Cell<PDPage> cell = headerRow.createCell(100, "EMPRESA FLASH", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		table.setHeader(headerRow);
		
		headerRow = table.createRow(15.0F);
		cell = headerRow.createCell(100, "NIT xxx.xxx.xxx-x", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		
		headerRow = table.createRow(15.0F);
		cell = headerRow.createCell(100, "LISTADO DE TODAS LAS VENTAS DEL SISTEMA", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		
		Row<PDPage> row;
		
		for (Venta v : lista)
		{
		    row = table.createRow(15.0F);
		    cell = row.createCell(100/3, "VENTA N° " + v.getId());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(12);
		    cell.setFillColor(Color.LIGHT_GRAY);
		    cell = row.createCell(100/3, "FECHA: " + v.getFecha());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(12);
		    cell.setFillColor(Color.LIGHT_GRAY);
		    cell = row.createCell(100/3, "POS: " + v.getPos());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(12);
		    cell.setFillColor(Color.LIGHT_GRAY);
		    
		    row = table.createRow(15.0F);
		    cell = row.createCell(100 / 4, "CEDULA");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, v.getCedula());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, "NOMBRE");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, v.getNombre());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    
		    row = table.createRow(15.0F);
		    cell = row.createCell(100 / 4, "DIRECCION");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, v.getDireccion());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, "PAQUETES");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, String.valueOf(v.getPaquetes().size()));
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    
		    row = table.createRow(15.0F);
		    cell = row.createCell(100 / 4, "METODO");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, v.getMetodo());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, "TOTAL");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		    cell = row.createCell(100 / 4, String.valueOf(v.getTotal()));
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		}
		
		row = table.createRow(15.0F);
		cell = row.createCell(100, "<< " + lista.size() + " Ventas >>");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);

		table.draw();
		
		//cerrar flujo y guardar pdf
		File file = new File("ListadoVentas.pdf");
		System.out.println("Sample file saved at : " + file.getAbsolutePath());
		doc.save(file);
		doc.close();
		Desktop.getDesktop().open(file);
	    }
	    catch (IOException ex) 
	    {
		Logger.getLogger(RegistrarVenta_Eventos.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
}
