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
public class Populasi {
    Individu[] individu;

    public Populasi(int populasiSize, boolean initialize) {
        individu = new Individu[populasiSize];
        //init populasi
        if(initialize){
            for(int i = 0; i < size(); i++){
                Individu newIndividu = new Individu();
                newIndividu.generateIndividu();
                simpanIndividu(i, newIndividu);
            }
        }
    }

    public void simpanIndividu(int i, Individu newIndividu) {
      individu[i] = newIndividu;
    }
    
    // getter
    public Individu getIndividu(int i){
        return individu[i];
    }
    
    public Individu getFittest(){
        Individu fittest = individu[0];
        
        //loop individu untuk mendapatkan fittest
        for(int i = 0; i < individu.length; i ++){
            if(fittest.getFitness() <= getIndividu(i).getFitness()){
                fittest = getIndividu(i);
            }
        }
        return fittest;
    }

    public int size() {
        return individu.length;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
