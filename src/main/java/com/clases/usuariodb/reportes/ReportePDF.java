/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clases.usuariodb.reportes;

import com.clases.usuariodb.DAO.UsuarioDAO;
import com.clases.usuariodb.modelos.Usuario;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ReportePDF {

    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static final String imagenn1 = "c://imgs//ui.png";

    public void crearPDF(File archivoPDF) { 
        // Creamos el documento e indicamos el nombre del fichero.
        try {
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(archivoPDF));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
            }
            document.open();
            Chunk titulo = new Chunk("Reportes de....", chapterFont);
            titulo.setBackground(BaseColor.GRAY);
            // Let's create de first Chapter (Creemos el primer capítulo)
            Paragraph parrafo = new Paragraph("Listado de ", paragraphFont);
            parrafo.setSpacingAfter(20);

            UsuarioDAO usuarioDao = new UsuarioDAO();
            java.util.List<Usuario> lista = new ArrayList<>();
            lista = usuarioDao.listar();
            Integer numColumns = 3;

            // We create the table (Creamos la tabla).
            PdfPTable table = new PdfPTable(numColumns);
            // Ahora llenamos la tabla del PDF
            PdfPCell columnHeader;
            // rellenamos las filas de la tabla.
            columnHeader = new PdfPCell(new Phrase("Id"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);

            columnHeader = new PdfPCell(new Phrase("Nombre"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);

            columnHeader = new PdfPCell(new Phrase("Apellido"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);

            table.setHeaderRows(1);
            // rellenamos las filas de la tabla                
            for (Usuario u : lista) {
                table.addCell(String.valueOf(u.getId()));
                table.addCell(u.getNombre());
                table.addCell(u.getApellido());
            }
            // Añadimos la tabla    
            // Añadimos el elemento con la tabla.
            document.add(titulo);
            document.add(parrafo);
            document.add(table);
            document.close();
            System.out.println("Reporte generado exitosamente");
        } catch (DocumentException documentException) {
            System.out.println("Error al generar el reporte): " + documentException);
        }
    }
}
