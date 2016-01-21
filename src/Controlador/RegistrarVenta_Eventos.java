/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.POS;
import Modelo.POSDAO;
import Modelo.Paquete;
import Modelo.Venta;
import Modelo.VentaDAO;
import Vista.RegistrarVenta;
import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.HorizontalAlignment;
import be.quodlibet.boxable.Row;
import be.quodlibet.boxable.VerticalAlignment;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author AndresFelipe
 */
public class RegistrarVenta_Eventos
{
    private final RegistrarVenta registrarVenta;
    private ArrayList<Paquete> paquetes;
    private Paquete selected;

    public RegistrarVenta_Eventos(final RegistrarVenta registrarVenta)
    {
        this.registrarVenta = registrarVenta;
        this.paquetes = new ArrayList();
        this.selected = null;

        this.registrarVenta.bCancelar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    cerrarFormulario();
                }
            }
        );

        this.registrarVenta.cbPaquetes.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    seleccion();
                }
            }
        );

        this.registrarVenta.bEliminarPaquete.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    eliminaPaquete();
                }
            }
        );

        this.registrarVenta.bAgregarPaquete.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    agregaPaquete();
                }
            }
        );
	
	this.registrarVenta.cbSeguro.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    agregaSeguro();
                }
            }
        );
	
	this.registrarVenta.bRegistrarVenta.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    agregaVenta();
                }
            }
        );
	
	actualizaPOS();
	habilitarVenta();
    }
    
    private void actualizaPOS()
    {
	ArrayList<POS> pos = new POSDAO().getListaPOS();
	
	if (pos != null)
	{
	    this.registrarVenta.cbPOS.removeAllItems();
        
	    for (POS p : pos)
	    {
		this.registrarVenta.cbPOS.addItem(p.getId());
	    }
	}
    }
    
    private void habilitarVenta()
    {
	if (this.registrarVenta.cbPOS.getItemCount() > 0)
	{
	    this.registrarVenta.tfCedula.setEditable(true);
	    this.registrarVenta.tfNombre.setEditable(true);	    
	    this.registrarVenta.tfDireccion.setEditable(true);
	    this.registrarVenta.tfAgregarVolumen.setEditable(true);
	    this.registrarVenta.tfAgregarPeso.setEditable(true);
	    this.registrarVenta.taAgregarDescripcion.setEditable(true);
	    this.registrarVenta.tfCosto.setEditable(true);
	    this.registrarVenta.cbPaquetes.setEnabled(true);
	    this.registrarVenta.bAgregarPaquete.setEnabled(true);
	    this.registrarVenta.bEliminarPaquete.setEnabled(true);
	    this.registrarVenta.rbEfectivo.setEnabled(true);
	    this.registrarVenta.rbCredito.setEnabled(true);
	    this.registrarVenta.rbDebito.setEnabled(true);
	    this.registrarVenta.cbSeguro.setEnabled(true);
	    this.registrarVenta.bRegistrarVenta.setEnabled(true);
	}
	else
	{
	    this.registrarVenta.tfCedula.setEditable(false);
	    this.registrarVenta.tfNombre.setEditable(false);	    
	    this.registrarVenta.tfDireccion.setEditable(false);
	    this.registrarVenta.tfAgregarVolumen.setEditable(false);
	    this.registrarVenta.tfAgregarPeso.setEditable(false);
	    this.registrarVenta.taAgregarDescripcion.setEditable(false);
	    this.registrarVenta.tfCosto.setEditable(false);
	    this.registrarVenta.cbPaquetes.setEnabled(false);
	    this.registrarVenta.bAgregarPaquete.setEnabled(false);
	    this.registrarVenta.bEliminarPaquete.setEnabled(false);
	    this.registrarVenta.rbEfectivo.setEnabled(false);
	    this.registrarVenta.rbCredito.setEnabled(false);
	    this.registrarVenta.rbDebito.setEnabled(false);
	    this.registrarVenta.cbSeguro.setEnabled(false);
	    this.registrarVenta.bRegistrarVenta.setEnabled(false);
	}
    }

    public void cerrarFormulario()
    {
        this.registrarVenta.setVisible(false);
    }

    public void seleccion()
    {
        int index = this.registrarVenta.cbPaquetes.getSelectedIndex();
        
        if (index != -1)
        {
            this.selected = this.paquetes.get(index);
        
            if (selected != null)
            {
                this.registrarVenta.tfVerVolumen.setText(selected.getVolumen()+"");
                this.registrarVenta.tfVerPeso.setText(selected.getPeso()+"");
                this.registrarVenta.taVerDescripcion.setText(selected.getDescripcion());
                this.registrarVenta.tfVerCosto.setText(selected.getCosto()+"");
            }
        }
        else
        {
            this.selected = null;
        }
    }

    public void eliminaPaquete()
    {
        if (this.selected != null)
        {
            int index = this.registrarVenta.cbPaquetes.getSelectedIndex();
            this.paquetes.remove(index);
            
	    for (int i = index; i < this.paquetes.size(); i++)
            {
                  this.paquetes.get(i).setNumero(this.paquetes.get(i).getNumero()-1);
            }
            
            borrarCamposPaquete();
            actualizaLista();
            
            calcular();
        }
    }
    
    public boolean verificaCamposPaquete()
    {
	if (!this.registrarVenta.tfAgregarVolumen.getText().isEmpty())
	{
	    try
	    {
		Double.parseDouble(this.registrarVenta.tfAgregarVolumen.getText());
	    }
	    catch (NumberFormatException ex)
	    {
		JOptionPane.showMessageDialog(registrarVenta, "El campo Volumen es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
		return false;
	    }
	}
	else
	{
	    JOptionPane.showMessageDialog(registrarVenta, "El campo Volumen es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
	    return false;
	}
	
	if (!this.registrarVenta.tfAgregarPeso.getText().isEmpty())
	{
	    try
	    {
		Double.parseDouble(this.registrarVenta.tfAgregarPeso.getText());
	    }
	    catch (NumberFormatException ex)
	    {
		JOptionPane.showMessageDialog(registrarVenta, "El campo Peso es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
		return false;
	    }
	}
	else
	{
	    JOptionPane.showMessageDialog(registrarVenta, "El campo Peso es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
	    return false;
	}
	
	if (this.registrarVenta.taAgregarDescripcion.getText().isEmpty())
	{
	    JOptionPane.showMessageDialog(registrarVenta, "El campo Descripcion es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
	    return false;
	}
	
	if (!this.registrarVenta.tfCosto.getText().isEmpty())
	{
	    try
	    {
		Double.parseDouble(this.registrarVenta.tfCosto.getText());
	    }
	    catch (NumberFormatException ex)
	    {
		JOptionPane.showMessageDialog(registrarVenta, "El campo Costo es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
		return false;
	    }
	}
	else
	{
	    JOptionPane.showMessageDialog(registrarVenta, "El campo Costo es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
	    return false;
	}
	
	return true;
    }

    public void agregaPaquete()
    {
        if (verificaCamposPaquete())
        {
            int numero = this.paquetes.size()+1;
            double volumen = Double.parseDouble(this.registrarVenta.tfAgregarVolumen.getText());
            double peso = Double.parseDouble(this.registrarVenta.tfAgregarPeso.getText());
            String descripcion = this.registrarVenta.taAgregarDescripcion.getText();
            double costo = Double.parseDouble(this.registrarVenta.tfCosto.getText());

            Paquete insert = new Paquete("", numero, volumen, peso, descripcion, costo);	    
            this.paquetes.add(insert);
            
            borrarCamposPaquete();
            actualizaLista();

            // Autoseleccionar ultimo item agregado
            this.registrarVenta.cbPaquetes.setSelectedIndex(numero-1);
            
            calcular();
        }
    }
    
    public boolean verificaCamposVenta()
    {
	if (this.registrarVenta.tfCedula.getText().isEmpty())
	{
	    JOptionPane.showMessageDialog(registrarVenta, "El campo Cedula es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
	    return false;
	}
	
	if (this.registrarVenta.tfNombre.getText().isEmpty())
	{
	    JOptionPane.showMessageDialog(registrarVenta, "El campo Nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
	    return false;
	}
	
	if (this.registrarVenta.tfDireccion.getText().isEmpty())
	{
	    JOptionPane.showMessageDialog(registrarVenta, "El campo Direccion es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
	    return false;
	}
	
	if (this.paquetes.size() <= 0)
	{
	    JOptionPane.showMessageDialog(registrarVenta, "Debe agregar al menos 1 paquete.", "Error", JOptionPane.ERROR_MESSAGE);
	    return false;
	}
	
	if (!this.registrarVenta.rbEfectivo.isSelected() && !this.registrarVenta.rbCredito.isSelected() && !this.registrarVenta.rbDebito.isSelected())
	{
	    JOptionPane.showMessageDialog(registrarVenta, "Debe seleccionar un metodo de pago.", "Error", JOptionPane.ERROR_MESSAGE);
	    return false;
	}
	
	return true;
    }
    
    public void agregaVenta()
    {
	if (verificaCamposVenta())
	{
	    String pos = (String) this.registrarVenta.cbPOS.getSelectedItem();
	    String cedula = this.registrarVenta.tfCedula.getText();
	    String nombre = this.registrarVenta.tfNombre.getText();
	    String direccion = this.registrarVenta.tfDireccion.getText();

	    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	    String fecha = df.format(Calendar.getInstance().getTime());

	    String metodo = "";

	    if (this.registrarVenta.rbEfectivo.isSelected())
	    {
		metodo = this.registrarVenta.rbEfectivo.getText();
	    }
	    else if (this.registrarVenta.rbCredito.isSelected())
	    {
		metodo = this.registrarVenta.rbCredito.getText();
	    }
	    else if (this.registrarVenta.rbDebito.isSelected())
	    {
		metodo = this.registrarVenta.rbDebito.getText();
	    }

	    double seguro = Double.parseDouble(this.registrarVenta.tfSeguro.getText());
	    double subtotal = Double.parseDouble(this.registrarVenta.tfSubtotal.getText());
	    double iva = Double.parseDouble(this.registrarVenta.tfIVA.getText());
	    double total = Double.parseDouble(this.registrarVenta.tfTotal.getText());

	    Venta venta = new Venta(cedula, nombre, direccion, fecha, metodo, seguro, subtotal, iva, total, pos, this.paquetes);
	    
	    int op = JOptionPane.showConfirmDialog(registrarVenta, "Desea registrar la Venta?", "Confirmacion", JOptionPane.YES_NO_OPTION);
	    
	    if (op == JOptionPane.YES_OPTION)
	    {
		boolean exito = new VentaDAO().insertarVenta(venta);

		if (exito)
		{
		    JOptionPane.showMessageDialog(registrarVenta, "Venta registrada correctamente.", "", JOptionPane.INFORMATION_MESSAGE);
		    borrarCamposVenta();
		    
		    generaRecibo(new VentaDAO().consultarUltimaVenta());
		}
		else
		{
		    JOptionPane.showMessageDialog(registrarVenta, "Error al registrar la Venta.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	    }
	}
    }
    
    public static void generaRecibo(Venta venta)
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
		BaseTable table  = new BaseTable(yStart,yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, drawContent);

		//fila de titulo
		Row<PDPage> headerRow = table.createRow(15f);
		Cell<PDPage> cell = headerRow.createCell(100, "EMPRESA FLASH", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);
		table.setHeader(headerRow);

		headerRow = table.createRow(15f);
		cell = headerRow.createCell(100, "NIT xxx.xxx.xxx-x", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);

		headerRow = table.createRow(15f);
		cell = headerRow.createCell(100, "RECIBO DE VENTA NO. " + venta.getId(), HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.COURIER_BOLD);
		cell.setFontSize(28);
		cell.setFillColor(Color.BLACK);
		cell.setTextColor(Color.WHITE);

		//fila de los campos
		Row<PDPage> campos = table.createRow(15f);

		cell = campos.createCell((1*100/3), "POS", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);       

		cell = campos.createCell((2*100/3), venta.getPos(), HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);

		campos = table.createRow(15f);

		cell = campos.createCell((1*100/3), "FECHA", HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);       

		cell = campos.createCell((2*100/3), venta.getFecha(), HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);

		Row<PDPage> row;

		row = table.createRow(15f);

		cell = row.createCell((100), "DATOS DEL CLIENTE");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);

		row = table.createRow(15f);

		cell = row.createCell((100 / 2), "CEDULA");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		cell = row.createCell((100 / 2), venta.getCedula());
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		row = table.createRow(15f);

		cell = row.createCell((100 / 2), "NOMBRE");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		cell = row.createCell((100 / 2), venta.getNombre());
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		row = table.createRow(15f);

		cell = row.createCell((100 / 2), "DIRECCION");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		cell = row.createCell((100 / 2), venta.getDireccion());
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		row = table.createRow(15f);

		cell = row.createCell((100), "PAQUETES");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);

		for (Paquete p : venta.getPaquetes())
		{
		    row = table.createRow(15f);

		    cell = row.createCell((100 / 2), "NUMERO");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);

		    cell = row.createCell((100 / 2), String.valueOf(p.getNumero()));
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);

		    row = table.createRow(15f);

		    cell = row.createCell((100 / 2), "VOLUMEN (cm^3)");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);

		    cell = row.createCell((100 / 2), String.valueOf(p.getVolumen()));
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);

		    row = table.createRow(15f);

		    cell = row.createCell((100 / 2), "PESO (g)");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);

		    cell = row.createCell((100 / 2), String.valueOf(p.getPeso()));
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);

		    row = table.createRow(15f);

		    cell = row.createCell((100 / 2), "DESCRIPCION");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);

		    cell = row.createCell((100 / 2), p.getDescripcion());
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);

		    row = table.createRow(15f);

		    cell = row.createCell((100 / 2), "COSTO");
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);

		    cell = row.createCell((100 / 2), String.valueOf(p.getCosto()));
		    cell.setFont(PDType1Font.HELVETICA);
		    cell.setFontSize(11);
		}

		row = table.createRow(15f);

		cell = row.createCell((100), "PAGO");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(12);
		cell.setFillColor(Color.LIGHT_GRAY);

		row = table.createRow(15f);

		cell = row.createCell((100 / 2), "METODO");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		cell = row.createCell((100 / 2), venta.getMetodo());
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		row = table.createRow(15f);

		cell = row.createCell((100 / 2), "SUBTOTAL");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		cell = row.createCell((100 / 2), String.valueOf(venta.getSubtotal()));
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		row = table.createRow(15f);

		cell = row.createCell((100 / 2), "IVA (16%)");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		cell = row.createCell((100 / 2), String.valueOf(venta.getIva()));
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		row = table.createRow(15f);

		cell = row.createCell((100 / 2), "SEGURO");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		cell = row.createCell((100 / 2), String.valueOf(venta.getSeguro()));
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		row = table.createRow(15f);

		cell = row.createCell((100 / 2), "TOTAL");
		cell.setFont(PDType1Font.HELVETICA);
		cell.setFontSize(11);

		cell = row.createCell((100 / 2), String.valueOf(venta.getTotal()));
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

    public void actualizaLista()
    {
        this.registrarVenta.cbPaquetes.removeAllItems();
        
        for (Paquete i : this.paquetes)
        {
              this.registrarVenta.cbPaquetes.addItem(i.getNumero()+"");
        }
    }
    
    public void agregaSeguro()
    {
	if (this.registrarVenta.cbSeguro.isSelected())
	{
	    double total = Double.parseDouble(this.registrarVenta.tfTotal.getText());
	    double seguro = total*0.02;
	    
	    this.registrarVenta.tfSeguro.setText(seguro+"");
	}
	else
	{
	    this.registrarVenta.tfSeguro.setText("0.0");
	}
	
	calcular();
    }
    
    private static PDPage agregarPagina(PDDocument doc) 
    {
        PDPage page = new PDPage();
        doc.addPage(page);
        return page;
    }

    public void calcular()
    {
        //Cambiar total por la suma 
        double iva;
        double subtotal = 0;
        
        for (Paquete p : this.paquetes)
        {
            subtotal += p.getCosto();
        }
        
        iva = subtotal*0.16;
	double total = subtotal + iva;
	
	if (this.registrarVenta.cbSeguro.isSelected())
	{
	    double seguro = Double.parseDouble(this.registrarVenta.tfSeguro.getText());
	    total += seguro;
	}
        
        this.registrarVenta.tfSubtotal.setText("" + subtotal);
        this.registrarVenta.tfIVA.setText("" + iva);
        this.registrarVenta.tfTotal.setText(total+"");
    }
    
    public void borrarCamposVenta()
    {
	this.registrarVenta.cbPOS.setSelectedIndex(0);
	this.registrarVenta.tfCedula.setText("");
	this.registrarVenta.tfNombre.setText("");
	this.registrarVenta.tfDireccion.setText("");
	this.paquetes = new ArrayList();
	actualizaLista();
	borrarCamposPaquete();
	this.registrarVenta.buttonGroup1.clearSelection();
	this.registrarVenta.cbSeguro.setSelected(false);
	this.registrarVenta.tfSeguro.setText("0.0");
	this.registrarVenta.tfSubtotal.setText("0.0");
	this.registrarVenta.tfIVA.setText("0.0");
	this.registrarVenta.tfTotal.setText("0.0");
    }

    public void borrarCamposPaquete()
    {
        this.registrarVenta.taAgregarDescripcion.setText("");
        this.registrarVenta.taVerDescripcion.setText("");
        this.registrarVenta.tfAgregarPeso.setText("");
        this.registrarVenta.tfAgregarVolumen.setText("");
        this.registrarVenta.tfCosto.setText("");
        this.registrarVenta.tfVerPeso.setText("");
        this.registrarVenta.tfVerVolumen.setText("");
        this.registrarVenta.tfVerCosto.setText("");
    }
}
