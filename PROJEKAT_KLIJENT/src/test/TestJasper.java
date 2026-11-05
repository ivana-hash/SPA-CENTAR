/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author HomePC
 */
public class TestJasper {
    public static void main(String[] args) {
        try {
            Class.forName("net.sf.jasperreports.engine.JasperFillManager");
            Class.forName("net.sf.jasperreports.pdf.JRPdfExporter");
            Class.forName("org.apache.commons.collections4.ArrayStack");
            Class.forName("com.fasterxml.jackson.dataformat.xml.XmlMapper");
            System.out.println("Sve biblioteke su OK, JasperReports je spreman za rad.");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    
    }
}
