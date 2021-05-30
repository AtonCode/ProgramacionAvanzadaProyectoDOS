package control;

import model.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ControlInventario {

    private Producto producto;
    private Tienda tienda;

    public ControlInventario(Tienda tienda) {
        this.tienda = tienda;

    }

    public void cargar_inventarioProductosComponente(String fileName){
        try (
                FileReader fr = new FileReader(fileName);
                CSVParser parser = new CSVParser(fr,CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            List<CSVRecord> filas=parser.getRecords();
            for (CSVRecord fila:filas) {

                double id = Double.parseDouble(fila.get("id"));
                int idSucursal = Integer.parseInt(fila.get("idSucursal"));
                int cantidad =Integer.parseInt(fila.get("cantidad"));
                String tipo = fila.get("tipo");
                String nombre = fila.get("nombre");
                double precio =Double.parseDouble(fila.get("precio"));
                String descripcion = fila.get("descripcion");
                String resumen = fila.get("resumen");
                String dispsitivoPertence = fila.get("dispsitivoPertence");
                String descripcion_fisica = fila.get("descripcion_fisica");
                String informacinAdicional = fila.get("informacinAdicional");

                Componente componente = new Componente(id, idSucursal,cantidad,tipo, nombre,precio,descripcion,resumen,dispsitivoPertence,descripcion_fisica, informacinAdicional);
                this.tienda.getInventarioGeneral().add(componente);


            }
        }catch (FileNotFoundException e) {
            System.err.println("El archivo no se encontro:"+e.getMessage());
        }catch(IOException ioe) {
            System.err.println("Error al procesar archivo: "+ioe.getMessage());
            ioe.printStackTrace();
        }

    }

    public void cargar_inventarioProductosDispositivo(String fileName){
        try (
                FileReader fr = new FileReader(fileName);
                CSVParser parser = new CSVParser(fr,CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            List<CSVRecord> filas=parser.getRecords();
            for (CSVRecord fila:filas) {


                double id = Double.parseDouble(fila.get("id"));
                int idSucursal = Integer.parseInt(fila.get("idSucursal"));
                int cantidad =Integer.parseInt(fila.get("cantidad"));
                String tipo = fila.get("tipo");
                String nombre = fila.get("nombre");
                double precio =Double.parseDouble(fila.get("precio"));
                String descripcion = fila.get("descripcion");
                String resumen = fila.get("resumen");
                String pantalla= fila.get("pantalla");
                String almacenamiento= fila.get("almacenamiento");
                String procesamiento= fila.get("procesamiento");
                String tecnicas= fila.get("tecnicas");
                String descripcion_fisica= fila.get("descripcion_fisica");
                String conectividad= fila.get("conectividad");
                String informacinAdicional= fila.get("informacinAdicional");


                Dispositivo dispositivo = new Dispositivo(id,idSucursal,cantidad,tipo, nombre,precio,descripcion,resumen,pantalla,almacenamiento,procesamiento,tecnicas,descripcion_fisica,conectividad,informacinAdicional);
                this.tienda.getInventarioGeneral().add(dispositivo);


            }
        }catch (FileNotFoundException e) {
            System.err.println("El archivo no se encontro:"+e.getMessage());
        }catch(IOException ioe) {
            System.err.println("Error al procesar archivo: "+ioe.getMessage());
            ioe.printStackTrace();
        }

    }

}
