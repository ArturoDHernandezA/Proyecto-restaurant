/*
    Ramírez Torres Iñaki Sebastián
    Bases de Datos Distribuidas

    Software:
    NetBeans 8.0
    SQL Server 2008 R2
    MySQL 5.0 (Workbench 6.1)
 */

package tokai;

// Librerias necesarias //
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author hinse
 */
public class Reporte{
    public static String ReporteEmpleados(){
        try{        
            Document TSQL = new Document();
            // Nombre del archivo y la dirección donde se va a guardar //
            PdfWriter.getInstance(TSQL, new FileOutputStream("D://DELL/Empleados TOKAI.pdf"));
            // Inicio el documento //
            TSQL.open();
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 30, Font.NORMAL, BaseColor.MAGENTA));
            parrafo.add("Reporte de Empleados \n\n\n");
            TSQL.add(parrafo);
            // Agregar otro parrafo //
            parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLUE));
            parrafo.add("\n Empleados Sucursal (SQL) \n\n");
            // Añadimos los datos //
            PdfPTable tabla = new PdfPTable(9);
//            tabla.addCell("Número de Empleado");
//            tabla.addCell("Nombre");
//            tabla.addCell("RFC");
//            tabla.addCell("Teléfono");
            // -------------------------------------------------------------- //
            /* En esta ocación reutilice el método que se uso para realizar las
            consultas, el cual lo adapte para que pueda realizar el llenado de
            la tabla para posteriormente ser guardada en un PDF */
            // B1 = SQL //
            Connection B1 = null;
            // B2 = MySQL //
            Connection B2 = null;
            
            B1 = Conexion.conexion("SQL", "sa", "180926", "TOKAI");
            B2 = Conexion.conexion("MySQL", "root", "1310HnBt1809", "TOKAI");
            
            String Titulo[] = new String[2];
            String Datos[][] = new String[2][2];
            
            if(B1 != null && B2 != null){
                try{
                    Statement BD1 = B1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    Statement BD2 = B2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet RS1 = BD1.executeQuery("select * from Empleados");
                    ResultSet RS2 = BD2.executeQuery("select * from Empleados");
                    
                    if(RS1.next() && RS2.next()){
                    int Columnas1 = RS1.getMetaData().getColumnCount();
                    int Columnas2 = RS2.getMetaData().getColumnCount();
                    int Columnas = (Columnas1 + Columnas2) - 1;
                    Titulo = new String[Columnas];
                    RS1.last();
                    int Filas1 = RS1.getRow();
                    RS2.last();
                    int Filas2 = RS2.getRow();
                    if(Filas1 == Filas2){
                        Datos = new String[Filas2][Columnas];
                        int conC1 = 0;
                        for(int i = 0; i < Columnas1; i++){
                            Titulo[conC1++] = RS1.getMetaData().getColumnName(i+1);
                            tabla.addCell(Titulo[i]);
                        }for(int i = 1; i < Columnas2; i++){
                            Titulo[conC1++] = RS2.getMetaData().getColumnName(i+1);
                            // Problema
                            tabla.addCell(Titulo[i]);
                        }
                        RS1.first();
                        RS2.first();
                        int conC2 = Columnas1 - 1;
                        for(int a = 0; a < Filas1; a++){
                            for(int b = 0; b < Columnas1; b++){
                                Datos[a][b] = RS1.getString(b+1);
                                tabla.addCell(Datos[a][b]);
                            }
                            RS1.next();
                            for(int c = 1; c < Columnas2; c++){
                                Datos[a][conC2+c] = RS2.getString(c+1);
                                tabla.addCell(Datos[a][conC2+c]);
                            }
                            RS2.next();
                        }
                    }
                    }else{
                        // Agregar otro parrafo //
                        parrafo = new Paragraph();
                        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.RED));
                        parrafo.add("\n No Hay Datos \n\n");
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e);
                }
            }else{
            System.out.println("Base No Conectada");
            }
        // -------------------------------------------------------------- //
            TSQL.add(parrafo);
            TSQL.add(tabla);
            Image imagen = Image.getInstance("D://DELL/Fondo.jpg");
            imagen.setAlignment(Paragraph.ALIGN_CENTER);
            imagen.scalePercent(30);
            TSQL.add(imagen);
            TSQL.close();
            JOptionPane.showMessageDialog(null, "Tablas Creadas Exitosamente");
            }catch(Exception e){
            System.out.println("Error en la gráfica" + e);
        }
        return (null);
    }
    
    public static String ReporteSucursal(){
        try{        
            Document TMySQL = new Document();
            // Nombre del archivo y la dirección donde se va a guardar //
            PdfWriter.getInstance(TMySQL, new FileOutputStream("D://DELL/Sucursal TOKAI.pdf"));
            // Inicio el documento //
            TMySQL.open();
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 30, Font.NORMAL, BaseColor.MAGENTA));
            parrafo.add("Reporte de Empleados \n\n\n");
            TMySQL.add(parrafo);
            // Agregar otro parrafo //
            parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo.setFont(FontFactory.getFont("Arial", 15, Font.NORMAL, BaseColor.BLUE));
            parrafo.add("\n Empleados Sucursal (SQL) \n\n");
            // Añadimos los datos //
            PdfPTable tabla = new PdfPTable(4);
