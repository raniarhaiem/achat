package tn.esprit.rh.achat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;

import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FactureServiceImplTest  {

    @Mock
    FactureRepository factureRepository;
    @InjectMocks
    FactureServiceImpl factureService;

    @Test
    void testRetrieveFactureById() {
        // Arrange
        Long factureId = 1L;
        Facture sampleFacture = new Facture();
        sampleFacture.setIdFacture(factureId);

        Mockito.when(factureRepository.findById(factureId)).thenReturn(Optional.of(sampleFacture));

        // Act
        Facture retrievedFacture = factureService.retrieveFacture(factureId);

        // Assert
        Assertions.assertNotNull(retrievedFacture);

    }

}