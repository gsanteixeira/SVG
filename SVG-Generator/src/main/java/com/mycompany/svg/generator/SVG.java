/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.svg.generator;

import java.util.Random;

/**
 *
 * @author gab_g
 */
public class SVG {
    
    private static final int largura = 1000;
    private static final int altura = 1000;

    public static String Html(String output) {
        int xInicio = largura / 2;
        int yInicio = altura / 2;
        int xFinal = xInicio;
        int yFinal = yInicio;
        int espessura = 1;
        char direcao;
        int distancia = 5;
        
        String svgOutput = "<!DOCTYPE html>" + "\n";
        svgOutput += "<html>" + "\n";
        svgOutput += "<body>" + "\n";
        svgOutput += "<svg xmlns=\"http://www.w3.org/2000/svg\" height=\"" + altura + "\" width=\"" + largura + "\">" + "\n";
        
        direcao = 'N';
        for (Character c : output.toCharArray()) {
            if (c == '-' || c == '+') {
                direcao = ProximaDirecao(c, direcao);
            }          
            switch (direcao) {
                case 'N':
                    yFinal = yInicio + distancia;
                    break;
                case 'L':
                    xFinal = xInicio + distancia;
                    break;
                case 'S':
                    yFinal = yInicio - distancia;
                    break;
                case 'O':
                    xFinal = xInicio - distancia;
                    break;
            }            
            svgOutput += "<line x1 = \"" + xInicio + "\" y1 = \"" + yInicio + "\" x2 = \"" + xFinal + "\" y2 = \"" + yFinal + "\" style = \"stroke:rgb(" + 255 + "," + 0 + "," + 0 + ");stroke-width:" + espessura + "\" />\n";  
            xInicio = xFinal;
            yInicio = yFinal;
        }
        
        svgOutput += "</svg>";        
        svgOutput += "</body>" + "\n";
        svgOutput += "</html>" + "\n";
        
        return svgOutput;
    }

    private static Character ProximaDirecao(Character sinal, Character direcao) {
        char[] direcoes = {'N', 'S', 'L', 'O'};
        int posicao = 0;

        switch (direcao) {
            case 'N':
                posicao = 0;
                break;
            case 'L':
                posicao = 1;
                break;
            case 'S':
                posicao = 2;
                break;
            case 'O':
                posicao = 3;
                break;
        }

        int comparador = 0;

        if (sinal == '+') {
            comparador = 1;
        } else if (sinal == '-') {
            comparador = -1;
        }

        if (posicao + comparador > 3) {
            return 'N';
        }

        if (posicao + comparador < 0) {
            return 'O';
        }

        return direcoes[posicao + comparador];
    }
}
