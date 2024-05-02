package src.br.com.conversorDeMoedas.model;

public class ConverterMoedas {
    private String base_code;
    private String target_code;
    private double conversion_rate;
    private double conversion_result;
    private double amount;

    public ConverterMoedas(String base_code, String target_code, double amount) {
        this.base_code = base_code;
        this.target_code = target_code;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    @Override
    public String toString() {
        return "ConverterMoedas{" +
                "base_code='" + base_code + '\'' +
                ", target_code='" + target_code + '\'' +
                ", conversion_rate=" + conversion_rate +
                ", conversion_result=" + conversion_result +
                '}';
    }

}
