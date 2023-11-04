package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;
import java.util.Optional;



@ExtendWith(MockitoExtension.class)
 class ProduitServiceImplMock {
    @Mock
    ProduitRepository produitRepository;

    @InjectMocks
    ProduitServiceImpl produitService;

    @Test
    void testRetrieveProduit() {

        // Arrange
        Long produitId = 1L;
        Produit sampleProduit = new Produit();
        sampleProduit.setIdProduit(produitId);
        // Vous pouvez définir d'autres propriétés du produit ici.

        // Définissez le comportement attendu du mock ProduitRepository pour findById
        Mockito.when(produitRepository.findById(produitId)).thenReturn(Optional.of(sampleProduit));

        // Act
        Produit retrievedProduit = produitService.retrieveProduit(produitId);

        // Assert
        Assertions.assertNotNull(retrievedProduit);


    }


}
