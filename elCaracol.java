import java.util.Random;

import org.w3c.dom.ranges.Range;

public class elCaracol{
	public static void main(String[] args){
        
        int cansansio = 1;
        var climaStatus = 0;

        for (int dia=1; dia<51; dia=dia+1) {

            double cocheRandom = Math.random(); //Probabilidad de coche.
            if (cocheRandom >= 0 && cocheRandom <= 0.35){
                var coche = 1;
            } else {
                var coche = 0;
            }

            double climaRandom = Math.random(); //Probabilidad de lluvia.
            if (climaRandom >= 0 && climaRandom <= 0.5) {
                var climaStatus = 2; //Lluvia fuerte
            } else if (climaRandom > 0.5 && climaRandom <= 0.15) {
                var climaStatus = 1; //Lluvia media
            } else {
                var climaStatus = 0; //Despejado
                System.out.println(climaStatus);
            }

            System.out.println("Dia [" + dia + "]");
        }
    }
}