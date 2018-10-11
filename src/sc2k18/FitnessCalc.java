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
public class FitnessCalc {
    static byte[] solusi = new byte[64];
    
    public static void setSolusi(byte[] newSolusi){
        solusi = newSolusi;
    }
    
    public static void setSolusi(String newSolusi){
        solusi = new byte[newSolusi.length()];
        //loop setiap karakter dari string dan disimpan pada byte new solusi
        for(int i = 0; i < newSolusi.length(); i++){
            String karakter = newSolusi.substring(i, i + 1);
            
            if(karakter.contains("0") || karakter.contains("1")){
                solusi[i] = Byte.parseByte(karakter);
            } else {
                solusi[i] = 0;
            }
        }
    }
    
    //kalkulasi individual fittness dengan membandingkan kepada kandidat solusi
    static int getFitness(Individu individu){
        int fitness = 0;
        
        for(int i = 0; i < individu.size() && i < solusi.length; i++){
            if(individu.getGene(i) == solusi[i]){
                fitness++;
            }
        }
        return fitness;
    }
    
    //get fitness optimal
    static int getMaxFitness(){
        int maxFitness = solusi.length;
        return maxFitness;
    }

    
    
}
