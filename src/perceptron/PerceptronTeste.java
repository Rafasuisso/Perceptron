/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author FaelT
 */
public class PerceptronTeste {
        static double entradas[][] = new double[20][20];
        static int saidas[] = new int[20];
    public static void lerArquivo(String nome) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\FaelT\\Google Drive\\PUC\\2017 -2\\Inteligência Artificial\\Trabalho Perceptron"+nome));
        int contador = 0;
        while(br.ready()){
            String linha = br.readLine();
            contador ++;
            String [] valores = linha.split(" ");
            for(int i = 0; i<valores.length -1; i++){
                entradas[contador][i] = Double.parseDouble(valores[i]);
            }
            saidas[contador] = Integer.parseInt(valores[valores.length]);
            System.out.println(linha);
        }
        br.close();
    }
    
    public static void main(String [] args){
        Perceptron p = new Perceptron();
        //double entradas[][]={{0,0},{0,1},{1,0},{1,1}};
        //int saidas[] = {1,1,1,0};
       // double entradas[][];
        //int saidas[];
        Scanner in = new Scanner(System.in);
        String linha;
        System.out.println("Informe o nome do arquivo desejado");
        linha = in.next();
        
        p.treinar(entradas, saidas, 0.2, 0.1, 200);
        System.out.println(p.Saida(new double[]{0,0}));
        System.out.println(p.Saida(new double[]{1,0}));
        System.out.println(p.Saida(new double[]{0,1}));
        System.out.println(p.Saida(new double[]{1,1}));
    }
    
}
