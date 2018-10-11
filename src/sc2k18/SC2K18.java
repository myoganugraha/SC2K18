/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sc2k18;

/**
 *
 * @author myoganugraha
 */
public class SC2K18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       FitnessCalc.setSolusi("1111000000000000000000000000000000000000000000000000000000001111");
       
       Populasi populasi = new Populasi(50, true);
       
       int hitungGenerasi = 0;
       while(populasi.getFittest().getFitness() < FitnessCalc.getMaxFitness()){
           hitungGenerasi++;
           System.out.println("Generasi: " + hitungGenerasi + " Fittest: " + populasi.getFittest().getFitness());
           populasi = Algoritma.evolvePopulasi(populasi);
       }
       System.out.println("Solution found!");
       System.out.println("Generasi: " + hitungGenerasi);
       System.out.println("Genes:");
       System.out.println(populasi.getFittest());
    }
    
}
