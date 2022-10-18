package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvio;

    @BeforeEach
    void setUp() {
        xuxa = new Cliente("xuxa", "56445634356", "413456786");
        silvioSantos = new Cliente("Silvio Santos", "44433366677", "332245679");

        contaXuxa = new Conta("0025", "2254", 2500.00, xuxa);
        contaSilvio = new Conta("0099", "2276", 3500.00, silvioSantos);
    }

    @Test
    public void realizarTransacao(){
        contaXuxa.realizarTransferencia(1000, contaSilvio);
        assertEquals(1500.00, contaXuxa.getSaldo());
        assertEquals(4500.00, contaSilvio.getSaldo());
        
    }

    @Test
    public void validarTransferenciaInvalida(){
        boolean resultado = contaXuxa.realizarTransferencia(2501.00, contaSilvio);
        assertFalse(resultado);

    }

}