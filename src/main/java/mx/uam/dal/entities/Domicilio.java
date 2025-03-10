package mx.uam.dal.entities;

public class Domicilio {
    private String calle;
    private String colonia;
    private String ciudad;
    private String pais;
    
    public Domicilio(){
        
    }

    public Domicilio(String calle, String ciudad, String colonia, String pais) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.pais = pais;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


}
