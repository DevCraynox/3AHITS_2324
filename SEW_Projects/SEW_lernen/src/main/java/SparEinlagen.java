public class SparEinlagen extends Einlage {

    public SparEinlagen(float betrag) {
        this.betrag = betrag;
    }

    public float berechneZinsen(){
        return betrag*0.035f;
    }
    public static void main(String[] args) {
        SparEinlagen[] sparEinlagen = new SparEinlagen[12];

        int index = 0;
        for (float f=1500f; f >= 400f; f -= 100f){
            SparEinlagen se = new SparEinlagen(f);
            sparEinlagen[index] = se;
            index++;
        }

        float sum = 0f;
        for (SparEinlagen se:sparEinlagen) {
            sum += se.berechneZinsen();
            System.out.println("Betrag: " + se.getBetrag() + " | Zinsen: " + se.berechneZinsen());
        }
        System.out.println("Summe der Zinsen: " + sum);
    }
}