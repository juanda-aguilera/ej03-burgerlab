public class Main {
    public static void main(String[] args) {
        System.out.println("=== BurgerLab: pedidos del dia ===");

        // Pedido 1: doble carne de res, CON tocineta, SIN queso, salsa BBQ
        Hamburguesa h1 = new Hamburguesa.Builder("res", 2)
                .conTocineta()
                .conSalsa("bbq")
                .build();

        // Pedido 2: pollo sencillo, solo pepinillos, sin salsa
        Hamburguesa h2 = new Hamburguesa.Builder("pollo", 1)
                .conPepinillos()
                .build();

        // Pedido 3: veggie triple con TODO
        Hamburguesa h3 = new Hamburguesa.Builder("veggie", 3)
                .conPan("integral")
                .conQueso()
                .conTocineta()
                .conCebollaCaramelizada()
                .conPepinillos()
                .conSalsa("de la casa")
                .conPapasAgrandadas()
                .build();

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);

        // Pedido 4: un error de digitacion que ahora SI se detecta
        try {
            Hamburguesa h4 = new Hamburguesa.Builder("res", 7)
                    .conSalsa("miel mostaza")
                    .build();
            System.out.println(h4);
        } catch (IllegalArgumentException e) {
            System.out.println("Pedido 4 RECHAZADO: " + e.getMessage());
        }

        System.out.println();
        System.out.println("ESPERADO -> pedido 1 con tocineta y sin queso, pan por defecto 'brioche',");
        System.out.println("            salsa por defecto 'ninguna' y el pedido 4 debe ser RECHAZADO (max 3 porciones)");
    }
}