//            tabla.addCell("Número de Empleado");
//            tabla.addCell("Nombre");
//            tabla.addCell("RFC");
//            tabla.addCell("Teléfono");
            // -------------------------------------------------------------- //
            /* En esta ocación reutilice el método que se uso para realizar las
            consultas, el cual lo adapte para que pueda realizar el llenado de
            la tabla para posteriormente ser guardada en un PDF */
            Connection B2 = Conexion.conexion("MySQL", "root", "1310HnBt1809", "TOKAI");

            if(B2 != null){
                try{
                    Statement st = B2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = st.executeQuery("select * from Sucursal");
                    if(rs.next()){
                        //Obtiene el numero de columnas
                    int Columnas = rs.getMetaData().getColumnCount();
                    String Titulos[] = new String[Columnas];
                    //Se manda el apuntador al final de la tabla
                    rs.last();
                    int Filas = rs.getRow();
                    for(int i = 0; i < Columnas; i++){
                        Titulos[i] = rs.getMetaData().getColumnName(i + 1);
                        tabla.addCell(Titulos[i]);
                    }
                    String Datos[][] = new String[Filas][Columnas];
                    //Regresamos el apuntador al inicio
                    rs.first();
                    for(int f = 0; f < Filas; f++){
                        for(int c = 0; c < Columnas; c++){
                            Datos[f][c] = rs.getString(c + 1);
                            tabla.addCell(Datos[f][c]);
                            }
                            rs.next();
                        }
                    }else{ 
                        // Agregar otro parrafo //
                        parrafo = new Paragraph();
                        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo.setFont(FontFactory.getFont("Arial", 15, Font.NORMAL, BaseColor.RED));
                        parrafo.add("\n No Hay Datos \n\n");
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e);
                }
            }else{
            System.out.println("Base No Conectada");
            }
            // -------------------------------------------------------------- //
            TMySQL.add(parrafo);
            TMySQL.add(tabla);
            Image imagen = Image.getInstance("D://DELL/TOKAI.jpg");
            imagen.setAlignment(Paragraph.ALIGN_CENTER);
            imagen.scalePercent(90);
            TMySQL.add(imagen);
            TMySQL.close();
            JOptionPane.showMessageDialog(null, "Tablas Creadas Exitosamente");
            }catch(Exception e){
            System.out.println("Error en la gráfica" + e);
        }
        return (null);
    }
    
    public static String ReporteInventarioE(){
        try{        
            Document TMySQL = new Document();
            // Nombre del archivo y la dirección donde se va a guardar //
            PdfWriter.getInstance(TMySQL, new FileOutputStream("D://DELL/Entradas TOKAI.pdf"));
            // Inicio el documento //
            TMySQL.open();
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 30, Font.NORMAL, BaseColor.MAGENTA));
            parrafo.add("Reporte de Empleados \n\n\n");
            TMySQL.add(parrafo);
            // Agregar otro parrafo //
            parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo.setFont(FontFactory.getFont("Arial", 15, Font.NORMAL, BaseColor.BLUE));
            parrafo.add("\n Empleados Sucursal (SQL) \n\n");
            // Añadimos los datos //
            PdfPTable tabla = new PdfPTable(8);
