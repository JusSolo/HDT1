public class Radio implements IRadio  {
    public Radio() {
        this.on = false;
        this.listaFM = new double[12];
        this.listaAM = new int[12];
        this.AM = false;
        this.frecuenciaFM = 87.9;
        this.frecuenciaAM = 530;

    }
    private boolean on;
    private int frecuenciaAM;
    private double frecuenciaFM;
    private int pasoAM = 10;
    private double pasoFM = 0.2;
    private double[] listaFM;
    private int[] listaAM;
    private boolean AM; //

    public void on() {
        on = true;
    }

    public void off() {
        on = false;
    }

    /***
     * Este metodo nos indica si la radio esta encendida o apagada
     * @return true si la radio esta encendida y false cuando la radio este apagada
     */
    public boolean isOn() {
        return on;
    }


   
    public void setFrequence(String freq) throws Exception {
        freq.toUpperCase();
        if (freq.startsWith("AM")) {
            try {


                int am = Integer.parseInt(freq.substring(2));
                if ( (am % 10 == 0) && (530 <= am) && (am <= 1610)){
                    frecuenciaAM = am;
                    this.AM = true;

                }



            }  catch (NumberFormatException nft) {
                System.out.println("ERROR. Verifique que el valor ingresado sea una frecuencia AM valida e intente de nuevo");
            }
        }
        else {
            try {

                double fm = Double.parseDouble(freq.substring(2));
                if (((fm*2+0.1) % 1 == 0) && (87.9 <= fm) && (fm <= 1610)){
                    this.frecuenciaFM = fm;
                    this.AM = false;

                }



            }  catch (NumberFormatException nft) {
                System.out.println("ERROR. Verifique que el valor ingresado sea una frecuencia FM valida e intente de nuevo");
            }
        }
    }
    public String getFrequence(){
        if (AM){
            return "AM" + frecuenciaAM;
        }
        else{
            return "FM" + frecuenciaFM;
        }
    }

    public void Forward(){
        if (AM){
            frecuenciaAM += pasoAM;
            if (frecuenciaAM > 1610){
                frecuenciaAM = 530;
            }
        }
        else{
            frecuenciaFM += pasoFM;
            if (frecuenciaFM > 107.9){
                frecuenciaFM = 87.9;
            }
        }

    }

    public void Backward(){
        if (AM){
            frecuenciaAM -= pasoAM;
            if (frecuenciaAM < 530 ){
                frecuenciaAM = 1610;
            }
        }
        else{
            frecuenciaFM -= pasoFM;
            if (frecuenciaFM < 87.9){
                frecuenciaFM = 107.9;
            }
        }
    }

    public double getFMActualStation(){
        return frecuenciaFM;
    }

    public int getAMActualStation(){
        return frecuenciaAM;
    }

    public void setFMActualStation(double actualStation){
        this.AM = false;
        this.frecuenciaFM = actualStation;
    }

    public void setAMActualStation(int actualStation){
        this.AM = true;
        this.frecuenciaAM = actualStation;
    }

    public void saveFMStation(double actualStation, int slot){

        this.listaFM[slot-1] = actualStation;
    }

    public void saveAMStation(int actualStation, int slot){

        this.listaAM[slot-1] = actualStation;
    }

    public double getFMSlot(int slot){

        return listaFM[slot-1];
    }

    public int getAMSlot(int slot){
        return listaAM[slot-1];
    }


}