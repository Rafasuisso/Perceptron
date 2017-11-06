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
        static double entradasArquivo[][] = new double[100][100];
        static int saidasArquivo[] = new int[20];
        static double [][] entradas;
        static int [] saidas;
        static int contador = 0;
        static int variaveis = 0;
    public static void lerArquivo(String nome) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\e.rafael.medeiros\\Documentos\\NetBeansProjects\\Perceptron\\src\\perceptron/"+nome));
        contador = 0;
        while(br.ready()){
            String linha = br.readLine();
            
            contador ++;
            String [] valores = linha.split(" ");
            variaveis = valores.length-1;
            for(int i = 0; i<=variaveis; i++){
                entradasArquivo[contador][i] = Double.parseDouble(valores[i]);
            }
            saidasArquivo[contador] = Integer.parseInt(valores[valores.length]);
            System.out.println(linha);
        }
        br.close();
    }
    
    public static void main(String [] args) throws IOException{
        Perceptron p = new Perceptron();
        //double entradas[][]={{0,0},{0,1},{1,0},{1,1}};
        //int saidas[] = {1,1,1,0};
       // double entradas[][];
        //int saidas[];
       
        
        
        
        
        Scanner in = new Scanner(System.in);
        String linha;
        System.out.println("Informe o nome do arquivo desejado");
        linha = in.next();
        
        lerArquivo(linha);
         for(int i = 0; i<variaveis; i++){
             for(int j=0; j<variaveis; j++){
                 entradas[i][j] = entradasArquivo[i][j];
             }
        }
         for(int i=0; i<contador; i++){
             saidas[i] = saidasArquivo[i];
         }
        
         for(int i = 0; i<variaveis; i++){
             for(int j=0; j<variaveis; j++){
                 System.out.print(entradas[i][j]);
                 
             }
             System.out.println("");
        }
         for(int i=0; i<contador; i++){
             System.out.print(saidas[i]);
         }
         
       // p.treinar(entradas, saidas, 0.2, 0.1, 200);
        //System.out.println(p.Saida(new double[]{0,0}));
        //System.out.println(p.Saida(new double[]{1,0}));
        //System.out.println(p.Saida(new double[]{0,1}));
        //System.out.println(p.Saida(new double[]{1,1}));
    }
    
}
