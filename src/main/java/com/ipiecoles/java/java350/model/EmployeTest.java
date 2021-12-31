package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;

public class EmployeTest {

    @Test
    public void testNbAnneeAncienneteNow(){
        //Given
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now());

        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(0);
    }

    @Test
    public void testNbAnneeAncienneteNowMinus2(){
        //Given
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now().minusYears(2));

        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(2);
    }

    @Test
    public void testNbAnneeAncienneteNowPlus3(){
        //Given
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now().plusYears(3));

        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(0);
    }

    @Test
    public void testNbAnneeAncienneteNull(){
        //Given
        Employe employe = new Employe();
        employe.setDateEmbauche(null);

        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(0);
    }
    @Test
    void test_Augmenter_Salaire() {
        double untaireٍsalaire = 0;
        double pourcentage = 5.0;
        //Given
        Employe employe = new Employe("Ngadi", "Elmahdi", "T123456", LocalDate.of(2018, Month.JANUARY, 8), 1200d, 1,1.4);
        employe.setSalaire(1200d);
        untaireٍsalaire = employe.getSalaire()  * (1 + (pourcentage/100));

        //When
        employe.augmenterSalaire(5.0);
        //Then
        Assertions.assertThat(employe.getSalaire()).isEqualTo(untaireٍsalaire);


    }
    @Test
    void augmenter_Salaire_Null() {
        double untaireٍsalaire = 0;
        double pourcentage = 5.0;
        //Given
        Employe employe = new Employe("Ngadi", "Elmahdi", "T123456", LocalDate.of(2018, Month.JANUARY, 8), 0d, 1,1.4);
        untaireٍsalaire = employe.getSalaire()  * (1 + (pourcentage/100));

        //When
        employe.augmenterSalaire(5.0);
        //Then
        Assertions.assertThat(employe.getSalaire()).isZero();
    }
    @Test
    void augmenter_Salaire_Pourcentage_Minus(){
        //given
        Employe employe = new Employe("ngadi", "Elmahdi", "T123456", LocalDate.of(2018, Month.JANUARY, 8), 1800d, 1,1.4);
        Double salaireSmic = 1500.0;
        //when
        employe.augmenterSalaire(-3d);

        //then
        Assertions.assertThat(employe.getSalaire()).isEqualTo(employe.getSalaire());
    }

}
