/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import java.util.Random;

/**
 *
 * @author FaelT
 */
public class Perceptron {

    
    double[] pesos;
    double limite;
    
    //Funcao de treinamento
    
    public void treinar(double [][] entradas, int[]saidas, double limite, double itaxa, int epoch ){
        
        this.limite = limite;
        int n = entradas[0].length;
        int p = saidas.length;
        pesos = new double[n];
        Random r = new Random();
        
        
        //Inicializando pesos com valores aleatorios
        for(int i = 0; i<n; i++){
            pesos[i]=r.nextDouble();
        }
        
        for(int i = 0; i<epoch; i++){
            int erroTotal = 0;
            for(int j=0; j<p; j++){
                int saida = Saida(entradas[j]);
                int erro = saidas[j] - saida;
                erroTotal +=erro;
                
                for(int k = 0;k<n;k++){
                    double delta = itaxa * entradas[j][k] * erro;
                    pesos[k] +=delta;
                }
            }
            if(erroTotal ==0){
                break;
            }
        }
        
    }
    
   public int Saida(double[] entrada){
       double soma = 0.0;
       for(int i = 0; i<entrada.length; i++){
           soma = pesos[i] * entrada[i];
       }
       if(soma> limite ){
           return 1;
       }else{
           return 0;
       }
       
   }
    
}
