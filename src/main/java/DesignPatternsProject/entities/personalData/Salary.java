package DesignPatternsProject.entities.personalData;


import DesignPatternsProject.entities.actors.Person;
import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.Transient;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**
 * Created by lucjan on 10.03.15.
 */
@NodeEntity
public class Salary {

    @GraphId
    private Long id;
    private EmploymentContractType type;

    @Transient
    private static final double MINIMUM_BRUTTO_SALARY = 2200;

    private double netto;
    private double brutto;
    private double insurancePrice;  // cena ubezpieczenia


    @Fetch
    @RelatedTo(type = "PERSON_SALARY", direction = Direction.BOTH)
    private Person person;

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
