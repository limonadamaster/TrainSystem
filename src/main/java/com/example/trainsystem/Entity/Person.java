package com.example.trainsystem.Entity;

import com.example.trainsystem.enums.DiscoundTariff;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person",indexes={@Index(name="identificationNumberIndex",columnList = "identificationNumber")})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String firstName;
    private String secondName;
    private String thirdName;

    @Column(unique = true)
    private String identificationNumber;//Egn

    @Transient
    private DiscoundTariff discoundTariff;

    @OneToOne(fetch = FetchType.LAZY)//only when access this field
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnore
    private DiscoundCard discoundCard;

    public Person(String firstName,
    String secondName,
    String thirdName,
    String identificationNumber,
                  DiscoundTariff discoundTariff){
        this.firstName=firstName;
        this.secondName=secondName;
        this.thirdName=thirdName;
        this.identificationNumber=identificationNumber;
        this.discoundTariff=discoundTariff;
    }

    public double calculateDisocountTariff(DiscoundTariff discoundTariff){
        if(discoundTariff.name()=="STUDENT") return 0.5;
        if(discoundTariff.name()=="CHILDER") return 1;
        if(discoundTariff.name()=="PENSIONER") return 0.5;
        if(discoundTariff.name()=="GOVERMENT_EMPLOYEE") return 0.8;
        return 0.0;
    }

    public void setDiscoundTariff(int discoundTariff) {
        this.discoundTariff = DiscoundTariff.values()[discoundTariff];
    }

}
