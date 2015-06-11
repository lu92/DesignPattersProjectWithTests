package DesignPatternsProject.entities.personalData;


import java.util.IllegalFormatException;

/**
 * Created by lucjan on 10.03.15.
 */

public class Salary {

    private Long id;

    private EmploymentContractType type;
    private static final double MINIMUM_BRUTTO_SALARY = 2200;

    private double netto;
    private double brutto;
    private double insurancePrice;  // cena ubezpieczenia

    public Salary() {
    }

    public Salary(EmploymentContractType type, double brutto) throws IllegalArgumentException{

        if (type == null || brutto < MINIMUM_BRUTTO_SALARY )
            throw new IllegalArgumentException("Invalid parameters");
        else {
            this.type = type;
            this.brutto = brutto;
            if (type == EmploymentContractType.REGULAR_EMPLOYMENT) {
                this.insurancePrice = 30 * brutto / 100;
                this.netto = brutto - insurancePrice;
            }

            if (type == EmploymentContractType.FIXED_TERM_EMPLOYMENT) {
                this.insurancePrice = 10 * brutto / 100;
                this.netto = brutto - insurancePrice;
            }
        }
    }

    //      Constructors only for tests

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmploymentContractType getType() {
        return type;
    }

    public void setType(EmploymentContractType type) {
        this.type = type;
    }

    public double getNetto() {
        return netto;
    }

    public void setNetto(double netto) {
        this.netto = netto;
    }

    public double getBrutto() {
        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", type=" + type +
                ", netto=" + netto +
                ", brutto=" + brutto +
                ", insurancePrice=" + insurancePrice +
                '}';
    }
}
