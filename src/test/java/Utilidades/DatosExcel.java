package Utilidades;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;


public class DatosExcel {
    // para que funcione Apache, debo copiar todo lo que sigue (lo sacamos de la clase teorica 4 filmina 9) 
	public static Object[][] leerExcel(String ruta,String nombreHoja) throws Exception {
		FileInputStream file = new FileInputStream(new File(ruta));
		XSSFWorkbook libroExcel= new XSSFWorkbook(file);
		XSSFSheet Hoja=libroExcel.getSheet(nombreHoja);
		
		System.out.println(nombreHoja);
		
		XSSFRow fila;
		int filas = Hoja.getPhysicalNumberOfRows();
		int columnas= Hoja.getRow(0).getPhysicalNumberOfCells();
		Object cellValue[][]=new Object[filas-1][columnas];
		
		
		// Saber! esto esta configurado para leer desde la celda excel A1 (for int r=1 // int c=0). Si el excel tiene por ej titulos, 
		// hay que configurar esto segun desde donde empieza, y arriba en Public Static.. leer excel habria que config un tercer parametro que diga desde donde (que celda) voy a leer el excel.
		for (int r = 1; r < filas; r++) {
		fila = Hoja.getRow(r);
		  if (fila == null){ break; }
		  else{ 
			  for (int c = 0; c < columnas; c++) 
			  {cellValue[r-1][c]=Hoja.getRow(r).getCell(c).getStringCellValue();
			  } 
		  }
		}
		return cellValue; 
		} 
	
	
}
