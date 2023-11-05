package tn.esprit.rh.achat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StockServiceImplMock {

    @Mock
    StockRepository stockRepository;

    @InjectMocks
    StockServiceImpl stockService;

    @Test
    void testRetrieveStock() {
        // Define a sample stock and a sample ID
        Long stockId = 1L;
        Stock sampleStock = new Stock();
        sampleStock.setId(stockId);
        // Mock the behavior of the stockRepository
        Mockito.when(stockRepository.findById(stockId)).thenReturn(Optional.of(sampleStock));

        // Call the method you want to test
        Stock retrievedStock = stockService.retrieveStock(stockId);

        // Perform assertions to verify the result
        Assertions.assertNotNull(retrievedStock);
        Assertions.assertEquals(stockId, retrievedStock.getId());
    }
}
