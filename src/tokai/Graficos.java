/*
    Ramírez Torres Iñaki Sebastián
    Bases de Datos Distribuidas

    Software:
    NetBeans 8.0
    SQL Server 2008 R2
    MySQL 5.0 (Workbench 6.1)
 */

package tokai;

import java.io.*;
import java.sql.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author hinse
 */
public class Graficos{
    
    String titulo, ty, tx;
    DefaultCategoryDataset datos = new DefaultCategoryDataset();
    DefaultPieDataset datos2 = new DefaultPieDataset();
    int largo = 600, ancho = 400;

    public String graficaBarras(){
        try{
            JFreeChart grafica;
            tx = "Sucursales";
            ty = "Frecuencia";
            buscarBarras();
            grafica = ChartFactory.createBarChart3D("\nEmpleados por Sucursal", 
                    tx, ty, datos, PlotOrientation.VERTICAL, true, true, true);
            ChartUtilities.saveChartAsJPEG(new File("c://DELL/graficoBarra.jpg"), grafica, largo, ancho);
            return "Grafico Creado";
        }catch(Exception e){
            return "Error en grafica Barras " + e;
        }
    }

    public String graficaPie(){
        try{
            JFreeChart grafica;
            buscarPie();
            grafica = ChartFactory.createPieChart3D(" \nEmpleados por Sucursal", datos2, true, true, true);
            ChartUtilities.saveChartAsJPEG(new File("D://DELL/graficoPie.jpg"), grafica, largo, ancho);
            return "Grafico Creado";
        }catch (Exception e){
            return "Error en grafica de pie " + e;
        }
    }

    public void buscar(String base, String query, int tipo){
        try{
            Connection conexion = Conexion.conexion("SQL", "sa", "180926", base);
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                if(tipo == 1){
                    do{
                        datos.addValue(rs.getInt(2), rs.getString(1), rs.getMetaData().getColumnName(1));
                    }while (rs.next());
                }
                if(tipo == 2){
                    do{
                        datos2.setValue(rs.getString(1) + " " + rs.getInt(2),rs.getInt(2));
                    }while(rs.next());
                }
            }
        } catch(Exception e){
            System.out.println("Error buscar " + e);
        }
    }
    
    public void buscarPie(){
        try{
            Connection conexion = Conexion.conexion("SQL", "sa", "180926", "TOKAI");
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("Select count(*) from Empleados");
            if(rs.next()){
                        datos2.setValue("Sucursal SQL",rs.getInt(1));        
                }
//            conexion = Conexion.conexion("MySQL", "root", "sasa", "P10Empleados");
//            st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            rs = st.executeQuery("Select count(*) from Empleados");
//            if(rs.next()){    
//                        datos2.setValue("Sucursal MySQL",rs.getInt(1));               
//            }
        }catch(Exception e){
            System.out.println("Error buscar pie " + e);
        }
    }
    
    public void buscarBarras(){
        try{
            Connection conexion = Conexion.conexion("SQL", "sa", "180926", "TOKAI");
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("Select count(*) from Empleados");
            if(rs.next()){
                datos.addValue(rs.getInt(1),"Empleados","");
            }
            conexion = Conexion.conexion("MySQL", "root", "1310HnBt1809", "TOKAI");
            st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("Select count(Nombre_Restaurante) from Empleados where Sucursal = 'Tokai Providencia'");
            if (rs.next()) {    
                        datos.addValue(rs.getInt(1),"Restaurantes","");
            }
        }catch(Exception e){
            System.out.println("Error buscar barra " + e);
        }
    }
}