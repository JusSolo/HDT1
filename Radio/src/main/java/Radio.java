public class Radio implements IRadio  {
    private boolean on;
    private double frecuenciaFM;
    private int frecuenciaAM
    private int pasoAM;
    private double pasoFM;
    private double[] listaFM;
    private int[] listaAM;

    private boolean AM; //

    public void on() {on==true}

    public void off() {off==false}

    /***
     * Este metodo nos indica si la radio esta encendida o apagada
     * @return true si la radio esta encendida y false cuando la radio este apagada
     */
    public boolean isOn() {
    	System.in.println("La radio está encendida");
    }


    public void setFrequence(String freq) throws Exception{
    	freq.toUpperCase();
    	if (freqstartsWith("AM")){
    		try {
    			int am = Integer.parseInt(freq.substring(2));
    			
    	
    		} catch
    	}
    	String frecuencia = 
    }

    public String getFrequence();

    public void Forward();

    public void Backward();

    public double getFMActualStation();

    public int getAMActualStation();

    public void setFMActualStation(double actualStation);

    public void setAMActualStation(int actualStation);

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
        return listaAM[slot-1;
    }

}