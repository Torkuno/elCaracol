public class elCaracol{
	public static void main(String[] args){
        
        double caracolNivel = (int) (-1) * ((Math.random() * (19 - 0)) + 1);
        double caracolImpulso = 0;
        var aguaNivel = -20;
        var climaStatus = "";
        var cocheStatus = "";

        for (int dia=1; dia<51; dia=dia+1) {

            //Avanze del caracol.
            int impulsoMaximo = 4; //Avanza 1-4
            if (dia < 10){ 
                impulsoMaximo = 3; //Avanza 1-3
            } else if (dia >= 10 && dia <20){
                impulsoMaximo = 2; //Avanza 1-2
            }
            caracolImpulso = Math.random() * (impulsoMaximo - 1) + 1;
            
            double caracolCaida = (-1) * (Math.random() * (2 - 0) + 1);

            double cocheRandom = Math.random(); //Probabilidad de coche.
            cocheStatus = "No";
            if (cocheRandom >= 0 && cocheRandom <= 0.35){
                cocheStatus = "Si";
                caracolCaida = caracolCaida - 2;
            }

            //Probabilidad de lluvia.
            double climaRandom = Math.random();
            climaStatus = "Despejado";
            if (climaRandom <= 0.05) {
                climaStatus = "Lluvia fuerte";
                aguaNivel = aguaNivel + 5;
            } else if (climaRandom > 0.05 && climaRandom <= 0.15) {
                climaStatus = "Lluvia ligera";
                aguaNivel = aguaNivel + 2;
            }

            var caracolAvanze = caracolImpulso + caracolCaida;
            caracolNivel = caracolNivel + caracolAvanze;

            if (aguaNivel > caracolNivel) {
                int caracolNivelInt = (int) caracolNivel;
                caracolNivel = aguaNivel + (1 + caracolNivel - caracolNivelInt);
            }

            //Status del dia.
            System.out.println("Dia [" + dia + "] / Clima [" + climaStatus + "] / Coche [" + cocheStatus + "]");
            System.out.println("Impulso [" + caracolImpulso + "] / Caida [" + caracolCaida + "] / Avanze [" + caracolAvanze + "]");
            System.out.println("Nivel del caracol [" + caracolNivel + "]");
            System.out.println("Nivel del agua: " + (20 + aguaNivel));
            System.out.println();
            
            //Dibujar el escenario.
            if (caracolNivel >= 1) {
                System.out.println("[__]    _@)_/`    [__]"); //Caracol
            } else if (cocheStatus == "Si") {
                System.out.println("[__]    O-=-O     [__]"); //Coche
            } else {
                System.out.println("[__]              [__]"); //Vacio
            }

            for (int nivel=0; nivel>(-21); nivel=nivel-1){
                if (nivel == (int) caracolNivel){
                    System.out.println("  []    _@)_/`    [] _ __ " + nivel); //Caracol
                } else if (nivel <= aguaNivel){
                    System.out.println("  []~~~~~~~~~~~~~~[] _ __ " + nivel); //Agua
                } else {
                    System.out.println("  []:. :. :. :. :.[] _ __ " + nivel); //Vacio
                }
            }
            System.out.println("  [][][][][][][][][]"); //Fondo
            
            if (caracolNivel >= 0){
                System.out.println();
                System.out.println("El caracol ha llegado a la superficie!");
                break;
            } else if (dia >= 50) {
                System.out.println();
                System.out.println("El caracol no ha logrado llegar a la superficie, y ha muerto.");
            } else {System.out.println();}
        }
    }
}