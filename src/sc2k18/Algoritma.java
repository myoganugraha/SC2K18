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
public class Algoritma {
    //GA Parameter
    private static final double uniformRate = 0.5;
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;
    
    public static Populasi evolvePopulasi(Populasi populasi){
        Populasi newPopulasi = new Populasi(populasi.individu.length, false);
        
        if(elitism){
            newPopulasi.simpanIndividu(0, populasi.getFittest());
        }
        
        //crossover populasi
        int elitismOffset;
        if(elitism){
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }
        
        for(int i = elitismOffset; i < populasi.size(); i++){
            Individu individu1 = seleksiTurnamen(populasi);
            Individu individu2 = seleksiTurnamen(populasi);
            Individu newIndividu = crossoverIndividu(individu1, individu2);
            newPopulasi.simpanIndividu(i, newIndividu);
        }
        
        for(int i = elitismOffset; i < newPopulasi.size(); i++){
            mutate(newPopulasi.getIndividu(i));
        }
        return newPopulasi;
    }

    private static void mutate(Individu individu) {
        for(int i = 0; i < individu.size(); i++){
            if(Math.random() <= mutationRate){
                byte gene = (byte) Math.round(Math.random());
                individu.setGene(i, gene);
            }
        }
    }
    
    //crossover individu
    private static Individu crossoverIndividu(Individu individu1, Individu individu2){
        Individu newIndividu = new Individu();
        
        for(int i = 0; i < individu1.size(); i++){
            //crossover
            if(Math.random() <= uniformRate){
                newIndividu.setGene(i, individu1.getGene(i));
            } else {
                newIndividu.setGene(i, individu2.getGene(i));
            }
        }
        return newIndividu;
    }
    
    // select individu untuk crossover
    private static Individu seleksiTurnamen(Populasi populasi){
        Populasi populasiTurnamen = new Populasi(tournamentSize, false);
        
        //untuk setiap tempat didalam turnament mendapatkan sebuah random individu
        for(int i = 0; i < tournamentSize; i++){
            int randomId = (int)(Math.random() * populasi.individu.length);
            populasiTurnamen.simpanIndividu(i, populasi.getIndividu(randomId));
        }
        Individu fittest = populasiTurnamen.getFittest();
        return fittest;
    }
}
