public class Radio implements IRadio  {
    public Radio(boolean on) {
        this.on = false;
        this.frecuenciaFM;
        this.frecuenciaAM;
    }

    private boolean on;
    private int pasoAM = 10;
    private double pasoFM = 0.2;
    private double[] listaFM;
    private int[] listaAM;

    private boolean AM; //

    public void on() {
        on==true
    }

    public void off() {
        off==false
    }

    /***
     * Este metodo nos indica si la radio esta encendida o apagada
     * @return true si la radio esta encendida y false cuando la radio este apagada
     */
    public boolean isOn() {
        System.in.println("La radio está encendida");
    }


   
    public void setFrequence(String freq) throws Exception {
        freq.toUpperCase();
        if (freqstartsWith("AM")) {
            try {
                int am = Integer.parseInt(freq.substring(2));


            } catch
        }
    }
    public String getFrequence(){
        if (AM){
            return frecuenciaAM;
        }
        else{
            return frecuenciaFM;
        }
    }

    public void Forward(){
        if (AM){
            frecuenciaAM += pasoAM;
        }
        else{
            frecuenciaFM += pasoFM;
        }

    }

    public void Backward(){
        if (AM){
            frecuenciaAM += - pasoAM;
        }
        else{
            frecuenciaFM += - pasoFM;
        }
    }

    public double getFMActualStation(){
        return frecuenciaFM;
    }

    public int getAMActualStation();{
        return frecuenciaAM;
    }

    public void setFMActualStation(double actualStation){
        this.frecuenciaFM = actualStation;
    }

    public void setAMActualStation(int actualStation){
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