//            tabla.addCell("Número de Empleado");
//            tabla.addCell("Nombre");
//            tabla.addCell("RFC");
//            tabla.addCell("Teléfono");
            // -------------------------------------------------------------- //
            /* En esta ocación reutilice el método que se uso para realizar las
            consultas, el cual lo adapte para que pueda realizar el llenado de
            la tabla para posteriormente ser guardada en un PDF */
            Connection B2 = Conexion.conexion("SQL", "sa", "180926", "TOKAI");

            if(B2 != null){
                try{
                    Statement st = B2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = st.executeQuery("select * from Almacen_Entrada");
                    if(rs.next()){
                        //Obtiene el numero de columnas
                    int Columnas = rs.getMetaData().getColumnCount();
                    String Titulos[] = new String[Columnas];
                    //Se manda el apuntador al final de la tabla
                    rs.last();
                    int Filas = rs.getRow();
                    for(int i = 0; i < Columnas; i++){
                        Titulos[i] = rs.getMetaData().getColumnName(i + 1);
                        tabla.addCell(Titulos[i]);
                    }
                    String Datos[][] = new String[Filas][Columnas];
                    //Regresamos el apuntador al inicio
                    rs.first();
                    for(int f = 0; f < Filas; f++){
                        for(int c = 0; c < Columnas; c++){
                            Datos[f][c] = rs.getString(c + 1);
                            tabla.addCell(Datos[f][c]);
                            }
                            rs.next();
                        }
                    }else{ 
                        // Agregar otro parrafo //
                        parrafo = new Paragraph();
                        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo.setFont(FontFactory.getFont("Arial", 15, Font.NORMAL, BaseColor.RED));
                        parrafo.add("\n No Hay Datos \n\n");
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e);
                }
            }else{
            System.out.println("Base No Conectada");
            }
            // -------------------------------------------------------------- //
            TMySQL.add(parrafo);
            TMySQL.add(tabla);
            Image imagen = Image.getInstance("D://DELL/TOKAI.jpg");
            imagen.setAlignment(Paragraph.ALIGN_CENTER);
            imagen.scalePercent(90);
            TMySQL.add(imagen);
            TMySQL.close();
            JOptionPane.showMessageDialog(null, "Tablas Creadas Exitosamente");
            }catch(Exception e){
            System.out.println("Error en la gráfica" + e);
        }
        return (null);
    }
    
    public static String ReporteInventarioS(){
        try{        
            Document TMySQL = new Document();
            // Nombre del archivo y la dirección donde se va a guardar //
            PdfWriter.getInstance(TMySQL, new FileOutputStream("D://DELL/Salidas TOKAI.pdf"));
            // Inicio el documento //
            TMySQL.open();
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 30, Font.NORMAL, BaseColor.MAGENTA));
            parrafo.add("Reporte de Empleados \n\n\n");
            TMySQL.add(parrafo);
            // Agregar otro parrafo //
            parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo.setFont(FontFactory.getFont("Arial", 15, Font.NORMAL, BaseColor.BLUE));
            parrafo.add("\n Empleados Sucursal (SQL) \n\n");
            // Añadimos los datos //
            PdfPTable tabla = new PdfPTable(7);
