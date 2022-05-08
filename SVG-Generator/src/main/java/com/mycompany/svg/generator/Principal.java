/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.svg.generator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author gab_g
 */
public class Principal {    
    
    public static void main(String[] args) throws IOException {
        
    String[] dados = new String[100];
    
    File file = new File("readme.txt");
    Scanner scanner = new Scanner(file);
    int aux = 0;
    do{
    dados[aux] = scanner.nextLine();
    aux++;
    }while (scanner.hasNextLine());
    
    String gramatica = dados[0]; //linha 1: gramatica
    String palavra = dados[1]; //linha 2: palavra a ser aplicada regra  
    String regra = dados[2]; //linha 3: regra a ser aplicada
    
    String output = "";
    for (int i = 0; i < 12; i++) {
        output += gramatica.replaceAll(palavra, regra);
    }
    
    String svgFile = SVG.Html(output);
    
    File file2 = new File("SVGOutput.svg");        
    FileWriter fw = new FileWriter("SVGOutput.svg");
    fw.write(svgFile);
    fw.close();
    }
}
