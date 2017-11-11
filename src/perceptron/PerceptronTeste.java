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
import javax.swing.JOptionPane;

/**
 *
 * @author FaelT
 */
public class PerceptronTeste {
   static double [][] entradas;
   static int [] saidas;
  
   public static double [] lerArquivo(String nome) throws FileNotFoundException, IOException{
      BufferedReader br = new BufferedReader(new FileReader(nome));
      double [] resposta = new double[200]; 
      if(br.ready()){
         String linha = br.readLine();
         resposta = new double[linha.length()];
         String [] valores = linha.split(" ");
         for(int i = 0; i<linha.length(); i++){
            resposta[i] = Double.parseDouble(valores[i]);
         }      
         return resposta;
      }
      br.close();
      return resposta;
   }
   
   public static Perceptron treinandoAND(){
      Perceptron p = new Perceptron();
      double entradas[][]={{0,0},{0,1},{1,0},{1,1}};
      int saidas[] = {0,0,0,1};
      p.treinar(entradas, saidas, 0.2, 0.1, 200);
      return p;
   }
   
   public static Perceptron treinandoOR(){
      Perceptron p = new Perceptron();
      double entradas[][]={{0,0},{0,1},{1,0},{1,1}};
      int saidas[] = {1,1,1,0};
      p.treinar(entradas, saidas, 0.2, 0.1, 200);
      return p;
   }
   
   public static Perceptron treinandoXOR(){
      Perceptron p = new Perceptron();
      double entradas[][]={{0,0},{0,1},{1,0},{1,1}};
      int saidas[] = {0,1,1,0};
      p.treinar(entradas, saidas, 0.2, 0.1, 200);
      return p;
   }
   public static void main(String [] args) throws IOException{
      Perceptron pAnd = treinandoAND();
      Perceptron pOr = treinandoOR();
      Perceptron pXor = treinandoXOR();
      
      
      
      
      Scanner in = new Scanner(System.in);
      String linha;
      
      
       //System.out.println("Informe o nome do arquivo desejado ou digite 0 para sair");
       //linha = JOptionPane.showInputDialog(null,"Entre com o nome do arquivo");
       //linha = in.next();
       //while(!linha.equals("0")){
       // double [] entrada = lerArquivo(linha);
       double [] entrada = {0,1,0};
       System.out.println("Resultado AND");
       System.out.println(pAnd.Saida(entrada));
       System.out.println("Resultado OR");
       System.out.println(pOr.Saida(entrada));
       System.out.println("Resultado XOR");
       System.out.println(pXor.Saida(entrada));
       System.out.println("Digite o nome do proximo arquivo: ");
       //}
   }
   
}
