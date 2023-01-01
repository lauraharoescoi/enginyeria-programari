package citizenmanagementplataformtest;

import data.Nif;
import data.Password;
import data.exceptions.*;
import dummies.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.Citizen;
import citizenmanagementplataform.*;
import exceptions.*;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnifiedPlatformTest {

    Citizen citizen;
    UnifiedPlatform platform;

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    // Per a poder comprovar el contingut de la sortida estandard
    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        outContent.reset();
    }

    @BeforeEach
    public void setUp() {
        citizen = new Citizen();
        citizen.setName("Lorena");
        citizen.setNif(new Nif("12345678A"));
        citizen.setPhoneNumber("123456789");
        citizen.setAddress("Calle falsa 123");

        platform = new UnifiedPlatform();
        platform.injectAuthenticationMethod(new CertificationAuthorityDumm(citizen));
    }


    @Test
    public void selectJustMinTest() throws ProceduralException {
        String expectedResult = "Es fa click en la secció Ministeri de Justicia del mosaïc inicial";
        platform.selectJusMin();
        assertEquals(expectedResult.strip(), outContent.toString().strip());
    }

    @Test
    public void selectProceduresSequence() throws ProceduralException {
        String expectedResult = "Es fa click en l'enllaç Tràmits dins la secció del Ministeri de Justicia";
        platform.selectJusMin();
        outContent.reset();
        platform.selectProcedures();
        assertEquals(expectedResult.strip(), outContent.toString().strip());
    }

    @Test
    public void selectCriminalReportCertfSequence() throws ProceduralException {
        String expectedResult = "Es selecciona el tramit per a obtindre el certificat d'antecedents penals";
        platform.selectJusMin();
        platform.selectProcedures();
        outContent.reset();
        platform.selectCriminalReportCertf();
        assertEquals(expectedResult.strip(), outContent.toString().strip());
    }

    @Test
    public void selectExistentAuthMethodTestSequence() throws ProceduralException {
        byte method = 3;
        String expectedResult = "Es selecciona el mètode d'autenticació Cl@ve Pin";
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        outContent.reset();
        platform.selectAuthMethod(method);
        assertEquals(expectedResult.strip(), outContent.toString().strip());
    }

    @Test
    public void selectProceduresWithStepsMissing() {
        Throwable exception = assertThrows(ProceduralException.class, platform::selectProcedures);
        assertEquals("Preconditions not accomplished",exception.getMessage());
    }

    @Test
    public void selectCriminalReportCertfWithStepsMissing() {
        Throwable exception = assertThrows(ProceduralException.class, platform::selectCriminalReportCertf);
        assertEquals("Preconditions not accomplished",exception.getMessage());
    }

    @Test
    public void selectExistentAuthMethodWithStepsMissing() {
        byte method = 3;
        Throwable exception = assertThrows(ProceduralException.class, () -> {platform.selectAuthMethod(method);});
        assertEquals("Preconditions not accomplished",exception.getMessage());
    }

}
