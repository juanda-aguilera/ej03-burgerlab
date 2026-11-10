public class Hamburguesa {

    private final String proteina;          // obligatorio: res, pollo, veggie
    private final int porciones;            // obligatorio: 1 a 3
    private final String pan;               // opcional (por defecto: brioche)
    private final boolean queso;
    private final boolean tocineta;
    private final boolean cebollaCaramelizada;
    private final boolean pepinillos;
    private final String salsa;             // opcional (por defecto: ninguna)
    private final boolean papasAgrandadas;

    private Hamburguesa(Builder b) {
        this.proteina = b.proteina;
        this.porciones = b.porciones;
        this.pan = b.pan;
        this.queso = b.queso;
        this.tocineta = b.tocineta;
        this.cebollaCaramelizada = b.cebollaCaramelizada;
        this.pepinillos = b.pepinillos;
        this.salsa = b.salsa;
        this.papasAgrandadas = b.papasAgrandadas;
    }

    public static class Builder {
        // obligatorios
        private final String proteina;
        private final int porciones;
        // opcionales con valor por defecto
        private String pan = "brioche";
        private String salsa = "ninguna";
        private boolean queso;
        private boolean tocineta;
        private boolean cebollaCaramelizada;
        private boolean pepinillos;
        private boolean papasAgrandadas;

        public Builder(String proteina, int porciones) {
            this.proteina = proteina;
            this.porciones = porciones;
        }

        public Builder conPan(String pan)             { this.pan = pan; return this; }
        public Builder conSalsa(String salsa)         { this.salsa = salsa; return this; }
        public Builder conQueso()                     { this.queso = true; return this; }
        public Builder conTocineta()                  { this.tocineta = true; return this; }
        public Builder conCebollaCaramelizada()       { this.cebollaCaramelizada = true; return this; }
        public Builder conPepinillos()                { this.pepinillos = true; return this; }
        public Builder conPapasAgrandadas()           { this.papasAgrandadas = true; return this; }

        public Hamburguesa build() {
            if (proteina == null || proteina.isBlank()) {
                throw new IllegalArgumentException("La proteina es obligatoria");
            }
            if (porciones < 1 || porciones > 3) {
                throw new IllegalArgumentException(
                    "Porciones invalidas: " + porciones + " (permitido de 1 a 3)");
            }
            return new Hamburguesa(this);
        }
    }

    @Override
    public String toString() {
        return "Hamburguesa de " + proteina + " x" + porciones
             + " | pan: " + pan
             + (queso ? " | queso" : "")
             + (tocineta ? " | tocineta" : "")
             + (cebollaCaramelizada ? " | cebolla caramelizada" : "")
             + (pepinillos ? " | pepinillos" : "")
             + " | salsa: " + salsa
             + (papasAgrandadas ? " | papas agrandadas" : "");
    }
}
