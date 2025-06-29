package maquina;

public class MaquinaDeCafe {
    private Cafetera cafetera;
    private Vaso vasosPequenos;
    private Vaso vasosMedianos;
    private Vaso vasosGrandes;
    private Azucarero azucarero;

    public void setCafetera(Cafetera cafetera) {
        this.cafetera = cafetera;
    }

    public void setVasosPequeno(Vaso vaso) {
        this.vasosPequenos = vaso;
    }

    public void setVasosMediano(Vaso vaso) {
        this.vasosMedianos = vaso;
    }

    public void setVasosGrande(Vaso vaso) {
        this.vasosGrandes = vaso;
    }

    public void setAzucarero(Azucarero azucarero) {
        this.azucarero = azucarero;
    }

    public Cafetera getCafetera() {
        return cafetera;
    }

    public Vaso getVasosPequeno() {
        return vasosPequenos;
    }

    public Vaso getVasosMediano() {
        return vasosMedianos;
    }

    public Vaso getVasosGrande() {
        return vasosGrandes;
    }

    public Azucarero getAzucarero() {
        return azucarero;
    }

    public Vaso getTipoVaso(String tipo) {
        switch (tipo.toLowerCase()) {
            case "pequeno": return vasosPequenos;
            case "mediano": return vasosMedianos;
            case "grande": return vasosGrandes;
            default: return null;
        }
    }

    public String getVasoDeCafe(Vaso vaso, int cantidad, int cantidadAzucar) {
        if (!vaso.hasVasos(cantidad)) return "No hay Vasos";
        if (!cafetera.hasCafe(vaso.getContenido() * cantidad)) return "No hay Cafe";
        if (!azucarero.hasAzucar(cantidadAzucar * cantidad)) return "No hay Azucar";

        vaso.giveVasos(cantidad);
        cafetera.giveCafe(vaso.getContenido() * cantidad);
        azucarero.giveAzucar(cantidadAzucar * cantidad);

        return "Felicitaciones";
    }
}
