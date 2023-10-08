package objects;

public class ComputerEngine {
    private String instances;
    private String amount;
    private String seriousValue;
    private String machineStandard;
    private String cardModel;
    private String gpuAmount;
    private String ssdAmount;
    private String address;
    private String yearsAmount;

    public ComputerEngine(String instances,String amount, String seriousValue, String machineStandard, String cardModel,
                          String gpuAmount, String ssdAmount, String address, String yearsAmount){
        this.instances = instances;
        this.amount = amount;
        this.seriousValue = seriousValue;
        this.machineStandard = machineStandard;
        this.cardModel = cardModel;
        this.gpuAmount = gpuAmount;
        this.ssdAmount = ssdAmount;
        this.address = address;
        this.yearsAmount = yearsAmount;
    }

    public String getInstances(){
        return instances;
    }
    public String getAmount(){
        return amount;
    }
    public String getSeriousValue(){
        return seriousValue;
    }
    public String getGpuAmount(){return gpuAmount;}
    public String getMachineStandard(){
        return machineStandard;
    }
    public String getCardModel(){
        return cardModel;
    }
    public String getSsdAmount(){
        return ssdAmount;
    }
    public String getAddress(){return address;}
    public String getYearsAmount(){
        return yearsAmount;
    }
}
