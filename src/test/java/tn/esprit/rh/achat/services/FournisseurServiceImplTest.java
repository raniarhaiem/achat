package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FournisseurServiceImplTest {

    @Mock
    private FournisseurRepository fournisseurRepository;

    @Mock
    private DetailFournisseurRepository detailFournisseurRepository;

    @Mock
    private ProduitRepository produitRepository;

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void retrieveAllFournisseurs() {
        Fournisseur fournisseur = new Fournisseur();
        when(fournisseurRepository.findAll()).thenReturn(Arrays.asList(fournisseur));

        assertEquals(1, fournisseurService.retrieveAllFournisseurs().size());
        verify(fournisseurRepository, times(1)).findAll();
    }

    @Test
    void addFournisseur() {
        Fournisseur f = new Fournisseur();
        when(fournisseurRepository.save(any(Fournisseur.class))).thenReturn(f);

        Fournisseur created = fournisseurService.addFournisseur(f);
        assertNotNull(created.getDetailFournisseur()); // because we are setting a new DetailFournisseur in the implementation
        verify(fournisseurRepository, times(1)).save(any(Fournisseur.class));
    }

//    @Test
//    void updateFournisseur() {
//        Fournisseur f = new Fournisseur();
//        when(fournisseurRepository.save(any(Fournisseur.class))).thenReturn(f);
//        when(detailFournisseurRepository.save(any())).thenReturn(new DetailFournisseur());
//
//        Fournisseur updated = fournisseurService.updateFournisseur(f);
//        assertNotNull(updated.getDetailFournisseur());
//        verify(detailFournisseurRepository, times(1)).save(any());
//        verify(fournisseurRepository, times(1)).save(any(Fournisseur.class));
//    }

    @Test
    void deleteFournisseur() {
        Long id = 1L;
        fournisseurService.deleteFournisseur(id);
        verify(fournisseurRepository, times(1)).deleteById(id);
    }

    @Test
    void retrieveFournisseur() {
        Long id = 1L;
        Fournisseur f = new Fournisseur();
        when(fournisseurRepository.findById(id)).thenReturn(Optional.of(f));

        Fournisseur retrieved = fournisseurService.retrieveFournisseur(id);
        assertNotNull(retrieved);
        verify(fournisseurRepository, times(1)).findById(id);
    }
}