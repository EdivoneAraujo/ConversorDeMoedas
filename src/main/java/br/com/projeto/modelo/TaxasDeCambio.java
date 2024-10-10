package br.com.projeto.modelo;

public class TaxasDeCambio {
    private double eurRate;
    private double brlRate;
    private double gbpRate;
    private double jpyRate;
    private double audRate;
    private double cadRate;

    public TaxasDeCambio(double eurRate, double brlRate, double gbpRate, double jpyRate, double audRate, double cadRate) {
        this.eurRate = eurRate;
        this.brlRate = brlRate;
        this.gbpRate = gbpRate;
        this.jpyRate = jpyRate;
        this.audRate = audRate;
        this.cadRate = cadRate;
    }

    public double getEurRate() { return eurRate; }
    public double getBrlRate() { return brlRate; }
    public double getGbpRate() { return gbpRate; }
    public double getJpyRate() { return jpyRate; }
    public double getAudRate() { return audRate; }
    public double getCadRate() { return cadRate; }
}