//            tabla.addCell("Número de Empleado");
//            tabla.addCell("Nombre");
//            tabla.addCell("RFC");
//            tabla.addCell("Teléfono");
            // -------------------------------------------------------------- //
            /* En esta ocación reutilice el método que se uso para realizar las
            consultas, el cual lo adapte para que pueda realizar el llenado de
            la tabla para posteriormente ser guardada en un PDF */
            Connection B2 = Conexion.conexion("SQL", "sa", "180926", "TOKAI");

            if(B2 != null){
                try{
                    Statement st = B2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = st.executeQuery("select * from Almacen_Salida");
                    if(rs.next()){
                        //Obtiene el numero de columnas
                    int Columnas = rs.getMetaData().getColumnCount();
                    String Titulos[] = new String[Columnas];
                    //Se manda el apuntador al final de la tabla
                    rs.last();
                    int Filas = rs.getRow();
                    for(int i = 0; i < Columnas; i++){
                        Titulos[i] = rs.getMetaData().getColumnName(i + 1);
                        tabla.addCell(Titulos[i]);
                    }
                    String Datos[][] = new String[Filas][Columnas];
                    //Regresamos el apuntador al inicio
                    rs.first();
                    for(int f = 0; f < Filas; f++){
                        for(int c = 0; c < Columnas; c++){
                            Datos[f][c] = rs.getString(c + 1);
                            tabla.addCell(Datos[f][c]);
                            }
                            rs.next();
                        }
                    }else{ 
                        // Agregar otro parrafo //
                        parrafo = new Paragraph();
                        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo.setFont(FontFactory.getFont("Arial", 15, Font.NORMAL, BaseColor.RED));
                        parrafo.add("\n No Hay Datos \n\n");
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e);
                }
            }else{
            System.out.println("Base No Conectada");
            }
            // -------------------------------------------------------------- //
            TMySQL.add(parrafo);
            TMySQL.add(tabla);
            Image imagen = Image.getInstance("D://DELL/TOKAI.jpg");
            imagen.setAlignment(Paragraph.ALIGN_CENTER);
            imagen.scalePercent(90);
            TMySQL.add(imagen);
            TMySQL.close();
            JOptionPane.showMessageDialog(null, "Tablas Creadas Exitosamente");
            }catch(Exception e){
            System.out.println("Error en la gráfica" + e);
        }
        return (null);
    }
    
    public static String BarraEmpleados(){
        try{
            Document Barra = new Document();
            //nombre del archivo donde se guarda el reporte
            PdfWriter.getInstance(Barra, new FileOutputStream("D://DELL/Barra Empleados.pdf"));
            Barra.open();//abriendo archivo para escritura
            Paragraph parrafo = new Paragraph(); //creando parrafo
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 25, Font.BOLD, BaseColor.RED));
            //para agregar espacios al texto necesitamos\n
            parrafo.add("Reporte de Empleados \n\n\n");
            Barra.add(parrafo);
            Image imagen = Image.getInstance("D://DELL/Fondo.jpg");
            imagen.setAlignment(Image.ALIGN_CENTER);
            imagen.scalePercent(40);
            Barra.add(imagen);
            //otro parrafo
            parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo.setFont(FontFactory.getFont("Arial", 12, BaseColor.BLACK));
            parrafo.add("\n\nGrafico de empleados por Sucursal \n\n");
            Barra.add(parrafo);
            //CREAR GRAFICO
            Graficos gr = new Graficos();
            gr.graficaBarras();
            //PEGO GRAFICO CREADO
            imagen = Image.getInstance("D://DELL/graficoBarra.jpg");
            imagen.setAlignment(Image.ALIGN_CENTER);
            imagen.scalePercent(40);
            Barra.add(imagen);
            JOptionPane.showMessageDialog(null, "Gráfica de Barras Creada Exitosamente");
            Barra.close();
            return ("Reporte Creado");
            //probamos
        }catch(Exception e){
            return ("Error en reporte " + e);
        }
    }
    public static String reportePie(){
        try{
            Document doc = new Document();
            //nombre del archivo donde se guarda el reporte
            PdfWriter.getInstance(doc, new FileOutputStream("D://DELL/ReportePie.pdf"));
            doc.open();//abriendo archivo para escritura
            Paragraph parrafo = new Paragraph(); //creando parrafo
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 25, Font.BOLD, BaseColor.RED));
            //para agregar espacios al texto necesitamos\n
            parrafo.add("Reporte de Empleados \n\n\n");
            doc.add(parrafo);
            Image imagen = Image.getInstance("c://DELL/Fondo.jpg");
            imagen.setAlignment(Image.ALIGN_CENTER);
            imagen.scalePercent(40);
            doc.add(imagen);
            //otro parrafo
            parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo.setFont(FontFactory.getFont("Arial", 12, BaseColor.BLACK));
            parrafo.add("\n\nGrafico de empleados por Sucursal \n\n");
            doc.add(parrafo);
            //CREAR GRAFICO
            Graficos gr = new Graficos();
            gr.graficaPie();
            //PEGO GRAFICO CREADO
            imagen = Image.getInstance("c://DELL/graficoPie.jpg");
            imagen.setAlignment(Image.ALIGN_CENTER);
            imagen.scalePercent(40);
            doc.add(imagen);
            JOptionPane.showMessageDialog(null, "Gráfica de Pie Creada Exitosamente");
            doc.close();
            return ("Reporte Creado");
            //
        }catch(Exception e){
            return ("Error en reporte " + e);
        }
    }
}
