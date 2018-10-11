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
public class Individu {
    static int panjangGeneDefault = 64;
    private byte[] genes = new byte[panjangGeneDefault];
    
    //cache
    private int fitness = 0;
    
    //random individual
    public void generateIndividu(){
        for(int i = 0; i< size(); i++){
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene; 
        }
    }
    
    //getter
    public byte getGene(int index){
        return genes[index];
    }
    
    //setter
    public void setGene(int index, byte value){
        genes[index] = value;
        fitness = 0;
    }
    
    //method size();
    public int size(){
        return genes.length;
    }
    
    public int getFitness(){
        if(fitness == 0){
            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
    }
    
    @Override
    public String toString(){
        String geneString = "";
        for(int i = 0; i < genes.length; i++){
            geneString += getGene(i);
        }
        return geneString;
    }

    
    
}
